/**
 */
package org.soluvas.email.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.Page;
import org.soluvas.email.PageType;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.PageTypeImpl#getSenderTypeName <em>Sender Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageTypeImpl extends TemplateTypeImpl<Page> implements PageType {
	private static final Logger log = LoggerFactory
			.getLogger(PageTypeImpl.class);
	/**
	 * The default value of the '{@link #getSenderTypeName() <em>Sender Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String SENDER_TYPE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSenderTypeName() <em>Sender Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenderTypeName()
	 * @generated
	 * @ordered
	 */
	protected String senderTypeName = SENDER_TYPE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.PAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSenderTypeName() {
		return senderTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSenderTypeName(String newSenderTypeName) {
		String oldSenderTypeName = senderTypeName;
		senderTypeName = newSenderTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME, oldSenderTypeName, senderTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Page create(Layout layout) {
		Preconditions.checkNotNull(getEFactory(),
				"Cannot create Page %s because eFactory is null", getName());
		log.debug("Creating Page {} of EClass {} using {}",
				getName(), getEClass().getName(), getEFactory()); 
		final Page target = (Page) getEFactory().create(getEClass());
		target.setPageType(this);
		// set layout
		target.setLayout(layout);
		log.debug("Created {} from Page {} of EClass {} using {}",
				target.getClass().getName(), getName(), getEClass().getName(), getEFactory()); 
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				return getSenderTypeName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				setSenderTypeName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				setSenderTypeName(SENDER_TYPE_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmailPackage.PAGE_TYPE__SENDER_TYPE_NAME:
				return SENDER_TYPE_NAME_EDEFAULT == null ? senderTypeName != null : !SENDER_TYPE_NAME_EDEFAULT.equals(senderTypeName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EmailPackage.PAGE_TYPE___CREATE__LAYOUT:
				return create((Layout)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (senderTypeName: ");
		result.append(senderTypeName);
		result.append(')');
		return result.toString();
	}

} //PageTypeImpl
