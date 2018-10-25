package ru.mirea;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DateInjectorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DateInjectorApplication.class);
    }

    @Bean
    public BeanPostProcessor dateInjectorBeanPostProcessor(){
        return new DateInjectorBeanPostProcessor();
    }
}
