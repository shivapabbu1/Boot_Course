package com.Boot_BeanLifeCycle.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
 @Bean(initMethod="init" ,destroyMethod="destroy")
 public MyBean myBean() {
	 return new MyBean();
 }
}
