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
<div class="block-body">
    <div class="container" style="float:left;width:100px;">
        <div id="code1">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">×</a>
                <h3>添加</h3>
            </div>
            <div class="modal-body">
                <input type="text" id="market" name="" placeholder="请输入市场">
                <input type="text" id="code" name="" placeholder="请输入证券代码">
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-success">提交</a>
                <a href="#" class="btn" data-dismiss="modal">关闭</a>
            </div>
        </div>

    </div>
</div>
</body>
</html>