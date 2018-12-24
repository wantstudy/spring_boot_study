package com.example.entity.vo;

import com.example.annotation.FlagValidator;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/12/2421:21
 */
@Data
public class UserEntityVo implements Serializable {

    @NotNull
    @Length(max = 20,min = 5)
    private String userName;


    @Min(value = 1)
    private int age;


    @NotBlank
    @Email
    private String email;

    //自定义校验，是否在 1  2  3 之中
    @FlagValidator(values = "1,2,3")
    private String flag;
}
