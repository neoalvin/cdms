<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页-高校课程设计评分系统</title>
<link rel="stylesheet" type="text/css" href="static/main.css">
</head>
<body>
	<!-- 页首个人信息模块开始 -->
	<div id="profileModule">
		<!-- 个人头像 -->
		<div class="profilePicture"><a href="#"><img src="images/alvin.jpg"></a></div>
		<!-- 个人信息 -->
		<div class="profileInfo">
			<div class="profileName">Alvin</div>
			<div class="profileNo">130420215</div>
		</div>
		<!-- 网站名称 -->
		<!-- <div class="headTitle">高校课程设计评分系统</div> -->
		<!-- 退出系统链接 -->
		<div class="logoutLink"><a href="/login">退出系统</a></div>
	</div>
	<!-- 页首个人信息模块结束 -->
	<!-- 页面主要内容开始 -->
	<div id="mainContent">
		<!-- 左侧导航栏开始 -->
		<div id="navigationModule">
		<ul>
			<li><a href="#">学生管理</a></li>
			<li><a href="#">题目管理</a></li>
			<li><a href="#">成绩管理</a></li>
			<li><a href="#">统计报表</a></li>
		</ul>
		</div>
		<!-- 左侧导航栏结束 -->
		<!-- 右侧主页面开始 -->
		<div id="mainModule">右侧主页面模块
			${studentInfo.studentId}<br>
			${studentInfo.studentName}<br>
			${studentInfo.studentPhone}<br>
			${studentInfo.studentEmail}<br>
			${studentInfo.pwdCode}
		</div>
		<!-- 右侧主页面结束 -->
	</div>
	<!-- 页面主要内容结束 -->
	<!-- 底部版权信息开始 -->
	<div id="copyrightFooter">版权所有©哈尔滨工业大学（威海）2017-2017 地址：山东省威海市文化西路2号 | 邮编：264209</div>
	<!-- 底部版权信息结束 -->
</body>
</html>