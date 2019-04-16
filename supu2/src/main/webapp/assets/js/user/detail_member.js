$(function(){
	/**
	  * 提交form表单
	  */
		$('#form').on('submit',function(ev){
   	    $.ajax({
   	      type:"POST",
   	      url:baseUrl+'/user/member/addSave',
   	      data:$('#form').serialize(),
   	      success:function(data){
   	    	  console.log(data);
   	    	  if(data.resultCode==200){
   	    		  $('#success').modal('show');
   	    		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);

   	    	  }else{
   	    		  $('#failure').modal('show');

   	    	  }

   	      }
   	    });
   	    ev.preventDefault();
   	  });

})