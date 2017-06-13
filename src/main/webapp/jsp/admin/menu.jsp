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
    <title>菜单管理</title>
    <meta name="description" content="菜单管理">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/static/admin/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="${pageContext.request.contextPath}/static/admin/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/admin/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/admin/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/admin/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin/menu.js"></script>
</head>

<body>
<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            菜单管理
        </ul>
        <dl class="am-icon-home" style="float: right;">
            当前位置： 系统管理 > <a href="#">菜单管理</a>
        </dl>
        <dl>
            <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"
                    data-am-modal="{target: '#my-popup'}">添加商品一级分类
            </button>
        </dl>

    </div>

    <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
            <thead>
            <tr class="am-success">
                <th class="am-table-radius">选择</th>
                <th class="table-id">CODE</th>
                <th class="table-id am-text-center">名称</th>
                <th class="table-title">URL</th>
                <th class="table-type">是否可见</th>
                <th class="table-author am-hide-sm-only">创建日期</th>
                <th class="table-date am-hide-sm-only">备注</th>
                <th class="table-set">快捷操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${menuList}" var="menu">
                <tr>
                    <td><input type="radio" id="rid" value="${menu.id}"/></td>
                    <td class="am-text-center">${menu.code}</td>
                    <td><a href="#">${menu.name}</a></td>
                    <td class="am-text-center">${menu.url}</td>
                    <td>
                        <c:if test="${menu.isVisible == 1}">可见</c:if>
                        <c:if test="${menu.isVisible == 0}">不可见</c:if>
                    </td>
                    <td class="am-hide-sm-only"><fmt:formatDate value="${menu.createTime}"
                                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${menu.remark}</td>
                    <td>
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs" style="z-index: 0">
                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                        data-am-modal="{target: '#my-popups'}" title="修改"><span
                                        class="am-icon-pencil-square-o"></span></button>
                                <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="隐藏"
                                        data-am-modal="{target: '#my-popupss'}"><span class="am-icon-copy"></span>
                                </button>
                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                        class="am-icon-trash-o"></span></button>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="am-btn-group am-btn-group-xs" style="z-index: 0">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 修改</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
        </div>

        <div class="am-btn-group am-btn-group-xs" style="z-index: 0">
            <ul class="am-pagination am-fr">
                <c:forEach var="i" begin="1" end="${pageCond.pageTotalCount}" step="1">
                    <c:if test="${i == 1}">
                        <li><a href="javascript:toPage('${i} - 1')">«</a></li>
                    </c:if>
                    <li id="pageCount${i}" class="am-active"><a href="javascript:toPage('${i}')"><c:out
                            value="${i}"/></a></li>
                    <c:if test="${i == 1}">
                        <li><a href="javascript:toPage('${i + 1}')">»</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>

        <hr/>
        <p>
            备注：操作图标含义
            <a class="am-icon-pencil-square-o am-text-secondary" title="修改"> 修改菜单</a>
            <a class="am-icon-copy am-text-warning" title="复制"> 隐藏菜单</a>
            <a class="am-icon-trash-o am-text-danger" title="删除"> 删除菜单</a>
        </p>
    </form>

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
