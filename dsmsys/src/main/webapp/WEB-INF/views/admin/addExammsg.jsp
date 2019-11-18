<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加考试信息页</title>
<style type="text/css">
	.mainblock{
		width: 500px;
		height: 300px;
		margin: 50px auto;
		padding-top: 70px;
	}

</style>
</head>
<%
	String[] tSubjectList = {"1","2","3","4"};
%>
<body>
<jsp:include page="../head.jsp"/>
<form action="${pageContext.request.contextPath }/admin/addexammsg" method="post" class="layui-form mainblock">
	<table class="layui-table">
		<tr>
			<td>考试时间</td>
			<td><input type = "text" name="eTime" class="layui-input" id="test1"></td><!-- 修改为日期组件 -->
			
		</tr>
		<tr>
			<td>考试地点</td>
			<td><input type = "text" name="eAddress" class="layui-input"></td>
		</tr>
		<tr>
			<td>考试科目</td>
			<td>
				<select name="eSubject">
					<c:forEach var="t" items="<%=tSubjectList %>">
						<option value="${t }">科目${t }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>可报考人数</td>
			<td><input type="text" name="eAllNum" class="layui-input"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="添加" class="layui-btn layui-btn-warm"/></td>
		</tr>
	
	</table>
</form>

<script src="../layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element,laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#test1' //指定元素
		  });
	}();
</script>
</body>
</html>