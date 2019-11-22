<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员信息查看页</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style>
	.stumsg{
		width:500px;
		height:300px;
		margin:50px auto;
	}

</style>
</head>
<body>
<jsp:include page="head.jsp"/>

<div class="stumsg">
<h4 align="center" style="color: red;">${msg }</h4>
<h4>欢迎您：[ ${student.sName }]</h4>
<hr><p>当前进度:</p>
<div class="layui-progress" lay-showPercent="true">
	<c:choose>
		<c:when test="${student.sCurrent >4}">
			<div class="layui-progress-bar layui-bg-red" lay-percent="4/4"></div>
		</c:when>
		<c:otherwise>
			<div class="layui-progress-bar layui-bg-red" lay-percent="${student.sCurrent}/4"></div>
		</c:otherwise>
	</c:choose>
</div>
<hr>
		
<table class="layui-table ">
	
	<tr>
		<td>身份证号：</td>
		<td>${student.sNumber }</td>
	</tr>
	<tr>
		<td>手机号</td>
		<td>${student.sMobile }</td>
	</tr>
	<tr>
		<td>性别</td>
		<td>${student.sSex }</td>
	</tr>
	<tr>
		<td>当前科目</td>
		<td>
			<c:choose>
				<c:when test="${student.sCurrent ==1 }">
					科目一
				</c:when>
				<c:when test="${student.sCurrent ==2 }">
					科目二
				</c:when>
				<c:when test="${student.sCurrent ==3 }">
					科目三
				</c:when>
				<c:when test="${student.sCurrent ==4 }">
					科目四
				</c:when>
				<c:when test="${student.sCurrent >4 }">
					<span style="color: red">恭喜拿证！</span>
				</c:when>
				<c:otherwise>
					等待管理员审批
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>当前考试状态</td>
		<td>
			<c:choose>
				<c:when test="${student.sStatus==1 }">
					已申请考试，请耐心等待管理员批准
				</c:when>
				<c:when test="${student.sStatus==2 }">
					已约考成功
				</c:when>
				<c:otherwise>
					未约考
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>报名时间</td>
		<td>
		<c:if test="${empty student.sRegTime }">
			等待管理员审批
		</c:if>
		${student.sRegTime}
		</td>
	</tr>
	<tr>
		<td>考试时间</td>
		<td>${student.sExTime }
			<c:if test="${empty student.sExTime}">
				未约考
			</c:if>
		</td>
	</tr>
	<tr>
		<td>住址</td>
		<td>${student.sAddress }
		<c:if test="${empty student.sAddress}">
			请尽快填写详细住址
		</c:if>
		</td>
	</tr>
	<tr>
		<c:if test="${!empty student }">
			<td>
				<a href="${pageContext.request.contextPath}/exam/showexammsg" class="layui-btn layui-btn-radius layui-btn-normal">可预约考试信息</a>
			</td>
			
			<td>
				<a href="${pageContext.request.contextPath }/showexamorder" class="layui-btn layui-btn-radius layui-btn-normal">已预约考试信息</a>
			</td>
		
		</c:if>
	
	</tr>
	
	<tr>
		<c:if test="${empty student.sId }">
			<td>
				<a href="${pageContext.request.contextPath}/login" 	class="layui-btn layui-btn-radius layui-btn-normal">去登录</a>
			</td>
		</c:if>
	</tr>
</table>

</div>

<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element;
		 
	}();

</body>
</html>