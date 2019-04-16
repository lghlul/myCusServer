$(function(){
var currenturl = window.location.href;
    $.ajax({
        type:"GET",
        url:baseUrl+'/ticket/getWXConfig?url='+currenturl,
        success:function(data) {
            wx.config({
                debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: data.openId, // 必填，公众号的唯一标识
                timestamp: data.timestamp , // 必填，生成签名的时间戳
                nonceStr: data.nonceStr, // 必填，生成签名的随机串
                signature: data.signature,// 必填，签名，见附录1
                jsApiList: ['checkJsApi',
                    'chooseImage',
                    'previewImage',
                    'uploadImage',
                    'downloadImage',
                    'getNetworkType',//网络状态接口
                    'openLocation',//使用微信内置地图查看地理位置接口
                    'getLocation' //获取地理位置接口
                ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });
            wx.ready(function() {

                wx.getLocation({
                    type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                    success: function (res) {
                        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                        var speed = res.speed; // 速度，以米/每秒计
                        var accuracy = res.accuracy; // 位置精度
                        getMinDistanceStore(latitude,longitude);
                    }
                });
            })
        }
        })

	//下拉加载
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

			getCourseGroup();
		}

	});

    //查询最近门店
	function getMinDistanceStore(lng,lat){
		$.ajax({
		      type:"GET",
		      //data:$('#form').serialize(),
		      url:baseUrl+'/outside/aboutClass/getNearestStore?lng='+lng+'&&lat='+lat+'&&date='+ new Date()+'',
		      success:function(data){
//		    	  alert(data.records.storename);
		    	  if (data!=null) {
					var storeList=data.records;
					for ( var i = 0; i < storeList.length; i++) {
						if (i==0) {
							$('#storeId').val(storeList[i].id);
							$('#storeName').val(storeList[i].storename);
							$('#cityid').text(storeList[i].storename);
							$('#distance').val(storeList[i].distance+"km");
							$('#select_store').append(
		                            '<a data-v-222004fa="" class="mint-cell card-item storeselect action" data-id='+storeList[i].id+' data-name='+storeList[i].storename+'>'+
		                                '<div class="mint-cell-left"></div>'+
		                                '<div class="mint-cell-wrapper">'+
		                                    '<div class="mint-cell-title">'+
		                                        '<span class="mint-cell-text">'+storeList[i].storename+'</span>'+
		                                    '</div>'+
		                                    '<div class="mint-cell-value"><span></span></div>'+
		                                '</div>'+
		                                '<div class="mint-cell-right"></div>'+
		                            '</a>'
								);
						}else{
							$('#select_store').append(
		                            '<a data-v-222004fa="" class="mint-cell card-item storeselect" data-id='+storeList[i].id+' data-name='+storeList[i].storename+'>'+
		                                '<div class="mint-cell-left"></div>'+
		                                '<div class="mint-cell-wrapper">'+
		                                    '<div class="mint-cell-title">'+
		                                        '<span class="mint-cell-text storeselect" data-id='+storeList[i].id+'>'+storeList[i].storename+'</span>'+
		                                    '</div>'+
		                                    '<div class="mint-cell-value"><span></span></div>'+
		                                '</div>'+
		                                '<div class="mint-cell-right"></div>'+
		                            '</a>'
								);
						}

					}
					clickbutton();
		    	  }
		      }
		});
	}
/*  navigator.geolocation.getCurrentPosition( // 该函数有如下三个参数
	  function(position){ // 如果成果则执行该回调函数
	    	longitude = position.coords.longitude;
	    	latitude = position.coords.latitude;
	    	getMinDistanceStore(longitude,latitude);
	  }, function(err){ // 如果失败则执行该回调函数
		  	var  longitude=0.0;
		  	var  latitude=0.0;
	//      alert(err.message);
	      getMinDistanceStore(longitude,latitude);
	  }, { // 附带参数
	      enableHighAccuracy: false, // 提高精度(耗费资源)
	      timeout: 1000, // 超过timeout则调用失败的回调函数
	      maximumAge: 1000 // 获取到的地理信息的有效期，超过有效期则重新获取一次位置信息
	  }
);*/








/**
 * 切换 门店名称
 */

$(document).on('click','.storeselect',function(){
			//门店id
			$('#storeId').val($(this).data('id'));

			//门店名称
			$('#cityid').text($(this).data('name'));

			//门店名称
			$('#storeName').val($(this).data('name'));
//			alert($(this).text());
			//获取门店距离
			getMinDisStore();

			//清空课程 重新加载
			emptyAllDiv();
			//查询
			clickbutton();
			$('#biaojiinput').val(9);

});

//切换日期
	$(document).on("click",'.mint-tab-item',function(){
        $('#getSelectDate').val($(this).data('date'));
        $('#getSelectWeek').val($(this).data('week'));
        $('#getSign').val($(this).data('id'));
        $('#weekinput').val($(this).data('data'));
        //查询
        clickbutton();
        $('#biaojiinput').val(9);
	})

//点击进入团课详情  post提交方式
$(document).on('click','.clickgrouplesson',function(){

	if ($(this).data("status")==8) {
		return false;
	}else{
		//开始时间
		$('#startTime').val($(this).find('.startTime').val());
		//结束时间赋值，传入后台
		$('#endTime').val($(this).find('.endTime').val());

		$('#id').val($(this).data("id"));
		//alert($('#id').val());
		$("#form").submit();
	}
});




/**
 * 获取团课  offset表示加载第几页数据
 */
function  getCourseGroup(){
	var a=$('#biaoji').val();
	if (a==9) {
		offset=a;
	}

    $.ajax({
	      type:"GET",
	      data:$('#form').serialize(),
	      url:baseUrl+'/outside/aboutClass/getAboutClass?start='+offset+'&&end=9',
	      success:function(data){
	    	  console.log(data.records);
	    	  //alert(data.records);
	    	  var sign=$('#getSign').val();
	    	  var list=data.records;
	    	  //alert(sign);
	    	  if (list!=null) {
		    	  if(list.length>0){
		    		  emptyAllDiv();
	    			  if (sign==0) {
	    				  appendGroupDiv('#today',list);
	    			  }else if(sign==1){
	    				  appendGroupDiv('#todaynextone',list);
	    			  }else if(sign==2){
	    				  appendGroupDiv('#todaynexttwo',list);
	    			  }else if(sign==3){
	    				  appendGroupDiv('#todaynextthree',list);
	    			  }else if(sign==4){
	    				  appendGroupDiv('#todaynextfour',list);
	    			  }else if(sign==5){
	    				  appendGroupDiv('#todaynextfive',list);
	    			  }else if(sign==6){
	    				  appendGroupDiv('#todaynextsix',list);
	    			  }
	    			  offset=offset+9;
	    			  $('#biaoji').val("");
		    	  }else if(list.length==0){
	    			  if (sign==0) {
	    				  appendisNotExit('#today');
	    			  }else if(sign==1){
	    				  appendisNotExit('#todaynextone');
	    			  }else if(sign==2){
	    				  appendisNotExit('#todaynexttwo');
	    			  }else if(sign==3){
	    				  appendisNotExit('#todaynextthree');
	    			  }else if(sign==4){
	    				  appendisNotExit('#todaynextfour');
	    			  }else if(sign==5){
	    				  appendisNotExit('#todaynextfive');
	    			  }else if(sign==6){
	    				  appendisNotExit('#todaynextsix');
	    			  }
		    	  }
	    	  }
	      }
	    });

}


	//点击按钮时
	function clickbutton(){
		    $.ajax({
			      type:"POST",
			      data:$('#form').serialize(),
			      url:baseUrl+'/outside/aboutClass/getAboutClass?start=0&&end=9',
			      success:function(data){
			    	  console.log(data.records);
			    	  //alert(data.records);
			    	  var sign=$('#getSign').val();
			    	  var list=data.records;
			    	  //alert(sign);
			    	  if (list!=null) {
				    	  if(list.length>0){
				    		  emptyAllDiv();
			    			  if (sign==0) {
			    				  appendGroupDiv('#today',list,sign);
			    			  }else if(sign==1){
			    				  appendGroupDiv('#todaynextone',list,sign);
			    			  }else if(sign==2){
			    				  appendGroupDiv('#todaynexttwo',list,sign);
			    			  }else if(sign==3){
			    				  appendGroupDiv('#todaynextthree',list,sign);
			    			  }else if(sign==4){
			    				  appendGroupDiv('#todaynextfour',list,sign);
			    			  }else if(sign==5){
			    				  appendGroupDiv('#todaynextfive',list,sign);
			    			  }else if(sign==6){
			    				  appendGroupDiv('#todaynextsix',list,sign);
			    			  }
				    	  }else if(list.length==0){
				    		  $('.empty-box').remove();
			    			  if (sign==0) {
			    				  appendisNotExit('#today');
			    			  }else if(sign==1){
			    				  appendisNotExit('#todaynextone');
			    			  }else if(sign==2){
			    				  appendisNotExit('#todaynexttwo');
			    			  }else if(sign==3){
			    				  appendisNotExit('#todaynextthree');
			    			  }else if(sign==4){
			    				  appendisNotExit('#todaynextfour');
			    			  }else if(sign==5){
			    				  appendisNotExit('#todaynextfive');
			    			  }else if(sign==6){
			    				  appendisNotExit('#todaynextsix');
			    			  }
				    	  }
			    	  }
			      }
			});
	}
	//append
	function appendGroupDiv(id,list,sign){
		var html="";
		if (sign==0) {
			html=$('#weekinput').val();
		}else if(sign==1){
			html=$('#weekinput').val();
		}else if(sign==2){
			html=$('#weekinput').val();
		}else if(sign==3){
			html=$('#weekinput').val();
		}else if(sign==4){
			html=$('#weekinput').val();
		}else if(sign==5){
			html=$('#weekinput').val();
		}else if(sign==6){
			html=$('#weekinput').val();
		}
		//alert(id);
		//alert(list.length);
		for(var i=0;i<list.length;i++){
			var st=list[i].courseStatus;
			var status=null;
            star=  showStar(list[i].commentCount,list[i].totalStar);
			if(st==1){
				status="可预约";
			}else if(st==2){
				status="需排队 ";
			}
			else if(st==3){
				status="紧张";
			}
			else if(st==4){
				status="不可排队";//临近课程开始时间，不可排队
			}
			else if(st==5){
				status="不可排队";//课程进行中，不可排队
			}
			else if(st==6){
				status="人数已满";
			}else if(st==7){
				status="未开放";
			}else if(st==8){
				status="已结束";
			}
			  $(id).append(
					  '<a class="clickgrouplesson" data-id='+list[i].id+' data-status='+st+'>'+
					  '<input type="hidden" class="startTime" value='+list[i].startTime+'><input type="hidden" class="endTime" value='+list[i].endTime+'>'+
					  '<div data-v-217fef9e="" class="class-box item" style="background-image: url('+list[i].courseimg+');">'+
				      '<span class="stars">'+star+'</span>'+
					  '<div data-v-217fef9e="" class="blanket"></div>'+
					  '<div data-v-217fef9e="" class="class-context">'+
					  '<div data-v-217fef9e="" class="class-status" style="background-color: rgb(255, 78, 0); color: rgb(255, 255, 255);">'+status+'</div>'+
					  '<div data-v-217fef9e="" class="class-text">'+
					  '<div data-v-217fef9e="" class="class-name">'+list[i].coursename+' · <small data-v-217fef9e="">'+list[i].coachnames+'</small></div>'+
					  '<div data-v-217fef9e="" class="class-store">'+html+' '+list[i].startTime+'-'+list[i].endTime+'/'+$('#storeName').val()+'/'+$('#distance').val()+'</div>'+
					  '</div></div></div></a>'
			  );
		}
	}

	//添加不存在
	function appendisNotExit(id){
		  $(id).append(
				  '<div class="empty-box"><div >'+
				  '<img src="'+baseUrl+'/assets/images/kcbg.gif" class="empty-img">'+
				  '<p class="empty-text">即将开放     敬请期待</p>'+
				  '</div></div>'
		  );
	}

	//清空所有div
	function emptyAllDiv(){
		  $('#today').empty();
		  $('#todaynextone').empty();
		  $('#todaynexttwo').empty();
		  $('#todaynextthree').empty();
		  $('#todaynextfour').empty();
		  $('#todaynextfive').empty();
		  $('#todaynextsix').empty();
	}
    //查询最近门店
	function getMinDisStore(){
		navigator.geolocation.getCurrentPosition(function (position) {
            longitude = position.coords.longitude;
            latitude = position.coords.latitude;
            ajax1(longitude,latitude);

        });
	}

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

	function ajax1(lng,lat){
		$.ajax({
		      type:"GET",
		      //data:$('#form').serialize(),
		      url:baseUrl+'/outside/aboutClass/getStoreDis?lng='+lng+'&&lat='+lat+'&storeId='+$('#storeId').val()+'',
		      success:function(data){
		    	  if (data!=null) {
					var storeList=data.records;
					$('#distance').val(storeList.distance+"km");
					//alert(storeList.distance+"km");
		    	  }
		      }
		});
	}


});



