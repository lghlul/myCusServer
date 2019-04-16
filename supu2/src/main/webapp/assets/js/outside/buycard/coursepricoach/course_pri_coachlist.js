$(function(){
	
	var offset=0;

	getcoursePri();
	/*$(window).scroll(function(){

		$(window).scrollTop();//这个方法是当前滚动条滚动的距离

		$(window).height();//获取当前窗体的高度

		$(document).height();//获取当前文档的高度
		   //var bot = 50;
		//bot是底部距离的高度
		if (( $(window).scrollTop()) >=
			($(document).height() - $(window).height())) {
			//alert("roll="+offset);
			alert(1);
			getcoursePri();
		}

	});*/




	/**
	 * 获取评论  offset表示加载第几页数据
	 */
	// function  getcoursePri(){
	//     $.ajax({
	// 	      type:"GET",
	// 	      url:baseUrl+'/outside/buyCard/coursePriCoachlist?offset='+offset+'&&limit=9',
	// 	      success:function(data){
	// 	    	  if(data.resultCode==200){
	// 		    	  if(data.records !=null){
	// 		    		  var recordlist=data.records;
	// 		    		//  console.log(recordlist);
	// 		    		  for(var i=0;i<recordlist.length;i++){
    //
	// 		    			 $('#search').append('<a href="'+baseUrl+'/outside/buyCard/coursePriListDetail?id='+recordlist[i].id+'">'+
	// 		    	                	'<div class="coach-list clearfix">'+
	// 		    	                    '<div class="left">'+
	// 		    	                        '<img src="'+recordlist[i].courseimg+'">'+
	// 		    	                    '</div>'+
	// 		    	                    '<div class="right">'+
	// 		    	                        '<div class="clearfix">'+
	// 		    	                            '<div class="coach-name">'+recordlist[i].coursename+'</div>'+
	// 		    	                            '<div class="price text-right">'+
	// 		    	                                '<span>'+recordlist[i].totalhours+'</span>'+
	// 		    	                                '<span>&nbsp;&nbsp;课时</span>'+
	// 		    	                            '</div>'+
	// 		    	                        '</div>'+
	// 		    	                        '<div class="stars">'+
	// 		    	                           '<span class=""></span>'+
	// 		    	                            '<span class=""></span>'+
	// 		    	                            '<span class=""></span>'+
	// 		    	                            '<span class=""></span>'+
	// 		    	                            '<span class=""></span>'+
	// 		    	                        '</div>'+
	// 		    	                        '<div class="advantage">'+recordlist[i].coursetitle+'</div>'+
	// 		    	                        '<div class="certificate">'+
	// 		    	                           /* '<span class="tap">2项专业认证</span>'+*/
	// 		    	                        '</div>'+
	// 		    	                    '</div>'+
	// 		    	                '</div>'+
	// 		    	                '</a>');
    //
	// 		    		  }
	// 			    	  offset=offset+9;
	// 		    	  }
	// 	    	  }
	// 	      }
	// 	    });
    //
	// }


    function  getcoursePri(){
        $.ajax({
            type:"GET",
            url:baseUrl+'/outside/buyCard/coursePriCoachlist?offset='+offset+'&&limit=9',
            success:function(data){
                if(data.resultCode==200){
                    if(data.records !=null){
                        var recordlist=data.records;
                        var star = "";
                        //  console.log(recordlist);
                        for(var i=0;i<recordlist.length;i++){

                            star=  showStar(recordlist[i].commentCount,recordlist[i].totalStar);

                            $('#search').append('<a href="'+baseUrl+'/outside/buyCard/coursePriListDetail?id='+recordlist[i].id+'">'+
                                '<div class="coach-list clearfix">'+
                                '<div class="left">'+
                                '<img src="'+recordlist[i].courseimg+'">'+
                                '</div>'+
                                '<div class="right">'+
                                '<div class="clearfix">'+
                                '<div class="coach-name">'+recordlist[i].coursename+'</div>'+
                                '<div class="price text-right">'+
                                '<span>'+recordlist[i].totalhours+'</span>'+
                                '<span>&nbsp;&nbsp;课时</span>'+
                                '</div>'+
                                '</div>'+
                                '<div class="stars">'+star+

                                '</div>'+
                                '<div class="advantage">'+recordlist[i].coursetitle+'</div>'+
                                '<div class="certificate">'+
                                /* '<span class="tap">2项专业认证</span>'+*/
                                '</div>'+
                                '</div>'+
                                '</div>'+
                                '</a>');

                        }
                        offset=offset+9;
                    }
                }
            }
        });


        function showStar(commentCount,totalStar){
        	var star = "";
            if(commentCount == 0){
                star="暂无评分"
            }
            if(Math.round(totalStar/commentCount) == 1){
                star = '<span class=""></span>';
            }
            if(Math.round(totalStar/commentCount) == 2){
                star = '<span class=""></span><span class=""></span>';
            }
            if(Math.round(totalStar/commentCount) == 3){
                star = '<span class=""></span><span class=""></span><span class=""></span>';
            }
            if(Math.round(totalStar/commentCount) == 4){
                star = '<span class=""></span><span class=""></span><span class=""></span><span class=""></span>';
            }
            if(Math.round(totalStar/commentCount) == 5){
                star = '<span class=""></span><span class=""></span><span class=""></span><span class=""></span><span class=""></span>';
            }
			return star;
        }
    }
	
	/*function  getcoursePri(){

		//alert("1");
	    $.ajax({
		      type:"GET",
		      url:baseUrl+'/outside/buyCard/coursePriCoachlist?offset='+offset+'&&limit=9',
		      success:function(data){
		    	  if(data.resultCode==200){
			    	  if(data.records !=null){
			    		  var recordlist=data.records;
			    		//  console.log(recordlist);
			    		  for(var i=0;i<recordlist.length;i++){

			    			 $('#search').append('<a href="'+baseUrl+'/outside/buyCard/coachPriDetail?id='+recordlist[i].id+'">'+
			    	                	'<div class="coach-list clearfix">'+
			    	                    '<div class="left">'+
			    	                        '<img src="'+recordlist[i].headimg+'">'+
			    	                        '<img src="'+baseUrl+'/assets/images/outside/p'+recordlist[i].coachlevel+'.png" class="hot">'+
			    	                    '</div>'+
			    	                    '<div class="right">'+
			    	                        '<div class="clearfix">'+
			    	                            '<div class="coach-name">'+recordlist[i].nickname+'</div>'+
			    	                            '<div class="price text-right">'+
			    	                                '<span>￥</span>'+
			    	                                '<span>'+recordlist[i].courseAmount+'</span>'+
			    	                                '<span>/课时起</span>'+
			    	                            '</div>'+
			    	                        '</div>'+
			    	                        '<div class="stars">'+
			    	                           '<span class=""></span>'+
			    	                            '<span class=""></span>'+
			    	                            '<span class=""></span>'+
			    	                            '<span class=""></span>'+
			    	                            '<span class=""></span>'+
			    	                        '</div>'+
			    	                        '<div class="advantage">'+recordlist[i].goodat+'</div>'+
			    	                        '<div class="certificate">'+
			    	                            '<span class="tap">2项专业认证</span>'+
			    	                        '</div>'+
			    	                    '</div>'+
			    	                '</div>'+
			    	                '</a>');

			    		  }
				    	  offset=offset+9;
			    	  }
		    	  }
		      }
		    });

	}*/

})



