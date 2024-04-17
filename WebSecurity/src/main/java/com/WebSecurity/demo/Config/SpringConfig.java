package com.WebSecurity.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {
	
	//authnetication
	@Bean
    public UserDetailsService userDetailsService() {
    	
    	
    	UserDetails user = User.withUsername("pabbu")
    			.password("1234")
    			.roles("USER")
    			.build();
    	return new InMemoryUserDetailsManager(user);
 }
	
	//Authurization

		@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/welcome","/").permitAll()
				.requestMatchers("/one").authenticated()
				.requestMatchers("/two").authenticated()
			);
			
			return http.build();
	               
	        
	     

	       
	    }
	
	@Bean
	public  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	
	

  

	  
    
}
