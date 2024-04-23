package com.JWT_Security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmpController {
	
	@PostMapping("/addemp")
	public String addEmp(@RequestBody Emp emp) {
		 
		return null;
	}

}
