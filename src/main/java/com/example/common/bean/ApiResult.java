package com.example.common.bean;

import lombok.Data;

/**
 * @author weiwei
 * @Description: 统一返回实体
 * @date 2018/12/2520:50
 */
public class ApiResult {

    //禁止new对象
    private ApiResult() {
    }

    public static ApiResult newInstance(){
        return  new ApiResult();
    }

    //消息提示
    private String msg;
    //状态信息
    private boolean flag = true;
    //返回结构
    private Object result;
    //查询出结构总数
    private int rows;
    //需要跳转的路径
    private String jumpUrl;
    //接口响应时间（毫秒）
    private long time;



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
