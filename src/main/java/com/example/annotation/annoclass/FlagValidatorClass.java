package com.example.annotation.annoclass;

import com.example.annotation.FlagValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/12/2422:01
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object>{

    private String values;

    //初始化values的值
    @Override
    public void initialize(FlagValidator flagValidator) {
        //将注解内配置的值赋值给临时变量
        this.values = flagValidator.values();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        String[] value_arr = values.split(",");
        boolean flag = false;

        //遍历对比有效值
        for (int i = 0; i < value_arr.length; i++) {
            if(value_arr[i].equals(value)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
