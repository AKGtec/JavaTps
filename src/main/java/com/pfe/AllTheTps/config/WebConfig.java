package com.pfe.AllTheTps.config;

import com.pfe.AllTheTps.Interceptors.UrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new UrlInterceptor());
    }
}
