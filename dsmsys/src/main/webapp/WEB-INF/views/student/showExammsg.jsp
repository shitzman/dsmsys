<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考试信息展示页</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h3>考试信息展示页</h3>
<h4>${msg }</h4>
<table border="1">
	<tr>
		<th>考试编号</th>
		<th>考试时间</th>
		<th>考试科目</th>
		<th>考试地址</th>
		<th>可报考人数</th>
		<th>已报考人数</th>
		<th>操作</th>
	</tr>
	<c:forEach var="exam" items="${examList }">
		<tr>	
			<td>${exam.eId }</td>
			<td>${exam.eTime }</td>
			<td>${exam.eSubject }</td>
			<td>${exam.eAddress }</td>
			<td>${exam.eAllNum }</td>
			<td>${exam.eAlrNum }</td>
			<c:choose>
				<c:when test="${sStatus == 0 }">
					<td><a href="${pageContext.request.contextPath }/addexamorder?eId=${exam.eId }">点击预约此考试</a></td>
				</c:when>
				<c:when test="${sStatus ==1 }">
					<td>你已成功提交申请，请耐心等待</td>
				</c:when>
				<c:when test="${sStatus ==2 }">
					<td><a href = "${pageContext.request.contextPath }/showexamorder">你已成功预约编号为${eId}的考试，点击查看考试信息</a></td>
				</c:when>
				<c:when test="${sStatus ==3 }">
					<td><a href = "${pageContext.request.contextPath }/addexamorder?eId=${exam.eId }">你的考试申请已被拒绝，点击重新申请</a></td>
				</c:when>
				
				<c:otherwise>
					<td><a href="#">删除考试信息</a></td>
				</c:otherwise>
			</c:choose>
			
		</tr>
	</c:forEach>

</table>
</body>
</html>