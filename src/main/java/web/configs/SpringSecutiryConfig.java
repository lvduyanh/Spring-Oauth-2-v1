package web.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import web.services.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
@ComponentScan("web")
public class SpringSecutiryConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobal");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		// auth.authenticationProvider(authenticationProvider());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		// @formatter:off
//		http.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/login_check")
//			.defaultSuccessUrl("/home")
//			.failureUrl("/login")
//			.usernameParameter("usname")
//			.passwordParameter("password")
//			.and().logout()
//			.logoutUrl("/logout")
//			.logoutSuccessUrl("/login");
		// @formatter:on

//		http.authorizeRequests().antMatchers("/", "/login", "/create", "/create-user", "/oauth/token").permitAll();
//		http.authorizeRequests().antMatchers("/home").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//		http.authorizeRequests().antMatchers("/api/*").access("hasAnyRole('ROLE_ADMIN')");
//		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/denied");
//
//		http.rememberMe().key("supersecret").tokenValiditySeconds(5 * 60 * 60);

		System.out.println("Config");
	}

}
