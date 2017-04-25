<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="static/bootstrap-table.css">
  <script type="application/javascript" src="js/bootstrap-table.js"></script>
  <script type="text/javascript" src="js/bootstrap-table-zh-CN.js"></script>
  <script type="text/javascript" src="js/studentManagement.js"></script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
  <div class="page_content_title">学生管理</div>
  <div id="toolbar" class="btn-group">
    <button id="btn_import" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入
    </button>
    <button id="btn_group" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-import" aria-hidden="true"></span>分组
    </button>
  </div>
  <table id="students_info_table"></table>
</div>
<jsp:include page="studentInfoEdit.jsp"></jsp:include>
</body>
</html>