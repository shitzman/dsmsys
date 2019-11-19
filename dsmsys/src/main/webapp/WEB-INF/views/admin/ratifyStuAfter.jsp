<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改成果界面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
<style type="text/css">
	.mainblock{
		width: 500px;
		height: 300px;
		margin: 100px auto;
		padding-top: 70px;
	}

</style>
</head>
<body>
<jsp:include page="../head.jsp"/>

<div class="mainblock">
	<c:choose>
		<c:when test="${empty student }">
			<div>
				<h4>审批失败！</h4>
				<a href="${pageContext.request.contextPath }/admin/showallstubyaccount">返回学员申请列表</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<h4>审批成功</h4>
				<table class="layui-table">
					<tr>
						<td>姓名</td>
						<td>${student.sName }</td>
					</tr>
					<tr>
						<td>入学时间</td>
						<td>${student.sRegTime }</td>
					</tr>
				</table>
				<a href="${pageContext.request.contextPath }/admin/showallstu" 	class="layui-btn layui-btn-sm">返回在校学员列表</a>
			</div>
		</c:otherwise>
	</c:choose>
	
</div>
</body>
</html>