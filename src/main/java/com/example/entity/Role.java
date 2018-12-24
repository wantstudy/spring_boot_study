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
@Table(name = "t_user_role")
public class Role extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "role_name")
    private String roleName;
}
