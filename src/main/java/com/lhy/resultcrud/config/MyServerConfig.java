package com.lhy.resultcrud.config;


import com.lhy.resultcrud.filter.MyFilter;
import com.lhy.resultcrud.listener.MyListener;
import com.lhy.resultcrud.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 自定义服务配置类，配置servlet，filter，listener这三大组件,替代web.xml。
 * 配置嵌入式的servlet容器，也可以通过application.properties文件进行配置。
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }


    /**
     * 注册filter
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        FilterRegistrationBean registrationBean =
                new FilterRegistrationBean();
        //注册filter
        registrationBean.setFilter(new MyFilter());
        //添加filter要过滤的请求URL
        registrationBean.setUrlPatterns(Arrays.asList("/myServlet"));
        return registrationBean;
    }

    /**
     * 注册Listener
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myServletListenerRegistrationBean() {

        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean =
                new ServletListenerRegistrationBean<>(new MyListener());
        return servletListenerRegistrationBean;
    }


    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8080);
                container.setSessionTimeout(60);
            }
        };
    }

}
