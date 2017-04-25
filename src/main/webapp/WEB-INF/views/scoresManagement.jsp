<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="static/bootstrap-table.css">
  <script type="application/javascript" src="js/bootstrap-table.js"></script>
  <script type="text/javascript" src="js/bootstrap-table-zh-CN.js"></script>
  <script type="text/javascript" src="js/scoresManagement.js"></script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
  <div class="page_content_title">成绩管理</div>
  <div id="toolbar" class="btn-group">
    <button id="btn_add" type="button" class="btn btn-default" onclick="addScoreInfo()">
      <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>打分
    </button>
  </div>
  <table id="score_info_table"></table>
</div>
<jsp:include page="scoreInfoEdit.jsp"></jsp:include>
</body>
</html>