/**
 * Created by XD.Wang on 2017/6/13.
 * 菜单功能
 */

function toListPage(pageCount) {
    window.open("/permission/list?pageCurCount=" + pageCount, "_self")
}

function del(id) {
    if (id == null) {
        id = getIdChecked();
        if (id === null) return;
    }
    $.ajax({
        url: "/permission/del?id=" + id,
        dataType: "json",
        type: "GET",
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/permission/list";
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("内部错误，请联系开发人员！")
        }
    });
}

function changeStatus(status) {
    var id = getIdChecked();
    if (id == null) return;
    $.ajax({
        url: "/permission/changeStatus?status=" + status,
        dataType: "json",
        type: "GET",
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/permission/list";
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
    window.open("/permission/detail?id=" + id, "_self")
}

function edit() {
    var permission = getPermission();
    if (permission == null) return;
    $.ajax({
        url: "/permission/edit",
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        data: JSON.stringify(permission),
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/permission/list";
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("内部错误，请联系开发人员！")
        }
    });
}

function getPermission() {
    var permission = {};
    var name = $("#name").val();
    if (isNull(name)) {
        alert("名称不能为空！");
        return null;
    }
    permission.name = name;
    permission.id = $("#id").val();
    var type = $("#type").val();
    if (isNull(type)) {
        alert("类型不能为空！");
        return null;
    }
    permission.type = type;
    var status = $("#status").val();
    if (isNull(status)) {
        alert("状态不能为空！");
        return null;
    }
    permission.status = status;
    var url = $("#url").val();
    if (isNull(url)) {
        alert("URL不能为空！");
        return null;
    }
    permission.url = url;
    var des = $("#des").val();
    if (isNull(des)) {
        alert("描述不能为空！");
        return null;
    }
    permission.des = des;
    return permission;
}
