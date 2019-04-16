$(function(){
	//getMinDistanceStore(32,118);

    var code=400;

	var loc;
    var isMapInit = false;
    //监听定位组件的message事件
    window.addEventListener('message', function(event) {
        loc = event.data; // 接收位置信息
        console.log('location', loc);
         getMinDistanceStore(loc.lat,loc.lng);
        if(loc  && loc.module == 'geolocation') { //定位成功,防止其他应用也会向该页面post信息，需判断module是否为'geolocation'
            var markUrl = 'https://apis.map.qq.com/tools/poimarker' +
            '?marker=coord:' + loc.lat + ',' + loc.lng +
            ';title:我的位置;addr:' + (loc.addr || loc.city) +
            '&key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp';
            //给位置展示组件赋值
            document.getElementById('markPage').src = markUrl;
        } else { //定位组件在定位失败后，也会触发message, event.data为null
            //alert('定位失败');
		  	var  longitude=0.0;
		  	var  latitude=0.0;
	//      alert(err.message);


		  	getMinDistanceStore(longitude,latitude);

        }

        // 另一个使用方式
   /*     if (!isMapInit && !loc) { //首次定位成功，创建地图
            isMapInit = true;
            createMap(event.data);
        } else if (event.data) { //地图已经创建，再收到新的位置信息后更新地图中心点
            updateMapCenter(event.data);
        }*/

    }, false);
    //为防止定位组件在message事件监听前已经触发定位成功事件，在此处显示请求一次位置信息
    document.getElementById("geoPage").contentWindow.postMessage('getLocation', '*');

    //设置6s超时，防止定位组件长时间获取位置信息未响应
    setTimeout(function() {
        if(!loc) {
            //主动与前端定位组件通信（可选），获取粗糙的IP定位结果
        document.getElementById("geoPage")
            .contentWindow.postMessage('getLocation.robust', '*');
        }
    }, 6000); //6s为推荐值，业务调用方可根据自己的需求设置改时间，不建议太短

/*	  navigator.geolocation.getCurrentPosition( // 该函数有如下三个参数
			  function(position){ // 如果成果则执行该回调函数
			    	longitude = position.coords.longitude;
			    	latitude = position.coords.latitude;
			    	alert("百度="+longitude);
			    	alert(latitude);
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
		);
	  navigator.geolocation.getCurrentPosition(showMap);
	  function showMap(position) {
		  latitude = position.coords.latitude;
		  longitude = position.coords.longitude;

	  };*/


    //查询最近门店
	function getMinDistanceStore(lng,lat){
		if(code !=200){//code用于区分某些苹果系统多次加载问题

		$.ajax({
		      type:"GET",
		      async: false,
		      //data:$('#form').serialize(),
		      url:baseUrl+'/outside/personal/getMyStores?lng='+lng+'&&lat='+lat+'&&date='+ new Date()+'',
		      success:function(data){
		    	  if(data.resultCode==200){
			    	  if (data!=null) {
			    		  code=data.resultCode;
			    		  //alert(code);
			    		  datalist=data.records;

                          star = '<span></span><span></span>';
			    		  debugger;
			    		  $('#spancount').append('共<span id="spancount">'+datalist.length+'</span>家');
							for ( var i = 0; i < datalist.length; i++) {
                                star=  showStar(datalist[i].commentCount,datalist[i].totalStar);
								var status=null;
								var id= null;
								if(datalist[i].status==2){
									status="营业中";
									id="operating_state_y";
								}else{
									status="筹备中";
									id="operating_state_c";
								}
								$('#appenddiv').append(
										'<a href="/outside/personal/mystoresDetail?id='+datalist[i].id+'"><div class="select-store-list2">'+
										'<img src="'+datalist[i].storeimg+'" />'+
										'<div class="top clearfix">'+
											'<div class="right">'+
												'<div class="clearfix">'+
													'<div class="left">'+datalist[i].storename+'<span id='+id+'>'+status+'</span>'+'</div>'+
													'<div class="right"><span class="two">'+datalist[i].distance+'km</span></div>'+
												'</div>'+
												'<div>'+datalist[i].city+''+datalist[i].region+''+datalist[i].address+'</div>'+
											'</div>'+
										'</div><span class="stars">'+ star+ '</span>'+
										'<div class="bottom"></div>'+
									'</div></a>'
								);
							}
			    	  }
		    	  }
//		    	  console.log(data.records.distance);
//		    	  $('#neareststorename').text(data.records.storename);
//		    	  $('#nearestdistance').text("离你最近"+data.records.distance+"km");
//		    	  $('.one-single-file').text(data.records.province+data.records.city+data.records.region+data.records.address);
//		    	  alert(data.records.province+data.records.city+data.records.region);
		      }
			});
		}
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


	console.log($("#operating_state").html());
	if($("#operating_state").html() == "营业中"){
		$("#operating_state").css({"background-color":"#FF9421"});
	}else if($("#operating_state").html() == "筹备中"){
		$("#operating_state").css({"background-color":"#FF0000"});
	}
});



