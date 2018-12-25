package com.example.common;

import com.example.common.bean.ApiResult;

import java.util.List;

/**
 * @author weiwei
 * @Description: 生成ApiResult
 * @date 2018/12/2520:54
 */
public class ApiResultGenerator {

    /**
     * 创建普通消息方法
     * @param msg 返回消息内容
     * @param flag 执行状态
     * @param result 返回结构
     * @param jumpUrl 跳转路径
     */
    public static ApiResult result(String msg, boolean flag, Object result, int rows, String jumpUrl, Throwable throwable){
        ApiResult apiResult = ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setJumpUrl(jumpUrl);
        apiResult.setMsg(msg == ""?"执行成功":msg);
        apiResult.setResult(result);
        apiResult.setTime(System.currentTimeMillis());
        apiResult.setRows(rows);
        return apiResult;
    }


    /**
     * 执行成功后返回方法
     * @param result
     * @return
     */
    public static ApiResult successResult(Object result){
        int rows = 0;
        if(result instanceof List){
            rows = ((List) result).size();
        }
        return result("",true,result,rows,"",null);

    }

    /**
     * 执行失败后返回方法
     * @param msg
     * @return
     */
    public static ApiResult errorResult(String msg, Throwable throwable){
        return result(msg,false,"",0,"",throwable);

    }

}
