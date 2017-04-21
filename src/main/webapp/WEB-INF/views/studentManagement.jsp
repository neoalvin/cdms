<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script type="text/javascript" src="js/studentManagement.js"></script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
  <div id="toolbar" class="btn-group">
    <button id="btn_add" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
    </button>
    <button id="btn_edit" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
    </button>
    <button id="btn_delete" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>删除
    </button>
    <button id="btn_import" type="button" class="btn btn-default">
      <span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入
    </button>
  </div>
  <table id="tb_departments"></table>
</div>
</body>
</html>