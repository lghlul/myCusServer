$(function(){

	$('.editTime').click(function(){
		var year=$(this).data("year");
		var month=$(this).data("month");
		window.location.href=baseUrl+"/user/course/editPageTime?courseId="+$('#courseId').val()+"&year="+year+"&month="+month;
	});


});