package com.example.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description:
 */
public class BaseService{

    @PersistenceContext
    protected EntityManager entityManager;

}
