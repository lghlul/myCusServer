<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑工作室</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
    <link rel="stylesheet" href="../../assets/css/backstagetwo.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css" />
   <%--  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/js/uploadify/uploadify.css" />
 --%>
    <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/css.css"/>
	<style>
		.col-sm-1>span{
			color: #ff0000;
		}
		.contentShow{
			padding-top: 7px;
		}
		.special{
			width: 5%!important;
		}

        .onoffswitch {
            position: relative; width: 90px;
            -webkit-user-select:none; -moz-user-select:none; -ms-user-select: none;
        }
        .onoffswitch-checkbox {
            display: none;
        }
        .onoffswitch-label {
            display: block; overflow: hidden; cursor: pointer;
            border: 2px solid #999999; border-radius: 20px;
        }
        .onoffswitch-inner {
            width: 200%; margin-left: -100%;
            -moz-transition: margin 0.3s ease-in 0s; -webkit-transition: margin 0.3s ease-in 0s;
            -o-transition: margin 0.3s ease-in 0s; transition: margin 0.3s ease-in 0s;
        }
        .onoffswitch-inner > div {
            float: left; width: 50%; height: 30px; padding: 0; line-height: 30px;
            font-size: 14px; color: white; font-family: Trebuchet, Arial, sans-serif; font-weight: bold;
            -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box;
        }
        .onoffswitch-inner .onoffswitch-active {
            padding-left: 10px;
            background-color: #ff0000; color: #FFFFFF;
        }
        .onoffswitch-inner .onoffswitch-inactive {
            padding-right: 10px;
            background-color: #EEEEEE; color: #999999;
            text-align: right;
        }
        .onoffswitch-switch {
            width: 18px; margin: 6px;
            background: #FFFFFF;
            border: 2px solid #999999; border-radius: 20px;
            position: absolute; top: 0; bottom: 0; right: 56px;
            -moz-transition: all 0.3s ease-in 0s; -webkit-transition: all 0.3s ease-in 0s;
            -o-transition: all 0.3s ease-in 0s; transition: all 0.3s ease-in 0s;
        }
        .onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-inner {
            margin-left: 0;
        }
        .onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-switch {
            right: 0px;
        }
        .import-tip{
            padding-left: 5px;
            margin-top: 10px;
            color: #999;
        }
        .modal-title>span{
            font-size: 18px;
        }
        .province{
            padding: 10px;
            border-bottom: 3px dashed #e5e5e5;
        }
        .province-info{
            border-bottom: 2px dashed #ccc;
            padding-bottom: 5px;
        }
        .area-left{
            display: inline-block;
            width: 15%;
            float: left;
            margin-top: 10px;
            margin-left: 10px;
        }
        .area-right{
            display: inline-block;
            width: 78%;
            float: right;
        }
        .aR-info{
            padding: 10px 0;
            border-bottom: 2px dashed #ccc;
        }
        .region{
            margin-bottom: 5px;
        }
        .area-right :last-child.aR-info{
            padding-bottom: 0px;
            border-bottom: none;
        }
        .city{
            border-bottom: 2px dashed #ccc;
            overflow: hidden;
        }
        .province :last-child.city{
            border-bottom: none;
        }
        .alDifferent{
            top: -25px;
        }
        .region-info label{
            margin-right: 10px;
        }
		.single{
			display: none;
		}
		.selt select.form-control{
			width: 68px;
			display: inline-block;
		}
		.selm select.form-control{
			width: 150px;
			display: inline-block;
		}
		.time>.form-control {
    		width:100%
		}
		.alert_error{
			position: relative;
		}
		.alert_error label.error{
			position: absolute;
			top: 0;
			right: 0;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">工作室详情</a>
                </li>
            </ul>
        </div>
            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>工作室基本信息</span>
                </div>

			 <form id="form" class="form-horizontal">
			 	<input type="hidden" value="2" name="type"><!-- 区分工作室和团课 -->
			 	 <input type="hidden" value="${courseGroup.id }" name="courseExcGroup.id">
 				<input class="courseGroupType" type="hidden" name="courseExcGroup.type" value="${courseGroup.type }">
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	课程名称
                    </label>
                    <div class="col-sm-5">
                        ${courseGroup.coursename}
                    </div>
                </div>
		<%-- 		<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                	      每堂课人数
                    </label>
                    <div class="col-sm-5">
                        ${courseGroup.people}
                    </div>
                </div> --%>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                	      课程名额
                    </label>
                    <div class="col-sm-5">
                        ${courseGroup.maxpeople}
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	适用门店
                    </label>
                     <div class="col-sm-6 cleandiv" id="div_servicearea">
                      <c:forEach items="${area}" var="province" >
                    			 <c:forEach items="${province.cityList}" var="city">
                    					<c:forEach items="${city.regionList}" var="region">
	                    					     <c:forEach items="${region.storeList}" var="store">
	                    					    	  	<c:if test="${store.checked}">${store.storename }&nbsp;&nbsp;</c:if>
	                    					    </c:forEach>
                    					</c:forEach>
                    			</c:forEach>
                    	</c:forEach>
          <!--           	  <a class="btn" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a> -->
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	课程教练
                    </label>
                     <div class="col-sm-6 cleancoach" id="div_servicecoach">
	                     <c:forEach items="${coach}" var="items">
								<c:if test="${items.checked}">${items.coachname }</c:if>
							</c:forEach>
                    	 <!--  <a class="btn" data-toggle="modal" data-target="#choose_coachs" id="jiaolianchoose">选择教练</a> -->
                    </div>
                </div>


 			  <div class="form-group">
                    <label class="col-sm-1 control-label">
                      <span>*</span> 	课程图片
                    </label>
                    <div class="col-sm-8">
                        <!-- <div class="pr-upload"> -->
                            <!-- img id="showImg" src="<%=request.getContextPath() %>/assets/images/sc.png" style="width:265px;height:209px"/>
							<input type="file" id="uploadify"> -->
                        <!-- </div> -->

						<div class="img-box">
						               	 	<div id="div_upload">
						               	 	<img id="showImg" src="<c:choose>
						                		 <c:when test="${courseGroup.courseimg!=null && courseGroup.courseimg!=''}">
						                			 ${courseGroup.courseimg}
						                		 </c:when>
												  <c:otherwise>
												 		<%=request.getContextPath()%>/assets/js/uploadImg/img/a11.png
												  </c:otherwise>
						                		</c:choose>" style='width:217px;height:125px'
						               	 	class="add-img">
						               	 	<!-- <input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple /> -->
											</div>

						</div>
<%-- 						<aside class="mask works-mask">
							<div class="mask-content">
								<p class="del-p">您确定要删除作品图片吗？</p>
								<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
							</div>
						</aside>
					 	<div class="tip">
                    		<p>1.图片尺寸为750px*400px，大小不超过500K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    		  <input type="hidden" name="courseExcGroup.courseimg" id="mainfigure" value="${courseGroup.courseimg }">
                    	</div> --%>

                    </div>


                </div>


                <div class="form-group div_courseamount">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	课程金额
                    </label>
                     <div class="col-sm-5">
                        ${courseGroup.courseamount}
                    </div>
               </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                      	 总课时
                    </label>
                     <div class="col-sm-5">
                        ${courseGroup.totalhours}
                    </div>
               	</div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                      	课程详情
                    </label>
                     <div class="col-sm-5">
						<div class="tr-main">
                       		${courseGroup.coursedetail}
                    	</div>
                    </div>
               </div>

        </div>

<%--         <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/course/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
                </div>
        </div> --%>
                <div class="form-group component center">
                    <a class="btn btn-success" href="<%=request.getContextPath()%>/user/course/listPage">返回</a>
        </div>

    </div>



</body>


<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
 --%>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/course/edit_course_studio.js"></script>
<script>
//JavaScript Document
$(function(){
	$(".single").first().show();
	$(".menu .btn").click(function(){
		var index=$(".menu .btn").index(this);
		$(this).addClass("btn-inverse").siblings().removeClass("btn-inverse");
		$(".single").eq(index).show().siblings().hide();
	});

})
</script>
<script>
	    var editor1;

		KindEditor.ready(function(K) {
			 editor1 = K.create('textarea[name="courseExcGroup.coursedetail"]', {
				cssPath : '<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css',
				uploadJson : '<%=request.getContextPath()%>/assets/js/kindeditor/jsp/upload_json.jsp',//标识处理图片的文件
				fileManagerJson : '<%=request.getContextPath()%>/assets/js/kindeditor/jsp/file_manager_json.jsp',
				allowImageUpload:true,//允许上传图片
				allowFileManager : true,//允许上传文件和图片
			    afterCreate : function() {
		            this.sync();
		        },
		        afterBlur:function(){
		            this.sync();
		        }
			});

			prettyPrint();
		});
</script>

<script>

</script>
</html>
