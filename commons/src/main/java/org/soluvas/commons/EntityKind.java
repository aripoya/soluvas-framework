/**
 */
package org.soluvas.commons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Entity Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Inspired by {@link org.soluvas.image.ImageTypes}. Used by {@link org.soluvas.web.site.PermalinkManager}.
 * <!-- end-model-doc -->
 * @see org.soluvas.commons.CommonsPackage#getEntityKind()
 * @model
 * @generated
 */
public enum EntityKind implements Enumerator {
	/**
	 * The '<em><b>Person</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERSON_VALUE
	 * @generated
	 * @ordered
	 */
	PERSON(0, "person", "person"),

	/**
	 * The '<em><b>Shop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOP_VALUE
	 * @generated
	 * @ordered
	 */
	SHOP(1, "shop", "shop"),

	/**
	 * The '<em><b>Product</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT(2, "product", "product"),

	/**
	 * The '<em><b>Place</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLACE_VALUE
	 * @generated
	 * @ordered
	 */
	PLACE(3, "place", "place"),

	/**
	 * The '<em><b>Task</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TASK_VALUE
	 * @generated
	 * @ordered
	 */
	TASK(4, "task", "task"),

	/**
	 * The '<em><b>Article</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARTICLE_VALUE
	 * @generated
	 * @ordered
	 */
	ARTICLE(5, "article", "article"),

	/**
	 * The '<em><b>Banner shop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BANNER_SHOP_VALUE
	 * @generated
	 * @ordered
	 */
	BANNER_SHOP(6, "banner_shop", "banner_shop"),

	/**
	 * The '<em><b>Category</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CATEGORY_VALUE
	 * @generated
	 * @ordered
	 */
	CATEGORY(7, "category", "category"),

	/**
	 * The '<em><b>Product release</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_RELEASE_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT_RELEASE(8, "product_release", "product_release"),

	/**
	 * The '<em><b>Tag</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TAG_VALUE
	 * @generated
	 * @ordered
	 */
	TAG(9, "tag", "tag"), /**
	 * The '<em><b>Page</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	PAGE(10, "page", "page");

	/**
	 * The '<em><b>Person</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Person</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERSON
	 * @model name="person"
	 * @generated
	 * @ordered
	 */
	public static final int PERSON_VALUE = 0;

	/**
	 * The '<em><b>Shop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Shop</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOP
	 * @model name="shop"
	 * @generated
	 * @ordered
	 */
	public static final int SHOP_VALUE = 1;

	/**
	 * The '<em><b>Product</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Product</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCT
	 * @model name="product"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_VALUE = 2;

	/**
	 * The '<em><b>Place</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Place</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLACE
	 * @model name="place"
	 * @generated
	 * @ordered
	 */
	public static final int PLACE_VALUE = 3;

	/**
	 * The '<em><b>Task</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Task</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TASK
	 * @model name="task"
	 * @generated
	 * @ordered
	 */
	public static final int TASK_VALUE = 4;

	/**
	 * The '<em><b>Article</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Article</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * CMS Article, which is usually chronological, categorized/tagged, and owned by Person (compare with Page).
	 * <!-- end-model-doc -->
	 * @see #ARTICLE
	 * @model name="article"
	 * @generated
	 * @ordered
	 */
	public static final int ARTICLE_VALUE = 5;

	/**
	 * The '<em><b>Banner shop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Banner shop</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BANNER_SHOP
	 * @model name="banner_shop"
	 * @generated
	 * @ordered
	 */
	public static final int BANNER_SHOP_VALUE = 6;

	/**
	 * The '<em><b>Category</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Category</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CATEGORY
	 * @model name="category"
	 * @generated
	 * @ordered
	 */
	public static final int CATEGORY_VALUE = 7;

	/**
	 * The '<em><b>Product release</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Product release</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_RELEASE
	 * @model name="product_release"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_RELEASE_VALUE = 8;

	/**
	 * The '<em><b>Tag</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tag</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TAG
	 * @model name="tag"
	 * @generated
	 * @ordered
	 */
	public static final int TAG_VALUE = 9;

	/**
	 * The '<em><b>Page</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * CMS page, which is usually non-chronological, hierarchical / structural, uncategorized/untagged, and owned by Tenant (compare with Article).
	 * <!-- end-model-doc -->
	 * @see #PAGE
	 * @model name="page"
	 * @generated
	 * @ordered
	 */
	public static final int PAGE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Entity Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EntityKind[] VALUES_ARRAY =
		new EntityKind[] {
			PERSON,
			SHOP,
			PRODUCT,
			PLACE,
			TASK,
			ARTICLE,
			BANNER_SHOP,
			CATEGORY,
			PRODUCT_RELEASE,
			TAG,
			PAGE,
		};

	/**
	 * A public read-only list of all the '<em><b>Entity Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EntityKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Entity Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntityKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntityKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entity Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntityKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntityKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entity Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntityKind get(int value) {
		switch (value) {
			case PERSON_VALUE: return PERSON;
			case SHOP_VALUE: return SHOP;
			case PRODUCT_VALUE: return PRODUCT;
			case PLACE_VALUE: return PLACE;
			case TASK_VALUE: return TASK;
			case ARTICLE_VALUE: return ARTICLE;
			case BANNER_SHOP_VALUE: return BANNER_SHOP;
			case CATEGORY_VALUE: return CATEGORY;
			case PRODUCT_RELEASE_VALUE: return PRODUCT_RELEASE;
			case TAG_VALUE: return TAG;
			case PAGE_VALUE: return PAGE;
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
	private EntityKind(int value, String name, String literal) {
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
	
} //EntityKind
