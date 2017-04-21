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
 * 更新管理员信息
 */
function updateProfile(){
    //获取用户信息
    var userId = $("#inputUserId").val();
    var password = $("#inputPassword").val();


    var data = {
        "adminId": userId,
        "pwdCode": password
    }

    //转换为json数据
    var jsonData = JSON.stringify(data);

    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: "adminProfile/updateProfile",
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