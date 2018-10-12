var spr = spr || {};
spr.org = spr.org || {};

spr.org.orgTable = {
	init : function() {
		// 搜索
		$('.btn-success').on('click', function() {
			$(".table-sort").dataTable().fnDraw(false);
		});

		// 初始化数据
		var table_sort = $('.table-sort').dataTable({
			/* "aaSorting": [[ 1, "desc" ]],//默认第几个排序 */
			"ordering" : false, // 设置所有列不排序
			"aLengthMenu" : [ 10], // 分页工具条页数设置
			"bPaginate" : true, // 分页工具条显示
			"bStateSave" : true, // 是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态
			"pading" : true,
			"sPaginationType" : "full_numbers", // 分页
			"bServerSide" : true, // 服务器处理分页 服务器端分页必须设置
			"bAutoWidth" : true, // 是否自动宽度
			/* "sAjaxDataProp": "aaData", */// 是服务器分页的标志
			// 默认aaData
			"sAjaxSource" : "orgTable.do",
			"bProcessing" : true, // 开启读取服务器数据时显示正在加载中
			"bFilter" : false, // 搜索栏
			"bScrollCollapse" : true, // 是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
			"aoColumns" : [// 初始化要显示的列
			{
				"mDataProp" : "empid"// 获取列数据，跟服务器返回字段一致
			},
			{
				"mDataProp" : "empname",
			},
			{
				"mDataProp" : "empid",
				"mRender" : function(data, type, full) {
					if(full.roleName == null || full.roleName == ""){
						return '<resource class="btn btn-primary-outline radius size-S" href="javascript:void(0);" onclick="spr.org.orgTable.opreation.addRole(\''+data+'\')">设为管理员</resource> ';
					}else{
						return full.roleName;
					}
				}
			} ],
			"fnServerData" : function(sSource, aoData,fnCallback) {
				aoData.push(
						{"name" : "empid","value" : $.trim($("#empid").val())},
						{"name" : "empname","value" : $.trim($("#empname").val())},
						{"name" : "orgid","value" : $.trim($("#orgid").val())});
						$.ajax({
							"type" : 'post',
							"url" : sSource,
							"dataType" : "json",
							"data" : aoData,
							"success" : function(resp) {
								$("#orgid").val("");
								// 总页数
								$('.totalNum').html(
								resp.iTotalDisplayRecords);
								fnCallback(resp); // 服务器端返回的对象的returnObject部分是要求的格式
								// 表格自适应样式设置
								$('.table-sort').css("width", "100%");
							},
							error : function(resp) {
								console.log(1);
										// fnCallback(resp.responseText);
							}
						});
					},
			"aoColumnDefs" : [// 用来设置列一些特殊列的属性
			],
			createdRow: function (row, data, index) { // 初始化行时 可对数据进行过滤
				  $(row).addClass('text-c');
				  }	
			});
		},
	opreation : {
		addRole : function(empid) {
			var action = "/org/addRole.do";
			base.AJAX_POST(action, {empid : empid}, 'html',
					function(html) {
				var data = new Array();
				data.push("roleIds");
				data.push("empid");
				data.push("empname");
				// 参数：返回的html，弹出框标题，form表单路径，参数名（需和input id一致），form表单ID
				base.dialog(html, "添加管理员", 'saveRole.do', data,"form-org-addRole");
			});
		}
	}
};