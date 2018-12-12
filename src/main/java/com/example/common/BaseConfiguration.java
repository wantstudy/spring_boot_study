package com.example.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description: 返回json数据处理
 */
@Configuration
public class BaseConfiguration extends WebMvcConfigurationSupport{

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类配置
        super.configureMessageConverters(converters);
        //将fastjson添加到视图消息转换器列表内
        converters.add(FastJsonMessageConvert.getFastJsonConvert());
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
