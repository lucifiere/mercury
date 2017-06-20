/**
 * Created by XD.Wang on 2017/6/13.
 * 菜单功能
 */
function checkValid() {
    pCodeValidCheck();
}

function toListPage(pageCount) {
    window.open("/menu/list?pageCurCount=" + pageCount, "_self")
}

function delMenu(id) {
    if (id === '-1') {
        id = getIdChecked();
        if (id === null) return;
    }
    alert("操作成功");
    window.open("/menu/del?id=" + id, "_self")
}

function toEditPage(id) {
    if (id === '-1') {
        id = getIdChecked();
        if (id === null) return;
    }
    window.open("/menu/detail?id=" + id, "_self")
}

function pCodeValidCheck() {
    var level = $("input[name='level']:checked").val();
    if (level === "1") {
        $("#parentCode").attr("disabled", true);
    } else {
        $("#parentCode").attr("disabled", false);
    }
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
        window.location.href = "/menu/list";
    });
}
