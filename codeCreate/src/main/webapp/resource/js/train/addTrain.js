spr.train.addTrain = {
		init:function(){},
//删除考试人员列表
	    btn: {
	        removeTr: function(obj) {
	        	var di = $(obj).parent().parent().remove();
	        } ,
//JS 提交课程数据	        
	       saTrain: function() {
	    	   alert("-");
//	    	   $("#tbody").find("tr")//所有tr
	    	   
//	    	   var id = $("#tbody").find("td").eq(0).text();
//	    	   var vale = $("#tbody").find("td").find("input").eq(0).val();
//	    	   var size = $("#tbody").find("tr").size();
//	    	   var map = new Object();
//	    	   $("#tbody").find("tr").find("td").eq(2).find("input").eq(0).val();
	    	   
	    	   var map = new Object();
	    	   $("#tbody").find("tr").each(function (i) {
	    		   $(this).find("td").eq(0).text();
	    		   map[$(this).find("td").eq(0).text()]= $(this).find("td").eq(2).find("input").eq(0).val();
	    		});
	    	   
	    	   
	            $.ajax({
                    url: "saveTrain.do",
                    type:"POST",
                    data: {
                   	 "trainId" : $("#trainId").val(),
                   	 "trainName": $("#trainName").val(),
                   	 "trainInfo" : $("#trainInfo").val(),
                   	 "trainIstest" : $("#trainIstest").val(),
                   	 "trainStarttime" : new Date($("#trainStarttime").val()).getTime(),
                   	 "trainEndtime" : new Date($("#trainEndttime").val()).getTime(),
                   	 "testInfo" : $("#testInfo").val(),
                   	 "testStarttime" : new Date($("#testStarttime").val()).getTime(),
                   	 "testEndtime" : new Date($("#testEndtime").val()).getTime(),
                   	 "trainCreater" : $("#trainStatus").val(),
                   	 "trainCreattime" : $("#trainCreattime").val(),
                   	 "trainStatus" : $("#trainStatus").val(),
                   	 "orgId" : $("#orgId").val(),
                   	 "testName" : $("#testName").val(),
//                   	 "ResIDs" : window.localStorage.getItem("res_str_ID"),//资源的ID字符串
                   	 "studentIdStr" :  window.localStorage.getItem("studentIdStr"),//参与考试的人员的ID字符串
                   	 "resId" : $("#resId").val(),//资源ID
                   	 "testMark" : $("#testMark").val(),//考试及格线
//                   	var map2json=JSON.stringify(map);
//                   	 "resmap" : window.localStorage.getItem("resmap")//学习资源的Map
                   	 "resmap" : JSON.stringify(map)
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
	            alert("-//");
	    		 window.localStorage.removeItem("res_ID");
	    		 window.localStorage.removeItem("studentIdStr");
//	    		 window.localStorage.removeItem("resmap");
	        } 
	    },
	    opreation: {
	        
	    }
	};

$(document).ready(function(){
	//是否考试开关的点击事件
	$('.test-switch').on('switch-change', function (e, data) {
	    //返回 是否开启的值
	    if(data.value)
	    	$("#trainIstestDiv").show(1000);
	    else
	    	$("#trainIstestDiv").hide(1000);
	});
//	有无考试
//  $("#haveTest").click(function(){//有考试code设置为1
//	  $("#trainIstest").val("1");
//	  $("#trainIstestDiv").show();//显示DOM
//	  alert($("#trainIstest").val());
	  
	  
//  });
//  $("#noneTest").click(function(){//没有考试code设置为2
//	  $("#trainIstest").val("2");
//	  $("#trainIstestDiv").hide();
//	  $("#trainIstestDiv").empty();//没有考试删除DOM
//	  alert($("#trainIstest").val());
	  
//  });
  
  //考试文件上传
  $("#files_button").click(function(){//没有考试code设置为2
	  alert("文件上传");
	  var formData = new FormData();
      formData.append("files",document.getElementById("files").files[0]);   //document.getElementById("form-lu-add").files[1]
      formData.append("trainId",$("#trainId").val());
      alert("trainId--"+$("#trainId").val());
	  $.ajax({
		    url: '../account/excel.do',
		    type: 'POST',
		    cache: false,
		    data: formData,
		    processData: false,
		    contentType: false
		}).done(function(res) {
			var ob = JSON.parse(res);
			$("#resId").val(ob.msgs.idCode);
		}).fail(function(res) {
			alert("失败"+ob.msgs.code);
		});
  });
  
  //学习资料
  $("#haveResources").click(function(){
	// 学习资料的弹出框
	  var action = "lu/resourceList.do";
	  base.AJAX_POST(action, {}, 'html',
	          function(html) {
	  	bootbox.dialog({
	  	    message: html,
	  	    title: "选择资源",
	  	    className:"dialog-width",
	  	    buttons: {
	  	        OK: {
	  	            label: "确定",
	  	            className: "btn-primary",
	  	            callback: function() {
	  	            	var map = new Object();
		  	            $.each($('#resources_table input[name=resourceId]:checkbox'),function(){
		  	                if(this.checked){
	//	  	              	  alert($(this).parent().next().next().val());
	//	  	              	  拼接ID的字符串
	//	  	              	  var resource = $(this).parent().next().text()+",";
	//	  	              	  res_str_ID = res_str_ID + resource;
		  	      //写入数据到Add页面-添加删除按钮-添加时间输入框按钮
		  	                    $("#tbody").append("<tr class='text-c'><td width='20%'>"
		  	                    		+$(this).parent().next().text()+"</td><td width='20%'>"+
		  	                    		$(this).parent().next().next().text()+"</td><td><input type='text' class='input-text' value='' placeholder='此资源学习时间(分钟)' id='testMark' name='testMark'></td><td  width='20%'><resource href='#' onclick='spr.lu.addTrain.btn.removeTr(this)'>删除</resource></td></tr>");
	//	  	               学习资料的资源ID-和资源的学习时间组成一个MAP传递
	//	  	                    map[$(this).parent().next().text()]=$(this).parent().next().next().children().val();
		  	                }
		  	            });
	//	  	            window.localStorage.setItem("resmap",JSON.stringify(map));
	  	            }
	  	        },
	  	        Cancel: {
	  	            label: "取消",
	  	            className: "btn-default",
	  	            callback: function() {}
	  	        }
	  	    }
	  });
	  });
  });
  
  
//添加考试人员
  $("#checkbox").click(function(){
	// 学习资料的弹出框
	  var action = "lu/checkbox.do";
	  base.AJAX_POST(action, {}, 'html',
	          function(html) {
	  	bootbox.dialog({
	  	    message: html,
	  	    title: "选择考试人员",
	  	    className:"dialog-width",
	  	    buttons: {
	  	        OK: {
	  	            label: "确定",
	  	            className: "btn-primary",
	  	            callback: function() {
	  	            	alert("选择人员");
		  	        	  var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		  	        	  var nodes = zTree.getCheckedNodes(true);
		  	        	  var personstr = "";
		  	        	  nodes.forEach(function(item){//for循环中向add页面添加考试人员名单
		  	        		  personstr+=item.id+",";
	//	  	        		  在add页面添加考试人员信息
		  	        		  $("#pbody").append("<tr class='text-c'><td width='20%'>"+item.id+"</td><td width='20%'>"+item.id+"</td><td  width='20%'><resource href='#' onclick='spr.lu.addTrain.btn.removeTr(this)'>删除</resource></td></tr>");
		  	        	  });
	//	  	        	  考试人员加入缓存
		  	        	  window.localStorage.setItem("studentIdStr",personstr);
		  	        	  alert(personstr);
		  	        	  console.log(nodes); 
	  	            }
	  	        },
	  	        Cancel: {
	  	            label: "取消",
	  	            className: "btn-default",
	  	            callback: function() {}
	  	        }
	  	    }
	  });
	  });
  });
  
  
  
//  
//  //删除DOM--没有考试
//  $("#haveTest").empty(function(){
//	  $("#trainIstestDiv").remove();
//  });
//  
//  //添加DOM--有考试
//  $("#noneTest").empty(function(){
//	  $("#trainIstestDiv").remove();
//  });
//  
//  var myName=session.getAttribute("trainId"); 
//  alert(myName);
  
  
//  var trainId=session.getAttribute('trainId'); 
//  alert(trainId);
//  alert("--");
//  alert("<%=session.getAttribute('trainId') %>");
  
//	选择判断
//  $("#resource").click(function(){
//	  alert("选择判断");
//	  
//	  
//  });
//  $("#re").click(function(){
//	  alert("=========");
//	  	$("[name='re'][checked]").each(function(){
////		     str+=$(this).val()+"n";
//		     alert(str+"--")
//		})
//  });
//  

  
  var res_str_ID = "";
//  选取资源列表中的数据
//  $("body").on("click","#re",function(){
//
//
//  });
  
  
//  提交考试人员
//  $("#person").click(function(){
//	  
//	  
//  });
  
  
  
});


