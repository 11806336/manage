/*说明*/
//<%--删除--%>deleteAction(obj,url,idField)
//<%--编辑--%>updateAction(obj,url,idField)
//<%--新增--%>createAction(url,title)
//<%--调用弹出--%>dialog(url,title,id)
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        }
    }
}
/* jquery-ui-dialog 弹框 可改变大小 */
function jqDialog(dialogId,iframeId,title){
    var dialog = $( dialogId ).show().dialog({
        modal: true,
        title: title,
        width : "600", //宽度
        height : "400", //高度
        show: "explode",
        hide: "drop",
        autoOpen: true
    });
    document.getElementById(iframeId).contentWindow.onload=function () {
        setIframeHeight(document.getElementById(iframeId));
    };
}
function jqDialogLocality(dialogId,title){
    var dialog = $( dialogId ).show().dialog({
        modal: true,
        title: title,
        width : "600", //宽度
        height : "400", //高度
        show: "drop",
        hide: "drop",
        autoOpen: true
    });
}
$(function() {
    // 数据表格动态高度
    $(window).resize(function () {
        $('#table').bootstrapTable('resetView', {
            height: getHeight()
        });
    });
    // 设置input特效
    $(document).on('focus', 'input[type="text"]', function() {
        $(this).parent().find('label').addClass('active');
    }).on('blur', 'input[type="text"]', function() {
        if ($(this).val() == '') {
            $(this).parent().find('label').removeClass('active');
        }
    });
});
// 数据表格展开内容
function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}
// 初始化input特效
function initMaterialInput() {
    $('form input[type="text"]').each(function () {
        if ($(this).val() != '') {
            $(this).parent().find('label').addClass('active');
        }
    });
}

$(function() {
    // bootstrap table初始化，必须有的参数，url_json 数据地址。sidePagination设置在哪里进行分页，client和server。
    // idField指定主键列。search、showRefresh、showColumns右上角刷新搜索
    $table.bootstrapTable({
        url:url_json,
        datatype:'json',
        height: getHeight(),
        striped: true,
        sortable:true,
        sortOrder:"ID asc",
        search: search,
        showRefresh: showRefresh,
        showColumns: showColumns,
        minimumCountColumns: 12,
        clickToSelect: false,
        // detailView: true,
        detailFormatter: 'detailFormatter',
        pagination: true,
        paginationLoop: false,
        sidePagination: sidePagination,
        silentSort: false,
        smartDisplay: false,
        escape: true,
        searchOnEnterKey: true,
        idField: idField,
        maintainSelected: true,
        toolbar: '#toolbar',
        columns:dataColumns
    });
});

function getHeight() {
    return $(window).height() - 168;
}

// 格式化图标
function iconFormatter(value, row, index) {
    return '<i class="' + value + '"></i>';
}
// 格式化类型
function typeFormatter(value, row, index) {
    if (value == 1) {
        return '目录';
    }
    if (value == 2) {
        return '菜单';
    }
    if (value == 3) {
        return '按钮';
    }
    return '-';
}
// 格式化状态
function statusFormatter(value, row, index) {
    if (value == 1) {
        return '<span class="label label-success">正常</span>';
    } else {
        return '<span class="label label-default">锁定</span>';
    }
}
// 新增
var createDialog;
function createAction(url,title) {
    //需要传的参数url地址，title标题
    createDialog = $.dialog({
        animationSpeed: 300,
        title: title,
        content:url, /*/manage/permission/create'*/
        onContentReady: function () {
            //initMaterialInput();
            //$('select').select2();
        }
    });
}
// 编辑
var updateDialog;
function updateAction(obj,url,idField) {
    //需要传的参数，obj ===this,url地址，idField主键
    var rows = $table.bootstrapTable('getSelections');
    //找到主键Id
    var Id = $(obj).parent().parent().find(".bs-checkbox ").find("input").val();
    //表格外的编辑按钮有个自定义属性 data-update = "表格外"
    var dataUpdate = $(obj).attr("data-update");
    //判断是表格内行后面的按钮还是右上角的编辑文字
    if(dataUpdate === "表格外"){
        if (rows.length != 1) {
            $.confirm({
                title: false,
                content: '请选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'btn-close'
                    }
                }
            });
        } else {
            updateDialog = $.dialog({
                animationSpeed: 300,
                title: '编辑组织',
                content: url + rows[0][idField],
                onContentReady: function () {
                    initMaterialInput();
                    $('select').select2();
                    initType();
                    initSelect2();
                }
            });
        }
    }else{
        updateDialog = $.dialog({
            animationSpeed: 300,
            title: '编辑组织',
            content: url + Id,
            onContentReady: function () {
                initMaterialInput();
                $('select').select2();
                initType();
                initSelect2();
            }
        });
    }
}
// 删除
var deleteDialog;
function deleteAction(obj,url,idField) {
    //需要传的参数。obj === this,url地址，idField主键
    var rows = $table.bootstrapTable('getSelections');
    //单行删除Id主键
    var Id = $(obj).parent().parent().find(".bs-checkbox ").find("input").val();
    //删除的数组
    var ids = new Array();
    //"判断单个删除还是批量删除
    var delete_type = $(obj).attr("data-deleteTpye");
    //批量删除按钮标签有个自定义属性 data-deleteTpye = "批量删除"
    if(delete_type === "批量删除"){
        if (rows.length == 0) {
            $.confirm({
                title: false,
                content: '请至少选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'btn-close'
                    }
                }
            });
            return false;
        }
        for (var i in rows) {
            ids.push(rows[i][idField]);
        }
    } else {
        ids.push(Id);
    }
    deleteDialog = $.confirm({
        type: 'red',
        animationSpeed: 300,
        title: false,
        content: '确认删除吗？',
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'btn-yes',
                action: function () {
                    $.ajax({
                        type: 'get',
                        url:url+"/" + ids.join("-"),
                        success: function (result) {
                            if (result.code != 1) {
                                if (result.data instanceof Array) {
                                    $.each(result.data, function (index, value) {
                                        $.confirm({
                                            theme: 'dark',
                                            animation: 'rotateX',
                                            closeAnimation: 'rotateX',
                                            title: false,
                                            content: value.errorMsg,
                                            buttons: {
                                                confirm: {
                                                    text: '确认',
                                                    btnClass: 'waves-effect waves-button waves-light'
                                                }
                                            }
                                        });
                                    });
                                } else {
                                    $.confirm({
                                        theme: 'dark',
                                        animation: 'rotateX',
                                        closeAnimation: 'rotateX',
                                        title: false,
                                        content: result.data,
                                        buttons: {
                                            confirm: {
                                                text: '确认',
                                                btnClass: 'waves-effect waves-button waves-light'
                                            }
                                        }
                                    });
                                }
                            } else {
                                deleteDialog.close();
                                $table.bootstrapTable('refresh');
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $.confirm({
                                theme: 'white',
                                animation: 'rotateX',
                                closeAnimation: 'rotateX',
                                title: false,
                                content: textStatus,
                                buttons: {
                                    confirm: {
                                        text: '确认',
                                        btnClass: 'btn-yes'
                                    }
                                }
                            });
                        }
                    });
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'btn-close'
            }
        }
    });
}
/**共有的js文件
 * Created by Administrator on 2017/5/27.
 */
