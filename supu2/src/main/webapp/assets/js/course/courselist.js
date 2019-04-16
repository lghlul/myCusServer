$(function(){

	//初始化table
	loadTable();


	//条件查询
	$('#searchCourse').click(function(){
		loadTable();

	});

	//重置
	$('#resetCourse').click(function(){
		$('#serachcoursename').val("");
		//重置资讯类型
	    $("#select_courseType option").eq(0).prop("selected", true);
		//重置咨询状态
	    $("#select_courseStatus option").eq(0).prop("selected", true);
	});

});
function loadTable(){
	 $('#coursetable').bootstrapTable('destroy');
	//列表页面
	var url =baseUrl+"/user/course/getCourseList";
	//alert(url);

//	//编辑页面
//	var editurl =baseUrl+"/customers/editPage.action?customerid=";


   $('#coursetable').bootstrapTable({
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
//           field : 'id',
//           title : 'id',
//           align : 'center',
//           valign : 'middle',
//       },
     {
	     field: 'coursename',
	     title: '课程名称',
	     align: 'center',
	     valign: 'middle',
	     weight:160,
	     formatter:function(value,row,index){
	     	if(value !=null && value !=''){
	     		if (row.type==3) {
	     			return '<a href='+baseUrl+'/user/course/detailPage?id='+row.id+'&type=2>'+value+'</a>';
				}else{
		     		return '<a href='+baseUrl+'/user/course/detailPage?id='+row.id+'&type='+row.coursetype+'>'+value+'</a>';
				}
	     	}
	     }
	 },
	  {
	   field : 'coursetype',
	   title : '课程类型',
	   align : 'center',
	   valign : 'middle',
	   formatter: function(value,row,index){
		   //console.log(row);
		   if (value==0){
			   if (row.isexperience==0) {
				   return '私教课';
			   }else if(row.isexperience==1){
		   			return '私教课-体验课';
			   }else if(value==null || value==''){
					return '私教课';
				}
	   		}else if(value==1) {
	   			if(row.type==1){
	   				return '训练营';
	   			}else if(row.type==2){
	   				return '基础团课';
	   			}else if(row.type==3){
	   				return '工作室';
	   			}
			}else if(value==null || value==''){
				return '未知';
			}
	  }
	},
    {
	     field: 'coachname',
	     title: '教练名称',
	     align: 'center',
	     valign: 'middle',
	     weight:160,
	 },
	 {
	  field : 'status',
	  title : '状态',
	  align : 'center',
	  valign : 'middle',
	  formatter: function(value,row,index){
	  		if (value==1){
	  			return '生效中';
	  		}else if(value==2) {
				return '已失效';
			}else if(value==null || value==''){
				return '';
			}
	 }
	},
//       {
//         field : 'realsetime',
//         title : '发布时间',
//         align : 'center',
//         valign : 'middle',
//         formatter:function(value,row,index){
//         	if (value==null || value=='') {
//         		return '';
//				}else{
//					return moment(value).format('YYYY-MM-DD');
//				}
//
//		    }
//     }
	  {
		   field : 'coursetype',
		   title : '操作',
		   align : 'center',
		   valign : 'middle',
		   formatter: function(value,row,index){
			   //console.log(row);
			   if (value==0){
					if(row.status==1){
						return '<a href='+baseUrl+'/user/course/editPage?id='+row.id+'&&type='+row.coursetype+'>'+
				       	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
				       	 '<a class="" onclick="stopCourseById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
				      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe669;</i>&nbsp;暂停</button></a>';
					}else if(row.status==2) {
						return '<a  onclick="forCourseById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
				       	 '<button class="btn btn-hf btn-sm"><i class="iconfont">&#xe64b;</i>&nbsp;启用</button></a>&nbsp;&nbsp;'+
				       	 '<a class="" onclick="deleteById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
				      	 '<button class="btn btn-dl btn-sm"><i class="iconfont">&#xe637;</i>&nbsp;关闭</button></a>';
					}
		   		}else if(value==1) {
					if(row.status==1){
						if (row.type==1) {
							return '<a href='+baseUrl+'/user/course/editPage?id='+row.id+'&&type='+row.coursetype+'>'+
					       	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
					       	 '<a class="" onclick="stopCourseById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
					      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe669;</i>&nbsp;暂停</button></a>&nbsp;&nbsp;'+
					       	 '<a class="" href='+baseUrl+'/user/course/courseExcTimePage?courseId='+row.id+'>'+
					      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe642;</i>&nbsp;排期</button></a>';
						}else if(row.type==2){
							return '<a href='+baseUrl+'/user/course/editPage?id='+row.id+'&&type='+row.coursetype+'>'+
					       	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
					       	 '<a class="" onclick="stopCourseById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
					      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe669;</i>&nbsp;暂停</button></a>&nbsp;&nbsp;'+
					       	 '<a class="" href='+baseUrl+'/user/course/courseListPage?courseId='+row.id+'>'+
					      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe642;</i>&nbsp;排期</button></a>';
						}else if(row.type==3){
							return '<a href='+baseUrl+'/user/course/editPage?id='+row.id+'&&type=2>'+
					       	 '<button class="btn btn-bj"><i class="iconfont">&#xe6e3;</i>&nbsp;编辑</button></a>&nbsp;&nbsp;'+
					       	 '<a class="" onclick="stopCourseById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
					      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe669;</i>&nbsp;暂停</button></a>&nbsp;&nbsp;'+
					       	 '<a class="" href='+baseUrl+'/user/course/workspaceTimePage?courseId='+row.id+'>'+
					      	 '<button class="btn btn-zt btn-sm"><i class="iconfont">&#xe642;</i>&nbsp;排期</button></a>';
						}
					}else if(row.status==2) {
						return '<a  onclick="forCourseById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
				       	 '<button class="btn btn-hf btn-sm"><i class="iconfont">&#xe64b;</i>&nbsp;启用</button></a>&nbsp;&nbsp;'+
				       	 '<a class="" onclick="deleteById(this)" data-id='+row.id+' data-type='+row.coursetype+'>'+
				      	 '<button class="btn btn-dl btn-sm"><i class="iconfont">&#xe637;</i>&nbsp;关闭</button></a>';
					}

				}else if(value==null || value==''){
					return '未知';
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
	        	coursename:$('#serachcoursename').val(),
	        	coursetype:$('#select_courseType option:selected').val(),
	        	status:$('#select_courseStatus option:selected').val()
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



//暂停
function stopCourseById(obj){
	var thisObj=$(obj);
	var type=thisObj.data('type');
	var id=thisObj.data('id');
	var desc="确定暂停该课程？";
	//暂停
	var stopCourseurl=baseUrl+"/user/course/updateCourseStatus?id="+id+"&status=2&type="+type;
	changeStatusById(desc,stopCourseurl);

}
//启用
function forCourseById(obj){
	var thisObj=$(obj);
	var type=thisObj.data('type');
	var id=thisObj.data('id');
	var desc="确定启用该课程？";
	//恢复生效
	var forCourseurl=baseUrl+"/user/course/updateCourseStatus?id="+id+"&status=1&type="+type;
	changeStatusById(desc,forCourseurl);

}
//删除课程
function deleteById(obj){
	var thisObj=$(obj);
	var type=thisObj.data('type');
	var id=thisObj.data('id');
	var desc="确定关闭该课程？";
	//删除课程
	var deleteCourseurl=baseUrl+"/user/course/updateCourseStatus?id="+id+"&status=0&type="+type;
	changeStatusById(desc,deleteCourseurl);

}


//改变状态
function changeStatusById(desc,url){
	bootbox.confirm("<font size='4'>"+desc+"</font>", function(result) {
		if(result) {
			//var deleteUrl=delurl+id;
			$.ajax({
				type:'GET',
				url:url,
				success:function(data){
					if(data.resultCode==200){
						$('#success_course').modal('show');
						//location.reload();
					}else{
						$('#failure_course').modal('show');
					}
				},
				error:function(data){
					$('#failure_course').modal('show');
				}
			});

		}
	});
}
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


