/**
 * 退出系统
 */
function logoutFromAdmin(){
    BootstrapDialog.show({
        title: "提示",
        message: '确定注销？',
        closable: false,
        buttons : [{
            label : "确认",
            action : function(dialog){
                window.location.href = "/admin/logout";
                dialog.close();
            }
        }, {
            label : "取消",
            action : function(dialog){
                dialog.close();
            }
        }]
    });
}


