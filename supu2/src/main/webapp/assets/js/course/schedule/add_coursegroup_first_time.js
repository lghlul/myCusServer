$(function(){

	  $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		  submitHandler: function(form) {  //通过之后回调
			 var result=false;
	      $.ajax({
		   	      type:"POST",
		   	      url:baseUrl+'/user/course/isAlreadyAddTime',
		   	      data:$('#form').serialize(),
		   	      async: false,
		   	      success:function(data){
		   	    	 if(data.resultCode==200){
		   	    		 if(data.records){//如果为true,表示本月已经添加过了

		   	    		 }else{
		   	    			result=true;
		   	    		 }
		   	    	 }


		   	      }
		   	 });

	      	if(result){
	      		form.submit();
	      	}else{
	      		$('#fail').modal('show');
	      		return false;
	      	}
	      }
	  });


})