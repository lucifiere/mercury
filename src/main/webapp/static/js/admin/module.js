/**
 * Created by XD.Wang on 2017/6/14.
 * 模块功能
 */

function toListPage(pageCount) {
    window.open("/module/list?pageCurCount=" + (pageCount - 1), "_self")
}

function delMenu(id) {
    if (id === '-1') {
        id = getIdChecked();
        if (id === null) return;
    }
    alert("操作成功");
    window.open("/module/del?id=" + id, "_self")
}

function toEditPage(id) {
    if (id === '-1') {
        id = getIdChecked();
        if (id === null) return;
    }
    window.open("/module/detail?id=" + id, "_self")
}

function sortIdCheck() {
    if (isNaN($("#sortId").val())) {
        alert("只能输入数字！");
        $("#sortId").val(0);
    }
}

function editMenu() {
    $("form").submit(function (e) {
        alert("操作成功");
        window.location.href = "/module/list";
    });
}