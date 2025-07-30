package com.hoan.springplayground.beanpostprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof MyService) {
            System.out.println("🔍 [BeforeInit] " + beanName + " → " + bean.getClass().getSimpleName());
        }

        return bean; // 반드시 bean 반환
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof MyService) {
            System.out.println("🔍 [AfterInit] " + beanName + " → " + bean.getClass().getSimpleName());
        }

        return bean;
    }
}
