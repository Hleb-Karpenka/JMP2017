package com.epam.training.shop.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProfilingsBeanPostProcessor implements BeanPostProcessor {
	Map<String, Class> beanMap = new HashMap<String, Class>();

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Class beanClass = beanMap.get(beanName);
		if (beanClass!=null) {
			
			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					
					System.out.println("Profiling..");
					Object returnValue = method.invoke(bean, args);
					System.out.println("finish...");
					return returnValue;
				}
			} );
			
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(Profilings.class)){
			beanMap.put(beanName, bean.getClass());
		}
		return bean;
	}

}
