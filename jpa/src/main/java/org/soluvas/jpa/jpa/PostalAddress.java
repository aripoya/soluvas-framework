package org.soluvas.jpa.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsFactory;
import com.google.common.base.Preconditions;

/**
 * A representation of the model object '<em><b>PostalAddress</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> See
 * http://www.upu.int/en/activities/addressing/standards.html - UPU S42.
 * 
 * ID is RFC1274: unique identifer. LDAP: uniqueIdentifier
 * 
 * 'name' attribute is Person name who will receive. RFC2256: common name(s) for
 * which the entity is known by. cn, commonName.
 * 
 * Can be used as:
 * 
 * 1. Billing Address in SalesQuote/SalesOrder 2. Shipping Address in
 * SalesQuote/SalesOrder 3. Origin Address in SalesQuote/SalesOrder 4. Person
 * (Customer) Address 5. Shop Address 6. Mall Address <!-- end-model-doc -->
 * 
 * @generated
 */
@Embeddable()
public class PostalAddress implements Describable, Serializable {

	private static final Logger log = LoggerFactory
			.getLogger(PostalAddress.class);

	public static PostalAddress getDefaultPrimaryAddress() {
		final PostalAddress postalAddress = new PostalAddress();
		postalAddress.setId(UUID.randomUUID());
		postalAddress.setPrimary(true);
		postalAddress.setPrimaryBilling(true);
		postalAddress.setPrimaryShipping(true);
		return postalAddress;
	}

	public static org.soluvas.commons.PostalAddress toCommons(
			PostalAddress jpaPostalAddressUp) {
		final org.soluvas.commons.PostalAddress emfPostalAddress = CommonsFactory.eINSTANCE
				.createPostalAddress();
		Preconditions.checkNotNull(jpaPostalAddressUp,
				"Postal Address must not be null");
		emfPostalAddress
				.setId(jpaPostalAddressUp.getId() != null ? jpaPostalAddressUp
						.getId().toString() : UUID.randomUUID().toString());
		emfPostalAddress.setCity(jpaPostalAddressUp.getCity());
		emfPostalAddress.setCountry(jpaPostalAddressUp.getCountry());
		emfPostalAddress.setCountryCode(jpaPostalAddressUp.getCountryCode());
		emfPostalAddress.setDescription(jpaPostalAddressUp.getDescription());
		if (jpaPostalAddressUp.getEmails() != null
				&& !jpaPostalAddressUp.getEmails().isEmpty()) {
			emfPostalAddress.getEmails().addAll(jpaPostalAddressUp.getEmails());
		}
		if (jpaPostalAddressUp.getHomePhones() != null
				&& !jpaPostalAddressUp.getHomePhones().isEmpty()) {
			emfPostalAddress.getHomePhones().addAll(
					jpaPostalAddressUp.getHomePhones());
		}
		if (jpaPostalAddressUp.getMobiles() != null
				&& !jpaPostalAddressUp.getMobiles().isEmpty()) {
			emfPostalAddress.getMobiles().addAll(
					jpaPostalAddressUp.getMobiles());
		}
		emfPostalAddress.setName(jpaPostalAddressUp.getName());
		emfPostalAddress.setOrganization(jpaPostalAddressUp.getOrganization());
		if (jpaPostalAddressUp.getPhones() != null
				&& !jpaPostalAddressUp.getPhones().isEmpty()) {
			emfPostalAddress.getPhones().addAll(jpaPostalAddressUp.getPhones());
		}
		emfPostalAddress.setPostalCode(jpaPostalAddressUp.getPostalCode());
		emfPostalAddress.setPrimary(jpaPostalAddressUp.isPrimary());
		emfPostalAddress.setPrimaryBilling(jpaPostalAddressUp
				.isPrimaryBilling());
		emfPostalAddress.setPrimaryEmail(jpaPostalAddressUp.getPrimaryEmail());
		emfPostalAddress.setPrimaryHomePhone(jpaPostalAddressUp
				.getPrimaryHomePhone());
		emfPostalAddress
				.setPrimaryMobile(jpaPostalAddressUp.getPrimaryMobile());
		emfPostalAddress.setPrimaryPhone(jpaPostalAddressUp.getPrimaryPhone());
		emfPostalAddress.setPrimaryShipping(jpaPostalAddressUp
				.isPrimaryShipping());
		emfPostalAddress.setPrimaryWorkPhone(jpaPostalAddressUp
				.getPrimaryWorkPhone());
		emfPostalAddress.setProvince(jpaPostalAddressUp.getProvince());
		emfPostalAddress.setStreet(jpaPostalAddressUp.getStreet());
		emfPostalAddress.setValidationTime(jpaPostalAddressUp
				.getValidationTime());
		if (jpaPostalAddressUp.getWorkPhones() != null
				&& !jpaPostalAddressUp.getWorkPhones().isEmpty()) {
			emfPostalAddress.getWorkPhones().addAll(
					jpaPostalAddressUp.getWorkPhones());
		}

		return emfPostalAddress;
	}

	public static PostalAddress fromCommons(
			org.soluvas.commons.PostalAddress commonsPostalAddressUp) {
		final PostalAddress jpaPostalAddress = new PostalAddress();
		Preconditions.checkNotNull(commonsPostalAddressUp,
				"Postal Address must not be null");
		jpaPostalAddress
				.setId(commonsPostalAddressUp.getId() != null ? UUID
						.fromString(commonsPostalAddressUp.getId()) : UUID
						.randomUUID());
		jpaPostalAddress.setCity(commonsPostalAddressUp.getCity());
		jpaPostalAddress.setCountry(commonsPostalAddressUp.getCountry());
		jpaPostalAddress
				.setCountryCode(commonsPostalAddressUp.getCountryCode());
		jpaPostalAddress
				.setDescription(commonsPostalAddressUp.getDescription());
		if (commonsPostalAddressUp.getEmails() != null
				&& !commonsPostalAddressUp.getEmails().isEmpty()) {
			jpaPostalAddress.getEmails().addAll(
					commonsPostalAddressUp.getEmails());
		}
		if (commonsPostalAddressUp.getHomePhones() != null
				&& !commonsPostalAddressUp.getHomePhones().isEmpty()) {
			jpaPostalAddress.getHomePhones().addAll(
					commonsPostalAddressUp.getHomePhones());
		}
		if (commonsPostalAddressUp.getMobiles() != null
				&& !commonsPostalAddressUp.getMobiles().isEmpty()) {
			jpaPostalAddress.getMobiles().addAll(
					commonsPostalAddressUp.getMobiles());
		}
		jpaPostalAddress.setName(commonsPostalAddressUp.getName());
		jpaPostalAddress.setOrganization(commonsPostalAddressUp
				.getOrganization());
		if (commonsPostalAddressUp.getPhones() != null
				&& !commonsPostalAddressUp.getPhones().isEmpty()) {
			jpaPostalAddress.getPhones().addAll(
					commonsPostalAddressUp.getPhones());
		}
		jpaPostalAddress.setPostalCode(commonsPostalAddressUp.getPostalCode());
		jpaPostalAddress.setPrimary(commonsPostalAddressUp.isPrimary());
		jpaPostalAddress.setPrimaryBilling(commonsPostalAddressUp
				.isPrimaryBilling());
		jpaPostalAddress.setPrimaryEmail(commonsPostalAddressUp
				.getPrimaryEmail());
		jpaPostalAddress.setPrimaryHomePhone(commonsPostalAddressUp
				.getPrimaryHomePhone());
		jpaPostalAddress.setPrimaryMobile(commonsPostalAddressUp
				.getPrimaryMobile());
		jpaPostalAddress.setPrimaryPhone(commonsPostalAddressUp
				.getPrimaryPhone());
		jpaPostalAddress.setPrimaryShipping(commonsPostalAddressUp
				.isPrimaryShipping());
		jpaPostalAddress.setPrimaryWorkPhone(commonsPostalAddressUp
				.getPrimaryWorkPhone());
		jpaPostalAddress.setProvince(commonsPostalAddressUp.getProvince());
		jpaPostalAddress.setStreet(commonsPostalAddressUp.getStreet());
		jpaPostalAddress.setValidationTime(commonsPostalAddressUp
				.getValidationTime());
		if (commonsPostalAddressUp.getWorkPhones() != null
				&& !commonsPostalAddressUp.getWorkPhones().isEmpty()) {
			jpaPostalAddress.getWorkPhones().addAll(
					commonsPostalAddressUp.getWorkPhones());
		}

		return jpaPostalAddress;
	}

	/**
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Basic()
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String name = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Organization or company name who will send or receive. Can be empty.
	 * RFC2256: organization this object belongs to LDAP: o, organizationName
	 * <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String organization = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String street = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String city = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String postalCode = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String province = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: friendly country name.
	 * 
	 * LDAP: co, friendlyCountryName <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String country = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * ISO 3166-1 alpha-2.
	 * 
	 * LDAP: c, countryName <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String countryCode = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String primaryMobile = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: mobile telephone number LDAP: mobile, mobileTelephoneNumber <!--
	 * end-model-doc -->
	 * 
	 */
	@Type(type = "org.soluvas.jpa.PersistentStringList")
	private List<String> mobiles = new ArrayList<String>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC2256: Telephone Number LDAP: telephoneNumber
	 * 
	 * For offices, usually work phone. For people, usually home phone. <!--
	 * end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String primaryPhone = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	@Type(type = "org.soluvas.jpa.PersistentStringList")
	private List<String> phones = new ArrayList<String>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String primaryHomePhone = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: home telephone number. LDAP: homePhone, homeTelephoneNumber.
	 * <!-- end-model-doc -->
	 * 
	 */
	@Type(type = "org.soluvas.jpa.PersistentStringList")
	private List<String> homePhones = new ArrayList<String>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String primaryWorkPhone = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC2256: Telephone Number. LDAP: (not yet mapped) <!-- end-model-doc -->
	 * 
	 */
	@Type(type = "org.soluvas.jpa.PersistentStringList")
	private List<String> workPhones = new ArrayList<String>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String primaryEmail = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * LDAP: mail. <!-- end-model-doc -->
	 * 
	 */
	@Type(type = "org.soluvas.jpa.PersistentStringList")
	private List<String> emails = new ArrayList<String>();

	/**
	 * Returns the value of '<em><b>id</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>id</b></em>' feature
	 * @generated
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the '{@link PostalAddress#getId() <em>id</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newId
	 *            the new value of the '{@link PostalAddress#getId() id}'
	 *            feature.
	 * @generated
	 */
	public void setId(UUID newId) {
		id = newId;
	}

	/**
	 * Returns the value of '<em><b>name</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>name</b></em>' feature
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the '{@link PostalAddress#getName() <em>name</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newName
	 *            the new value of the '{@link PostalAddress#getName() name}'
	 *            feature.
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary Address of the containing list.
	 * <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private Boolean primary = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing
	 * list. <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private Boolean primaryBilling = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing
	 * list. <!-- end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private Boolean primaryShipping = false;

	/**
	 * <!-- begin-user-doc --> Problem with @Columns and @Embeddable:
	 * https://github.com/JadiraOrg/jadira/issues/20
	 * 
	 * @todo <b>WARNING:</b> Custom {@link #getValidationTime()} and
	 *       {@link #setValidationTime(DateTime)} implementation! Please reset
	 *       if Jadira issue is fixed. <!-- end-user-doc --> <!--
	 *       begin-model-doc --> When this postal address was validated by the
	 *       user. <!-- end-model-doc -->
	 * 
	 */
	@Basic()
	// @Columns(columns = { @Column(name = "validationtime"),
	// @Column(name = "validationtime_zone") })
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime validationTime = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String district = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * What this address represents, usually "Home", "Work", etc. <!--
	 * end-model-doc -->
	 * 
	 * @generated
	 */
	@Basic()
	private String description = null;

	@Basic()
	// @Columns(columns = { @Column(name = "validationtime"),
	// @Column(name = "validationtime_zone") })
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTimeZoneAsString")
	private DateTimeZone validationTime_zone = null;

	public PostalAddress() {
		super();
	}

	public PostalAddress(final org.soluvas.commons.PostalAddress postalAddressUp) {
		Preconditions.checkNotNull(postalAddressUp,
				"Postal Address must not be null");
		setId(postalAddressUp.getId() != null ? UUID.fromString(postalAddressUp
				.getId()) : UUID.randomUUID());
		setCity(postalAddressUp.getCity());
		setCountry(postalAddressUp.getCountry());
		setCountryCode(postalAddressUp.getCountryCode());
		setDescription(postalAddressUp.getDescription());
		setEmails(new ArrayList<>(postalAddressUp.getEmails()));
		setHomePhones(new ArrayList<>(postalAddressUp.getHomePhones()));
		setMobiles(new ArrayList<>(postalAddressUp.getMobiles()));
		setName(postalAddressUp.getName());
		setOrganization(postalAddressUp.getOrganization());
		setPhones(new ArrayList<>(postalAddressUp.getPhones()));
		setPostalCode(postalAddressUp.getPostalCode());
		setPrimary(postalAddressUp.isPrimary());
		setPrimaryBilling(postalAddressUp.isPrimaryBilling());
		setPrimaryEmail(postalAddressUp.getPrimaryEmail());
		setPrimaryHomePhone(postalAddressUp.getPrimaryHomePhone());
		setPrimaryMobile(postalAddressUp.getPrimaryMobile());
		setPrimaryPhone(postalAddressUp.getPrimaryPhone());
		setPrimaryShipping(postalAddressUp.isPrimaryShipping());
		setPrimaryWorkPhone(postalAddressUp.getPrimaryWorkPhone());
		setProvince(postalAddressUp.getProvince());
		setStreet(postalAddressUp.getStreet());
		setValidationTime(postalAddressUp.getValidationTime());
		setWorkPhones(new ArrayList<>(postalAddressUp.getWorkPhones()));
	}

	/**
	 * Returns the value of '<em><b>organization</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Organization or company name who will send or receive. Can be empty.
	 * RFC2256: organization this object belongs to LDAP: o, organizationName
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>organization</b></em>' feature
	 * @generated
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * Sets the '{@link PostalAddress#getOrganization() <em>organization</em>}'
	 * feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Organization or company name who will send or receive. Can be empty.
	 * RFC2256: organization this object belongs to LDAP: o, organizationName
	 * <!-- end-model-doc -->
	 * 
	 * @param newOrganization
	 *            the new value of the '{@link PostalAddress#getOrganization()
	 *            organization}' feature.
	 * @generated
	 */
	public void setOrganization(String newOrganization) {
		organization = newOrganization;
	}

	/**
	 * Returns the value of '<em><b>street</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>street</b></em>' feature
	 * @generated
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the '{@link PostalAddress#getStreet() <em>street</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newStreet
	 *            the new value of the '{@link PostalAddress#getStreet() street}
	 *            ' feature.
	 * @generated
	 */
	public void setStreet(String newStreet) {
		street = newStreet;
	}

	/**
	 * Returns the value of '<em><b>city</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>city</b></em>' feature
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the '{@link PostalAddress#getCity() <em>city</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newCity
	 *            the new value of the '{@link PostalAddress#getCity() city}'
	 *            feature.
	 * @generated
	 */
	public void setCity(String newCity) {
		city = newCity;
	}

	/**
	 * Returns the value of '<em><b>postalCode</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>postalCode</b></em>' feature
	 * @generated
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the '{@link PostalAddress#getPostalCode() <em>postalCode</em>}'
	 * feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPostalCode
	 *            the new value of the '{@link PostalAddress#getPostalCode()
	 *            postalCode}' feature.
	 * @generated
	 */
	public void setPostalCode(String newPostalCode) {
		postalCode = newPostalCode;
	}

	/**
	 * Returns the value of '<em><b>province</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>province</b></em>' feature
	 * @generated
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Sets the '{@link PostalAddress#getProvince() <em>province</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newProvince
	 *            the new value of the '{@link PostalAddress#getProvince()
	 *            province}' feature.
	 * @generated
	 */
	public void setProvince(String newProvince) {
		province = newProvince;
	}

	/**
	 * Returns the value of '<em><b>country</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: friendly country name.
	 * 
	 * LDAP: co, friendlyCountryName <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>country</b></em>' feature
	 * @generated
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the '{@link PostalAddress#getCountry() <em>country</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: friendly country name.
	 * 
	 * LDAP: co, friendlyCountryName <!-- end-model-doc -->
	 * 
	 * @param newCountry
	 *            the new value of the '{@link PostalAddress#getCountry()
	 *            country}' feature.
	 * @generated
	 */
	public void setCountry(String newCountry) {
		country = newCountry;
	}

	/**
	 * Returns the value of '<em><b>countryCode</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * ISO 3166-1 alpha-2.
	 * 
	 * LDAP: c, countryName <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>countryCode</b></em>' feature
	 * @generated
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the '{@link PostalAddress#getCountryCode() <em>countryCode</em>}'
	 * feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * ISO 3166-1 alpha-2.
	 * 
	 * LDAP: c, countryName <!-- end-model-doc -->
	 * 
	 * @param newCountryCode
	 *            the new value of the '{@link PostalAddress#getCountryCode()
	 *            countryCode}' feature.
	 * @generated
	 */
	public void setCountryCode(String newCountryCode) {
		countryCode = newCountryCode;
	}

	/**
	 * Returns the value of '<em><b>primaryMobile</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>primaryMobile</b></em>' feature
	 * @generated
	 */
	public String getPrimaryMobile() {
		return primaryMobile;
	}

	/**
	 * Sets the '{@link PostalAddress#getPrimaryMobile() <em>primaryMobile</em>}
	 * ' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPrimaryMobile
	 *            the new value of the '{@link PostalAddress#getPrimaryMobile()
	 *            primaryMobile}' feature.
	 * @generated
	 */
	public void setPrimaryMobile(String newPrimaryMobile) {
		primaryMobile = newPrimaryMobile;
	}

	/**
	 * Returns the value of '<em><b>mobiles</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: mobile telephone number LDAP: mobile, mobileTelephoneNumber <!--
	 * end-model-doc -->
	 * 
	 * @return the value of '<em><b>mobiles</b></em>' feature
	 * @generated
	 */
	public List<String> getMobiles() {
		return mobiles;
	}

	/**
	 * Sets the '{@link PostalAddress#getMobiles() <em>mobiles</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: mobile telephone number LDAP: mobile, mobileTelephoneNumber <!--
	 * end-model-doc -->
	 * 
	 * @param newMobiles
	 *            the new value of the '{@link PostalAddress#getMobiles()
	 *            mobiles}' feature.
	 * @generated
	 */
	public void setMobiles(List<String> newMobiles) {
		mobiles = newMobiles;
	}

	/**
	 * Returns the value of '<em><b>primaryPhone</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC2256: Telephone Number LDAP: telephoneNumber
	 * 
	 * For offices, usually work phone. For people, usually home phone. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of '<em><b>primaryPhone</b></em>' feature
	 * @generated
	 */
	public String getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * Sets the '{@link PostalAddress#getPrimaryPhone() <em>primaryPhone</em>}'
	 * feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC2256: Telephone Number LDAP: telephoneNumber
	 * 
	 * For offices, usually work phone. For people, usually home phone. <!--
	 * end-model-doc -->
	 * 
	 * @param newPrimaryPhone
	 *            the new value of the '{@link PostalAddress#getPrimaryPhone()
	 *            primaryPhone}' feature.
	 * @generated
	 */
	public void setPrimaryPhone(String newPrimaryPhone) {
		primaryPhone = newPrimaryPhone;
	}

	/**
	 * Returns the value of '<em><b>phones</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>phones</b></em>' feature
	 * @generated
	 */
	public List<String> getPhones() {
		return phones;
	}

	/**
	 * Sets the '{@link PostalAddress#getPhones() <em>phones</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPhones
	 *            the new value of the '{@link PostalAddress#getPhones() phones}
	 *            ' feature.
	 * @generated
	 */
	public void setPhones(List<String> newPhones) {
		phones = newPhones;
	}

	/**
	 * Returns the value of '<em><b>primaryHomePhone</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>primaryHomePhone</b></em>' feature
	 * @generated
	 */
	public String getPrimaryHomePhone() {
		return primaryHomePhone;
	}

	/**
	 * Sets the '{@link PostalAddress#getPrimaryHomePhone()
	 * <em>primaryHomePhone</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPrimaryHomePhone
	 *            the new value of the '
	 *            {@link PostalAddress#getPrimaryHomePhone() primaryHomePhone}'
	 *            feature.
	 * @generated
	 */
	public void setPrimaryHomePhone(String newPrimaryHomePhone) {
		primaryHomePhone = newPrimaryHomePhone;
	}

	/**
	 * Returns the value of '<em><b>homePhones</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: home telephone number. LDAP: homePhone, homeTelephoneNumber.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>homePhones</b></em>' feature
	 * @generated
	 */
	public List<String> getHomePhones() {
		return homePhones;
	}

	/**
	 * Sets the '{@link PostalAddress#getHomePhones() <em>homePhones</em>}'
	 * feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC1274: home telephone number. LDAP: homePhone, homeTelephoneNumber.
	 * <!-- end-model-doc -->
	 * 
	 * @param newHomePhones
	 *            the new value of the '{@link PostalAddress#getHomePhones()
	 *            homePhones}' feature.
	 * @generated
	 */
	public void setHomePhones(List<String> newHomePhones) {
		homePhones = newHomePhones;
	}

	/**
	 * Returns the value of '<em><b>primaryWorkPhone</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>primaryWorkPhone</b></em>' feature
	 * @generated
	 */
	public String getPrimaryWorkPhone() {
		return primaryWorkPhone;
	}

	/**
	 * Sets the '{@link PostalAddress#getPrimaryWorkPhone()
	 * <em>primaryWorkPhone</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPrimaryWorkPhone
	 *            the new value of the '
	 *            {@link PostalAddress#getPrimaryWorkPhone() primaryWorkPhone}'
	 *            feature.
	 * @generated
	 */
	public void setPrimaryWorkPhone(String newPrimaryWorkPhone) {
		primaryWorkPhone = newPrimaryWorkPhone;
	}

	/**
	 * Returns the value of '<em><b>workPhones</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC2256: Telephone Number. LDAP: (not yet mapped) <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>workPhones</b></em>' feature
	 * @generated
	 */
	public List<String> getWorkPhones() {
		return workPhones;
	}

	/**
	 * Sets the '{@link PostalAddress#getWorkPhones() <em>workPhones</em>}'
	 * feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * RFC2256: Telephone Number. LDAP: (not yet mapped) <!-- end-model-doc -->
	 * 
	 * @param newWorkPhones
	 *            the new value of the '{@link PostalAddress#getWorkPhones()
	 *            workPhones}' feature.
	 * @generated
	 */
	public void setWorkPhones(List<String> newWorkPhones) {
		workPhones = newWorkPhones;
	}

	/**
	 * Returns the value of '<em><b>primaryEmail</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>primaryEmail</b></em>' feature
	 * @generated
	 */
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * Sets the '{@link PostalAddress#getPrimaryEmail() <em>primaryEmail</em>}'
	 * feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newPrimaryEmail
	 *            the new value of the '{@link PostalAddress#getPrimaryEmail()
	 *            primaryEmail}' feature.
	 * @generated
	 */
	public void setPrimaryEmail(String newPrimaryEmail) {
		primaryEmail = newPrimaryEmail;
	}

	/**
	 * Returns the value of '<em><b>emails</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * LDAP: mail. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>emails</b></em>' feature
	 * @generated
	 */
	@Nullable
	public List<String> getEmails() {
		return emails;
	}

	/**
	 * Sets the '{@link PostalAddress#getEmails() <em>emails</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * LDAP: mail. <!-- end-model-doc -->
	 * 
	 * @param newEmails
	 *            the new value of the '{@link PostalAddress#getEmails() emails}
	 *            ' feature.
	 * @generated
	 */
	public void setEmails(List<String> newEmails) {
		emails = newEmails;
	}

	/**
	 * Returns the value of '<em><b>primary</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary Address of the containing list.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>primary</b></em>' feature
	 * @generated
	 */
	public Boolean isPrimary() {
		return primary;
	}

	/**
	 * Sets the '{@link PostalAddress#isPrimary() <em>primary</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary Address of the containing list.
	 * <!-- end-model-doc -->
	 * 
	 * @param newPrimary
	 *            the new value of the '{@link PostalAddress#isPrimary()
	 *            primary}' feature.
	 * @generated
	 */
	public void setPrimary(Boolean newPrimary) {
		primary = newPrimary;
	}

	/**
	 * Returns the value of '<em><b>primaryBilling</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing
	 * list. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>primaryBilling</b></em>' feature
	 * @generated
	 */
	public Boolean isPrimaryBilling() {
		return primaryBilling;
	}

	/**
	 * Sets the '{@link PostalAddress#isPrimaryBilling()
	 * <em>primaryBilling</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing
	 * list. <!-- end-model-doc -->
	 * 
	 * @param newPrimaryBilling
	 *            the new value of the '{@link PostalAddress#isPrimaryBilling()
	 *            primaryBilling}' feature.
	 * @generated
	 */
	public void setPrimaryBilling(Boolean newPrimaryBilling) {
		primaryBilling = newPrimaryBilling;
	}

	/**
	 * Returns the value of '<em><b>primaryShipping</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing
	 * list. <!-- end-model-doc -->
	 * 
	 * @return the value of '<em><b>primaryShipping</b></em>' feature
	 * @generated
	 */
	public Boolean isPrimaryShipping() {
		return primaryShipping;
	}

	/**
	 * Sets the '{@link PostalAddress#isPrimaryShipping()
	 * <em>primaryShipping</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * Designates this Address as the primary billing Address of the containing
	 * list. <!-- end-model-doc -->
	 * 
	 * @param newPrimaryShipping
	 *            the new value of the '
	 *            {@link PostalAddress#isPrimaryShipping() primaryShipping}'
	 *            feature.
	 * @generated
	 */
	public void setPrimaryShipping(Boolean newPrimaryShipping) {
		primaryShipping = newPrimaryShipping;
	}

	/**
	 * Returns the value of '<em><b>validationTime</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * When this postal address was validated by the user. <!-- end-model-doc
	 * -->
	 * 
	 * @return the value of '<em><b>validationTime</b></em>' feature
	 */
	public DateTime getValidationTime() {
		return validationTime != null ? validationTime
				.withZone(getValidationTime_zone()) : null;
	}

	/**
	 * Sets the '{@link PostalAddress#getValidationTime()
	 * <em>validationTime</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * When this postal address was validated by the user. <!-- end-model-doc
	 * -->
	 * 
	 * @param newValidationTime
	 *            the new value of the '
	 *            {@link PostalAddress#getValidationTime() validationTime}'
	 *            feature.
	 */
	public void setValidationTime(DateTime newValidationTime) {
		validationTime = newValidationTime;
		if (newValidationTime != null) {
			this.validationTime_zone = newValidationTime.getZone();
		} else {
			this.validationTime_zone = null;
		}
	}

	/**
	 * Returns the value of '<em><b>district</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>district</b></em>' feature
	 * @generated
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Sets the '{@link PostalAddress#getDistrict() <em>district</em>}' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newDistrict
	 *            the new value of the '{@link PostalAddress#getDistrict()
	 *            district}' feature.
	 * @generated
	 */
	public void setDistrict(String newDistrict) {
		district = newDistrict;
	}

	/**
	 * Returns the value of '<em><b>description</b></em>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * What this address represents, usually "Home", "Work", etc. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of '<em><b>description</b></em>' feature
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the '{@link PostalAddress#getDescription() <em>description</em>}'
	 * feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * What this address represents, usually "Home", "Work", etc. <!--
	 * end-model-doc -->
	 * 
	 * @param newDescription
	 *            the new value of the '{@link PostalAddress#getDescription()
	 *            description}' feature.
	 * @generated
	 */
	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public DateTimeZone getValidationTime_zone() {
		return validationTime_zone;
	}

	public void setValidationTime_zone(DateTimeZone validationTime_zone) {
		this.validationTime_zone = validationTime_zone;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "PostalAddress " + " [id: " + getId() + "]" + " [name: "
				+ getName() + "]" + " [organization: " + getOrganization()
				+ "]" + " [street: " + getStreet() + "]" + " [city: "
				+ getCity() + "]" + " [postalCode: " + getPostalCode() + "]"
				+ " [province: " + getProvince() + "]" + " [country: "
				+ getCountry() + "]" + " [countryCode: " + getCountryCode()
				+ "]" + " [primaryMobile: " + getPrimaryMobile() + "]"
				+ " [primaryPhone: " + getPrimaryPhone() + "]"
				+ " [primaryHomePhone: " + getPrimaryHomePhone() + "]"
				+ " [primaryWorkPhone: " + getPrimaryWorkPhone() + "]"
				+ " [primaryEmail: " + getPrimaryEmail() + "]" + " [primary: "
				+ isPrimary() + "]" + " [primaryBilling: " + isPrimaryBilling()
				+ "]" + " [primaryShipping: " + isPrimaryShipping() + "]"
				+ " [validationTime: " + getValidationTime() + "]"
				+ " [district: " + getDistrict() + "]" + " [description: "
				+ getDescription() + "]";
	}

}
