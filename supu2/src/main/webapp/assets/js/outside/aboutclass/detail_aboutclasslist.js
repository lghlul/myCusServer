$(function(){

	grade();//获取评论的人数和品均分数

    getCommentList();

	
//课程详细页面获取课程的评论
$('#sendcomment').click(function(){
	$.ajax({
	    type:"GET",
	    data:{
	    	"source":$("#source").val(),
	    	"status":$("#status").val(),
	    	"startlevel":$("#startlevel").val(),
	    	"sourceID":$("#sourceID").val(),
	    	"content":$("#contentText").val()
	    },
	    url:baseUrl+'/user/comment/insertComment',
	    success:function(data, textStatus, request){
	  	  alert(data);
	    }
	});
});
	/**
	 * 预约成功后,利用form表单提交post
	 */
	$('.success_sure_cancel').click(function(){
		$("#courseGroupform").submit();

	})

$('#clicklocation').click(function(){
	$.ajax({
	      type:"POST",
	      data:$('#form').serialize(),
	      url:baseUrl+'/outside/personal/queue',
	      success:function(data, textStatus, request){
//	    	  alert(request.getResponseHeader('sessionstatus'));
	    	  if (request.getResponseHeader('sessionstatus')=="unlogin") {
	    		  window.location=baseUrl+"/outside/login";
	    	  }else{
		    	  if (data.resultCode==200) {
//		    		  location.reload();
		    			$('#successMassage_form_submit').text("");
						$('#successMassage_form_submit').text('预约成功！');
						$('#alertquenen_success_form_submit').show();
						$('.success_form_submit').show();
						//$("#courseGroupform").submit();
						//window.location.href=baseUrl+"/outside/aboutClass/courseGroupDetail?id="+$("#id").val()+"&storeId="+$("#storeid").val()+"&date="+$("#appointtime").val();
		    	  }else if(data.resultCode==400){
		    		  if (data.message==1) {
		    			$('#alertMassage').text("");
						$('#alertMassage').text('您已经预约！');
						$('#alertquenen_succfal').show();
						$('.succfal').show();
					}else if(data.message==2){
		    		/*	$('#alertMassage').text("");
						$('#alertMassage').text('请先购买会员卡！');
						$('#alertquenen_succfal').show();
						$('.succfal').show();*/
						$('.queuemask').show();
						$('#alertquenen').show();
						//$('#alertMassage').text('请先购买会员卡！');
					}
		    		 else if(data.message==4){
		    			$('#alertMassage').text("");
						$('#alertMassage').text('人数已满，不能排队！');
						$('#alertquenen_succfal').show();
						$('.succfal').show();
					}
		    		 else if(data.message==79){
			    			$('#alertMassage').text("");
							$('#alertMassage').text('已过期，请提前一小时预约！');
							$('#alertquenen_succfal').show();
							$('.succfal').show();
						}
		    		  //alert("您已经预约");
	    	  }

	    	  }
	      }
	});
});

	//点击预约
	$('.REQueue').click(function(){
		var id=$(this).data("id");
		if (id==4) {
			$('#alertMassage').text("");
			$('#alertMassage').text('人数已满，不能排队！');
			$('#alertquenen_succfal').show();
			$('.succfal').show();
		}
		$('#successMassage').text("");
		$('#successMassage').text('您确定预约此团课吗？');
		$('#alertquenen_success').show();
		$('.success').show();
	});
});

// 评价来源标识：1私教课2团课3门店4私教
function getCommentList(){
    $.ajax({
        type:"GET",
        url:baseUrl+"/outside/comment/getCommenListPublic?source=2&sourceID="+sourceID+"&limitstart=0&limitend=10",
        success:function(data){
            if(data.resultCode == "200"){
                showList(data.records);
            }
        }
    })
}

function showList(list){
    var htmlString = "";
    var star="";
    for(var i =0;i<list.length;i++){
        if(list[i].startlevel == 5){
            star = '<span></span><span></span><span></span><span></span><span></span>';
        }
        if(list[i].startlevel == 4){
            star = '<span></span><span></span><span></span><span></span>';
        }
        if(list[i].startlevel == 3){
            star = '<span></span><span></span><span></span>';
        }
        if(list[i].startlevel == 2){
            star = '<span></span><span></span>';
        }
        if(list[i].startlevel == 1){
            star = '<span></span>';
        }
        htmlString+='<div class="item"><img src="'+list[i].head+'" alt="">' +
            '<div class="right"><p>'+list[i].userName+'</p><span> <div class="stars">'+ star+ '</div></span>' +
            '<p>'+list[i].content+'</p>' +
            '<p>'+Time.getFormatTime(list[i].addtime)+'</p></div></div>';
    }
    $(".commentList").html(htmlString);
}

function grade(){
	$.ajax({
	    type:"GET",
	    data:{
	    	"source":$("#source").val(),//机构识别,课程的识别ID
	    	"sourceID":$("#sourceID").val()//当前机构中的ID，当前是课程
	    },
	    url:baseUrl+'/user/comment/getCommentgradePN',
	    success:function(jsonDate){
//	    	alert(jsonDate.resultCode);
//	    	alert(jsonDate.records.count);
	    	
//	    	alert($("#source").val()+"--"+$("#sourceID").val())
	    	$("#count").html(jsonDate.records.count)
	    	$("#number").html(jsonDate.records.number)
	    	      
	    }
	});

}
