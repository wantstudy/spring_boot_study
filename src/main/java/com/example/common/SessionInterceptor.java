package com.example.common;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: 登录拦截器，只允许登陆用户访问
 * @date 2018/12/1122:04
 */
public class SessionInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if("/user/login".equals(request.getRequestURI()) || "/login".equals(request.getRequestURI()))
            return true;

        Object obj = request.getSession().getAttribute("_session_user");
        if(obj == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
