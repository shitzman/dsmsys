<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加车辆</title>
</head>
<body>
<jsp:include page="../head.jsp"/>

<form action="addcar" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td>车牌号：</td>
			<td>
				<input type="text" name="cId">
			</td>
		</tr>
		<tr>
			<td>车辆状态</td>
			<td>
				<select name="cStatus">
					<option value="1">可用</option>
					<option value="0">不可用</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>备注：</td>
			<td>
				<input type="text" name="cRemark" >
			</td>
		</tr>
		<tr>
			<td>照片：</td>
			<td>
				<input type="file" name="cImgFile" >
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="提交">
			</td>
		</tr>
	</table>
	
</form>


</body>
</html>