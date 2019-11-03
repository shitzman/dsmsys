<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理界面</title>
</head>
<body>
<jsp:include page="adminHead.jsp"/>
<h4 style="color: red">${msg }</h4>
你好a，${sessionScope.admin.admName}
<a href="admin/showallstubyaccount">学员申请列表</a>
<a href="admin/showallstu">所有学员</a>

</body>
</html>