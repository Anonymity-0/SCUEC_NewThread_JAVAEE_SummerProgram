<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>文章管理</title>
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
	<span class="wel_word">文章管理系统</span>
	<%@include file="/pages/common/login_success_menu.jsp"%>
</div>
<div>

</div>
<div class="book_cond">
	<form action="user/ArticleServlet?action=search" method="post">
		<input type="hidden" name="action" value="pageByPrice">
		标题：<input id="username" type="text" charset="UTF-8" name="header" value="${requestScope.header}">
		<input id="author" type="hidden" name="author" value="${sessionScope.user.username}">
		id：<input id="id" type="text" name="id" value="${requestScope.id==0?"":requestScope.id}">
		<input type="submit" value="查询" />
	</form>
</div>
<div id="main">
	<table>
		<tr>
			<td>标题</td>
			<td>作者</td>
			<td colspan="2">操作</td>
		</tr>
		<c:forEach items="${requestScope.articles}" var="artical">
			<tr>
				<td>${artical.header}</td>
				<td>${artical.id}</td>
				<td>${artical.author}</td>
				<td><a href="user/ArticleServlet?action=getArtical&id=${artical.id}">修改</a></td>
				<td><a class="deleteClass" href=user/ArticleServlet?action=delete&id=${artical.id} >删除</a></td>
			</tr>
		</c:forEach>


		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a href="pages/user/article_edit.jsp">添加图书</a></td>
		</tr>
	</table>
</div>

<div id="bottom">
		<span>
		</span>
</div>
</body>
</html>