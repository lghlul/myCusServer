$(function(){



	/**
	 * 上传主图到阿里云
	 */
	 $("#file").takungaeImgup2({

	    /*  formData: {
	          "path": "artScene/",
	          "name": value
	      },*/
	      url: baseUrl+'/user/uploadMainFigure',
	      success: function(data) {

	      },
	      error: function(err) {

	      }
	});

	 //添加资质证书
	/* $('.btn').click(function(){



	 });*/

	 $('.btn_add').click(function(){
		 var  index=$('.div_cetificate').length;
		 if(index>=20){
			 return false;
		 }


		 $('#div_append_certificate').append('<div class="form-group div_cetificate">'+
						'<div class="col-sm-3 col-sm-offset-1">'+
							'<input type="text" class="form-control" placeholder="请输入证书名称" name="coachCertificate['+index+'].name" >'+
						'</div>'+
						'<div class="col-sm-1">'+
						 	'<a href="javascript:;" class="file">上传证书'+
	    						'<input type="file"  id="file'+index+'" onchange="previewImage(this)">'+
							'</a>'+
							'<input type="hidden" class="hidden" value="" id="certificatefile'+index+'" name="coachCertificate['+index+'].certificateimg" >'+
						'</div>'+
						'<div class="col-sm-1 special">'+
							'<button class="btn btn_remove" type="button" >&nbsp;-&nbsp;</button>'+
						'</div>'+

					'</div>');
	 });


	 //查看图片
	 $(document).on('click','.checkImg',function(){
		// alert($(this).siblings('.hidden').val());
		 var imgsrc=$(this).siblings('.hidden').val();
		// alert($(this).parent().);
		 //alert($(this).parent().prev().eq(1).find(':hidden').val());
		 $('#seeImg').attr("src",imgsrc);
		 $('#lookover').modal('show');

	 });




	//移除证书一层
	 $(document).on('click','.btn_remove',function(){
		 $(this).parent().parent().remove();

	 });
/*
	 //移除证书一层
	 $('.').click(function(){
		 $(this).parent().parent().remove();
	 });*/



	 /**
	  * 提交form表单
	  */
	$('#form').on('submit',function(ev){

		$.ajax({
	   	      type:"POST",
	   	      url:baseUrl+'/user/coach/addNextSave',
	   	      data:$('#form').serialize(),
	   	      success:function(data){
	   	    	  console.log(data);
	   	    	  if(data.resultCode==200){
	   	    		  $('#success').modal('show');

	   	    	  }else{
	   	    		  $('#failure').modal('show');

	   	    	  }

	   	      }
	   	    });
	    ev.preventDefault();
	   	});


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
//alert(file.id);

	   	    	  //给隐藏域赋值
	   	    	  $('#certificate'+file.id).val(data.url);

	   	    	  $('#'+file.id).parent().after('<a class="btn btn-default checkImg" data-toggle="modal" >查看图片</a>');

	   	    	  $('#'+file.id).parent().remove();
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