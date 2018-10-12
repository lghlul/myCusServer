var spr = spr || {};
spr.testpaper = spr.testpaper || {};

spr.testpaper.testpaperTable = {
	init:function() {
		//搜索
		$('#searchBtn').on( 'click', function() { 
			$(".table-sort").dataTable().fnDraw(false);
	    });
		
		//初始化数据
		var table_sort =  $('.table-sort').dataTable({
			"aLengthMenu": [ 5, 10, 15 ], //分页工具条页数设置
			"bPaginate": true,  //分页工具条显示
			"bStateSave": true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
			"pading":true,
			"sPaginationType": "full_numbers", //分页
			"bServerSide": true,  //服务器处理分页  服务器端分页必须设置
			"bAutoWidth": true, // 是否自动宽度
			"sAjaxSource": "testPaperTable.do",
			"bProcessing": true, //开启读取服务器数据时显示正在加载中
			"bFilter": false, //搜索栏
			"bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
			"aoColumns": [//初始化要显示的列
				{
				    "mDataProp" : "acId"//获取列数据，跟服务器返回字段一致
				},{
                    "mDataProp" : "userId"
				},{
                    "mDataProp" : "testName"
				},{
                    "mDataProp" : "testTime"
				},{
                    "mDataProp" : "handTimeStr"
				},{
                    "mDataProp" : "score"
				},{
                    "mDataProp" : "testStatus",
                    "mRender": function (data) {
                    	if(data == 2){
	  		        		  return "未批阅";
	  		        	  }else if(data == 3){
	  		        		  return "待审核";
	  		        	  }else if(data == 4){
	  		        		  return "已审核";
	  		        	  }
                    }
				},{  
			          "mDataProp" : "acId",  
			          "mRender" : function(data) {  
			        	  var _html = '';
			              return '<resource class="btn btn-secondary-outline radius size-S" href="javascript:void(0);" onclick="spr.activity.activityTable.opreation.editActivity('+data+')">编辑</resource> '+
			                     '<resource class="btn btn-danger-outline radius size-S" href="javascript:void(0);" onclick="spr.activity.activityTable.opreation.deleteActivity('+data+')">删除</resource> '+
			                     _html 
			          }  
			      }
			],
			"fnServerData" : function(sSource, aoData, fnCallback) {
				aoData.push(
						{ "name": "testName", "value": $("#testName").val() },
						{ "name": "userName", "value": $("#userName").val() },
						{ "name": "testStatus", "value": $("#testStatus").val() }
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
			},
			"aoColumnDefs": [//用来设置列一些特殊列的属性
				{"gradingTestTable":false,"aTargets":[0,4]}// 不参与排序的列
			],
			createdRow: function (row) { // 初始化行时 可对数据进行过滤
				$(row).addClass('text-c');
			}
		});
	},
	btn: {
		toAdd: function() {
            var action = "activity/addActivity.do";
            base.AJAX_POST(action, {}, 'html',
                    function(html) {
            	var data = new Array();
            	data.push("infoTitle");
            	data.push("infoSort");
            	data.push("classType");
            	data.push("infoImgUrl");
            	data.push("infoIntroduct");
            	data.push("infoContent");
            	data.push("infoStartTime");
            	data.push("infoEndTime");
            	data.push("abortTime");
            	data.push("infoPrice");
            	data.push("infoAddress");
            	data.push("area");
            	data.push("longitude");
            	data.push("latitude");
            	data.push("formId");
            	data.push("infoQuotaListStr");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"添加活动",'saveActivity.do',data,"form-activity-add");
            });
        }
    },
	opreation: {
		editActivity: function(infoId) {
            var action = 'activity/editActivity.do';
            var data = {infoId:infoId};
            base.AJAX_POST(action, data, 'html', function(html) {
            	var data = new Array();
            	data.push("infoId");
            	data.push("infoTitle");
            	data.push("infoSort");
            	data.push("classType");
            	data.push("infoImgUrl");
            	data.push("infoIntroduct");
            	data.push("infoContent");
            	data.push("infoStartTime");
            	data.push("infoEndTime");
            	data.push("abortTime");
            	data.push("infoPrice");
            	data.push("infoAddress");
            	data.push("area");
            	data.push("longitude");
            	data.push("latitude");
            	data.push("formId");
            	data.push("infoQuotaListStr");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"编辑活动",'updateActivity.do',data,"form-activity-edit");
            });
        },detail: function(infoId) {
            var url = 'detail.do?infoId='+infoId;
            var index = layer.open({
    			type: 2,
    			title: "报名详情",
    			content: url,
    			shadeClose: true,
    			scrollbar: false
    		});
    		layer.full(index);
        },
        deleteActivity: function(infoId) {
            bootbox.dialog({
                message: "确定删除该活动？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../activity/deleteActivity.do',
                                data: {
                                	infoId: infoId,
                                },
                                success: function(data) {
                                    if ("false" == data) {
                                        bootbox.alert("操作失败");
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
        }
	}
}
