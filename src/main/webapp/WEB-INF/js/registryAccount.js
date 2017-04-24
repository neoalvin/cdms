$(document).ready(
    function() {
        $("#registrySubmit").click(
            function () {
                //获取用户注册信息
                var userId = $("#inputUserId").val();
                var username = $("#inputUsername").val();
                var userClass = $("#inputUserClass").val();
                var userEmail = $("#inputUserEmail").val();
                var userPhone = $("#inputPhone").val();
                var password = $("#inputPassword").val();

                //校验用户信息
                if(!validateUserInfo()){
                    return;
                }

                var data = {
                    "studentId": userId,
                    "studentName": username,
                    "userClass": userClass,
                    "studentEmail": userEmail,
                    "studentPhone": userPhone,
                    "pwdCode": password
                };

                var jsonData = JSON.stringify(data);

                $.ajax({
                    type: "POST",
                    contentType : 'application/json',
                    url: "registry/addUser",
                    dataType: "json",
                    async: false,
                    data: jsonData,
                    success: function (msg) {
                        if(msg.code === '0'){
                            BootstrapDialog.show({
                                title: "提示",
                                message: '注册成功!',
                                closable: false,
                                buttons : [{
                                    label : "确认",
                                    action : function(dialog){
                                        window.location.href = '/login';
                                        dialog.close();
                                    }
                                }]
                            });

                        }
                        else{
                            BootstrapDialog.show({
                                title: "提示",
                                message: '注册失败：' + msg.message,
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
                    },
                    error: function (msg) {
                        BootstrapDialog.show({
                            title: "提示",
                            message: '注册发生错误：' + msg.message,
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
                return false;
            });
    });

/**
 * 校验用户信息格式是否正确
 * @returns {boolean}
 */
function validateUserInfo() {
    //获取用户注册信息
    var userId = $("#inputUserId").val();
    var username = $("#inputUsername").val();
    var password = $("#inputPassword").val();

    if(isStringEmpty(userId)||isStringEmpty(username)||isStringEmpty(password)){
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
