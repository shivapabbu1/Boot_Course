package com.SessionMangenment.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;


@Configuration
public class SecurityConfig {

   @Bean
   public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	   UserDetails user=User.builder().username("user").password(passwordEncoder.encode("user")).roles("USER").build();
	   UserDetails hr=User.builder().username("hr").password(passwordEncoder.encode("hr")).roles("HR").build();
	  
	   return new  InMemoryUserDetailsManager(user,hr);
   }

 @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                        .requestMatchers("/login","/getSessionId","/authenticate").permitAll()
                        .requestMatchers("/user").hasRole("USER")
                        .requestMatchers("/hr").hasRole("HR")
                        .requestMatchers("/admin").hasRole("ADMIN")
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
                                response.sendRedirect("/default");
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
                		 .sessionFixation(sessionFixation -> sessionFixation.newSession())
                		 .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    )
                
                .httpBasic(Customizer.withDefaults());

              
        return http.build();
    }
    
   
   
   
}
