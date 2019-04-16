$(function(){

    getPriCoachList();

    //查询已预约私教
    function getPriCoachList(){
        $.ajax({
		      type:"GET",
		      url:baseUrl+'/outside/priCoach/list',
		      success:function(data) {
		          var data ={
		              "total": 1,
                      "records": [
                      {
                          "id": 1,
                          "userId": 3685,
                          "courseId": 14,
                          "coachId": 9,
                          "totalClass": 100,
                          "buyTime": 1543507200000,
                          "status": 1,
                          "coachName": "王婉",
                          "sex": 0,
                          "phoneNumber": "13814054948",
                          "headImg": "/upload/1508935649577.jpg",
                          "courseName": "测试体验课，请勿购买",
                          "courseTitle": "测试体验课，请勿购买",
                          "courseEndTime": null,
                          "amount": null,
                          "useClass": 0
                      }
                  ],
                      "resultCode": null,
                      "message": null
              };
              }
        })
    }





    //查询最近门店
//	function getMinDistanceStore(lng,lat){
//		$.ajax({
//		      type:"GET",
//		      //data:$('#form').serialize(),
//		      url:baseUrl+'/outside/aboutClass/getNearestStore?lng='+lng+'&&lat='+lat+'',
//		      success:function(data){
////		    	  alert(data.records.storename);
//		    	  if (data!=null) {
//					var storeList=data.records;
//					for ( var i = 0; i < storeList.length; i++) {
//						if (i==0) {
//							$('#select_store').append(
//									'<option value='+storeList[i].id+' selected="selected">'+storeList[i].storename+'</option>'
//							);
//							$('#storeId').val(storeList[i].id);
//							$('#storeName').val(storeList[i].storename);
//							$('#distance').val(storeList[i].distance+"km");
//						}else{
//							$('#select_store').append(
//									'<option value='+storeList[i].id+' >'+storeList[i].storename+'</option>'
//							);
//						}
//					}
//					clickbutton();
//		    	  }
//		      }
//		});
//	}


	var loc;
    var isMapInit = false;
    //监听定位组件的message事件
    window.addEventListener('message', function(event) {
        loc = event.data; // 接收位置信息
        console.log('location', loc);
    	$('.lng').val(loc.lng);
    	$('.lat').val(loc.lat);
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
	    	$('.lng').val(latitude);
	    	$('.lat').val(longitude);
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


	  $('.clickspan').click(function(){
		  alert($(this).data("id"));
		  $('#form'+$(this).data("id")).submit();
	  });

});



