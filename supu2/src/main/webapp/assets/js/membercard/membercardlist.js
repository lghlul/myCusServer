$(function(){

//	var offset=9;
//	$(window).scroll(function(){

	/*	$(window).scrollTop();//这个方法是当前滚动条滚动的距离

		$(window).height();//获取当前窗体的高度

		$(document).height();//获取当前文档的高度*/
		   //var bot = 50;
		//bot是底部距离的高度
	/*	if (( $(window).scrollTop()) >=
			(($(document).height()) - $(window).height())) {
			//alert("roll="+offset);
			getMemberCard();
		}*/

//	});
	//删除
	$(document).on('click','.edit_dell',function(){
//		alert($(this).data('id'));
		var desc="确定删除这张会员卡？";
		//删除服务
		var deleteSaleurl=baseUrl+"/user/memberCard/deleteCard?id="+$(this).data('id');
		changeStatusById(desc,deleteSaleurl);
	});
	//改变状态
	function changeStatusById(desc,url){
		bootbox.confirm("<font size='4'>"+desc+"</font>", function(result) {
			if(result) {
				//var deleteUrl=delurl+id;
				$.ajax({
					type:'GET',
					url:url,
					success:function(data){
						if(data.resultCode==200){
							$('#success_del').modal('show');
							//location.reload();
						}else{
							if (data.message!=null || data.message!='') {
								$('#failure_del').modal('show');
								//location.reload();
							}else{
								alert("操作失败");
							}
//							alert(data.message);
						}
					},
					error:function(data){
						alert("操作失败");
					}
				});

			}
		});
	}
	/**
	 * 获取评论  offset表示加载第几页数据
	 */
/*	function  getMemberCard(){
	    $.ajax({
		      type:"GET",
		      url:baseUrl+'/user/memberCard/getMemberCardList?offset='+offset+'&&limit=9',
		      success:function(data){
		    	  //console.log(data);
		    	  var money;
		    	  if(data !=null){
		    		  for(var i=0;i<data.length;i++){
		    			  if (data[i].amountmoney==null) {
							money=0;
						}
		    			  $('#qiyongcard').before(
		    						'<div class="col-sm-4" style="padding:20px;">'+
		    						'<div class="row clearfix bk" >'+
		    						'<div class="col-sm-2" style="width: 10%;">'+
		    						'<div class="edit_dell"><i class="iconfont">&#xe637;</i></div></div>'+
		    						'<div class="col-sm-6"  style="width:80%;">'+
		    						'<div class="js_img"><img src="../../assets/images/jsk/hyk.png"/></div>'+
		    						'<div class="jg"><p>'+data[i].membername+'</p><span>'+data[i].amountmoney+'元/月</span></div></div>'+
		    						'<div class="col-sm-2" style="width: 10%;">'+
		    						'<div class="edit_ed"><a href='+baseUrl+'/user/memberCard/editPage?='+data[i].id+'><i class="iconfont">&#xe6e3;</i></a></div></div></div></div>');

		    		  }
			    	  offset=offset+9;
		    	  }
		      }
		    });

	}*/
});



