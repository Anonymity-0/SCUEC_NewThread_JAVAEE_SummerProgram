<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%@include file="/pages/common/head.jsp"%>
	<script>
		
	</script>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color: #ff0000;
	}

	input {
		text-align: center;
	}
</style>
	
</head>
<body>

		<div id="header">
			<span class="wel_word">编辑</span>
			<%@include file="/pages/common/login_success_menu.jsp"%>
		</div>
		<div id="main">
			<form action="user/ArticleServlet",method="get">
				<input type="hidden" name="action" value="${empty param.id?"add":"update"}"/>
				<table>
					<tr>
						<td>标题</td>
						<td></td>
						<td>作者</td>
						<td>作者id</td>
						<td>类别</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td><input name="header" type="text" value="${requestScope.article.header}"/></td>
						<td><input name="id" type="hidden" value="${requestScope.article.id}"/></td>
						<td><input name="author" type="hidden" value="${sessionScope.user.username}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>
				</table>
				<textarea name="content" rows="20" cols="210" >${requestScope.article.content} </textarea>
			</form>

		</div>

		<div id="bottom">
		</div>
</body>
</html>