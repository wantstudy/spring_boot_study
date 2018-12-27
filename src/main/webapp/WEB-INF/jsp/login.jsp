<%--
  Created by IntelliJ IDEA.
  User: wangweiwei
  Date: 2018/12/11
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    用户名：<input type="text" name="username"/>
    密码：<input type="password" name="password"/>
    <input type="submit" value="登陆">
</form>
</body>
</html>
