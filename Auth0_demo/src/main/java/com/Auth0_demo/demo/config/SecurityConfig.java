package com.Auth0_demo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	         JwtWebSecurityConfigurer
	            .forRS256(audience, issuer)
	            .configure(http)
	            .authorizeHttRequests(authorize -> authorize
	                .reqMa("/api/welcome").permitAll() // Allow unauthenticated access to welcome endpoint
	                .antMatchers("/api/**").authenticated() // Secure other endpoints
	            );
	        return http.build();
	    }

}
