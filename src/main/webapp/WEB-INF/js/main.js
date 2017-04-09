function logoutFromSystem(){
    BootstrapDialog.show({
        title: "提示",
        message: '确定注销？',
        closable: false,
        buttons : [{
            label : "确认",
            action : function(dialog){
                window.location.href = "/logout";
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

