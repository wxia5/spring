package com.xd.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
@Configuration
@EnableWebMvc
@ComponentScan("com.xd")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {
@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
configurer.enable();
}
@Bean
public InternalResourceViewResolver getInternalResourceViewResolver() {
InternalResourceViewResolver resolver = new InternalResourceViewResolver();
resolver.setViewClass(JstlView.class);
resolver.setPrefix("/WEB-INF/jsp/");
resolver.setSuffix(".jsp");
return resolver;
}
@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    //◊‘∂®“Â≈‰÷√...
    //FastJsonConfig config = new FastJsonConfig();
    //config.set ...
    //converter.setFastJsonConfig(config);
    converters.add(0, converter);
}
}