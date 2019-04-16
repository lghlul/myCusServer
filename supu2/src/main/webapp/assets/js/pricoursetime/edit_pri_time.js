$(function(){

	/**
	 * 增加   每天的时间段
	 */
	$(document).on('click','.btn_add_day',function(){

		//查询时间段div的个数
		var index=$('.div_day').length;

		 //追加元素
		$(this).parent().parent().parent().append(
				'<div class="form-group div_day">'+
				'<div class="col-sm-6">'+
					'<div class="contractDay-menu">'+
						'<div  class="contractBeginDay time div_startTime">'+
							'<input type="text" id="coachTimeList['+index+'].startTime" name="coachTimeList['+index+'].startTime" class="form-control"'+
							'placeholder="开始时间" onclick="WdatePicker({dateFmt:\'HH:mm\',maxDate:\'#F{$dp.$D(\\\'coachTimeList['+index+'].endTime\\\')}\'});">'+
						'</div>'+
					'</div>'+
					'  - '+
					'<div class="contractDay-menu">'+
						'<div class="contractBeginDay time  div_endTime">'+
						'<input id="coachTimeList['+index+'].endTime" type="text" name="coachTimeList['+index+'].endTime" class="form-control"'+
							'placeholder="结束时间" onclick="WdatePicker({dateFmt:\'HH:mm\',minDate:\'#F{$dp.$D(\\\'coachTimeList['+index+'].startTime\\\')}\'});">'+
						'</div>'+
					'</div>'+
					' <button  class="btn btn_add_day" type="button">&nbsp;+&nbsp;</button>'+
					'<input type="hidden" name="coachTimeList['+index+'].type" value="2">'+
					' <button  class="btn btn_remove_day" type="button">&nbsp;-&nbsp;</button>'+
				'</div>'+
			'</div>'
		);
		/*$(this).parent().parent().parent().next().find('.div_startTime').append(txt_starttime);
		$(this).parent().parent().parent().next().find('.div_endTime').append(txt_endtime);*/
	});



	/**
	 * 移除每天
	 */
	$(document).on('click','.btn_remove_day',function(){
	/*	var index=$('.div_day').length;
		alert(index);
		//.var index=document.getElementsByTagName("mydiv").style.display="none";
		//当为1时，不能删除
		if(index==1){
			return ;
		}else{*/

			$(this).parent().parent().find('*').attr("disabled",true);
			$(this).parent().parent().hide();

	});


	/**
	 * 指定时间 添加时间段
	 */

	$(document).on('click','.btn_add_specDate',function(){
		//alert($('.border').length);
		var index=$('.div_total_time').length;

		//今天是几号
		var day=$(this).prev().val();


		//alert(day);
		$(this).parent().after(
				   '<div class="form-group div_total_time">'+
					'<div class="contractDay-menu">'+
						'<div class="contractBeginDay time">'+
							'<input type="text" id="coachTimeList['+index+'].startTime" name="coachTimeList['+index+'].startTime" class="form-control"'+
							'placeholder="开始时间" onclick="WdatePicker({dateFmt:\'HH:mm\',maxDate:\'#F{$dp.$D(\\\'coachTimeList['+index+'].endTime\\\')}\'});">'+
						'</div>'+
					'</div>'+
					'  -  '+
					'<div class="contractDay-menu">'+
						'<div class="contractBeginDay time">'+
							'<input type="text" id="coachTimeList['+index+'].endTime" name="coachTimeList['+index+'].endTime" class="form-control"'+
							'placeholder="结束时间" onclick="WdatePicker({dateFmt:\'HH:mm\',minDate:\'#F{$dp.$D(\\\'coachTimeList['+index+'].startTime\\\')}\'});">'+
						'</div>'+
					'</div>'+
					'<input type="hidden" name="coachTimeList['+index+'].type" value="1">'+
					'<input type="hidden" name="coachTimeList['+index+'].day" value="'+day+'">'+
				    '  <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>'+
					'  <button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>'+
			  	'</div>'
		);
	})


	/**
	 * 移除指定时间段
	 */
	$(document).on('click','.btn_remove_specDate',function(){
			$(this).parent().find('*').attr("disabled",true);
			$(this).parent().hide();

	});


	$('#form').on('submit',function(ev){
	   $.ajax({
	     type:"POST",
	     url:baseUrl+'/user/pricoursetime/editSave',
	     data:$('#form').serialize(),
	     success:function(data){
	   	  console.log(data);
	   	  if(data.resultCode==200){
	   		  $('#success').modal('show');
	   		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);

	   	  }else{
	   		  $('#failure').modal('show');

	   	  }

	     }
	   });
	   	ev.preventDefault();
 });










})