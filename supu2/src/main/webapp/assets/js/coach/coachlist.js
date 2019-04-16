$(function(){
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

			getCoach();
		}

	});


	//重置
	$('#resetCoach').click(function(){
    	$('#serachcoachname').val("");

    	$('#select_sex option').eq(0).prop("selected", true);
    	$('#select_goodat option').eq(0).prop("selected", true);
    	$('#select_stores option').eq(0).prop("selected", true);
    	$('#select_coachStatus option').eq(0).prop("selected", true);
	});
	//删除
	$(document).on('click','.iconfont',function(){
		var sign=$(this).data('sign');
		var id=$(this).data('id');
		if (sign==0) {
			var desc="确定删除这个教练？";
			var deleteSaleurl=baseUrl+'/user/coach/updateCoachStatus?id='+id+'&&status=0';
			changeStatusById(desc,deleteSaleurl);
		}else if(sign==1){
			var desc="确定审核这个教练？";
			var deleteSaleurl=baseUrl+'/user/coach/updateCoachStatus?id='+id+'&&status=1';
			changeStatusById(desc,deleteSaleurl);
		}else if(sign==2){
			var desc="确定与这个教练终止合作？";
			var deleteSaleurl=baseUrl+'/user/coach/updateCoachStatus?id='+id+'&&status=2';
			changeStatusById(desc,deleteSaleurl);
		}else if(sign==3){
			var desc="确定与这个教练恢复合作？";
			var deleteSaleurl=baseUrl+'/user/coach/updateCoachStatus?id='+id+'&&status=1';
			changeStatusById(desc,deleteSaleurl);
		}
	});

	$('#searchCoach').click(function(){
		if ($('#select_sex option:selected').val()=="" && $('#select_stores option:selected').val()=="" && $('#select_goodat option:selected').val()=="" && $('#select_coachStatus option:selected').val()=="" && $('#serachcoachname').val()=="") {
			location.reload();
		}else{
			$('#cleardiv').empty();
//			var start=0;
		    $.ajax({
			      type:"GET",
			      data:$('#coachform').serialize(),
			      url:baseUrl+'/user/coach/getCoachList?offset=0&&limit=9',
			      success:function(data){
			    	  //console.log(data);
			    	  if(data !=null){
			    		  for(var i=0;i<data.length;i++){
			    			  if (data[i].status==1) {
			    				  $('#cleardiv').append(
			    						  '<div class="col-sm-3" style="padding:20px;">'+
			    						  '<div class="jlk" >'+
			    						  '<div class="jlk-l">'+
			    						  '<img src='+data[i].image+' width="154"/></div>'+
			    						  '<div class="jlk-r">'+
			    						  '<h1>'+data[i].coachname+'<span><input class="btn btn-xs btn-yellow" type="button" value="合作中"></span></h1>'+
			    						  '<p>'+data[i].goodat+'</p></div></div>'+
			    						  '<div class="jlk-mask a0 fadeIn" ><div class="jlk-div">'+
			    						  '<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href='+baseUrl+'/user/coach/detailPage?id='+data[i].id+'><i class="iconfont">&#xe607;</i></a></span>'+
			    						  '<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="终止"><i class="iconfont" data-sign="2" data-id='+data[i].id+'>&#xe662;</i></span>'+
			    						  '<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href='+baseUrl+'/user/coach/editPage?id='+data[i].id+'><i class="iconfont">&#xe630;</i></a></span>'+
			    						  '</div></div></div>');
			    			  }else if(data[i].status==2){
			    				  $('#cleardiv').append(
			    						  '<div class="col-sm-3" style="padding:20px;">'+
			    						  '<div class="jlk" >'+
			    						  '<div class="jlk-l">'+
			    						  '<img src='+data[i].image+' width="154"/></div>'+
			    						  '<div class="jlk-r">'+
			    						  '<h1>'+data[i].coachname+'<span><input class="btn btn-xs btn-yellow" type="button" value="已终止"></span></h1>'+
			    						  '<p>'+data[i].goodat+'</p></div></div>'+
			    						  '<div class="jlk-mask a0 fadeIn" ><div class="jlk-div">'+
			    						  '<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href='+baseUrl+'/user/coach/detailPage?id='+data[i].id+'><i class="iconfont">&#xe607;</i></a></span>'+
			    						  '<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="再次合作"><i class="iconfont" data-sign="3" data-id='+data[i].id+'>&#xe627;</i></span>'+
			    						  '<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href='+baseUrl+'/user/coach/editPage?id='+data[i].id+'><i class="iconfont">&#xe630;</i></a></span>'+
			    						  '<span  class="jsk_del a4 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="iconfont" data-sign="0" data-id='+data[i].id+'>&#xe637;</i></span'+
			    						  '</div></div></div>');
			    			  }else if(data[i].status==3){
			    				  $('#cleardiv').append(
			    						  '<div class="col-sm-3" style="padding:20px;">'+
			    						  '<div class="jlk" >'+
			    						  '<div class="jlk-l">'+
			    						  '<img src='+data[i].image+' width="154"/></div>'+
			    						  '<div class="jlk-r">'+
			    						  '<h1>'+data[i].coachname+'<span><input class="btn btn-xs btn-yellow" type="button" value="待审核"></span></h1>'+
			    						  '<p>'+data[i].goodat+'</p></div></div>'+
			    						  '<div class="jlk-mask a0 fadeIn" ><div class="jlk-div">'+
			    						  '<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href='+baseUrl+'/user/coach/detailPage?id='+data[i].id+'><i class="iconfont">&#xe607;</i></a></span>'+
			    						  '<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="审核"><i class="iconfont" data-sign="1" data-id='+data[i].id+'>&#xe627;</i></span>'+
			    						  '<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href='+baseUrl+'/user/coach/editPage?id='+data[i].id+'><i class="iconfont">&#xe630;</i></a></span>'+
			    						  '<span  class="jsk_del a4 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="iconfont" data-sign="0" data-id='+data[i].id+'>&#xe637;</i></span'+
			    						  '</div></div></div>');
			    			  }
			    		  }
//			    		  start=start+9;
			    	  }
			      }
			    });
		}
	});

	/**
	 * 获取评论  offset表示加载第几页数据
	 */
	var a=9;
	function  getCoach(){

		if (!$('#select_sex option:selected').val()=="" || !$('#select_stores option:selected').val()=="" || !$('#select_goodat option:selected').val()=="" || !$('#select_coachStatus option:selected').val()=="" || !$('#serachcoachname').val()=="") {
			offset=a;
			a=a+9;
		}
	    $.ajax({
		      type:"GET",
		      data:$('#coachform').serialize(),
		      url:baseUrl+'/user/coach/getCoachList?offset='+offset+'&&limit=9',
		      success:function(data){
		    	  //console.log(data);
		    	  if(data !=null){
		    		  for(var i=0;i<data.length;i++){
		    			  if (data[i].status==1) {
		    				  $('#cleardiv').append(
		    						  '<div class="col-sm-3" style="padding:20px;">'+
		    						  '<div class="jlk" >'+
		    						  '<div class="jlk-l">'+
		    						  '<img src='+data[i].image+' width="154"/></div>'+
		    						  '<div class="jlk-r">'+
		    						  '<h1>'+data[i].coachname+'<span><input class="btn btn-xs btn-yellow" type="button" value="合作中"></span></h1>'+
		    						  '<p>'+data[i].goodat+'</p></div></div>'+
		    						  '<div class="jlk-mask a0 fadeIn" ><div class="jlk-div">'+
		    						  '<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href='+baseUrl+'/user/coach/detailPage?id='+data[i].id+'><i class="iconfont">&#xe607;</i></a></span>'+
		    						  '<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="终止"><i class="iconfont" data-sign="2" data-id='+data[i].id+'>&#xe662;</i></span>'+
		    						  '<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href='+baseUrl+'/user/coach/editPage?id='+data[i].id+'><i class="iconfont">&#xe630;</i></a></span>'+
		    						  '</div></div></div>');
		    			  }else if(data[i].status==2){
		    				  $('#cleardiv').append(
		    						  '<div class="col-sm-3" style="padding:20px;">'+
		    						  '<div class="jlk" >'+
		    						  '<div class="jlk-l">'+
		    						  '<img src='+data[i].image+' width="154"/></div>'+
		    						  '<div class="jlk-r">'+
		    						  '<h1>'+data[i].coachname+'<span><input class="btn btn-xs btn-yellow" type="button" value="已终止"></span></h1>'+
		    						  '<p>'+data[i].goodat+'</p></div></div>'+
		    						  '<div class="jlk-mask a0 fadeIn" ><div class="jlk-div">'+
		    						  '<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href='+baseUrl+'/user/coach/detailPage?id='+data[i].id+'><i class="iconfont">&#xe607;</i></a></span>'+
		    						  '<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="再次合作"><i class="iconfont" data-sign="3" data-id='+data[i].id+'>&#xe627;</i></span>'+
		    						  '<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href='+baseUrl+'/user/coach/editPage?id='+data[i].id+'><i class="iconfont">&#xe630;</i></a></span>'+
		    						  '<span  class="jsk_del a4 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="iconfont" data-sign="0" data-id='+data[i].id+'>&#xe637;</i></span'+
		    						  '</div></div></div>');
		    			  }else if(data[i].status==3){
		    				  $('#cleardiv').append(
		    						  '<div class="col-sm-3" style="padding:20px;">'+
		    						  '<div class="jlk" >'+
		    						  '<div class="jlk-l">'+
		    						  '<img src='+data[i].image+' width="154"/></div>'+
		    						  '<div class="jlk-r">'+
		    						  '<h1>'+data[i].coachname+'<span><input class="btn btn-xs btn-yellow" type="button" value="待审核"></span></h1>'+
		    						  '<p>'+data[i].goodat+'</p></div></div>'+
		    						  '<div class="jlk-mask a0 fadeIn" ><div class="jlk-div">'+
		    						  '<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href='+baseUrl+'/user/coach/detailPage?id='+data[i].id+'><i class="iconfont">&#xe607;</i></a></span>'+
		    						  '<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="审核"><i class="iconfont" data-sign="1" data-id='+data[i].id+'>&#xe627;</i></span>'+
		    						  '<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href='+baseUrl+'/user/coach/editPage?id='+data[i].id+'><i class="iconfont">&#xe630;</i></a></span>'+
		    						  '<span  class="jsk_del a4 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="iconfont" data-sign="0" data-id='+data[i].id+'>&#xe637;</i></span'+
		    						  '</div></div></div>');
		    			  }

		    		  }

		    		offset=offset+9;

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
							$('#success_caozuo').modal('show');
							//location.reload();
						}else{
							$('#failure_caozuo').modal('show');
						}
					},
					error:function(data){
						$('#failure_caozuo').modal('show');
					}
				});

			}
		});
	}
});