package com.example.application;

import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/12/1121:16
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,User paramUser){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("password");
        List<User> userList = userService.findAll(Example.of(paramUser,exampleMatcher));
        if(userList.size() < 1)
            return "用户不存在";
        long count = userList.stream().filter(user ->
                paramUser.getUserName().equals(user.getUserName())
                        &&
                        paramUser.getPassword().equals(user.getPassword())
        ).count();
        if(count < 1)
            return "密码不正确";
        else
            request.getSession().setAttribute("_session_user",paramUser);
            return "登陆成功";
    }

}
