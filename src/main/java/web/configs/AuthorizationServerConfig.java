package web.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import web.globalvars.JwtVariable;
import web.globalvars.ServerConfigVar;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private ServerConfigVar serverConfigVar;

	@Autowired
	private JwtVariable jwtVariable;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(jwtVariable.getSECRET());
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		System.out.println("configure " + serverConfigVar.getClientID());
		configurer.inMemory().withClient(serverConfigVar.getClientID()).secret(serverConfigVar.getClientSecret())
				.authorizedGrantTypes(serverConfigVar.getGrantType(), serverConfigVar.getAuthorizationCode(),
						serverConfigVar.getRefeshToken(), serverConfigVar.getImplicit())
				.scopes("user_info")
				.accessTokenValiditySeconds(serverConfigVar.getAccessTokenValidTime())
				.refreshTokenValiditySeconds(serverConfigVar.getRefeshTokenValidTime()).autoApprove(true)
				.redirectUris("http://localhost:8080/testoauth2/login", "https://www.getpostman.com/oauth2/callback");
		
//		configurer.inMemory()
//        .withClient(serverConfigVar.getClientID())
//        .secret(serverConfigVar.getClientSecret())
//        .authorizedGrantTypes(serverConfigVar.getGrantType())
//        .scopes("user_info")
//        .accessTokenValiditySeconds(serverConfigVar.getAccessTokenValidTime())
//        .autoApprove(true) 
//        .redirectUris("http://localhost:8080/testoauth2/login");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.accessTokenConverter(accessTokenConverter());
	}

//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//		System.out.println("test");
//		oauthServer.allowFormAuthenticationForClients();
//	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

}
