package ru.mirea;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInjectorBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for(Field field : bean.getClass().getDeclaredFields()) // get date and fullDate and more private and public filds.
        {
            // a lot of cost of CPU
            DateInject dateInject = field.getAnnotation(DateInject.class);
            if(dateInject != null) {
                String format = dateInject.format();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                String formattedDate = sdf.format(date); // threads-safe
                // sdf.parse(); threads-no-safe
                field.setAccessible(true); // get access for write.
                try {
                    field.set(bean, formattedDate);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }

    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Object proxy = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(bean, args); // need final bean.
                    }
                }
        );
        return proxy;
    }
}
