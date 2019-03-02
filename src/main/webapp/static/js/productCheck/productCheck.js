function addCheckResult(baseResult){
       var baseCheckResult='<tr name="baseCheckResult">\n' +
        '<td>'+baseResult.checkItem+'</td>\n' +
        '<td>'+baseResult.checkResult+'</td>\n' +
        '<td>'+baseResult.checkResultDesc+'</td>\n' +
        '<td>'+baseResult.checkMark+'</td>\n' +
        '</tr>';
       $("#tb").append(baseCheckResult)
}