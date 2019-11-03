<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加教练信息</title>
</head>
<body>

<form action="addteacher" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td>所管车辆：</td>
			<td>
				<input type="text" name="cId" >
			</td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td>
				<input type="text" name="tName" >
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
				<input type="text" name="tSex" >
			</td>
		</tr>
		<tr>
			<td>所教科目：</td>
			<td>
				<input type="text" name="tSubject" >
			</td>
		</tr>
		<tr>
			<td>照片：</td>
			<td>
				<input type="file" name="tImgFile" >
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