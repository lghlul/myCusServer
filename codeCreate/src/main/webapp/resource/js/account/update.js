var spr = spr || {};
spr.account = spr.account || {};

/**
 * 表单验证
 */
spr.account.updateRole = {
    init: function() {
        var roleIdInput = $("#roleIdInput").val();
        $("#roleIds").val(roleIdInput);
        
    	$("#form-role-update").validate({
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
