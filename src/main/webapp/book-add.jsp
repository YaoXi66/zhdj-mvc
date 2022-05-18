<%--
  Created by IntelliJ IDEA.
  User: 18766
  Date: 2022/4/29
  Time: 10:56
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
    <h4>添加图书信息</h4>
    <form action="users/book" method="post" enctype="multipart/form-data">
        <p>图书id:<input type="text" name="book_id"/></p>
        <p>图书名称:<input type="text" name="title"/></p>
        <p>图书作者:<input type="text" name="author"/></p>
        <p>图书简介:<input type="text" name="introduce"/></p>
        <p>图书封面:<input type="text" name="img_src"/></p>
<%--        <p>图书封面:<input type="file" name="file"/></p>--%>
        <p><input type="submit" value="提交"/></p>
    </form>

    <h3>超链接提交</h3>
    <a herf="book/add?bookName=java">url提交</a>

    <h3>AJAX提交</h3>
    <input type="button" value="ajax提交" id="btn1" >
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">

        $("#btn1").click(function () {
            var obj = {};
            obj.title = "python";
            obj.author = "杰哥";
            obj.introduce = "杰哥不要啊";
            obj.img_src="www.axios.com"

            $.ajax({
                //请求行传值
                url: "redclass/book",
                // url: "book/add?name=java&author=lisi&price=3.33",
                // url: "book/list",
                type: "post",
                //请求头传值
                // headers:{
                //     token:"nmsl"
                // },
                // 请求体传值
                data:JSON.stringify(obj),
                dataType:"json",
                contentType: "application/json",
                success: function (res) {
                    console.log(res);
                }
            });
        });
    </script>
</body>
</html>
