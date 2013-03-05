/**
 */
package org.soluvas.commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Archival Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 *  atribut untuk new/fresh/inbox. Kalau fresh maka masuk Inbox / New Products / bolded, tidak fresh maka masuk All Mail / All Products. Semanticnya Archive. Tidak termasuk read/unread ya.
 * <!-- end-model-doc -->
 * @see org.soluvas.commons.CommonsPackage#getArchivalStatus()
 * @model
 * @generated
 */
public enum ArchivalStatus implements Enumerator {
	/**
	 * The '<em><b>Fresh</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRESH_VALUE
	 * @generated
	 * @ordered
	 */
	FRESH(0, "fresh", "fresh"),

	/**
	 * The '<em><b>Archived</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHIVED_VALUE
	 * @generated
	 * @ordered
	 */
	ARCHIVED(1, "archived", "archived");

	/**
	 * The '<em><b>Fresh</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * New item
	 * <!-- end-model-doc -->
	 * @see #FRESH
	 * @model name="fresh"
	 * @generated
	 * @ordered
	 */
	public static final int FRESH_VALUE = 0;

	/**
	 * The '<em><b>Archived</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Old Item
	 * <!-- end-model-doc -->
	 * @see #ARCHIVED
	 * @model name="archived"
	 * @generated
	 * @ordered
	 */
	public static final int ARCHIVED_VALUE = 1;

	/**
	 * An array of all the '<em><b>Archival Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ArchivalStatus[] VALUES_ARRAY =
		new ArchivalStatus[] {
			FRESH,
			ARCHIVED,
		};

	/**
	 * A public read-only list of all the '<em><b>Archival Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ArchivalStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Archival Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchivalStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ArchivalStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Archival Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchivalStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ArchivalStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Archival Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ArchivalStatus get(int value) {
		switch (value) {
			case FRESH_VALUE: return FRESH;
			case ARCHIVED_VALUE: return ARCHIVED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ArchivalStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ArchivalStatus