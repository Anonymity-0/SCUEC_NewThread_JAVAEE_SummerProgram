<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">关注</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>id</td>
				<td>用户名</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.attention}" var="attention">
				<tr>
					<td>${attention.id}</td>
					<td>${attention.username}</td>
					<td><a class="deleteClass" href=attentionServlet?action=delete&username=${attention.username} >删除</a></td>
				</tr>
			</c:forEach>



		</table>

	
	</div>
	
	<div id="bottom">
	</div>
</body>
</html>