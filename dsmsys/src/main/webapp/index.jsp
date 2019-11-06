<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>

<a href="regstudent">学员申请</a>
<a href="login">登录</a>
<a href="${pageContext.request.contextPath }/showallteacher">查看学校教练情况</a>
<a href="${pageContext.request.contextPath }/car/showallcar">查看学校车辆情况</a>
</body>
</html>
