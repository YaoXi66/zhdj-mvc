<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="users/updateUser?id=1">xiugai</a>

<table width="100%" height="700">
    <tr>
        <td width="200" style="border-right: deepskyblue 2px solid;background: rgba(255,0,0,0.1)">
            <ul>
                <li><a href="book-add.jsp" target="mainFrame">上传图片</a></li>
                <li><a href="list.jsp" target="mainFrame">文件列表</a></li>
            </ul>
        </td>
        <td>
            <iframe name="mainFrame" width="100%" height="700" frameborder="0"></iframe>
        </td>
    </tr>
</table>
</body>
</html>
