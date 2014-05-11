/**
 */
package org.soluvas.socmed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Facebook Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.socmed.FacebookSysConfig#getFacebookAppId <em>Facebook App Id</em>}</li>
 *   <li>{@link org.soluvas.socmed.FacebookSysConfig#getFacebookAppSecret <em>Facebook App Secret</em>}</li>
 *   <li>{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantAccessToken <em>Facebook Tenant Access Token</em>}</li>
 *   <li>{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPageId <em>Facebook Tenant Page Id</em>}</li>
 *   <li>{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPublishEnabled <em>Facebook Tenant Publish Enabled</em>}</li>
 *   <li>{@link org.soluvas.socmed.FacebookSysConfig#getFacebookExplicitlyShared <em>Facebook Explicitly Shared</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface FacebookSysConfig extends EObject {

	/**
	 * Returns the value of the '<em><b>Facebook App Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Facebook App ID for this tenant, it's used for Facebook-based login/authentication and also for publishing actions using Facebook OpenGraph APIs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facebook App Id</em>' attribute.
	 * @see #setFacebookAppId(Long)
	 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig_FacebookAppId()
	 * @model
	 * @generated
	 */
	Long getFacebookAppId();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookAppId <em>Facebook App Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook App Id</em>' attribute.
	 * @see #getFacebookAppId()
	 * @generated
	 */
	void setFacebookAppId(Long value);

	/**
	 * Returns the value of the '<em><b>Facebook App Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Facebook App Secret for this tenant, it's used for Facebook-based login/authentication and also for publishing actions using Facebook OpenGraph APIs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facebook App Secret</em>' attribute.
	 * @see #setFacebookAppSecret(String)
	 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig_FacebookAppSecret()
	 * @model
	 * @generated
	 */
	String getFacebookAppSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookAppSecret <em>Facebook App Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook App Secret</em>' attribute.
	 * @see #getFacebookAppSecret()
	 * @generated
	 */
	void setFacebookAppSecret(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Tenant Access Token</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Facebook access token for the tenant/mall Facebook Page. This is a Page token, not a User token.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facebook Tenant Access Token</em>' attribute.
	 * @see #setFacebookTenantAccessToken(String)
	 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig_FacebookTenantAccessToken()
	 * @model
	 * @generated
	 */
	String getFacebookTenantAccessToken();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantAccessToken <em>Facebook Tenant Access Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Tenant Access Token</em>' attribute.
	 * @see #getFacebookTenantAccessToken()
	 * @generated
	 */
	void setFacebookTenantAccessToken(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Tenant Page Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Facebook Page ID for the tenant/mall Facebook Page. This is a Page ID, not a User ID.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facebook Tenant Page Id</em>' attribute.
	 * @see #setFacebookTenantPageId(String)
	 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig_FacebookTenantPageId()
	 * @model
	 * @generated
	 */
	String getFacebookTenantPageId();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPageId <em>Facebook Tenant Page Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Tenant Page Id</em>' attribute.
	 * @see #getFacebookTenantPageId()
	 * @generated
	 */
	void setFacebookTenantPageId(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Tenant Publish Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether features to publish to tenant's Facebook Page are enabled. This requires both the {@code facebookTenantAccessToken} and {@code facebookTenantPageId} to be filled properly.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facebook Tenant Publish Enabled</em>' attribute.
	 * @see #setFacebookTenantPublishEnabled(Boolean)
	 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig_FacebookTenantPublishEnabled()
	 * @model default="false"
	 * @generated
	 */
	Boolean getFacebookTenantPublishEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookTenantPublishEnabled <em>Facebook Tenant Publish Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Tenant Publish Enabled</em>' attribute.
	 * @see #getFacebookTenantPublishEnabled()
	 * @generated
	 */
	void setFacebookTenantPublishEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Facebook Explicitly Shared</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether publishing will use the "explicitly_shared" flag. Note: The Facebook App ID used must be prepared to support explicitly_shared, which requires additional approval from Facebook.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Facebook Explicitly Shared</em>' attribute.
	 * @see #setFacebookExplicitlyShared(Boolean)
	 * @see org.soluvas.socmed.SocmedPackage#getFacebookSysConfig_FacebookExplicitlyShared()
	 * @model default="false"
	 * @generated
	 */
	Boolean getFacebookExplicitlyShared();

	/**
	 * Sets the value of the '{@link org.soluvas.socmed.FacebookSysConfig#getFacebookExplicitlyShared <em>Facebook Explicitly Shared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Explicitly Shared</em>' attribute.
	 * @see #getFacebookExplicitlyShared()
	 * @generated
	 */
	void setFacebookExplicitlyShared(Boolean value);
} // FacebookSysConfig