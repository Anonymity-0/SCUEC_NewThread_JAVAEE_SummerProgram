<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2020/8/30
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function (){
            //确认删除提示
            $("a.deleteClass").click(function () {
                return confirm("你确定要删除？");
            })
        })
    </script>
</head>
<body>

<div id="header">
    <span class="wel_word">用户管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <div class="book_cond">
        <form action="manager/userServlet" method="post">
            <input type="hidden" name="action" value="search">
            用户名：<input id="username" type="text" name="username" value="${requestScope.username}">
            <input type="submit" value="查询" />
        </form>
    </div>
    <table>
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>密码</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><a href="manager/userServlet?action=getUser&id=${user.id}">修改</a></td>
                <td><a class="deleteClass" href="manager/userServlet?action=delete&id=${user.id}" >删除</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="/program/pages/manager/user_edit.jsp">添加</a></td>
        </tr>
    </table>
</div>

<div id="bottom">
		<span>
		</span>
</div>
</body>
</html>
