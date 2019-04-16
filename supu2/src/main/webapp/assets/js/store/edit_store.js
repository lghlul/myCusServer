$(function(){
	//加载地区
	 $('#city_china_val').cxSelect({
		   url:baseUrl+'/assets/js/cxselect/cityData.json',
		   selects: ['province','city', 'area'],
		   emptyStyle: 'none'
	});

	 /**
	  * 提交form表单
	  */
		/*$('#form').on('submit',function(ev){

    	    ev.preventDefault();
    	  });*/




		  $('#form').validate({
			   ignore: "",
			    rules : {
			    	storename : {
				        required : true,
				        maxlength : 20,
				        minlength : 1,
				      },
				      storeimg:{
				    	 required : true,

				     }
			    },
			    messages : {
			    	storename : {
				        required : "请输入门店名称",
				        maxlength : "门店名称最长为20个字符",
				        minlength : "门店名称至少有1个字符",
			      },
			      storeimg:{
				    	 required :"请上传图片",

				     }
			    },submitHandler: function(form) {  //通过之后回调
			    	 /**
			   	  * 提交form表单
			   	  */
				    $.ajax({
			    	      type:"POST",
			    	      url:baseUrl+'/user/store/editSave',
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

			    }

			});






		/**
		 * 选择门店状态
		 */
		$('.btn_storeStatus').click(function(){

			$('#status').val($(this).data('id'));
		});



		/**
		 * 上传主图到阿里云
		 */
		 $("#file").takungaeImgup({

		    /*  formData: {
		          "path": "artScene/",
		          "name": value
		      },*/
		      url: baseUrl+'/user/uploadMainFigure',
		      success: function(data) {
		    	  //alert("1");
		    	//  alert("children");
		      },
		      error: function(err) {

		      }
		});


		 /**
		  * 删除图片
		  */
		 $('#delImg').click(function(){

			 $('#showImg').attr('src',baseUrl+'/assets/js/uploadImg/img/a11.png');
			 $('#mainfigure').val("");
			 $(this).remove();
			// alert("1");

		 });
});