<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车辆列表</title>

<style type="text/css">
	.c_list{
		border: solid 1px red;
		margin: 5px;
		height: 300px;
		width: 300px;
		display: inline-block;
	}
</style>
</head>
<body>

<jsp:include page="head.jsp"/>
<h3>教练列表</h3>
<c:forEach var="car" items="${carList }">
	<div class="c_list">
		<table>
			<tr>
				<td colspan="2">
					<img alt="车辆图片" src="${pageContext.request.contextPath }/img/${car.cImg }" width="240" height="220">
				</td>
			</tr>	
			<tr>
				<td>车牌号：</td>
				<td>${car.cId }</td>
			</tr>
			<tr>
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
		</table>
	</div>
</c:forEach>

</body>
</html>