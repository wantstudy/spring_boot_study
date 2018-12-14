package com.example.service;


import com.example.entity.Goods;

import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/11 0011
 * @Description: 查询service
 */
public interface IGoodsService {


    List<Goods> getGoodsList(Goods goods);

    List<Goods> getGoodsListByType(Goods goods);

    List<Goods> getGoodsListByDSL(Goods goods);

    List<Goods> getGoodsListByInq(Goods goods);
}
