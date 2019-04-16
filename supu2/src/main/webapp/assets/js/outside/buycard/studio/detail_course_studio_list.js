$(function(){
	/* 	var startDate=$('#startDate').val();;
	 	var endDate=$('#endDate').val();;*/
		//工作是课程id
		var courseid=$('#courseid').val();
	 	//点击购买按钮
	 	$('#buyexccourse').click(function(){
	 		//训练营是否已满以及是否购买相同的课程
			$.ajax({
			      type:"GET",
			      data:$('#form').serialize(),
			      async:false,
			      url:baseUrl+"/outside/personal/buyStudio?cid="+courseid,
			      success:function(data, textStatus, request){
			    	  if (request.getResponseHeader('sessionstatus')=="unlogin") {
			    		  window.location=baseUrl+"/outside/login";
			    	  }else{
			    		  if (data.resultCode==200) {
			    			  window.location.href=baseUrl+"/outside/personal/buyStudio?courseId="+courseid;

				    	  }else{
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
		 * 隐藏弹出层
		 */
		$('.mint-msgbox-cancel').click(function(){
			$('#alertFail').hide();
			$('.failmask').hide();

		});
	});