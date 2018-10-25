package ru.mirea;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DateInjectorBeanPostProcessor implements BeanPostProcessor {
    
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BEAN NAME: " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
