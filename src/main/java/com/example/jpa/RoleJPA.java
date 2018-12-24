package com.example.jpa;

import com.example.entity.Role;
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
public interface RoleJPA extends BaseJPA<Role,Long> {
}
