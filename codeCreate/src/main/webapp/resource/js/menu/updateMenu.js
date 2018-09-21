var spr = spr || {};
spr.updateMenu = spr.updateMenu || {};
spr.updateMenu.update = {
	init : function() {
		this.btn.init();
	},
	btn : {
		init : function() {
			$("#form-update-menu").validate({
	    		rules:{
                    menuName:{
	    				required:true
	    			},
                    menuParentId:{
	    				required:true
	    			},
                    menuUrl:{
	    				required:false
	    			},
                    menuOrder:{
                        required:true
                    }
	    		},
	            messages:{
                    menuName:{
	                    required:"请输入新菜单名！"
	            	},
                    menuParentId:{
	                    required:"请输入菜单父ID！"
	                },
                    menuUrl:{
	                    required:"请输入菜单URL！"
	                },
                    menuOrder:{
                        required:"请输入菜单排序！"
                    }
	            },
	    		focusCleanup:true
	    	});
		}
	}
};