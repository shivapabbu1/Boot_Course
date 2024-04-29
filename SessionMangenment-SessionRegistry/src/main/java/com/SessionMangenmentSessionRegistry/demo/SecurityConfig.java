package com.SessionMangenmentSessionRegistry.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
   public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	   UserDetails user=User.builder().username("sunny").password(passwordEncoder.encode("user")).roles("USER").build();
	   UserDetails hr=User.builder().username("bunny").password(passwordEncoder.encode("hr")).roles("HR").build();
	   UserDetails admin=User.builder().username("funny").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
	   return new  InMemoryUserDetailsManager(user,hr,admin);
   }

 @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                		  .requestMatchers("/login", "/registration", "/secured", "/getSessionId", "/active-usernames", "/active-sessions", "/remove-session/**").permitAll()
                        .requestMatchers("/user").hasRole("USER")
                        .requestMatchers("/hr").hasRole("HR")
                        .requestMatchers("/adm").hasRole("ADMIN")
                        .requestMatchers("/secure/**").authenticated()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .successHandler((request, response, authentication) -> {
                            if (authentication.getAuthorities().stream()
                                    .anyMatch(r -> r.getAuthority().equals("ROLE_HR"))) {
                                response.sendRedirect("/hr");
                            } else if (authentication.getAuthorities().stream()
                                    .anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
                                response.sendRedirect("/user");
                            } 
                            else {
                                response.sendRedirect("/admin");
                            }
                        })
                )
                .logout((logout) -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
//                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/login?logout=true") 
                        .permitAll()
                )
                .sessionManagement(session -> session
                		
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(true)
                        .sessionRegistry(sessionRegistry())
                       
                    )
                
                .httpBasic(Customizer.withDefaults());

              
        return http.build();
    }
    
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    // Listener for sessionevent
    @Bean
    public HttpSessionEventPublisher eventPublisher() {
        return new HttpSessionEventPublisher();
    }
    
   
   
}
