/**
 * Created by XD.Wang on 2017/6/13.
 * 菜单功能
 */

function toListPage(pageCount) {
    window.open("/role/list?pageCurCount=" + pageCount, "_self")
}

function del(id) {
    if (id == null) {
        id = getIdChecked();
        if (id === null) return;
    }
    $.ajax({
        url: "/role/del?id=" + id,
        dataType: "json",
        type: "GET",
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/role/list";
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
        url: "/role/changeStatus?status=" + status ,
        dataType: "json",
        type: "GET",
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/role/list";
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
    window.open("/role/detail?id=" + id, "_self")
}

function edit() {
    var role = getRole();
    if (role == null) return;
    $.ajax({
        url: "/role/edit",
        contentType: "application/json",
        dataType: "json",
        type: "POST",
        data: JSON.stringify(role),
        success: function (result) {
            if (result.code == 1) {
                alert(result.msg);
                window.location.href = "/role/list";
            } else {
                alert(result.msg);
            }
        },
        error: function () {
            alert("内部错误，请联系开发人员！")
        }
    });
}

function getRole() {
    var role = {};
    var name = $("#name").val();
    if (isNull(name)) {
        alert("名称不能为空！");
        return null;
    }
    role.name = name;
    role.id = $("#id").val();
    var type = $("#type").val();
    if (isNull(type)) {
        alert("类型不能为空！");
        return null;
    }
    role.type = type;
    var status = $("#status").val();
    if (isNull(status)) {
        alert("状态不能为空！");
        return null;
    }
    role.status = status;
    return role;
}
