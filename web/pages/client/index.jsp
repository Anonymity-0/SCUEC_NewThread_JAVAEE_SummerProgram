<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<Script type="text/javascript">
		$(function () {
			// 给加入购物车按钮绑定单击事件
			$(".collect").click(function () {
				/**
				 * 在事件响应的function函数 中，有一个this对象，这个this对象，是当前正在响应事件的dom对象
				 * @type {jQuery}
				 */
				var id = $(this).attr("articleId");
				var header = $(this).attr("header");
				var username = $(this).attr("author");
				location.href =	"http://localhost:8080/program/collectServlet?action=add&id="+id+"&header="+header+"&username="+username;

			});
			$(".attention").click(function () {
				var username = $(this).attr("username");
				location.href =	"http://localhost:8080/program/attentionServlet?action=add&username="+username;

			});
		});
	</Script>
</head>
<body>
	
	<div id="header">
			<div>
				<%--如果用户还没有登录，显示     【登录 和注册的菜单】 --%>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a> ;
					<a href="/program/pages/manager/manager.jsp">后台管理</a>
				</c:if>
				<%--如果已经登录，则显示 登录 成功之后的用户信息。--%>
				<c:if test="${not empty sessionScope.user}">
					<%@include file="/pages/common/login_success_menu.jsp"%>
				</c:if>
			</div>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="indexServlet?action=search" method="post">
					标题：<input id="user_header" type="text" name="header" value="${requestScope.header}">
					作者：<input id="author" type="text" name="author" value="${requestScope.author}">
					id：<input id="id" type="text" name="id" value="${requestScope.id==0?"":requestScope.id}">
					<input type="submit" value="查询" />
				</form>
			</div>

			<c:forEach items="${requestScope.articles}" var="article">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="" />
				</div>
				<div class="book_info">
					<div class="header">
						<span class="sp1">标题:</span>
						<span class="sp2"><a href="	http://localhost:8080/program/user/ArticleServlet?action=article&id=${article.id}">${article.header}</a></span>
						<button articleId="${article.id}" header="${article.header}" author="${article.author}" class="collect">收藏</button>
					</div>

					<div class="author">
						<span class="sp1">作者:</span>
						<span class="sp2">${article.author}</span>
						<button username="${article.author}" class="attention">关注</button>
					</div>
				</div>
			</div>
			</c:forEach>

			</div>
		</div>

</body>
</html>