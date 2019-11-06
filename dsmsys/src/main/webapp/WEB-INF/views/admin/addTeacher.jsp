<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加教练信息</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4 style="color: red">${msg }</h4>
<%
	String[] tSubjectList = {"1","2","3","4"};
%>
<form action="addteacher" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td>所管车辆：</td>
			<td>
				<select name="cId">
					<c:forEach var="carId" items="${carIdList }">
						<option value="${carId }">${carId }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td>
				<input type="text" name="tName" >
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<input type="text" name="tSex" >
			</td>
		</tr>
		<tr>
			<td>所教科目：</td>
			<td>
				<select name="tSubject">
					<c:forEach var="t" items="<%=tSubjectList %>">
						<option value="${t }">科目${t }</option>
					</c:forEach>
				</select>
				
			</td>
		</tr>
		<tr>
			<td>照片：</td>
			<td>
				<input type="file" name="tImgFile" >
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="提交">
			</td>
		</tr>
	
	
	</table>
	
</form>

</body>
</html>