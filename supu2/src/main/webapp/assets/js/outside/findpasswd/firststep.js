$(function(){


	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请正确填写您的手机号码");

	/**
	 * code 验证码改变改变事件
	 */
	$("#code").change(function(){
        var code = $("#code").val().trim();
        reg=/^\d{4}$/;
		if (!reg.test(code)) {
			$('#error_code').remove();
			$('#Code').after("<div id='error_code'>请填写4位短信验证码</div>");
			return false;
		}else{
			$('#error_code').remove();
		}
	});


	//点击下一步

	$('#nextStep').click(function(){
		var  mobile=$('#mobile').val();
		if(mobile==null || mobile == ''){
			$('#error').remove();
			$('#mobile').after("<div id='error'>请输入手机号码</div>");
			return false;
		}
		var ret = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		if (mobile!=null || mobile != '') {
			if (!ret.test(mobile)) {
				$('#error').remove();
				$('#mobile').after("<div id='error'>请填写正确手机号码</div>");
				return false;
			}else{
				$('#error').remove();
			}
		}

        var code = $("#Code").val().trim();
        reg=/^\d{4}$/;
		if (!reg.test(code)) {
			$('#error_code').remove();
			$('#Code').after("<div id='error_code'>请填写4位短信验证码</div>");
			return false;
		}else{
			$('#error_code').remove();
		}
	});

	/**
	 * 发送验证码点击事件
	 */
	$('#sendCode').click(function(){
		var  mobile=$('#mobile').val();
		if(mobile==null || mobile == ''){
			$('#error').remove();
			$('#mobile').after("<div id='error'>请输入手机号码</div>");
			return false;
		}
		var ret = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		if (mobile!=null || mobile != '') {
			if (!ret.test(mobile)) {
				$('#error').remove();
				$('#mobile').after("<div id='error'>请填写正确手机号码</div>");
				return false;
			}else{
				$('#error').remove();
			}
		}
		var a=phoneIsExist();
		if (a==0) {
			$('#error').remove();
			$('#mobile').after("<div id='error'>此账号不存在</div>");
			return false;
		}

		//$(this).unbind("click");
		sendCodeAjax('#sendCode', mobile);


	});
	/**
	 * 发送短信验证码
	 */
	function sendCodeAjax(id,mobile){
		//$.ajaxSettings.async = false;
		var time = 60;
		$.getJSON(baseUrl+'/findpasswd/getMobileCode', {
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
                        clearInterval(timer);
                        $(id).prop('disabled', false).text("发送验证码");
                    }
                },1000);
			}
			else {
				$('#error_code').remove();
				$('#Code').after("<div id='error_code'>"+data.message+"</div>");
			}
		});

	}


	/**
	 * 手机号是否存在
	 */
	function phoneIsExist(){
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

})