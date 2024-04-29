package com.JWTPractice.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JWTPractice.demo.Entity.AuthRequest;
import com.JWTPractice.demo.Entity.User;
import com.JWTPractice.demo.service.JwtService;
import com.JWTPractice.demo.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/app")

  public class UserController {
	
	 @Autowired
	    private UserService userService;
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private JwtService jwtService;

	    @GetMapping("/welcome")
	    public String welcome(){
	        return "Welcome to Spring Security tutorials !!";
	    }

	    @PostMapping("/register")
	    public String addUser(@RequestBody User user){
	        return userService.regUser(user);

	    }
	    @PostMapping("/login")
	    public String addUser(@RequestBody AuthRequest authRequest){
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if(authenticate.isAuthenticated()){
	            return jwtService.generateToken(authRequest.getUsername());
	        }else {
	            throw new UsernameNotFoundException("Invalid user request");
	        }
	    }
	    
	    @GetMapping("/getUsers")
	    @PreAuthorize("hasAuthority('ADMIN')")
	    public List<User> getAllUsers(){
	        return userService.getAllUser();
	    }
	    @GetMapping("/getUsers/{id}")
	    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
	    public User getAllUsers(@PathVariable Integer id){
	        return userService.getUser(id);
	    }
	

}
