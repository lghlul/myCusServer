<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>私教时间管理</title>
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
			text-align: center;
			vertical-align: middle;
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
                    <a href="javascript:void(0)">私教时间管理</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>私教时间信息</span>
                </div>

			 <form id="form" method="post" class="form-horizontal" action="<%=request.getContextPath()%>/user/pricoursetime/addSave">
			 	<!-- <input type="hidden" value="1" name="type"> -->
			 	<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	选择教练
                    </label>
                    <div class="col-sm-5" id="div_servicearea">
                        <a class="btn btn-default" data-toggle="modal" data-target="#choose_coachs">教练</a>

                        	<%-- <a href="<%=request.getContextPath()%>/user/pricoursetime/editPage">编辑</a> --%>
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	选择月份
                    </label>
                    <div class="col-sm-2">
						<input type="text" name="selectymonth" class="form-control"
						placeholder="选择月份" onclick="WdatePicker({dateFmt:'yyyy-MM'});">
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                		选择时间
                    </label>
                    <div class="col-sm-5 menu">
                        <a href="javascript:;" class="btn btn-default btn-inverse a_changeType"  data-id="2">每天</a>
                       <!--  <a href="javascript:;" class="btn btn-default">每周</a> -->
                        <a href="javascript:;" class="btn btn-default a_changeType" data-id="1" >指定时间</a>
                    </div>
                </div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-1">
						<!-- “每天”的内容 -->
						<div class="single " id="div_everyDay">
							<div class="form-group div_day">
								<div class="col-sm-6">
									<div class="contractDay-menu">
										<div class="contractBeginDay time div_startTime">
											<input type="text" id="coachTimeList[0].startTime1" name="coachTimeList[0].startTime" class="form-control"

											placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm' ,maxDate:'#F{$dp.$D(\'coachTimeList[0].endTime1\')}'});">
											<!-- <i class="icon iconfont data type1"></i> -->
										</div>
									</div>
									-
									<div class="contractDay-menu">
										<div class="contractBeginDay time div_endTime">
											<input type="text" id="coachTimeList[0].endTime1"  name="coachTimeList[0].endTime" class="form-control"
											placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[0].startTime1\')}'});">
											<!-- <i class="icon iconfont data type1"></i> -->
										</div>
									</div>
									<!-- 时间类型，代表每天  批量插入   -->
									<input type="hidden" name="coachTimeList[0].type" value="2">

									<button  class="btn btn_add_day" type="button">&nbsp;+&nbsp;</button>
									<button  class="btn btn_remove_day" type="button">&nbsp;-&nbsp;</button>
								 </div>
							</div>
						</div>

						<!-- “指定时间”的内容 -->
						<div class="single" id="div_specDate">
							<!-- “一号” -->
							<div class="form-group border">
								<div class="col-sm-1">一号</div>
								<div class="col-sm-8">
									<!-- 添加一层 -->
								   <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[0].startTime" name="coachTimeList[0].startTime" class="form-control"
												placeholder="开始时间"
												onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[0].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[0].endTime" name="coachTimeList[0].endTime" class="form-control"
												placeholder="结束时间"
												onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[0].startTime\')}'});">
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


								</div>


							</div>
							<!-- “二号” -->
							<div class="form-group border">
								<div class="col-sm-1">二号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[1].startTime" name="coachTimeList[1].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[1].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[1].endTime" name="coachTimeList[1].endTime" class="form-control"
												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[1].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[1].type" value="1">

										<input type="hidden" value="02" name="coachTimeList[1].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “三号” -->
							<div class="form-group border">
								<div class="col-sm-1">三号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[2].startTime" name="coachTimeList[2].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[2].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[2].endTime" name="coachTimeList[2].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[2].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[2].type" value="1">
											<input type="hidden" value="03" name="coachTimeList[2].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate"  type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “四号” -->
							<div class="form-group border">
								<div class="col-sm-1">四号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[3].startTime" name="coachTimeList[3].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[3].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[3].endTime" name="coachTimeList[3].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[3].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[3].type" value="1">
										<input type="hidden" value="04" name="coachTimeList[3].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “五号” -->
							<div class="form-group border">
								<div class="col-sm-1">五号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[4].startTime" name="coachTimeList[4].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[4].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[4].endTime" name="coachTimeList[4].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[4].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[4].type" value="1">
										<input type="hidden" value="05" name="coachTimeList[4].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “六号” -->
							<div class="form-group border">
								<div class="col-sm-1">六号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[5].startTime" name="coachTimeList[5].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[5].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[5].endTime" name="coachTimeList[5].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[5].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[5].type" value="1">
										<input type="hidden" value="06" name="coachTimeList[5].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “七号” -->
							<div class="form-group border">
								<div class="col-sm-1">七号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[6].startTime" name="coachTimeList[6].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[6].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[6].endTime" name="coachTimeList[6].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[6].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[6].type" value="1">
										<input type="hidden" value="07" name="coachTimeList[6].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “八号” -->
							<div class="form-group border">
								<div class="col-sm-1">八号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[7].startTime" name="coachTimeList[7].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[7].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[7].endTime" name="coachTimeList[7].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[7].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[7].type" value="1">
										<input type="hidden" value="08" name="coachTimeList[7].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “九号” -->
							<div class="form-group border">
								<div class="col-sm-1">九号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[8].startTime" name="coachTimeList[8].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[8].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[8].endTime" name="coachTimeList[8].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[8].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[8].type" value="1">
										<input type="hidden" value="09" name="coachTimeList[8].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十号” -->
							<div class="form-group border">
								<div class="col-sm-1">十号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[9].startTime" name="coachTimeList[9].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[9].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[9].endTime" name="coachTimeList[9].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[9].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[9].type" value="1">
										<input type="hidden" value="10" name="coachTimeList[9].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十一号” -->
							<div class="form-group border">
								<div class="col-sm-1">十一号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[10].startTime" name="coachTimeList[10].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[10].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[10].endTime" name="coachTimeList[10].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[10].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[10].type" value="1">
										<input type="hidden" value="11" name="coachTimeList[10].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十二号” -->
							<div class="form-group border">
								<div class="col-sm-1">十二号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[11].startTime" name="coachTimeList[11].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[11].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[11].endTime" name="coachTimeList[11].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[11].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[11].type" value="1">
										<input type="hidden" value="12" name="coachTimeList[11].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十三号” -->
							<div class="form-group border">
								<div class="col-sm-1">十三号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[12].startTime" name="coachTimeList[12].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[12].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[12].endTime" name="coachTimeList[12].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[12].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[12].type" value="1">
										<input type="hidden" value="13" name="coachTimeList[12].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十四号” -->
							<div class="form-group border">
								<div class="col-sm-1">十四号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[13].startTime" name="coachTimeList[13].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[13].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[13].endTime" name="coachTimeList[13].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[13].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[13].type" value="1">
										<input type="hidden" value="14" name="coachTimeList[13].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十五号” -->
							<div class="form-group border">
								<div class="col-sm-1">十五号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[14].startTime" name="coachTimeList[14].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[14].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[14].endTime" name="coachTimeList[14].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[14].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[14].type" value="1">
										<input type="hidden" value="15" name="coachTimeList[14].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十六号” -->
							<div class="form-group border">
								<div class="col-sm-1">十六号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[15].startTime" name="coachTimeList[15].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[15].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[15].endTime" name="coachTimeList[15].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[15].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[15].type" value="1">
										<input type="hidden" value="16" name="coachTimeList[15].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十七号” -->
							<div class="form-group border">
								<div class="col-sm-1">十七号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[16].startTime" name="coachTimeList[16].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[16].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[16].endTime" name="coachTimeList[16].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[16].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[16].type" value="1">
										<input type="hidden" value="17" name="coachTimeList[16].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十八号” -->
							<div class="form-group border">
								<div class="col-sm-1">十八号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[17].startTime" name="coachTimeList[17].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[17].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[17].endTime" name="coachTimeList[17].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[17].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[17].type" value="1">
										<input type="hidden" value="18" name="coachTimeList[17].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “十九号” -->
							<div class="form-group border">
								<div class="col-sm-1">十九号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[18].startTime" name="coachTimeList[18].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[18].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[18].endTime" name="coachTimeList[18].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[18].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[18].type" value="1">
										<input type="hidden" value="19" name="coachTimeList[18].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[19].startTime" name="coachTimeList[19].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[19].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[19].endTime" name="coachTimeList[19].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[19].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[19].type" value="1">
										<input type="hidden" value="20" name="coachTimeList[19].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十一号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十一号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[20].startTime" name="coachTimeList[20].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[20].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[20].endTime" name="coachTimeList[20].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[20].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[20].type" value="1">
										<input type="hidden" value="21" name="coachTimeList[20].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十二号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十二号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[21].startTime" name="coachTimeList[21].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[21].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[21].endTime" name="coachTimeList[21].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[21].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>

										<input type="hidden" name="coachTimeList[21].type" value="1">
										<input type="hidden" value="22" name="coachTimeList[21].day">
									 <button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十三号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十三号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[22].startTime" name="coachTimeList[22].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[22].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[22].endTime" name="coachTimeList[22].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[22].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[22].type" value="1">
										<input type="hidden" value="23" name="coachTimeList[22].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十四号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十四号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[23].startTime" name="coachTimeList[23].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[23].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[23].endTime" name="coachTimeList[23].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[23].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[23].type" value="1">
										<input type="hidden" value="24" name="coachTimeList[23].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十五号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十五号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[24].startTime" name="coachTimeList[24].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[24].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[24].endTime" name="coachTimeList[24].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[24].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[24].type" value="1">
										<input type="hidden" value="25" name="coachTimeList[24].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十六号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十六号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[25].startTime" name="coachTimeList[25].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[25].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[25].endTime" name="coachTimeList[25].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[25].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>

										<input type="hidden" name="coachTimeList[25].type" value="1">
										<input type="hidden" value="26" name="coachTimeList[25].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十七号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十七号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[26].startTime" name="coachTimeList[26].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[26].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[26].endTime" name="coachTimeList[26].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[26].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[26].type" value="1">
										<input type="hidden" value="27" name="coachTimeList[26].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十八号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十八号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[27].startTime" name="coachTimeList[27].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[27].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[27].endTime" name="coachTimeList[27].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[27].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[27].type" value="1">
										<input type="hidden" value="28" name="coachTimeList[27].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “二十九号” -->
							<div class="form-group border">
								<div class="col-sm-1">二十九号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[28].startTime" name="coachTimeList[28].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[28].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[28].endTime" name="coachTimeList[28].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[28].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>

										<input type="hidden" name="coachTimeList[28].type" value="1">
										<input type="hidden" value="29" name="coachTimeList[28].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “三十号” -->
							<div class="form-group border">
								<div class="col-sm-1">三十号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[29].startTime" name="coachTimeList[29].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[29].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[29].endTime" name="coachTimeList[29].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[29].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
                                        <input type="hidden" name="coachTimeList[29].type" value="1">
										<input type="hidden" value="30" name="coachTimeList[29].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>
							<!-- “三十一号” -->
							<div class="form-group border">
								<div class="col-sm-1">三十一号</div>
								<div class="col-sm-8">
								  <div class="form-group div_total_time">
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[30].startTime" name="coachTimeList[30].startTime" class="form-control"

												placeholder="开始时间" onclick="WdatePicker({dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'coachTimeList[30].endTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										-
										<div class="contractDay-menu">
											<div class="contractBeginDay time">
												<input type="text" id="coachTimeList[30].endTime" name="coachTimeList[30].endTime" class="form-control"

												placeholder="结束时间" onclick="WdatePicker({dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'coachTimeList[30].startTime\')}'});">
												<!-- <i class="icon iconfont data type1"></i> -->
											</div>
										</div>
										<input type="hidden" name="coachTimeList[30].type" value="1">
										<input type="hidden" value="31" name="coachTimeList[30].day">
										<button class="btn btn_add_specDate" type="button">&nbsp;+&nbsp;</button>
										<button class="btn btn_remove_specDate" type="button">&nbsp;-&nbsp;</button>
								  	</div>
								</div>
							</div>

						</div>
					</div>
				</div>
        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/pricoursetime/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
                </div>
        </div>

   <!--教练选择框 -->
    <div class="modal fade" id="choose_coachs" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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

                	<c:forEach items="${coachList}" var="item" varStatus="status">
                			<lable>
                    			<input type="checkbox" class="coachs" name="coachs[${status.index }].id" value="${item.id }">${item.coachname }
                    			<input type="hidden" name="coachs[${status.index }].coachname" value="${item.coachname }">
                  		  </lable>
                	</c:forEach>

                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
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
                           	添加成功！
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
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/pricoursetime/addPage?type=1">继续添加</a>
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
 <script src="<%=request.getContextPath()%>/assets/js/pricoursetime/add_pri_time.js"></script>
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

</html>
