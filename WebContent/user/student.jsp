<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生首页</title>
<script src="../js/jquery-1.11.1.js"></script>
<script src="../js/student.js"></script>
<link href="../css/student.css" rel="stylesheet">
</head>
<body>
	<h1>学生首页</h1>
	<h3>欢迎</h3><span>${name}</span><h3>登录！</h3>
	<div class="bigdiv">
	<!-- 左边的div -->
		<div class="leftdiv">
			<ul>
				<li onclick="dj(0)">个人信息查询
				</li>
				<li onclick="dj(1)">个人密码修改
				</li>
				<li onclick="dj(2)">个人成绩查询
				</li>
			</ul>
		</div>
		<!-- 右边的div用来实现左边具体的模块 -->
			<div class="rightdiv">
					<div  class="show" name="xiao">
						<h2>个人信息查询</h2>
							学号:<span>${stuid}</span><br/>
							姓名:<span>${name}</span><br/>
							状态:<span>在读</span>
					</div>
					<div  class="hide" name="xiao">
						<h2>个人密码修改</h2>
						<input type="text" id="newpwd0" placeholder="请输入新密码"><br>
						<input type="text" id="newpwd1" placeholder="再次确认密码"><br>
						<input type="button" value="点击提交" onclick="repwd()" id="alt">
					</div>
					<div  class="hide" name="xiao">
						<h2>点击按钮查询${stuid}${name}的成绩</h2>
						<input type="button" onclick="showach()" value="点我查询" id="find">
						<h2>语文<span id="showc"></span>
						<h2>数学<span id="showm"></span>
						<h2>英语<span id="showe"></span>
						<h2>平均<span id="showa"></span>
						<h2>总分<span id="shows"></span>
						</div>
			</div>
	</div>
</body>
</html>