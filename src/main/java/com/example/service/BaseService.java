package com.example.service;


import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description:  初始化 JPAQueryFactory
 */
public class BaseService{

    @PersistenceContext
    protected EntityManager entityManager;

    protected JPAQueryFactory queryFactory;

    @PostConstruct
    public void init(){
        queryFactory = new JPAQueryFactory(entityManager);
    }

}
