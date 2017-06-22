/**
 * Created by XD.Wang on 2017/6/13.
 * 菜单功能
 */

function toListPage(pageCount) {
    window.open("/user/list?pageCurCount=" + pageCount, "_self")
}

function del(id) {
    if (id == null) {
        id = getIdChecked();
        if (id === null) return;
    }
    $.ajax({
        url: "/user/del?id=" + id,
        dataType: "json",
        type: "GET",
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/user/list";
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("内部错误，请联系开发人员！")
        }
    });
}

function lock() {
    var id = getIdChecked();
    if (id == null) return;
    var isLocked = $("input[name='rid']:checked").next().val();
    $.ajax({
        url: "/user/lock?id=" + id + "&pastStatus=" + isLocked,
        dataType: "json",
        type: "GET",
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/user/list";
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("内部错误，请联系开发人员！")
        }
    });
}

function toEditPage(id) {
    if (id == null) {
        id = getIdChecked();
        if (id === null) return;
    }
    window.open("/user/detail?id=" + id, "_self")
}

function edit() {
    var user = getUser();
    if (user == null) return;
    $.ajax({
        url: "/user/edit",
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        data: JSON.stringify(user),
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/user/list";
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("内部错误，请联系开发人员！")
        }
    });
}

function getUser() {
    var user = {};
    var nickname = $("#nickname").val();
    if (isNull(nickname)) {
        alert("账户名不能为空！");
        return null;
    }
    user.id = $("#id").val();
    var password = $("#password").val();
    if (isNull(password)) {
        alert("密码不能为空！");
        return null;
    }
    user.password = password;
    var confirmPassword = $("#confirmPassword").val();
    if (isNull(confirmPassword)) {
        alert("请确认输入的密码！");
        return null;
    }
    user.confirmPassword = confirmPassword;
    var email = $("#email").val();
    if (isNull(email)) {
        alert("邮箱不能为空！");
        return null;
    }
    user.email = email;
    return user;
}
