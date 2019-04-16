$(function(){
	
	

	
	
	
		//点击所授课程
		$('.lesson-list').click(function(){
			//将详情 照片 添加到弹窗中
			var title=$(this).find('.title').val();
			var img=$(this).find('.img').val();
			var detail=$(this).find('.detail');

			$('#window_img').attr("src",img);

			$('#titleappend').empty();
			$('#titleappend').append(title);

			$('#div_detail').empty();
			$('#div_detail').append(detail.html());
		});

		/**
		 * 点击立即购买
		 */
		$('#buy').click(function(){

			//获取选中的课程
			var count= $('.check').length;

			if(count <1){
				$('#errorMassage').text("");
				$('#errorMassage').text('请选择您需要购买的课程！');

				$('#alertquenen').show();
				$('.model').show();
				return false;
			}


			//判断是否为体验课
			var isExperience=$('.check').parent().prev('.isexperience').val();



			//你已经购买过私教课或者购买过体验课，就不能购买   仅限新人
			var isBuyPriCoach=false;
			//==1为体验课  ,只有为体验课时，才加一下检查
			if(isExperience==1){
				$.ajax({
				      type:"GET",
				      data:$('#form').serialize(),
				      async:false,
				      url:baseUrl+'/outside/personal/isBuyPriCoach',
				      success:function(data, textStatus, request){
				    	  if (request.getResponseHeader('sessionstatus')=="unlogin") {
				    		  window.location=baseUrl+"/outside/login";
				    	  }else{
				    		  if (data.resultCode==200) {
				    			  isBuyPriCoach=data.records;

					    	  }

				    	  }
				      }
				})

			}
			if(isBuyPriCoach){
				$('#errorMassage').text("");
				$('#errorMassage').text('您好，体验课仅限从未买过私教课的新用户购买！');

				$('#alertquenen').show();
				$('.model').show();
				return false;
			}




			var courseId=$('.check').parent().next(':hidden').val();

			window.location.href=baseUrl+"/outside/personal/buyPriCoach?courseId="+courseId;


		});

		/**
		 * 隐藏弹出层
		 */
		$('.mint-msgbox-cancel').click(function(){
			$('#alertquenen').hide();
			$('.model').hide();

		});
})



