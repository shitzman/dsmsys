<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有学员列表</title>
<link rel="stylesheet" href="../layui/css/layui.css">

<style type="text/css">

	.mianList{
		width:900px;
		height:600px;
		margin:100px auto;
	}
</style>
</head>
<body>
<jsp:include page="../head.jsp"/>

<div class="mianList">
	<h4 align="center">${msg }</h4>
	<h3 align="center">所有在校学员列表</h3>
	<table class="layui-table">
		<tr>
			<th>姓名：</th>
			<th>性别：</th>
			<th>身份证号：</th>
			<th>手机号：</th>
			<th>住址：</th>
			<th>当前科目</th>
			<th>当前分配教练：</th>
			<th>学员可分配教练编号：</th>
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
						<c:when test="${stu.sCurrent ==1 }">
							科目一
						</c:when>
						<c:when test="${stu.sCurrent ==2 }">
							科目二
						</c:when>
						<c:when test="${stu.sCurrent ==3 }">
							科目三
						</c:when>
						<c:when test="${stu.sCurrent ==4 }">
							科目四
						</c:when>
						<c:otherwise>
							等待管理员审批
						</c:otherwise>
					</c:choose>
				
				
				</td>
				<td>${stu.tId}</td>
				<form action="${pageContext.request.contextPath}/admin/linkstuandt" method="get" class="layui-form">
					<input type="hidden" name="sId" value="${stu.sId }">
					
					<td> 
						<c:choose>
							<c:when test="${stu.tIdList.size()==0 }">
								当前科目暂无教练
							</c:when>
							
							<c:otherwise>
								<select name="tId" >
									<c:forEach var="tId" items="${stu.tIdList }">
									<option value="${tId }">${tId }</option>
									</c:forEach>
								</select>
							</c:otherwise>
						</c:choose>
						
					</td>
					<td><input type="submit" value="确定" class="layui-btn layui-btn-sm"></td>
				</form>
			</tr>
		</c:forEach>
	</table>

	
</div>

<script src="../layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element;
	}();
</script>


</body>
</html>