package com.example.service.impl;

import com.example.common.Inquirer;
import com.example.jpa.GoodsJPA;
import com.example.entity.Goods;
import com.example.entity.QGoods;
import com.example.service.BaseService;
import com.example.service.IGoodsService;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description:
 */
@Service
public class GoodsService extends BaseService implements IGoodsService{

    @Autowired
    private GoodsJPA goodsJPA;

    private QGoods qGoods = QGoods.goods;

    @Override
    public List<Goods> getGoodsList(Goods goods) {

        JPAQuery<Goods> qGoodsJPAQuery = new JPAQuery<>(entityManager);

        return qGoodsJPAQuery
                .select(qGoods)
                .from(qGoods)
                .fetch();
    }

    @Override
    public List<Goods> getGoodsListByType(Goods goods) {

        JPAQuery<QGoods> qGoodsJPAQuery = new JPAQuery<>(entityManager);

        return qGoodsJPAQuery
                .select(qGoods)
                .from(qGoods)
                .where(qGoods.goodsType.id.eq(Long.valueOf("1")))
                .fetch();
    }

    @Override
    public List<Goods> getGoodsListByDSL(Goods goods) {
        //查询条件
        BooleanExpression booleanExpression = qGoods.goodsType.id.eq(Long.valueOf("2"));

        //执行查询
        Iterator<Goods> iterable = goodsJPA.findAll(booleanExpression).iterator();
        List<Goods> list = new ArrayList<>();
        while (iterable.hasNext()){
            list.add(iterable.next());
        }
        return list;
    }

    @Override
    public List<Goods> getGoodsListByInq(Goods goods) {
        Inquirer inquirer = new Inquirer();

        inquirer.putExpression(qGoods.goodsType.id.eq(Long.valueOf("2")));
        inquirer.putExpression(qGoods.id.eq(Long.valueOf("2")));

        return inquirer.iterToList(goodsJPA.findAll(inquirer.buildQuery()));
    }
}
