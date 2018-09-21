var spr = spr || {};
spr.role = spr.role || {};

/**
 * 表单验证
 */
spr.role.add = {
    init: function() {
    	$("#form-role-add").validate({
    		rules:{
    			roleName:{
    				required:true
    			}
    		},
            messages:{
            	roleName:{
                    required:"请输入角色名称！"
            	}
            },
    		focusCleanup:true
    	});
    }
};
