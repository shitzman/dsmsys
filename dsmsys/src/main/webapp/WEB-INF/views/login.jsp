<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body style="background-color:#F0F0F0">
<jsp:include page="head.jsp"/>
<h5 style="color: red">${msg }</h5>

<div class="layui-layui-fluid">   
<div class="layui-row">
	<h2 align="center">顶部区域</h2>
	<h2 align="center">|</h2>
	<h2 align="center">|</h2>
	<h2 align="center">|</h2>
</div>

<div class="layui-row">
	<div class="layui-col-md3">
		<h4 align="center">左侧栏</h4>
	</div>
	<div class="layui-col-md6 " style="background-color:#c2c2c2">
	<form action="${pageContext.request.contextPath}/login" method="post" class="layui-form" style="margin:80px auto">
	
	
		<div class="layui-form-item">
			<label class="layui-form-label">手机号：</label>
			<div class="layui-input-block">
				<input type="text" name="mobile" value="${mobile }" required class="layui-input" style="width: 300px;">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码：</label>
			<div class="layui-input-block">
				<input type="password" name="password" required class="layui-input" style="width: 300px;">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">登录身份:</label>
			<div class="layui-input-block">
				<input type="radio" name="type" value="0" title="管理员"></td>
				<input type="radio" name="type" value="1" title="学员" checked="checked" >
			</div>
		</div>
		
		 <div class="layui-form-item">
			<div class="layui-input-block">
			  <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
			  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>

	</form>
	</div>
	<div class="layui-col-md3">
		<h4 align="center">右侧栏</h4>
	</div>
</div>
</div>
<script src="layui/layui.all.js" charset="utf-8"></script>
<script>
;!function(){
  var layer = layui.layer
  ,form = layui.form
  ,element = layui.element;
 
}();
</script> 
</body>
</html>