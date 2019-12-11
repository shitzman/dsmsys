<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>驾校首页</title>
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

	<c:choose>
		<c:when test="${ !empty sessionScope.student }">
			<ul class="layui-nav">
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath}">主页</a></li>
				<li class="layui-nav-item layui-this"><a
					href="${pageContext.request.contextPath}/exam/showexammsg">可预约考试信息</a></li>
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath }/teacher/showallteacher">学校教练情况</a></li>
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath }/car/showallcar">学校车辆情况</a></li>
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath }/showexamorder">已预约考试信息</a></li>
				<li class="layui-nav-item userRight"><a href="${pageContext.request.contextPath }/studetails"><img
						src="${pageContext.request.contextPath }/img/xy.png" class="layui-nav-img">${sessionScope.student.sName }</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath}/exam/showexammsg">可预约考试信息</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/showexamorder">已预约考试信息</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath}/stulogout">退出登录</a>
						</dd>
					</dl></li>
			</ul>
		</c:when>

		<c:when test="${!empty sessionScope.admin }">
			<ul class="layui-nav">
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath}">主页</a></li>
				<li class="layui-nav-item"><a href="">学员管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a
								href="${pageContext.request.contextPath }/admin/showallstubyaccount">学员申请列表</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/admin/showallstu">所有在校学员</a>
						</dd>
					</dl></li>

				<li class="layui-nav-item"><a href="">教练管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a
								href="${pageContext.request.contextPath }/teacher/showallteacher">查看学校教练情况</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/teacher/addteacher">添加教练</a>
						</dd>
					</dl></li>

				<li class="layui-nav-item"><a href="">车辆管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/car/showallcar">显示所有车辆</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/car/addcar">添加车辆</a>
						</dd>
					</dl></li>

				<li class="layui-nav-item"><a href="">考试管理</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/admin/showexammsg">查询所有已发布考试信息</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/admin/showexamorder">显示学员预约考试信息</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/admin/addexammsg">添加考试信息</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/admin/showeremark0">录入学员考试信息</a>
						</dd>
					</dl></li>

				<li class="layui-nav-item userRight"><a href="${pageContext.request.contextPath }/admin/manage"><img
						src="${pageContext.request.contextPath }/img/gl.png" class="layui-nav-img">欢迎您：${sessionScope.admin.admName }--【管理员】</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath}/admin/adminlogout">退出登录</a>
						</dd>
					</dl></li>
			</ul>

		</c:when>

		<c:otherwise>
			<ul class="layui-nav">
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath}">主页</a></li>
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath }/car/showallcar">查看学校车辆情况</a></li>
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath }/teacher/showallteacher">学校教练情况</a></li>
				<li class="layui-nav-item userRight"><a
					href="${pageContext.request.contextPath}/login">登录</a></li>
				<li class="layui-nav-item userRight"><a href="${pageContext.request.contextPath}/regstudent">申请</a></li>

			</ul>
		</c:otherwise>
	</c:choose>

<table class="layui-table">
<tr>
	<td><h1 align="center" style="margin-top: 200px">驾校管理系统</h1></td>
</tr>
<tr>
	<td><h2 align="center" style="margin-top: 50px"><a href="regstudent">-立即加入-</a></h2></td>
</tr>
<tr>
	<td><h3 align="center" style="margin-top: 20px"><a href="login">-去登录-</a></h3></td>
</tr>
<tr>
	<td><h3 align="center" style="margin-top: 50px"><a href="${pageContext.request.contextPath }/teacher/showallteacher">查看学校教练情况</a></h3>
	</td>
</tr>
<tr>
	<td><h3 align="center" ><a href="${pageContext.request.contextPath }/car/showallcar">查看学校车辆情况</a></h3>
	</td>
</tr>
</table>



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
