package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description:
 */
@NoRepositoryBean
public interface BaseService<T> extends JpaRepository<T,Long>,
        JpaSpecificationExecutor<T>,
        Serializable{
}
