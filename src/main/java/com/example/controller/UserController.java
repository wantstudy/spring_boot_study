package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description:
 */
@RequestMapping("/user")
@RestController
public class UserController {


    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserInfo(){
        return userService.findAll();
    }

    @RequestMapping(value = "/getUserInfo/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo(@PathVariable(value = "id") String id){
        return userService.findById(Long.parseLong(id)).get();
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public User save(User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/delUser/{id}",method = RequestMethod.GET)
    public void save(@PathVariable(value = "id") String id){
        userService.deleteById(Long.parseLong(id));
    }


}
