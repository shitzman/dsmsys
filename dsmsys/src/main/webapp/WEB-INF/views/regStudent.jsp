<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="layui/css/layui.css">
<style type="text/css">

</style>
<title>学员申请界面</title>
</head>
<body style="background-color:#F0F0F0">
	<jsp:include page="head.jsp"></jsp:include>
	<h4 style="color: red">${msg }</h4>

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
		<form action="adduser" method="post" class="layui-form" style="margin:80px auto">
			
				<div class = "layui-form-item">
					<label class="layui-form-label">身份证号：</label>
					<div class="layui-input-block" style="width: 300px;">
						<input type="text" name="sNumber"  required  class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">姓名：</label>
					<div class="layui-input-block" style="width: 300px;">
						<input type="text" name="sName" required   class="layui-input" >
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">性别：</label>
					<div class="layui-input-block">
						<input type="radio" name="sSex" value="男" title="男" checked>
						<input type="radio" name="sSex" value="女" title="女">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">手机号：</label>
					<div class="layui-input-block" style="width: 300px;">
						<input type="text" name="sMobile" required  class="layui-input" >
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">密码：</label>
					<div class="layui-input-block" style="width: 150px;">
						<input type="password" name="sPassword" required  class="layui-input" >
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">住址：</label>
					<div class="layui-input-block" style="width: 300px;">
						<input type="text" name="sAddress" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交申请</button>
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