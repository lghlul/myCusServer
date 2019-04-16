$(function(){


	  $('#form').validate({


		    rules : {

		    passwd : {
		        required : true,
		        maxlength : 18,
		        minlength : 6,
		      //  digits : true

		      },
		      confirmPasswd : {
		        required : true,
		        equalTo : '#passwd'
		      }
		    },
		    messages : {

		      passwd : {
		        required : "请输入密码",
		        maxlength : " 密码长度为6-18位",
		        minlength : " 密码长度为6-18位",
		        //digits : " 密码为6位数字"
		      },
		      confirmPasswd : {
		        required : "请输入确认密码",
		        equalTo : "2次密码输入不匹配"
		      }
		    },

		  });

});