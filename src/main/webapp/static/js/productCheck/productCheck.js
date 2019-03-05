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
    var productCode = $("#productCode").val();
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
