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

    /**
     * 启动类加入注解 @EnableCaching
     * 需要缓存的方法加入 @Cacheable(cacheNames = "user"),存入的redis key= user::aa
     * 测试springboot redis
     */
    @Test
    public void findUsersByUserName(){
        userService.findUsersByUserName("aa");
    }


    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    /**
     * 性能测试
     * 10万次查询，100个线程同时操作findAll方法
     */
    @Test
    @PerfTest(invocations = 100000, threads = 100)
    public void contextLoads_redis() {
        userService.findUsersByUserName("aa");
    }

    /**
     * 普通方法测试,去掉 @Cacheable ,与性能测试对比
     */
    @Test
    @PerfTest(invocations = 100000, threads = 100)
    public void contextLoads() {
        userService.findUsersByUserName("aa");
    }
}