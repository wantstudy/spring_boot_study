<%--
  Created by IntelliJ IDEA.
  User: wangweiwei
  Date: 2018/12/12
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>单文件上传</h2>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>

<br/>
<br/>

<h2>多文件上传</h2>
<form action="/file/uploads" method="post" enctype="multipart/form-data">
    <input type="file" name="files"/><br/>
    <input type="file" name="files"/><br/>
    <input type="file" name="files"/><br/>
    <input type="submit" value="上传"/>
</form>

</body>
</html>
