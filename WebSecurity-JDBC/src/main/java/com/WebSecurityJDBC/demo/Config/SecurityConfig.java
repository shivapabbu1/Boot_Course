package com.WebSecurityJDBC.demo.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)->csrf.disable())
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/root","/log").permitAll()  
                .requestMatchers("/admin").hasAuthority("ADMIN")
                .requestMatchers("/user").hasAuthority("USER")
                .anyRequest().authenticated()
            )
            .formLogin(
                (form) -> form.loginPage("/log")
                .successHandler((request, response, authentication) -> {
                    if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"))) {
                        response.sendRedirect("/admin");
                    } else if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("USER"))) {
                        response.sendRedirect("/user");
                    } else {
                        response.sendRedirect("/root");
                    }
                })
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
    	 JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
         userDetailsManager.setUsersByUsernameQuery("SELECT username, password, 1 as enabled FROM stu_table WHERE username = ?");
         userDetailsManager.setAuthoritiesByUsernameQuery("SELECT username, role as authority FROM stu_table WHERE username = ?");
         return userDetailsManager;
    }
}
