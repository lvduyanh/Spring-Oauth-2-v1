package web.globalvars;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfigVar {

	@Value("${svcon.client_id}")
	private String clientID;

	@Value("${svcon.resource_id}")
	private String resourceID;

	@Value("${svcon.client_secret}")
	private String clientSecret;

	@Value("${svcon.grant_type}")
	private String grantType;

	@Value("${svcon.autho_code}")
	private String authorizationCode;

	@Value("${svcon.refesh_token}")
	private String refeshToken;

	@Value("${svcon.implicit}")
	private String implicit;

	@Value("${svcon.scope_read}")
	private String scopeRead;

	@Value("${svcon.scope_write}")
	private String scopeWrite;

	@Value("${svcon.trust}")
	private String trust;

	@Value("${svcon.access_token_valid_time}")
	private int accessTokenValidTime;

	@Value("${svcon.refesh_token_valid_time}")
	private int refeshTokenValidTime;

	public String getClientID() {
		return clientID;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getGrantType() {
		return grantType;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public String getRefeshToken() {
		return refeshToken;
	}

	public String getImplicit() {
		return implicit;
	}

	public String getScopeRead() {
		return scopeRead;
	}

	public String getScopeWrite() {
		return scopeWrite;
	}

	public String getTrust() {
		return trust;
	}

	public int getAccessTokenValidTime() {
		return accessTokenValidTime;
	}

	public int getRefeshTokenValidTime() {
		return refeshTokenValidTime;
	}

	public String getResourceID() {
		return resourceID;
	}
}
