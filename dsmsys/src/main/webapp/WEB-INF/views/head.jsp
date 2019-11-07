<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>head</title>
</head>
<body>
	<h2>头部信息区</h2>
	
	<a href="${pageContext.request.contextPath}">首页</a>
	<c:choose>
		<c:when test="${ !empty sessionScope.student }">
			<span>欢迎您：${sessionScope.student.sName }</span>
			<span><a href="${pageContext.request.contextPath}/stulogout">退出登录</a></span>
			<a href="${pageContext.request.contextPath}/exam/showexammsg">显示可预约考试信息</a>
			<a href="${pageContext.request.contextPath }/showallteacher">查看学校教练情况</a>
			<a href="${pageContext.request.contextPath }/car/showallcar">查看学校车辆情况</a>
			<a href="${pageContext.request.contextPath }/showexamorder">查看已预约考试信息</a>
		</c:when>
		
		<c:when test="${!empty sessionScope.admin }">
			<span>欢迎您：${sessionScope.admin.admName }--【管理员】</span>
			<span><a href="${pageContext.request.contextPath}/admin/adminlogout">退出登录</a></span>
			<a href="${pageContext.request.contextPath }/admin/showallstubyaccount">学员申请列表</a>
			<a href="${pageContext.request.contextPath }/admin/showallstu">所有在校学员</a>
			<a href="${pageContext.request.contextPath }/addteacher">添加教练</a>
			<a href="${pageContext.request.contextPath }/showallteacher">显示所有教练</a>
			<a href="${pageContext.request.contextPath }/car/addcar">添加车辆</a>
			<a href="${pageContext.request.contextPath }/car/showallcar">显示所有车辆</a>
			<a href="${pageContext.request.contextPath }/admin/showexamorder">显示学员预约考试信息</a>
			<a href="${pageContext.request.contextPath }/admin/addexammsg">添加考试信息</a>
			<a href="${pageContext.request.contextPath }/admin/showexammsg">查询所有已发布考试信息</a>
			
			<a href="${pageContext.request.contextPath }/showallteacher">查看学校教练情况</a>
			<a href="${pageContext.request.contextPath }/car/showallcar">查看学校车辆情况</a>
		
		</c:when>
		
		<c:otherwise>
			<span><a href="${pageContext.request.contextPath}/login">登录</a></span>
			<a href="${pageContext.request.contextPath }/showallteacher">查看学校教练情况</a>
			<a href="${pageContext.request.contextPath }/car/showallcar">查看学校车辆情况</a>
		</c:otherwise>
	</c:choose>

	
</body>
</html>