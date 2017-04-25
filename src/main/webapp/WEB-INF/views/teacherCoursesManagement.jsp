<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="static/bootstrap-table.css">
  <script type="application/javascript" src="js/bootstrap-table.js"></script>
  <script type="text/javascript" src="js/bootstrap-table-zh-CN.js"></script>
  <link rel="stylesheet" type="text/css" href="static/registry.css">
  <script type="text/javascript" src="js/studentCoursesManagement.js"></script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
  <div class="page_content_title">教师题目管理</div>
  <div id="toolbar" class="btn-group">
     <button id="btn_add" type="button" class="btn btn-default" onclick="addStudentInfo()">
      <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
    </button>
    <button id="btn_edit" type="button" class="btn btn-default" onclick="updateStudentInfo()">
      <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
    </button>
    <button id="btn_delete" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
    </button>
    <button id="btn_import" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-import" aria-hidden="true"></span>分配题目
    </button>
  </div>
  <table id="courses_info_table"></table>
</div>
</body>
</html>