<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>管理员资料-高校课程设计评分系统</title>
  <link rel="stylesheet" type="text/css" href="static/admin_profile.css">
  <link rel="stylesheet" type="text/css" href="static/main.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap-dialog.css">
  <script type="application/javascript" src="js/jquery-3.2.0.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/bootstrap-dialog.js"></script>
  <script type="application/javascript" src="js/loginAdmin.js"></script>
  <script type="application/javascript" src="js/adminProfile.js"></script>
</head>
<body>
<!-- 页首个人信息模块开始 -->
<div id="pageHeader">
  <!-- 网站名称 -->
  <div class="headTitle"><a href="/admin">高校课程设计评分系统</a></div>
  <!-- 退出系统链接 -->
  <div class="logoutLink"><a href="javascript:void(0)" onclick="logoutFromAdmin()">退出系统</a></div>
</div>
<!-- 页首个人信息模块结束 -->
<!-- 页面主要内容开始 -->
<div id="adminProfileContent">
  <div class="adminHeadLabel">修改管理员信息</div>
  <label for="inputUserId" class="personalLabel">用户名</label>
  <input type="text" id="inputUserId" class="form-control" value="${adminId}" disabled="disabled">
  <label for="inputPassword" class="personalLabel">密&nbsp;&nbsp;&nbsp;码</label>
  <input type="password" id="inputPassword" class="form-control" placeholder="*****">
  <button class="btn btn-primary" id="saveSubmit" type="submit">提交</button>
</div>
<!-- 页面主要内容结束 -->
</body>
</html>
