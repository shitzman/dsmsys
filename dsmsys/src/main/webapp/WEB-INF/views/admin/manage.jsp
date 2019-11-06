<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理界面</title>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4 style="color: red">${msg }</h4>
你好a，${sessionScope.admin.admName}
<a href="${pageContext.request.contextPath }/admin/showallstubyaccount">学员申请列表</a>
<a href="${pageContext.request.contextPath }/admin/showallstu">所有在校学员</a>
<a href="${pageContext.request.contextPath }/addteacher">添加教练</a>
<a href="${pageContext.request.contextPath }/showallteacher">显示所有教练</a>
<a href="${pageContext.request.contextPath }/car/addcar">添加车辆</a>
<a href="${pageContext.request.contextPath }/car/showallcar">显示所有车辆</a>
<a href="${pageContext.request.contextPath }/admin/showexamorder">显示学员预约考试信息</a>

</body>
</html>