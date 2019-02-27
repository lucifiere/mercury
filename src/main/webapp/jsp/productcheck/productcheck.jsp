<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2017/6/9
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/jsp/common/base.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>产品自检盒子</title>
    <meta name="description" content="产品自检盒子">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Cache" content="no-cache">
    <script src="${pageContext.request.contextPath}/static/js/admin/menu.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common.js"></script>
</head>

<body onload="checkValid()">
<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            产品自检盒子
        </ul>
    </div>

    <div class="fbneirong">
        <form class="am-form" id="menuForm">
            <div class="am-form-group am-cf">
                <div class="zuo">sku：</div>
                <div class="you">
                    <input id="productCode" class="am-input-sm" placeholder="请输入sku"/>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="selectAll" onclick="selectAllBaseCheck()">
                </div>
                <div class="you"><b>全选</b></div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="underWrite" name="baseCheckCB">
                </div>
                <div class="you">核保检测</div>
            </div>

            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="issue" name="baseCheckCB">
                </div>
                <div class="you">出单检测</div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="onLinePolicy" name="baseCheckCB">
                </div>
                <div class="you">电子保单检测</div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="underWriteOnceMore" name="baseCheckCB">
                </div>
                <div class="you">核保份数校验</div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="issueOnceMore" name="baseCheckCB">
                </div>
                <div class="you">出单份数校验</div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="issueIdempotent" name="baseCheckCB">
                </div>
                <div class="you">出单幂等校验</div>
            </div>

            <div class="am-form-group am-cf">
                <div class="zuo">是否进行费率检测</div>
                <lable class="am-radio-inline">
                    <input type="radio" name="isFeeCheck" value="true" onclick="">是
                </lable>
                <lable class="am-radio-inline">
                    <input type="radio" name="isFeeCheck" value="false" checked="checked">否
                </lable>
            </div>

            <div class="am-form-group am-cf">
                <div class="zuo">核保结果：</div>
                <div class="you">
                    <textarea id="underWriteResult" cols="20" rows="4" class="am-input-sm"></textarea>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">出单结果：</div>
                <div class="you">
                    <textarea id="issueResult" cols="30" rows="4" class="am-input-sm"></textarea>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="you" style="margin-left: 11%;">
                    <button type="button" class="am-btn am-btn-success am-radius" onclick="startCheck()">开始</button>&nbsp;
                </div>
            </div>
        </form>
    </div>

</div>

<script>
    function startCheck() {
        var productCode = $("#productCode").val();
        $.ajax({
            url: "/productCheck/startCheck?sku=" + productCode,
            type: "GET",
            dataType: "json",
            success: function (result) {
               var res1 = result.underWriteResult;
               var res2 = result.issueResult;
               $("#underWriteResult").val(res1);
               $("#issueResult").val(res2);
            },
            error: function () {
                alert("内部错误，请联系开发人员！")
            }
        });
    }
    function selectAllBaseCheck() {
        var isSelected =$("#selectAll").prop('checked');
        if (isSelected){
            $("input[name='baseCheckCB']").prop('checked',true);
        }
        else{
            $("input[name='baseCheckCB']").prop('checked',false);
        }
    }
</script>

</body>

</html>