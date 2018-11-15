package web.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import web.globalvars.ServerConfigVar;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private ServerConfigVar serverConfigVar;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(serverConfigVar.getResourceID()).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("configure resource server");
		
		http.authorizeRequests().antMatchers("/api/*").access("hasRole('ADMIN')").and().exceptionHandling()
				.accessDeniedPage("/oauthdenied");
		http.authorizeRequests().antMatchers("/", "/login", "/create", "/create-user", "/oauth/token", "/oauth/authorize", "/oauth/confirm_access").permitAll();
		http.formLogin().loginPage("/login").loginProcessingUrl("/login_check").defaultSuccessUrl("/home")
				.failureUrl("/login").usernameParameter("usname").passwordParameter("password").and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/login");
		http.authorizeRequests().antMatchers("/home").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
	}

}
