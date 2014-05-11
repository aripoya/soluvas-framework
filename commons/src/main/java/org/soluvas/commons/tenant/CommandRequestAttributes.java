package org.soluvas.commons.tenant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.felix.gogo.runtime.CommandProcessorImpl;
import org.apache.felix.gogo.runtime.CommandSessionImpl;
import org.apache.felix.gogo.runtime.threadio.ThreadIOImpl;
import org.apache.felix.service.command.CommandSession;
import org.apache.felix.service.threadio.ThreadIO;
import org.slf4j.MDC;
import org.soluvas.commons.config.MultiTenantWebConfig;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.context.request.AbstractRequestAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.google.common.base.Preconditions;

/**
 * The {@link RequestAttributes} implementation used by {@link RequestOrCommandScope} Spring {@link Scope}.
 * @author ceefour
 * @see MultiTenantWebConfig#tenantRef()
 * @see RequestOrCommandScope
 * @see ExtCommandSupport
 */
public class CommandRequestAttributes extends AbstractRequestAttributes {

	/**
	 * MDC key for {@value #MDC_TENANT_ID}.
	 * Used by {@link org.soluvas.commons.config.MultiTenantWebConfig#tenantRef()}.
	 */
	public static final String MDC_TENANT_ID = "tenantId";
	protected static final ThreadLocal<CommandRequestAttributes> threadRequestAttributes = new NamedThreadLocal<>("Command RequestAttributes");
	
	protected static class SimpleCommandProcessor extends CommandProcessorImpl {

		public SimpleCommandProcessor(ThreadIO tio) {
			super(tio);
		}
		
	}
	
	protected static class SimpleCommandSession extends CommandSessionImpl {

		protected SimpleCommandSession(CommandProcessorImpl shell,
				InputStream in, PrintStream out, PrintStream err) {
			super(shell, in, out, err);
		}
		
	}

	/**
	 * Stores the {@link RequestAttributes#SCOPE_REQUEST} attributes.
	 * Unlike in {@link CommandSession}, they will be destroyed after command execution completes. 
	 */
	private final Map<String, Object> requestVars = new HashMap<>();
	
	private final CommandSession session;
	
	/**
	 * <strong>Important:</strong> This automatically puts an {@link MDC} entry for {@value CommandRequestAttributes#MDC_TENANT_ID}
	 * from <tt>{@link CommandSession}.get("tenantId")</tt> (can be {@code null}) which will be removed by {@link #requestCompleted()}.
	 * @param session
	 */
	public CommandRequestAttributes(CommandSession session) {
		super();
		this.session = session;
		MDC.put(CommandRequestAttributes.MDC_TENANT_ID, (String) session.get("tenantId"));
	}

	public CommandSession getSession() {
		return session;
	}
	
	/**
	 * Return the {@link CommandRequestAttributes} currently bound to the thread.
	 * <p>Exposes the previously bound RequestAttributes instance, if any.
	 * @return the RequestAttributes currently bound to the thread
	 * @throws IllegalStateException if no RequestAttributes object
	 * is bound to the current thread
	 * @see RequestContextHolder#currentRequestAttributes()
	 */
	public static RequestAttributes currentRequestAttributes() throws IllegalStateException {
		final CommandRequestAttributes requestAttributes = threadRequestAttributes.get();
		Preconditions.checkState(requestAttributes != null, "Not in CommandSession. Note that currently request-scoped beans are not available inside Atmosphere, as a workaround you can save the 'tenantId' during constructor.");
		return requestAttributes;
	}
	
	/**
	 * Returns a {@link Closeable} that:
	 * A. if threadlocal doesn't yet exist, sets the threadlocal {@link CommandRequestAttributes}
	 * 		based on {@link CommandSession}, then afterwards, mark it as {@link #requestCompleted()} and removes it from the thread.
	 * B. if threadlocal already exist and is the same {@code tenantId}, simply uses the existing {@link CommandSession}. Otherwise throw {@link IllegalStateException}.
	 * @param requestAttributes
	 * @return 
	 * @throw {@link IllegalStateException}
	 */
	public static Closeable withSession(CommandSession session) {
		if (threadRequestAttributes.get() != null) {
			final CommandSession thatSession = threadRequestAttributes.get().getSession();
			final String tenantId = (String) session.get("tenantId");
			final String thatTenantId = (String) thatSession.get("tenantId");
			if (!Objects.equals(tenantId, thatTenantId)) {
				throw new IllegalStateException(String.format(
						"Thread '%s' requests session '%s' for tenant '%s' but already contains a CommandRequestAttributes with different session '%s' for tenant '%s', cannot set",
						Thread.currentThread().getId(), session, tenantId, thatSession, thatTenantId));
			}
			return new Closeable() {
				@Override
				public void close() {
					// Don't do anything, assume cleanup will be done by "parent"
				}
			};
		} else {
			final CommandRequestAttributes reqAttrs = new CommandRequestAttributes(session);
			threadRequestAttributes.set(reqAttrs);
			return new Closeable() {
				@Override
				public void close() {
					// Mark "request" as completed
					reqAttrs.requestCompleted();
					threadRequestAttributes.remove();
				}
			};
		}
	}

	/**
	 * Returns a {@link Closeable} that sets the {@link ThreadLocal} {@link CommandRequestAttributes}
	 * based on fixed {@code tenantId}, then afterwards, mark it as {@link #requestCompleted()} and removes it from the {@link ThreadLocal}.
	 * This is required when you want to use a multitenant {@code EntityManager} from a non-web/shell-request entry point
	 * (e.g. scheduled).
	 * @param requestAttributes
	 * @return 
	 */
	public static Closeable withTenant(String tenantId) {
		final SimpleCommandProcessor shell = new SimpleCommandProcessor(new ThreadIOImpl());
		final SimpleCommandSession session = new SimpleCommandSession(shell, 
				new ByteArrayInputStream(new byte[] {}), new PrintStream(new ByteArrayOutputStream()), new PrintStream(new ByteArrayOutputStream()));
		session.put("tenantId", tenantId);
		return withSession(session);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.RequestAttributes#getAttribute(java.lang.String, int)
	 */
	@Override
	public Object getAttribute(String name, int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			return requestVars.get(name);
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			return session.get(name);
		default:
			throw new IllegalArgumentException("Unknown scope: " + scope);
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.context.request.RequestAttributes#setAttribute(java.lang.String, java.lang.Object, int)
	 */
	@Override
	public void setAttribute(String name, Object value, int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			requestVars.put(name, value);
			break;
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			session.put(name, value);
			break;
		}
	}

	@Override
	public void removeAttribute(String name, int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			requestVars.remove(name);
			break;
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			session.put(name, null);
			break;
		}
	}

	@Override
	public String[] getAttributeNames(int scope) {
		switch (scope) {
		case SCOPE_REQUEST:
			return requestVars.keySet().toArray(new String[] {});
		case SCOPE_SESSION:
		case SCOPE_GLOBAL_SESSION:
			// see https://issues.apache.org/jira/browse/FELIX-4206
			final Collection<String> keySet = (Collection<String>) session.get(null);
			return keySet.toArray(new String[] {});
		default:
			throw new IllegalArgumentException("Unknown scope: " + scope);
		}
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback,
			int scope) {
		if (scope == SCOPE_REQUEST) {
			registerRequestDestructionCallback(name, callback);
		} else {
			registerSessionDestructionCallback(name, callback);
		}
	}

	/**
	 * Register the given callback as to be executed after session termination.
	 * <p>Note: The callback object should be serializable in order to survive
	 * web app restarts.
	 * @param name the name of the attribute to register the callback for
	 * @param callback the callback to be executed for destruction
	 */
	protected void registerSessionDestructionCallback(String name, Runnable callback) {
//		HttpSession session = getSession(true);
//		session.setAttribute(DESTRUCTION_CALLBACK_NAME_PREFIX + name,
//				new DestructionCallbackBindingListener(callback));
	}
	
	@Override
	public Object resolveReference(String key) {
		if (REFERENCE_REQUEST.equals(key)) {
//			return this.request;
			return requestVars;
		}
		else if (REFERENCE_SESSION.equals(key)) {
			return session;
		}
		else {
			return null;
		}
	}

	@Override
	public String getSessionId() {
		return Integer.toHexString(session.hashCode());
	}

	@Override
	public Object getSessionMutex() {
		return null;
	}

	@Override
	protected void updateAccessedSessionAttributes() {
	}
	
	@Override
	public void requestCompleted() {
		super.requestCompleted();
		MDC.remove(CommandRequestAttributes.MDC_TENANT_ID);
	}

}
