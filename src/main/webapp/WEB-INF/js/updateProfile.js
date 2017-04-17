/**
 * 绑定按钮响应事件
 */
$(document).ready(
    function() {
        $("#saveSubmit").bind('click',function(){
            updateProfile();
            return false;
        });
    }
);

/**
 * 更改个人资料
 */
function updateProfile(){
    //获取用户信息
    var username = $("#inputUsername").val();
    var userId = $("#inputUserId").val();
    var userType = $("#inputUserType").val();
    var password = $("#inputPassword").val();
    var userEmail = $("#inputEmail").val();
    var userPhone = $("#inputPhone").val();

    //转换用户类型
    if("学生" === userType.trim()) {
        userType = "student";
    }
    else if("教师" === userType.trim()){
        userType = "teacher";
    }

    var data = {
        "username": username,
        "userId": userId,
        "userType": userType,
        "userEmail": userEmail,
        "userPhone": userPhone,
        "pwdCode": password
    }

    //转换为json数据
    var jsonData = JSON.stringify(data);

    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: "personal/updateProfile",
        dataType: "json",
        async: false,
        data: jsonData,
        success: function (msg) {
            if(msg.code === "0"){
                BootstrapDialog.show({
                    title: "提示",
                    message: "个人资料修改成功！",
                    closable: false,
                    buttons : [{
                        label : "确认",
                        action : function(dialog){
                            window.location.reload();
                            dialog.close();
                        }
                    }]
                });
            }
            else{
                BootstrapDialog.show({
                    title: "提示",
                    message: "个人资料修改失败：" + msg.message,
                    closable: false,
                    buttons : [{
                        label : "确认",
                        action : function(dialog){
                            dialog.close();
                        }
                    }]
                });
            }
        },
        error: function (error) {
            BootstrapDialog.show({
                title: "提示",
                message: "个人资料修改遇到错误：" + error.message,
                closable: false,
                buttons : [{
                    label : "确认",
                    action : function(dialog){
                        window.location.reload();
                        dialog.close();
                    }
                }]
            });
        }
    });
}

/**
 * 修改头像
 */
function changePicture(){
    BootstrapDialog.show({
        title: "提示",
        message: '暂不支持编辑头像！',
        closable: false,
        buttons : [{
            label : "确认",
            action : function(dialog){
                dialog.close();
            }
        }]
    });
}
