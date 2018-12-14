package com.example.common;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: WangWeiWei
 * @Date: 2018/12/14 0014
 * @Description: 查询条件封装
 */
public class Inquirer {

    private List<BooleanExpression> expressionList;

    //初始化
    public Inquirer() {
        this.expressionList = new ArrayList<>();
    }

    //加入条件
    public Inquirer putExpression(BooleanExpression expression){
        expressionList.add(expression);
        return  this;
    }

    //构造查询条件
    public Predicate buildQuery(){
        BooleanExpression booleanExpression = null ;
        for (int i = 0; i < expressionList.size(); i++) {
            if(i==0){
                booleanExpression = expressionList.get(i);
            }else{
                booleanExpression = booleanExpression.and(expressionList.get(i));
            }
        }
        return  booleanExpression;
    }

    public <T> List<T> iterToList(Iterable<T> iterable){

        List<T> list = new ArrayList<T>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

}
