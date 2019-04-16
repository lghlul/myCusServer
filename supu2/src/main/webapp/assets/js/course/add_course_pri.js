$(function(){


	/**
	 * 上传主图到阿里云
	 */
	 $("#file").takungaeImgup({

	      url: baseUrl+'/user/uploadMainFigure',
	      success: function(data) {

	      },
	      error: function(err) {

	      }
	});

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
			var b = false;
			$('.coachs').each(function(i){
				if ($(this).is(':checked')) {
					$('#jiaolianchoose').before($(this).data("name")+"&nbsp;&nbsp;");

                    if(!$("input[name='coursePriCoach.price']").eq(i).val()){
                        layer.msg("请输入价格",{time:1000})
                        b = true;
                        return;
                    }

					if(!$("input[name='coursePriCoach.orderNum']").eq(i).val()){
                        layer.msg("请输入排序",{time:1000})
						b = true;
                        return;
					}
				}else{
                    $("input[name='coursePriCoach.price']").eq(i).val("");
                    $("input[name='coursePriCoach.orderNum']").eq(i).val("")
				}
			});
			if(!b){
                $("#cancelBtn").click();
            }
        });
	    /**
	     * 切换到团课
	     */
	    $('#a_course_group').click(function(){
	    /*	$('#message').modal('show');
	    	$('#span_msg').text("确定切换为精品团课吗？切换后将清空当前页面内容");

	    	*/
	    	bootbox.confirm("<font size='3'>确定切换为基础团课或训练营吗？切换后将清空当前页面内容</font>", function(result) {
	    		if(result) {
	    			window.location.href=baseUrl+"/user/course/addPage?type=1";

	    		}
	    	});
	    });



	    /**
	     * 体验课 checkbox 切换
	     */
	/*    $('#isexperience').click(function(){
	    	if($(this).val()=="0"){
	    		$(this).val(1);
	    	}else{
	    		$(this).val(0);
	    	}
	    });*/

	    //表单校验
	  $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		    rules : {
		    	"coursePriCoach.coursename" : {
		    		required : true,
		    		maxlength:15
		      },
		      "coursePriCoach.courseamount":{
		    	  required : true,
		    	  minNumber:true,
		      },
		      "coursePriCoach.totalhours" : {
			        required : true,
			       // digits:true

//			        maxlength : 11,
//			        minlength : 11,
//			        digits : true,
		      },
		      "coursePriCoach.courseimg":{
		    	  required : true,
		      },
		      "coursePriCoach.coursetitle":{
		    	  required:true
		      },
		      "coursePriCoach.coursedetail":{
		    	  required:true
		      },
				"coursePriCoach.courseEndTimeStr" :{
					required:true
				}
		    },
		    messages : {
		    	"coursePriCoach.coursename" : {
			        required : "请输入名称",
			        maxlength : "名称不超过15个字符",
		      },
		      "coursePriCoach.courseamount":{
		    	  required :"请输入课程金额",
		    	  minNumber:"小数点后最多1位",
		      },
		      "coursePriCoach.totalhours" : {
			        required : "请输入起售课时",
			        //minNumber:"小数点后最多1位"
			        //digits:"请输入整数"
		      },
		      "coursePriCoach.courseimg":{
		    	  required : "请上传图片",
		      },
		      "coursePriCoach.coursetitle":{
		    	  required:"请输入标题"
		      },
		      "coursePriCoach.coursedetail":{
		    	  required:"请输入课题详情"
		      },"coursePriCoach.courseEndTimeStr" :{
				required: "请输入课程结束时间"
			}

		    },
		      submitHandler: function(form) {  //通过之后回调
		    	  if($(".stores").is(":checked")==false){
		    			$('#coachs_error').remove();
			    		if($('#stores_error').length<=0){
			    			$('#div_choseStores').append("<span id='stores_error' class='error'>请选择门店</span>");
			    		}
			    		return false;
			    	}
		    	  if($(".coachs").is(":checked")==false){
		    		  	$('#stores_error').remove();
			    		if($('#coachs_error').length<=0){
			    			$('#div_choseCoachs').append("<span id='coachs_error' class='error'>请选择教练</span>");
			    		}
			    		return false;
			    	}
			    	 $.ajax({
			      	      type:"POST",
			      	      url:baseUrl+'/user/course/addSave',
			      	      data:$('#form').serialize(),
			      	      success:function(data){
			      	    	  console.log(data);
			      	    	  if(data.resultCode==200){
			      	    		  $('#success').modal('show');
			      	    		//  $('#all_success').modal('show');
			      	    		 // $('#a_infoLink').attr('href',baseUrl+"/user/realseInfo/editPage?id="+data.total);

			      	    	  }else{
			      	    		  $('#failure').modal('show');
			      	    		//  $('#all_failure').modal('show');

			      	    	  }

			      	      }
			      	    });
		      }
		  });

})