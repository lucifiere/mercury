<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/base.jsp" %>

<!DOCTYPE html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="后台登录">
    <meta name="author" content="XD.Wang">
    <meta http-equiv="Cache-Control" content="max-age=7200">
    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/auth/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/auth/css/supersized.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/auth/css/style.css">
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>

<body>

<input type="hidden" id="msg" value="${result.msg}">

<div class="page-container">
    <h1>Login</h1>
    <form action="/auth/login" method="post" id="login-form">
        <input type="text" name="nickname" id="nickname" class="username" value="<shiro:principal/>" placeholder="账号">
        <input type="password" name="password" id="password" class="password" placeholder="密码">
        <button type="submit">登录</button>
        <div class="error"><span>+</span></div>
    </form>
    <div class="connect">
        <p>联系我: lucifiere@126.com</p>
        <p></p>
    </div>
</div>
<div align="center"><a href="" target="_blank" title="XD.Wang">Designed by -> XD.Wang</a></div>

<!-- Javascript -->
<script src="${pageContext.request.contextPath}/static/lib/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/lib/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/login/supersized-init.js"></script>
<script src="${pageContext.request.contextPath}/static/js/login/scripts.js"></script>
<script src="${pageContext.request.contextPath}/static/js/login/login.js"></script>
</body>

</html>

