package com.example.service;

import com.example.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description: 查询service
 */
//调用自定义sql需注解Transactional
@Transactional
public interface IUserService extends BaseService<User,Long> {

    public List<User> findUsersByUserName(String UserName);

    //使用原生sql查询
    @Query(value = "select * from t_user_info where user_name like %?1%",nativeQuery = true)
    public List<User> findUsersNaviteLike(String UserName);


    @Modifying
    @Query(value = "delete from t_user_info where id = ?1 and user_name = ?2",nativeQuery = true)
    public void deleteUserByNaviteQuery(Long id,String userName);
}
