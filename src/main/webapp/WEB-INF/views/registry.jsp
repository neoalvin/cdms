<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册-高校课程设计评分系统</title>
	<link rel="stylesheet" type="text/css" href="static/registry.css">
	<link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="static/bootstrap-dialog.css">
	<script type="application/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script type="application/javascript" src="js/bootstrap.min.js"></script>
	<script type="application/javascript" src="js/bootstrap-dialog.js"></script>
  <script type="application/javascript" src="js/registryAccount.js"></script>
</head>
<body>
	<!-- 页头开始 -->
	<div id="pageHeader">
		<!-- 网站名称 -->
		<div class="headTitle">高校课程设计评分系统</div>
		<!-- 用户登录链接 -->
		<div class="userLogin"><a href="/login">用户登录</a></div>
	</div>
	<!-- 注册页面主要内容开始 -->
	<div id="registryContent">
		<div class="registryHeadLabel">用户注册</div>
      	<form class="registryForm" method="post">
      		<!-- 学号 -->
      		<label for="inputUserId" class="registryLabel">用户名<span>*</span></label>
	        <input type="text" id="inputUserId" name="userId" class="form-control" placeholder="学号/工号" required autofocus>
	        <!-- 真实姓名 -->
	        <label for="inputUsername" class="registryLabel">真实姓名<span>*</span></label>
	        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="真实姓名" required>
					<!-- 班级 -->
					<label for="inputUserClass" class="registryLabel">班级<span>*</span></label>
					<input type="text" id="inputUserClass" name="userClass" class="form-control" placeholder="班级" required>
					<!-- 邮箱 -->
	        <label for="inputUserEmail" class="registryLabel">邮箱</label>
	        <input type="email" id="inputUserEmail" name="userEmail" class="form-control" placeholder="邮箱">
					<!-- 真实姓名 -->
					<label for="inputPhone" class="registryLabel">电话号码</label>
					<input type="text" id="inputPhone" name="userPhone" class="form-control" placeholder="电话号码">
					<!-- 密码 -->
	        <label for="inputPassword" class="registryLabel">密码<span>*</span></label>
	        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
	        <!-- 确认注册按钮 -->
	        <button class="btn btn-primary" id="returnBtn" type="button" onclick="window.location.href='/login'">返回</button>
					<button class="btn btn-primary" id="registrySubmit" type="submit">确认</button>
				</form>
	</div>
</body>
</html>