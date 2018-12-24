package com.example.controller;

import com.example.entity.Goods;
import com.example.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description:
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    /**
     * spring-data-jpa 一对一查询
     * @param goods
     * @return
     */
    @RequestMapping(value = "/getGoodsList", method = RequestMethod.GET)
    public List<Goods> getGoodsList(Goods goods){

        return  goodsService.getGoodsList(goods);
    }
    /**
     * spring-data-jpa 一对一查询
     * @param goods
     * @return
     */
    @RequestMapping(value = "/getGoodsListByType", method = RequestMethod.GET)
    public List<Goods> getGoodsListByType(Goods goods){
        return  goodsService.getGoodsListByType(goods);
    }

    /**
     * jpa 结合 dsl 查询
     * @param goods
     * @return
     */
    @RequestMapping(value = "/getGoodsListByDSL", method = RequestMethod.GET)
    public List<Goods> getGoodsListByDSL(Goods goods){
        return  goodsService.getGoodsListByDSL(goods);
    }

    /**
     * 封装 jpa 结合 dsl 查询
     * @param goods
     * @return
     */
    @RequestMapping(value = "/getGoodsListByInq", method = RequestMethod.GET)
    public List<Goods> getGoodsListByInq(Goods goods){
        return  goodsService.getGoodsListByInq(goods);
    }
}
