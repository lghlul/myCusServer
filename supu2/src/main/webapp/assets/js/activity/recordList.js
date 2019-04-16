$(function () {
    //初始化table
    loadTable();
    //	条件查询
    $('#searchRecord').click(function () {
        loadTable();

    });
    //重置
    $('#resetRecord').click(function () {
        $('#mobilePhone').val("");
        $('#status option').eq(0).prop("selected", true);
    });

});


function loadTable() {
    $('#activitys').bootstrapTable('destroy');
    //列表页面
    var url = baseUrl + "/activity/getRecordList?activityId=" + $("#activityId").val();

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
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        queryParams: queryParams,
        exportDataType: 'all',
        responseHandler: responseHandler,
        columns: [{
            checkbox: true
        },
            {
                field: 'mobilePhone',
                title: '手机号码',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'createDate',
                title: '中奖时间',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'name',
                title: '奖品名称    ',
                align: 'center',
                valign: 'middle',
            },
            {
                field: 'path',
                title: '奖品图片',
                align: 'center',
                valign: 'middle',
                formatter: function (value) {
                        return "<img src = " + value +"  style='width:100px;'>";

                }
            },
            {
                field: 'status',
                title: '状态',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "待领";
                    } else {
                        return "已领";
                    }

                }
            },
            {
                field: 'status',
                title: '操作',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    if(row.status == 1){
                        var _html =   "<a href='#' onclick='updateRecord(\"" + row.id + "\")'><button class='btn btn-bj' ><i class='iconfont'>&#xe6e3;</i>&nbsp;领取</button></a>" ;
                        return   _html ;
                    }else{
                        return "";
                    }
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
            mobilePhone: $('#mobilePhone').val(),
            status: $('#status').val(),
        };
        return params;
    };

}


