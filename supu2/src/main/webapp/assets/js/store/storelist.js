$(function(){


	 $('#city_china_val').cxSelect({
		   url:baseUrl+'/assets/js/cxselect/cityData.json',
		   selects: ['province','city', 'area'],
		   nodata: 'none'
	});


	//初始化table
	loadTable();


//	条件查询
	$('#searchStore').click(function(){
		loadTable();

	});



	//重置
	$('#resetStore').click(function(){
    	$('#mainStoreName').val("");

    	$('#select_province').prop('value','1');
    	$('#select_city').prop('value','1');
    	$('#select_area').prop('value','1');
    	$('#select_StatusStore option').eq(0).prop("selected", true);
	  	/* $('#city_china_val').cxSelect({
		   url:baseUrl+'/assets/js/cxselect/cityData.json',
		   selects: ['province','city', 'area'],
		   nodata: 'none'
	});*/
//alert($('#select_province').eq().val());

//	alert($('#select_province').attr('value','1'));
    /*	$('#select_province').eq(0).prop("selected", true);*/
    	//$('#select_StatusStore option').eq(0).prop("selected", true);

//		//重置资讯类型
//	    $("#select_infoType option").eq(0).prop("selected", true);
//		//重置咨询状态
//	    $("#select_infoStatus option").eq(0).prop("selected", true);
	});
//	//批量 下线
//	$('#stopByList').click(function(){
//		//获取选中的行
//		rows=$('#realseInfo').bootstrapTable('getSelections');
//		for ( var i = 0; i < rows.length; i++) {
//			if (rows[i].status!=3) {
//				 //返回操作信息
//				 $('#resultMsg').text("勾选的第"+(i+1)+"行不是生效状态,无法下线");
//
//				 $('#endModal').modal('show');
//				 return false;
//			}
//		}
//		if (rows.length==0) {
//			 //返回操作信息
//			 $('#resultMsg').text("请选择要下线的行");
//
//			 $('#endModal').modal('show');
//		}else{
//			var desc="确定下线这些资讯？";
//			//暂停销售
//			var stopSaleurl=baseUrl+"/user/realseInfo/changeStatusByList?idItems="+getIds(rows)+"&status=4";
//			changeStatusById(desc,stopSaleurl);
//		}
//
//	});
//
//
//	//批量  删除服务
//	$('#deleteByList').click(function(){
//		//获取选中的行
//		rows=$('#realseInfo').bootstrapTable('getSelections');
//		for ( var i = 0; i < rows.length; i++) {
//			if (rows[i].status==2) {
//				 //返回操作信息
//				 $('#resultMsg').text("勾选的第"+(i+1)+"行是待审核状态,无法删除");
//
//				 $('#endModal').modal('show');
//				 return false;
//			}else if(rows[i].status==3){
//				 //返回操作信息
//				 $('#resultMsg').text("勾选的第"+(i+1)+"行是生效状态,无法删除");
//
//				 $('#endModal').modal('show');
//				 return false;
//			}
//		}
//		if (rows.length==0) {
//			 //返回操作信息
//			 $('#resultMsg').text("请选择要删除的行");
//
//			 $('#endModal').modal('show');
//		}else{
//			var desc="确定删除这些资讯？";
//			//删除服务
//			var deleteSaleurl=baseUrl+"/user/realseInfo/changeStatusByList?idItems="+getIds(rows)+"&status=5";
//			changeStatusById(desc,deleteSaleurl);
//		}
//
//	});
});



function loadTable(){
	 $('#storeList').bootstrapTable('destroy');
	//列表页面
	var url =baseUrl+"/user/store/getStoreList";
	//alert(url);

//	//编辑页面
//	var editurl =baseUrl+"/customers/editPage.action?customerid=";


    $('#storeList').bootstrapTable({
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
            field: 'storename',
            title: '门店名称',
            align: 'center',
            valign : 'middle',
            weight:160,
            formatter:function(value,row,index){
            	if(value !=null && value !=''){
            		return '<a href='+baseUrl+'/user/store/detailPage?id='+row.id+'>'+value+'</a>';
            	}
            }
        },
        {
            field: 'area',
            title: '所属区域',
            align: 'center',
            valign : 'middle',
            weight:160,
        },
        {
            field : 'status',
            title : '状态',
            align : 'center',
            valign : 'middle',
            formatter: function(value,row,index){
            	if (value==1){
            		return '筹备中';
            	}else if(value==2) {
					return '开业中';
				}else if(value==3){
					return '暂停中';
				}else if(value==4){
					return '已关闭';
				}else if(value==null || value==''){
					return '';
				}
           }
        },
//        {
//          field : 'realsetime',
//          title : '发布时间',
//          align : 'center',
//          valign : 'middle',
//          formatter:function(value,row,index){
//          	if (value==null || value=='') {
//          		return '';
//				}else{
//					return moment(value).format('YYYY-MM-DD');
//				}
//
//		    }
//      }
        {
            field : 'status',
            title : '操作',
            align : 'center',
            valign : 'middle',
            formatter: function(value,row,index){
            	return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
	           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>';
//            	if(value==1){
//					return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
//		           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
//		           	 '<a onclick="willCheckById(this)" data-id='+row.id+'>'+
//		           	 '<button class="btn btn-ds"><i class="iconfont">&#xe66b;</i>&nbsp;开业</button></a>';
//            	}
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
	        	storename:$('#mainStoreName').val(),
	        	province:$('#select_province').val(),
	        	city:$('#select_city').val(),
	        	region:$('#select_area').val(),
	        	status:$('#select_StatusStore option:selected').val()
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
////下线
//function stopSaleById(obj){
//	var thisObj=$(obj);
//	var id=thisObj.data('id');
//	var desc="确定下线该资讯？";
//	//下线
//	var stopSaleurl=baseUrl+"/user/realseInfo/changeStatusByList?idItems="+id+"&status=4";
//	changeStatusById(desc,stopSaleurl);
//
//}
////待审
//function willCheckById(obj){
//	var thisObj=$(obj);
//	var id=thisObj.data('id');
//	var desc="确定将该资讯变为待审状态？";
//	//待审
//	var forSaleurl=baseUrl+"/user/realseInfo/changeStatusByList?idItems="+id+"&status=2";
//	changeStatusById(desc,forSaleurl);
//
//}
////审核
//function checkSaleById(obj){
//	var thisObj=$(obj);
//	var id=thisObj.data('id');
//	var desc="确定审核该资讯？";
//	//审核
//	var forSaleurl=baseUrl+"/user/realseInfo/changeStatusByList?idItems="+id+"&status=3";
//	changeStatusById(desc,forSaleurl);
//
//}
////恢复生效
//function forSaleById(obj){
//	var thisObj=$(obj);
//	var id=thisObj.data('id');
//	var desc="确定将该资讯恢复生效？";
//	//恢复生效
//	var forSaleurl=baseUrl+"/user/realseInfo/recoverToEffectByList?idItems="+id+"&status=3";
//	changeStatusById(desc,forSaleurl);
//
//}
////删除服务
//function deleteById(obj){
//	var thisObj=$(obj);
//	var id=thisObj.data('id');
//	var desc="确定删除该资讯？";
//	//删除服务
//	var deleteSaleurl=baseUrl+"/user/realseInfo/changeStatusByList?idItems="+id+"&status=5";
//	changeStatusById(desc,deleteSaleurl);
//
//}

///**
// * 删除服务
// * @param obj
// */
//function changeStatusById(desc,url){
//	bootbox.confirm("<font size='4'>"+desc+"</font>", function(result) {
//		if(result) {
//			//var deleteUrl=delurl+id;
//			$.ajax({
//				type:'post',
//				url:url,
//				success:function(data){
//					if(data.resultCode==200){
//						location.reload();
//					}else{
//						alert("操作失败");
//					}
//				},
//				error:function(data){
//					alert("操作失败");
//				}
//			});
//
//		}
//	});
//}
//
///**
// * 拼接选中行id
// */
//function getIds(rows){
//
//	var idItems="";
//	//循环拼接
//	for ( var i = 0; i < rows.length; i++) {
//		idItems+=rows[i].id+',';
//	}
//	return idItems.substring(0, idItems.length-1);
//}


