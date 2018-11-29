package com.lhy.resultcrud.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {


    /**
     * 创建一个数据源，作用：为了让以下属性值绑定到DruidDataSource类的字段上
     * initialSize: 5
     * minIdle: 5
     * maxActive: 20
     * maxWait: 60000
     * timeBetweenEvictionRunsMillis: 60000
     * minEvictableIdleTimeMillis: 300000
     * validationQuery: SELECT 1 FROM DUAL
     * testWhileIdle: true
     * testOnBorrow: false
     * testOnReturn: false
     * poolPreparedStatements: true
     * #配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
     * filters: stat,wall,log4j
     * maxPoolPreparedStatementPerConnectionSize: 20
     * useGlobalDataSourceStat: true
     * connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
     * 如果使用springboot内置通过反射创建的以上这些自定义的属性值都绑定不上。
     *
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource bruid() {
        return new DruidDataSource();
    }


    /**
     * 配置Druid的监控
     * 1、配置一个管理后台的Servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());
        Map initParams = new HashMap();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "1");
        //默认允许所有访问
        initParams.put("allow", "");
        //拒绝某个ip不能访问
        initParams.put("deny", "192.168.130.1");

        servletRegistrationBean.setInitParameters(initParams);

        return servletRegistrationBean;
    }

    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
