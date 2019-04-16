$(function(){
	var offset=0;
	getcourseGroup();
	$(window).scroll(function(){

	/*	$(window).scrollTop();//这个方法是当前滚动条滚动的距离

		$(window).height();//获取当前窗体的高度

		$(document).height();//获取当前文档的高度*/
		   //var bot = 50;
		//bot是底部距离的高度
		if (( $(window).scrollTop()) >=
			($(document).height() - $(window).height())) {
			//alert("roll="+offset);
			getcourseGroup();
		}

	});




	/**
	 * 获取评论  offset表示加载第几页数据
	 */
	function  getcourseGroup(){


	    $.ajax({
		      type:"GET",
		      url:baseUrl+'/outside/buyCard/getCourseStudio?offset='+offset+'&&limit=9',
		      success:function(data){
		    	  if(data.resultCode==200){
			    	  if(data.records !=null){
			    		  var recordlist=data.records;
			    		  var html="";
			    		  for(var i=0;i<recordlist.length;i++){
/*			    			var timelist=recordlist[i].courseExcTimeDtos;
			    			//开始时间
			    			var startDate=moment(recordlist[i].sdate).format('YYYY-MM-DD');

			    			//结束时间
			    			var endDate=moment(recordlist[i].edate).format('YYYY-MM-DD');
			    			html="开营日期"+startDate+"至"+endDate+"<br>";
			    			html="开日期"+startDate+"<br>";
			    			//循环精品团课排期
			    			for ( var j = 0; j < timelist.length; j++) {
			    				html+="周"+timelist[j].concatweek.replace(",", '、')+"&nbsp;&nbsp;"+timelist[j].starttime+"~"+timelist[j].endtime+"&nbsp;&nbsp;";
							}*/
			    			 $('#appendgroupDiv').append(
									'<a href="'+baseUrl+'/outside/buyCard/courseStudioDetail?id='+recordlist[i].id+'&storeid='+recordlist[i].stores+'">'+
										'<div flex="dir:top cross:center" class="training-center-list">'+
											'<div class="training-center-item">'+
												'<div flex="dir:top main:justify cross:left" class="training-center-item-main" style="background-image: url('+recordlist[i].courseimg+');">'+
													'<div class="blanket"></div>'+
													'<div class="main">'+
														'<div class="training-slip">'+
															'<div class="training-center-item-price-time">'+
																'<span class="item-price">'+
	                                                        '<small >¥ </small>'+recordlist[i].courseamount+'</span> <span class="class_amount">/ 共'+recordlist[i].totalhours+'课时</span>'+
															'</div>'+
														'</div>'+
														'<div class="training-center-item-title2">'+
															'<div class="training-center-item-subTitle1">'+
																'<span class="training-name">'+recordlist[i].coursename+'</span>'+
																/*'<span class="training-remain">仅剩6个名额</span>'+*/
															'</div>'+
															'<div class="training-center-item-subTitle2">'+
																''+recordlist[i].storename+' / '+recordlist[i].coachname+' /开课时间'+recordlist[i].startTime+' '+
															'</div>'+
														'</div>'+
													'</div>'+
												'</div>'+
											'</div>'+
										'</div>'+
									'</a>'
			    	         );
			    		  }
				    	  offset=offset+9;

			    	  }else{
				    	  if (data.records.length==0) {
				    			 $('#appendgroupDiv').append(
				    							  '<div class="empty-box"><div >'+
				    							  '<img src="'+baseUrl+'/assets/images/kcbg.gif" class="empty-img">'+
				    							  '<p class="empty-text">即将开放     敬请期待</p>'+
				    							  '</div></div>'

					    	         );
				    	  }
			    	  }
/*			    	  console.log(data.records);*/
		    	  }
		      }
		    });

	}

});