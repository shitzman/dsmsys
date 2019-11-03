<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>head</title>
</head>
<body>
<div style="border: solid 2px green;">
	<h2>头部信息区</h2>
	<a href="${pageContext.request.contextPath }">首页</a>
	
	<c:choose>
		<c:when test="${ !empty sessionScope.student }">
			<span>欢迎您：${sessionScope.student.sName }</span>
			<span><a href="${pageContext.request.contextPath}/stulogout">退出登录</a></span>
		</c:when>
		
		<c:when test="${!empty sessionScope.admin }">
			<span>欢迎您：${sessionScope.admin.admName }--【管理员】</span>
			<span><a href="${pageContext.request.contextPath}/admin/adminlogout">退出登录</a></span>
		</c:when>
		
		<c:otherwise>
			<span><a href="${pageContext.request.contextPath}/login">登录</a></span>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>