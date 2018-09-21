var spr = spr || {};
spr.role = spr.role || {};

spr.role.roleTable = {
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
			"ordering":false, //设置所有列不排序
			"aLengthMenu" : [ 5, 10, 15 ], //分页工具条页数设置
			"bPaginate": true,  //分页工具条显示
			"bStateSave": true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
			"pading":true,
			"sPaginationType" : "full_numbers", //分页
			"bServerSide" : true,  //服务器处理分页  服务器端分页必须设置
			"bAutoWidth": true, // 是否自动宽度
			/* "sAjaxDataProp": "aaData", */ //是服务器分页的标志 默认aaData
			"sAjaxSource" : "roleTable.do",
			"bProcessing": true, //开启读取服务器数据时显示正在加载中
			"bFilter" : false, //搜索栏
			"bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
			"aoColumns" : [//初始化要显示的列  
		            {  
		            	"mDataProp" : "roleId",
		                "mRender" : function(data, type, full) {  
		                    return "<input type='checkbox' value='"+data+"' name='roleIds'>"  
		                }
		            }, 
		      {  
		          "mDataProp" : "roleId"//获取列数据，跟服务器返回字段一致  
		      },  
		      {  
		          "mDataProp" : "roleName",
		          'sClass': "text-l"
		      },  
		      {  
		          "mDataProp" : "roleStatus",
		          "mRender" : function(data, type, full) {  
		        	  var _html = '';
		        	  if(data == 1)
		        		  _html ='启用';
		        		  else
		        			  _html='停用';
		              return _html   
		          }
		      }, 
		      {  
		          "mDataProp" : "roleCreateName"
		      },  
		      {  
		          "mDataProp" : "createTime"
		      },  
		      {  
		          "mDataProp" : "roleId",  
		          "mRender" : function(data, type, full) {  
		        	  var _html = '';
		        	  if(full.roleStatus == 1)
		        		  _html+='<a class="btn btn-danger-outline radius size-S" href="javascript:void(0);" onclick="spr.role.roleTable.opreation.updateRoleStatus('+data+',2)">停用</a>';
		        		  else
		        			  _html+='<a class="btn btn-success-outline radius size-S" href="javascript:void(0);" onclick="spr.role.roleTable.opreation.updateRoleStatus('+data+',1)">启用</a>';
		              return '<a class="btn btn-primary-outline radius size-S" href="javascript:void(0);" onclick="spr.role.roleTable.btn.addRole('+data+')">编辑角色</a> ' + 
		                     _html   
		          }  
		      } ]    , 
		      "fnServerData" : function(sSource, aoData, fnCallback) {
		    	  aoData.push(
		                  { "name": "roleName", "value": $.trim($("#roleName").val()) },
		                  { "name": "roleStatus", "value": $.trim($("#roleStatus").val()) }
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
    btn: {
    	addRole: function(id) {
            var action = "role/getRoleList.do";
            base.AJAX_POST(action, {id:id}, 'html',
                    function(html) {
            	var data = new Array();
            	data.push("roleId");
            	data.push("roleName");
            	data.push("menuIds");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"添加角色",'saveRole.do',data,"form-role-add");
            });
        }		,
		delRole: function() {
		    var action = "del.do";
		    var ids = new Array();
		    $("[name=roleIds]:checked").each(function(e){ids.push($(this).val())});
		    if(ids.length==0){
		    	bootbox.alert("请选择要删除的角色");
		    	return;
		    }
		    bootbox.dialog({
		        message: "确定删除选中角色？",
		        title: "提示信息",
		        buttons: {
		            OK: {
		                label: "确定",
		                className: "btn-primary",
		                callback: function() {
		                    $.ajax({
		                        url: action,
		                        data: {
		                        	ids: ids.join(",")
		                        },
		                        success: function(data) {
		                            if ("true" == data) {
		                                bootbox.alert("操作成功");
		                                $(".table-sort").dataTable().fnDraw(false);
		                            }else{
		                            	bootbox.alert("操作失败");
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
    },
    opreation: {
        updateRoleStatus:function(roleId,status)
    	{
    		bootbox.dialog({
    			message : "确定对该角色进行该操作？",
    			title : "提示信息",
    			buttons : {
    				OK : {
    					label : "确定",
    					className : "btn-primary",
    					callback : function() {
    						$.ajax({
    							url : '../role/updateRoleStatus.do',
    							data : {
    								roleId :roleId,
    								status : status
    							},
    							success : function(data) {
    								if ("error" == data) {
    									bootbox.alert('此角色不可进行该操作');
    								} else if ("false" == data) {
    									bootbox.alert("操作失败");
    									$(".table-sort").dataTable().fnDraw(false);

    								} else if ("true" == data) {
    									bootbox.alert("操作成功");
    									$(".table-sort").dataTable().fnDraw(false);;
    								}
    							}
    						});
    					}
    				},

    				Cancel : {
    					label : "取消",
    					className : "btn-default",
    					callback : function() {

    					}
    				}
    			}
    		});
    	},
    }
};