package com.Boot_BeansScope.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonScope {
	
	public  void getScope() {
		System.out.println("SingletonScope BEAN CREATED");
	}
}
