<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教练详情</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style>
	.tmsg{
		width:800px;
		height:300px;
		margin:50px auto;
	}

</style>
</head>
<body>
<jsp:include page="../head.jsp"/>

<div class="tmsg">
	<table class="layui-table">
		<tr>
			<td colspan="2" align="center" > <span class="layui-badge-dot"></span> 教练员详情信息：</td>
		</tr>
		<tr>
			<td>编号：</td>
			<td>${teacher.tId }</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td>${teacher.tName }</td>
		</tr>
		<tr>
			<td>车牌号：</td>
			<td>${teacher.cId }</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>${teacher.tSex }</td>
		</tr>
		<tr>
			<td>所教科目：</td>
			<td>
				<c:choose>
					<c:when test="${teacher.tSubject==1}">
						科目一
					</c:when>
					<c:when test="${teacher.tSubject==2}">
						科目二
					</c:when>
					<c:when test="${teacher.tSubject==3}">
						科目三
					</c:when>
					<c:when test="${teacher.tSubject==4}">
						科目四
					</c:when>
				</c:choose>
			</td>
		</tr>

	<tr>
		<td colspan="2" align="center"> <span class="layui-badge-dot"></span> 车辆信息：${msg }</td>
	</tr>
	<tr>
		<td>车牌号:</td>
		<td>${car.cId }</td>
	</tr>
	
	<tr>
		<td>备注:</td>
		<td>${car.cRemark }</td>
	</tr>
	<tr>
	<tr>
		<td style="color: red" colspan="2" align="center">添加、更改所属车辆：</td>
	</tr>
	<tr>
		<form action="${pageContext.request.contextPath}/admin/linktandc" method="post" class="layui-form">
		
			<input type="hidden" name = "tId" value="${teacher.tId }">
			<div>
			<td class="layui-input-block">
				<select name="cId" lay-verify="required">
					<c:forEach var="carId" items="${carIdList }">
						<option value="${carId }">${carId }</option>
					</c:forEach>
				</select>
				
				
			</td>
			
			<td>
				<input type="submit" value="确定" 	class="layui-btn layui-btn-sm layui-btn-danger">
			</td>
		</form>
	</tr>
</table>

<h3>所带学员信息：</h3>
<table class="layui-table">

	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>身份证号</th>
		<th>手机号</th>
		<th>住址</th>
		<th>科目</th>
		<th>操作</th>
	</tr>

	<c:forEach var="stu" items="${stuList }">
		<tr>
			<td>${stu.sName }</td>
			<td>${stu.sSex }</td>
			<td>${stu.sNumber }</td>
			<td>${stu.sMobile }</td>
			<td>${stu.sAddress }</td>
			<td>
			
				<c:choose>
					<c:when test="${stu.sCurrent==1}">
						科目一
					</c:when>
					<c:when test="${stu.sCurrent==2}">
						科目二
					</c:when>
					<c:when test="${stu.sCurrent==3}">
						科目三
					</c:when>
					<c:when test="${stu.sCurrent==4}">
						科目四
					</c:when>
				</c:choose>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/relievetcandstu?sId=${stu.sId}&tId=${stu.tId}" class="layui-btn layui-btn-sm layui-btn-danger">解除关系</a>
			</td>
		</tr>
	</c:forEach>
</table>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.all.js" charset="utf-8"></script>
<script>
;!function(){
  var layer = layui.layer
  ,form = layui.form
  ,element = layui.element;
 
}();
</script> 
</body>
</html>