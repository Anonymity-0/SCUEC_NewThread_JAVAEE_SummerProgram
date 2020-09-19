<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑用户</title>
	<%@include file="/pages/common/head.jsp"%>
	<script>
		
	</script>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color:red;
	}

	input {
		text-align: center;
	}
</style>
	
</head>
<body>
		<div id="header">
			<span class="wel_word">编辑资料</span>
			<%@include file="/pages/common/login_success_menu.jsp"%>
		</div>
		<div id="main">
			<form action="user/userServlet",method="get",action="update">
				<input type="hidden" name="action" value="update"/>
				<table>
					<tr>
						<td>id</td>
						<td>用户名</td>
						<td>密码</td>
						<td> </td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="id" type="text" value="${requestScope.user.id}"/></td>
						<td><input name="username" type="text" value="${requestScope.user.username}"/></td>
						<td><input name="password" type="text" value="${requestScope.user.password}"/></td>
						<td><input name="" type="text" value=""/></td>
						<td><input type="submit" value="修改"/></td>
					</tr>
				</table>
			</form>

		</div>

		<div id="bottom">
		</div>
</body>
</html>