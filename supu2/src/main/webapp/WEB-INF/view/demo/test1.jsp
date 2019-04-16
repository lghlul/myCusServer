<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" >


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图片上传本地预览</title>
<style type="text/css">
#preview{width:260px;height:190px;border:1px solid #000;overflow:hidden;}
#imghead {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);}
</style>
<script type="text/javascript">
      //图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
          var MAXWIDTH  = 260;
          var MAXHEIGHT = 180;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();

              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);

          	var data = new FormData();
			//data.append("path", opt.formData.path);
			data.append("file", file.files[0]);
      	    $.ajax({
  	   	      type:"POST",
  	   	      url:baseUrl+'/user/upload/uploadMainFigure',
	  	   		data : data,
	  			//alert(1)
				async: false,//同步
				processData : false,
				contentType : false,
				dataType : 'json',
  	   	      success:function(data){
  	   	    	  alert("1");

  	   	    	  console.log(data);
  	   	    	  if(data.resultCode==200){

  	   	    	  }else{


  	   	    	  }

  	   	      }
  	   	  });
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;

                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }


    	var defaults = {
				fileType : [ "jpg", "png", "bmp", "jpeg","JPG","PNG","JPEG","BMP" ], // 上传文件的类型
				fileSize : 1024 *  1024 *10, // 上传文件的大小 1M
				count : 0
			// 计数器
			};
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
</script>
</head>
<body>
<div id="preview">
    <img id="imghead" width=100% height=auto border=0 src='a1.png'>
</div>

<input type="file" onchange="previewImage(this)" />
</body>
</html>
<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
  <script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>