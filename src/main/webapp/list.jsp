<%--
  Created by IntelliJ IDEA.
  User: 18766
  Date: 2022/5/3
  Time: 8:21
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

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

<body>

<div class="row" id="container"></div>
    <%--    屏幕大、中、小、超小显示6、4、3、2个--%>
<%--    <div class='col-lg-2 col-md-3 col-sm-4 col-xs-6'></div>--%>

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
    $.get("user/lists",function (res){
        for (let i = 0; i < res.length; i++) {
            let fn = res[i];
            let htmlStr="<div class='col-lg-2 col-md-3 col-sm-4 col-xs-6'><div class='thumbnail'><img src='imgs/"+fn+"' alt='...'><div class='caption'><p><a href='user/download?fname="+fn+"' class='btn btn-primary' role='button'>下载</a></p></div></div></div>"
            $("#container").append(htmlStr);
        }
        console.log(res)
    },"json");
</script>
</body>
</html>
