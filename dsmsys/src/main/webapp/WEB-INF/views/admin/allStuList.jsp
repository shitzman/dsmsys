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
		<tr>
			<th>姓名：</th>
			<th>性别：</th>
			<th>身份证号：</th>
			<th>手机号：</th>
			<th>住址：</th>
			<th>当前分配教练：</th>
			<th>重新分配教练：</th>
			<th>操作</th>
		</tr>
		<c:forEach var="stu" items="${stuList }">
			<tr>
				<td>${stu.sName }</td>
				<td>${stu.sSex }</td>
				<td>${stu.sNumber }</td>
				<td>${stu.sMobile }</td>
				<td>${stu.sAddress }</td>
				<td>${stu.tId}</td>
				<form action="${pageContext.request.contextPath}/admin/linkstuandt" method="get">
					<input type="hidden" name="sId" value="${stu.sId }">
					<td>
						<select name="tId">
							<c:forEach var="tId" items="${tIdList }">
							<option value="${tId }">${tId }</option>
							</c:forEach>
						</select>
					</td>
					<td><input type="submit" value="确定"></td>
				</form>
			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>