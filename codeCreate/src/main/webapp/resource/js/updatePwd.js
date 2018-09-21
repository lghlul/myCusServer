var spr = spr || {};
spr.updatePwd = spr.updatePwd || {};
spr.updatePwd.update = {
	init : function() {
		this.btn.init();
	},
	btn : {
		init : function() {
			$("#form-update-password").validate({
	    		rules:{
	    			oldPass:{
	    				required:true
	    			},
	    			newPass:{
	    				required:true
	    			},
	    			conPass:{
	    				required:true,
	    				equalTo:"#newPass"
	    			}
	    		},
	            messages:{
	            	oldPass:{
	                    required:"请输入原始密码！"
	            	},
	            	newPass:{
	                    required:"请输入新密码！"
	                },
	                conPass:{
	                    required:"请输入确认密码！",
	    				equalTo:"两次密码不一致"
	                }
	            },
	    		focusCleanup:true
	    	});
		}
	}
};