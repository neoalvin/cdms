<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editStudentInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
        <form class="registryForm">
          <!-- 学号 -->
          <label for="inputUserId" class="registryLabel">学号<span>*</span></label>
          <input type="text" id="inputUserId" name="userId" class="form-control" placeholder="学号/工号" required autofocus>
          <!-- 姓名 -->
          <label for="inputUsername" class="registryLabel">姓名<span>*</span></label>
          <input type="text" id="inputUsername" name="username" class="form-control" placeholder="真实姓名" required>
          <!-- 班级 -->
          <label for="inputUserClass" class="registryLabel">班级<span>*</span></label>
          <input type="text" id="inputUserClass" name="userClass" class="form-control" placeholder="班级" required>
          <!-- 邮箱 -->
          <label for="inputUserEmail" class="registryLabel">邮箱</label>
          <input type="email" id="inputUserEmail" name="userEmail" class="form-control" placeholder="邮箱">
          <!-- 电话 -->
          <label for="inputPhone" class="registryLabel">电话</label>
          <input type="text" id="inputPhone" name="userPhone" class="form-control" placeholder="电话号码">
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">提交</button>
      </div>
    </div>
  </div>
</div>
