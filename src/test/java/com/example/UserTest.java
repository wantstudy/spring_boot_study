package com.example;

import com.example.entity.User;
import com.example.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/17 0017
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testGetUserRole() {
        List<User> usersInfo = userService.findUsersInfo(PageRequest.of(1, 20));
        usersInfo.forEach(user -> System.out.printf(user.getUserName()));
    }
}
