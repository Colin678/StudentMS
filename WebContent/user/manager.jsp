<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员首页</title>
<script src="../js/jquery-1.11.1.js"></script>
<script src="../js/manager.js"></script>
<link href="../css/manager.css" rel="stylesheet">
</head>
<body>
	<h1>管理员首页</h1>
	<h3>欢迎</h3><span>${name}</span><h3>登录！</h3>
	<div class="bigdiv">
	<!-- 左边的div -->
		<div class="leftdiv">
			<ul>
				<li onclick="dj(0)">添加教师
				</li>
				<li onclick="dj(1)">删除教师
				</li>
				<li onclick="dj(2)">修改教师
				</li>
				<li onclick="dj(3)">查询教师
				</li>
				<li onclick="dj(4)">修改公告
				</li>
			</ul>
		</div>
		<!-- 右边的div用来实现左边具体的模块 -->
			<div class="rightdiv">
					<div  class="show" name="xiao">
						<h2>添加一名教师</h2>
						<span>账号：</span><input type="text" id="id1" placeholder="请输入教师账号"><br>
						<span>姓名：</span><input type="text" id="name" placeholder="请输入教师姓名"><br>
						<input type="button" value="点击添加" onclick="addtea()" id="add">
					</div>
					<div  class="hide" name="xiao">
						<h2>删除一名教师</h2>
						<span>账号：</span><input type="text" id="id2" placeholder="请输入教师账号"><br>
						<input type="button" value="点击删除" onclick="deltea()" id="del">
					</div>
					<div  class="hide" name="xiao">
						<h2>修改教师的信息</h2>
						<span>账号：</span><input type="text" id="id3" placeholder="请输入被修改的教师账号"><br>
						<h2>你要将其修改为</h2>
						<span>账号：</span><input type="text" id="alterid0" placeholder="账号更改为"><br>
						<span>姓名：</span><input type="text" id="alterid1" placeholder="姓名更改为"><br>
						<input type="button" value="点击修改" onclick="alttea()" id="alt">
					</div>
					<div  class="hide" name="xiao">
						<h2>查询教师信息</h2>
						<span>账号：</span><input type="text" id="id4" placeholder="请输入教师账号"><br>
						<input type="button" value="点击查询" onclick="findtea()" id="find">
						<div id="showteacher">
							<span>账号</span><span id="tip0"></span><br>
							<span>姓名</span><span id="tip1"></span><br>
							<span>状态</span><span id="tip2"></span><br>
						</div>
					</div>
					<div  class="hide" name="xiao">
						<h2>查看与修改公告</h2>
					</div>
			</div>
	</div>
</body>
</html>