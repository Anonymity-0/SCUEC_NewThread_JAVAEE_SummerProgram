<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/5
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>

    <span>欢迎<span class="um_span">${sessionScope.user.username}</span></span>
    <a href="collectServlet?action=list">我的收藏</a>
    <a href="user/ArticleServlet?action=list">我的文章</a>
    <a href="attentionServlet?action=list">我的关注</a>
    <a href="user/userServlet?action=getUser&id=${sessionScope.user.id}">我的信息</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="indexServlet?action=list">返回</a>
    <a href="/program/pages/manager/manager.jsp">后台管理</a>
</div>