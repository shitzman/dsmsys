<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">

</style>
<title>学员申请界面</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<h4 style="color: red">${msg }</h4>
	<form action="adduser" method="post">
		<table>
			<tr>
				<td>身份证号：</td>
				<td><input type="text" name="sNumber"></td>
			</tr>

			<tr>
				<td>姓名：</td>
				<td><input type="text" name="sName"></td>
			</tr>

			<tr>
				<td>性别：</td>
				<td><input type="text" name="sSex"></td>
			</tr>

			<tr>
				<td>手机号：</td>
				<td><input type="text" name="sMobile"></td>
			</tr>

			<tr>
				<td>密码：</td>
				<td><input type="password" name="sPassword"></td>
			</tr>

			<tr>
				<td>住址：</td>
				<td><input type="text" name="sAddress"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="注册"></td>
			</tr>

		</table>

	</form>



</body>
</html>