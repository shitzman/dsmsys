<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"">
<title>参加此次考试的学员信息</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
		.mainblock{
		width: 900px;
		margin: 0px auto;
		padding-top: 20px;
	}

</style>
</head>
<body>
<h2 align="center">参加编号为【${remarkList[0].eId }】的学员如下</h2>
<hr>
<div class="mainblock">
	<table class="layui-table">
		<tr>
			<th>学生id</th>
			<th>学生姓名</th>
			<th>性别</th>
			<th>手机号</th>
			<th>地址</th>
			<th>通过情况</th>
			<th>考试分数</th>
			<th>备注信息</th>
		</tr>
		
		<c:forEach var="remark" items="${remarkList }">
			<tr>
				<td>${remark.sId}</td>
				<td>${remark.student.sName}</td>
				<td>${remark.student.sSex}</td>
				<td>${remark.student.sMobile}</td>
				<td>${remark.student.sAddress}</td>
				<td>
					<c:choose>
						<c:when test="${remark.rStatus ==1}">
							通过
						</c:when>
						<c:when test="${remark.rStatus ==2}">
							挂科
						</c:when>
						<c:otherwise>
							待录入考试信息
						</c:otherwise>
					</c:choose>
					
				
				</td>
				<td>${remark.rScore}</td>
				<td>${remark.rRemark}</td>
			</tr>
		</c:forEach>
		
	</table>

</div>
</body>
</html>