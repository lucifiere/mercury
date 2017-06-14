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
    <title>菜单详情</title>
    <meta name="description" content="菜单管理">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Cache" content="no-cache">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/admin/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="${pageContext.request.contextPath}/static/admin/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/admin/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/admin/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin/menu.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>

<body onload="checkValid()">
<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            菜单管理
        </ul>
        <dl class="am-icon-home" style="float: right;">
            当前位置： 系统管理 > 菜单管理 > 编辑菜单
        </dl>

    </div>

    <div class="fbneirong">
        <spring:form commandName="menu" action="/menu/edit" cssClass="am-form" id="menuForm" method="post">
            <spring:hidden path="id"/>
            <spring:hidden path="isValid"/>
            <div class="am-form-group am-cf">
                <div class="zuo">名称：</div>
                <div class="you">
                    <spring:input path="name" cssClass="am-input-sm" placeholder="请输入名称" maxlength="15"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">编号：</div>
                <div class="you">
                    <spring:input path="code" cssClass="am-input-sm" placeholder="请输入编号" maxlength="10"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">级别：</div>
                <div class="you">
                    <spring:radiobutton path="level" onchange="pCodeValidCheck()" cssClass="am-input-sm" value="1"/>&nbsp;&nbsp;系统（Sys）
                    <spring:radiobutton path="level" onchange="pCodeValidCheck()" cssClass="am-input-sm" value="2"/>&nbsp;&nbsp;功能（Func）
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">父编号：</div>
                <div class="you">
                    <spring:input path="parentCode" cssClass="am-input-sm" placeholder="请输入父编号"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">可见性：</div>
                <div class="you">
                    <spring:radiobutton path="isVisible" cssClass="am-input-sm" value="1"/> &nbsp; 可见&nbsp;&nbsp;
                    <spring:radiobutton path="isVisible" cssClass="am-input-sm" value="0"/> &nbsp; 不可见&nbsp;&nbsp;
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">排序标识：</div>
                <div class="you">
                    <spring:input path="sortId" cssClass="am-input-sm" onchange="sortIdCheck()"
                                  placeholder="请输入排序标识，只能为大于0的整数"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">URL：</div>
                <div class="you">
                    <spring:input path="url" cssClass="am-input-sm" placeholder="请输入路径地址" maxlength="100"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">描述：</div>
                <div class="you">
                    <spring:input path="remark" cssClass="am-input-sm" placeholder="请输入菜单描述" maxlength="100"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you" style="margin-left: 11%;">
                    <button type="submit" class="am-btn am-btn-success am-radius" onclick="editMenu()">发布</button>&nbsp;
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