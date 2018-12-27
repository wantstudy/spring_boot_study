package com.example.configure;

import com.example.service.impl.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/25 0025
 * @Description:
 */
@Configuration
public class WebsecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected UserDetailsService userDetailsService() {
        return new UserService();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated() //所有请求登陆后可以访问
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll() //登陆页面,错误页面可直接访问
                .and()
                    .logout()
                    .permitAll()
                ; //登出请求直接访问
    }

}
