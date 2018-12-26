# spring_boot_study

`从零开始,学习SpringBoot` 学习文档 http://47.93.232.108:3000/#/study/java/springBoot

## 控制层,接口层编写
实体类: [User](/src/main/java/com/example/entity/User.java)

控制层: [UserController](/src/main/java/com/example/controller/UserController.java)

接口层: [IUserService](/com/example/dao/IUserService.java)

## 使用druid做项目数据源,使用druid监控
主类 :[DruidConfigure](/com/example/configure/DruidConfigure.java)

## fastjson 转换输出数据
主类 :[FastJsonMessageConvert](/com/example/configure/FastJsonMessageConvert.java)

配置类: [BaseConfiguration](/com/example/configure/BaseConfiguration.java)
    
    重写 configureMessageConverters 方法

## intercepter 拦截器(登陆)
主类: [LoginController](/src/main/java/com/example/application/LoginController.java)

配置类: [BaseConfiguration](/com/example/configure/BaseConfiguration.java)
    
    重写 addInterceptors 方法

## validator 校验

实体类： [UserEntityVo](/com/example/entity/vo/UserEntityVo)

### 自定义注解

注解： [FlagValidator](com/example/nnotation/FlagValidator)
注解配置类： [FlagValidatorClass](com/example/annotation/annoclass/FlagValidatorClass)

## 全局异常处理

实体类：[ApiResult](com/example/common/bean/ApiResult)
生成工具类：[ApiResultGenerator](com/example/common/ApiResultGenerator)