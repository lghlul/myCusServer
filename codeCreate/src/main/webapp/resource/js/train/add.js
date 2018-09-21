var spr = spr || {};
spr.train = spr.train || {};

/**
 * 表单验证
 */


spr.train.add = {
		
    init: function() {
    	
    	$("#form-account-add").validate({
    		rules:{
    			userAccount:{
    				required:true
    			},
    			userPassword:{
    				required:true
    			},
    			conPass:{
    				required:true,
    				equalTo:"#userPassword"
    			},
    			userName:{
    				required:true
    			},
    			userRoleId:{
    				required:true
    			}
    		},
            messages:{
            	userAccount:{
                    required:"请输入用户名！"
            	},
            	userPassword:{
                    required:"请输入密码！"
                },
                conPass:{
                    required:"请输入确认密码！",
    				equalTo:"两次密码不一致"
                },
                userName:{
                    required:"请输入昵称！"
                },
                userRoleId:{
                    required:"请选择角色！"
                }
            },
    		focusCleanup:true
    	});
    } 

};




