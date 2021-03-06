package org.soluvas.jpa;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.postgresql.util.PGobject;

/**
 * Map <a href="http://www.postgresql.org/">Postgres</a> <a href="http://wiki.postgresql.org/wiki/Enum">Enum</a>
 * onto <a href="http://download.oracle.com/javase/tutorial/java/javaOO/enum.html">Java Enum</a> using <a href="http://www.hibernate.org/">Hibernate</a>.
 * 
 * @deprecated It seems only works with Hibernate 4.3 with PostgreSQL9Dialect, but a better version is already
 * <a href="https://github.com/JadiraOrg/jadira/issues/14">available in Jadira 3.2.0</a>.
 * For Hibernate 4.2 with PostgreSQL82Dialect, use Jadira {@link org.jadira.usertype.corejava.PersistentEnum}
 * instead since PostgreSQL82Dialect returns {@code enum} as String, not as {@link PGobject}.
 * @author Rudi Wijaya <rudi@bippo.co.id>
 * @see http://anismiles.wordpress.com/2010/08/04/postgres-enum-with-hibernate/
 */
@Deprecated
public class PersistentEnum extends org.jadira.usertype.corejava.PersistentEnum {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see <a href="https://github.com/JadiraOrg/jadira/issues/33">JadiraOrg/jadira#33</a>
	 * @see org.jadira.usertype.spi.shared.AbstractReflectionUserType#returnedClass()
	 */
	@Override
	public Class<Enum<?>> returnedClass() {
		return (Class<Enum<?>>) getMappedClass();
	}
	
	@Override
	public Object doNullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		final Object identifier = rs.getObject(names[0]);
		if (rs.wasNull()) {
			return null;
		}
        // Notice how Object is mapped to PGobject. This makes this implementation Postgres specific
        if (identifier instanceof PGobject) {
            PGobject pg = (PGobject) identifier;
            return Enum.valueOf((Class) getMappedClass(), pg.getValue());
        } else if (identifier instanceof String) { // quirk of PostgreSQL82Dialect? to write we must use PGobject, but to read it returns String??
        	return Enum.valueOf((Class) getMappedClass(), (String) identifier);
        } else {
        	throw new IllegalArgumentException("PersistentEnum type expects PGobject, got " + identifier.getClass().getName() + " for value '" + identifier + "'");
        }
	}
	
	@Override
	public void doNullSafeSet(PreparedStatement preparedStatement,
			Object value, int index, SessionImplementor session)
			throws SQLException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
    	if (value == null) {
            // To support NULL insertion, use type 1111 instead of VARCHAR
			preparedStatement.setNull(index, Types.OTHER);
		} else {
            // Notice 1111 which java.sql.Type for Postgres Enum
			preparedStatement.setObject(index, ((Enum) value).name(), Types.OTHER);
		}
	}

}
