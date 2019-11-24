<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理界面</title>
<script src="${pageContext.request.contextPath}/dist/echarts.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
	<style type="text/css">
	
		.main0{
			width: 600px;
			height:400px;
			position:absolute;
		    left:50px;
		    top:280px;
		}
		.subjectblock{
			width: 1200px;
			height:800px;
			position:absolute;
		    left:700px;
		    top:100px;
		}
		
		.spantitle{
			position:absolute;
		    left:200px;
		    top:5px;
			font-size: 20px;
		}
		.btnblock{
			width: 600px;
			height:100px;
			border: 1px red;
			position:absolute;
		    left:100px;
		    top:50px;
		}
		.btnblock2{
			width: 600px;
			height:100px;
			border: 1px red;
			position:absolute;
		    left:20px;
		    top:100px;
		}
	.leftupblock{
		width: 530px;
		height:150px;
		background-color: #d2d2d2;
		position:absolute;
		left:100px;
		top:100px;
	}
	
	</style>
</head>
<body>
<jsp:include page="../head.jsp"/>
<h4 style="color: red">${msg }</h4>

	<div class = "leftupblock">
		<span class="spantitle">日常功能区</span>
		<div class="btnblock">
			<a href="${pageContext.request.contextPath }/admin/showallstubyaccount" class="layui-btn">学员入校申请<span class="layui-badge">${managesomeCountArray[4][0] }</span></a>
			<a href="${pageContext.request.contextPath }/admin/showexamorder" class="layui-btn">学员考试申请<span class="layui-badge">${managesomeCountArray[4][1] }</span></a>
		</div>
		<div class="btnblock2">
			<a href="${pageContext.request.contextPath }/admin/addexammsg" class="layui-btn">发布考试信息</a>
			<a href="${pageContext.request.contextPath }/admin/showeremark0" class="layui-btn">待录入学生成绩<span class="layui-badge">${managesomeCountArray[4][2] }</span></a>
			<button class="layui-btn">更多功能请访问上方导航</button>
		</div>
	</div>

<div id="main" class="main0"></div>
	<div class="subjectblock">
		<div class="layui-row">
			<div id="subject1" style="width: 300px;height:300px;" class="layui-col-md3"></div>
			<div id="subject2" style="width: 300px;height:300px;" class="layui-col-md3"></div>
		</div>
		
		<div class="layui-row">
			<div id="subject3" style="width: 300px;height:300px;" class="layui-col-md3"></div>
			<div id="subject4" style="width: 300px;height:300px;" class="layui-col-md3"></div>
		</div>
	</div>
</div>




<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var subject1 = echarts.init(document.getElementById('subject1'));
        var subject2 = echarts.init(document.getElementById('subject2'));
        var subject3 = echarts.init(document.getElementById('subject3'));
        var subject4 = echarts.init(document.getElementById('subject4'));
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '在校学员所处科目分布'
            },
            tooltip: {},
            legend: {
                data:['人数']
            },
            xAxis: {
                data: ["科目一","科目二","科目三","科目四"]
            },
            yAxis: {},
            series: [{
                name: '人数',
                type: 'bar',
                data: [${managesomeCountArray[1][0] }, ${managesomeCountArray[1][1] }, ${managesomeCountArray[1][2] }, ${managesomeCountArray[1][3] }]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        subject1.setOption({
        	title: {
                text: '历史科目一考试过关率【'+
                		parseInt(${managesomeCountArray[2][0] }/(${managesomeCountArray[2][0] }+${managesomeCountArray[3][0] })*100)
                		+"%】"
            },
            series : [
                {
               
                    name: '科目一考试情况',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:${managesomeCountArray[2][0] }, name:'过关人数'},
                        {value:${managesomeCountArray[3][0] }, name:'挂科人数'}
                    ]
                }
            ]
        })
        
         subject2.setOption({
        	title: {
                text: '历史科目二考试过关率【'+
                		parseInt(${managesomeCountArray[2][1] }/(${managesomeCountArray[2][1] }+${managesomeCountArray[3][1] })*100)
                		+"%】"
            },
            series : [
                {
               
                    name: '科目二考试情况',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:${managesomeCountArray[2][1] }, name:'过关人数'},
                        {value:${managesomeCountArray[3][1] }, name:'挂科人数'}
                    ]
                }
            ]
        })
        
        subject3.setOption({
        	title: {
                text: '历史科目三考试过关率【'+
                		parseInt(${managesomeCountArray[2][2] }/(${managesomeCountArray[2][2] }+${managesomeCountArray[3][2] })*100)
                		+"%】"
            },
            series : [
                {
               
                    name: '科目三考试情况',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:${managesomeCountArray[2][2] }, name:'过关人数'},
                        {value:${managesomeCountArray[3][2] }, name:'挂科人数'}
                    ]
                }
            ]
        })
        subject4.setOption({
        	title: {
                text: '历史科目三考试过关率【'+
                		parseInt(${managesomeCountArray[2][3] }/(${managesomeCountArray[2][3] }+${managesomeCountArray[3][3] })*100)
                		+"%】"
            },
            series : [
                {
               
                    name: '科目三考试情况',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:${managesomeCountArray[2][3] }, name:'过关人数'},
                        {value:${managesomeCountArray[3][3] }, name:'挂科人数'}
                    ]
                }
            ]
        })

        
    </script>
</body>

</html>