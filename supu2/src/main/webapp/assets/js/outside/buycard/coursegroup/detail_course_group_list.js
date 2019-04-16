$(function(){
	
	// loadTable();//初始化评论
	grade();//获取评论的人数和品均分数
	
	
 	var startDate=$('#startDate').val();;
 	var endDate=$('#endDate').val();;
	//精品团课id
	var courseid=$('#courseid').val();
 	//点击购买按钮
 	$('#buyexccourse').click(function(){
 		//训练营是否已满以及是否购买相同的课程
		$.ajax({
		      type:"POST",
		      data:$('#form').serialize(),
		      async:false,
		      url:baseUrl+"/outside/personal/buySameGrouCourse?cid="+courseid+"&startDate="+startDate+"&endDate="+endDate,
		      success:function(data, textStatus, request){
		    	  if (request.getResponseHeader('sessionstatus')=="unlogin") {
		    		   window.location=baseUrl+"/outside/login";
		    	  }else{
		    		  if (data.resultCode==200) {
		    			  window.location.href=baseUrl+"/outside/personal/buygroupcourse?startDate="+startDate+"&&endDate="+endDate+"&&courseId="+courseid;

			    	  }else{
			 	          	$('#errorMassage').text("");
			 				$('.failmask').show();
			 				$('#errorMassage').text(data.message);
			 				$('#alertFail').show();
			    	  }

		    	  }
		      }
		});
 	});


	/**
	 * 隐藏弹出层
	 */
	$('.mint-msgbox-cancel').click(function(){
		$('#alertFail').hide();
		$('.failmask').hide();

	});
});



//页面初始化的加载页面中品论
function loadTable(){
 // $('#members').bootstrapTable('destroy');
//列表页面
var url =baseUrl+"/user/comment/getCommenListPublic";
$('#members').bootstrapTable({
  method:'GET',
  dataType:'json',
  editable:true,
  cache: false,
  striped: true,                      //是否显示行间隔色
  sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
  url:url,
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
  columns: [
  {
      field: 'id',
      title: 'id',
      align: 'center',
      valign: 'middle',
      weight:160
  },
  {
      field: 'userName',
      title: '姓名',
      align: 'center',
      valign: 'middle',
      weight:160
  },
  {
      field : 'addtime',
      title : '添加时间',
      align : 'center',
      valign : 'middle'
  },
  {
      field : 'content',
      title : '评论内容',
      align : 'center',
      valign : 'middle'
  },
  {
      field : 'head',
      title : '头像',
      align : 'center',
      valign : 'middle'
  }
  ],

  onEditableSave: function (field, row, oldValue, $el) {

  }

});

//用于server 分页，表格数据量太大的话 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server"
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
        	limitend :  this.pageSize,
            limitstart: params.offset,
            source:$("#source").val(),//机构识别，私教课的识别ID
            sourceID:$("#sourceID").val(),//当前机构中的ID，当前是私教
        };
        return params;
    };
}

function grade(){//私教的ID
	$.ajax({
	    type:"GET",
	    data:{
	    	"source":$("#source").val(),//私教课的识别ID
	    	"sourceID":$("#sourceID").val()//当前机构中的ID，当前是私教
	    },
	    url:baseUrl+'/user/comment/getCommentgradePN',
	    success:function(jsonDate){
	//    	alert(jsonDate.resultCode);
	//    	alert(jsonDate.records.count);
	    	
	    	$("#count").html(jsonDate.records.count)
	    	$("#number").html(jsonDate.records.number)
	    	      
	    }
	});

}





