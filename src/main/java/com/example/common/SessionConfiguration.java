package com.example.common;

import com.example.application.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/12/1122:11
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurationSupport{

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        System.out.printf("------------SessionConfiguration");
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
