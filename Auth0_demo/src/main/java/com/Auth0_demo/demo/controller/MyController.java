package com.Auth0_demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:5173")
public class MyController {
	
	

	    @GetMapping("/welcome")
	    public String welcome() {
	     return "welcome home page";
       }
	    
	    @GetMapping("/v1")
	    public String getCall() {
	     return "welcome user one page";
       }
	    
	    @GetMapping("/v2")
	    public String getdata() {
	     return "welcome user two page";
       }
}
