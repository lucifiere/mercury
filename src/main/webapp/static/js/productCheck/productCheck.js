function addCheckResult(baseResult) {
    var baseCheckResult = '<tr name="baseCheckResult">\n' +
        '<td>' + baseResult.checkItem + '</td>\n' +
        '<td>' + baseResult.checkResult + '</td>\n' +
        '<td>' + baseResult.checkResultDesc + '</td>\n' +
        '<td>' + baseResult.checkMark + '</td>\n' +
        '</tr>';
    $("#tb").append(baseCheckResult)
}

function addFeeCheckResult(feeResult) {
    var feeCheckResult = '<tr name="feeCheckResult">\n' +
        '<td>' + feeResult.checkAge + '</td>\n' +
        '<td>' + feeResult.checkPremium + '</td>\n' +
        '<td>' + feeResult.checkResult + '</td>\n' +
        '<td>' + feeResult.checkMark + '</td>\n' +
        '</tr>';
    $("#ftb").append(feeCheckResult)
}



// function startFeeCheck () {
//     alert("dgdsfds");
//     var productFee = {};
//     productFee.productCode = $("#productCode").val();
//     productFee.periods = $("#insurancePeriodId option:selected").val();
//     productFee.payPeriod = $("#paymentPeriodId option:selected").val();
//     productFee.socialSecurity = $("#isSocialSecurityId option:selected").val();
//     productFee.sex = $("#sexId option:selected").val();
//     productFee.amount = $("#amountId option:selected").val();
//     productFee.minAge = $("#minAgeId").val();
//     productFee.maxAge = $("#maxAgeId").val();
//     if(productFee.minAge==="" || productFee.maxAge===""){
//         alert("请选择投保年龄区间！");
//         return false;
//     }
//     $.ajax({
//         type: "post",
//         url: "/productCheck/startFeeCheck",
//         dataType: 'json',
//         contentType: "application/json",
//         async: false,
//         data: JSON.stringify(productFee),
//         success: function (data) {
//             if (data.success === "true") {
//                 for (var i = 0;i<data.length;i++){
//                     addFeeCheckResult(data[i]);
//                 }
//                 return true;
//             } else {
//                 alert("执行失败");
//                 return false;
//             }
//         },
//         error: function (data) {
//             alert("error" + Json.stringify(data));
//             return false;
//         }
//     });
// }
