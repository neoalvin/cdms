<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录-高校课程设计评分系统</title>
	<link rel="stylesheet" type="text/css" href="static/login.css">
	<link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
</head>
<body>
	<!-- 页头开始 -->
	<div id="pageHeader">
		<!-- 网站名称 -->
		<div class="headTitle">高校课程设计评分系统</div>
		<!-- 用户注册链接 -->
		<div class="userRegistry"><a href="/registry">用户注册</a></div>
	</div>
	<!-- 登录页面主要内容开始 -->
	<div id="loginContent">
		<div class="loginHeadLabel">用户登录</div>
      	<form class="loginForm" action="LoginAccount">
      		<!-- 学号/工号 -->
      		<label for="inputUserId" class="loginLabel">用户名</label>
	        <input type="text" id="inputUserId" name="userId" class="form-control" placeholder="学号/工号" required autofocus>
	        <!-- 密码 -->
	        <label for="inputPassword" name="password" class="loginLabel">密&nbsp;&nbsp;&nbsp;码</label>
	        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
	        <!-- 登录按钮 -->
	        <button class="btn btn-primary" id="teachSubmit" name="teachBtn" type="submit">教师登录</button>
	        <button class="btn btn-primary" id="studSubmit" name="studBtn" type="submit">学生登录</button>
      	</form>
	</div>
</body>
</html>