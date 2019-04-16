$(function(){

	//开业
	$('#opendoor').click(function(){
		var desc="确定开业？";
		//删除服务
		var opendoorurl=baseUrl+"/user/store/changeStatusByList?idItems="+$('#id_state').val()+"&status=2";
		changeStatusById(desc,opendoorurl);

	});
    //暂停
	$('#stopdoor').click(function(){
		var desc="确定暂停？";
		//删除服务
		var opendoorurl=baseUrl+"/user/store/changeStatusByList?idItems="+$('#id_state').val()+"&status=3";
		changeStatusById(desc,opendoorurl);

	});
	//闭馆
	$('#closedoor').click(function(){
		var desc="确定闭馆？";
		//删除服务
		var opendoorurl=baseUrl+"/user/store/changeStatusByList?idItems="+$('#id_state').val()+"&status=4";
		changeStatusById(desc,opendoorurl);

	});
});



function changeStatusById(desc,url){
bootbox.confirm("<font size='4'>"+desc+"</font>", function(result) {
		if(result) {
			//var deleteUrl=delurl+id;
			$.ajax({
				type:'post',
				url:url,
				success:function(data){
					if(data.resultCode==200){
						//alert("操作成功");
						  $('#success').modal('show');
					}else{
						//alert("操作失败");
						 $('#failure').modal('show');

					}
				},
				error:function(data){
					 $('#failure').modal('show');

				}
			});

		}
	});
}
