$(function(){



	//初始化table
	//loadTable();


//	条件查询
	$('#searchMember').click(function(){
		loadTable();
	});
	$('#resetMember').click(function(){
    	//$('#serachMemberName').val("");
    	$('#serachMobile').val("");
    	/*$('#select_buycard option').eq(0).prop("selected", true);*/
    	//$('#select_memberStatus option').eq(0).prop("selected", true);
    	//$('#select_memberfrom option').eq(0).prop("selected", true);
    	//$('#select_membertype option').eq(0).prop("selected", true);
    	//$('#select_store option').eq(0).prop("selected", true);

	});
});



function loadTable(){
	 $('#members').bootstrapTable('destroy');
	//列表页面
	var url =baseUrl+"/user/xfuser/getuserList";
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
           field: 'name',
           title: '用户名称',
           align: 'center',
           valign: 'middle',
           weight:160,
           formatter:function(value,row,index){
	           	if(value !=null && value !=''){
	           		return '<a href='+baseUrl+'/user/xfuser/detailPage?id='+row.id+'&org='+row.org+'>'+value+'</a>';
	           	}
           }
       },
       {
           field: 'phone',
           title: '用户电话',
           align: 'center',
           valign: 'middle',
           weight:160
       },
       {
           field : 'org',
           title : '用户类型',
           align : 'center',
           valign : 'middle',
           formatter:function(value,row,index){
             	if(value > 0){
             		return '会员';
             	}else if(value < 0){
             		return '普通用户';
             	}
            }
       },
       {
           field : 'status',
           title : '操作',
           align : 'center',
           valign : 'middle',
           formatter: function(value,row,index){
           	return '<button class="btn btn-bj" onclick="deleteUser(' + row.id + ')"><i class="iconfont">&#xe6e3;</i>&nbsp;删除</button>';
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
}


function deleteUser(id) {
    layer.confirm('确定要删除用户信息吗？', {
        btn: ['确定', '取消'],
        title: "提示"
    }, function () {
        var url = baseUrl + "/user/xfuser/delete";
        $.post(url, {"id": id}, function (res) {
            if (res.resultCode == 200) {
                layer.msg('删除成功');
                loadTable();
            }
        }, "json")
    });
}


