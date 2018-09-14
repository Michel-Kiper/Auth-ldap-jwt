package cl.bice.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

import static cl.bice.auth.config.Constantes.LOGIN_URL;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	

    @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
			.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
			
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.groupSearchBase("ou=groups")
			.contextSource()
				.url("ldap://localhost:8389/dc=springframework,dc=org")
				.and()
			.passwordCompare()
				.passwordEncoder(new LdapShaPasswordEncoder())
				.passwordAttribute("userPassword");  
	}
	
	
}
