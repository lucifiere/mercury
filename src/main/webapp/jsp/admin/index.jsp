<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/base.jsp" %>

<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Mercury管理后台</title>
    <meta name="description" content="Mercury管理后台">
    <meta name="renderer" content="webkit">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
</head>

<body>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand"><img src="${pageContext.request.contextPath}/static/lib/amaze_ui/i/logo.png"></div>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
            <li class="am-dropdown tognzhi" data-am-dropdown>
                <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o"
                        data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">6</span></button>
                <ul class="am-dropdown-content">
                    <li class="am-dropdown-header">所有消息都在这里</li>
                    <c:forEach items="${messageList}" var="msg">
                        <li><a href="${msg.url}">${msg.title} </a></li>
                    </c:forEach>
                </ul>
            </li>


            <li class="kuanjie">
                <c:forEach items="${moduleList}" var="module">
                    <a href="${module.url}">${module.name} </a>
                </c:forEach>
                <a style="color: red" href="${pageContext.request.contextPath}/auth/loginOut">退出登录</a>
            </li>

        </ul>
    </div>
</header>

<div class="am-cf admin-main">

    <div class="nav-navicon admin-main admin-sidebar">

        <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;">
            欢迎系统管理员：<shiro:principal/>
            <br>
        </div>

        <div class="sideMenu">
            <c:forEach items="${menuList}" var="module">
                <h3 class="am-icon-flag"><a href="#">${module.name}</a></h3>
                <ul>
                    <c:forEach items="${module.children}" var="child">
                        <li><a href="${child.url}" target="container">${child.name}</a></li>
                    </c:forEach>
                </ul>
            </c:forEach>
        </div>
        <!-- sideMenu End -->

        <script type="text/javascript">
            jQuery(".sideMenu").slide({
                titCell: "h3", //鼠标触发对象
                targetCell: "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
                effect: "slideDown", //targetCell下拉效果
                delayTime: 300, //效果时间
                triggerTime: 150, //鼠标延迟触发时间（默认150）
                defaultPlay: true,//默认是否执行效果（默认true）
                returnDefault: true //鼠标从.sideMen移走后返回默认状态（默认false）
            });
        </script>

    </div>

    <div class=" admin-content">

        <div class="daohang">

        </div>

        <div class="admin">
            <iframe src="${pageContext.request.contextPath}/html/admin_blank.html" width="100%" height="100%"
                    name="container">
            </iframe>
        </div>

    </div>

</div>
</body>
</html>