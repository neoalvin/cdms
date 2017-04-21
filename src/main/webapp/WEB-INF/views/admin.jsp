<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>管理员-高校课程设计评分系统</title>
  <!--Jquery-->
  <script type="application/javascript" src="js/jquery-3.2.0.min.js"></script>
  <!--Bootstrap-->
  <link rel="stylesheet" type="text/css" href="static/bootstrap.min.css">
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <!-- Bootstrap Dialog -->
  <link rel="stylesheet" type="text/css" href="static/bootstrap-dialog.css">
  <script type="application/javascript" src="js/bootstrap-dialog.js"></script>
  <!-- Bootstrap Table -->
  <link rel="stylesheet" type="text/css" href="static/bootstrap-table.css">
  <script type="application/javascript" src="js/bootstrap-table.js"></script>
  <script type="text/javascript" src="js/bootstrap-table-zh-CN.js"></script>
  <!-- 自定义 -->
  <link rel="stylesheet" type="text/css" href="static/admin.css">
  <link rel="stylesheet" type="text/css" href="static/main.css">
  <script type="application/javascript" src="js/admin.js"></script>
</head>
<body>
<!-- 页首网站信息模块开始 -->
<div id="pageHeader">
  <!-- 网站名称 -->
  <div class="headTitle">高校课程设计评分系统</div>
  <!-- 退出系统链接 -->
  <div class="logoutLink"><a href="javascript:void(0)" onclick="logoutFromAdmin()">退出系统</a></div>
  <!-- 管理员 -->
  <div class="adminTag"><a href="/adminProfile">管理员</a></div>
</div>
<!-- 页首网站信息模块结束 -->
<!-- 页面主要内容开始 -->
<div id="mainContent">
  <!-- 左侧导航栏开始 -->
  <div id="navigationModule">
    <ul>
      <li><a href="/admin/studentManagement">学生管理</a></li>
      <li><a href="/admin/teacherManagement">教师管理</a></li>
      <li><a href="/admin/statistic">统计报表</a></li>
    </ul>
  </div>
  <!-- 左侧导航栏结束 -->
  <!-- 右侧主页面开始 -->
  <div id="mainModule">
    <jsp:include page="${curModuleName}.jsp" flush="true"></jsp:include>
  </div>
  <!-- 右侧主页面结束 -->
</div>
<!-- 页面主要内容结束 -->
<!-- 底部版权信息开始 -->
<div id="copyrightFooter">版权所有©哈尔滨工业大学（威海）2017-2017 地址：山东省威海市文化西路2号 | 邮编：264209</div>
<!-- 底部版权信息结束 -->
</body>
</html>
