<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教练名下学员</title>
</head>
<body>
<jsp:include page="../head.jsp"/>

<div>
<h3>教练员详情信息：</h3>
	<table>
		<tr>
			<td>姓名：</td>
			<td>${teacher.tName }</td>
		</tr>
		<tr>
			<td>车牌号：</td>
			<td>${teacher.cId }</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>${teacher.tSex }</td>
		</tr>
		<tr>
			<td>所教科目：</td>
			<td>
				<c:choose>
					<c:when test="${teacher.tSubject==1}">
						科目一
					</c:when>
					<c:when test="${teacher.tSubject==2}">
						科目二
					</c:when>
					<c:when test="${teacher.tSubject==3}">
						科目三
					</c:when>
					<c:when test="${teacher.tSubject==4}">
						科目四
					</c:when>
				</c:choose>
			</td>
		</tr>
	</table>
</div>
<h3>所带学员信息：</h3>
<table border="1">

	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>手机号</th>
		<th>住址</th>
		<th>科目</th>
		<th>操作</th>
	</tr>

	<c:forEach var="stu" items="${stuList }">
		<tr>
			<td>${stu.sName }</td>
			<td>${stu.sSex }</td>
			<td>${stu.sNumber }</td>
			<td>${stu.sMobile }</td>
			<td>${stu.sAddress }</td>
			<td>
			
				<c:choose>
					<c:when test="${stu.sCurrent==1}">
						科目一
					</c:when>
					<c:when test="${stu.sCurrent==2}">
						科目二
					</c:when>
					<c:when test="${stu.sCurrent==3}">
						科目三
					</c:when>
					<c:when test="${stu.sCurrent==4}">
						科目四
					</c:when>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
</table>

<h3>车辆信息：</h3>
<h5 style="color: red">${msg }</h5>
<table>
	<tr>
		<td>车牌号:</td>
		<td>${car.cId }</td>
	</tr>
	
	<tr>
		<td>备注:</td>
		<td>${car.cRemark }</td>
	</tr>
	<tr>
	<form action="${pageContext.request.contextPath}/admin/linktandc" method="post">
		<td style="color: red">添加、更改所属车辆：</td>
		<input type="hidden" name = "tId" value="${teacher.tId }">
		<td>
			<select name="cId">
				<c:forEach var="carId" items="${carIdList }">
					<option value="${carId }">${carId }</option>
				</c:forEach>
			</select>
		</td>
		<td>
			<input type="submit" value="确定">
		</td>
	</form>
	</tr>
</table>


</body>
</html>