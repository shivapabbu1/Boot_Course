package com.SessionMangenmentCustomStore.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.SessionMangenmentCustomStore.demo.service.CustomPersonUserDetail;
import com.SessionMangenmentCustomStore.demo.service.PersonSecurityContextRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private PersonSecurityContextRepository contextRepository;
	
	@Autowired
	private CustomPersonUserDetail customPersonUserDetail;
	
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
//	@Bean
//	public UserDetailsService detailsService() {
//		UserDetails user=User.builder().username("user").password(passwordEncoder().encode("user")).roles("USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customPersonUserDetail);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf((csrf)->csrf.disable())
				.authorizeHttpRequests((authreq)->authreq
						.requestMatchers("/","/login","/data","/save","/sessdata").permitAll()
						.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
//				.formLogin((form)->form
//						.loginPage("/login").permitAll())
				.securityContext((sc)->sc
						.securityContextRepository(contextRepository)
						)
				.build();
	}

	

	@Bean
	public HttpSessionEventPublisher  httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
}
