<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考试信息展示页</title>
<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4>${msg }</h4>

<div class="layui-layui-fluid">
		<div class="layui-row">
			<h2 align="center">考试信息展示页顶部区域</h2>
			<h2 align="center">|</h2>
			<h2 align="center">|</h2>
			<h2 align="center">|</h2>
		</div>
		
		<div class="layui-row">
			<div class="layui-col-md1">
				<h4 align="center">考试信息展示页左侧栏</h4>
			</div>
			
		<div class="layui-col-md10 " style="background-color: #c2c2c2">
<table class="layui-table">
	<tr>
		<th>考试编号</th>
		<th>考试时间</th>
		<th>考试科目</th>
		<th>考试地址</th>
		<th>可报考人数</th>
		<th>已报考人数</th>
		<th>操作</th>
	</tr>
	<c:choose>
		<c:when test="${examList.size()==0 }">
			<tr>
				<td colspan="6" align="center">暂无任何可约考信息</td>
			</tr>
		</c:when>
		<c:otherwise>
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
		
		
		</c:otherwise>
	</c:choose>
	

</table>

		</div>
			<div class="layui-col-md1">
				<h4 align="center">考试信息展示页右侧栏</h4>
			</div>
		</div>
	</div>

<script src="../layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element;
	}();
</script>
</body>
</html>