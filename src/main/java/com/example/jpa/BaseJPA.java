package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description:
 */
@NoRepositoryBean
public interface BaseJPA<T,ID> extends JpaRepository<T,ID>,
        JpaSpecificationExecutor<T>,
        QuerydslPredicateExecutor<T>,
        Serializable {
}
