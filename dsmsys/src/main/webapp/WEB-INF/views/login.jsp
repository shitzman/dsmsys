<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<h5 style="color: red">${msg }</h5>
<form action="${pageContext.request.contextPath}/login" method="post">
	<table>
		<tr>
			<td>手机号：</td>
			<td><input type="text" name="mobile" value="${mobile }"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>选择登录身份：</td>
		</tr>
		<tr>
			<td>管理员</td>
			<td><input type="radio" name="type" value="0"></td>
		</tr>
		<tr>
			<td>学员</td>
			<td><input type="radio" name="type" value="1" checked="checked"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="登录"> </td>
		</tr>
	
	</table>
</form>

</body>
</html>