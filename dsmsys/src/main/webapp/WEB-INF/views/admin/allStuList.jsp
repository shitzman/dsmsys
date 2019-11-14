<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有学员列表</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<div>
<h3>所有学员列表</h3>
	<table border="1">
		<tr>
			<th>姓名：</th>
			<th>性别：</th>
			<th>身份证号：</th>
			<th>手机号：</th>
			<th>住址：</th>
			<th>分配教练：</th>
			<th>操作</th>
		</tr>
		<c:forEach var="stu" items="${stuList }">
			<tr>
				<td>${stu.sName }</td>
				<td>${stu.sSex }</td>
				<td>${stu.sNumber }</td>
				<td>${stu.sMobile }</td>
				<td>${stu.sAddress }</td>
				<td>${stu.tId}</td>
				<td><a href="#">确定</a></td>
			</tr>
			
			
		</c:forEach>
	</table>

</div>
</body>
</html>