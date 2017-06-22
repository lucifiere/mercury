<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2017/6/9
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/jsp/common/base.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户详情</title>
    <meta name="description" content="用户管理">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Cache" content="no-cache">
    <script src="${pageContext.request.contextPath}/static/js/auth/user.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>

<body>
<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            用户管理
        </ul>
        <dl class="am-icon-home" style="float: right;">
            当前位置： 安全管理 > 用户管理 > 编辑用户
        </dl>

    </div>

    <div class="fbneirong">
        <spring:form commandName="user" action="/user/edit" cssClass="am-form" id="detailForm" method="post">
            <spring:hidden path="id"/>
            <spring:hidden path="isValid"/>
            <div class="am-form-group am-cf">
                <div class="zuo">账户（昵称）：</div>
                <div class="you">
                    <spring:input path="nickname" cssClass="am-input-sm" placeholder="请输入昵称" maxlength="15" width="20px"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">邮箱：</div>
                <div class="you">
                    <spring:input path="email" cssClass="am-input-sm" placeholder="请输入邮箱" maxlength="50" />
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">密码：</div>
                <div class="you">
                    <spring:password path="password" cssClass="am-input-sm" placeholder="请输入密码" maxlength="50"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">确认密码：</div>
                <div class="you">
                    <spring:password path="confirmPassword" cssClass="am-input-sm" placeholder="请确认密码" maxlength="50"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you" style="margin-left: 11%;">
                    <button type="button" class="am-btn am-btn-success am-radius" onclick="edit()">发布</button>&nbsp;
                    &nbsp;&nbsp;&nbsp;
                    <button type="button" class="am-btn am-btn-danger am-radius" onclick="window.history.go(-1)">取消
                    </button>
                </div>
            </div>
        </spring:form>
    </div>

    <div class="foods">
        <ul style="z-index: 999">
            Mercury管理后台
        </ul>
        <dl>
            <a href="#" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
        </dl>
    </div>

</div>
</body>

</html>