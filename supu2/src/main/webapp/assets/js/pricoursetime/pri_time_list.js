$(function(){

	//初始化table
	loadTable();


//	条件查询
	$('#searchStore').click(function(){
		loadTable();

	});



	//重置
	$('#resetStore').click(function(){
    	$('#selectymonth').val("");

    	$('#select_StatusStore option').eq(0).prop("selected", true);

	});

	function loadTable(){
		 $('#pritimelist').bootstrapTable('destroy');
		//列表页面
		//var url =baseUrl+"/user/pricoursetime/getpricoursetimeList";
		 //var url ="a";



	    $('#pritimelist').bootstrapTable({
	        method:'GET',
	        dataType:'json',
	      //  contentType: "application/x-www-form-urlencoded",
	        editable:true,
	        cache: false,
	        striped: true,                      //是否显示行间隔色
	        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	        url:baseUrl+"/user/pricoursetime/getpricoursetimeList",
//	      height: $(window).height() ,
//	      width:$(window).width(),
//	        showColumns:true,
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
//	        {
//	            field : 'customerid',
//	            title : 'id',
//	            align : 'center',
//	            valign : 'middle',
//	        },
//	        {
//	            field: 'coachid',
//	            title: '教练id',
//	            align: 'center',
//	            valign : 'middle',
//	            weight:160,
//	            hidden :true,
//
//	        },
	        {
	            field: 'coachname',
	            title: '教练名字',
	            align: 'center',
	            valign : 'middle',
	            weight:160,
	        },
	        {
	            field : 'selectymonth',
	            title : '月份',
	            align : 'center',
	            valign : 'middle',
	        },
	        {
	          field : 'addtime',
	          title : '发布时间',
	          align : 'center',
	          valign : 'middle',
	          formatter:function(value,row,index){
	          	if (value==null || value=='') {
	          		return '';
					}else{
						return moment(value).format('YYYY-MM-DD');
					}

			    }
	      },
	        {
	            field : 'status',
	            title : '操作',
	            align : 'center',
	            valign : 'middle',
	            formatter: function(value,row,index){
	            	return '<a href='+baseUrl+'/user/pricoursetime/editPage?date='+row.selectymonth+'&coachId='+row.coachId+'>'+
		           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>';
//	            	if(value==1){
//						return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
//			           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
//			           	 '<a onclick="willCheckById(this)" data-id='+row.id+'>'+
//			           	 '<button class="btn btn-ds"><i class="iconfont">&#xe66b;</i>&nbsp;开业</button></a>';
//	            	}
	/*            	else if(value==2) {
						return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
			           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
			           	 '<a class="" onclick="stopSaleById(this)" data-id='+row.id+'>'+
			          	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe669;</i>&nbsp;暂停</button></a>&nbsp;&nbsp;'+
			           	 '<a  onclick="forSaleById(this)" data-id='+row.id+'>'+
			           	 '<button class="btn btn-hf btn-sm"><i class="iconfont">&#xe64b;</i>&nbsp;关闭</button></a>';
					}else if(value==3){
						return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
			           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
			           	 '<a onclick="willCheckById(this)" data-id='+row.id+'>'+
			           	 '<button class="btn btn-ds"><i class="iconfont">&#xe66b;</i>&nbsp;开业</button></a>&nbsp;&nbsp;'+
			           	 '<a  onclick="forSaleById(this)" data-id='+row.id+'>'+
			           	 '<button class="btn btn-hf btn-sm"><i class="iconfont">&#xe64b;</i>&nbsp;关闭</button></a>';
					}else if(value==4){
						return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
			           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
			           	 '<a onclick="willCheckById(this)" data-id='+row.id+'>'+
			           	 '<button class="btn btn-ds"><i class="iconfont">&#xe66b;</i>&nbsp;开业</button></a>&nbsp;&nbsp;'+
			           	 '<a  onclick="deleteById(this)" data-id='+row.id+'>'+
			          	 '<button class="btn btn-dl btn-sm"><i class="iconfont">&#xe637;</i>&nbsp;删除</button></a>';
					}*/
	           },width:400
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
		            date:$('#selectymonth').val(),
//		        	province:$('#select_province').val(),
//		        	city:$('#select_city').val(),
//		        	region:$('#select_area').val(),
		        	coachId:$('#select_StatusStore option:selected').val()
		        }
		        return params;
		    };
//		    function operateFormatter(value, row, index) {
//		    	     return [
//		    	          '<button type="button" class="RoleOfA btn btn-default  btn-sm" style="margin-right:15px;">A权限</button>',
//		    	          '<button type="button" class="RoleOfB btn btn-default  btn-sm" style="margin-right:15px;">B权限</button>',
//		    	          '<button type="button" class="RoleOfC btn btn-default  btn-sm" style="margin-right:15px;">C权限</button>',
//		    	    ].join('');
//		    }
	}

});






