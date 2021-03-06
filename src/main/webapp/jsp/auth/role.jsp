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
    <title>角色管理</title>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Cache" content="no-cache">
    <meta name="description" content="角色管理">
    <meta name="renderer" content="webkit">
    <script src="${pageContext.request.contextPath}/static/js/auth/role.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>

<body>
<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            角色管理
        </ul>
        <dl class="am-icon-home" style="float: right;">
            当前位置： 安全管理 > 角色管理
        </dl>

    </div>

    <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
            <thead>
            <tr class="am-success">
                <th class="am-table-radius am-text-center">选择</th>
                <th class="table-id am-text-center">名称</th>
                <th class="table-title am-text-center">类型</th>
                <th class="table-title am-text-center">权限</th>
                <th class="table-title am-text-center">状态</th>
                <th class="table-author am-text-center">创建日期</th>
                <th>快捷操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${roleList}" var="role">
                <tr>
                    <td class="am-text-center">
                        <input type="radio" name="rid" value="${role.id}"/>
                    </td>
                    <td class="am-text-center"><a href="javascript:toEditPage('${role.id}')">${role.name}</a></td>
                    <td class="am-text-center">${role.typeStr}</td>
                    <td class="am-text-center">${role.permissionStr}</td>
                    <td class="am-text-center">${role.statusStr}</td>
                    <td class="am-text-center"><fmt:formatDate value="${role.createTime}"
                                                               pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs" style="z-index: 0">
                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                        data-am-modal="{target: '#my-popups'}" title="修改"
                                        onclick="toEditPage('${role.id}')"><span
                                        class="am-icon-pencil-square-o"></span></button>
                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"
                                        onclick="del('${role.id}')"><span
                                        class="am-icon-trash-o"></span></button>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="am-btn-group am-btn-group-xs" style="z-index: 0">
            <button type="button" class="am-btn am-btn-default" onclick="toEditPage('')"><span
                    class="am-icon-plus"></span> 新增
            </button>
            <button type="button" class="am-btn am-btn-default" onclick="toEditPage()"><span
                    class="am-icon-save"></span> 修改
            </button>
            <button type="button" class="am-btn am-btn-default" onclick="del()"><span
                    class="am-icon-trash-o"></span> 删除
            </button>
        </div>

        <div class="am-btn-group am-btn-group-xs" style="z-index: 0">
            <ul class="am-pagination am-fr">
                <c:forEach var="i" begin="1" end="${pageTotalCount}" step="1">
                    <c:if test="${i == 1}">
                        <li><a href="javascript:toListPage('${i}')">«</a></li>
                    </c:if>
                    <li id="pageCount${i}" class="am-active"><a href="javascript:toListPage('${i}')"><c:out
                            value="${i}"/></a></li>
                    <c:if test="${i == pageTotalCount}">
                        <li><a href="javascript:toListPage('${i}')">»</a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>

        <hr/>
        <p>
            备注：操作图标含义
            <a class="am-icon-pencil-square-o am-text-secondary" title="修改"> 修改角色</a>
            <a class="am-icon-trash-o am-text-danger" title="删除"> 删除角色</a>
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
