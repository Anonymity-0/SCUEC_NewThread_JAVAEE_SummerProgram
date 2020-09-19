<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="/pages/common/head.jsp"%>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .article .title {
            text-align: center;
            font-size: 28px;
            color: #565353;
            letter-spacing: 2px;
            margin-top:20px;
        }

    </style>

</head>
<body>
<div id="header">
    <%@include file="/pages/common/login_success_menu.jsp"%>
</div>
<!-- 内容区 -->
<div class='article'>
    <div class='title'> ${requestScope.article.header}</div>
    <div class='right mt32'>
        <div class='author'>
            作者：${requestScope.article.author}
        </div>
    </div>
    <div class='category'><span class='light-font'>分类：</span><span class='info'>没写</span></div>
    <hr/>
    <div class='content'>
        ${requestScope.article.content}
    </div>

</div>
</body>
</html>