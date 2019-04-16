$(function(){

	//初始化table
	loadTable();


	//条件查询
	$('#searchAppointCourse').click(function(){
		loadTable();

	});

	//重置
	$('#resetAppointCourse').click(function(){
		$('#coursename').val("");
		$('#username').val("");
		//重置资讯类型
	    $("#select_courseType option").eq(0).prop("selected", true);
		//重置咨询状态
	    $("#select_coachname option").eq(0).prop("selected", true);
	    $("#select_courseStatus option").eq(0).prop("selected", true);
	});


	$('#exportData').click(function(){
		//var a= $.table.bootstrapTable('getSelections');
		var choose_data= $('#coursetable').bootstrapTable('getSelections');
		if(choose_data==null || choose_data==""){
			$('#failure_course').modal('show');//请选择导出数据
			return false;
		}

		var ids="";
		for(var i=0;i<choose_data.length;i++){
			ids+=choose_data[i].id+",";
			//alert(choose_data[i]);
		}
		//拼接id
		ids=ids.substring(0, ids.length-1);
		window.location.href=baseUrl+"/exportExcel?ids="+ids;

	});




});
function loadTable(){
	 $('#coursetable').bootstrapTable('destroy');
	//列表页面
	var url =baseUrl+"/user/appoint/getAppointCourseList";



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
       {
           field : 'id',
           title : 'id',
           align : 'center',
           valign : 'middle',
           visible:false //隐藏这一列
       },
     {
	     field: 'username',
	     title: '用户账号',
	     align: 'center',
	     valign: 'middle',
	     weight:160,
/*	     formatter:function(value,row,index){
	     	if(value !=null && value !=''){
	     		if (row.type==3) {
	     			return '<a href='+baseUrl+'/user/course/detailPage?id='+row.id+'&type=2>'+value+'</a>';
				}else{
		     		return '<a href='+baseUrl+'/user/course/detailPage?id='+row.id+'&type='+row.coursetype+'>'+value+'</a>';
				}
	     	}
	     }*/
	 },
     {
	     field: 'coursename',
	     title: '课程名称',
	     align: 'center',
	     valign: 'middle',
	     weight:160,
	 },
	  {
	   field : 'type',
	   title : '课程类型',
	   align : 'center',
	   valign : 'middle',
	   formatter: function(value,row,index){
		   //console.log(row);
		   if (value==0){
			   return '私教课';
	   		}else if(value==1) {
	   			return '基础团课';
			}else if(value==2) {
	   			return '工作室';
			}else if(value==null || value==''){
				return '未知';
			}
	  }
	},
    {
	     field: 'coachnames',
	     title: '教练名称',
	     align: 'center',
	     valign: 'middle',
	     weight:160,
	 },
	    {
	     field: 'storename',
	     title: '门店名称',
	     align: 'center',
	     valign: 'middle',
	     weight:160,
	 },
     {
         field : 'status',
         title : '预约状态',
         align : 'center',
         valign : 'middle',
         formatter:function(value,row,index){
         	if (value==0) {
         		return "取消";
         	}else if(value==1){
         		return "预约";
         	}

		 }
     },
       {
         field : 'starttime',
         title : '预约时间',
         align : 'center',
         valign : 'middle',
         formatter:function(value,row,index){
         	if (value==null || value=='') {
         		return '';
				}else{
					return moment(row.appointtime).format('YYYY-MM-DD')+"&nbsp;&nbsp;"+value+"~"+row.endtime;
				}

		    }
     }],

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
	        	coursename:$('#coursename').val(),
	        	username:$('#username').val(),
	        	type:$('#select_courseType option:selected').val(),
	        	coachname:$('#select_coachname option:selected').val(),
	        	status:$('#select_courseStatus option:selected').val()
	        }
	        return params;
	    };

}









