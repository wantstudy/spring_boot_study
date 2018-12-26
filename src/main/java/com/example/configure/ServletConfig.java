package com.example.configure;

import com.example.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/25 0025
 * @Description: 加入servlet支持
 */

//方法1
/*@Configuration
public class ServletConfig {

    @Bean
    public  ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new TestServlet(),"/servletTest");
    }
}*/


//方法2 开启自动装配servelt,装配依赖 @WebServlet
@Configuration
@ServletComponentScan(basePackages = "com.example")
public class ServletConfig {

}