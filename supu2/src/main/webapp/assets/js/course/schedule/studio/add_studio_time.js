$(function(){


//添加开始------------------------------------------------------------------------------------------------


	//单击添加，跳出弹出框
	$(document).on("click",".add_open",function(){

		var day=$(this).parent().siblings('input[name=day]').val();
		//alert(day);

		//将天 都赋值到弹出框中，便于提交

		$('#modal_add_day').val(day);


		//用于添加显示框显示   天
		$('#add_span_day').text(day);


		$('#add_winModal').modal('show');

	});



	//添加提交
	$('#add_form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		  submitHandler: function(form) {  //通过之后回调
			  var result =true;
			  var msg="请填写数据";
			  $('.add_starttime').each(function(){
				  var starttime=$(this).val();
				  var endtime=$(this).siblings('.add_endtime').val();
				  var classhour=$(this).siblings('.add_classhour').val();
				  if(starttime ==null || starttime==""){
					  msg="请将开始时间填写完整";
					  result=false;
				  	  return false;
				  }
				  if(endtime ==null || endtime==""){
					  msg="请将结束时间填写完整";
					  result=false;
				  	  return false;
				  }

				  if(classhour ==null || classhour==""){
					  msg="请将课时填写完整";
					  result=false;
					  return false;
				  }
				  //整数正则
				  var r = /^[0-9]*[1-9][0-9]*$/;
				  if(isNaN(classhour)||!r.test(classhour)){
					  msg="课时输入为整数数字";
					  result=false;
					  return false;
				  }

			  });
			  if(result){
				  add_Edit_delete_ajax(baseUrl+'/user/course/addStudioTimeSave',"#add_form");
			  }else{

				  $('#fail_message').text(msg);
	    		  $('#failure').modal('show');
		    	  return false;

			  }

		  }});

	/**
	 *添加一个新的 时间输入框
	 */
	$('.modal_add_new').click(function(){
	   var countTime=$('.modal_time').size();
	   var countBeforeTime=countTime-1;

	   $('.fr').append('<div class="choose-time modal_time">'+
               '上课时间：<input name="addCourseStudio['+countTime+'].starttime" id="startDate'+countTime+'" class="form-control add_starttime"'+
               'onFocus="WdatePicker({lang:\'zh-cn\',dateFmt:\'HH:mm\',minDate:\'#F{$dp.$D(\\\'endDate'+countBeforeTime+'\\\')}\',maxDate:\'#F{$dp.$D(\\\'endDate'+countTime+'\\\')}\' })" type="text" placeholder="请选择开始时间" style="width: 140px;display: inline-block">'+
               '&nbsp;至&nbsp;'+
               '<input name="addCourseStudio['+countTime+'].endtime" id="endDate'+countTime+'" class="form-control add_endtime" onFocus="WdatePicker({lang:\'zh-cn\',dateFmt:\'HH:mm\',minDate:\'#F{$dp.$D(\\\'startDate'+countTime+'\\\')}\'})" type="text" placeholder="请选择结束时间" style="width: 140px;display: inline-block">'+
               '&nbsp;&nbsp;&nbsp;'+
               '&nbsp;&nbsp;第 <input name="addCourseStudio['+countTime+'].classhour" class="form-control add_classhour" type="text" style="width: 50px;display: inline-block"/>课时'+
             /*  '&nbsp;<span class="reduce">-</span>'+*/
               '</div>');
	});

	//去除时间输入框，从最底层开始去除
	$('.reduce').click(function(){
		 var countTime=$('.modal_time').size();
		 if(countTime>1){
			 $(".fr :last-child.choose-time").remove();
		 }
	});


//添加结束-----------------------------------------------------------------------------------------------------------------





//编辑开始-----------------------------------------------------------------------------------------------------------------

	//单击编辑，跳出弹出框
	$(document).on("click",".edit_open",function(){
		var starttime=$(this).parent().siblings('input[name=starttime]').val();
		var endtime=$(this).parent().siblings('input[name=endtime]').val();
		var day=$(this).parent().parent().siblings('input[name=day]').val();
		//主键id
		var id=$(this).parent().siblings('input[name=id]').val();

		//课时
		var classhour=$(this).parent().siblings('input[name=classhour]').val();

		//将值都赋值到弹出框中，便于提交
		$('#modal_edit_id').val(id);
		$('#modal_edit_day').val(day);
		$('#modal_edit_starttime').val(starttime);
		$('#modal_edit_endtime').val(endtime);
		$('#modal_edit_classhour').val(classhour);


		$('#edit_winModal').modal('show');

	});


	/**
	 * 编辑表单 提交
	 */
	$('#edit_form').on('submit',function(ev){
		add_Edit_delete_ajax(baseUrl+'/user/course/editStudioTimeSave',"#edit_form");
   	    ev.preventDefault();
   	  });

//编辑结束---------------------------------------------------------------------------------------------------------------




//删除开始----------------------------------------------------------------------------------------------------------------

	  /**
	   * 点击删除按钮
	   */

		$(document).on("click",".delStudioTime",function(){
			//主键id
			var id=$(this).siblings('input[name=id]').val();
			 bootbox.confirm("<font size='4'>您确定要删除该时间吗？</font>", function(result) {
			 if(result){
				  add_Edit_delete_ajax(baseUrl+'/user/course/delStudioTime?id='+id,null);
			 }});
		});



//删除结束----------------------------------------------------------------------------------------------



//公共方法 开始-------------------------------------------------------------------------------------------

	  // ajax公共方法
	  function  add_Edit_delete_ajax(baseUrl,form_id){
		  $.ajax({
	   	      type:"POST",
	   	      url:baseUrl,
	   	      data:$(form_id).serialize(),
	   	      success:function(data){
	   	    	  console.log(data);

	   	    	  if(data.resultCode==200){
	   	    		  $('#success').modal('show');
	   	    	  }else{
	   	    		  if(data.message!="" && data.message!=null){
	   	    			  $('#fail_message').text(data.message);
	   	    		  }else{
	   	    			  $('#fail_message').text("操作失败");
	   	    		  }
	   	    		  $('#failure').modal('show');
	   	    	  }
	   	      }
	   	    });
	  }


	//操作成功页面   关闭之后的刷新操作
	 $('.close_modal').click(function(){
			  //课程id
			  var courseId=$('#courseId').val();

			  //日期
			  var date=$('#date').val();


			  //刷新当前页面
			  window.location.href=baseUrl+"/user/course/addStudioChooseTime?courseId="+courseId+"&&date="+date;

	});

//公共方法 结束---------------------------------------------------------------------------------------
});
