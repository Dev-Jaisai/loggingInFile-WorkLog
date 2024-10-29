package com.customLogging.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
        System.out.println("Spring ApplicationContext initialized!"); // Debugging to check if context is set
    }

    public static <T> T getBean(Class<T> beanClass) {
        System.out.println("Retrieving bean: " + beanClass.getName()); // Debugging to check bean retrieval
        return context.getBean(beanClass);
    }
}
