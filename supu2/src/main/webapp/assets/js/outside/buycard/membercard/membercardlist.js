$(function(){


	clickbutton();

//	//下拉加载
//	var offset=9;
//	$(window).scroll(function(){
//
//	/*	$(window).scrollTop();//这个方法是当前滚动条滚动的距离
//
//		$(window).height();//获取当前窗体的高度
//
//		$(document).height();//获取当前文档的高度*/
//		   //var bot = 50;
//		//bot是底部距离的高度
//		if (( $(window).scrollTop()) >=
//			(($(document).height()) - $(window).height())) {
//			//alert("roll="+offset);
//
//			getCourseGroup();
//		}
//
//	});
//


	$('.btn-reset').click(function(){
		$("input[type='radio']:checked").attr("checked",false);
	});








//
//
//$('.changeDate').click(function(){
//	//赋值
//	$('#getSelectDate').val($(this).data('date'));
//	$('#getSelectWeek').val($(this).data('week'));
//	$('#getSign').val($(this).data('id'));
//	$('#weekinput').val($(this).data('data'));
//	//查询
//	clickbutton();
//	$('#biaojiinput').val(9);
//});
//
//
//
//
//
//
//
///**
// * 获取团课  offset表示加载第几页数据
// */
//function  getCourseGroup(){
//	var a=$('#biaoji').val();
//	if (a==9) {
//		offset=a;
//	}
//
//    $.ajax({
//	      type:"GET",
//	      data:$('#form').serialize(),
//	      url:baseUrl+'/outside/aboutClass/getAboutClass?start='+offset+'&&end=9',
//	      success:function(data){
//	    	  console.log(data.records);
//	    	  //alert(data.records);
//	    	  var sign=$('#getSign').val();
//	    	  var list=data.records;
//	    	  //alert(sign);
//	    	  if(list.length>0){
//	    		  emptyAllDiv();
//    			  if (sign==0) {
//    				  appendGroupDiv('#today',list);
//    			  }else if(sign==1){
//    				  appendGroupDiv('#todaynextone',list);
//    			  }else if(sign==2){
//    				  appendGroupDiv('#todaynexttwo',list);
//    			  }else if(sign==3){
//    				  appendGroupDiv('#todaynextthree',list);
//    			  }else if(sign==4){
//    				  appendGroupDiv('#todaynextfour',list);
//    			  }else if(sign==5){
//    				  appendGroupDiv('#todaynextfive',list);
//    			  }else if(sign==6){
//    				  appendGroupDiv('#todaynextsix',list);
//    			  }
//    			  offset=offset+9;
//    			  $('#biaoji').val("");
//	    	  }else if(list.length==0){
//    			  if (sign==0) {
//    				  appendisNotExit('#today');
//    			  }else if(sign==1){
//    				  appendisNotExit('#todaynextone');
//    			  }else if(sign==2){
//    				  appendisNotExit('#todaynexttwo');
//    			  }else if(sign==3){
//    				  appendisNotExit('#todaynextthree');
//    			  }else if(sign==4){
//    				  appendisNotExit('#todaynextfour');
//    			  }else if(sign==5){
//    				  appendisNotExit('#todaynextfive');
//    			  }else if(sign==6){
//    				  appendisNotExit('#todaynextsix');
//    			  }
//	    	  }
//	      }
//	    });
//
//}
//
//
	//点击按钮时
	function clickbutton(){
		    $.ajax({
			      type:"POST",
			      //data:$('#form').serialize(),
			      url:baseUrl+'/outside/buyCard/getMemberCardList?offset=0&&limit=9',
			      success:function(data){
			    	  console.log(data.records);
			    	  //alert(data.records);
			    	  var list=data.records;
			    	  if(list!=null){
			    		  $('#memberCardDiv').empty();
			    		  appendMemberCardDiv('#memberCardDiv',list);

			    	  }
			      }
			});
	}
	//append
	function appendMemberCardDiv(id,list){
		//alert(list.length);
		for(var i=0;i<list.length;i++){
			  $(id).append(
					'<a href="'+baseUrl+'/outside/buyCard/detailPage?id='+list[i].id+'">'+
						'<div class="membership-card-item">'+
							'<div class="item-contanier">'+
								'<div class="item-img">'+
									'<img src="'+list[i].mcardimg+'" class="gold-card-membership">'+
								'</div>'+
								'<div flex="dir:top main:center" class="item-content">'+
									'<div class="item-content-title">'+list[i].membername+'</div>'+
									'<div class="item-content-subTitle">'+list[i].proinfo+'</div>'+
									'<div class="item-content-price"><small>¥</small> <span class="price">'+list[i].amountmoney+'</span></div>'+
								'</div>'+
					 		'</div>'+
					 	'</div>'+
					'</a>'
			  );
		}
	}
//
//	//添加不存在
//	function appendisNotExit(id){
//		  $(id).append(
//				  '<div class="empty-box"><div >'+
//				  '<img src="'+baseUrl+'/assets/images/kcbg.gif" class="empty-img">'+
//				  '<p class="empty-text">暂无课程 敬请期待</p>'+
//				  '</div></div>'
//		  );
//	}
//
//	//清空所有div
//	function emptyAllDiv(){
//		  $('#today').empty();
//		  $('#todaynextone').empty();
//		  $('#todaynexttwo').empty();
//		  $('#todaynextthree').empty();
//		  $('#todaynextfour').empty();
//		  $('#todaynextfive').empty();
//		  $('#todaynextsix').empty();
//	}
//
});
//
//
//
