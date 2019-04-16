$(function(){
/*	$('#form').on('submit',function(ev){

   	    ev.preventDefault();
   	  });*/

	   // 判断用户输入的value是否满足传入的正则params的规范
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
	    return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请正确填写您的手机号码");

 // 身份证号码验证
    jQuery.validator.addMethod("isIdCardNo", function(value, element) {
      return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
    }, "请正确输入您的身份证号码");


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

	$('#form').validate({
		   ignore: "",
		    rules : {
		    	coachname : {
			        required : true,
			        maxlength : 20,
			        minlength : 1,
			      },
			      nickname : {
					    required : true,
					    maxlength : 20,
					    minlength : 1,
					  },
			      email:{
			    	  email:true
			      },
			      phonenumber:{
			    	// required : true,
			    	 maxlength : 11,
				     minlength : 11,
				     digits : true,
				     isMobile: true

			     },
			     idnumber:{
			    	 //required:true,
			    	 isIdCardNo:true
			     },
			     servicearea:{
			    	 required : true,
			     },
			      goodat:{
			    	  required : true,
			      },

			     teachyears:{
			    	  required : true,
			    	  number:true,
			    	  minNumber:true
			      },
			      headimg:{
			    	  required : true,
			      }
		    },
		    messages : {
		    	coachname : {
			        required : "请输入门店名称",
			        maxlength : "教练名称最长为20个字符",
			        minlength : "教练名称至少有1个字符",

		      },
		      nickname : {
			        required : "请输入教练昵称",
			        maxlength : "教练名称最长为20个字符",
			        minlength : "教练名称至少有1个字符",

		      },
		      email:{
		    	  email:"请输入正确的email"
		      },
		      phonenumber:{
			    	// required :"请输入手机号码",
			         maxlength : " 手机号码为11位数字",
				     minlength : "手机号码为11位数字",
				     digits : " 手机号码为11位数字",
				     isMobile: "请输入正确的手机号"

			     },
			 idnumber:{
				// required:"请输入身份证号",
				 isIdCardNo:"请输入正确的身份证号"
			 	},

			 servicearea:{
				    	 required : "请输入服务区域",
			 	},
			      goodat:{
			    	  required : "请选择擅长的项目",

			      },

			      teachyears:{
			    	  required : "请输入教龄",
			    	  number:"请输入数字",
			    	  minNumber:"小数点后最多一位"
			      },
			      headimg:{
			    	  required : "请上传头像",
			      }
		    },submitHandler: function(form) {  //通过之后回调
		    	//
		    	if($(".stores").is(":checked")==false){
		    		//alert($('#stores_error').length);
		    		if($('#stores_error').length<=0){
		    			$('#div_choseStores').append("<span id='stores_error' class='error'>请选择门店</span>");
		    		}
		    		return false;
		    	}
		    	if(($('#mainfigure1').val()==null || $('#mainfigure1').val()=="")
		    			&&($('#mainfigure2').val()==null || $('#mainfigure2').val()=="")
		    			&&($('#mainfigure3').val()==null || $('#mainfigure3').val()=="")
		    			&&($('#mainfigure4').val()==null || $('#mainfigure4').val()=="")
		    			&&($('#mainfigure5').val()==null || $('#mainfigure5').val()==""))
		    	{
		    		if($('#imgError').length<=0){
		    			$('#img').append("<span id='imgError'>请上传照片</span>");
		    		}
		    		return false;
		    	}

		    	form.submit();

		   /* 	   $.ajax({
		    	   	      type:"POST",
		    	   	      url:baseUrl+'/user/coach/editSave',
		    	   	      data:$('#form').serialize(),
		    	   	      success:function(data){
		    	   	    	  console.log(data);
		    	   	    	  if(data.resultCode==200){
		    	   	    		  $('#success').modal('show');

		    	   	    	  }else{
		    	   	    		  $('#failure').modal('show');

		    	   	    	  }

		    	   	      }
		    	   	    });*/

		    }

		});


	/**
	 * 点击教练等级
	 */
	$('.coachlevel').click(function(){
		$('#chooseCoachlevel').val($(this).data('id'));
	});

	//选中checkbox
	$('.surechoose').click(function(){
		$('#cleandiv').empty();
		$('#cleandiv').append('<a class="btn btn-success" data-toggle="modal" data-target="#choose_stores"  id="mendianchoose">选择门店</a>');
		$('.stores').each(function(){
			if ($(this).is(':checked')) {
				$('#mendianchoose').before($(this).data("name")+"&nbsp;&nbsp;");
			}
		});
	});

	/**
	 * 上传主图到阿里云
	 */
	 $("#file").takungaeImgup5({

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
	 * 根据市改变事件  加载区
	 */
	$('#location').change(function(){

		//获取市的编码
		var cityCode=$(this).children('option:selected').val();


 	    $.ajax({
 	   	      type:"GET",
 	   	      url:baseUrl+'/user/coach/selectRegionByCity',
 	   	      data:{"cityCode":cityCode},
 	   	      success:function(data){

 	   	    	  if(data.resultCode==200){
 	   	    		  $('#div_servicearea').empty();
 	   	    		  if(data.records !=null && data.records.length>0){
 	   	    			  var regionList=data.records;
 	   	    			  for(var i=0;i<regionList.length;i++){
 	   	    				  var region=regionList[i];

 	   	    				  //加载区
 	   	    				  $('#div_servicearea').append('<input type="checkbox" name="servicearea" value="'+region.zonecode+'">'+region.name+'');
 	   	    			  }

 	   	    		  }


 	   	    	  }else{
 	   	    		//  $('#failure').modal('show');

 	   	    	  }

 	   	      }
 	   	    });


	});


	 /**
	  * 删除图片
	  */
	/* $('.delImg').click(function(){

		 $('#showImg').attr('src',baseUrl+'/assets/js/uploadImg/img/a11.png');
		 $('#mainfigure').val("");
		 $(this).remove();
		// alert("1");

	 });*/
})

function previewImage(file)
{

		 var defaults = {
					fileType : [ "jpg", "png", "bmp", "jpeg","JPG","PNG","JPEG","BMP" ], // 上传文件的类型
					fileSize : 1024 *  1024 *10, // 上传文件的大小 1M
					count : 0
				// 计数器
				};

           validateUp(file.files, defaults);
           var data = new FormData();
			data.append("file", file.files[0]);
			$.ajax({
	   	      type:"POST",
	   	      url:baseUrl+'/user/uploadMainFigure',
	  	   		data : data,
				async: false,//同步
				processData : false,
				contentType : false,
				dataType : 'json',
	   	      	success:function(data){
	   	      	   console.log(file);
	   	      	   	$('#headImg').attr("src",data.url);
	   	      	   	$('#hidden_headImg').val(data.url);
	   	     	   //清空提示
	   	      	   	$('#hidden_headImg-error').remove();
	   	    	  //给隐藏域赋值
	   	    	  //$('#certificate'+file.id).val(data.url);

	   	    	  //$('#'+file.id).parent().after('<a class="btn btn-default checkImg" data-toggle="modal" >查看图片</a>');

	   	    	 // $('#'+file.id).parent().remove();
	   	    	 /* $('#'+id).remove();
	   	    	  $('#')*/

	   	      }
	   	  });
       }


 	// 验证文件的合法性
		function validateUp(files, defaults) {
			var arrFiles = [];// 替换的文件数组
			for ( var i = 0, file; file = files[i]; i++) {
				// 获取文件上传的后缀名
				var newStr = file.name.split("").reverse().join("");
				if (newStr.split(".")[0] != null) {
					var type = newStr.split(".")[0].split("")
							.reverse().join("");
					console.log(type + "===type===");
					if (jQuery.inArray(type, defaults.fileType) > -1) {
						// 类型符合，可以上传
						if (file.size >= defaults.fileSize) {
							alert('文件大小"' + file.name + '"超出10M限制！');
						} else {
							arrFiles.push(file);
						}
					} else {
						alert('您上传的"' + file.name + '"不符合上传类型');
					}
				} else {
					alert('您上传的"' + file.name + '"无法识别类型');
				}
			}
			return arrFiles;
		}