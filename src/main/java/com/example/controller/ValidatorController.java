package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.vo.UserEntityVo;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/12/2421:30
 */
@RestController
@RequestMapping("/validator")
public class ValidatorController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/user")
    public JSONObject user(@Valid UserEntityVo userEntityVo, BindingResult result){
        JSONObject jsonObject = new JSONObject();
        if(result.hasErrors()){
            jsonObject.put("sucess",false);
            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();
            for(FieldError fieldError:fieldErrors){
               String msg = messageSource.getMessage(fieldError,locale);
               jsonObject.put(fieldError.getField(),msg);
            }
        }else{
            jsonObject.put("sucess",true);
        }
        return jsonObject;
    }

    @RequestMapping(value = "/divided/{num1}/{num2}")
    public String divided(@PathVariable(value = "num1") int num1,
                          @PathVariable(value = "num2") int num2){

        System.out.printf("num1/num2="+num1/num2);
        return num1/num2+"";
    }
}
