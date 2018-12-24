package com.example.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/17 0017
 * @Description:
 */
@Data
@Entity
@Table(name = "t_user_role_info")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "role_id")
    private int roleId;
}
