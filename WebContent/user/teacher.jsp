<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>教师首页</title>

<script src="../js/jquery-1.11.1.js"></script>
<script src="../js/teacher.js"></script>
<link href="../css/teacher.css" rel="stylesheet">
</head>
<body>
	<h1>教师首页</h1>
	<h3>欢迎</h3><span>${name}</span><h3>登录！</h3>
	<div class="bigdiv">
	<!-- 左边的div -->
		<div class="leftdiv">
			<ul>
				<li onclick="dj(0)">添加学生
				</li>
				<li onclick="dj(1)">删除学生
				</li>
				<li onclick="dj(2)">修改学生信息
				</li>
				<li onclick="dj(3)">查询学生
				</li>
				<li onclick="dj(4)">添加学生成绩
				</li>
				<li onclick="dj(5)">修改学生成绩
				</li>
			</ul>
		</div>
		<!-- 右边的div用来实现左边具体的模块 -->
			<div class="rightdiv">
					<div  class="show" name="xiao">
						<h2>添加一名学生</h2>
						<span>账号：</span><input type="text" id="id1" placeholder="请输入学生账号"><br>
						<span>姓名：</span><input type="text" id="name" placeholder="请输入学生姓名"><br>
						<input type="button" value="点击添加" onclick="addstu()" id="add">
					</div>
					<div  class="hide" name="xiao">
						<h2>删除一名学生</h2>
						<span>账号：</span><input type="text" id="id2" placeholder="请输入要删除的学生账号"><br>
						<input type="button" value="点击删除" onclick="delstu()" id="del">
					</div>
					<div  class="hide" name="xiao">
						<h2>修改学生的信息</h2>
						<span>账号：</span><input type="text" id="id3" placeholder="请输入被修改的学生账号"><br>
						<h2>你要将其修改为</h2>
						<span>账号：</span><input type="text" id="alterid0" placeholder="账号更改为"><br>
						<span>姓名：</span><input type="text" id="alterid1" placeholder="姓名更改为"><br>
						<span>状态：</span><input type="text" id="alterid2" placeholder="更改为在读/毕业/退学"><br>
						<input type="button" value="点击修改" onclick="altstu()" id="alt">
					</div>
					<div  class="hide" name="xiao">
						<h2>查询学生</h2>
						
							<span>学生状态：</span><input type="text" id="id4" placeholder="请输入:在读/毕业/退学"><br>
							<input type="button" value="点击查询" onclick="findstu()" id="find">
						
						<div id="showstudent"> 
						 	<table  id="tableinfo" border="1px" cellpadding="1px" cellspacing="0" width="50%" align="center" style="text-align:center">
						 			<tr><td>学号</td><td>姓名</td></tr>
						 			<c:if test="true">
						 				<c:forEach items="${stulist}" var="student">
						 					<tr>
						 						<td>${student.getId()}</td>
						 						<td>${student.getName()}</td>
						 					</tr>
						 				</c:forEach>
						 			</c:if>
						 		</table>	
					     </div>
					</div>
					<div  class="hide" name="xiao">
						<h2>添加学生成绩</h2>
						<span>账号：</span><input type="text" id="id5" placeholder="添加成绩的学生账号"><span id="sname1"></span><br>
						<h2>请输入各科的成绩</h2>
						<span>语文：</span><input type="text" id="chinese" placeholder="0-100"><br>
						<span>数学：</span><input type="text" id="math" placeholder="0-100"><br>
						<span>英语：</span><input type="text" id="english" placeholder="0-100"><br>
						<input type="button" value="点击提交" onclick="subach()" id="add1">
					</div>
					<div  class="hide" name="xiao">
						<h2>修改学生成绩</h2>
						<span>账号：</span><input type="text" id="id6" placeholder="修改成绩的学生账号"><span id="sname2"></span><br>
						<h2>请修改各科的成绩</h2>
						<span>语文：</span><input type="text" id="chinese1" placeholder="0-100"><br>
						<span>数学：</span><input type="text" id="math1" placeholder="0-100"><br>
						<span>英语：</span><input type="text" id="english1" placeholder="0-100"><br>
						<input type="button" value="点击提交" onclick="altach()" id="alt1">
					</div>
			</div>
	</div>
</body>
</html>