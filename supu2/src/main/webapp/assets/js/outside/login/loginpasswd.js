$(function(){

	 $('#form').validate({

		  onsubmit:true,// 是否在提交是验证
		    rules : {
		    	username : {
		        required : true,
		        maxlength : 11,
		        minlength : 11,
		        digits : true,
	            remote:{                         //自带远程验证存在的方法
	                   url:baseUrl+'/isExist',
	                   type:"get",
	                   data:{
	                	   username: function () { return $("#loginPhone").val(); },

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
		        maxlength : 18,
		        minlength : 6,

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
		        remote : "账号不存在"
		      },
		      password : {
		        required : "请输入密码",
		        maxlength : " 密码长度为6-18位",
		        minlength : " 密码长度为6-18位",

		      },
		      captcha:{
		    	  required:"请输入验证码"
		      }
		    },
		      submitHandler: function(form) {  //通过之后回调
		    	  form.submit();


			  }
		  });
})