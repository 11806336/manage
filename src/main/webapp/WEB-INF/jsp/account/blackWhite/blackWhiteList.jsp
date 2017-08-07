<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账号</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/plugins/My97DatePicker/skin/WdatePicker.css">
    <link rel="stylesheet" href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css">

    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main" style="padding:10px 20px;">
    <div class="block" id="tradeServerBlack" style="width: 1000px; height: 800px;float: left;">
        <a href="javascript:void(0);" class="block-heading">黑名单</a>
        <div class="block-body">
            <!--添加代码dialog-->
            <div class="container" style="float:left;width:100px;">
                <div id="blackCode" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal" onclick="closeBlack()">×</a>
                        <h3>添加代码</h3>
                    </div>
                    <div class="modal-body">
                        <select name="globalConstDataValue" id="globalConstDataValue">
                            <option>---请选择市场---</option>
                            <c:forEach var="platform" items="${amsPlatforms}">
                                <option value="${platform.globalConstDataValue}">${platform.globalConstDataName}</option>
                            </c:forEach>
                        </select>
                        <input type="text" id="finInstrId" name="finInstrId" placeholder="请输入证券代码">
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success" onclick="blackSubmit()">提交</a>
                        <a href="#" class="btn" data-dismiss="modal" onclick="closeBlack()">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" onclick="addBlackCode();" class="btn">添加代码1</a></p>
            </div>
            <div class="container" style="float:left;width:100px;">
                <div id="blackClassify" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加</h3>
                    </div>
                    <div class="modal-body">
                        <select name="globalConstDataValue1" id="globalConstDataValue1">
                            <option>---请选择分类---</option>
                            <c:forEach var="platform" items="${amsPlatforms}">
                                <option value="${platform.globalConstDataValue}">${platform.globalConstDataName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success" onclick="blackClassifySubmit()" >提交</a>
                        <a href="#" class="btn" onclick="closeBlackClassify()" data-dismiss="modal" >关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" class="btn"  onclick="addBlackClassify();" >添加分类1</a></p>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="deleteBlack" onclick="deleteBlackWhite('/blackWhite/delete?isBlack=1')" > 全部删除1</a>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add1"> 批量上传</a>
            </div>
        <table id="black"></table>
        </div>
    </div>
    <div style="clear: both;"></div>
    <div class="block" id="tradeServerDiv" style="width: 1000px;  height: 800px; float: left;" >
        <a href="javascript:void(0);" class="block-heading">白名单</a>
        <div class="block-body">
            <!--添加代码dialog-->
            <div class="container" style="float:left;width:100px;">
                <div id="whiteCode" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加代码</h3>
                    </div>
                    <div class="modal-body">

                        <select name="globalConstDataValue" id="whiteGlobalConstDataValue">
                            <option>---请选择分类---</option>
                            <c:forEach var="platform" items="${amsPlatforms}">
                                <option value="${platform.globalConstDataValue}">${platform.globalConstDataName}</option>
                            </c:forEach>
                        </select>

                        <input type="text" id="whiteFinInstrId" name="finInstrId" placeholder="请输入证券代码">
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success" onclick="whiteSubmit()">提交</a>
                        <a href="#" class="btn" data-dismiss="modal" onclick="closeWhiteCode()">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#code2" class="btn" onclick="addWhiteCode()">添加代码2</a></p>
            </div>
            <!--添加分类dialog-->
            <div class="container" style="float:left;width:100px;">
                <div id="whiteClassify" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>添加分类</h3>
                    </div>
                    <div class="modal-body">
                        <select name="globalConstDataValue1" id="whiteGlobalConstDataValue1">
                            <option>---请选择分类---</option>
                            <c:forEach var="platform" items="${amsPlatforms}">
                                <option value="${platform.globalConstDataValue}">${platform.globalConstDataName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-success" onclick="whiteClassifySubmit()">提交</a>
                        <a href="#" class="btn" data-dismiss="modal" onclick="closeWhiteClassify()">关闭</a>
                    </div>
                </div>
                <p><a data-toggle="modal" href="#cat" class="btn" onclick="addWhiteClassify()">添加分类</a></p>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="deleteWhite" onclick="deleteBlackWhite('/blackWhite/delete')"> 全部删除</a>
            </div>
            <div class="container" style="float:left;width:100px;">
                <a class="btn" href="javascript:void(0);" id="add"> 批量上传</a>
            </div>
            <table id="white"></table>
        </div>
    </div>
    <div style="clear: both;">
        <input type="button" class="btn btn-info" id="saveBrokerBtn" value=" 提交 ">
        <input type="button" class="btn btn-info" id="export" value=" 导出黑白名单 ">
    </div>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#black');
    //数据url
    var url_json = "${basePath}/blackWhite/list";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'black_white_id';
    //右上角刷新搜索
    var search = true;
    var showRefresh = true;
    var showColumns = true;
    //列配置项
    var dataColumns = [
        {field: 'blackwhite_id', title: '黑白名单ID'},
        {field: 'company_id', title: '公司ID'},
        {field: 'fin_instr_id', title: '金融工具ID'},
        {field: 'fin_instr_type',
            title: '金融工具类型',
            align: 'center',
            formatter: 'fin_instr_type',
            events: 'Events',
            clickToSelect: false
        },
        {
            field: 'blackwhite_list_type',
            title: '黑白名单范围',
            align: 'center',
            formatter: 'blackwhite_list_type',
            events: 'Events',
            clickToSelect: false
        },
        {field: 'operator_id', title: '创建人'}
    ];

    //白名单
    var $white = $('#white');
    //列配置项
    var whiteDataColumns = [
        {field: 'blackwhite_id', title: '黑白名单ID'},
        {field: 'company_id', title: '公司ID'},
        {field: 'fin_instr_id', title: '金融工具ID'},
        {field: 'fin_instr_type',
         title: '金融工具类型',
         align: 'center',
         formatter: 'fin_instr_type',
         events: 'Events',
         clickToSelect: false
        },
        {
            field: 'blackwhite_list_type',
            title: '黑白名单范围',
            align: 'center',
            formatter: 'blackwhite_list_type',
            events: 'Events',
            clickToSelect: false
        },
        {field: 'operator_id', title: '创建人'},
    ];
        $white.bootstrapTable({
            url:url_json + "?isBlack=1",
            datatype:'json',
            striped: true,
            search: search,
            showRefresh: showRefresh,
            showColumns: showColumns,
            minimumCountColumns: 2,
            clickToSelect: true,
            // detailView: true,
//            detailFormatter: 'detailFormatter',
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
            columns:whiteDataColumns
        });

        function fin_instr_type(value, row, index) {
            if(row.fin_instr_type == 1){
                return "股票"
            }else if(row.fin_instr_type == 2){
                return "期货"
            }else if(row.fin_instr_type == 3){
                return "期权"
            }
        }
        function blackwhite_list_type(value, row, index) {
            if (row.blackwhite_list_type == 1) {
                return "所有产品"
            } else if (row.blackwhite_list_type == 2) {
                return "指定产品单元"
            }
        }
    function addBlackCode(){
        $("#blackCode").show();

    }
    function closeBlack() {
        $("#blackCode").hide();
    }
    function addBlackClassify(){
        $("#blackClassify").show();
    }
    function closeBlackClassify() {
        $("#blackClassify").hide();
    }
    function addWhiteCode() {
        $("#whiteCode").show();
    }
    function closeWhiteCode() {
        $("#whiteCode").hide();
    }
    function addWhiteClassify(){
        $("#whiteClassify").show();
    }
    function closeWhiteClassify() {
        $("#whiteClassify").hide();
    }
    function blackSubmit() {
        var globalConstDataValue=$("#globalConstDataValue").val();
        var finInstrId=$("#finInstrId").val();
        $.ajax({
            type: 'POST',
            url: '${basePath}/blackWhite/createBlack?isBlack=1',
            data: {
                "globalConstDataValue":globalConstDataValue,
                "finInstrId":finInstrId
            } ,
            success: function (data) {
                if (data.code == '1') {
                    $("#blackCode").hide();
                    window.refresh();
                }
            } ,
            error: function () {
                alert("error");
            }

        });
    }
    function whiteSubmit() {
        var whiteGlobalConstDataValue=$("#whiteGlobalConstDataValue").val();
        var whiteFinInstrId=$("#whiteFinInstrId").val();
        $.ajax({
            type: 'POST',
            url: '${basePath}/blackWhite/createBlack',
            data: {
                "globalConstDataValue":whiteGlobalConstDataValue,
                "finInstrId":whiteFinInstrId
            } ,
            success: function (data) {
                if (data.code == '1') {
                    $("#whiteCode").hide();
                    window.refresh();
                }
            } ,
            error: function () {
                alert("error");
            }

        });
    }
    function blackClassifySubmit() {
        var globalConstDataValue1=$("#globalConstDataValue1").val();
        $.ajax({
            type: 'POST',
            url: '${basePath}/blackWhite/createBlack?isBlack=1',
            data: {
                "globalConstDataValue1":globalConstDataValue1,
            } ,
            success: function (data) {
                if (data.code == '1') {
                    $("#blackCode").hide();
                    window.refresh();
                }
            } ,
            error: function () {
                alert("error");
            }

        });
    }
    function whiteClassifySubmit() {
        var globalConstDataValue1=$("#whiteGlobalConstDataValue1").val();
        $.ajax({
            type: 'POST',
            url: '${basePath}/blackWhite/createBlack',
            data: {
                "globalConstDataValue1":globalConstDataValue1,
            } ,
            success: function (data) {
                if (data.code == '1') {
                    $("#whiteCode").hide();
                    window.refresh();
                }
            } ,
            error: function () {
                alert("error");
            }

        });
    }
    function deleteBlackWhite(url) {
        var deleteDialog = $.confirm({
            type: 'red',
            animationSpeed: 300,
            title: false,
            content: '确认删除吗？',
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'waves-effect waves-button',
                    action: function () {
                        $.ajax({
                            type: 'get',
                            url:url,
                            success: function () {
                                alert("删除成功");
                                deleteDialog.close();
                                $table.bootstrapTable('refresh');

                            },
                            error: function (XMLHttpRequest, textStatus) {
                                $.confirm({
                                    theme: 'dark',
                                    animation: 'rotateX',
                                    closeAnimation: 'rotateX',
                                    title: false,
                                    content: textStatus,
                                    buttons: {
                                        confirm: {
                                            text: '确认',
                                            btnClass: 'waves-effect waves-button waves-light'
                                        }
                                    }
                                });
                            }
                        });
                    }
                },
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    }
</script>
</body>
</html>