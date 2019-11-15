<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>录入结果</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h1 style="color: red">${warnings }</h1>
<c:choose>
	<c:when test="${!empty stuEnd }">
		<h2 style="color: red">${msg }</h2>
		<table>
			<tr><td>姓名：</td><td>${stuEnd.sName }</td></tr>
			<tr><td>身份证号：</td><td>${stuEnd.sNumber }</td></tr>
			<tr><td>手机号</td><td>${stuEnd.sMobile }</td></tr>
			<tr><td>住址</td><td>${stuEnd.sAddress }</td></tr>
		</table>
	</c:when>
	
	<c:when test="${!empty stu }">
		<h4 style="color: red">${msg1 }</h4>
		<table>
			<tr><td>姓名：</td><td>${stu.sName }</td></tr>
			<tr><td>身份证号：</td><td>${stu.sNumber }</td></tr>
			<tr><td>手机号</td><td>${stu.sMobile }</td></tr>
			<tr><td>性别</td><td>${stu.sSex }</td></tr>
			<tr>
				<td>下个科目</td>
				<td>
					<c:choose>
						<c:when test="${stu.sCurrent ==1 }">
							科目一
						</c:when>
						<c:when test="${stu.sCurrent ==2 }">
							科目二
						</c:when>
						<c:when test="${stu.sCurrent ==3 }">
							科目三
						</c:when>
						<c:when test="${stu.sCurrent ==4 }">
							科目四
						</c:when>
					</c:choose>
				</td>
			</tr>
			
		</table>
		
	</c:when>
	
	<c:otherwise>
		<h4 style="color: red">${msg }</h4>
		<table>
			<tr>
				<td>学员编号：</td>
				<td>${student.sId }</td>
			</tr>
			<tr>
				<td>学员姓名：</td>
				<td>${student.sName }</td>
			</tr>
			<tr>
				<td>考试编号：</td>
				<td>${remark.eId }</td>
			</tr>
			<tr>
				<td>考试分数：</td>
				<td>${remark.rScore }</td>
			</tr>
			<tr>
				<td>备注信息：</td>
				<td>${remark.rRemark }</td>
			</tr>
		
		</table>
	</c:otherwise>

</c:choose>
</body>
</html>