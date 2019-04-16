$(function(){
	$('#div_on').click(function(){
		$('#isuse_value').val(0);

	});
	$('#div_off').click(function(){
		$('#isuse_value').val(1);

	});
	//点击时长  切换按钮
	$(document).on('click','.timelong',function(){
			//赋值给文本。提交后台
			$('#txt_timelong').val($(this).data('id'));

	});


	//点击  会员卡类型 切换按钮
	$(document).on('click','.cardtype',function(){
			//赋值给文本。提交后台
			$('#txt_cardtype').val($(this).data('id'));

	});

	//选中checkbox
	$('.surechoose').click(function(){
		$('#cleandiv').empty();
		$('#cleandiv').append('<a class="btn btn-success" data-toggle="modal" data-target="#choose_stores"  id="mendianchoose">选择门店</a>');
		$('.stores').each(function(){
			if ($(this).is(':checked')) {
				$('#mendianchoose').before($(this).data("name")+"&nbsp;&nbsp;");
			}
		});
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
	    	  alert("1");
	    	//  alert("children");
	      },
	      error: function(err) {

	      }
	});



	  $('#addcard_form').validate({
		 // onsubmit:true,// 是否在提交是验证
		  ignore: "",
		    rules : {
		    	membername : {
		        required : true,
		      },
		      amountmoney : {
			        required : true,
//			        maxlength : 11,
//			        minlength : 11,
//			        digits : true,
		      },
		      idnumber :{
		    	   required:true,
		    	   isIdCardNo:true
//			        digits : false,
		      },
		      mcardimg:{
		    	  required:true,
		      },
		      memberrights:{
		    	  required:true,
		      }
		    },
		    messages : {
		      membername : {
		        required : "请输入名字",
		      },
		      amountmoney : {
			        required : "请输入金额",
//			        maxlength : " 手机号码为11位数字",
//			        minlength : " 手机号码为11位数字",
//			        digits : " 手机号码为11位数字",
		      },
		      idnumber :{
		    	  required:"请输入身份证号",
		    	  isIdCardNo:"请输入正确的身份证号"
		      },
		      mcardimg:{
		    	  required:"请上传图片",
		      },
		      memberrights:{
		    	  required:"请输入权益",
		      }
		    },
		      submitHandler: function(form) {  //通过之后回调
			    	if($(".stores").is(":checked")==false){
			    		//alert($('#stores_error').length);
			    		if($('#stores_error').length<=0){
			    			$('#div_servicearea').append("<span id='stores_error' class='error'>请选择门店</span>");
			    		}
			    		return false;
			    	}
//			    	if($(".checkbox_memberCard").is(":checked")==false){
//			    		$('#checkdiv').append("请选择会员卡");
//			    		return false;
//			    	}
			    	 $.ajax({
			      	      type:"POST",
			      	      url:baseUrl+'/user/memberCard/addSave',
			      	      data:$('#addcard_form').serialize(),
			      	      success:function(data){
			      	    	  console.log(data);
			      	    	  if(data.resultCode==200){
			      	    		  $('#all_success').modal('show');
			      	    		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);

			      	    	  }else{
			      	    		  $('#all_failure').modal('show');

			      	    	  }

			      	      }
			      	    });
		      }
		  });

//异步提交表单
/*	$('#addcard_form').on('submit',function(ev){

   	    ev.preventDefault();
   	  });*/
	//异步新增会员卡类型
	$('#btn_cardtype_sub').click(function(){
		var  cardType=$('#add_cardtype').val();
		if(cardType==null || cardType==''){
			$('#add_cardtype').after("<div id='cardType' class='error'>请输入会员卡类型名称</div>");

		}
		else if(cardType.length>20){
			$('#cardType').remove();
			$('#add_cardtype').after("<div id='cardType' class='error'>会员卡类型名称不能超过20个字符</div>");

		}else{

			addcardtype();
		}
	});
});

//异步新增会员卡类型
function addcardtype(){
	    $.ajax({
	   	      type:"POST",
	   	      url:baseUrl+'/user/memberCard/addMemberCardType',
	   	      data:{title:$('#add_cardtype').val()},
	   	      success:function(data){
	   	    	  console.log(data);
	   	    	  if(data.resultCode==200){
	   	    		  $('#addcard_success').modal('show');
	   	    		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);
	   	    		  $('#addcardType').before('<button id="add_type" class="btn cardtype" type="button" data-id='+data.total+'>'+$('#add_cardtype').val()+'</button>');
	   	    		  $('#addCardType').modal('hide');
	   	    		  $('#cardtype').val("");
	   	    	  }else{
	   	    		  $('#addcard_failure').modal('show');

	   	    	  }

	   	      }
	   	  });
}