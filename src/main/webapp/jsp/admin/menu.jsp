<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2017/6/9
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
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
                <th class="table-check"><input type="checkbox"/></th>
                <th class="table-id">排序</th>
                <th class="table-id am-text-center">ID</th>
                <th class="table-title">栏目名称</th>
                <th class="table-type">数据量</th>
                <th class="table-author am-hide-sm-only">访问</th>
                <th class="table-date am-hide-sm-only">添加子栏目</th>
                <th class="table-set">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">14</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
                               data-am-modal="{target: '#my-popups'}" title="添加子栏目"></a>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}" title="修改"><span
                                    class="am-icon-pencil-square-o"></span></button>
                            <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->


                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="复制"
                                    data-am-modal="{target: '#my-popupss'}"><span class="am-icon-copy"></span></button>
                            <!-- 做完发现 复制栏目没什么用处 早晚都要修改 -->


                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>


            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">2</td>
                <td><i style="margin-left:30px">├─ </i><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
                               data-am-modal="{target: '#my-popups'}" title="添加子栏目"></a>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}" title="修改"><span
                                    class="am-icon-pencil-square-o"></span></button>
                            <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->


                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="复制"><span
                                    class="am-icon-copy"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>

            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">3</td>
                <td><i style="margin-left:30px">├─ </i><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
                               data-am-modal="{target: '#my-popups'}" title="添加子栏目"></a>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}" title="修改"><span
                                    class="am-icon-pencil-square-o"></span></button>
                            <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->


                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="复制"><span
                                    class="am-icon-copy"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>


            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">4</td>
                <td><i style="margin-left:30px">├─ </i><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
                               data-am-modal="{target: '#my-popups'}" title="添加子栏目"></a>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}" title="修改"><span
                                    class="am-icon-pencil-square-o"></span></button>

                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="复制"><span
                                    class="am-icon-copy"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>


            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">5</td>
                <td><i style="margin-left:30px">├─ </i><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
                               data-am-modal="{target: '#my-popups'}" title="添加子栏目"></a>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}" title="修改"><span
                                    class="am-icon-pencil-square-o"></span></button>
                            <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->


                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="复制"><span
                                    class="am-icon-copy"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>

            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">6</td>
                <td><i style="margin-left:30px">├─ </i><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only">访问</td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file"
                               data-am-modal="{target: '#my-popups'}" title="添加子栏目"></a>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}" title="修改"><span
                                    class="am-icon-pencil-square-o"></span></button>
                            <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->

                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round" title="复制"><span
                                    class="am-icon-copy"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>


            <tr>
                <td><input type="checkbox"/></td>
                <td><input type="text" class="am-form-field am-radius am-input-sm"/></td>
                <td class="am-text-center">15</td>
                <td><a href="#">Business management</a></td>
                <td>default</td>
                <td class="am-hide-sm-only"><i class="am-icon-close am-text-primary"></i></td>
                <td class="am-hide-sm-only">2014年9月4日 7:28:47</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <button class="am-btn am-btn-default am-btn-xs am-text-success am-round"><span
                                    class="am-icon-search"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"
                                    data-am-modal="{target: '#my-popups'}"><span class="am-icon-pencil-square-o"></span>
                            </button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-warning  am-round"><span
                                    class="am-icon-copy"></span></button>
                            <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round"><span
                                    class="am-icon-trash-o"></span></button>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="am-btn-group am-btn-group-xs">
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 修改</button>
            <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
        </div>

        <div class="am-btn-group am-btn-group-xs">
            <ul class="am-pagination am-fr">
                <li class="am-disabled"><a href="#">«</a></li>
                <li class="am-active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">»</a></li>
            </ul>
        </div>

        <hr/>
        <p>
            备注：操作图标含义
            <a class="am-text-success am-icon-file" title="添加子栏目"> 添加子栏目</a>
            <a class="am-icon-pencil-square-o am-text-secondary" title="修改"> 修改栏目</a>
            <a class="am-icon-copy am-text-warning" title="复制"> 复制栏目</a>
            <a class="am-icon-trash-o am-text-danger" title="删除"> 删除栏目</a>
        </p>
    </form>

    <div class="foods">
        <ul>
            Mercury管理后台
        </ul>
        <dl>
            <a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
        </dl>
    </div>

</div>
</body>
</html>
