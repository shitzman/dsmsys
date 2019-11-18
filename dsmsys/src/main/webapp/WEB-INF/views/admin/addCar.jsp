<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加车辆</title>
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
<div class="mainList">
<form action="addcar" enctype="multipart/form-data" method="post" class="layui-form" >
		<div class="layui-form-item">
			 <label class="layui-form-label">车牌号：</label>
			<div class="layui-input-block maininput">
				<input type="text" name="cId" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			 <label class="layui-form-label">车辆状态</label>
			<div class="layui-input-block maininput">
				<select name="cStatus" lay-verify="required">
					<option value="1">可用</option>
					<option value="0">不可用</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item" >
			 <label class="layui-form-label">备注：</label>
			<div class="layui-input-block maininput">
				<input type="text" name="cRemark" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			 <label class="layui-form-label">照片：</label>
			<div class="layui-input-block maininput">
				<input type="file" name="cImgFile" >
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
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