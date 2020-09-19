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
	<Script type="text/javascript">
		$(function () {
			// 给按钮绑定单击事件
			$(".expert").click(function () {
				location.href = "http://localhost:8080/program/ExcleServlet?action=export";
			});
		});
	</Script>
	<Script type="text/javascript">
		$(function () {
			// 给按钮绑定单击事件
			$(".import").click(function () {
				location.href = "http://localhost:8080/program/ExcleServlet?action=importExcle";
			});
		});
	</Script>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">文章管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	<div class="expert">
		<button  class="expert">导出</button>
	</div>
	<div class="import">
		<button  class="import">导入</button>
	</div>
	<div id="main">
		<div align="center">
			共有${requestScope.count}条文章
		</div>
		<div class="book_cond">
			<form action="manager/ArticleServlet?action=search" method="post">
				标题：<input id="username" type="text" charset="UTF-8" name="header" value="${requestScope.header}">
				作者：<input id="author" type="text" name="author" value="${requestScope.author}">
				id：<input id="id" type="text" name="id" value="${requestScope.id==0?"":requestScope.id}">
				<input type="submit" value="查询" />
			</form>
		</div>
		<table>
			<tr>
				<td>标题</td>
				<td>简介</td>
				<td>作者</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.articles}" var="artical">
			<tr>
				<td>${artical.header}</td>
				<td>${artical.id}</td>
				<td>${artical.author}</td>
				<td><a href="manager/ArticleServlet?action=getArtical&id=${artical.id}">修改</a></td>
				<td><a class="deleteClass" href="manager/ArticleServlet?action=delete&id=${artical.id}" >删除</a></td>
			</tr>
				</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/article_edit.jsp">添加文章</a></td>
			</tr>	
		</table>
	</div>
	<div id="bottom">
		<span>
			共有条文章
		</span>
	</div>
</body>
</html>