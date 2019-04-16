<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>私教课详情</title>
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
		.special{
			width: 3%!important;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">私教课详情</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>私教课基本信息</span>
                </div>

			 <form id="form" class="form-horizontal">

			<input type="hidden" value="${coursePriCoach.id}" name="coursePriCoach.id">
			 <input type="hidden" name="type" value="0">
				<!-- <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                       	课程类型
                    </label>
                    <div class="col-sm-5">
                        <a class="btn btn-success">私教课</a>
                        <a id="a_course_group" class="btn btn-default">精品团课</a>
                    </div>
                </div> -->
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                	         	   课程健身需求
                    </label>
                    <div class="col-sm-5 contentShow">
                    	<c:forEach items="${courseFitDemand}" var="item" varStatus="status">

  									  <label>
  									   <c:if test="${item.checked}">
  									   	${item.title}
  									    </c:if>
		  									 <%--  <input name="coursePriCoach.fitdemand" type="radio"
		  									  <c:if test="${item.checked}"> checked="checked" </c:if>

		  									   value="${item.basicvalue}" />${item.title} --%>
  									   </label>
                    	</c:forEach>

                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                       	课程名称
                    </label>
                    <div class="col-sm-5 contentShow">
                   		 ${coursePriCoach.coursename }
                    	<%--  <input type="text" name="coursePriCoach.coursename" value="${coursePriCoach.coursename }" class="form-control" placeholder="输入课程名称"> --%>
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	<span>*</span>
                       	课程金额
                    </label>
                    <div class="col-sm-1 contentShow special">
                    	${coursePriCoach.courseamount }
                    </div>
                    <div class="col-sm-1 contentShow">
                    	元 / 课时
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                      	 起售课时
                    </label>
                    <div class="col-sm-1 contentShow special">
                    	${coursePriCoach.totalhours }
                    </div>
                    <div class="col-sm-1 contentShow">
                    	课时
                    </div>
               	</div>

               	<div class="form-group">
                    <label class="col-sm-1 control-label">
                      <span>*</span> 	课程图片
                    </label>
                    <div class="col-sm-5">
                        <!-- <div class="pr-upload"> -->
                            <!-- img id="showImg" src="<%=request.getContextPath() %>/assets/images/sc.png" style="width:265px;height:209px"/>
							<input type="file" id="uploadify"> -->
                        <!-- </div> -->

						<div class="img-box">
						<img id="showImg" src="<c:choose>
						                		 <c:when test="${coursePriCoach.courseimg!=null && coursePriCoach.courseimg!=''}">
						                			 ${coursePriCoach.courseimg}
						                		 </c:when>
												  <c:otherwise>
												 		<%=request.getContextPath()%>/assets/js/uploadImg/img/a11.png
												  </c:otherwise>
						                		</c:choose>" style='width:217px;height:125px'
						               	 	class="add-img">
									<%-- <section class=" img-section">

								<div class="z_photo upimg-div clear" >
  								<c:if test="${coursePriCoach.courseimg!=null && coursePriCoach.courseimg!='' }">
						               	<a id="delImg"><img class="close-img" src="<%=request.getContextPath()%>/assets/js/uploadImg/img/a7.png"></a>
						               	</c:if>
						               	 <section class="z_file fl">
						               	 	<div id="div_upload">
						               	 	<img id="showImg" src="<c:choose>
						                		 <c:when test="${coursePriCoach.courseimg!=null && coursePriCoach.courseimg!=''}">
						                			 ${coursePriCoach.courseimg}
						                		 </c:when>
												  <c:otherwise>
												 		<%=request.getContextPath()%>/assets/js/uploadImg/img/a11.png
												  </c:otherwise>
						                		</c:choose>" style='width:217px;height:125px'
						               	 	class="add-img">
						               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
											</div>
						               	 </section>
						         </div>
							 </section> --%>
						</div>
				<!-- 		<aside class="mask works-mask">
							<div class="mask-content">
								<p class="del-p">您确定要删除作品图片吗？</p>
								<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
							</div>
						</aside> -->
					<!-- 	<div class="tip">
                    		<p>1.图片尺寸为580*335，大小不超过100K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    	</div> -->

                    </div>

               <%--      <input type="hidden" name="coursePriCoach.courseimg" id="mainfigure" value="${coursePriCoach.courseimg }"> --%>

                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                      	课程详情
                    </label>
                    <div class="col-sm-5 contentShow">${coursePriCoach.coursetitle }
						<%-- <input type="text" name="coursePriCoach.coursetitle" value="${coursePriCoach.coursetitle }" class="form-control" placeholder="请输入标题"> --%>
                    </div>
               </div>

               <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<!-- <span>*</span> -->

                    </label>
                    <div class="col-sm-8">
                    	<div class="tr-main">
                    		${coursePriCoach.coursedetail }
                      		<%--   <textarea name="coursePriCoach.coursedetail" value="${coursePriCoach.coursedetail }" id="pcservicedetail"  style="width:700px;height:300px;">${coursePriCoach.coursedetail }</textarea> --%>
                    	</div>
                	</div>
               </div>

               <div class="form-group" id="div_choseStores">
                    <label class="col-sm-1 control-label">
                       	适用门店
                    </label>
                     <div class="col-sm-6" id="div_servicearea">
                    	  <!-- <a class="btn" data-toggle="modal" data-target="#choose_stores">选择门店</a> -->

			      <c:forEach items="${area}" var="province" >
			                           <c:forEach items="${province.cityList}" var="city">
			                              <c:forEach items="${city.regionList}" var="region">
			                                     <c:forEach items="${region.storeList}" var="store">
			                                          <c:if test="${store.checked}">${store.storename }&nbsp;&nbsp;</c:if>
			                                    </c:forEach>
			                              </c:forEach>
			                          </c:forEach>
			                      </c:forEach>
                    </div>
                </div>

				<div class="form-group" id="div_choseCoachs">
                    <label class="col-sm-1 control-label">
                       	课程教练
                    </label>
                     <div class="col-sm-6" id="div_servicearea">
                     <c:forEach items="${coach}" var="items">
							<c:if test="${items.checked}">${items.coachname }</c:if>
						</c:forEach>
                    	<!--   <a class="btn" data-toggle="modal" data-target="#choose_coachs">选择教练</a> -->
                    </div>
                </div>

        </div>
                <div class="form-group component center">
                    <a class="btn btn-success" href="<%=request.getContextPath()%>/user/course/listPage">返回</a>
        </div>

     <%--    <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/coach/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
                </div>
        </div> --%>
        	    <!--门店选择框 -->
    <div class="modal fade" id="choose_stores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        门店选择&nbsp;&nbsp;<span></span>
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="province">
                    	<c:forEach items="${area}" var="province" >
                    			<div class="province-info">${province.name}</div>

                    			 <c:forEach items="${province.cityList}" var="city">
                    				<div class="city">
                    					<div class="area-left">${city.name}</div>

                    					<c:forEach items="${city.regionList}" var="region">
                    					  <div class="area-right">

	                    					   <div class="aR-info">
	                    					      <div class="region">${region.name}</div>
	                    					      <div class="region-info">
	                    					      		<c:forEach items="${region.storeList}" var="store">
	                    					      			 <label><input name="stores" class="stores" type="checkbox" value="${store.id}"<c:if test="${store.checked}">checked="checked"</c:if>/>${store.storename }</label>
	                    					    	  <%-- 	 <label>
	                    					    	  	 <c:if test="${store.checked}">
	                    						    	  	 <label><input name="stores" class="stores"  disabled="disabled" type="checkbox" value="${store.id}"<c:if test="${store.checked}">checked="checked"</c:if>/>${store.storename }</label>
	                    					    	  	 </c:if>
	                    					    	  	 <input name="coursePriCoach.stores" class="stores" type="checkbox" value="${store.id}" <c:if test="${store.checked}">checked="checked"</c:if>/>${store.storename }
	                    					    	  	 </label> --%>
	                    					    	   </c:forEach>
	                    					      </div>
	                    					   </div>
                    					  </div>

                    					</c:forEach>
                    				</div>
                    			</c:forEach>

                    	</c:forEach>
                    </div>
                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>


   <!--教练选择框 -->
   <%--  <div class="modal fade" id="choose_coachs" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        教练选择&nbsp;&nbsp;<span></span>
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="province">
						<c:forEach items="${coach}" var="items">
						<c:if test="${items.checked}">${items.coachname} </c:if>
							<input type="checkbox" name="coursePriCoach.coachs"  class="coachs" <c:if test="${items.checked}">checked="checked"</c:if>  value="${items.id }">${items.coachname}
						</c:forEach>
                    </div>
                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
 --%>
         </form>
    </div>


</body>


<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/course/edit_course_pri.js"></script>


<script>
	    var editor1;

		KindEditor.ready(function(K) {
			 editor1 = K.create('textarea[name="coursePriCoach.coursedetail"]', {
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
</html>
