$(document).ready(
    function() {
        $("#teachSubmit").bind('click',function(){
            loginUserRequest("teacher");
            return false;
        });

        $("#studSubmit").bind('click',function(){
            loginUserRequest("student");
            return false;
        });
    }
    );

/**
 * 登录用户请求
 * @param userType
 * @returns {boolean}
 */
function loginUserRequest(userType) {
        //获取用户注册信息
        var userId = $("#inputUserId").val();
        var password = $("#inputPassword").val();

        //校验用户信息
        if(!validateLoginInfo()){
            alert("必选信息不能为空。");
            return false;
        }

        var data = {
            "userId": userId,
            "pwdCode": password,
            "userType": userType
        };

        //数据转换为json格式
        var jsonData = JSON.stringify(data);

        $.ajax({
            type: "POST",
            contentType : "application/json",
            url: "login/loginUser",
            dataType: "json",
            async: false,
            data: jsonData,
            success: function (msg) {
                if(msg.code === '0'){
                    BootstrapDialog.show({
                        title: "提示",
                        message: '登录成功!',
                        closable: false,
                        buttons : [{
                            label : "确认",
                            action : function(dialog){
                                window.location.href = "/";
                                dialog.close();
                            }
                        }]
                    });
                }
                else{
                    BootstrapDialog.show({
                        title: "提示",
                        message: "登录失败： " + msg.message,
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
            error: function (msg) {
                BootstrapDialog.show({
                    title: "提示",
                    message: "用户登录发生错误： " + msg.message,
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
 * 校验用户信息格式是否正确
 * @returns {boolean}
 */
function validateLoginInfo() {
    //获取用户注册信息
    var userId = $("#inputUserId").val();
    var password = $("#inputPassword").val();

    if(isStringEmpty(userId)||isStringEmpty(password)){
        return false;
    }
    return true;
}

/**
 * 校验参数是否为空
 * @param str
 * @returns {boolean}
 */
function isStringEmpty(str){
    return ("" === str) || (undefined === str);
}
