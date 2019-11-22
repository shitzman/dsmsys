<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生考试信息</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
	.mainblock{
		width: 650px;
		height: 300px;
		margin: 100px auto;
		padding-top: 70px;
	}

</style>
</head>
<body>
<div class="mainblock">
	<table class="layui-table">
		<tr>
			<td colspan="7" align="center" style="color: red">考试记录</td>
		</tr>
		<tr>
			<th>考试id</th>
			<th>考试时间</th>
			<th>考试地点</th>
			<th>考试科目</th>
			<th>是否通过</th>
			<th>考试分数</th>
			<th>备注信息</th>
		</tr>
			<c:choose>
				<c:when test="${remarkList.size() !=0 }">
					<c:forEach var="remark" items="${remarkList }">
						<tr>
							<td>${remark.eId }</td>
							<td>${remark.exammsg.eTime }</td>
							<td>${remark.exammsg.eAddress }</td>
							<td>${remark.exammsg.eSubject }</td>
							<td>
								<c:choose>
									<c:when test="${remark.rStatus ==0}">
										待考
									</c:when>
									<c:when test="${remark.rStatus ==1}">
										通过
									</c:when>
									<c:when test="${remark.rStatus ==2}">
										挂科
									</c:when>
								</c:choose>
							</td>
							<td>${remark.rScore }</td>
							<td>${remark.rRemark }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
					<td colspan="7" align="center">暂无历史考试记录</td>
					</tr>
				</c:otherwise>
			
			</c:choose>
	
	</table>


</div>

	
</body>
</html>