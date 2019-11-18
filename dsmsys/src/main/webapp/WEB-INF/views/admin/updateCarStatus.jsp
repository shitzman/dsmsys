<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改车辆信息</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
.mainblock {
	width: 600px;
	margin: 100px auto;
	padding-top: 20px;
}
</style>
</head>
<body>
	<div class="mainblock">
		<h3 align="center">修改车辆【${cFlag }】的信息</h3>
		<form action="${pageContext.request.contextPath}/admin/updatecarstatus"  method="post" class="layui-form" style="margin-top: 10px">
			<input type="hidden" name="cFlag" value="${cFlag }">
			<div class="layui-form-item">
				<label class="layui-form-label">车辆状态</label>
				<div class="layui-input-block">
					<select name="cStatus">
						<option value="0">不可用</option>
						<option value="1" selected="selected">可用</option>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">备注：</label>
				<div class="layui-input-block">
					<input type="text" name="cRemark" required class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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