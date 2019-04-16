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

/*    jQuery.validator.addMethod("amountLimit", function(value, element) {
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
    	},"最大课程名额必须大于等于课程名额");*/

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



	  $('#form').validate({
		  onsubmit:true,// 是否在提交是验证
		  ignore: "",
		    rules : {
		    	"courseExcGroup.coursename" : {
		        required : true,
		        maxlength:15
		      },
		    /*  "courseExcGroup.people" : {
			        required : true,
			        digits : true,
		      },*/
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
		    	  digits : true,
		    	 // amountLimit:true,
		      },


		    },
		    messages : {
		    	"courseExcGroup.coursename" : {
		        required : "请输入课程名字",
		        maxlength : "名称不超过15个字符",
		      },
		   /*   "courseExcGroup.people" : {
			        required : "请输入名额",
			        digits : " 名额为数字",
		      },*/
		      "courseExcGroup.courseamount" :{
		    	  required:"请输入总金额",
		    	  minNumber:"小数点后最多1位"
		      },
		      "courseExcGroup.totalhours":{
		    	  required:"请输入总课时",
		    	  minNumber:"小数点后最多1位"
		      },
		      "courseExcGroup.courseimg":{
		    	  required:"请上传图片",
		      },
		      "courseExcGroup.maxpeople":{
		    	  required:"请输入课程名额",
		    	  digits : "课程名额为数字",
		    	 // minNumber:"最大课程名额必须大于等于课程名额"
		      },


		    },
		      submitHandler: function(form) {  //通过之后回调

			    	if($(".stores").is(":checked")==false){
			    		//alert($('#stores_error').length);
			    		if($('#stores_error').length<=0){
			    			$('#div_servicearea').append("<span id='stores_error' class='error'>请选择门店</span>");
			    		}
			    		return false;
			    	}
			    	if($(".coachs").is(":checked")==false){
			    		//alert($('#stores_error').length);
			    		$('#stores_error').remove();
			    		if($('#coachs_error').length<=0){
			    			$('#div_servicecoach').append("<span id='coachs_error' class='error'>请选择教练</span>");

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



	//异步提交表单
//	$('#form').on('submit',function(ev){
//
//	   	    ev.preventDefault();
//	 });

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






});