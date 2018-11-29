package com.lhy.resultcrud.component;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义额外的WebMvcConfig配置类，springboot自动配置的mvcConfig也会生效
 */
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加视图映射器，发送某个请求时转发到指定的视图
     * spingboot的视图解析器会将spring.mvc.view.prefix+viewname+spring.mvc.view.suffix拼接起来。
     * springmvc的xml文件配置
     * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * <property name="prefix" value="/templates"></property>
     * <property name="suffix" value=".html"></property>
     * </bean>
     * 前缀就是templates目录，后缀就是.html。
     * 也可以在application.properties文件中更改前缀与后缀。
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //指定浏览器请求某个路径是直接转发到指定的viewname
        //比如浏览器请求/自动转发到login.html界面。
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**") //配置要拦截的请求
                .excludePathPatterns("/login.html", "/", "/user/login"); //配置不拦截的请求
    }
}
