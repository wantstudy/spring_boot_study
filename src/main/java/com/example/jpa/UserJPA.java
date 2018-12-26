package com.example.jpa;

import com.example.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description:
 */
@Component
public interface UserJPA extends BaseJPA<User,Long> {

    public List<User> findUsersByUserName(String UserName);

    public User findUserByUserName(String userName);

    //使用原生sql查询
    @Query(value = "select * from t_user_info where user_name like %?1%",nativeQuery = true)
    public List<User> findUsersNaviteLike(String UserName);


    @Modifying
    @Query(value = "delete from t_user_info where id = ?1 and user_name = ?2",nativeQuery = true)
    public void deleteUserByNaviteQuery(Long id,String userName);
}
