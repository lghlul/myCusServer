var spr = spr || {};
spr.train = spr.train	 || {};

spr.train.trainTable = {
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
			"sAjaxSource" : "trainTable.do",
			"bProcessing": true, //开启读取服务器数据时显示正在加载中
			"bFilter" : false, //搜索栏
			"bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
			"aoColumns" : [//初始化要显示的列
                    {
                        "mDataProp" : "trainId",
                        "mRender" : function(data, type, full) {
                            return "<input type='checkbox' value='"+data+"' name='id'>"
                        }
                    },
		      {  
		          "mDataProp" : "trainId",
		         // 'sClass': "text-l"
		      },  
		      {  
		          "mDataProp" : "trainName",
		      }, 
		      {  
		    	  "mDataProp" : "trainTime",
			    	"mRender" : function formatDate(data, type, full){
			    	    var stratTime = new Date(full.trainStarttime);
			    	    var endtTime = new Date(full.trainEndtime);
			    	    var stratyear = stratTime.getFullYear(),
			    	    	stratmonth = stratTime.getMonth() + 1,//月份是从0开始的
			    	    	stratday = stratTime.getDate();
			    	    var endyear = endtTime.getFullYear(),
			    	    	endmonth = endtTime.getMonth() + 1,//月份是从0开始的
			    	    	endday = endtTime.getDate();
			    	    var newTime = stratyear + '-' +
			    	    				stratmonth + '-' +
			    	    				stratday +
			    	    				"<br/>"+
			    	    				endyear + '-' +
			    	    				endmonth + '-' +
			    	    				endday ;
			    	    return newTime;         
			    	}
		      
		      
		      
		      },
		      {
		    	  "mDataProp" : "testtime",
		    		  "mRender" : function formatDate(data, type, full){
				    	    var stratTime = new Date(full.testStarttime);//考试时间
				    	    var stratyear = stratTime.getFullYear(),
				    	    	stratmonth = stratTime.getMonth() + 1,//月份是从0开始的
				    	    	stratday = stratTime.getDate(),
				    	    	strathour = stratTime.getHours(),
				    	    	stratmin = stratTime.getMinutes(),
				    	    	stratsec = stratTime.getSeconds();
				    	    var newTime = stratyear + '-' +
				    	    				stratmonth + '-' +
				    	    				stratday +
				    	    				"<br/>"+
				    	    				strathour + ':' +
				    	    				stratmin + ':' +
				    	    				stratsec ;
				    	    return newTime;         
				    	}
		      },
		      {
		    	  "mDataProp" : "trainCreater"
		      },
		      {
		    	  "mDataProp" : "trainStatus",
		    	  "mRender" : function(data){
		    		  if(data == 2){
		    			  return "未上架"
		    		  }else if(data == 1){
		    			  return "上架"
		    		  }else if(data == 3){
		    			  return "结束"
		    		  }else{
		    			  return "异常"
		    		  }
		    	  }
		      },
		      {
		    	  "mDataProp" : "trainStatus",
		    	  
		          "mRender" : function(data, type, full) {  
		        	  var _html = '';
		        	  var timestamp = (new Date()).valueOf();
//		        	  alert(timestamp);
//		      		 上下架
		        	 if(full.trainEndtime>=timestamp){//在结束时间之前，可以上架下架
		        		 //可以上架下架
		        	  if(data == 2)
		        		  _html+='<a class="btn btn-danger-outline radius size-S" href="javascript:void(0);" onclick='+full.trainId+'"spr.lu.trainTable.opreation.updateStatus(,1)">上架</a>';
		        	  else if(data == 1){
		        		  _html+='<a class="btn btn-danger-outline radius size-S" href="javascript:void(0);" onclick='+full.trainId+'"spr.lu.trainTable.opreation.updateStatus(,2)">下架</a>';
		        	  }else{
		        	  }
		        	 }
//		        	 修改
		        	 if(full.trainEndtime>=timestamp){
		        	  	  _html+='<a class="btn btn-secondary-outline radius size-S" href="javascript:void(0);" onclick='+full.trainId+'"spr.lu.trainTable.opreation.editTrain()">修改</a>';
		        	 }
                      if(full.trainIstest == 1){
                         _html+='<a class="btn btn-secondary-outline radius size-S" href="javascript:void(0);" onclick='+full.trainId+'"spr.lu.trainTable.opreation.export()">导出</a>';
                      }
                      //		        	 删除
		              return '<a class="btn btn-danger-outline radius size-S" href="javascript:void(0);" onclick='+full.trainId+'"spr.lu.trainTable.opreation.deleteTrain()">删除</a> '+
		                     _html   
		          }  
		          
		      } ]    ,
                "fnServerData" : function(sSource, aoData, fnCallback) {
                	var trainstartTime = new Date($("#trainstartTime").val()).getTime(); //得到毫秒数
                	var trainendTime = new Date($("#trainendTime").val()).getTime();
                	if(isNaN(trainstartTime)){trainstartTime="";}
                	if(isNaN(trainendTime)){trainendTime="";}
                    aoData.push(
                        { "name": "trainName", "value": $("#trainName").val() }
                    );
                    aoData.push(
                            { "name": "trainStatus", "value": $("#trainStatus").val() }
                    );
                    aoData.push(
                    		{ "name": "trainstartTime", "value": trainstartTime }
                    );
                    aoData.push(
                    		{ "name": "trainendTime", "value": trainendTime }
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
                        console.log(1);
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
//	跳转到新增课程页面
    btn: {
        addTrain : function() {
        	alert("toADD");
        	window.location.href= "toAdd.do";
        }
    },
    opreation: {
        editMenu: function(menuId) {
            var action = 'menu/updateMenu.do';
            var data = {menuId:menuId};
            base.AJAX_POST(action, data, 'html',
                    function(html) {
            	var data = new Array();
            	data.push("userAccount");
                data.push("menuName");
                data.push("menuParentId");
                data.push("menuUrl");
                data.push("menuOrder");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"修改菜单",'edit.do',data,"form-lu-add");
            });
        },
//     更新课程状态
        updateStatus: function(trainId, status) {
            bootbox.dialog({
                message: "确定对该课程进行该操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../lu/updateTrainStatus.do',
                                data: {
                                	trainId: trainId,
                                    status: status
                                },
                                success: function(data) {
                                    if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        //spr.menu.comFn.toMenuTable(1);

                                    } else if ("true" == data) {
                                        bootbox.alert("操作成功");
                                        $(".table-sort").dataTable().fnDraw(false);
                                    }
                                }
                            });
                        }
                    },
                    Cancel: {
                        label: "取消",
                        className: "btn-default",
                        callback: function() {}
                    }
                }
            });
        },
        deleteTrain: function(trainId) {
            bootbox.dialog({
                message: "确定对该菜单进行该操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../lu/del.do',
                                data: {
                                    trainId: trainId
                                },
                                success: function(data) {
                                    if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        //spr.menu.comFn.toMenuTable(1);

                                    } else if ("true" == data) {
                                        bootbox.alert("操作成功");
                                        $(".table-sort").dataTable().fnDraw(false);
                                    }
                                }
                            });
                        }
                    },
                    Cancel: {
                        label: "取消",
                        className: "btn-default",
                        callback: function() {}
                    }
                }
            });
        },
        export: function(trainId) {
            var action = "export.do";
            var $eleForm = $("<form method='get'></form>");
            $eleForm.append("<input name='trainId' value='"+trainId + "' />")
            $eleForm.attr("action",action);
            $(document.body).append($eleForm);
            //提交表单，实现下载
            $eleForm.submit();
        },
    }
};


