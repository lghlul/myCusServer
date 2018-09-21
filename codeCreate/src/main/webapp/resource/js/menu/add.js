var spr = spr || {};
spr.menu = spr.menu || {};

/**
 * 表单验证
 */
spr.menu.add = {
    init: function() {
    	$("#form-menu-add").validate({
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
                    required:"请输入菜单名！"
            	},
                menuParentId:{
                    required:"请选择菜单父ID！"
                },
                menuUrl:{
                    required:"请输入菜单地址！"
                },
                menuOrder:{
                    required:"请输入菜单排序！"
                }
            },
    		focusCleanup:true
    	});
    }
};
