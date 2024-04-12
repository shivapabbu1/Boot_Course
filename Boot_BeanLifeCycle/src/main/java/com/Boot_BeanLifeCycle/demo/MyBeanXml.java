package com.Boot_BeanLifeCycle.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyBeanXml implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("JavaConfig: Bean destroy was done ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("JavaConfig: Bean InitializingBean was done ");
    }
}
