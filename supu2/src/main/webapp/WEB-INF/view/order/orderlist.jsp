<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/css/common.css">
		<style>
			.menu-panel {
				padding: 30px 0;
			}
			.btn-group > .btn, .btn-group-vertical > .btn{ padding:5px;}
			.divselect select {
				width: 150px;
			}

			.pull-left>.form-control {
				width: 150px;
			}
		</style>
	</head>

	<body>
		<div class="external">
			<div class="page-header">
				<ul class="breadcrumb">
					<li>
						<i class="iconfont">&#xe648;</i>
						<a href="javascript:void(0)">订单列表</a>
					</li>
				</ul>
			</div>

			<div class="menu-panel">
				<div class="panel-header">
					<b></b>
					<span>订单基本信息</span>
				</div>

				<div class="pull">


					<div class="pull-left">

					<input type="text" class="form-control" name="" id="serachecode" placeholder="请输入手机号"/>

                    <div class="divselect">
						<select id="select_ordertype" name="status">
											<option value="">-订单类型-</option>
											<option value="0">会员卡</option>
											<option value="1">私教课</option>
											<option value="2">精品团课</option>

						</select>
						<select id="select_issuccess" name="status">
											<option value="">-是否支付-</option>
											<option value="0">否</option>
											<option value="1">是</option>

						</select>
						                              购买时间
							<div class="contractBeginDay time">
									<input type="text" id="starttime"  class="form-control"
									 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});">
								<!-- <i class="icon iconfont data type1"></i> -->
							</div>
至

							<div class="contractBeginDay time">
									<input type="text" id="endtime"  class="form-control"
									 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'starttime\')}',dateFmt:'yyyy-MM-dd HH:mm',lang:'zh-cn'})">
								<!-- <i class="icon iconfont data type1"></i> -->
							</div>
                        <button class="btn btn-app btn-success" id="searchOrder">查询</button>
						<button class="btn btn-default" id="resetOrder">重置</button>
                        </div>

					</div>
				</div>
				<div class="tab-pane">
					<table class="table table-bordered" id="orderList">
					</table>
				</div>


			</div>
</body>
</html>
<script
	src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/script.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap-table.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap-table-zh-CN.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script
	src="<%=request.getContextPath()%>/assets/js/order/orderlist.js"></script>