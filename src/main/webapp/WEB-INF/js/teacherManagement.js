$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#teachers_info_table').bootstrapTable({
            url: '/userInfo/teacher/page',
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            clickToSelect: true,                //是否启用点击选中行
            height: 400,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "teacherId",              //每一行的唯一标识，一般为主键列
            columns: [{
                checkbox: true
            }, {
                field: 'teacherName',
                title: '姓名'
            }, {
                field: 'teacherId',
                title: '工号'
            }, {
                field: 'teacherEmail',
                title: '邮箱'
            },{
                field: 'teacherPhone',
                title: '电话'
            }]
        });
    };

    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

function addTeacherInfo(){
    $("#myModalLabel").html("添加教师信息");
    $("#editTeacherInfo").modal("show");
}

function updateTeacherInfo(){
    $("#myModalLabel").html("修改教师信息");
    $("#editTeacherInfo").modal("show");
}