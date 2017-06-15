/**
 *  Created by XD.Wang on 2016/10/20.
 */

function login() {
    $.ajax({
        type: "post",
        url: "/auth/login",
        dataType: 'json',
        contentType: "application/json",
        async: false,
        data: $('#login-form').serialize(),
        success: function (data) {
            if (data.code === 0) {
                alert(data.msg);
            }
        },
        error: function () {
            alert("登录失败 - 400");
        }
    });
}
