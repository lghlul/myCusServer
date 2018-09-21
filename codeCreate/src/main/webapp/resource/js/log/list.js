var spr = spr || {};
spr.log = spr.log || {};

spr.log.logTable = {
	init:function(){
		//全选
		$('.table-sort th input:checkbox').on( 'click', function() { 
	         var that = this; 
	         $(this).closest('table').find( 
	             'tr > td:first-child input:checkbox').each( 
	             function() { 
	               this.checked = that.checked; 
	               $(this).closest('tr').toggleClass('selected'); 
	             }); 
	    }); 
		
		//搜索
		$('.btn-success').on( 'click', function() { 
			$(".table-sort").dataTable().fnDraw(false);
	    });
		
		//初始化数据
		var table_sort=  $('.table-sort').dataTable({
			/* "aaSorting": [[ 1, "desc" ]],//默认第几个排序 */
			"aLengthMenu" : [ 5, 10, 15 ], //分页工具条页数设置
			"bPaginate": true,  //分页工具条显示
			"bStateSave": true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
			"pading":true,
			"sPaginationType" : "full_numbers", //分页
			"bServerSide" : true,  //服务器处理分页  服务器端分页必须设置
			"bAutoWidth": true, // 是否自动宽度
			/* "sAjaxDataProp": "aaData", */ //是服务器分页的标志 默认aaData
			"sAjaxSource" : "list.do",
			"bProcessing": true, //开启读取服务器数据时显示正在加载中
			"bFilter" : false, //搜索栏
			"bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
			"aoColumns" : [//初始化要显示的列  
		      {  
		          "mDataProp" : "id"//获取列数据，跟服务器返回字段一致  
		      },  
		      {  
		          "mDataProp" : "logType",
		          "mRender" : function(data, type, full) {
		        	  if(data==1){
		        		  return "用户操作类型";
		        	  }
		        	  if(data==2){
		        		  return "系统日志类型";
		        	  }
		        	  return "未知";
		          }  
		      },
		      {  
		          "mDataProp" : "description"
		      },
		      {  
		          "mDataProp" : "accountName" 
		      },  
		      {  
		    	  "mDataProp" : "operTime",  
		          "mRender" : function(data, type, full) {
		        	  var newDate = new Date();
		              	newDate.setTime(data);
		              	return newDate.toLocaleString()
		          }  
		      },  
		      {  
		          "mDataProp" : "id",  
		          "mRender" : function(data, type, full) {
		              return '<a class="btn btn-secondary-outline radius size-S" href="javascript:void(0);" onclick="spr.log.logTable.opreation.detail('+data+')">详情</a> ' ;
		          }  
		      } ]    , 
		      "fnServerData" : function(sSource, aoData, fnCallback) {
		    	  aoData.push(
		                  {  "name": "userName", "value": $("#userName").val()}
		          );
		    	  aoData.push(
		                  { "name": "logType", "value": $("#logType").val()}
		          );
		    	 
		          $.ajax({
		              "type" : 'post',
		              "url" : sSource,
		              "dataType" : "json",
		              "data" : aoData,
		              "success" : function(resp) {
		            	  //总页数
		            	  $('.totalNum').html(resp.iTotalDisplayRecords);
		                  fnCallback(resp); //服务器端返回的对象的returnObject部分是要求的格式
		                  //表格自适应样式设置
		                  $('.table-sort').css("width","100%");
		              },
		              error: function(resp){
		            	  //fnCallback(resp.responseText);
		              }
		         });
		      }  ,
			 "aoColumnDefs": [//用来设置列一些特殊列的属性
			  /* {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示 */
			  {"orderable":false,"aTargets":[0,4]}// 不参与排序的列
			],
			createdRow: function (row, data, index) { // 初始化行时 可对数据进行过滤
		      $(row).addClass('text-c');
		    }
		}); 
	},
    btn: {
       
    },
    opreation: {
    	detail: function(id) {
            var url = 'logDetail.do?id='+id;
            var index = layer.open({
    			type: 2,
    			title: "日志详情",
    			content: url,
    			shadeClose: true,
    			scrollbar: false
    		});
    		layer.full(index);
        }
        
    }
};