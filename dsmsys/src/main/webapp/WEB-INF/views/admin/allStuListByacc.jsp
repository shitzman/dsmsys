<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员申请列表</title>
</head>
<body>
	<jsp:include page="../head.jsp" />
	<h3>学员申请列表</h3>
	<table border="1">
		<c:forEach var="stu" items="${stuListAcc }">
			<tr>
				<td>姓名：${stu.sName }</td>
				<td>性别：${stu.sSex }</td>
				<td>身份证号：${stu.sNumber }</td>
				<td>手机号：${stu.sMobile }</td>
				<td>住址：${stu.sAddress }</td>
				<td><a href="${pageContext.request.contextPath }/admin/ratifystu?sId=${stu.sId }">批准入学</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>