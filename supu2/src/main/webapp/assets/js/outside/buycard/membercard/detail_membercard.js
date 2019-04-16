$(function(){

/*    var longitude,latitude;
	navigator.geolocation.getCurrentPosition(function (position) {
        longitude = position.coords.longitude;
        latitude = position.coords.latitude;
//        alert(longitude);
//        alert(latitude);
        getMinDistanceStore(longitude,latitude);
    });*/
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

    //查询最近门店
	function getMinDistanceStore(lng,lat){
		$.ajax({
		      type:"GET",
		      //data:$('#form').serialize(),
		      url:baseUrl+'/outside/buyCard/getNearestStore?lng='+lng+'&&lat='+lat+'&&date='+new Date()+'',
		      success:function(data){
		    	  console.log(data.records.distance);
		    	  $('#neareststorename').text(data.records.storename);
		    	  $('#nearestdistance').text("离你最近"+data.records.distance+"km");
		    	  $('.one-single-file').text(data.records.province+data.records.city+data.records.region+data.records.address);
//		    	  alert(data.records.province+data.records.city+data.records.region);
		      }
		});
	}

});



