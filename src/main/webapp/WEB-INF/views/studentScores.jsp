<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
	<div class="page_content_title">学生成绩</div>
	<form style="margin: 70px auto;width:300px;">
          <label for="inputUserId" class="registryLabel">平时分</label>
          <input type="text" id="inputUserId" name="userId" class="form-control" disabled="true" value="10">
          <label for="inputUsername" class="registryLabel">中期成绩</label>
          <input type="text" id="inputUsername" name="username" class="form-control"  disabled="true" value="20">
          <label for="inputUserClass" class="registryLabel">验收成绩</label>
          <input type="text" id="inputUserClass" name="userClass" class="form-control" disabled="true" value="70">
          <label for="inputUserEmail" class="registryLabel">总成绩</label>
          <input type="email" id="inputUserEmail" name="userEmail" class="form-control" disabled="true" value="100">
          
	</form>
</div>
</body>
</html>