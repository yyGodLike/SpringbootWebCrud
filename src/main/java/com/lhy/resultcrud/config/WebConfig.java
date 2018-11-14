package com.lhy.resultcrud.config;

import com.lhy.resultcrud.component.MyLocaleResolver;
import com.lhy.resultcrud.component.MyWebMvcConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spingboot 配置类
 */
@Configuration
public class WebConfig {


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new MyWebMvcConfig();
    }


    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }




}
