package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/17 0017
 * @Description:
 */
@Data
@Entity
@Table(name = "t_user_role")
public class Role extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "role_name")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
