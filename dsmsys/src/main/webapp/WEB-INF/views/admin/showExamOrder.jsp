<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员考试申请列表</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
		.mainblock{
		width: 900px;
		margin: 100px auto;
		padding-top: 20px;
	}

</style>
</head>
<body>
<jsp:include page="../head.jsp"/>
<div class="mainblock">
<table class="layui-table">
	<tr>
		<th>考试编号</th>
		<th>学员姓名：</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>手机号</th>
		<th>入学时间</th>
		<th colspan="2">操作</th>
		
	</tr>
	<c:choose>
		<c:when test="${ orderList.isEmpty()}">
			<td colspan="8" align="center">暂无学员约考信息</td>
		</c:when>
		
		<c:otherwise>
			<c:forEach var="key" items="${orderList.keySet() }">
				<tr>
					<td>${orderList.get(key) }</td>
					<td>${key.sName }</td>
					<td>${key.sSex }</td>
					<td>${key.sNumber }</td>
					<td>${key.sMobile }</td>
					<td>${key.sRegTime }</td>
					<td><a href="${pageContext.request.contextPath }/admin/ratifyexamyes?sId=${key.sId}&eId=${orderList.get(key) }" class="layui-btn layui-btn-normal">批准</a></td>
					<td><a href="${pageContext.request.contextPath }/admin/ratifyexamno?sId=${key.sId}" class="layui-btn layui-btn-danger">拒绝</a></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	
	</c:choose>
	
</table>
</div>
</body>
</html>