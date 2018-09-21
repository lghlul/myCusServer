var spr = spr || {};
spr.org = spr.org || {};

/**
 * 表单验证
 */
spr.org.addRole = {
    init: function() {
        
    	$("#form-org-addRole").validate({
	    	rules:{
				roleIds:{
					required:true
				}
			},
	        messages:{
	        	roleIds:{
	                required:""
	            }
	        },
    		focusCleanup:true
    	});
    }
};
