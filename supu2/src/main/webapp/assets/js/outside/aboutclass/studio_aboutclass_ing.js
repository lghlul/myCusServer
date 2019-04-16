$(function(){
/*	 //给time赋值
	  $('.nodis').click(function(){
		  $('#time').val($(this).data("time"));
	  });
	  //给date赋值
	  $('.clickli').click(function(){
		  $('#appointtime').val($(this).data("date"));
	  });
	  //给storeid赋值
	  $('.divStoreid').click(function(){
		  $('#storeid').val($(this).data("storeid"));
		  $('#storename').val($(this).data("name"));
	  });*/
	  //提交表单
	  var result=true;
	  $('#submitdiv').click(function(){
		  $(".starttime").each(function(){
			  if ($(this).val()!='') {
				result=false;
			  }
		  });
		  if (result) {
				$('#errorMassage').text("");
				$('#errorMassage').text('请选择上课时间');
				$('.failmask').show();
				$('#alertFail').show();
				return false;
		  }
			$.ajax({
			      type:"POST",
			      data:$('#form').serialize(),
			      url:baseUrl+'/outside/personal/doAppointStudio',
			      success:function(data, textStatus, request){

			    	  if (request.getResponseHeader('sessionstatus')=="unlogin") {
			    		  window.location=baseUrl+"/outside/login";
			    	  }else{
			    		  console.log("data.resultCode="+data.resultCode);
				    	  if (data.resultCode==200) {
				    		  	$('#successMassage').text("");
				    		  	$('.successmask').show();
								$('#successMassage').text('预约成功');
								$('#alertSuccess').show();
				    	  }else if(data.resultCode==400){
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
	   * 错误提示框  点击确定或者取消后   隐藏起来
	   */
	  $('.btn_div').click(function(){
		  	$('.failmask').hide();
		  	$('#alertFail').hide();

	  });
	  /**
	   * 选择上课时间后关闭
	   */
	  $('.classTime').click(function(){
		  $('#div_classTime').hide();
		  $('#clickTime').text("请选择");
		  $(".starttime").each(function(){
			  if ($(this).val()!='') {
				  $('#clickTime').text($('#appointtime').val()+" "+$(this).val()+"~"+$(this).data("endtime"));
				  return false;
			  }
		  });
	  });

	  /**
	   * 选择上课场地后关闭
	   */
/*	  $('.classPlace').click(function(){
		  $('#div_classPlace').hide();
		  $('#clickdiv').text($('#storename').val());

	  });*/

	  /**
	   * 成功提示框  点击确定或者取消后   隐藏起来
	   */
	  $('.btn_success').click(function(){
		  	$('.successmask').hide();
		  	$('#alertSuccess').hide();
		  	$('#form').submit();
/*		  	window.location.href=baseUrl+'/outside/aboutClass/appointStudioSuccess';
		  	$("#dataTime").empty();
			$.ajax({
			      type:"POST",
			      data:$('#form').serialize(),
			      url:baseUrl+'/outside/aboutClass/AppointStudioData',
			      success:function(data){
			    	  if (data.resultCode==200) {
//			    		  conlose.log(data.records);
			    		  var recordlist=data.records;
			    		  if (data.records.length>0) {
			    			  for ( var i = 0; i < recordlist.length; i++) {
			    				  $("#dataTime").append(
			    						''+moment(recordlist[i].appointtime).format('YYYY-MM-DD')+'&nbsp;&nbsp;'+recordlist[i].starttime+'~'+recordlist[i].endtime+''
			    				  );
							}
						}

			    	  }
			      }
			});*/

	  });

//	  $('#form').submit();
});



