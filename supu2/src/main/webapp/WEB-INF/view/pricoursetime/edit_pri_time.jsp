<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>私教时间编辑</title>
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
		.special{
			width: 5%!important;
		}
        .import-tip{
            padding-left: 5px;
            margin-top: 10px;
            color: #999;
        }
        .modal-title>span{
            font-size: 18px;
        }
		.single{
			display: none;
		}
		.contentShow{
			padding: 7px;
		}
		.contractDay-menu{
			display: inline-block;
		}
		.border{
			border: 1px solid #ccc;
			padding: 20px;
			border-radius: 8px;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">私教时间编辑</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>信息</span>
                </div>

			 <form id="form" method="post" class="form-horizontal" action="<%=request.getContextPath()%>/user/pricoursetime/editSave">
			 	<!-- <input type="hidden" value="1" name="type"> -->
			 	<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	教练
                    </label>
                    <div class="col-sm-1 contentShow" id="div_servicearea">
                             ${coach.coachname }
                             <input type="hidden" value="${coach.id }" name="coachs[0].id">

                            <%--  <input type="hidden" value="${date}" name="date"> --%>
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	选择月份
                    </label>
                    <div class="col-sm-2">
                  		  ${date}

                  		  <input type="hidden" value="${date}" name="date" >
						<%-- <input type="text" value="${date}" name="date" class="form-control"
						placeholder="选择月份" onclick="WdatePicker({dateFmt:'yyyy-MM'});"> --%>
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                		选择时间
                    </label>
                    <div class="col-sm-9">

                       <!-- "1号" -->
                      <!-- “一号” -->
							<div class="form-group border">
								<div class="col-sm-1">一号</div>
								<div class="col-sm-8">
									<!-- 添加一层 -->
									<c:choose>
									<c:when test="${caochTime.coachTimeList01== null || fn:length(caochTime.coachTimeList01) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[0].startTime" value="${item.starttime }"
														 name="coachTimeList[0].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[0].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[0].endTime" value="${item.endtime }"
														 name="coachTimeList[0].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[0].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[0].type" value="1">

												<input type="hidden" value="01" name="coachTimeList[0].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList01}" var="item" varStatus="status">
										   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${status.index}].startTime"  value="${item.starttime }"
														name="coachTimeList[${status.index}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[0].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${status.index}].endTime" value="${item.endtime }" name="coachTimeList[${status.index}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[0].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${status.index}].type" value="1">

												<input type="hidden" value="01" name="coachTimeList[${status.index}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									  	</c:forEach>
									  	</c:otherwise>
								  	</c:choose>


								</div>


							</div>
							<!-- “二号” -->
							<div class="form-group border">
								<div class="col-sm-1">二号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList02== null || fn:length(caochTime.coachTimeList02) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${caochTime.count1}].startTime"
														 value="${item.starttime }" name="coachTimeList[${caochTime.count1}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count1}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${caochTime.count1}].endTime"
														 value="${item.starttime }" name="coachTimeList[${caochTime.count1}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count1}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count1}].type" value="1">

												<input type="hidden" value="02" name="coachTimeList[${caochTime.count1}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList02}" var="item" varStatus="status">
										  <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${caochTime.count1+status.index}].startTime"
														value="${item.starttime }" name="coachTimeList[${caochTime.count1+status.index}].startTime" class="form-control"

														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count1+status.index}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${caochTime.count1+status.index}].endTime"
														 value="${item.endtime }" name="coachTimeList[${caochTime.count1+status.index}].endTime" class="form-control"

														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count1+status.index}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count1+status.index}].type" value="1">

												<input type="hidden" value="02" name="coachTimeList[${caochTime.count1+status.index}].day">
												<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “三号” -->
							<div class="form-group border">
								<div class="col-sm-1">三号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList03== null || fn:length(caochTime.coachTimeList03) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count2}].startTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count2}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count2}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count2}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count2}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count2}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count2}].type" value="1">

												<input type="hidden" value="03" name="coachTimeList[${caochTime.count2}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
								<c:forEach items="${caochTime.coachTimeList03}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input id="coachTimeList[${caochTime.count2+status.index}].startTime" type="text"
												value="${item.starttime }"  name="coachTimeList[${caochTime.count2+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count2+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input id="coachTimeList[${caochTime.count2+status.index}].endTime" type="text"
												 value="${item.endtime }" name="coachTimeList[${caochTime.count2+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count2+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count2+status.index}].type" value="1">
											<input type="hidden" value="03" name="coachTimeList[${caochTime.count2+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate"  type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “四号” -->
							<div class="form-group border">
								<div class="col-sm-1">四号</div>
								<div class="col-sm-8">
									<c:choose>
									<c:when test="${caochTime.coachTimeList04== null || fn:length(caochTime.coachTimeList04) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count3}].startTime" type="text" value="${item.starttime }"
														name="coachTimeList[${caochTime.count3}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count3}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count3}].endTime" type="text"
														 value="${item.starttime }" name="coachTimeList[${caochTime.count3}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count3}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count3}].type" value="1">

												<input type="hidden" value="04" name="coachTimeList[${caochTime.count3}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList04}" var="item" varStatus="status">
										  <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count3+status.index}].startTime"
														 type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count3+status.index}].startTime" class="form-control"

														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count3+status.index}].endTime\')}'});">

													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count3+status.index}].endTime"
														 type="text" value="${item.endtime }" name="coachTimeList[${caochTime.count3+status.index}].endTime" class="form-control"

														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count3+status.index}].startTime\')}'});">

													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count3+status.index}].type" value="1">
												<input type="hidden" value="04" name="coachTimeList[${caochTime.count3+status.index}].day">
												<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
										  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “五号” -->
							<div class="form-group border">
								<div class="col-sm-1">五号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList05== null || fn:length(caochTime.coachTimeList05) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count4}].startTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count4}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count4}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count4}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count4}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count4}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count4}].type" value="1">

												<input type="hidden" value="05" name="coachTimeList[${caochTime.count4}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList05}" var="item" varStatus="status">
										  <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count4+status.index}].startTime"
														 type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count4+status.index}].startTime" class="form-control"

														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count4+status.index}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count4+status.index}].endTime"
														 type="text" value="${item.endtime }"
														name="coachTimeList[${caochTime.count4+status.index}].endTime" class="form-control"

														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count4+status.index}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count4+status.index}].type" value="1">
												<input type="hidden" value="05" name="coachTimeList[${caochTime.count4+status.index}].day">
												<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
										  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “六号” -->
							<div class="form-group border">
								<div class="col-sm-1">六号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList06== null || fn:length(caochTime.coachTimeList06) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count5}].startTime" type="text" value="${item.starttime }"
														name="coachTimeList[${caochTime.count5}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count5}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count5}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count5}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count5}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count5}].type" value="1">

												<input type="hidden" value="06" name="coachTimeList[${caochTime.count5}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
											<c:forEach items="${caochTime.coachTimeList06}" var="item" varStatus="status">
										  	<div class="form-group div_total_time">

												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count5+status.index}].startTime"
														 type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count5+status.index}].startTime" class="form-control"

														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count5+status.index}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count5+status.index}].endTime" type="text"
														value="${item.endtime }" name="coachTimeList[${caochTime.count5+status.index}].endTime" class="form-control"

														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count5+status.index}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count5+status.index}].type" value="1">
												<input type="hidden" value="06" name="coachTimeList[${caochTime.count5+status.index}].day">
												<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
										  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “七号” -->
							<div class="form-group border">
								<div class="col-sm-1">七号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList07== null || fn:length(caochTime.coachTimeList07) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count6}].startTime" type="text" value="${item.starttime }"
														 name="coachTimeList[${caochTime.count6}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count6}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count6}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count6}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count6}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count6}].type" value="1">

												<input type="hidden" value="07" name="coachTimeList[${caochTime.count6}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList07}" var="item" varStatus="status">
									  <div class="form-group div_total_time">
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count6+status.index}].startTime" type="text"
													value="${item.starttime }" name="coachTimeList[${caochTime.count6+status.index}].startTime" class="form-control"

													placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count6+status.index}].endTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											-
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count6+status.index}].endTime" type="text" value="${item.endtime }"
													name="coachTimeList[${caochTime.count6+status.index}].endTime" class="form-control"

													placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count6+status.index}].startTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											<input type="hidden" name="coachTimeList[${caochTime.count6+status.index}].type" value="1">
											<input type="hidden" value="07" name="coachTimeList[${caochTime.count6+status.index}].day">
											<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
											<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
									  	</div>
									  	</c:forEach>
									  </c:otherwise>
									  </c:choose>
								</div>
							</div>
							<!-- “八号” -->
							<div class="form-group border">
								<div class="col-sm-1">八号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList08== null || fn:length(caochTime.coachTimeList08) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count7}].startTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count7}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count7}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count7}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count7}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count7}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count7}].type" value="1">

												<input type="hidden" value="08" name="coachTimeList[${caochTime.count7}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList08}" var="item" varStatus="status">
									  		<div class="form-group div_total_time">
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count7+status.index}].startTime"
													type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count7+status.index}].startTime" class="form-control"

													placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count7+status.index}].endTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											-
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count7+status.index}].endTime"
													type="text" value="${item.endtime }" name="coachTimeList[${caochTime.count7+status.index}].endTime" class="form-control"

													placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count7+status.index}].startTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											<input type="hidden" name="coachTimeList[${caochTime.count7+status.index}].type" value="1">
											<input type="hidden" value="08" name="coachTimeList[${caochTime.count7+status.index}].day">
											<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
											<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
									  	</div>
									  	</c:forEach>
								  	</c:otherwise>

								  	</c:choose>
								</div>
							</div>
							<!-- “九号” -->
							<div class="form-group border">
								<div class="col-sm-1">九号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList09== null || fn:length(caochTime.coachTimeList09) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count8}].startTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count8}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count8}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count8}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count8}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count8}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count8}].type" value="1">

												<input type="hidden" value="09" name="coachTimeList[${caochTime.count8}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList09}" var="item" varStatus="status">
										  <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count8+status.index}].startTime"
														 type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count8+status.index}].startTime" class="form-control"

														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count8+status.index}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count8+status.index}].endTime" 、
														type="text" value="${item.endtime }"  name="coachTimeList[${caochTime.count8+status.index}].endTime" class="form-control"

														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count8+status.index}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count8+status.index}].type" value="1">
												<input type="hidden" value="09" name="coachTimeList[${caochTime.count8+status.index}].day">
												<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
										  	</c:forEach>
										 </c:otherwise>

										</c:choose>
								</div>
							</div>
							<!-- “十号” -->
							<div class="form-group border">
								<div class="col-sm-1">十号</div>
								<div class="col-sm-8">
									<c:choose>
									<c:when test="${caochTime.coachTimeList10== null || fn:length(caochTime.coachTimeList10) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count9}].startTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count9}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count9}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count9}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count9}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count9}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count9}].type" value="1">

												<input type="hidden" value="10" name="coachTimeList[${caochTime.count9}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList10}" var="item" varStatus="status">
									  <div class="form-group div_total_time">
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count9+status.index}].startTime"
													 type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count9+status.index}].startTime" class="form-control"

													placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count9+status.index}].endTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											-
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count9+status.index}].endTime"
													type="text" value="${item.endtime }" name="coachTimeList[${caochTime.count9+status.index}].endTime" class="form-control"

													placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count9+status.index}].startTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											<input type="hidden" name="coachTimeList[${caochTime.count9+status.index}].type" value="1">
											<input type="hidden" value="10" name="coachTimeList[${caochTime.count9+status.index}].day">
											<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
											<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
									  	</div>
									  	</c:forEach>
									  </c:otherwise>
									  </c:choose>
								</div>
							</div>
							<!-- “十一号” -->
							<div class="form-group border">
								<div class="col-sm-1">十一号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList11== null || fn:length(caochTime.coachTimeList11) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count10}].startTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count10}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count10}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input id="coachTimeList[${caochTime.count10}].endTime" type="text"
														value="${item.starttime }" name="coachTimeList[${caochTime.count10}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count10}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count10}].type" value="1">

												<input type="hidden" value="11" name="coachTimeList[${caochTime.count10}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList11}" var="item" varStatus="status">
									  <div class="form-group div_total_time">
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input id="coachTimeList[${caochTime.count10+status.index}].startTime"
													type="text" value="${item.starttime }" name="coachTimeList[${caochTime.count10+status.index}].startTime" class="form-control"

													placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count10+status.index}].endTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											-
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input type="text" value="${item.endtime }"
													 id="coachTimeList[${caochTime.count10+status.index}].endTime"
													 name="coachTimeList[${caochTime.count10+status.index}].endTime" class="form-control"

													placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count10+status.index}].startTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											<input type="hidden" name="coachTimeList[${caochTime.count10+status.index}].type" value="1">
											<input type="hidden" value="11" name="coachTimeList[${caochTime.count10+status.index}].day">
											<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
											<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
									  	</div>
									  	</c:forEach>
									  </c:otherwise>
									  </c:choose>
								</div>
							</div>
							<!-- “十二号” -->
							<div class="form-group border">
								<div class="col-sm-1">十二号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList12== null || fn:length(caochTime.coachTimeList12) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														 id="coachTimeList[${caochTime.count11}].startTime"
														 name="coachTimeList[${caochTime.count11}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count11}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" id="coachTimeList[${caochTime.count11}].endTime" class="form-control"
														 value="${item.starttime }" name="coachTimeList[${caochTime.count11}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count11}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count11}].type" value="1">

												<input type="hidden" value="12" name="coachTimeList[${caochTime.count11}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList12}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count11+status.index}].startTime"
												name="coachTimeList[${caochTime.count11+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count11+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count11+status.index}].endTime"
												name="coachTimeList[${caochTime.count11+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count11+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count11+status.index}].type" value="1">
										<input type="hidden" value="12" name="coachTimeList[${caochTime.count11+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>

								  	</c:choose>
								</div>
							</div>
							<!-- “十三号” -->
							<div class="form-group border">
								<div class="col-sm-1">十三号</div>
								<div class="col-sm-8">
												<c:choose>
									<c:when test="${caochTime.coachTimeList13== null || fn:length(caochTime.coachTimeList13) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count12}].startTime"
														name="coachTimeList[${caochTime.count12}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count12}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count12}].endTime"
														name="coachTimeList[${caochTime.count12}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count12}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count12}].type" value="1">

												<input type="hidden" value="13" name="coachTimeList[${caochTime.count12}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList13}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												 id="coachTimeList[${caochTime.count12+status.index}].startTime"
												 name="coachTimeList[${caochTime.count12+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count12+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												 id="coachTimeList[${caochTime.count12+status.index}].endTime"
												 name="coachTimeList[${caochTime.count12+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count12+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count12+status.index}].type" value="1">
										<input type="hidden" value="13" name="coachTimeList[${caochTime.count12+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “十四号” -->
							<div class="form-group border">
								<div class="col-sm-1">十四号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList14== null || fn:length(caochTime.coachTimeList14) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count13}].startTime"
														name="coachTimeList[${caochTime.count13}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count13}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														 id="coachTimeList[${caochTime.count13}].endTime"
														 name="coachTimeList[${caochTime.count13}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count13}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count13}].type" value="1">

												<input type="hidden" value="14" name="coachTimeList[${caochTime.count13}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList14}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												 id="coachTimeList[${caochTime.count13+status.index}].startTime"
												 name="coachTimeList[${caochTime.count13+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count13+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count13+status.index}].endTime"
												name="coachTimeList[${caochTime.count13+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count13+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count13+status.index}].type" value="1">
										<input type="hidden" value="14" name="coachTimeList[${caochTime.count13+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “十五号” -->
							<div class="form-group border">
								<div class="col-sm-1">十五号</div>
								<div class="col-sm-8">
										<c:choose>
									<c:when test="${caochTime.coachTimeList15== null || fn:length(caochTime.coachTimeList15) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count14}].startTime"
														name="coachTimeList[${caochTime.count14}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count14}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count14}].endTime"
														name="coachTimeList[${caochTime.count14}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count14}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count14}].type" value="1">

												<input type="hidden" value="15" name="coachTimeList[${caochTime.count14}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList15}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count14+status.index}].startTime"
												name="coachTimeList[${caochTime.count14+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count14+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count14+status.index}].endTime"
												name="coachTimeList[${caochTime.count14+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count14+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count14+status.index}].type" value="1">
										<input type="hidden" value="15" name="coachTimeList[${caochTime.count14+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “十六号” -->
							<div class="form-group border">
								<div class="col-sm-1">十六号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList16== null || fn:length(caochTime.coachTimeList16) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count15}].startTime"
														 name="coachTimeList[${caochTime.count15}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count15}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count15}].endTime"
														name="coachTimeList[${caochTime.count15}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count15}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count15}].type" value="1">

												<input type="hidden" value="16" name="coachTimeList[${caochTime.count15}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
										<c:forEach items="${caochTime.coachTimeList16}" var="item" varStatus="status">
									  <div class="form-group div_total_time">
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input type="text" value="${item.starttime }"
													id="coachTimeList[${caochTime.count15+status.index}].startTime"
													name="coachTimeList[${caochTime.count15+status.index}].startTime" class="form-control"

													placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count15+status.index}].endTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											-
											<div class="contractDay-menu">
												<div class="contractBeginDay time">
													<input type="text" value="${item.endtime }"
													id="coachTimeList[${caochTime.count15+status.index}].endTime"
													name="coachTimeList[${caochTime.count15+status.index}].endTime" class="form-control"

													placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count15+status.index}].startTime\')}'});">
													<!-- <i class="icon iconfont data type1"></i> -->
												</div>
											</div>
											<input type="hidden" name="coachTimeList[${caochTime.count15+status.index}].type" value="1">
											<input type="hidden" value="16" name="coachTimeList[${caochTime.count15+status.index}].day">
											<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
											<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
									  	</div>
									  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “十七号” -->
							<div class="form-group border">
								<div class="col-sm-1">十七号</div>
								<div class="col-sm-8">
										<c:choose>
									<c:when test="${caochTime.coachTimeList17== null || fn:length(caochTime.coachTimeList17) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count16}].startTime"
														name="coachTimeList[${caochTime.count16}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count16}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count16}].endTime"
														name="coachTimeList[${caochTime.count16}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count16}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count16}].type" value="1">

												<input type="hidden" value="17" name="coachTimeList[${caochTime.count16}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList17}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count16+status.index}].startTime"
												name="coachTimeList[${caochTime.count16+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count16+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count16+status.index}].endTime"
												name="coachTimeList[${caochTime.count16+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count16+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count16+status.index}].type" value="1">
										<input type="hidden" value="17" name="coachTimeList[${caochTime.count16+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “十八号” -->
							<div class="form-group border">
								<div class="col-sm-1">十八号</div>
								<div class="col-sm-8">
											<c:choose>
									<c:when test="${caochTime.coachTimeList18== null || fn:length(caochTime.coachTimeList18) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count17}].startTime"
														name="coachTimeList[${caochTime.count17}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count17}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count17}].endTime"
														name="coachTimeList[${caochTime.count17}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count17}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count17}].type" value="1">

												<input type="hidden" value="18" name="coachTimeList[${caochTime.count17}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList18}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count17+status.index}].startTime"
												name="coachTimeList[${caochTime.count17+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count17+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count17+status.index}].endTime"
												name="coachTimeList[${caochTime.count17+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count17+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count17+status.index}].type" value="1">
										<input type="hidden" value="18" name="coachTimeList[${caochTime.count17+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “十九号” -->
							<div class="form-group border">
								<div class="col-sm-1">十九号</div>
								<div class="col-sm-8">
											<c:choose>
									<c:when test="${caochTime.coachTimeList19== null || fn:length(caochTime.coachTimeList19) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count18}].startTime"
														 name="coachTimeList[${caochTime.count18}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count18}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														 id="coachTimeList[${caochTime.count18}].endTime"
														 name="coachTimeList[${caochTime.count18}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count18}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count18}].type" value="1">

												<input type="hidden" value="19" name="coachTimeList[${caochTime.count18}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList19}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count18+status.index}].startTime"
												name="coachTimeList[${caochTime.count18+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count18+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count18+status.index}].endTime"
												name="coachTimeList[${caochTime.count18+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count18+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count18+status.index}].type" value="1">
										<input type="hidden" value="19" name="coachTimeList[${caochTime.count18+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十号</div>
								<div class="col-sm-8">
									<c:choose>
									<c:when test="${caochTime.coachTimeList20== null || fn:length(caochTime.coachTimeList20) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count19}].startTime"
														name="coachTimeList[${caochTime.count19}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count19}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count19}].endTime"
														name="coachTimeList[${caochTime.count19}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count19}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count19}].type" value="1">

												<input type="hidden" value="20" name="coachTimeList[${caochTime.count19}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList20}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count19+status.index}].startTime"
												name="coachTimeList[${caochTime.count19+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count19+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												 id="coachTimeList[${caochTime.count19+status.index}].endTime"
												 name="coachTimeList[${caochTime.count19+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count19+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count19+status.index}].type" value="1">
										<input type="hidden" value="20" name="coachTimeList[${caochTime.count19+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十一号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十一号</div>
								<div class="col-sm-8">
					<c:choose>
									<c:when test="${caochTime.coachTimeList21== null || fn:length(caochTime.coachTimeList21) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count20}].startTime"
														name="coachTimeList[${caochTime.count20}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count20}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count20}].endTime"
														name="coachTimeList[${caochTime.count20}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count20}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count20}].type" value="1">

												<input type="hidden" value="21" name="coachTimeList[${caochTime.count20}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList21}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count20+status.index}].startTime"
												name="coachTimeList[${caochTime.count20+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count20+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count20+status.index}].endTime"
												name="coachTimeList[${caochTime.count20+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count20+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count20+status.index}].type" value="1">
										<input type="hidden" value="21" name="coachTimeList[${caochTime.count20+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十二号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十二号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList22== null || fn:length(caochTime.coachTimeList22) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count21}].startTime"
														name="coachTimeList[${caochTime.count21}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count21}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count21}].endTime"
														name="coachTimeList[${caochTime.count21}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count21}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count21}].type" value="1">

												<input type="hidden" value="22" name="coachTimeList[${caochTime.count21}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList22}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count21+status.index}].startTime"
												name="coachTimeList[${caochTime.count21+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count21+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count21+status.index}].endTime"
												name="coachTimeList[${caochTime.count21+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count21+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>

										<input type="hidden" name="coachTimeList[${caochTime.count21+status.index}].type" value="1">
										<input type="hidden" value="22" name="coachTimeList[${caochTime.count21+status.index}].day">
									 <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十三号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十三号</div>
								<div class="col-sm-8">
								<c:choose>

									<c:when test="${caochTime.coachTimeList23== null || fn:length(caochTime.coachTimeList23) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count22}].startTime"
														name="coachTimeList[${caochTime.count22}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count22}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														 id="coachTimeList[${caochTime.count22}].endTime"
														 name="coachTimeList[${caochTime.count22}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count22}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count22}].type" value="1">

												<input type="hidden" value="23" name="coachTimeList[${caochTime.count22}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList23}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count22+status.index}].startTime"
												name="coachTimeList[${caochTime.count22+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count22+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count22+status.index}].endTime"
												name="coachTimeList[${caochTime.count22+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count22+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count22+status.index}].type" value="1">
										<input type="hidden" value="23" name="coachTimeList[${caochTime.count22+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十四号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十四号</div>
								<div class="col-sm-8">
									<c:choose>
									<c:when test="${caochTime.coachTimeList24== null || fn:length(caochTime.coachTimeList24) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count23}].startTime"
														name="coachTimeList[${caochTime.count23}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count23}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count23}].endTime"
														name="coachTimeList[${caochTime.count23}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count23}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count23}].type" value="1">

												<input type="hidden" value="24" name="coachTimeList[${caochTime.count23}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList24}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count23+status.index}].startTime"
												name="coachTimeList[${caochTime.count23+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count23+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count23+status.index}].endTime"
												name="coachTimeList[${caochTime.count23+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count23+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count23+status.index}].type" value="1">
										<input type="hidden" value="24" name="coachTimeList[${caochTime.count23+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十五号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十五号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList25== null || fn:length(caochTime.coachTimeList25) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count24}].startTime" class="form-control"
														name="coachTimeList[${caochTime.count24}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count24}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count24}].endTime"
														name="coachTimeList[${caochTime.count24}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count24}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count24}].type" value="1">

												<input type="hidden" value="25" name="coachTimeList[${caochTime.count24}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList25}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count24+status.index}].startTime"
												name="coachTimeList[${caochTime.count24+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count24+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count24+status.index}].endTime"
												name="coachTimeList[${caochTime.count24+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count24+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count24+status.index}].type" value="1">
										<input type="hidden" value="25" name="coachTimeList[${caochTime.count24+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十六号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十六号</div>
								<div class="col-sm-8">
									<c:choose>
									<c:when test="${caochTime.coachTimeList26== null || fn:length(caochTime.coachTimeList26) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count25}].startTime"
														name="coachTimeList[${caochTime.count25}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count25}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														 id="coachTimeList[${caochTime.count25}].endTime"
														 name="coachTimeList[${caochTime.count25}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count25}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count25}].type" value="1">

												<input type="hidden" value="26" name="coachTimeList[${caochTime.count25}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList26}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count25+status.index}].startTime"
												name="coachTimeList[${caochTime.count25+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count25+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count25+status.index}].endTime"
												name="coachTimeList[${caochTime.count25+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count25+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>

										<input type="hidden" name="coachTimeList[${caochTime.count25+status.index}].type" value="1">
										<input type="hidden" value="26" name="coachTimeList[${caochTime.count25+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十七号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十七号</div>
								<div class="col-sm-8">
										<c:choose>
									<c:when test="${caochTime.coachTimeList27== null || fn:length(caochTime.coachTimeList27) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count26}].startTime"
														name="coachTimeList[${caochTime.count26}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count26}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count26}].endTime"
														name="coachTimeList[${caochTime.count26}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count26}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count26}].type" value="1">

												<input type="hidden" value="27" name="coachTimeList[${caochTime.count26}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList27}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count26+status.index}].startTime"
												name="coachTimeList[${caochTime.count26+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count26+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count26+status.index}].endTime"
												name="coachTimeList[${caochTime.count26+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count26+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count26+status.index}].type" value="1">
										<input type="hidden" value="27" name="coachTimeList[${caochTime.count26+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十八号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十八号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList28== null || fn:length(caochTime.coachTimeList28) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count27}].startTime"
														name="coachTimeList[${caochTime.count27}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count27}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count27}].endTime"
														name="coachTimeList[${caochTime.count27}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count27}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count27}].type" value="1">

												<input type="hidden" value="28" name="coachTimeList[${caochTime.count27}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
								<c:forEach items="${caochTime.coachTimeList28}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count27+status.index}].startTime"
												name="coachTimeList[${caochTime.count27+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count27+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count27+status.index}].endTime"
												name="coachTimeList[${caochTime.count27+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count27+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count27+status.index}].type" value="1">
										<input type="hidden" value="28" name="coachTimeList[${caochTime.count27+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “二十九号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十九号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList29== null || fn:length(caochTime.coachTimeList29) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count28}].startTime"
														name="coachTimeList[${caochTime.count28}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count28}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count28}].endTime"
														name="coachTimeList[${caochTime.count28}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count28}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count28}].type" value="1">

												<input type="hidden" value="29" name="coachTimeList[${caochTime.count28}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList29}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count28+status.index}].startTime"
												name="coachTimeList[${caochTime.count28+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count28+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count28+status.index}].endTime"
												name="coachTimeList[${caochTime.count28+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count28+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>

										<input type="hidden" name="coachTimeList[${caochTime.count28+status.index}].type" value="1">
										<input type="hidden" value="29" name="coachTimeList[${caochTime.count28+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>
							<!-- “三十号” -->
							<div class="form-group border">
								<div class="col-sm-1">三十号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList30== null || fn:length(caochTime.coachTimeList30) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count29}].startTime"
														name="coachTimeList[${caochTime.count29}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count29}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count29}].endTime"
														name="coachTimeList[${caochTime.count29}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count29}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count29}].type" value="1">

												<input type="hidden" value="30" name="coachTimeList[${caochTime.count29}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList30}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count29+status.index}].startTime"
												name="coachTimeList[${caochTime.count29+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count29+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												id="coachTimeList[${caochTime.count29+status.index}].endTime"
												name="coachTimeList[${caochTime.count29+status.index}].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count29+status.index}].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
                                        <input type="hidden" name="coachTimeList[${caochTime.count29+status.index}].type" value="1">
										<input type="hidden" value="30" name="coachTimeList[${caochTime.count29+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  </c:otherwise>
								  </c:choose>
								</div>
							</div>
							<!-- “三十一号” -->
							<div class="form-group border">
								<div class="col-sm-1">三十一号</div>
								<div class="col-sm-8">
								<c:choose>
									<c:when test="${caochTime.coachTimeList31== null || fn:length(caochTime.coachTimeList31) == 0}">
											   <div class="form-group div_total_time">
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count30}].startTime"
														name="coachTimeList[${caochTime.count30}].startTime" class="form-control"
														placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count30}].endTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												-
												<div class="contractDay-menu">
													<div class="contractBeginDay time">
														<input type="text" value="${item.starttime }"
														id="coachTimeList[${caochTime.count30}].endTime"
														name="coachTimeList[${caochTime.count30}].endTime" class="form-control"
														placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count30}].startTime\')}'});">
														<!-- <i class="icon iconfont data type1"></i> -->
													</div>
												</div>
												<input type="hidden" name="coachTimeList[${caochTime.count30}].type" value="1">

												<input type="hidden" value="31" name="coachTimeList[${caochTime.count30}].day">
												<!-- 时间类型，代表指定日期  -->
												<!-- coachTimeList[0].startTime -->

											    <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
												<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
										  	</div>
									</c:when>
									<c:otherwise>
									<c:forEach items="${caochTime.coachTimeList31}" var="item" varStatus="status">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.starttime }"
												id="coachTimeList[${caochTime.count30+status.index}].startTime"
												name="coachTimeList[${caochTime.count30+status.index}].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count30+status.index}].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" value="${item.endtime }"
												name="coachTimeList[${caochTime.count30+status.index}].endTime" class="form-control"
												id="coachTimeList[${caochTime.count30+status.index}].endTime"


												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[${caochTime.count30+status.index}].startTime\')}'});">






												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[${caochTime.count30+status.index}].type" value="1">
										<input type="hidden" value="31" name="coachTimeList[${caochTime.count30+status.index}].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								  	</c:forEach>
								  	</c:otherwise>
								  	</c:choose>
								</div>
							</div>

                    </div>
                </div>

        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath() %>/user/pricoursetime/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/pricoursetime/listPage">返回时间列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/pricoursetime/editPage?coachId=${coach.id}&&date=${date}">继续编辑</a>
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
                          	<span id="span_failure">  发布失败！</span>
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
</script>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/pricoursetime/edit_pri_time.js"></script>


</html>
