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
							'<input id="coachTimeList['+index+'].startTime1" type="text" name="coachTimeList['+index+'].startTime" class="form-control"'+
							'placeholder="开始时间" onclick="WdatePicker({dateFmt:\'HH:mm\',maxDate:\'#F{$dp.$D(\\\'coachTimeList['+index+'].endTime1\\\')}\'});">'+
						'</div>'+
					'</div>'+
					'  - '+
					'<div class="contractDay-menu">'+
						'<div  class="contractBeginDay time  div_endTime">'+
						'<input id="coachTimeList['+index+'].endTime1" type="text" name="coachTimeList['+index+'].endTime" class="form-control"'+
							'placeholder="结束时间" onclick="WdatePicker({dateFmt:\'HH:mm\',minDate:\'#F{$dp.$D(\\\'coachTimeList['+index+'].startTime1\\\')}\'});">'+
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
			//$(this).parent().parent().hide();

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
							'<input id="coachTimeList['+index+'].startTime" type="text" name="coachTimeList['+index+'].startTime" class="form-control"'+
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


	 //form检查
	 $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		    rules : {
		    	"selectymonth" : {
		        required : true,
		      },

		    },
		    messages : {
		    	selectymonth : {
		        required : "请选择月份",
		      },

		    },
		    submitHandler: function(form) {  //通过之后回调
		    	$('#stores_error').remove();
		    	if($(".coachs").is(":checked")==false){
		    		//alert($('#stores_error').length);
		    		if($('#stores_error').length<=0){
		    			$('#div_servicearea').append("<span id='stores_error' class='error'>请选择教练</span>");
		    		}
		    		return false;
		    	}

		    	 $.ajax({
			   	      type:"POST",
			   	      url:baseUrl+'/user/pricoursetime/addSave',
			   	      data:$('#form').serialize(),
			   	      success:function(data){
			   	    	  console.log(data);
			   	    	  if(data.resultCode==200){
//			   	    		  alert("成功");
			   	    		  $('#success').modal('show');
			   	    		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);

			   	    	  }else{
//			   	    		  alert("失败");
			   	    		  $('#failure').modal('show');
			   	    		  $('#span_failure').text(data.message);

			   	    	  }

			   	      }
			   	    });

		   }
	 })


	 //进入页面默认  disabled 指定日期
	 $('#div_everyDay *').attr("disabled",false);
	$('#div_specDate *').attr("disabled",true);
	 /**
	  *	切换为每天和指定日期
	  */
	$('.a_changeType').click(function(){
		var id=$(this).data('id');
		if(id==1){//表示点击了指定日期
			$('#div_everyDay *').attr("disabled",true);
			$('#div_specDate *').attr("disabled",false);
		}else if(id==2){//表示点击了每天
			$('#div_everyDay *').attr("disabled",false);
			$('#div_specDate *').attr("disabled",true);
		}

	});


})



