$(function(){

    jQuery.validator.addMethod("minNumber",function(value, element){
        var returnVal = true;
        inputZ=value;
        var ArrMen= inputZ.split(".");    //截取字符串
        if(ArrMen.length==2){
            if(ArrMen[1].length>1){    //判断小数点后面的字符串长度
                returnVal = false;
                return false;
            }
        }
        return returnVal;
    },"小数点后最多1位");

    jQuery.validator.addMethod("amountLimit", function(value, element) {
    	var returnVal = false;
    	if(!$("#coursepeople").prop('disabled')){//如果已经被disabled  不用检查
	    	var people = $("#coursepeople").val();
	    	var maxpeople = $("#maxcoursepeople").val();
	    	if(parseFloat(maxpeople)>=parseFloat(people)){
	    	returnVal = true;
	    	}
    	}else{
    		returnVal = true;
    	}
    	return returnVal;
    	},"最大课程名额必须大于等于课程名额");

	/**
	 * 上传主图到阿里云
	 */
	 $("#file").takungaeImgup({

	    /*  formData: {
	          "path": "artScene/",
	          "name": value
	      },*/
	      url: baseUrl+'/user/uploadMainFigure',
	      success: function(data) {
	    	  //alert("1");
	    	//  alert("children");
	      },
	      error: function(err) {

	      }
	});

	 /**
	  * 删除图片
	  */
	 $('#delImg').click(function(){
		 $('#showImg').attr('src',baseUrl+'/assets/js/uploadImg/img/a11.png');
		 $('#mainfigure').val("");
		 $(this).remove();
		// alert("1");

	 });

//    /**
//     * 切换到精品团课
//     */
//    $('#a_course_pri').click(function(){
//    /*	$('#message').modal('show');
//    	$('#span_msg').text("确定切换为精品团课吗？切换后将清空当前页面内容");
//
//    	*/
//    	bootbox.confirm("<font size='3'>确定切换为私教课吗？切换后将清空当前页面内容</font>", function(result) {
//    		if(result) {
//    			window.location.href=baseUrl+"/user/course/addPage?type=0";
//
//    		}
//    	});
//    });

	  $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		    rules : {
		    	"courseExcGroup.coursename" : {
		        required : true,
		        maxlength:15
		      },
		      "courseExcGroup.people" : {
			        required : true,
			        digits : true,
		      },
		      "courseExcGroup.courseamount" :{
		    	   required:true,

		    	   minNumber:true,
		      },
		      "courseExcGroup.totalhours":{
		    	  required:true,

		    	  minNumber:true,

		      },
		      "courseExcGroup.courseimg":{
		    	  required:true,
		      },
		      "courseExcGroup.maxpeople":{
		    	  required:true,
		    	  amountLimit:true,
		      },
		     /* "courseExcGroup.startdate":{
		    	  required:true,
		      },
		      "courseExcGroup.enddate":{
		    	  required:true,
		      },
		      "courseExcGroup.starthour":{
		    	  required:true,
		      },
		      "courseExcGroup.endhour":{
		    	  required:true,
		      },
		      "courseExcGroup.startmin":{
		    	  required:true,
		      },
		      "courseExcGroup.endmin":{
		    	  required:true,
		      },
		      "courseExcGroup.courseexpstart":{
		    	  required:true,
		      },
		      "courseExcGroup.week":{
		    	  required:true,
		      },
		      "courseExcGroup.startmonth":{
		    	  required:true,
		      },
		      "courseExcGroup.endmonth":{
		    	  required:true,
		      }*/

		    },
		    messages : {
		    	"courseExcGroup.coursename" : {
		        required : "请输入课程名字",
		        maxlength : "名称不超过15个字符",
		      },
		      "courseExcGroup.people" : {
			        required : "请输入名额",
			        digits : " 名额为数字",
		      },
		      "courseExcGroup.courseamount" :{
		    	  required:"请输入总金额",
		    	  minNumber:"小数点后最多1位"
		      },
		      "courseExcGroup.totalhours":{
		    	  required:"请输入总课时",
		    	  minNumber:"小数点后最多1位",

		      },
		      "courseExcGroup.courseimg":{
		    	  required:"请上传图片",
		      },
		      "courseExcGroup.maxpeople":{
		    	  required:"请输入最大课程名额",
		    	  minNumber:"最大课程名额必须大于等于课程名额"
		      },
		     /* "courseExcGroup.startdate":{
		    	  required:"请选择开始日期",
		      },
		      "courseExcGroup.enddate":{
		    	  required:"请选择结束日期",
		      },
		      "courseExcGroup.starthour":{
		    	  required:"请选择开始小时",
		      },
		      "courseExcGroup.endhour":{
		    	  required:"请选择结束小时",
		      },
		      "courseExcGroup.startmin":{
		    	  required:"请选择结束分钟",
		      },
		      "courseExcGroup.endmin":{
		    	  required:"请选择结束分钟",
		      },
		      "courseExcGroup.courseexpstart":{
		    	  required:"请选择预计开始时间",
		      },
		      "courseExcGroup.week":{
		    	  required:"请选择星期",
		      },
		      "courseExcGroup.startmonth":{
		    	  required:"请选择每月开始日期",
		      },
		      "courseExcGroup.endmonth":{
		    	  required:"请选择每月结束日期",
		      }
*/

		    },
		      submitHandler: function(form) {  //通过之后回调

			    	if($(".stores").is(":checked")==false){
			    		//alert($('#stores_error').length);
			    		if($('#stores_error').length<=0){
			    			$('#div_servicearea').append("<span id='stores_error'>请选择门店</span>");
			    		}
			    		return false;
			    	}
			    	if($(".coachs").is(":checked")==false){
			    		$('#stores_error').remove();
			    		//alert($('#stores_error').length);
			    		if($('#coachs_error').length<=0){
			    			$('#div_servicecoach').append("<span id='coachs_error'>请选择教练</span>");

			    		}
			    		return false;
			    	}
//			    	if($(".checkbox_memberCard").is(":checked")==false){
//			    		$('#checkdiv').append("请选择会员卡");
//			    		return false;
//			    	}
			      	 $.ajax({
			   	      type:"POST",
			   	      url:baseUrl+'/user/course/editSave',
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

			   	    	  }

			   	      }
			   	    });
		      }
		  });

		//选中checkbox
		$('.surechoose').click(function(){
			$('.cleandiv').empty();
			$('.cleandiv').append('<a class="btn" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a>');
			$('.stores').each(function(){
				if ($(this).is(':checked')) {
					$('#mendianchoose').before($(this).data("name")+"&nbsp;&nbsp;");
				}
			});
		});


		//选中checkbox
		$('.coachsure').click(function(){
			$('.cleancoach').empty();
			$('.cleancoach').append(' <a class="btn" data-toggle="modal" data-target="#choose_coachs" id="jiaolianchoose">选择教练</a>');
			$('.coachs').each(function(){
				if ($(this).is(':checked')) {
					$('#jiaolianchoose').before($(this).data("name")+"&nbsp;&nbsp;");
				}
			});
		});
	//异步提交表单
//	$('#form').on('submit',function(ev){
//
//	   	    ev.preventDefault();
//	 });



	//点击button  课程时间
	/*$('.coursertimetype').click(function(){
		//获取课程时间类型
		var id=$(this).data('id');
		if(id=="1"){//指定日期
			$('#specDate *').attr("disabled",false);

			$("#eveDay *").attr("disabled",true);
			$("#eveWeek *").attr("disabled",true);
			$("#eveMonth *").attr("disabled",true);

		}else if(id=="2"){//每天
			$("#eveDay *").attr("disabled",false);

			$('#specDate *').attr("disabled",true);
			$("#eveWeek *").attr("disabled",true);
			$("#eveMonth *").attr("disabled",true);
		}else if(id=="3"){//每周
			$("#eveWeek *").attr("disabled",false);

			$("#eveDay *").attr("disabled",true);
			$('#specDate *').attr("disabled",true);
			$("#eveMonth *").attr("disabled",true);

		}else if(id="4"){//每月
			$("#eveMonth *").attr("disabled",false);

			$("#eveDay *").attr("disabled",true);
			$('#specDate *').attr("disabled",true);
			$("#eveWeek *").attr("disabled",true);

		}








		$('#chooseCourseTimeType').val(id);
	});
*/

	/**
	 * 开选项卡
	 */
	$('#div_on').click(function(){
		$('#coursetab').val(0);
		$('#coursetitle').attr("disabled","disabled");
		$('.tabDetail').hide();

	});
	/**
	 * 关选项卡
	 */
	$('#div_off').click(function(){
		$('#coursetab').val(1);
		$('#coursetitle').removeAttr("disabled");
		$('.tabDetail').show();

	});



	/**
	 * 刚进入页面   courseGroupType==1表示精品团课    否则为基础团课
	 */
	if(courseGroupType==1){
		//每堂课人数  去掉
		//$('.everyPeople *').
		$('.div_everyPeople *').attr("disabled",true);
		//$('.div_everyPeople').hide();



		//金额
		$('.div_courseamount *').attr("disabled",false);
		//$('.div_courseamount').show();

		//总课时
		$('.div_totalhours *').attr("disabled",false);
		//$('.div_totalhours').show();
	}else{
		//每堂课人数出现
		$('.div_everyPeople *').attr("disabled",false);
		//$('.div_everyPeople').show();


		//金额
		$('.div_courseamount *').attr("disabled",true);
		//$('.div_courseamount').hide();

		//总课时
		$('.div_totalhours *').attr("disabled",true);
		//$('.div_totalhours').hide();
	}

	/**
	 * 点击团课类型
	 */
	$('.courseGroupType').click(function(){
		if($(this).val()==1){//表示精品团课

			//每堂课人数  去掉
			//$('.everyPeople *').
			$('.div_everyPeople *').attr("disabled",true);
			$('.div_everyPeople').hide();



			//金额
			$('.div_courseamount *').attr("disabled",false);
			$('.div_courseamount').show();

			//总课时
			$('.div_totalhours *').attr("disabled",false);
			$('.div_totalhours').show();

		}else if($(this).val()==2){//基础团课
			//每堂课人数出现
			$('.div_everyPeople *').attr("disabled",false);
			$('.div_everyPeople').show();


			//金额
			$('.div_courseamount *').attr("disabled",true);
			$('.div_courseamount').hide();

			//总课时
			$('.div_totalhours *').attr("disabled",true);
			$('.div_totalhours').hide();

		}
	});
});