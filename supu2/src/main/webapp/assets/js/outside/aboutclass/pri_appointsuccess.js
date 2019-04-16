$(function(){
//	 //给time赋值
//	  $('.nodis').click(function(){
//		  $('#time').val($(this).data("time"));
//	  });
//	  //给date赋值
//	  $('.clickli').click(function(){
//		  $('#appointtime').val($(this).data("date"));
//	  });
//	  //给storeid赋值
//	  $('.divStoreid').click(function(){
//		  $('#storeid').val($(this).data("storeid"));
//	  });
	  //提交表单
	  $('#cancelAppoint').click(function(){
			$.ajax({
			      type:"GET",
			     // data:$('#form').serialize(),
			      url:baseUrl+'/outside/aboutClass/cancelAppointCourse?id='+$(this).data('id')+'',
			      success:function(data){
			    	  if (data.resultCode==200) {
			    		 /* 	$('#successMassage').text("");
							$('#successMassage').text("取消成功");*/
							$('.successmask').show();
							$('#alertSuccess').show();
							//return false;
			    	  }else if(data.resultCode==400){
				    		$('#errorMassage').text("");
							$('#errorMassage').text(data.message);
							$('.failmask').show();
							$('#alertFail').show();
						//	return false;
			    	  }
			      }
			});
	  });


//	  /**
//	   * 错误提示框  点击确定或者取消后   隐藏起来
//	   */
//	  $('.btn_div').click(function(){
//		  	$('.failmask').hide();
//		  	$('#alertFail').hide();
//	  });
//	  /**
//	   * 选择上课时间后关闭
//	   */
//	  $('.classTime').click(function(){
//		  $('#div_classTime').hide();
//
//	  });
//
//	  /**
//	   * 选择上课场地后关闭
//	   */
//	  $('.classPlace').click(function(){
//		  $('#div_classPlace').hide();
//
//	  });

//	  $('#form').submit();
	  /**
	   * 成共提示框  点击确定或者取消后   隐藏起来
	   */
	  $('.successhide').click(function(){
			$('.successmask').hide();
			$('#alertSuccess').hide();

			$('.failmask').hide();
			$('#alertFail').hide();
			window.location=baseUrl+'/outside/aboutClass/privatePage';
	  });

});



