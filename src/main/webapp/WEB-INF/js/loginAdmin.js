$(document).ready(
    function() {
        $("#adminSubmit").bind('click',function(){
            loginAdminRequest();
            return false;
        });

        $("#clearSubmit").bind('click',function(){
            clearLoginAdminInfo();
        });

    }
);

/**
 * 管理员登录请求
 */
function loginAdminRequest() {
    //获取管理员信息
    var adminId = $("#inputUserId").val();
    var pwd = $("#inputPassword").val();

    //组装data
    var data = {
     "adminId": adminId,
     "pwdCode": pwd
    };

    //装换为json体
    var jsonData = JSON.stringify(data);

    $.ajax({
        type: "POST",
        contentType : "application/json",
        url: "admin/login/loginAdmin",
        dataType: "json",
        async: false,
        data: jsonData,
        success: function (msg) {
            if(msg.code === '0'){
                BootstrapDialog.show({
                    title: "提示",
                    message: '管理员登录成功!',
                    closable: false,
                    buttons : [{
                        label : "确认",
                        action : function(dialog){
                            window.location.href = "/admin";
                            dialog.close();
                        }
                    }]
                });
            }
            else{
                BootstrapDialog.show({
                    title: "提示",
                    message: "管理员登录失败： " + msg.message,
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
                message: "管理员登录发生错误： " + error.message,
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
 * 清空页面信息
 */
function clearLoginAdminInfo() {
    $("#inputUserId").attr("value","");
    $("#inputPassword").attr("value","");
}


