$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#students_info_table').bootstrapTable({
            url: '/userInfo/student/page',
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
            uniqueId: "studentId",              //每一行的唯一标识，一般为主键列
            columns: [{
                checkbox: true
            }, {
                field: 'studentName',
                title: '姓名'
            }, {
                field: 'studentId',
                title: '学号'
            },  {
                field: 'studentClass',
                title: '班级'
            }, {
                field: 'studentEmail',
                title: '邮箱'
            },{
                field: 'studentPhone',
                title: '电话'
            }]
        });
    };

    return oTableInit;
};


function addStudentInfo(){
    $("#myModalLabel").html("添加学生信息");
    $("#editStudentInfo").modal("show");
}

function updateStudentInfo(){
    $("#myModalLabel").html("修改学生信息");
    $("#editStudentInfo").modal("show");
}