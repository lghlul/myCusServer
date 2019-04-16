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
			    	// required:true,
			    	 isIdCardNo:true
			     },
			     servicearea:{
			    	 required : true,
			     },
			      goodat:{
			    	  required : true,
			      },
			   /*   stores:{
			    	  required : true,
			      },*/
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
			        required : "请输入教练名称",
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
				 //required:"请输入身份证号",
				 isIdCardNo:"请输入正确的身份证号"
			 		},

			 	   servicearea:{
				    	 required : "请输入服务区域",
				     },
			      goodat:{
			    	  required : "请选择擅长的项目",

			      },
			   /*   stores:{
			    	  required : "请选择门店",
			      },*/
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
		    		if($('#stores_error').length<=0){
		    			$('#div_choseStores').append("<span id='stores_error' class='error'>请选择门店</span>");
		    		}
		    		return false;
		    	}
		/*    	if($(".stores").is(":checked")==false){
		    		if($('#headimg_error').length<=0){
		    			$('#div_choseStores').append("<span id='headimg_error' class='error'>请上传头像</span>");
		    		}
		    		return false;
		    	}*/

		    	if(($('#mainfigure1').val()==null || $('#mainfigure1').val()=="")
		    			&&($('#mainfigure2').val()==null || $('#mainfigure2').val()=="")
		    			&&($('#mainfigure3').val()==null || $('#mainfigure3').val()=="")
		    			&&($('#mainfigure4').val()==null || $('#mainfigure4').val()=="")
		    			&&($('#mainfigure5').val()==null || $('#mainfigure5').val()==""))
		    	{
		    		if($('#imgError').length<=0){
		    			$('#img').append("<span id='imgError' class='error'>请上传照片</span>");
		    		}
		    		return false;
		    	}

		    	form.submit();

		 /*	    $.ajax({
		 	   	      type:"POST",
		 	   	      url:baseUrl+'/user/coach/addSave',
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
		$('.cleandiv').empty();
		$('.cleandiv').append('<a class="btn btn-success" data-toggle="modal" data-target="#choose_stores"  id="mendianchoose">选择门店</a>');
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
	  * 上传图片
	  */
/*	 $("#file2").takungaeImgup2({

		      formData: {
		          "path": "artScene/",
		          "name": value
		      },
		      url: baseUrl+'/user/upload/uploadMainFigure',
		      success: function(data) {
		    	  //alert("1");
		    	//  alert("children");
		      },
		      error: function(err) {

		      }
		});*/


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
 	   	    				  //$('#div_servicearea').empty();

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


       /*   $("#btnsubmit").click(function () {
              $("#form1").ajaxSubmit({
                  success: function (data) {
                      alert(data.url);
                  },
                  error: function (error) { alert(error); },
                  url:baseUrl+'/user/upload/uploadMainFigure', 设置post提交到的页面
                  type: "post", 设置表单以post方法提交
                  dataType: "json" 设置返回值类型为文本
              });
          });
*/
	/**
	 * 上传资格证书
	 */
	$('.uploadFile').change(function(){
		var hideForm = $('#form0');
		var options = {
		dataType : "json",
		/*data: {'file': $("input[type=file]").val(), "username": '123', password: "123"},*/
		beforeSubmit : function() {
		alert("正在上传");
		},
		success : function(result) {
		alert('成功上传！');
		},
		error : function(result) {
			alert("");
		}
		};
		hideForm.ajaxSubmit(options);

		//$("#form0").submit();
		/*  $("#form0").ajaxSubmit({
              url: baseUrl+'/user/upload/uploadMainFigure', 设置post提交到的页面
              type: "post", 设置表单以post方法提交
              dataType: "json", 设置返回值类型为文本
            	  success: function (data) {
                         alert(data.url);
                   },
                error: function (error) { alert(error); },
          });*/
/*		var formData = new FormData();
		//var name = $("input").val();
		formData.append("file",$("#form0")[0].files[0]);
		//formData.append("name",name);
		$.ajax({
		url : baseUrl+'/user/upload/uploadMainFigure',
		type : 'POST',
		data : formData,
		// 告诉jQuery不要去处理发送的数据
		processData : false,
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend:function(){
		console.log("正在进行，请稍候");
		},
		success : function(responseStr) {
		if(responseStr.status===0){
		console.log("成功"+responseStr);
		}else{
		console.log("失败");
		}
		},
		error : function(responseStr) {
		console.log("error");
		}
		});*/
		  //var formData = new FormData($("#form0")[0]);

		/*     var formData = new FormData($("#uploadForm")[0]);
		     $.ajax({
		          url: baseUrl+'/user/upload/uploadMainFigure' ,
		          type: 'POST',
		          data: formData,
		          async: false,
		          cache: false,
		          contentType: false,
		          processData: false,
		          success: function (returndata) {
		              console(returndata);
		          },
		          error: function (returndata) {
		        	 // console(returndata);
		          }
		     });*/
	/*	$.ajax({
		     url :baseUrl+'/user/upload/uploadMainFigure',
		     type : "POST",
		     data : $('#form0').serialize(),
		     success : function(data) {
		    	 console.log(data);
		         // $( '#serverResponse').html(data);
		     },
		     error : function(data) {
		         // $( '#serverResponse').html(data.status + " : " + data.statusText + " : " + data.responseText);
		     }
		});*/
	});


	/**
	 * 添加资格证书
	 */
	$(document).on('click','.add_div',function(){
		var index=$('.div_certificate').length;
		if(index>=20){
			$('#span_msg').text("资格证书不能超过20个");
			$('#message').modal('show');
			return  false;

		}
		$('#div_certificate').after('<div class="form-group div_certificate">'+
				'<div class="col-sm-4 col-sm-offset-1">'+
				'<input type="text" class="form-control" placeholder="输入证书名称"></div>'+
				'<div class="col-sm-1">'+
				'<input type="file"  class="uploadFile">上传证书</div>'+
				'<input type="hidden" name="certificateimg['+index+']">'+
			    '<div class="col-sm-1 special">'+
				'<button  type="button" class="btn del_div">&nbsp;&nbsp;-&nbsp;&nbsp;</button></div>'+
			    '<div class="col-sm-1 special">'+
			    '<button type="button" class="btn add_div">&nbsp;&nbsp;+&nbsp;&nbsp;</button>'+
			    '</div></div>');
	});


	//去掉一层资格证书
	$(document).on('click','.del_div',function(){

		//去除一层
		$(this).parent().parent().remove();
	})
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