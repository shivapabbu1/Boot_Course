package com.SessionMangenmentCustomStore.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
	
	@GetMapping("/log")
	public String getlog() {
		return "login";
	}

}
