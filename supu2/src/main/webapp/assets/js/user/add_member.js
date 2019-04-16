$(function(){

	// 身份证号码验证
	jQuery.validator.addMethod("isIdCardNo", function(value, element) {
	  return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
	}, "请正确输入您的身份证号码");

	  $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		    rules : {
		      membername : {
		        required : true,
		      },
		      phonenumber : {
			        required : true,
			        maxlength : 11,
			        minlength : 11,
			        digits : true,
		      },
		      idnumber :{
		    	   isIdCardNo:true
//			        digits : false,checkdiv
		      },
		      buytime :{
		    	   required:true,
		      },
		      expiretime :{
		    	   required:true,
		      }
		    },
		    messages : {
		      membername : {
		        required : "请输入名字",
		      },
		      phonenumber : {
			        required : "请输入手机号码",
			        maxlength : " 手机号码为11位数字",
			        minlength : " 手机号码为11位数字",
			        digits : " 手机号码为11位数字",
		      },
		      idnumber :{
		    	  isIdCardNo:"请输入正确的身份证号"
		      },
		      buytime :{
		    	  required:"请输入开始时间",
		      },
		      expiretime :{
		    	  required:"请输入结束时间",
		      }
		    },
		      submitHandler: function(form) {  //通过之后回调
			    	if($(".checkbox_memberCard").is(":checked")==false){
			    		if($('#membercard_error').length<=0){
			    			$('#checkdiv').append("<span id='membercard_error' class='error'>请选择会员卡</span>");
			    		}
			    		return false;
			    	}
			    	if($(".stores").is(":checked")==false){
			    		if($('#stores_error').length<=0){
			    			$('#div_choseStores').append("<span id='stores_error' class='error'>请选择门店</span>");
			    		}
			    		return false;
			    	}
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
		  	   	    		  $('#sp_msg').text(data.message==null?"发布失败":data.message);
		  	   	    		  $('#failure').modal('show');

		  	   	    	  }

		  	   	      }
		  	   	    });
		      }
		  });



		//选中门店之后，点击确定，将门店展示出来
		$('.surechoose').click(function(){
			$('.cleandiv').empty();
			$('.cleandiv').append('<a class="btn btn-success" data-toggle="modal" data-target="#choose_stores"  id="mendianchoose">选择门店</a>');
			$('.stores').each(function(){
				if ($(this).is(':checked')) {
					$('#mendianchoose').before($(this).data("name")+"&nbsp;&nbsp;");
				}
			});
		});

	/**
	  * 提交form表单
	  */
//		$('#form').on('submit',function(ev){
//   	    $.ajax({
//   	      type:"POST",
//   	      url:baseUrl+'/user/member/addSave',
//   	      data:$('#form').serialize(),
//   	      success:function(data){
//   	    	  console.log(data);
//   	    	  if(data.resultCode==200){
//   	    		  $('#success').modal('show');
//   	    		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);
//
//   	    	  }else{
//   	    		  $('#failure').modal('show');
//
//   	    	  }
//
//   	      }
//   	    });
//   	    ev.preventDefault();
//   	  });


		//会员卡checkbox选中事件
		$('.checkbox_memberCard').click(function(){
			//获取id
			var id=$(this).val();

			//如果是选中状态
			if($(this).is(":checked")){

				//显示出层
				$('#div_'+id).show();

				$('#buytime'+id).attr("disabled",false);

			}else{
				//显示出层
				$('#div_'+id).hide();

				$('#buytime'+id).attr("disabled",true);
			}

		});



});