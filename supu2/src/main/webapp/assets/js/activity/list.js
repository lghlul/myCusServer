$(function () {
    //初始化table
    loadTable();
    //	条件查询
    $('#searchActivity').click(function () {
        loadTable();

    });
    //重置
    $('#resetActivity').click(function () {
        $('#title').val("");
        $('#introduce').val("");
        $('#status option').eq(0).prop("selected", true);
    });

});


function loadTable() {
    $('#activitys').bootstrapTable('destroy');
    //列表页面
    var url = baseUrl + "/activity/getActivityList";

    $('#activitys').bootstrapTable({
        method: 'GET',
        dataType: 'json',
        editable: true,
        cache: false,
        striped: true,                      //是否显示行间隔色
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        url: url,
        pagination: true,
        minimumCountColumns: 2,
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 20, 50],        //可供选择的每页的行数（*）
        uniqueId: "activityId",                     //每一行的唯一标识，一般为主键列
        queryParams: queryParams,
        exportDataType: 'all',
        responseHandler: responseHandler,
        columns: [{
            checkbox: true
        },
            {
                field: 'title',
                title: '活动标题',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'introduce',
                title: '介绍',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'contact',
                title: '联系方式',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'startDate',
                title: '开始时间',
                align: 'center',
                valign: 'middle',
            }, {
                field: 'endDate',
                title: '结束时间',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'status',
                title: '状态',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "上架";
                    } else {
                        return "下架";
                    }

                }
            },
            {
                field: 'status',
                title: '操作',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    //var _html =  '<a href=' + baseUrl + '/user/member/editPage?id=' + row.id + '><button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>';
                    var _html = "<a href=recordListPge?activityId=" + row.activityId + "><button class=\"btn btn-bj\"><i class=\"iconfont\">&#xe6e3;</i>&nbsp;中奖情况</button></a>"
                    return _html;
                }
            }
        ],

        onEditableSave: function (field, row, oldValue, $el) {

        }

    });

// 用于server 分页，表格数据量太大的话 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server"
    //改为 sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
    function responseHandler(res) {
        //alert(res.records.length);
        if (res) {
            return {
                "rows": res.records,
                "total": res.total
            };
        } else {
            return {
                "rows": [],
                "total": 0
            };
        }
    };

    function queryParams(params) {
        var params = {
            limit: this.pageSize,
            offset: params.offset,
            title: $('#title').val(),
            status: $('#status').val(),
            introduce: $('#introduce').val(),
        };
        return params;
    };
}


