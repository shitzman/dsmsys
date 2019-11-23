<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>考试信息展示页</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<style type="text/css">
		.mainblock{
		width: 900px;
		margin: 100px auto;
		padding-top: 20px;
	}

</style>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4>${msg }</h4>

<div class="mainblock" style="background-color: #c2c2c2">
<table class="layui-table">
	<tr>
		<th>考试编号</th>
		<th>考试时间</th>
		<th>考试科目</th>
		<th>考试地址</th>
		<th>可报考人数</th>
		<th>已报考人数</th>
		<th>操作</th>
	</tr>
	<c:choose>
		<c:when test="${pageExamList.list.size()==0 }">
			<tr>
				<td colspan="7" align="center">暂无任何可约考信息</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="exam" items="${pageExamList.list }">
			<tr>	
				<td>${exam.eId }</td>
				<td>${exam.eTime }</td>
				<td>${exam.eSubject }</td>
				<td>${exam.eAddress }</td>
				<td>${exam.eAllNum }</td>
				<td>${exam.eAlrNum }</td>
				<c:choose>
					<c:when test="${sStatus == 0 }">
						<td><a href="${pageContext.request.contextPath }/addexamorder?eId=${exam.eId }" class="layui-btn layui-btn-normal">点击预约此考试</a></td>
					</c:when>
					<c:when test="${sStatus ==1 }">
						<td>你已成功提交申请，请耐心等待</td>
					</c:when>
					<c:when test="${sStatus ==2 }">
						<td><a href = "${pageContext.request.contextPath }/showexamorder" class="layui-btn layui-btn-normal">你已成功预约编号为${eId}的考试，点击查看考试信息</a></td>
					</c:when>
					<c:when test="${sStatus ==3 }">
						<td><a href = "${pageContext.request.contextPath }/addexamorder?eId=${exam.eId }">你的考试申请已被拒绝，点击重新申请</a></td>
					</c:when>
					
					<c:otherwise>
						<td><button  onclick="openThisStuByeId(${exam.eId })" class="layui-btn layui-btn-sm layui-btn-danger">查看考试情况</button></td>
					</c:otherwise>
				</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="center">
					<div id="epagenums"></div>
				</td>
			</tr>
		</c:otherwise>
	</c:choose>
	

</table>

</div>

<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
<script>
	;!function() {
		var layer = layui.layer, form = layui.form, element = layui.element,laypage = layui.laypage;
		  
		  //执行一个laypage实例
		  laypage.render({
		  		elem: 'epagenums' 
			  ,count: ${pageExamList.getTotal()}
			  ,limit:${pageExamList.getPageSize()}
			  ,curr:${pageExamList.getPageNum()}
			  ,jump: function(obj, first){
				   
				    if(!first){
				      //do something
				    	location.href="${pageContext.request.contextPath }/admin/showexammsg?pn="+obj.curr;
				    }
				  }
		  });

		 
	}();
	 function openThisStuByeId(eId){
		   layer.open({
			  type: 2, 
			  type: 2, 
			  area: ['900px', '400px'],
			  content: '${pageContext.request.contextPath }/admin/getallremarkandstubyeid?eId='+eId //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
			});  
	};
</script>
</body>
</html>