package com.example.common;

import com.example.common.bean.ApiResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author weiwei
 * @Description: 全局异常处理
 * @date 2018/12/2520:46
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e){
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }
}
