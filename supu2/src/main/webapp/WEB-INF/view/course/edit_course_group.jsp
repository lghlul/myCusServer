<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑团课</title>
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
        .mDian{
            margin: 10% auto;
        }
		.single{
			display: none;
		}
		.selt>select.form-control{
			width: 68px;
			display: inline-block;
		}
		.selm>select.form-control{
			width: 150px;
			display: inline-block;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">编辑团课</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>团课基本信息</span>
                </div>

			 <form id="form" class="form-horizontal">
			 	<input type="hidden" value="1" name="type">
			 	<input type="hidden" value="${courseGroup.id }" name="courseExcGroup.id">
			 	<!-- <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                       	课程类型
                    </label>
                    <div class="col-sm-5">
                        <a id="a_course_pri" class="btn" style="color: #666">私教课</a>
                        <a class="btn" style="color: #4CA8EB">团课</a>
                    </div>
                </div> -->
                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	团课类型
                    </label>
                    <div class="col-sm-5 contentShow">
                    	<input type="radio" class="courseGroupType" name="courseExcGroup.type" <c:if test="${courseGroup.type==1 }"> checked="checked"</c:if> value="1" disabled="true">训练营
                    	 <input type="radio" class="courseGroupType" name="courseExcGroup.type" <c:if test="${courseGroup.type==2 }"> checked="checked"</c:if> value="2" disabled="true">基础团课

                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	课程名称
                    </label>
                    <div class="col-sm-5">
                        <input type="text" name="courseExcGroup.coursename" class="form-control" placeholder="请输入课程名称" required="required" maxlength="100" value="${courseGroup.coursename }">
                    </div>
                </div>
				<div class="form-group div_everyPeople" <c:if test="${courseGroup.type==1 }">style="display:none"</c:if>>
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                	       每堂课人数
                    </label>
                    <div class="col-sm-5">
                        <input type="number" id="coursepeople" name="courseExcGroup.people" class="form-control" placeholder="请输入每堂课人数"  maxlength="100" value="${courseGroup.people}">
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                	      课程名额
                    </label>
                    <div class="col-sm-5">
                        <input type="number" id="maxcoursepeople" name="courseExcGroup.maxpeople" class="form-control" placeholder="请输入最大课程名额"  maxlength="100" value="${courseGroup.maxpeople}">
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
                    	  <a class="btn" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a>
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
                    	  <a class="btn" data-toggle="modal" data-target="#choose_coachs" id="jiaolianchoose">选择教练</a>
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
									<section class=" img-section">

								<div class="z_photo upimg-div clear" >
  								<c:if test="${courseGroup.courseimg!=null && courseGroup.courseimg!='' }">
						               	<a id="delImg"><img class="close-img" src="<%=request.getContextPath()%>/assets/js/uploadImg/img/a7.png"></a>
						               	</c:if>
						               	 <section class="z_file fl">
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
						               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
											</div>
						               	 </section>
						         </div>
							 </section>
						</div>
						<aside class="mask works-mask">
							<div class="mask-content">
								<p class="del-p">您确定要删除作品图片吗？</p>
								<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
							</div>
						</aside>
					 	<div class="tip">
                    		<p>1.图片尺寸为750px*400px，大小不超过500K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    		  <input type="hidden" name="courseExcGroup.courseimg" id="mainfigure" value="${courseGroup.courseimg }">
                    	</div>

                    </div>


                </div>
				<%-- <div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                      	 课程时间
                    </label>
                    <input type="hidden" name="courseExcGroup.coursetimetype" id="chooseCourseTimeType" value="${courseGroup.coursetimetype }">
                     <div class="col-sm-5 menu">
 		                     	<a href="javascript:;" class="btn btn-default <c:if test="${courseGroup.coursetimetype==1 }">btn-inverse</c:if> coursertimetype" data-id="1">指定日期</a>
		                     	<a href="javascript:;" class="btn btn-default <c:if test="${courseGroup.coursetimetype==2 }">btn-inverse</c:if> coursertimetype" data-id="2">每天</a>
		                     	<a href="javascript:;" class="btn btn-default <c:if test="${courseGroup.coursetimetype==3 }">btn-inverse</c:if> coursertimetype" data-id="3">每周</a>
		                     	<a href="javascript:;" class="btn btn-default <c:if test="${courseGroup.coursetimetype==4 }">btn-inverse</c:if> coursertimetype" data-id="4">每月</a>
                    </div>
               	</div> --%>
<%--
				<div class="form-group">
				<c:choose>
					<c:when test="${courseGroup.coursetimetype==1 }">
						<div class="col-sm-5 col-sm-offset-1">
	                     <!-- “指定日期”内容 -->
						 <div class="single" id="specDate">

 	                        <div class="form-group">
								<div class="contractBeginDay time">
										<input type="text" name="courseExcGroup.startdate" class="form-control"
										 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value="<fmt:formatDate value="${courseGroup.startdate}"/>">
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
								至
								<div class="contractBeginDay time">

										<input type="text" name="courseExcGroup.enddate" class="form-control"
										 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value="<fmt:formatDate value="${courseGroup.enddate}"/>">
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>

							<div class="form-group selt">
								<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${startHour}" var="item" varStatus="status">
									 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
		                       	</select>
								-
		                        <select name="courseExcGroup.startmin" class="form-control">
										<!-- <option value="" selected="selected">分</option> -->
										 <c:forEach items="${startMinutes}" var="item" varStatus="status">
												<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
										 </c:forEach>
		                        </select>
		                      	 至
		                      	<select name="courseExcGroup.endhour" class="form-control">
		                       		<!-- <option value="">时</option> -->
										 <c:forEach items="${endHour}" var="item" varStatus="status">
										 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>>${item.value}</option>
										 </c:forEach>
		                        </select>
								-
		                        <select name="courseExcGroup.endmin" class="form-control">
										<!-- <option value="" selected="selected">分</option> -->
										 <c:forEach items="${endMinutes}" var="item" varStatus="status">
												<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>>${item.value}</option>
										 </c:forEach>
		                        </select>
		                 	</div>

						  </div>
						 <!-- “每天”内容 -->
						 <div class="single" id="eveDay">

						   <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						  </div>

						    <div class="form-group">
	                       		 课程预计开始日期
									<div class="contractBeginDay time">

										 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>

									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>
						 </div>
						 <!-- “每周”内容 -->
						 <div class="single" id="eveWeek">

						   <div class="form-group">
					 		<c:forEach items="${week }" var="item">
						 		<label><input name="courseExcGroup.week" type="checkbox" value="${item.basicvalue}"/>${item.title }</label>
						 	</c:forEach>
						   </div>

						  <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						  </div>

						    <div class="form-group">
	                                                                                     课程预计开始日期
								<div class="contractBeginDay time">
													 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
								</div>

							</div>
						 </div>
						 <!-- “每月”内容 -->
						 <div class="single" id="eveMonth">

						   <div class="form-group selm">
						 	<select name="courseExcGroup.startmonth" class="form-control">
								<!-- 	<option value="" selected="selected">每月几号</option> -->
									 <c:forEach items="${months}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endmonth" class="form-control">
	                       		<!-- <option value="">每月几号</option> -->
									 <c:forEach items="${months}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						   </div>

						   <div class="form-group selt">
							<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						   </div>

							<div class="form-group">
	                                                                                    课程预计开始日期
								<div class="contractBeginDay time">

													 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>
						 </div>
	                  </div>
					</c:when>
					<c:when test="${courseGroup.coursetimetype==2 }">
						<div class="col-sm-5 col-sm-offset-1">
	                     <!-- “指定日期”内容 -->
						 <div class="single" id="specDate">

	                          <div class="form-group">
								<div class="contractBeginDay time">
										<input type="text" name="courseExcGroup.startdate" class="form-control"
										 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
								至
								<div class="contractBeginDay time">

										<input type="text" name="courseExcGroup.enddate" class="form-control"
										 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							  </div>

							  <div class="form-group selt">
								<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
		                       	</select>
								-
		                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- 	<option value="" selected="selected">分</option> -->
										 <c:forEach items="${minutes}" var="item" varStatus="status">
												<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
		                      	 至
		                      	<select name="courseExcGroup.endhour" class="form-control">
		                       		<!-- <option value="">时</option> -->
										 <c:forEach items="${hour}" var="item" varStatus="status">
										 		<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
								-
		                        <select name="courseExcGroup.endmin" class="form-control">
										<!-- <option value="" selected="selected">分</option> -->
										 <c:forEach items="${minutes}" var="item" varStatus="status">
												<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
		                      </div>
						  </div>
						 <!-- “每天”内容 -->
						 <div class="single" id="eveDay">

						   <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${startHour}" var="item" varStatus="status">
									 		<option value="${item.value}"  <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${startMinutes}" var="item" varStatus="status">
											<option value="${item.value}"  <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${endHour}" var="item" varStatus="status">
									 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${endMinutes}" var="item" varStatus="status">
											<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
						  </div>

							<div class="form-group">
	                       		 课程预计开始日期
								<div class="contractBeginDay time">
												 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
								</div>
							</div>
						 </div>
						 <!-- “每周”内容 -->
						 <div class="single" id="eveWeek">

						   <div class="form-group">
					 		<c:forEach items="${week }" var="item">
						 		<label><input name="courseExcGroup.week" type="checkbox" value="${item.basicvalue}"/>${item.title }</label>
						 	</c:forEach>
						   </div>

						   <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
								<!-- 	<option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						  </div>
							<div class="form-group">
	                                                                                    课程预计开始日期
								<div class="contractBeginDay time">

													 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>
						 </div>
						 <!-- “每月”内容 -->
						 <div class="single" id="eveMonth">

						   <div class="form-group selm">
						 	<select name="courseExcGroup.startmonth" class="form-control">
									<option value="" selected="selected">每月几号</option>
									 <c:forEach items="${months}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endmonth" class="form-control">
	                       		<option value="">每月几号</option>
									 <c:forEach items="${months}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						   </div>

						  <div class="form-group selt">
							<select name="courseExcGroup.starthour" class="form-control">
	                       	<!-- 	<option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       	<!-- 	<option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						   </div>

							 <div class="form-group">
	                                                                                    课程预计开始日期
								<div class="contractBeginDay time">

													 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							 </div>
						 </div>
	                  </div>
					</c:when>
					<c:when test="${courseGroup.coursetimetype==3 }">
						<div class="col-sm-5 col-sm-offset-1">
	                     <!-- “指定日期”内容 -->
						 <div class="single" id="specDate">

						 	<div class="form-group">
								<div class="contractBeginDay time">

										<input type="text" name="courseExcGroup.startdate" class="form-control"
										 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
								至
								<div class="contractBeginDay time">

										<input type="text" name="courseExcGroup.enddate" class="form-control"
										 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>

							<div class="form-group selt">
								<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
		                       	</select>
								-
		                        <select name="courseExcGroup.startmin" class="form-control">
										<!-- <option value="" selected="selected">分</option> -->
										 <c:forEach items="${minutes}" var="item" varStatus="status">
												<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
		                      	 至
		                      	<select name="courseExcGroup.endhour" class="form-control">
		                       		<!-- <option value="">时</option> -->
										 <c:forEach items="${hour}" var="item" varStatus="status">
										 		<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
								-
		                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- 	<option value="" selected="selected">分</option> -->
										 <c:forEach items="${minutes}" var="item" varStatus="status">
												<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
		                    </div>
						  </div>
						 <!-- “每天”内容 -->
						 <div class="single" id="eveDay">

						   <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						  </div>

							<div class="form-group">
	                       		课程预计开始日期
								<div class="contractBeginDay time">
										 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
								</div>
							</div>
						 </div>
						 <!-- “每周”内容 -->
						 <div class="single" id="eveWeek">

						   <!-- <div class="col-sm-12"> -->
						   <div class="form-group">
					 		<c:forEach items="${weekcheck }" var="item">
						 		<label><input name="courseExcGroup.week" type="checkbox" value="${item.basicvalue}" <c:if test="${item.checked }"> checked="checked"</c:if>/>${item.title }</label>
						 	</c:forEach>
						   </div>

						  <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       	<!-- 	<option value="">时</option> -->
									 <c:forEach items="${startHour}" var="item" varStatus="status">
									 		<option value="${item.value}"  <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${startMinutes}" var="item" varStatus="status">
											<option value="${item.value}"  <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       	<!-- 	<option value="">时</option> -->
									 <c:forEach items="${endHour}" var="item" varStatus="status">
									 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${endMinutes}" var="item" varStatus="status">
											<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
						  </div>

							<div class="form-group">
	                                                                                    课程预计开始日期
								<div class="contractBeginDay time">

										 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
								</div>
							</div>
						 </div>
						 <!-- “每月”内容 -->
						 <div class="single"  id="eveMonth">

						   <div class="form-group selm">
						 	<select name="courseExcGroup.startmonth" class="form-control">
									<option value="" selected="selected">每月几号</option>
									 <c:forEach items="${months}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endmonth" class="form-control">
	                       		<option value="">每月几号</option>
									 <c:forEach items="${months}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						   </div>

						  <div class="form-group selt">
							<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						   </div>

							 <div class="form-group">
	                                                                                    课程预计开始日期
								<div class="contractBeginDay time">

													 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							 </div>
						 </div>
	                  </div>
					</c:when>
					<c:when test="${courseGroup.coursetimetype==4 }">
						<div class="col-sm-5 col-sm-offset-1">
	                     <!-- “指定日期”内容 -->
						 <div class="single" id="specDate">

	                        <div class="form-group">
								<div class="contractBeginDay time">

										<input type="text" name="courseExcGroup.startdate" class="form-control"
										 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
								至
								<div class="contractBeginDay time">

										<input type="text" name="courseExcGroup.enddate" class="form-control"
										 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>

							<div class="form-group selt">
								<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
		                       	</select>
								-
		                        <select name="courseExcGroup.startmin" class="form-control">
										<!-- <option value="" selected="selected">分</option> -->
										 <c:forEach items="${minutes}" var="item" varStatus="status">
												<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
		                      	 至
		                      	<select name="courseExcGroup.endhour" class="form-control">
		                       		<!-- <option value="">时</option> -->
										 <c:forEach items="${hour}" var="item" varStatus="status">
										 		<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
								-
		                        <select name="courseExcGroup.endmin" class="form-control">
										<!-- <option value="" selected="selected">分</option> -->
										 <c:forEach items="${minutes}" var="item" varStatus="status">
												<option value="${item}"> ${item}</option>
										 </c:forEach>
		                        </select>
		                      </div>
						  </div>
						 <!-- “每天”内容 -->
						 <div class="single" id="eveDay">
						   <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						  </div>

							<div class="form-group">
	                       		课程预计开始日期
								<div class="contractBeginDay time">
												 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>
						 </div>
						 <!-- “每周”内容 -->
						 <div class="single" id="eveWeek">

						   <div class="form-group">
					 		<c:forEach items="${week }" var="item">
						 		<label><input name="courseExcGroup.week" type="checkbox" value="${item.basicvalue}"/>${item.title }</label>
						 	</c:forEach>
						   </div>

						   <div class="form-group selt">
						 	<select name="courseExcGroup.starthour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       		<!-- <option value="">时</option> -->
									 <c:forEach items="${hour}" var="item" varStatus="status">
									 		<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${minutes}" var="item" varStatus="status">
											<option value="${item}"> ${item}</option>
									 </c:forEach>
	                        </select>
						  </div>

							<div class="form-group">
	                                                                                    课程预计开始日期
								<div class="contractBeginDay time">

													 <c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
									<!-- <i class="icon iconfont data type1"></i> -->
								</div>
							</div>
						 </div>
						 <!-- “每月”内容 -->
						 <div class="single"  id="eveMonth">

						   <div class="form-group selm">
						 	<select name="courseExcGroup.startmonth" class="form-control">
									<option value="" selected="selected">每月几号</option>
									 <c:forEach items="${startDay}" var="item" varStatus="status">
											<option value="${item.value}"  <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endmonth" class="form-control">
	                       		<option value="">每月几号</option>
									 <c:forEach items="${endDay}" var="item" varStatus="status">
									 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
						   </div>

						   <div class="form-group selt">
							<select name="courseExcGroup.starthour" class="form-control">
	                       	<!-- 	<option value="">时</option> -->
									 <c:forEach items="${startHour}" var="item" varStatus="status">
									 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                       	</select>
							-
	                        <select name="courseExcGroup.startmin" class="form-control">
									<!-- <option value="" selected="selected">分</option> -->
									 <c:forEach items="${startMinutes}" var="item" varStatus="status">
											<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
	                      	 至
	                      	<select name="courseExcGroup.endhour" class="form-control">
	                       	<!-- 	<option value="">时</option> -->
									 <c:forEach items="${endHour}" var="item" varStatus="status">
									 		<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
							-
	                        <select name="courseExcGroup.endmin" class="form-control">
								<!-- 	<option value="" selected="selected">分</option> -->
									 <c:forEach items="${endMinutes}" var="item" varStatus="status">
											<option value="${item.value}" <c:if test="${item.checked }">selected="selected"</c:if>> ${item.value}</option>
									 </c:forEach>
	                        </select>
						   </div>

							<div class="form-group">
	                                                                                     课程预计开始日期
								<div class="contractBeginDay time">

										<c:choose>
										   <c:when test="${courseGroup.courseexpstart!='' && courseGroup.courseexpstart!=null}">
												<input type="text"
													 value="<fmt:formatDate value="${courseGroup.courseexpstart}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:when>
										   <c:otherwise>
													<input type="text"
													 value="<fmt:formatDate value="${date}"/>"
													name="courseExcGroup.courseexpstart" class="form-control"
													 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
										   </c:otherwise>
										</c:choose>
								</div>
							</div>
						 </div>
	                  </div>
					</c:when>
				</c:choose>


               </div> --%>

                <div class="form-group div_courseamount" <c:if test="${courseGroup.type==2 }">style="display:none"</c:if>>
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	课程金额
                    </label>
                     <div class="col-sm-5">
                        <input type="number" name="courseExcGroup.courseamount" class="form-control" placeholder="请输入课程金额" value="${courseGroup.courseamount}">
                    </div>
               </div>

                <div class="form-group div_totalhours" <c:if test="${courseGroup.type==2 }">style="display:none"</c:if>>
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                      	 总课时
                    </label>
                     <div class="col-sm-5">
                        <input type="number" name="courseExcGroup.totalhours" class="form-control" placeholder="请输入总课时" value="${courseGroup.totalhours }">
                    </div>
               	</div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                      	课程详情
                    </label>
                     <div class="col-sm-5">
						<div class="tr-main">
                       		<textarea name="courseExcGroup.coursedetail" id="courseDetail"  style="width:700px;height:300px;" >${courseGroup.coursedetail }</textarea>
                    	</div>
                    </div>
               </div>

			<%-- 	<div class="form-group">
                	<label class="col-sm-1 control-label">
                   	 	选项卡
                	</label>
                	<div class="col-sm-5">
                    	<div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" <c:if test="${courseGroup.coursetab==1 }">checked</c:if>/>
                        	<label class="onoffswitch-label" for="myonoffswitch">
                            	<div class="onoffswitch-inner">
                                	<div class="onoffswitch-active"  id="div_on">ON</div>
                                	<div class="onoffswitch-inactive" id="div_off">OFF</div>
                            	</div>
                            	<div class="onoffswitch-switch"></div>
                        	</label>
                        	<input type="hidden" value="1" name="courseExcGroup.coursetab" id="coursetab">
                    	</div>
                	</div>
            	</div> --%>
<%--
               <div class="form-group">
               <c:choose>
               	<c:when test="${courseGroup.coursetab==1 }">
               		<div class="tr-main tabDetail">
	                 	<label class="col-sm-1 control-label">
	                   	 	标题
	                	</label>


	                    <div class="col-sm-5">
								<input type="text" class="form-control" placeholder="请输入标题" maxlength="100" name="courseExcGroup.coursetitle" id="coursetitle" value="${courseGroup.coursetitle }">
	                       		<textarea name="courseExcGroup.tabdetail" id="tabDetail"  style="width:700px;height:300px;" >${courseGroup.tabdetail }</textarea>
	                    </div>
                    </div>

               	</c:when>
               	<c:otherwise>
					 <div class="tr-main tabDetail" style="display:none">
	                 	<label class="col-sm-1 control-label">
	                   	 	标题
	                	</label>


	                    <div class="col-sm-5">
								<input type="text" class="form-control" placeholder="请输入标题" name="courseExcGroup.coursetitle" id="coursetitle" value="${courseGroup.coursetitle }">
	                       		<textarea name="courseExcGroup.tabdetail" id="tabDetail"  style="width:700px;height:300px;" >${courseGroup.tabdetail }</textarea>
	                    </div>
                    </div>
               	</c:otherwise>
               </c:choose>
		</div> --%>



        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/course/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
                </div>
        </div>

		    <!--门店选择框 -->
    <div class="modal fade" id="choose_stores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog mDian">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close surechoose" data-dismiss="modal" aria-hidden="true">
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
	                    					    	  	 <label><input name="courseExcGroup.stores" class="stores" type="checkbox" value="${store.id}"<c:if test="${store.checked}">checked="checked"</c:if> data-name="${store.storename }"/>${store.storename }</label>
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
					<button type="button" class="btn btn-default surechoose" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>


   <!--教练选择框 -->
    <div class="modal fade" id="choose_coachs" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog mDian">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close coachsure" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        教练选择&nbsp;&nbsp;<span></span>
                    </h4>
                </div>
                <div class="modal-body">
						<c:forEach items="${coach}" var="items">
							<input type="checkbox" name="courseExcGroup.coachs"  class="coachs" <c:if test="${items.checked}">checked="checked"</c:if>  value="${items.id }" data-name="${items.coachname }">${items.coachname}
						</c:forEach>
                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
					<button type="button" class="btn btn-default coachsure" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
         </form>
    </div>
		  <!--弹出内容-->
        <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-success" id="myModalLabel">
                           <i class="iconfont">&#xe6bf;</i>
                           	编辑成功！
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!-- <a id="a_infoLink" class="btn btn-default" href="">查看咨询</a> -->
                       <!--  <a class="btn btn-primary" href="javascript:void(0)">复制链接</a> -->
                        <%-- <a class="btn btn-info" href="<%=request.getContextPath() %>/user/realseInfo/listPage">返回资讯管理</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/realseInfo/addPage">继续发布</a> --%>
                    </div>
                    <div class="modal-footer">
                    <!-- 	<a id="a_infoLink" class="btn btn-default" href="">查看咨询</a> -->
                       <!--  <a class="btn btn-primary" href="javascript:void(0)">复制链接</a> -->
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/course/listPage">返回课程列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/course/editPage?type=1&id=${courseGroup.id }">继续编辑</a>
                        <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭 -->
                        </button>
                   <!--      <button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
                    </div>
                </div>
            </div>
        </div>


          <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="failure" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe643;</i>
                          	  编辑失败！
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!-- <a class="btn btn-default" href="javascript:void(0)">取消</a>
                        <a class="btn btn-success" href="javascript:void(0)">返回修改</a> -->
                    </div>
                    <div class="modal-footer">
                    	<!-- <button class="btn btn-default" href="javascript:void(0)">取消</button> -->
                       <!--  <button class="btn btn-success" href="javascript:void(0)">重新发布</button> -->
                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <!-- button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
                    </div>
                </div>
            </div>
        </div>





</body>


<script>
	var baseUrl = '${pageContext.request.contextPath}';
	//团课类型
	var courseGroupType='${courseGroup.type}';
</script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/course/edit_course_group.js"></script>
<script>
//JavaScript Document
$(function(){
	 //显示课程时间类型
	var type="${courseGroup.coursetimetype}";
	if(type==1){

		$(".single:eq(0)").show();
		$('#specDate *').attr("disabled",false);

		$("#eveDay *").attr("disabled",true);
		$("#eveWeek *").attr("disabled",true);
		$("#eveMonth *").attr("disabled",true);

		/* $(".single").first().show(); */
	}else if(type==2){
		$(".single:eq(1)").show();
		$("#eveDay *").attr("disabled",false);

		$('#specDate *').attr("disabled",true);
		$("#eveWeek *").attr("disabled",true);
		$("#eveMonth *").attr("disabled",true);

		/* $(".single").second().show(); */
	}else if(type==3){
		$(".single:eq(2)").show();
		$("#eveWeek *").attr("disabled",false);

		$("#eveDay *").attr("disabled",true);
		$('#specDate *').attr("disabled",true);
		$("#eveMonth *").attr("disabled",true);


		/* $(".single").third().show(); */
	}else if(type==4){
		$(".single:eq(3)").show();
		$("#eveMonth *").attr("disabled",false);

		$("#eveDay *").attr("disabled",true);
		$('#specDate *').attr("disabled",true);
		$("#eveWeek *").attr("disabled",true);


		/* $(".single").fourth().show(); */
	}
 	else{
		$(".single:eq(0)").show();
	}
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
	    var editor2;

		KindEditor.ready(function(K) {
			 editor2 = K.create('textarea[name="courseExcGroup.tabdetail"]', {
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
