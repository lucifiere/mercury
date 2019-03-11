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