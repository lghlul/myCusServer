<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta charset="utf-8">
		<title>会员卡管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" type="text/css" href="../../assets/css/common.css">
		<link href="../../assets/bootstrap/css/bootstrap.css"rel="stylesheet">
		<style>
		.menu-panel {padding: 40px 30px 40px 10px;}
		.container{ height: auto;}
		.bk{border:1px dashed #E0E4ED;padding:20px 5px 0px 0px; border-radius: 10px; }
		.js_img{ width:100%;}
		.js_img img{ height:239px;}
		.js_img img{ width:100%;}
		.edit_dell,.edit_ed{display: none;cursor: pointer;}
		.edit_ed i,.edit_dell i{ font-size: 24px;color:#FF0000;}
		.jg{overflow: hidden; margin-top: 10px; font-size: 16px;}
		.jg p{ float: left;}
		.jg span{ float: right; color:#FF0000;}
		.stop .bk{ background-color:#F8F9FD;}
		</style>
	</head>

	<body>
		<div class="external">
			<div class="page-header">
				<ul class="breadcrumb">
					<li>
						<i class="iconfont">&#xe648;</i>
						<a href="javascript:void(0)">会员管理</a>
					</li>
				</ul>
			</div>

			<!--一个面板-->
    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>启用中</span>
        </div>
        <div class="panel-right">
            <a class="panel-right-a" id="test18"  role="button" data-toggle="collapse"
            	 href="#collapseOne"aria-expanded="false" aria-controls="collapseExample">
                <i class="iconfont">&#xe76e;</i>
            </a>
        </div>
        <div class="in" id="collapseOne">
        <!--图片区域-->
        <div class="container">
	<div class="row clearfix">

	<c:forEach items="${memberCard }" var="items">
		<div class="col-sm-4" style="padding:20px;">
			<div class="row clearfix bk" >
				<div class="col-sm-2" style="width: 10%;">
				<div class="edit_dell" data-id="${items.id }"><i class="iconfont">&#xe637;</i></div>
				</div>
				<div class="col-sm-6"  style="width:80%;">
				<div class="js_img">
					<a href="<%=request.getContextPath()%>/user/memberCard/detailPage?id=${items.id}">
					<img src="${items.mcardimg }"/>
					</a>
				</div>
				<div class="jg"><p><a href="<%=request.getContextPath()%>/user/memberCard/detailPage?id=${items.id}">${items.membername}</a> </p><span>${items.amountmoney}元/月</span>
				</div>
				</div>
				<div class="col-sm-2" style="width: 10%;">
				<div class="edit_ed"><a href="<%=request.getContextPath()%>/user/memberCard/editPage?id=${items.id}"><i class="iconfont">&#xe6e3;</i></a></div>
				</div>
			</div>
		</div>
	</c:forEach>
<!-- 		<div class="col-sm-4" style="padding:20px;">
			<div class="row clearfix bk" >
				<div class="col-sm-2" style="width: 10%;">
				<div class="edit_dell"><i class="iconfont">&#xe637;</i></div>
				</div>
				<div class="col-sm-6"  style="width:80%;">
				<div class="js_img"><img src="../../assets/images/jsk/hyk.png"/></div>
				<div class="jg"><p>1月卡</p><span>99元/月</span>
				</div>
				</div>
				<div class="col-sm-2" style="width: 10%;">
				<div class="edit_ed"><i class="iconfont">&#xe6e3;</i></a></div>
				</div>
			</div>
		</div> -->


		<div class="col-sm-4 jsk_add" style="padding:20px;" id="qiyongcard">
			<a href="<%=request.getContextPath()%>/user/memberCard/addPage"><div class="row clearfix bk" >
				<div class="col-sm-2" style="width: 10%;"></div>
				<div class="col-sm-6"  style="width:80%;">
				<div class="js_img" style="margin-bottom: 40px;"><img src="../../assets/images/jsk/hyk_add.png"/></div>
				</div>
				<div class="col-sm-2" style="width: 10%;"></div>
			</div></a>
		</div>

</div>
        </div>
        <!--//图片区域-->
        </div>
    </div>


 	<!--线-->
				<div class="separator"></div>
<!--一个面板-->
    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>未启用</span>
        </div>
        <div class="panel-right">
            <a class="panel-right-a" id="test18"  role="button" data-toggle="collapse"
            	 href="#collapse2"aria-expanded="false" aria-controls="collapseExample">
                <i class="iconfont">&#xe76e;</i>
            </a>
        </div>
        <div class="in" id="collapse2">
         <!--图片区域-->
        <div class="container stop">
	<div class="row clearfix">
	<c:forEach items="${no_membercard }" var="items">
		<div class="col-sm-4" style="padding:20px;">
			<div class="row clearfix bk" >
				<div class="col-sm-2" style="width: 10%;">
				<div class="edit_ed"><a href="<%=request.getContextPath()%>/user/memberCard/editPage?id=${items.id}"><i class="iconfont">&#xe6e3;</i></a></div>
				</div>
				<div class="col-sm-6"  style="width:80%;">
				<div class="js_img">
				<img src="${items.mcardimg }"/></div>
				<div class="jg"><p>
				${items.membername }</p><span>${items.amountmoney }元/月</span>
				</div>
				</div>
				<div class="col-sm-2" style="width: 10%;"></div>
			</div>
		</div>
	</c:forEach>


</div>
        </div>
        <!--//图片区域-->

        </div>
    </div>


 	<!--线-->
</div>


        <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="success_del" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-success" id="myModalLabel">
                           <i class="iconfont">&#xe6bf;</i>
                           	删除成功！
                        </h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                    	    <a class="btn btn-default" href="<%=request.getContextPath()%>/user/memberCard/listPage">确定</a>
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
        <div class="modal fade" id="failure_del" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe643;</i>
                          	 有会员持有此卡，无法删除！
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
<script type="text/javascript">

$(function(){
/* $(".bk").mouseover(function() {
    $(this).children().find(".edit_dell,.edit_ed").show();
		$(this).find(".edit_dell").on("click",function(){
		   $(this).parent().parent().parent().remove();
		 });
});
$(".bk").mouseout(function() {
    $(this).children().find(".edit_dell,.edit_ed").hide();
}); */

	$(document).on('mouseover','.bk',function(){
	    $(this).children().find(".edit_dell,.edit_ed").show();
/* 		$(this).find(".edit_dell").on("click",function(){
		   $(this).parent().parent().parent().remove();
		 }); */
	});
	$(document).on('mouseout','.bk',function(){
		$(this).children().find(".edit_dell,.edit_ed").hide();

	});
});


</script>
<script
	src="<%=request.getContextPath()%>/assets/js/membercard/membercardlist.js"></script>