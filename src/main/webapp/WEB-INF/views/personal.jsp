<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>个人资料-高校课程设计评分系统</title>
  <link rel="stylesheet" type="text/css" href="static/personal.css">
  <link rel="stylesheet" type="text/css" href="static/main.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="static/bootstrap-dialog.css">
  <script type="application/javascript" src="js/jquery-3.2.0.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/bootstrap-dialog.js"></script>
  <script type="application/javascript" src="js/main.js"></script>
  <script type="application/javascript" src="js/updateProfile.js"></script>
</head>
<body>
<!-- 页首个人信息模块开始 -->
<div id="pageHeader">
  <!-- 网站名称 -->
  <div class="headTitle"><a href="/">高校课程设计评分系统</a></div>
  <!-- 退出系统链接 -->
  <div class="logoutLink"><a href="javascript:void(0)" onclick="logoutFromSystem()">退出系统</a></div>
</div>
<!-- 页首个人信息模块结束 -->
<!-- 页面主要内容开始 -->
<div id="personalContent">
  <!-- 个人头像 -->
  <div class="personalPicture"><a href="javascript:void(0)" onclick="changePicture()"><img src="${userPicture}"></a></div>
  <!-- 个人资料 -->
  <div class="personalProfile">
    <label for="inputUsername" class="personalLabel">姓名：</label>
    <input type="text" id="inputUsername" class="form-control" value="${username}" disabled="disabled">
    <label for="inputUserId" class="personalLabel">学号：</label>
    <input type="text" id="inputUserId" class="form-control" value="${userId}" disabled="disabled">
    <label for="inputUserType" class="personalLabel">类型：</label>
    <input type="text" id="inputUserType" class="form-control" value="${userType}" disabled="disabled">
    <label for="inputEmail" class="personalLabel">邮箱：</label>
    <input type="text" id="inputEmail" class="form-control" value="${userEmail}">
    <label for="inputUsername" class="personalLabel">电话：</label>
    <input type="text" id="inputPhone" class="form-control" value="${userPhone}">
    <label for="inputPassword" class="personalLabel">密码：</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="*****">
    <button class="btn btn-primary" id="saveSubmit" name="saveProfile" type="submit">提交</button>
  </div>
</div>
<!-- 页面主要内容结束 -->
</body>
</html>
