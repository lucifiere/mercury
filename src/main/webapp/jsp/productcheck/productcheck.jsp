<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2017/6/9
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ include file="/jsp/common/base.jsp"%>--%>

<context:component-scan base-package="com.atlandes.productCode.controller"></context:component-scan>
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
    <script src="${pageContext.request.contextPath}/static/lib/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/static/js/productCheck/productCheck.js"></script>

</head>

<body>
<div class="admin-biaogelist">
    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
            产品自检盒子
        </ul>
    </div>

    <div class="fbneirong">
        <form class="am-form" id="menuForm">
            <div class="am-form-group am-cf">
                <div class="zuo">sku：
                    <input id="productCode" class="am-input-sm" placeholder="请输入sku"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" class="am-btn am-btn-success am-radius" onclick="startCheck()">开始</button>&nbsp;
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="selectAll" onclick="selectAllBaseCheck()">
                    <b>全选</b>
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="underWrite" name="baseCheckCB">
                    核保检测
                </div>
            </div>

            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="issue" name="baseCheckCB">
                    出单检测
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="onLinePolicy" name="baseCheckCB">
                    电子保单检测
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="underWriteOnceMore" name="baseCheckCB">
                    核保份数校验
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="issueOnceMore" name="baseCheckCB">
                    出单份数校验
                </div>
            </div>
            <div class="am-form-group am-cf">
                <div class="zuo">
                    <input type="checkbox" id="issueIdempotent" name="baseCheckCB">
                    出单幂等校验
                </div>
            </div>
            <div name="baseResult">
                <div class="am-form-group am-cf">
                    <b>检测结果</b>
                </div>
                <table border="1">
                    <thead>
                    <tr>
                        <td>检测项</td>
                        <td>检测结果</td>
                        <td>结果描述</td>
                        <td>备注</td>
                    </tr>
                    <thead>
                    <tbody id="tb">

                    </tbody>
                </table>
            </div>
            <br/><br/>
            <div class="am-form-group am-cf">
                <div class="zuo">是否进行费率检测
                    <lable class="am-radio-inline">
                        <input type="radio" name="isFeeCheck" value="true" id="feeCheckTrue" onclick="displayFeeType()">是
                    </lable>
                    <lable class="am-radio-inline">
                        <input type="radio" name="isFeeCheck" value="false" id="feeCheckFalse" checked="checked"
                               onclick="displayFeeType()">否
                    </lable>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" id="feeCheckBtn" name="feeCheck" class="am-btn am-btn-success am-radius" onclick="startFeeCheck()" hidden="true">
                        费率检测开始
                    </button>&nbsp;
                </div>
                <div class="am-form-group am-cf" name="feeCheck">

                    <div id="amountId" hidden="true">
                        <lable>保额方案：</lable>
                        <select name="amount">
                        </select>
                    </div>
                    <div id="holderInsuredRelationsId" hidden="true">
                        <lable>投被保人关系：</lable>
                        <select name="holderInsuredRelations">
                        </select>
                    </div>
                    <div id="sexId" hidden="true">
                        <lable>性别：</lable>
                        <select name="sex">
                        </select>
                    </div>
                    <div id="paymentPeriodId" hidden="true">
                        <lable>缴费期间：</lable>
                        <select name="paymentPeriod">
                        </select>
                    </div>
                    <div id="insurancePeriodId" hidden="true">
                        <lable>保障期间：</lable>
                        <select name="insurancePeriod">
                        </select>
                    </div>
                    <div id="isSocialSecurityId" hidden="true">
                        <lable>社保：</lable>
                        <select name="isSocialSecurity">
                        </select>
                    </div>
                    <br>
                    <div id="ageId">
                    </div>
                    <br>
                </div>
            </div>

            <div name="feeCheckResult">
                <div class="am-form-group am-cf">
                    <b>费率检测结果</b>
                </div>
                <table border="1">
                    <thead>
                    <tr>
                        <td>年龄(岁)</td>
                        <td>保费(元)</td>
                        <td>结果</td>
                        <td>备注</td>
                    </tr>
                    <thead>
                    <tbody id="ftb">
                    </tbody>
                </table>
            </div>
        </form>
    </div>

</div>


<script>
    function startCheck() {
        var productCode = $("#productCode").val();
        var baseCheckIdList = [];
        var baseChecked = $("input[name='baseCheckCB']:checked").each(function (i, checkCB) {
            baseCheckIdList.push($(checkCB).prop("id"));
        });
        var baseCheckIdStr = baseCheckIdList.join(",");
        $.ajax({
            url: "/productCheck/startCheck?sku=" + productCode + "&baseCheckIds=" + baseCheckIdStr,
            type: "GET",
            dataType: "json",

            success: function (result) {

                var res1 = result.underWriteResult;
                if (res1 != null) {
                    addCheckResult(res1);
                }
                var res2 = result.issueResult;
                if (res2 != null) {
                    addCheckResult(res2);
                }
                var res3 = result.onLinePolicyResult;
                if (res3 != null) {
                    addCheckResult(res3);
                }
                var res4 = result.underWriteOnceMoreResult;
                if (res4 != null) {
                    addCheckResult(res4);
                }
                var res5 = result.issueOnceMoreResult;
                if (res5 != null) {
                    addCheckResult(res5);
                }
                var res6 = result.issueIdempotentResult;
                if (res6 != null) {
                    addCheckResult(res6);
                }
            },
            error: function () {
                if (productCode.length > 0) {
                    alert("您没有任何检测结果")
                }
                else {
                    alert("请输入sku")
                }
            }
        });

    }

    function selectAllBaseCheck() {
        var isSelected = $("#selectAll").prop('checked');
        if (isSelected) {
            $("input[name='baseCheckCB']").prop('checked', true);
        }
        else {
            $("input[name='baseCheckCB']").prop('checked', false);
        }
    }

    function displayFeeType() {
        var productCode = $("#productCode").val();
        if (productCode.length > 0) {
            $("input[name='isFeeCheck']").change(function () {
                var value = $(this).val();
                if (value == "true") {
                    $.ajax({
                        url: "/productCheck/displayFeeType?sku=" + productCode,
                        type: "GET",
                        dataType: "json",
                        success: function (result) {
                            var res1 = result.periods;
                            if (res1 != null) {
                                var periodsString = "";
                                for (var i = 0; i < res1.length; i++) {
                                    periodsString += "<option value=\"" + res1[i].code + "\" >" + res1[i].desc + "</option>";
                                    $("select[name='insurancePeriod']").html(periodsString);
                                }
                                $("#insurancePeriodId").show();
                                $("#feeCheckBtn").show();
                            }
                            var res2 = result.payPeriod;
                            if (res2 != null) {
                                var payPeriodString = "";
                                for (var i = 0; i < res2.length; i++) {
                                    payPeriodString += "<option value=\"" + res2[i].code + "\" >" + res2[i].desc + "</option>";
                                    $("select[name='paymentPeriod']").html(payPeriodString);
                                }
                                $("#paymentPeriodId").show();
                                $("#feeCheckBtn").show();

                            }
                            var res3 = result.socialSecurity;
                            if (res3 != null) {
                                var socialSecurityString = "";
                                for (var i = 0; i < res3.length; i++) {
                                    socialSecurityString += "<option value=\"" + res3[i].code + "\" >" + res3[i].desc + "</option>";
                                    $("select[name='isSocialSecurity']").html(socialSecurityString);
                                }
                                $("#isSocialSecurityId").show();
                                $("#feeCheckBtn").show();

                            }
                            var res4 = result.sex;
                            if (res4 != null) {
                                var sexString = "";
                                for (var i = 0; i < res4.length; i++) {
                                    sexString += "<option value=\"" + res4[i].code + "\" >" + res4[i].desc + "</option>";
                                    $("select[name='sex']").html(sexString);
                                }
                                $("#sexId").show();
                                $("#feeCheckBtn").show();
                            }

                            var res5 = result.amount;
                            if (res5.length>0) {
                                var amountString = "";
                                for (var i = 0; i < res5.length; i++) {
                                    amountString += "<option value=\"" + res5[i].code + "\" >" + res5[i].desc + "</option>";
                                    $("select[name='amount']").html(amountString);
                                }
                                $("#amountId").show();
                                $("#feeCheckBtn").show();
                            }

                            var res6 = result.holderInsuredRelations;
                            if (res6 != null) {
                                var holderInsuredRelationstring = "";
                                for (var i = 0; i < res6.length; i++) {
                                    holderInsuredRelationstring += "<option value=\"" + res6[i].code + "\" >" + res6[i].desc + "</option>";
                                    $("select[name='holderInsuredRelations']").html(holderInsuredRelationstring);
                                }
                                $("#holderInsuredRelationsId").show();
                                $("#feeCheckBtn").show();
                            }

                            var minAge = result.minAge;
                            var maxAge = result.maxAge;
                            if (minAge != null && maxAge!=null) {
                                var ageString = "";
                                ageString += "<lable>年龄：</lable>" +
                                    "<input type='number' id='minAgeId' min='" + minAge +
                                    "' max='" + maxAge + "'/>" +
                                    "<label>(岁)</label>" +
                                    "<label>—</label>" +
                                    "<input type='number' id='maxAgeId' min='" + minAge +
                                    "' max='" + maxAge + "'/>" +
                                    "<label>(岁)</label>";
                                $("#ageId").html(ageString);
                                $("#ageId").show();
                                $("#feeCheckBtn").show();
                            }
                        },
                        error: function () {
                            alert("本产品没有配费率表")
                        }
                    });
                } else {
                    $("div[name='feeCheck']").hide();
                }
            });
        }
        else {
            alert("在输入框输入sku")
            $("#feeCheckFalse").each(function () {
                $(this).prop("checked", true);
            });
        }
    }

    function startFeeCheck () {
        var productFee = {};
        productFee.productCode = $("#productCode").val();
        productFee.periods = $("#insurancePeriodId option:selected").val();
        productFee.payPeriod = $("#paymentPeriodId option:selected").val();
        productFee.socialSecurity = $("#isSocialSecurityId option:selected").val();
        productFee.sex = $("#sexId option:selected").val();
        productFee.amount = $("#amountId option:selected").val();
        productFee.minAge = $("#minAgeId").val();
        productFee.maxAge = $("#maxAgeId").val();
        if(productFee.minAge==="" || productFee.maxAge===""){
            alert("请选择投保年龄区间！");
            return false;
        }
        $.ajax({
            type: "post",
            url: "/productCheck/startFeeCheck",
            dataType: 'json',
            contentType: "application/json",
            async: false,
            data: JSON.stringify(productFee),
            success: function (data) {
                if (data.success === "true") {
                    for (var i = 0;i<data.length;i++){
                        addFeeCheckResult(data[i]);
                    }
                    return true;
                } else {
                    alert("执行失败");
                    return false;
                }
            },
            error: function (data) {
                alert("error" + Json.stringify(data));
                return false;
            }
        });
    }
</script>

</body>

</html>