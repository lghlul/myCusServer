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
						<a href="javascript:void(0)">会员列表</a>
					</li>
				</ul>
			</div>

			<div class="menu-panel">
				<div class="panel-header">
					<b></b>
					<span>会员基本信息</span>
				</div>

				<div class="pull">
					<div class="pull-right">
                        <a href="<%=request.getContextPath() %>/user/member/addPage">
                            <input class="btn btn-sm btn-success" type="button" id="addStore" value="新增">
                        </a>
					</div>

					<div class="pull-left">
						<input type="text" class="form-control" name="" id="serachMemberName" placeholder="请输入会员名称"/>
						<input type="text" class="form-control" name="" id="serachMobile" placeholder="请输入手机号"/>
                        <div class="divselect">
							<select id="select_memberStatus">
											<option value="">-选择会员状态-</option>
											<c:forEach items="${memberStatus}" var="item"
												varStatus="status">
													<option  value="${item.basicvalue}">${item.title }</option>
											</c:forEach>

							</select>
                            <i class="iconfont type1">&#xe772;</i>
                        </div>
						 <div class="divselect">
							<select id="select_memberfrom">
											<option value="">-选择会员来源-</option>
											<c:forEach items="${memberSource}" var="item"
												varStatus="status">
													<option  value="${item.basicvalue}">${item.title }</option>
											</c:forEach>

							</select>
                            <i class="iconfont type1">&#xe772;</i>
                        </div>
                        <div class="divselect">
							<select id="select_membertype">
											<option value="">-选择会员类型-</option>
											<option  value="1">顾客</option>
											<option  value="2">工作人员</option>


							</select>
                            <i class="iconfont type1">&#xe772;</i>
                        </div>
                        <div class="divselect">
							<select id="select_store">
											<option value="">-选择门店-</option>
											<c:forEach items="${storeList}" var="item"
												varStatus="status">
													<option  value="${item.id}">${item.storename }</option>
											</c:forEach>

							</select>
                            <i class="iconfont type1">&#xe772;</i>
                        </div>
						<button class="btn btn-app btn-success" type="button" id="searchMember">查询</button>
						<button class="btn btn-default" type="button" id="resetMember">重置</button>
					</div>
				</div>
				<div class="tab-pane">
					<table class="table table-bordered" id="members">
					</table>
				</div>

				<!-- 模态框（Modal） -->
				<div class="modal fade" id="endModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
								<h8 class="modal-title" id="myModalLabel">
									选择提示
								</h8>
							</div>
							<div class="modal-body">
								<h4><span id="resultMsg"></span></h4>
								<div class="modal-footer">
									<a  href="<%=request.getContextPath() %>/user/realse/listPage" class="btn btn-default" data-dismiss="modal">
										确定
									</a>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>
				</div>

			</div>
</body>
</html>
<script
	src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/script.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap-table.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap-table-zh-CN.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script
	src="<%=request.getContextPath()%>/assets/js/member/memberlist.js"></script>