//package com.example.demo.commons.spring;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ConversionServiceFactoryBean;
//import org.springframework.core.convert.converter.Converter;
//
//@Configuration  
//public class PropertiesConfig {
//	@Bean(name="conversionService")  
//    public ConversionServiceFactoryBean getConversionService() {  
//        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();  
//        Set<Converter> converters = new HashSet<>();  
//        converters.add(new StringToDateConverter());  
//        bean.setConverters(converters);  
//        return bean;  
//    }  
//}
