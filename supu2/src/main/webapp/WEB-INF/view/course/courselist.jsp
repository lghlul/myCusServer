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
						<a href="javascript:void(0)">课程管理</a>
					</li>
				</ul>
			</div>

			<div class="menu-panel">
				<div class="panel-header">
					<b></b>
					<span>课程基本信息</span>
				</div>

				<div class="pull">
					<div class="pull-right">
                 		 <a href="<%=request.getContextPath()%>/user/course/addPage?type=1">
                            <input class="btn btn-sm btn-success" type="button" id="add_tuanke" value="新增团课">
                        </a>
					 <a href="<%=request.getContextPath()%>/user/course/addPage?type=0">
                            <input class="btn btn-sm btn-success" type="button" id="add_sijiaoke" value="新增私教课">
                        </a>
                         <a href="<%=request.getContextPath()%>/user/course/addPage?type=2">
                            <input class="btn btn-sm btn-success" type="button" id="add_tuanke" value="新增工作室">
                        </a>
					</div>

					<div class="pull-left">
						<input type="text" class="form-control" name="" id="serachcoursename" placeholder="输入课程名称关键字"/>
						<div class="divselect">
	 						<select id="select_courseType">
											<option value="">-课程类型-</option>
											<option  value="0">私教课</option>
											<option  value="1">训练营</option>
											<option  value="2">基础团课</option>
											<option  value="3">工作室</option>

							</select>
							<i class="iconfont type1">&#xe772;</i>
						</div>
                        <div class="divselect">
							<select id="select_courseStatus">
											<option value="">-课程状态-</option>
											<option  value="1">生效中</option>
											<option  value="2">已失效</option>

							</select>
                            <i class="iconfont type1">&#xe772;</i>
                        </div>

						<button class="btn btn-app btn-success" id="searchCourse">查询</button>
						<button class="btn btn-default" id="resetCourse">重置</button>
					</div>
				</div>
				<div class="tab-pane">
					<table class="table table-bordered" id="coursetable">
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


			        <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="success_course" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-success" id="myModalLabel">
                           <i class="iconfont">&#xe6bf;</i>
                           	操作成功！
                        </h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                    	    <a class="btn btn-default" href="<%=request.getContextPath()%>/user/course/listPage">确定</a>
<!--                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button> -->
                   <!--      <button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
                    </div>
                </div>
            </div>
        </div>

          <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="failure_course" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe643;</i>
                          	操作失败！
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!-- <a class="btn btn-default" href="javascript:void(0)">取消</a>
                        <a class="btn btn-success" href="javascript:void(0)">返回修改</a> -->
                    </div>
                    <div class="modal-footer">
                    	<!-- <button class="btn btn-default" href="javascript:void(0)">取消</button> -->
                       <!--  <button class="btn btn-success" href="javascript:void(0)">重新发布</button> -->
                        <button type="button" class="btn btn-default" data-dismiss="modal">确定
                        </button>
                        <!-- button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
                    </div>
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
	src="<%=request.getContextPath()%>/assets/js/course/courselist.js"></script>