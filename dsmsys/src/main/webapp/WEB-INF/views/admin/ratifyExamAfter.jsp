<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结果页面</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  <style>
	.userRight{
		color:red;
		float:right;
		margin-right:20px
	}
  </style>
</head>
<body>
<jsp:include page="../head.jsp"/>





<table class="layui-table">
<tr>
	<td><h1 align="center" style="margin-top: 200px">${msg }</h1></td>
</tr>
<tr>
	<td><h2 align="center" style="margin-top: 50px"><a href="regstudent">-<a href="${pageContext.request.contextPath }/admin/showexamorder">返回学员考试申请列表</a>-</a></h2></td>
</tr>
</table>



<script src="${pageContext.request.contextPath}/layui/layui.all.js" charset="utf-8"></script>
<script>
;!function(){
  var layer = layui.layer
  ,form = layui.form
  ,element = layui.element;
 
}();
</script> 
</body>
</html>