$(function(){

	 $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		  submitHandler: function(form) {  //通过之后回调

			  //如果所有数据为空，则不允许提交
			  var hasValue=false;


			  $('.startDate').each(function(){
				  var startDate=$(this).val();
				  	//var endDate=$(this).next().val();
				  var endDate=$(this).parent().parent().find('.endDate').val();
				  if(startDate !=null && startDate!='' || (endDate !=null && endDate !='')){
					  hasValue=true;
					  return false;
				  }
			  })

			  if(!hasValue){
				  $('#fail').modal('show');
			      $('#span_msg').text("请填写数据");

				  return false;
			  }

			  //判断是否填写完整
			  var result =true;
			  var msg="请填写数据";
			  $('.startDate').each(function(){

				  var startDate=$(this).val();
				  var endDate=$(this).parent().parent().find('.endDate').val();
				  	//开始时间有，结束时间没有的情况
				  	if(startDate !=null && startDate!='' && (endDate ==null || endDate =='')){
				  		msg="请将数据填写完整";
				  		result=false;

				  		return false;
				  	}
				  //结束时间有，开始时间没有的情况
				  	if(endDate !=null && endDate!='' && (startDate ==null || startDate =='')){
				  		msg="请将数据填写完整";
				  		result=false;
				  		return false;
				  	}

			  });

			  if(result){
				  $.ajax({
			   	      type:"POST",
			   	      url:baseUrl+'/user/course/addGroupTimeSave',
			   	      data:$('#form').serialize(),
			   	      async: false,
			   	      success:function(data){
			   	    	  console.log(data);
			   	    	  if(data.resultCode=="200"){
			   	    		  $('#success').modal('show');
			   	    	  }else{
			   	    		  $('#fail').modal('show');
						      $('#span_msg').text(data.message);
			   	    	  }


			   	      }
			   	 });
			  }
		      else{
		    	  $('#fail').modal('show');
			      $('#span_msg').text(msg);
		    	  return false;


			  }

		  }});



})