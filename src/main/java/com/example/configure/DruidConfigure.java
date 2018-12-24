package com.example.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description: druid 监控配置
 * 访问路径 localhost:8081/druid/login.html
 */
@Configuration
public class DruidConfigure {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //设置黑名单
        servletRegistrationBean.addInitParameter("deny","");
        //设置控制台用户
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","druid");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.jpg,*,png,*.css,*.gif,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
