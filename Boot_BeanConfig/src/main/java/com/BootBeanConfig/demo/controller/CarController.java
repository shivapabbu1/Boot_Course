package com.BootBeanConfig.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BootBeanConfig.demo.service.Car;

@RestController
public class CarController {
 
	@Autowired
	private Car car;
	
	
	public CarController(Car car) {
		this.car=car;
	}
	
	@GetMapping("/car")
	public String getCar() {
		return car.getCar();
	}
}
