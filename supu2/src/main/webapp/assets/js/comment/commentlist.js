$(function(){

	clickbutton();


	var offset=9;
	$(window).scroll(function(){

	/*	$(window).scrollTop();//这个方法是当前滚动条滚动的距离

		$(window).height();//获取当前窗体的高度

		$(document).height();//获取当前文档的高度*/
		   //var bot = 50;
		//bot是底部距离的高度
		if (( $(window).scrollTop()) >=
			(($(document).height()) - $(window).height())) {
			//alert("roll="+offset);

			getComment();
		}

	});


	//重置
	$('#resetclick').click(function(){
		//getIds();
    	$('#startTime').val("");
    	$('#endTime').val("");
    	$('#startlevel option').eq(0).prop("selected", true);
    	$('#coachs option').eq(0).prop("selected", true);
    	$('#stores option').eq(0).prop("selected", true);
	});
	//审核
	$(document).on('click','.iconfont',function(){
		var sign=$(this).data('sign');
		var id=$(this).data('id');
		if (sign==2) {
			var desc="确定这个评论通过？";
			var deleteSaleurl=baseUrl+'/user/comment/updStatus?ids='+id+'&&status=1';
			changeStatusById(desc,deleteSaleurl);
		}else if(sign==3){
			var desc="确定这个评论不通过？";
			var deleteSaleurl=baseUrl+'/user/comment/updStatus?ids='+id+'&&status=3';
			changeStatusById(desc,deleteSaleurl);
		}
	});



	$(document).on('click','.tongguo',function(){
		var sign=$(this).data('sign');
		if (sign==1) {
			var desc="确定这些评论通过？";
			var deleteSaleurl=baseUrl+'/user/comment/updStatus?ids='+getIds()+'&&status=1';
			changeStatusById(desc,deleteSaleurl);
		}else if(sign==2){
			var desc="确定这些评论不通过？";
			var deleteSaleurl=baseUrl+'/user/comment/updStatus?ids='+getIds()+'&&status=3';
			changeStatusById(desc,deleteSaleurl);
		}
	});
	//点击查询
	$('#searchclick').click(function(){

		clickbutton();
		$('#biaoji').val(9);
	});

	//点击待审核评价  点击审核不通过    点击审核通过
	$('.checkbutton').click(function(){
		var  status=$(this).data('id');
		$('#commentstatus').val(status);
		//查询
		clickbutton();
		$('#biaoji').val(9);
	});


	/**
	 * 获取评论  offset表示加载第几页数据
	 */
	function  getComment(){
		var a=$('#biaoji').val();
		if (a==9) {
			offset=a;
		}

	    $.ajax({
		      type:"GET",
		      data:$('#form').serialize(),
		      url:baseUrl+'/user/comment/getCommenList?start='+offset+'&&end=9',
		      success:function(data){
		    	  console.log(data);
		    	  if(data !=null){
		    		  var list=data.records;
		    		  var html="";

		    		  for(var i=0;i<list.length;i++){
		    			  if (list[i].status==2) {
							html='<div class="col-sm-2"><a class="btn btn-default btn-success iconfont" data-id='+list[i].id+' data-sign="2">通过</a> '+
									' <a class="btn btn-default iconfont"  data-id='+list[i].id+' data-sign="3">不通过</a></div>';
		    			  }
		    			  $('#waitAudit').append(
		    					  '<div class="form-group"><div class="col-sm-1 teal">'+
		    					  '<input name="" type="checkbox" value='+list[i].id+'></div>'+
		    					  '<div class="col-sm-11 col-border"><div class="col-sm-10"><div class="col-sm-12">'+
		    					  '<div class="col-sm-4">评价人：'+list[i].appraiserName+'</div><div class="col-sm-4">评价星级： '+list[i].startlevel+'</div><div class="col-sm-4">评价时间：'+moment(list[i].addtime).format('YYYY-MM-DD hh:mm:ss')+'</div></div>'+
		    					  '<div class="col-sm-12"><div class="col-sm-4">评价教练：'+list[i].coachName+'</div><div class="col-sm-4">评价门店： '+list[i].storeName+'</div>'+
		    					  '<div class="col-sm-4">课程类型：'+list[i].courseTypeName+'</div></div>'+
		    					  '<div class="col-sm-12"><div class="col-sm-6">评价内容：　'+list[i].content+'</div></div></div>'+
		    					  ''+html+''+
		    					  '</div></div>'

		    			  );
		    		  }

		    		offset=offset+9;
		    		$('#biaoji').val("");
		    	  }
		      }
		    });

	}

	//点击按钮时
	function clickbutton(){
		    $.ajax({
			      type:"GET",
			      data:$('#form').serialize(),
			      url:baseUrl+'/user/comment/getCommenList?start=0&&end=9',
			      success:function(data){
			    	  console.log(data);
			    	  if(data !=null){
			    		  $('#waitAudit').empty();
			    		  var list=data.records;
			    		  var html="";
			    		  for(var i=0;i<list.length;i++){
			    			  if (list[i].status==2) {
								html='<div class="col-sm-2"><a class="btn btn-default btn-success iconfont" data-id='+list[i].id+' data-sign="2">通过</a> '+
										' <a class="btn btn-default iconfont" data-id='+list[i].id+' data-sign="3">不通过</a></div>';
			    			  }
			    			  $('#waitAudit').append(
			    					  '<div class="form-group"><div class="col-sm-1 teal">'+
			    					  '<input name="" type="checkbox" value='+list[i].id+'></div>'+
			    					  '<div class="col-sm-11 col-border"><div class="col-sm-10"><div class="col-sm-12">'+
			    					  '<div class="col-sm-4">评价人：'+list[i].appraiserName+'</div><div class="col-sm-4">评价星级： '+list[i].startlevel+'</div><div class="col-sm-4">评价时间：'+moment(list[i].addtime).format('YYYY-MM-DD hh:mm:ss')+'</div></div>'+
			    					  '<div class="col-sm-12"><div class="col-sm-4">评价教练：'+list[i].coachName+'</div><div class="col-sm-4">评价门店： '+list[i].storeName+'</div>'+
			    					  '<div class="col-sm-4">课程类型：'+list[i].courseTypeName+'</div></div>'+
			    					  '<div class="col-sm-12"><div class="col-sm-6">评价内容：　'+list[i].content+'</div></div></div>'+
			    					  ''+html+''+
			    					  '</div></div>'

			    			  );
			    		  }
			    	  }
			      }
			});
	}


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
							$('#pass').modal('show');
							//location.reload();
						}else{
							$('#refuse').modal('show');
						}
					},
					error:function(data){
						$('#refuse').modal('show');
					}
				});

			}
		});
	}



	/**
	 * 拼接选中行id
	 */
	function getIds(){
		var idItems="";
		$("input[type='checkbox']:checked").each(function(){
			if ($(this).val()!="on") {
				idItems+=$(this).val()+',';
			}
		});
		return idItems.substring(0, idItems.length-1);
	}



});