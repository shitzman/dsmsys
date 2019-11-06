<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有教练列表</title>
<style type="text/css">
	.t_list{
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
<c:forEach var="teacher" items="${teacherList }">
	<div class="t_list">
		<table>
			<tr>
				<td colspan="2">
					<img alt="教练图片" src="img/${teacher.tImg }" width="240" height="220">
				</td>
			</tr>	
			<tr>
				<td>姓名：</td>
				<td>${teacher.tName }</td>
			</tr>	
			<tr>
				<td>性别</td>
				<td>${teacher.tSex }</td>
			</tr>
			<tr>
				<td>车牌号：</td>
				<td>${teacher.cId }</td>
			</tr>
		</table>
	</div>
</c:forEach>

</body>
</html>