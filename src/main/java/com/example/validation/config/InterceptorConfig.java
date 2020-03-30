package com.example.validation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private RequestParamInterceptor requestParamInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(requestParamInterceptor).addPathPatterns("/api/student");
    }
}
