$(function(){



	//初始化table
	loadTable();


//	条件查询
	$('#searchMember').click(function(){
		loadTable();

	});
//
//
//
	//重置
	$('#resetMember').click(function(){
    	$('#serachMemberName').val("");
    	$('#serachMobile').val("");
    	/*$('#select_buycard option').eq(0).prop("selected", true);*/
    	$('#select_memberStatus option').eq(0).prop("selected", true);
    	$('#select_memberfrom option').eq(0).prop("selected", true);
    	$('#select_membertype option').eq(0).prop("selected", true);
    	$('#select_store option').eq(0).prop("selected", true);

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

});



function loadTable(){
	 $('#members').bootstrapTable('destroy');
	//列表页面
	var url =baseUrl+"/user/member/getMemberList";
	//alert(url);

//	//编辑页面
//	var editurl =baseUrl+"/customers/editPage.action?customerid=";


   $('#members').bootstrapTable({
       method:'GET',
       dataType:'json',
     //  contentType: "application/x-www-form-urlencoded",
       editable:true,
       cache: false,
       striped: true,                      //是否显示行间隔色
       sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
       url:url,
//     height: $(window).height() ,
//     width:$(window).width(),
//       showColumns:true,
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
//       {
//           field : 'customerid',
//           title : 'id',
//           align : 'center',
//           valign : 'middle',
//       },
       {
           field: 'membername',
           title: '会员名称',
           align: 'center',
           valign: 'middle',
           weight:160,
           formatter:function(value,row,index){
	           	if(value !=null && value !=''){
	           		return '<a href='+baseUrl+'/user/member/detailPage?id='+row.id+'>'+value+'</a>';
	           	}
           }
       },
       {
           field: 'phonenumber',
           title: '会员电话',
           align: 'center',
           valign: 'middle',
           weight:160
       },
/*       {
           field : 'status',
           title : '状态',
           align : 'center',
           valign : 'middle',
           formatter: function(value,row,index){
	           	if (value==0){
	           		return '未购买';
	           	}else if(value==1) {
					return '已购买';
				}
	//           	else if(value==3){
	//				return '暂停中';
	//			}else if(value==4){
	//				return '已关闭';
	//			}
				else if(value==null || value==''){
					return '';
				}
          }
       },*/
       {
           field : 'membertype',
           title : '会员类型',
           align : 'center',
           valign : 'middle',
           formatter:function(value,row,index){
             	if(value ==1){
             		return '顾客';
             	}else if(value==2){
             		return '工作人员';
             	}
            }
       },
       {
         field : 'membersource',
         title : '会员来源',
         align : 'center',
         valign : 'middle',
         formatter:function(value,row,index){
           	if(value ==1){
           		return '公众号注册';
           	}else if(value==2){
           		return '线下会员';
           	}
          }
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
           field : 'expiretime',
           title : '到期时间',
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
           field : 'status',
           title : '操作',
           align : 'center',
           valign : 'middle',
           formatter: function(value,row,index){
           	return '<a href='+baseUrl+'/user/member/editPage?id='+row.id+'>'+
	           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>';
//           	if(value==1){
//					return '<a href='+baseUrl+'/user/store/editPage?id='+row.id+'>'+
//		           	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
//		           	 '<a onclick="willCheckById(this)" data-id='+row.id+'>'+
		           	 '<button class="btn btn-ds"><i class="iconfont">&#xinsertSelectiveinsertSelectivee66b;</i>&nbsp;开业</button></a>';
//           	}
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
	        	membername:$('#serachMemberName').val(),
	        	/*choosemcode:$('#select_buycard option:selected').val(),*/
	        	status:$('#select_memberStatus option:selected').val(),
	        	membersource:$('#select_memberfrom option:selected').val(),
	        	storeid:$('#select_store option:selected').val(),
	        	membertype:$('#select_membertype option:selected').val(),
	        	phonenumber:$('#serachMobile').val(),
	        };
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


