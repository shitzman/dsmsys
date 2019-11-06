<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员考试申请列表</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<table border="1">
	<tr>
		<th>考试编号</th>
		<th>学员姓名：</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>手机号</th>
		<th>入学时间</th>
		<th colspan="2">操作</th>
		
	</tr>
	<c:forEach var="key" items="${orderList.keySet() }">
		<tr>
			<td>${orderList.get(key) }</td>
			<td>${key.sName }</td>
			<td>${key.sSex }</td>
			<td>${key.sNumber }</td>
			<td>${key.sMobile }</td>
			<td>${key.sRegTime }</td>
			<td><a href="${pageContext.request.contextPath }/admin/ratifyexamyes?sId=${key.sId}&eId=${orderList.get(key) }">--批准--</a></td>
			<td><a href="${pageContext.request.contextPath }/admin/ratifyexamno?sId=${key.sId}">--拒绝--</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>