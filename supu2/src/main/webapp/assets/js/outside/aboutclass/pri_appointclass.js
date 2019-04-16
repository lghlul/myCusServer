$(function(){
	 //给time赋值
	  $('.nodis').click(function(){
		  $('#time').val($(this).data("time"));
		  $('#count').val($(this).data("count"));
	  });
	  //给date赋值
	  $('.clickli').click(function(){
		  $('#appointtime').val($(this).data("date"));
	  });
	  //给storeid赋值
	  $('.divStoreid').click(function(){
		  $('#storeid').val($(this).data("storeid"));
		  $('#storename').val($(this).data("name"));
	  });
	  //提交表单
	  $('#submitdiv').click(function(){
		//  alert("submitdiv");
		  if($('#count').val()>3){
			  layer.open({
					content: '该教练本时间段预约已满'
				    ,skin: 'msg'
			        ,time: 3 //2秒后自动关闭

			   });
			  return false;
		  }
		  if ($('#storeid').val()=="") {
				$('#errorMassage').text("");
				$('#errorMassage').text('请选择上课场地');
				$('.failmask').show();
				$('#alertFail').show();
			  return false;
		  }
		  if ($('#time').val()=="") {
				$('#errorMassage').text("");
				$('#errorMassage').text('请选择开始上课时间');
				$('.failmask').show();
				$('#alertFail').show();
			  return false;
		  }
			$.ajax({
			      type:"POST",
			      data:$('#form').serialize(),
			      url:baseUrl+'/outside/personal/doappointCourse',
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
								$('#appointid').val(data.records);
				    	  }else if(data.resultCode==400){
					    		 if (data.message==1) {
					    			$('#errorMassage').text("");
					    			$('.failmask').show();
									$('#errorMassage').text('您已经预约！');
									$('#alertFail').show();
								}else if(data.message==5){
					    			$('#errorMassage').text("");
					    			$('.failmask').show();
									$('#errorMassage').text('您的预约次数超过购买次数！');
									$('#alertFail').show();
								}
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
		  $('#clickTime').text($('#appointtime').val()+" "+$('#time').val());

	  });

	  /**
	   * 选择上课场地后关闭
	   */
	  $('.classPlace').click(function(){
		  $('#div_classPlace').hide();
		  $('#clickdiv').text($('#storename').val());

	  });

	  /**
	   * 成功提示框  点击确定或者取消后   隐藏起来
	   */
	  $('.btn_success').click(function(){
		  	$('.successmask').hide();
		  	$('#alertSuccess').hide();
		  	$('#form').submit();

	  });

//	  $('#form').submit();
});



