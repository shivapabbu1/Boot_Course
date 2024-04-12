package com.Boot_BeansScope.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootBeansScopeApplication {

	public static void main(String[] args) {
		var context=SpringApplication.run(BootBeansScopeApplication.class, args);
		SingletonScope sc=    context.getBean(SingletonScope.class);
		sc.getScope();
		System.out.println(sc.hashCode());
		
		SingletonScope sc1=    context.getBean(SingletonScope.class);
		sc1.getScope();
		System.out.println(sc1.hashCode());
		
		SingletonScope sc2=    context.getBean(SingletonScope.class);
		sc2.getScope();
		System.out.println(sc2.hashCode());
		
PrototypeScope pr=context.getBean(PrototypeScope.class);
pr.getScope();
System.out.println(pr.hashCode());
PrototypeScope pr1=context.getBean(PrototypeScope.class);
pr1.getScope();
System.out.println(pr1.hashCode());
PrototypeScope pr2=context.getBean(PrototypeScope.class);
pr2.getScope();
System.out.println(pr2.hashCode());
	}

}
