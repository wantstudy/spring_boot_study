package com.example.service.impl;

import com.example.entity.*;
import com.example.jpa.UserJPA;
import com.example.service.BaseService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description:
 */
@Service
public class UserService extends BaseService implements IUserService{

    @Autowired
    private UserJPA userJPA;

    @Cacheable(cacheNames = "user")
    @Override
    public List<User> findUsersByUserName(String UserName) {
        return userJPA.findUsersByUserName(UserName);
    }

    @Override
    public List<User> findUsersNaviteLike(String UserName) {
        return userJPA.findUsersNaviteLike(UserName);
    }

    @Override
    public void deleteUserByNaviteQuery(Long id, String userName) {
        userJPA.deleteUserByNaviteQuery(id,userName);
    }

    @Override
    public List<User> findAll() {
        return userJPA.findAll();
    }

    @Override
    public List<User> findAll(PageRequest pageRequest) {
        return userJPA.findAll(pageRequest).getContent();
    }

    @Override
    public List<User> findAll(Example example) {
        return userJPA.findAll(example);
    }

    @Override
    public User findById(long l) {
        return userJPA.findById(l).get();
    }

    @Override
    public List<User> findUsersInfo(PageRequest pageRequest) {
        QUser qUser = QUser.user;
        QRole qrole = QRole.role;
        QUserRole qUserRole = QUserRole.userRole;

        return queryFactory
                .select(qUser)
                .leftJoin(qrole).on(qUser.id.eq(qUserRole.id))
                .fetch();

    }

    @Override
    public User save(User user) {
        return userJPA.save(user);
    }

    @Override
    public void deleteById(long l) {
        userJPA.deleteById(l);
    }
}
