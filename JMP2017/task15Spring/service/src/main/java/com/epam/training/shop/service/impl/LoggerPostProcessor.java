package com.epam.training.shop.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

@Component
public class LoggerPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		ReflectionUtils.doWithFields(bean.getClass(), new MyFieldProcessor(bean, beanName), new LoggerFieldFilter());

		return bean;
	}

	public static class MyFieldProcessor implements FieldCallback {

		private final Object bean;
		private final Object beanName;

		public MyFieldProcessor(Object bean, Object beanName) {
			super();
			this.bean = bean;
			this.beanName = beanName;
		}

		@Override
		public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
			InitLogger annotation = field.getAnnotation(InitLogger.class);

			if (field.getType().equals(org.slf4j.Logger.class)) {
				String loggerCategory = annotation.category();
				if ("".equals(loggerCategory)) {
					loggerCategory = bean.getClass().getName();
				}
				Logger logger = LoggerFactory.getLogger(loggerCategory);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, bean, logger);
			}
		}
	}

	private static class LoggerFieldFilter implements ReflectionUtils.FieldFilter {
		@Override
		public boolean matches(Field field) {
			InitLogger logger = field.getAnnotation(InitLogger.class);
			return null != logger;
		}
	}

}
