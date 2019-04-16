<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html lang="en">

	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta charset="utf-8">
		<title>教练管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" type="text/css" href="../../assets/css/common.css">

		<style>
		/* .jlk-l img{height:200px;} */
		.menu-panel {padding: 40px 30px 40px 10px;}
		.container{  padding-left: 15px;}
		.pull-left>.form-control{ width: 160px;}
		.divselect select{
			width:120px;
			height:34px;
			border-radius:4px;
			border:1px solid #ccc;
			color: #555;
		}
		.jlk-l>img{
			height:168px;
		}
		</style>
	</head>

	<body>
		<div class="external">
			<div class="page-header">
				<ul class="breadcrumb">
					<li>
						<i class="iconfont">&#xe648;</i>
						<a href="javascript:void(0)">教练管理</a>
					</li>
				</ul>
			</div>

			<!--一个面板-->
    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>教练列表</span>
        </div>
        <!--搜索-->
        <div class="pull">
        	<form id="coachform">
					<div class="pull-right">

                            <a href="<%=request.getContextPath()%>/user/coach/addPage">
                            	<input class="btn btn-sm btn-success" type="button" value="新增">
                            </a>
					</div>

					<div class="pull-left">
						<input type="text" class="form-control" name="coachname" id="serachcoachname" placeholder="请输入姓名或手机号">
						<div class="divselect" >
	 						<select id="select_sex" name="sex">
											<option value="">-性别-</option>
											<option  value="0">女</option>
											<option  value="1">男</option>
							</select>
							<i class="iconfont type1">&#xe772;</i>
						</div>
				<%-- 		<div class="divselect" >
							<select id="select_goodat" name="goodat">
											<option value="">-善长的项目-</option>
											<c:forEach items="${coachGoodAt}" var="item"
												varStatus="status">
													<option  value="${item.basicvalue}">${item.title }</option>
											</c:forEach>
							</select>
							<i class="iconfont type1">&#xe772;</i>
						</div> --%>
						<div class="divselect" >
							<select id="select_stores" name="stores">
											<option value="">-服务门店-</option>
											<c:forEach items="${storelist}" var="item"
												varStatus="status">
													<option  value="${item.id}">${item.storename }</option>
											</c:forEach>
							</select>
							<i class="iconfont type1">&#xe772;</i>
						</div>
						<div class="divselect" >
							<select id="select_coachStatus" name="status">
											<option value="">-合作状态-</option>
											<option  value="2">已终止</option>
											<option  value="1">合作中</option>
											<option  value="3">待审核</option>
							</select>
							<i class="iconfont type1">&#xe772;</i>
						</div>

						<button class="btn btn-app btn-success" type="button" id="searchCoach">查询</button>
						<button class="btn btn-default" type="button" id="resetCoach">重置</button>
					</div>
					</form>
				</div>

        <!--区域-->
        <div class="container">
        	<div class="row clearfix" id="cleardiv">
        		<c:forEach items="${coachlist }" var="items">

	        		<c:choose>
	        			<c:when test="${items.status==1}">
		        			<div class="col-sm-3" style="padding:20px;">
			        			<div class="jlk" >
			        				<div class="jlk-l">
			        					<img src="${items.image}"/>
			        				</div>
			        				<div class="jlk-r">
			        					<h1>${items.coachname}<span><input class="btn btn-xs btn-yellow" type="button" value="合作中"></span></h1>
			        					<p>${items.goodat}</p>
			        				</div>

			        			</div>
				       			<div class="jlk-mask a0 fadeIn" >
				       				<div class="jlk-div">
				        					<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href="<%=request.getContextPath()%>/user/coach/detailPage?id=${items.id}"><i class="iconfont">&#xe607;</i></a>
				        					</span>
				        					<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="终止"><i class="iconfont" data-sign="2" data-id="${items.id }">&#xe662;</i>
				        					</span>
				        				<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href="<%=request.getContextPath()%>/user/coach/editPage?id=${items.id}"><i class="iconfont">&#xe630;</i></a>
				        				</span>
				        			</div>
				        		</div>
				        	</div>
	        			</c:when>
	        			<c:when test="${items.status==2}">
			        		<div class="col-sm-3" style="padding:20px;">
			        			<div class="jlk" >
			        				<div class="jlk-l">
			        					<img src="${items.image}"/>
			        				</div>
			        				<div class="jlk-r">
			        					<h1>${items.nickname} <span><input class="btn btn-xs btn-yellow" disabled type="button" value="已终止"></span></h1>
			        					<p>${items.goodat}</p>
			        				</div>
			        			</div>
				        		<div class="jlk-mask a0 fadeIn">
				        				<div class="jlk-div">
				        					<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href="<%=request.getContextPath()%>/user/coach/detailPage?id=${items.id}"><i class="iconfont">&#xe607;</i></a>
				        					</span>
				        					<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="再次合作"><i class="iconfont" data-sign="3" data-id="${items.id }">&#xe627;</i>
				        					</span>
				        				<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href="<%=request.getContextPath()%>/user/coach/editPage?id=${items.id}"><i class="iconfont">&#xe630;</i></a>
				        					</span>
				        				<span  class="jsk_del a4 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="iconfont" data-sign="0" data-id="${items.id }">&#xe637;</i>
				        					</span></div>
				        			</div>
			        		</div>
	        			</c:when>
	        			<c:when test="${items.status==3}">
			        		<div class="col-sm-3" style="padding:20px;">
			        			<div class="jlk" >
			        				<div class="jlk-l">
			        					<img src="${items.image}"/>
			        				</div>
			        				<div class="jlk-r">
			        					<h1>${items.nickname} <span><input class="btn btn-xs btn-yellow" disabled type="button" value="待审核"></span></h1>
			        					<p>${items.goodat}</p>
			        				</div>
			        			</div>
				        		<div class="jlk-mask a0 fadeIn">
				        				<div class="jlk-div">
				        					<span class="a1 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="查看"><a href="<%=request.getContextPath()%>/user/coach/detailPage?id=${items.id}"><i class="iconfont">&#xe607;</i></a>
				        					</span>
				        					<span class="a2 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="审核"><i class="iconfont" data-sign="1" data-id="${items.id }">&#xe627;</i>
				        					</span>
				        					<span class="a3 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="编辑"><a href="<%=request.getContextPath()%>/user/coach/editPage?id=${items.id}"><i class="iconfont">&#xe630;</i></a>
				        					</span>
				        					<span  class="jsk_del a4 rotateInLeft" data-toggle="tooltip" data-placement="bottom" title="删除"><i class="iconfont" data-sign="0" data-id="${items.id }">&#xe637;</i>
				        					</span></div>
				        			</div>
			        		</div>
	        			</c:when>
	        		</c:choose>

        		</c:forEach>

        </div>
        </div>
        <!--//区域-->
    </div>


</div>

        <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="success_caozuo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                    	    <a class="btn btn-default" href="<%=request.getContextPath()%>/user/coach/listPage">确定</a>
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
        <div class="modal fade" id="failure_caozuo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
<script
	src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(document).on('mouseenter','.jlk',function() {
			    $(this).siblings(".jlk-mask").show();
/* 					$(this).siblings(".jlk-mask").find(".jsk_del").on("click",function(){
					   $(this).parent().parent().parent().remove();
					 }); */
					 $(this).siblings(".jlk-mask").mouseenter(function() {
					 	$("[data-toggle='tooltip']").tooltip();
					 	 });

			});
			$(document).on('mouseleave','.jlk-mask',function() {
			    $(this).hide();

			});

		});

</script>
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
	src="<%=request.getContextPath()%>/assets/js/coach/coachlist.js"></script>
</body>
</html>