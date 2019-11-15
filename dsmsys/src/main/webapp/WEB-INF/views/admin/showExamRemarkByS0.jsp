<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>待考学员记录</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<table border="1">
	<tr>
		<th>学员id：</th>
		<th>姓名：</th>
		<th>考试编号：</th>
		<th>考试科目</th>
		<th>考试地点：</th>
		<th>考试时间：</th>
		<th>考试分数：</th>
		<th>备注</th>
		<th>操作</th>
	</tr>
	<c:forEach var="re" items="${reList }">
		<form action="${pageContext.request.contextPath}/admin/updateremark" method="post">
			<input type="hidden" name="sId" value="${re.sId }">
			<input type="hidden" name="eId" value="${re.eId }">
			<tr>
				<td>${re.sId }</td>
				<td>${re.student.sName }</td>
				<td>${re.eId }</td>
				<td>${re.exammsg.eSubject }</td>
				<td>${re.exammsg.eAddress}</td>
				<td>${re.exammsg.eTime }</td>
				<td>
					<input type="text" name="rScore">
				</td>
				<td>
					<input type="text" name="rRemark">
				</td>
				<td>
					<input type="submit" value="更新该考试记录">
				</td>
			</tr>
		</form>
	</c:forEach>
</table>
</body>
</html>