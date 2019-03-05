function addCheckResult(baseResult){
       var baseCheckResult='<tr name="baseCheckResult">\n' +
        '<td>'+baseResult.checkItem+'</td>\n' +
        '<td>'+baseResult.checkResult+'</td>\n' +
        '<td>'+baseResult.checkResultDesc+'</td>\n' +
        '<td>'+baseResult.checkMark+'</td>\n' +
        '</tr>';
       $("#tb").append(baseCheckResult)
}

function addFeeCheckResult(feeResult){
       var feeCheckResult='<tr name="feeCheckResult">\n' +
           '<td>'+feeResult.checkAge+'</td>\n' +
           '<td>'+feeResult.checkPremium+'</td>\n' +
           '<td>'+feeResult.checkResult+'</td>\n' +
           '<td>'+feeResult.checkMark+'</td>\n' +
           '</tr>';
       $("#ftb").append(feeCheckResult)
}

function startFeeCheck() {
    var productFee = {};
    productFee.productCode = $("#productCode").val();
    productFee.periods=$("#insurancePeriodId").val();
    productFee.payPeriod = $("#paymentPeriodId").val();
    productFee.socialSecurity = $("#isSocialSecurityId").val();
    productFee.sex = $("#sexId").val();
    productFee.amount = $("#amountId").val();
    productFee.minAge = $("#minAgeId").val();
    productFee.maxAge = $("#maxAgeId").val();
    $.ajax({
        type: "post",
        url: "/productCheck/startFeeCheck",
        dataType: 'json',
        contentType: "application/json",
        async: false,
        data: JSON.stringify(productFee),
        success: function (data) {
            if (data.success === "true") {

            }else{
                alert("执行失败");
            }
        },
        error: function () {
            alert("400");
        }
    });
}
