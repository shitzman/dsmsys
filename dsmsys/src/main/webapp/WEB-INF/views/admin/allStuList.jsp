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
		<c:forEach var="stu" items="${stuList }">
			<tr>
				<td>姓名：${stu.sName }</td>
				<td>性别：${stu.sSex }</td>
				<td>身份证号：${stu.sNumber }</td>
				<td>手机号：${stu.sMobile }</td>
				<td>住址：${stu.sAddress }</td>
			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>