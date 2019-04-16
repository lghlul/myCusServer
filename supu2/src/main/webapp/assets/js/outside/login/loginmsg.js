$(function(){



	$('#mobile').keyup(function(){
		$('#error').remove();//清除错误
	});


	 $('#form').validate({

		  onsubmit:true,// 是否在提交是验证
		    rules : {
		    	username : {
		        required : true,
		        maxlength : 11,
		        minlength : 11,
		        digits : true,
	            remote:{                         //自带远程验证存在的方法
	                   url:baseUrl+'/findpasswd/isExist',
	                   type:"get",
	                   data:{
	                	   username: function () { return $("#mobile").val(); },

	                   },
	                   dataFilter: function(data, type) {
	                		data=eval("("+data+")");
	                        if (data.resultCode == 1){
	                            return true;
	                        }
	                        else{
	                            return false;
	                        }
	                   }

	               }
		      },
		      password : {
		        required : true,
		        maxlength : 4,
		        minlength : 4,

		      },
		      captcha:{
		    	  required:true
		      }

		    },
		    messages : {
		    	username : {
		        required : "请输入手机号码",
		        maxlength : " 手机号码为11位数字",
		        minlength : " 手机号码为11位数字",
		        digits : " 手机号码为11位数字",
		        remote : "账号已被绑定"
		      },
		      password : {
		        required : "请输入验证码",
		        maxlength : " 验证码长度为4位",
		        minlength : " 验证码长度为4位",

		      },
		      captcha:{
		    	  required:"请输入验证码"
		      }
		    },
		      submitHandler: function(form) {  //通过之后回调
		    	  form.submit();


			  }
		  });

		/**
		 * 发送验证码点击事件
		 */
		$('#send').click(function(){

			var  mobile=$('#mobile').val();
			if(mobile==null || mobile == ''){
				$('#error').remove();
				$('#mobile-error').remove();
				$('#mobile').after("<label class='error' id='error'>请输入手机号码</label>");
				return false;
			}
			var ret = /^(13[0-9]{9})|(18[0-9]{9})|(16[0-9]{9})|(14[0-9]{9})|(19[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
			if (mobile!=null || mobile != '') {
				if (!ret.test(mobile)) {
					$('#mobile-error').remove();
					$('#error').remove();
					$('#mobile').after("<label class='error' id='error'>请填写正确手机号码</label>");
					return false;
				}else{
					$('#error').remove();
				}
			}
			var a=phoneIsExist();
			if (a==0) {
				$('#error').remove();
				//请相互validate.js的错误
				//$('#mobile-error').remove();
				//$('#mobile').after("<label id='error' class='error'>账号不存在</div>");
				return false;
			}

			sendCodeAjax('#send', mobile,'#ImagePictext');


		});

		/**
		 * 手机号是否存在
		 */
		function phoneIsExist(){
			//alert($('#mobile').val());
			var result;
			$.ajax({
				type:'get',
				data:{"username":$('#mobile').val()},
				dataType:'json',
				async:false,
				url:baseUrl+"/findpasswd/isExist",
				success:function(data){
					//alert(data.resultCode);
					result= data.resultCode;
					//return data.resultCode;
				/*	if (data.resultCode==0) {
						result= data.resultCode;
					}else{
						result= data.resultCode;
					}*/

				}
			});
			return result;
		}

		/**
		 * 发送短信验证码
		 */
		function sendCodeAjax(id,mobile,imgvetext){
			//$.ajaxSettings.async = false;
			var time = 60;
			$.getJSON(baseUrl+'/getLoginMobileCode', {
				'mobile':mobile,
				'imgvetext':$(imgvetext).val()
			}, function(data){

				console.log(data);
				if(data.resultCode === 200) {
					$(id).prop('disabled', true).text('已发送');
					var timer = setInterval(function(){
	                    $(id).prop('disabled', true).text((time--)+"s 后重新发送");
	                    if (time === 0){
	                        clearInterval(timer);
	                        $(id).prop('disabled', false).text("发送验证码");
	                    }
	                },1000);
				}
				else {


					$('#error').remove();
					//alert();
					$('#div_error').html("<font color='red'><div id='error'  class='error'>"+data.message+"</div></font>");
				}
			});
		}


		//点击登录，清空 发送验证码的错误信息
		$('#login').click(function(){
			$('#error').remove();
		});

})