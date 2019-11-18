<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加教练信息</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">

	.mainList{
		width:900px;
		height:600px;
		margin:100px auto;
	}
	.maininput{
		width: 300px;
	}
</style>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4 style="color: red">${msg }</h4>
<%
	String[] tSubjectList = {"1","2","3","4"};
%>
<div class="mainList">
<form action="addteacher" enctype="multipart/form-data" method="post" class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">所管车辆：</label>
			<div class="layui-input-block maininput">
				<select name="cId" lay-verify="required" style="width: 300px;">
					<c:forEach var="carId" items="${carIdList }">
						<option value="${carId }">${carId }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		
		<div class="layui-form-item">
			<label class="layui-form-label">姓名：</label>
			<div class="layui-input-block maininput">
				<input type="text" name="tName" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别：</label>
			<div class="layui-input-block maininput">
				<input type="text" name="tSex" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">所教科目：</label>
			<div class="layui-input-block maininput" >
				<select name="tSubject" >
					<c:forEach var="t" items="<%=tSubjectList %>">
						<option value="${t }">科目${t }</option>
					</c:forEach>
				</select>
				
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">照片：</label>
			<div class="layui-input-block">
				<input type="file" name="tImgFile" >
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			</div>
		</div>
	
</form>

</div>
<script src="../layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element;
	}();
</script>

</body>
</html>