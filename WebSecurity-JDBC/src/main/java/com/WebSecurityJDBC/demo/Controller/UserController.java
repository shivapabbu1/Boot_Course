package com.WebSecurityJDBC.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class UserController {
	
	  private final UserDetailsService userDetailsService;

	    @Autowired
	    public UserController(UserDetailsService userDetailsService) {
	        this.userDetailsService = userDetailsService;
	    }

	    @GetMapping("/log")
	    public String getlog() {
	        return "log";
	    }

    @GetMapping("/root")
    public String home() {
        return "root";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
}