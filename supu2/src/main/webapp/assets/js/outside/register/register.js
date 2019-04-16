$(function(){

	$('#mobile').keyup(function(){
		$('#error').remove();
	});



	  $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		    rules : {
		    	mobile : {
		        required : true,
		        maxlength : 11,
		        minlength : 11,
		        digits : true,
	            remote:{                         //自带远程验证存在的方法
	                   url:baseUrl+'/isExist',
	                   type:"get",
	                 //  dataType:"json",
	                   data:{
	                	   username: function () { return $("#mobile").val(); },
	                   },
	                   dataFilter: function(data, type) {
	                		data=eval("("+data+")");
	                        if (data.resultCode == 0){
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
		        maxlength : 18,
		        minlength : 6,
		        digits : false,
		      },
		      confirmPasswd : {
		          required : true,
		          equalTo : '#password'
		        },
		      shortMessage :{
			        required : true,
			        maxlength : 4,
			        minlength : 4,
			        digits : true
		      }
		    },
		    messages : {
		    	mobile : {
		        required : "请输入手机号码",
		        maxlength : " 手机号码为11位数字",
		        minlength : " 手机号码为11位数字",
		        digits : " 手机号码为11位数字",
		        remote : "账号已存在"
		      },
		      password : {
		        required : "请输入密码",
		        maxlength : " 密码为6-18位字符",
		        minlength : " 密码为6-18位字符",
		       // digits : " 密码为6-18位数字或字母"
		      },
		      confirmPasswd : {
		          required : "请输入确认密码",
		          equalTo : "2次密码输入不匹配"
		        },
		      shortMessage :{
			        required : "请输入验证码",
			        maxlength : " 验证码为4位数字",
			        minlength : " 验证码为4位数字",
			        digits : " 验证码为4位数字"
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
			var ret = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
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

			sendCodeAjax('#send', mobile);


		});
		$('#register').click(function(){
			$('#error').remove();
		});


		/**
		 * 发送短信验证码
		 */
		function sendCodeAjax(id,mobile){
			var time = 60;
			$.getJSON(baseUrl+'/getMobileCode', {
				'mobile':mobile

			}, function(data){
				console.log(data);
				if(data.resultCode === 200) {
					//alert("a");
				/*	$('#exist').remove();
					$('#fail').remove();*/
					//$('#newPhoneCode-error').remove();
					$(id).prop('disabled', true).text('已发送');
					var timer = setInterval(function(){
	                    $(id).prop('disabled', true).text((time--)+"s 后重新发送");
	                    if (time === 0){
	                    	time = 60;
	                        clearInterval(timer);
	                        $(id).prop('disabled', false).text("发送验证码");
	                    }
	                },1000);

				}
				else {
					if (data.message=='账号已存在') {
						$('#mobile-error').remove();
						$('#error').remove();
						$('#mobile').after("<label class='error' id='error'>"+data.message+"</label>");
					}else{
						$('#mobile-error').remove();
						$('#error_code').remove();
						$('#shortMessage').after("<label class='error' id='error'>"+data.message+"</label>");
					}
				}
			});
		}

});

