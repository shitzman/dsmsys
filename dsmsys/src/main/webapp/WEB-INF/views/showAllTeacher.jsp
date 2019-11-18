<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>teacherList</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
.t_list {
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
				<h3 align="center">教练列表</h3>
				<c:forEach var="teacher" items="${teacherList }">
					<div class="t_list">
						<table>
							<tr>
								<td colspan="4" align="center"><img alt="教练图片"
									src="${pageContext.request.contextPath }/img/${teacher.tImg }"
									width="240" height="220"></td>
							</tr>
							<tr>
								<td>姓名：</td>
								<td>${teacher.tName }</td>
								<td>性别</td>
								<td>${teacher.tSex }</td>
							</tr>
							<tr>
								<td>编号:</td>
								<td>${teacher.tId}</td>
								<td>车牌号：</td>
								<td>${teacher.cId }</td>
							</tr>
							<c:if test="${!empty sessionScope.admin }">
								<tr>
									<td colspan="2" align="center"><a
										href="${pageContext.request.contextPath}/admin/showstubyt?tId=${teacher.tId}"
										class="layui-btn layui-btn-sm">查询教练详情</a></td>
									<td colspan="2" align="center"><a
										href="${pageContext.request.contextPath}/teacher/deleteteacher?tId=${teacher.tId}"
										class="layui-btn layui-btn-sm layui-btn-danger">删除该教练</a></td>
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