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
        $('#score_info_table').bootstrapTable({
            height: 400,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            columns: [{
                checkbox: true
            }, {
                field: 'studentId',
                title: '学号'
            },  {
                field: 'studentName',
                title: '姓名'
            }, {
                field: 'studentClass',
                title: '班级'
            }, {
                field: 'courseTitle',
                title: '课设题目'
            },{
                field: 'scoreUsual',
                title: '平时分'
            },{
                field: 'scoreMiddle',
                title: '中期成绩'
            },{
                field: 'scoreLast',
                title: '验收成绩'
            },{
                field: 'scoreSummary',
                title: '总成绩'
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

function addScoreInfo(){
    $("#editScoreInfo").modal("show");
}
