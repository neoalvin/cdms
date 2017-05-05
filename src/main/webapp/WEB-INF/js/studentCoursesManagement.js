$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#courses_info_table').bootstrapTable({
        	url: "/courses/page",
        	height: 400,  
            columns: [{
                checkbox: true
            }, {
                field: 'courseId',
                title: '题目序号'
            }, {
                field: 'courseName',
                title: '题目名称'
            }]
        });
    };

    return oTableInit;
};
