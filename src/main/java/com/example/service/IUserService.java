package com.example.service;

import com.example.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description: 查询service
 */
public interface IUserService {

    public List<User> findUsersByUserName(String UserName);

    public List<User> findUsersNaviteLike(String UserName);

    public void deleteUserByNaviteQuery(Long id,String userName);

    List<User> findAll();

    List<User> findAll(PageRequest pageRequest);

    List<User> findAll(Example pageRequest);

    User findById(long l);

    List<User> findUsersInfo(PageRequest pageRequest);

    User save(User user);

    void deleteById(long l);
}
