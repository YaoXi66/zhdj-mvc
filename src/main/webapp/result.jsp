<%--
  Created by IntelliJ IDEA.
  User: 18766
  Date: 2022/5/9
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%--解决忽略el表达式--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@page pageEncoding="utf-8"
        contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>文件的上传与下载</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<p>下载刚才上传的文件</p>
<a href="download?filename=${user.avatar.originalFilename }">下载文件</a>
</body>
</html>
</body>
</html>
