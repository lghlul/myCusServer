$(function(){
	
	
	$('.le-courses-box').click(function(){
		
		alert(baseUrl+'/outside/myCourse/courseDetail?id='+$(this).data("id")+'&type='+$(this).data("type"));
		window.location.href = baseUrl+'/outside/myCourse/courseDetail?id='+$(this).data("id")+'&type='+$(this).data("type");
	})
	
})

