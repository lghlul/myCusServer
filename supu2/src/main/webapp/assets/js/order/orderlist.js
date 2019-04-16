$(function(){



	//初始化table
	loadTable();


	//条件查询
	$('#searchOrder').click(function(){
		loadTable();

	});

	//重置
	$('#resetOrder').click(function(){
		$('#serachecode').val("");
		$('#starttime').val("");
		$('#endtime').val("");
		$("#select_ordertype option").eq(0).prop("selected", true);
	    $("#select_issuccess option").eq(0).prop("selected", true);
	});

});



function loadTable(){
	 $('#orderList').bootstrapTable('destroy');
	//列表页面
	var url =baseUrl+"/user/order/getOrderList";
	//alert(url);

//	//编辑页面
//	var editurl =baseUrl+"/customers/editPage.action?customerid=";


    $('#orderList').bootstrapTable({
        method:'GET',
        dataType:'json',
      //  contentType: "application/x-www-form-urlencoded",
        editable:true,
        cache: false,
        striped: true,                      //是否显示行间隔色
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        url:url,
//      height: $(window).height() ,
//      width:$(window).width(),
//        showColumns:true,
        pagination:true,

        minimumCountColumns:2,
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 20,50],        //可供选择的每页的行数（*）
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        queryParams : queryParams,
       //showExport: true,  //导出数据，包括SQL,xml等数据
        exportDataType: 'all',
        responseHandler: responseHandler,
        columns: [{
            checkbox: true
        },
//        {
//            field : 'customerid',
//            title : 'id',
//            align : 'center',
//            valign : 'middle',
//        },
        {
            field: 'ecode',
            title: '用户名称',
            align: 'center',
            valign : 'middle',
            weight:160,
        },
        {
            field: 'ordernumber',
            title: '订单号',
            align: 'center',
            valign : 'middle',
            weight:160,
        },
        {
            field: 'ordername',
            title: '订单名称',
            align: 'center',
            valign : 'middle',
            weight:160,
        },
        {
            field: 'coachnames',
            title: '教练名称',
            align: 'center',
            valign : 'middle',
            weight:160,
        },
        {
            field : 'type',
            title : '订单类型',
            align : 'center',
            valign : 'middle',
            formatter: function(value,row,index){
            	if (value==0){
            		return '会员卡';
            	}else if(value==1) {
					return '私教课';
				}else if(value==2){
					return '训练营';
				}else if(value==3){
					return '工作室';
				}else if(value==null || value==''){
					return '';
				}
           }
        },
        {
            field: 'amount',
            title: '购买金额',
            align: 'center',
            valign : 'middle',
            weight:160,
        },

        {
          field : 'buytime',
          title : '购买时间',
          align : 'center',
          valign : 'middle',
          formatter:function(value,row,index){
          	if (value==null || value=='') {
          		return '';
				}else{
					return moment(value).format('YYYY-MM-DD HH:mm:ss');
				}

		    }
        },
        {
            field : 'issuccess',
            title : '是否支付',
            align : 'center',
            valign : 'middle',
            formatter: function(value,row,index){
            	if (value==0){
            		return 'NO';
            	}else if(value==1) {
					return 'YES';
				}else if(value==null || value==''){
					return '';
				}
           }
        },
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
	                "rows" : res.records,
	                "total" : res.total
	            };
	        } else {
	            return {
	                "rows" : [],
	                "total" : 0
	            };
	        }
	    };

	    function queryParams(params) {
	         var params = {
	            limit :  this.pageSize,
	            offset: params.offset,
	        	ecode:$('#serachecode').val(),
	        	starttime:$('#starttime').val(),
	        	endtime:$('#endtime').val(),
	        	issuccess:$('#select_issuccess option:selected').val(),
	        	type:$('#select_ordertype option:selected').val()
	        }
	        return params;
	    };
//	    function operateFormatter(value, row, index) {
//	    	     return [
//	    	          '<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">A权限</button>',
//	    	          '<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">B权限</button>',
//	    	          '<button type="button" class="RoleOfC btn btn-default  btn-sm" style="margin-right:15px;">C权限</button>',
//	    	    ].join('');
//	    }
}



