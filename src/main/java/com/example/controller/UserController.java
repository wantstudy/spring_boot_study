package com.example.controller;

import com.example.entity.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @RequestMapping(value = "/getUserInfoPage",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserInfoPage(User user){
        //Sort sort = new Sort();
        PageRequest pageRequest = PageRequest.of(user.getPage(),user.getSize());
        return userService.findAll(pageRequest).getContent();
    }

    @RequestMapping(value = "/getUserInfoSortPage",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserInfoSortPage(User user){
        Sort sort = new Sort(Sort.Direction.DESC,user.getSortSid());
        PageRequest pageRequest = PageRequest.of(user.getPage(),user.getSize(),sort);
        return userService.findAll(pageRequest).getContent();
    }


    @RequestMapping(value = "/getUserInfo/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo(@PathVariable(value = "id") String id){
        return userService.findById(Long.parseLong(id)).get();
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.GET)
    public User save(User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/delUser/{id}",method = RequestMethod.GET)
    public void save(@PathVariable(value = "id") String id){
        userService.deleteById(Long.parseLong(id));
    }

    @RequestMapping(value = "/findUsersLikeName/{userName}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findUserLikeName(@PathVariable("userName") String userName){
        return userService.findUsersNaviteLike(userName);
    }

    @RequestMapping(value = "/deleteUserByNaviteQuery",method = RequestMethod.GET)
    public void deleteUserByNaviteQuery(@RequestParam(value = "id") String id,@RequestParam(value = "userName") String userName){
        userService.deleteUserByNaviteQuery(Long.parseLong(id),userName);
    }
}
