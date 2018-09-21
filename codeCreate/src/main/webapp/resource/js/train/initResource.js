spr.train.initrecources = {
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
				"sAjaxSource" : "ResourcesTable.do",
				"bProcessing": true, //开启读取服务器数据时显示正在加载中
				"bFilter" : false, //搜索栏
				"bScrollCollapse" : true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
				"aoColumns" : [//初始化要显示的列
	                    {
	                        "mDataProp" : "trainId",
	                        "mRender" : function(data, type, full) {
	                            return "<input type='checkbox' name='resourceId' value='"+data+"' name='id'>";
	                        }
	                    },
				      {  
				          "mDataProp" : "resId"
				      },  
				      {  
				          "mDataProp" : "resName"
				      }
			      
			      ]    ,
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
				   
				],
				createdRow: function (row, data, index) { // 初始化行时 可对数据进行过滤
			      $(row).addClass('text-c');
			    }
			}); 
		}
	};