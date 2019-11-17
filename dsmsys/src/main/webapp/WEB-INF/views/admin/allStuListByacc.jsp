<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员申请列表</title>
<link rel="stylesheet" href="../layui/css/layui.css">

</head>
<body>
	<jsp:include page="../head.jsp" />
	<div class="layui-layui-fluid">
		<div class="layui-row">
			<h2 align="center">所有学员列表顶部区域</h2>
			<h2 align="center">|</h2>
			<h2 align="center">|</h2>
			<h2 align="center">|</h2>
		</div>
		
		<div class="layui-row">
			<div class="layui-col-md1">
				<h4 align="center">所有学员列表左侧栏</h4>
			</div>
			
		<div class="layui-col-md10 " style="background-color: #c2c2c2">
	<table class="layui-table">
		<tr>
			<th>姓名：</th>
			<th>性别：</th>
			<th>身份证号：</th>
			<th>手机号：</th>
			<th>住址：</th>
			<th>操作</th>
		</tr>
		<c:forEach var="stu" items="${stuListAcc }">
			<tr>
				<td>${stu.sName }</td>
				<td>${stu.sSex }</td>
				<td>${stu.sNumber }</td>
				<td>${stu.sMobile }</td>
				<td>${stu.sAddress }</td>
				<td><a href="${pageContext.request.contextPath }/admin/ratifystu?sId=${stu.sId } class="layui-btn layui-btn-sm">批准入学</a></td>
			</tr>
		</c:forEach>
	</table>
	
		</div>
			<div class="layui-col-md1">
				<h4 align="center">所有学员列表右侧栏</h4>
			</div>
		</div>
	</div>

<script src="../layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element;
	}();
</script>
</body>
</html>