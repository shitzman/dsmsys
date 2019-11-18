<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>carList</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
.c_list {
	margin: 5px;
	height: 330px;
	width: 300px;
	display: inline-block;
	background-color: #d2d2d2;
	margin: 20px;
	padding: 5px;
}

.mianList{
		width:1080px;
		margin:100px auto;
	}


table tr td{
padding:5px;
}

</style>
</head>
<jsp:include page="head.jsp"/>
<body style="background-color: #F0F0F0">

<div class="mianList" style="background-color: #c2c2c2">
				<h4 align="center" style="color: red">${msg }</h4>
				<h3 align="center">所有车辆列表</h3>
<c:forEach var="car" items="${carList }">
	<div class="c_list">
		<table>
			<tr>
				<td colspan="4">
					<img alt="车辆图片" src="${pageContext.request.contextPath }/img/${car.cImg }" width="240" height="220">
				</td>
			</tr>	
			<tr>
				<td>车牌号：</td>
				<td>${car.cId }</td>
			
				<td>车辆状态：</td>
				<c:choose>
					<c:when test="${car.cStatus == 1 }">
						<td>可用</td>
					</c:when>
					<c:otherwise>
						<td>不可用</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>备注：</td>
				<td>${car.cRemark }</td>
			</tr>
			<c:if test="${!empty sessionScope.admin }">
				<tr>
					<td colspan="2" align="center"></td>
					<td colspan="2" align="center"><a href="${pageContext.request.contextPath}/car/deletecar?cFlag=${car.cFlag}" class="layui-btn layui-btn-sm layui-btn-danger">删除该车辆</a></td>
				</tr>
			</c:if>
		</table>
	</div>
</c:forEach>
</div>


	
<script src="../layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element;
	}();
</script>
</body>
</html>