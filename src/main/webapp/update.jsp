<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>资料修改</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="updateServlet" method="post">
    <%----%>
    <input type="hidden" name="id" value="${users.id}">

    姓名：<input name="name" value="${users.name}"><br>
    密码：<input name="pass" value="${users.pass}"><br>
    邮箱：<input name="email" value="${users.email}"><br>
    性别：<input name="sex" value="${users.sex}"><br>

    <input type="submit" value="提交">

</form>
</body>
</html>