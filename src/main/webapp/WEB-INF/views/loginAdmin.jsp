<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>管理员登录-高校课程设计评分系统</title>
  <link rel="stylesheet" type="text/css" href="static/admin.css">
  <link rel="stylesheet" type="text/css" href="static/main.css">
  <link rel="stylesheet" type="text/css" href="static/login.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap-dialog.css">
  <script type="application/javascript" src="js/jquery-3.2.0.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/bootstrap-dialog.js"></script>
  <script type="application/javascript" src="js/loginAdmin.js"></script>
  <script type="application/javascript" src="js/admin.js"></script>
</head>
<body>
<!-- 页头开始 -->
<div id="pageHeader">
  <!-- 网站名称 -->
  <div class="headTitle">高校课程设计评分系统</div>
</div>
<!-- 登录页面主要内容开始 -->
<div id="loginContent">
  <div class="loginHeadLabel">管理员登录</div>
  <form class="loginForm" method="post">
    <!-- 学号/工号 -->
    <label for="inputUserId" class="loginLabel">用户名</label>
    <input type="text" id="inputUserId" class="form-control" placeholder="用户名" required autofocus>
    <!-- 密码 -->
    <label for="inputPassword" class="loginLabel">密&nbsp;&nbsp;&nbsp;码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
    <!-- 登录按钮 -->
    <button class="btn btn-primary" id="adminSubmit" type="submit">登录</button>
    <button class="btn btn-primary" id="clearSubmit" type="submit">取消</button>
  </form>
</div>
</body>
</html>
