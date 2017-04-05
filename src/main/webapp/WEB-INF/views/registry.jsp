<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册-高校课程设计评分系统</title>
	<link rel="stylesheet" type="text/css" href="static/registry.css">
	<link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
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
      	<form class="registryForm" action="RegistryAccount" method="post">
      		<!-- 学号 -->
      		<label for="inputUserId" class="registryLabel">用户名<span>*</span></label>
	        <input type="text" id="inputUserId" name="userId" class="form-control" placeholder="学号/工号" required autofocus>
	        <!-- 真实姓名 -->
	        <label for="inputUsername" class="registryLabel">真实姓名<span>*</span></label>
	        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="真实姓名" required>
	        <!-- 邮箱 -->
	        <label for="inputUserEmail" class="registryLabel">邮箱</label>
	        <input type="email" id="inputUserEmail" name="userEmail" class="form-control" placeholder="xxx@xxx.com">
					<!-- 真实姓名 -->
					<label for="inputPhone" class="registryLabel">电话号码</label>
					<input type="text" id="inputPhone" name="userPhone" class="form-control" placeholder="1846310xxxx">
					<!-- 密码 -->
	        <label for="inputPassword" class="registryLabel">密码<span>*</span></label>
	        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
	        <!-- 确认注册按钮 -->
	        <button class="btn btn-primary" id="registrySubmit" type="submit">确认</button>
	        <button class="btn btn-primary" id="returnBtn" type="button" onclick="window.location.href='/login'">返回</button>
	        
      	</form>
	</div>
</body>
</html>