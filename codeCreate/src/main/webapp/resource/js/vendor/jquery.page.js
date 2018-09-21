(function($){
	var ms = {
		init:function(obj,args){
			return (function(){
				ms.fillHtml(obj,args);
				ms.bindEvent(obj,args);
			})();
		},
		//填充html
		fillHtml:function(obj,args){
			return (function(){
				obj.empty();
				args.current = Number(args.current);
				args.pageCount = Number(args.pageCount);
				//上一页
				if(args.current > 1){
					obj.append('<a href="javascript:;" class="homePage">首页</a>');
					obj.append('<a href="javascript:;" class="prevPage">上一页</a>');
				}else{
					obj.remove('.prevPage');
					obj.append('<span class="disabled">首页</span>');
					obj.append('<span class="disabled">上一页</span>');
				}
				//中间页码
				if(args.current != 1 && args.current >= 8 && args.pageCount != 8){
					obj.append('<a href="javascript:;" class="tcdNumber">'+1+'</a>');
				}
				if(args.current-2 > 2 && args.current <= args.pageCount && args.pageCount > 9){
					obj.append('<span>...</span>');
				}
				var start = args.current -3,end = args.current+3;
				if((start > 1 && args.current < 8)||args.current == 1){
					end++;
				}
				if(args.current > args.pageCount-8 && args.current >= args.pageCount){
					start--;
				}
				for (;start <= end; start++) {
					if(start <= args.pageCount && start >= 1){
						if(start != args.current){
							obj.append('<a href="javascript:;" class="tcdNumber">'+ start +'</a>');
						}else{
							obj.append('<span class="current">'+ start +'</span>');
						}
					}
				}
				if(args.current + 3 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 9){
					obj.append('<span>......</span>');
				}
				if(args.current != args.pageCount && args.current < args.pageCount -3  && args.pageCount != 9){
					obj.append('<a href="javascript:;" class="tcdNumber">'+args.pageCount+'</a>');
				}
				//下一页
				if(args.current < args.pageCount){
					obj.append('<a href="javascript:;" class="nextPage">下一页</a>');
				}else{
					obj.remove('.nextPage');
					obj.append('<span class="disabled">下一页</span>');
				}

				//尾页
				if(args.pageCount<=1)
				{
					obj.append('<span class="disabled">尾页</span>');
				}else if(args.current == args.pageCount){
					obj.append('<span class="disabled">尾页</span>');
				}else{
					obj.append('<a href="javascript:;" class="lastPage">尾页</a>');
				}
			})();
		},
		//绑定事件
		bindEvent:function(obj,args){
			return (function(){
				obj.on("click","a.tcdNumber",function(){
					var current = parseInt($(this).text());
					ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current);
					}
				});
				//上一页
				obj.on("click","a.prevPage",function(){
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj,{"current":current-1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current-1);
					}
				});
				//下一页
				obj.on("click","a.nextPage",function(){
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj,{"current":current+1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current+1);
					}
				});
				//首页
				obj.on("click","a.homePage",function(){
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj,{"current":1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(1);
					}
				});
				//尾页
				obj.on("click","a.lastPage",function(){
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj,{"current":args.pageCount,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(args.pageCount);
					}
				});
			})();
		}
	}
	$.fn.createPage = function(options){
		var args = $.extend({
			pageCount : 10,
			current : 1,
			backFn : function(){}
		},options);
		ms.init(this,args);
	}
})(jQuery);

