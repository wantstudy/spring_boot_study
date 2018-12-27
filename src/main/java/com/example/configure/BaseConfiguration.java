package com.example.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description: 返回json数据处理
 */
@Configuration
public class BaseConfiguration extends WebMvcConfigurationSupport{

    /**
     * 返回json处理
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类配置
        super.configureMessageConverters(converters);
        //将fastjson添加到视图消息转换器列表内
        converters.add(FastJsonMessageConvert.getFastJsonConvert());
    }

    /**
     * 访问校验
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }


    /**
     * 增加跨域支持
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")    //配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
                .allowedMethods("*") //允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
                .allowedOrigins("*") //允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
                .allowedHeaders("*");//允许所有的请求header访问，可以自定义设置任意请求头信息
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
    }




}
