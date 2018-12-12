# spring_boot_study

`从零开始,学习SpringBoot` 学习文档 http://47.93.232.108:3000/#/study/java/springBoot

## 控制层,接口层编写
实体类: [User](/src/main/java/com/example/entity/User.java)

控制层: [UserController](/src/main/java/com/example/controller/UserController.java)

接口层: [IUserService](/src/main/java/com/example/service/IUserService.java)

## 使用druid做项目数据源,使用druid监控
主类 :[DruidConfigure](/src/main/java/com/example/common/DruidConfigure.java)

## fastjson 转换输出数据
主类 :[FastJsonMessageConvert](/src/main/java/com/example/common/FastJsonMessageConvert.java)

配置类: [BaseConfiguration](/src/main/java/com/example/common/BaseConfiguration.java)
    
    重写 configureMessageConverters 方法

## intercepter 拦截器(登陆)
主类: [LoginController](/src/main/java/com/example/application/LoginController.java)

配置类: [BaseConfiguration](/src/main/java/com/example/common/BaseConfiguration.java)
    
    重写 addInterceptors 方法


