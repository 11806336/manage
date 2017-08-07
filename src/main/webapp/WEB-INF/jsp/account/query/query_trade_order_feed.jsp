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
    <title>交易</title>
    <link href="${basePath}/resources/plugins/bootstrap-3.3.0/css/bootstrap2.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/css/select2.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/plugins/select2/theme/select2-bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${basePath}/resources/css/common.css">
</head>
<body>
<div id="main">

    <div class="control-group form-inline mt10 mb10">
        <div class="controls">
            <label for="dateStart">起始日期：</label>
            <input class="form-control" type="text" id="dateStart" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="dateStart" value="" readonly="readonly" style="background-color: #fff;cursor:pointer">
            <label for="dateEnd" style="margin-left: 10px;">结束日期:</label>
            <input class="form-control" type="text" id="dateEnd" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="dateEnd" value="" readonly="readonly" style="background-color: #fff;cursor:pointer">
            <input type="button" value="查询" class="btn" id="searchBtnIdata"  onclick="searchBtnIdata()"  style="margin-left: 20px;">
            <div class="btn-panel-right" style="float:right;">
                <button type="button" data-toggle="modal" class="btn" data-target="#exportModal" id="export_data">导出数据</button>
            </div>
        </div>
        <table id="table"></table>
    </div>
</div>
<jsp:include page="/resources/inc/foot.jsp" flush="true"/>
<script>
    var $table = $('#table');
    //列配置项
    var dataColumns = [
        {field: 'ck', checkbox: true},
        {field: 'stockOrderExecutionId', title: '成交ID'},
        {field: 'contractId', title: '合同编号'},
        {field: 'knockPrice', title: '成交价格'},
        {field: 'knockQty', title: '成交数量'},
        {field: 'knockDate', title: '成交时间'},
        {field: 'knockAmount', title: '成交金额'},
        {field: 'stockOrderType', title: '委托类别'},
        {field: 'fee', title: '手续费'},
        {
            field: 'action',
            title: '操作',
            align: 'center',
            formatter: 'actionFormatter',
            events: 'actionEvents',
            clickToSelect: true
        }
    ];
    //数据url
    var url_json = "/account/amsTradeOrderFeed";
    //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
    var sidePagination = 'server';
    //指定主键列
    var idField = 'companyId';
    //右上角刷新搜索
    var search = false;
    var showRefresh = false;
    var showColumns = false;
    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="panel(' + "'create_broker.html'" + "," + "'管理经纪公司'" + ')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
    function searchBtnIdata() {
        var dateStart = $('#dateStart').val();
        var dateEnd = $('#dateEnd').val();
        $table.bootstrapTable('refresh', {url: '${basePath}/account/amsTradeOrderFeed?dateStart=' + dateStart + "&dateEnd=" + dateEnd });
    }
</script>
</body>
</html>