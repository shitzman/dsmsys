<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考试预约信息</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4 style="color: red">${msg }</h4>
<table border="1">
	<tr>
		<td>考试编号</td>
		<td>${exammsg.eId }</td>
	</tr>
	<tr>
		<td>考试时间</td>
		<td>${exammsg.eTime }</td>
	</tr>
	<tr>
		<td>考试地址</td>
		<td>${exammsg.eAddress }</td>
	</tr>
	<tr>
		<td>考试科目</td>
		<td>${exammsg.eSubject }</td>
	</tr>
</table>
</body>
</html>