package com.Boot_BeanLifeCycle.demo;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MyBean  {

    @PostConstruct
    public void init() throws Exception {
        System.out.println("JavaConfig: Bean initialization was done by InitializingBean's afterPropertiesSet() method");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("JavaConfig: Bean destruction was done by DisposableBean's destroy() method");
    }
}
