$(function(){

	//用来获取取消预约的主键id
//	var id=null;
	/**
	 * 取消预约
	 */
	$('.cancelAppoint').click(function(){
		$('.sure').show();
		$('#alertSure').show();

		//获取该预约id
		var id=$(this).next(":hidden").val();

		 //将id赋值到弹出框里，
		 $('#cancelAppointId').val(id);

	/*	$('.failmask').show();
		$('#alertFail').show();*/
			/*if(result) {
				var id=$(this).next(":hidden").val();
				 $.ajax({
			   	      type:"POST",
			   	      url:baseUrl+'/outside/aboutClass/cancelAppointCourse',
			   	      data:{id:id},
			   	      success:function(data){
			   	    	  console.log(data);
			   	    	  if(data.resultCode==200){
			   	    		  //移除当前那课程
			   	    		  $(this).parent().parent().parent().parent().parent().remove();

			   	    	  }else{

			   	    		 // $('#failure').modal('show');

			   	    	  }

			   	      }
			   	    });*/




	});

	/**
	 * 确定取消预约
	 */
	$('#btn_sure').click(function(){
		//隐藏弹出的确认提示框
		$('.sure').hide();
		$('#alertSure').hide();

		var id=	$('#cancelAppointId').val();
		 $.ajax({
	   	      type:"GET",
	   	      url:baseUrl+'/outside/aboutClass/cancelAppointCourse',
	   	      data:{id:id},
	   	      success:function(data){
	   	    	  console.log(data);
	   	    	  if(data.resultCode==200){
	   	    		 location.reload();
	   /*	    		  $('.failmask').show();
	   	    		  $('#alertFail').show();
	   	    		  $('#errorMassage').text("");
	   	    		  $('#errorMassage').text("操作成功");
	   	    		  //移除当前那课程
	   	    		  $(this).parent().parent().parent().parent().parent().remove();*/

	   	    	  }else{

	   	    		  $('.failmask').show();
	   	    		  $('#alertFail').show();
	   	    		  $('#failmsg').text(data.message);
	   	    		/* $('.failmask').show();
	   	    		  $('#alertFail').show();
	   	    		  $('#errorMassage').text("");
	   	    		  $('#errorMassage').text(data.message);*/

	   	    	  }

	   	      }
	   	    });

	});

	/**
	 * 取消预约
	 *
	 */
	$('#btn_cancel').click(function(){
		//取消预约的弹出框
		$('.sure').hide();
		$('#alertSure').hide();

	});

	//隐藏  操作提示信息
	$('.btn_msg').click(function(){
		$('.failmask').hide();
		$('#alertFail').hide();

	});

})