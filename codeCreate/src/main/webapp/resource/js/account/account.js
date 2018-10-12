var spr = spr || {};
spr.account = spr.account || {};

spr.account.userTable = {
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
		$('#searchBtn').on( 'click', function() { 
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
			"sAjaxSource" : "userTable.do",
			"bProcessing": true, //开启读取服务器数据时显示正在加载中
			"bFilter" : false, //搜索栏
			"bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
			"aoColumns" : [//初始化要显示的列  
		            {  
		            	"mDataProp" : "userId",
		                "mRender" : function(data, type, full) {  
		                    return "<input type='checkbox' value='"+data+"' name='userIds'>"  
		                }
		            }, 
		      {  
		          "mDataProp" : "userId"//获取列数据，跟服务器返回字段一致  
		      },  
		      {  
		          "mDataProp" : "userAccount"
		      },  
		      {  
		          "mDataProp" : "userName"  
		      }, 
		      {  
	            	"mDataProp" : "userRoleId",
	                "mRender" : function(data, type, full) {  
	                    return $("#roleId option[value="+data+"]").html();
	                }
	            }, 
	            {  
	            	"mDataProp" : "userStatus",
	                "mRender" : function(data, type, full) { 
	                	if(data == 1){
	                		return "启用";
	                	}
	                	return "停用";
	                	
	                }
	            }, 
	            {  
	            	"mDataProp" : "userCreateName"
  	            }, 
	            {  
	            	"mDataProp" : "createTime"
	            }, 
		      {  
		          "mDataProp" : "userId",  
		          "mRender" : function(data, type, full) {  
		        	  var _html = '';
		        	  if(full.userStatus == 1)
		        		  _html+='<resource class="btn btn-danger-outline radius " href="javascript:void(0);" onclick="spr.account.userTable.opreation.updateStatus('+data+',0)">停用</resource>';
		        		  else
		        			  _html+='<resource class="btn btn-success-outline radius " href="javascript:void(0);" onclick="spr.account.userTable.opreation.updateStatus('+data+',1)">启用</resource>';
		              return '<resource class="btn btn-secondary-outline radius " href="javascript:void(0);" onclick="spr.account.userTable.opreation.resetPass('+data+')">重置密码</resource> '+ 
		                     '<resource class="btn btn-secondary-outline radius " href="javascript:void(0);" onclick="spr.account.userTable.opreation.editPass('+data+')">修改密码</resource> '+ 
		                     '<resource class="btn btn-primary-outline radius " href="javascript:void(0);" onclick="spr.account.userTable.opreation.updateRole('+data+')">分配角色</resource> ' + 
		                     '<resource class="btn btn-danger-outline radius " href="javascript:void(0);" onclick="spr.account.userTable.btn.delUser('+data+')">删除</resource> ' + 
		                     _html   
		          }  
		      } ]    , 
		      "fnServerData" : function(sSource, aoData, fnCallback) {
		    	  aoData.push(
		                  { "name": "nike", "value": $.trim($("#nikename").val()) },
		                  { "name": "roleId", "value": $.trim($("#roleId").val()) },
		                  { "name": "userStatus", "value": $.trim($("#userStatus").val()) }
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
			  /* {"bVisible": false, "aTargets": [ 3 ]}, //控制列的隐藏显示 */
			  {"orderable":false,"aTargets":[0,4]}// 不参与排序的列
			],
			createdRow: function (row, data, index) { // 初始化行时 可对数据进行过滤
		      $(row).addClass('text-c');
		    }
		}); 
	},
    btn: {
        addUser: function() {
            var action = "account/addUser.do";
            base.AJAX_POST(action, {}, 'html',
                    function(html) {
            	var data = new Array();
            	data.push("userPassword");
            	data.push("userName");
            	data.push("userAccount");
            	data.push("userRoleId");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"添加用户",'saveUser.do',data,"form-account-add");
            });
        },
		delUser: function(id) {
		    var action = "del.do";
		    bootbox.dialog({
		        message: "确定删除此管理员？",
		        title: "提示信息",
		        buttons: {
		            OK: {
		                label: "确定",
		                className: "btn-primary",
		                callback: function() {
		                    $.ajax({
		                        url: action,
		                        data: {
		                        	id: id
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
        editPass: function(id) {
            var action = 'updatePwd.do';
            var data = {id:id};
            base.AJAX_POST(action, data, 'html',
                    function(html) {
            	var data = new Array();
            	data.push("userId");
            	data.push("oldPass");
            	data.push("newPass");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"修改密码",'../savePwd.do',data,"form-update-password");
            });
        },
        updateRole: function(id) {
            var action = 'account/updateRole.do';
            var data = {id:id};
            base.AJAX_POST(action, data, 'html',
                    function(html) {
            	var data = new Array();
            	data.push("roleIds");
            	data.push("userId");
            	data.push("userAccount");
            	//参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
            	base.dialog(html,"分配角色",'update.do',data,"form-role-update");
            });
        },
        resetPass:function(id){
            bootbox.dialog({
                message: "确定对该用户进行重置密码操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../account/updateUserPwd.do',
                                data: {
                                    userId: id
                                },
                                success: function(data) {
                                    if ("error" == data) {
                                        bootbox.alert('此用户不可进行该操作');
                                    } else if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        spr.account.comFn.toUserTable(1);

                                    } else if ("true" == data) {
                                        bootbox.alert("操作成功");
                                        //spr.account.comFn.toUserTable(1);
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
        
        updateStatus: function(userId, status) {
            bootbox.dialog({
                message: "确定对该用户进行该操作？",
                title: "提示信息",
                buttons: {
                    OK: {
                        label: "确定",
                        className: "btn-primary",
                        callback: function() {
                            $.ajax({
                                url: '../account/updateUserStatus.do',
                                data: {
                                    userId: userId,
                                    status: status
                                },
                                success: function(data) {
                                    if ("error" == data) {
                                        bootbox.alert('此用户不可进行该操作');
                                    } else if ("false" == data) {
                                        bootbox.alert("操作失败");
                                        spr.account.comFn.toUserTable(1);

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
};