package com.example;

import com.example.common.RedisUtil;
import com.example.service.IUserService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    IUserService userService;

    @Test
    public void findAllUsers()  {
        redisUtil.setValue("key","hello");
    }


    @Test
    public void findAllUsers2()  {
        System.out.println("get key value:"+ redisUtil.getValue("key"));
    }

    @Test
    public void findUsersByUserName(){
        userService.findUsersByUserName("aa");
    }


    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    /**
     * 性能测试
     * 1万次查询，10个线程同时操作findAll方法
     */
    @Test
    @PerfTest(invocations = 10000, threads = 10)
    public void contextLoads_redis() {
        userService.findUsersByUserName("aa");
    }

    /**
     * 普通测试
     */
    @Test
    @PerfTest(invocations = 10000, threads = 100)
    public void contextLoads() {
        userService.findUsersByUserName("aa");
    }
}