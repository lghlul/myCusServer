<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>评价</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
    <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>

    <style>
  		.col-sm-1>span{
			color: #ff0000;
		}
        .teal{
        	text-align: center;
			margin: 30px auto;
        }
        .teals{
        	text-align: center;
        	margin: 5px auto;
        }
        .col-border{
        	border: 1px solid #E0E4ED;
        	padding: 15px 0;
        }
        .single{
        	display: none;
        }
        .time{
        	width: 100%;
        }
        .time>.form-control {
    		width: 100%;
		}
		.special{
			width: 4%!important;
			text-align: center;
		}
		.contentShow{
			padding: 7px;
		}
    </style>
</head>
<body>
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">评价</a>
            </li>
        </ul>
    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>评价信息</span>
        </div>

        <form class="form-horizontal" id="form">
            <div class="form-group">
                <label class="col-sm-1 control-label">
                                                        评价日期
                </label>
                <div class="col-sm-2">
					<div class="contractBeginDay time">
						<input type="text" name="startTime" class="form-control" id="startTime"
							placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
									<!-- <i class="icon iconfont data type1"></i> -->
					</div>
				</div>
				<div class="col-sm-1 special contentShow">
					至
				</div>
				<div class="col-sm-2">
					<div class="contractBeginDay time">
						<input type="text" name="endTime" class="form-control" id="endTime"
							placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" >
									<!-- <i class="icon iconfont data type1"></i> -->
					</div>
                </div>

                <label class="col-sm-1 control-label">
                                                        评价星级
                </label>
                <div class="col-sm-2">
					<select id="startlevel" class="form-control" name="startlevel">
						<option value="">-选择星级-</option>
						<c:forEach items="${commentStar }" var="items">
							<option value="${items.basicvalue }">${items.title }</option>
						</c:forEach>
					</select>
                </div>

                <label class="col-sm-1 control-label">
                                                        评价教练
                </label>
                <div class="col-sm-2">
					<select id="coachs" class="form-control" name="coachs">
						<option value="">-请选择-</option>
						<c:forEach items="${coach }" var="items">
							<option value="${items.id }">${items.coachname }</option>
						</c:forEach>
					</select>
                </div>
			</div>

			 <div class="form-group">
				<label class="col-sm-1 control-label">
                                                        评价门店
                </label>
				<div class="col-sm-2">
					<select id="stores" class="form-control" name="stores">
						<option value="">-请选择-</option>
					<c:forEach items="${store }" var="items">
							<option value="${items.id }">${items.storename }</option>
						</c:forEach>
					</select>
                </div>
				<div class="col-sm-2">
					<button type="button" class="btn btn-success" id="searchclick">查询</button>
					<button type="button" class="btn btn-default" id="resetclick">重置</button>
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-5 col-sm-offset-1 menu">
                     <button type="button" class="btn btn-success checkbutton"  data-id="2">待审核评价</button>
                     <button type="button" class="btn checkbutton" data-id="1">审核通过</button>
                     <button type="button" class="btn checkbutton" data-id="3">审核不通过</button>
                 </div>
			</div>

 			<div class="form-group">
				<div class="col-sm-1 teals">
                	<input name="" type="checkbox">
                </div>
                <div class="col-sm-2 menu">
                	<button type="button" class="btn btn-success  tongguo" data-sign="1">通过</button>
                	<button type="button" class="btn tongguo" data-sign="2">不通过</button>
                	<input type="hidden" id="commentstatus" name="status" value="2"></input>
                	<input type="hidden" id="biaoji"></input>
                </div>
			</div>

			<!-- tab切换内容区域 -->
			<div>
			  <!-- 待审核评价 -->
			  <div class="single" id="waitAudit">

<!--  				<div class="form-group">
					<div class="col-sm-1 teal">
                      <input name="" type="checkbox">
                	</div>
					<div class="col-sm-11 col-border">
						<div class="col-sm-10">
							<div class="col-sm-12">
								<div class="col-sm-4">评价人： dslp</div>
								<div class="col-sm-4">评价星级： jljl</div>
								<div class="col-sm-4">评价时间：2017-07-28 11:10:05</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-4">评价教练：lfj</div>
								<div class="col-sm-4">评价门店： 南大店</div>
								<div class="col-sm-4">课程类型：减脂</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-6">评价内容：　服务态度好、非常满意</div>
							</div>
						</div>
						<div class="col-sm-2">
                     		<a class="btn btn-default btn-success" data-toggle="modal" data-target="#pass">通过</a>
                     		<a class="btn btn-default" data-toggle="modal" data-target="#refuse">不通过</a>
						</div>
					</div> -->
				</div>

			  </div>
				<!-- 审核通过 -->
<!-- 			  <div class="single" id="througthAudit">

			  </div> -->
				<!-- 审核不通过 -->
<!-- 			  <div class="single" id="noAudit">

			  </div> -->
			</div>

        </form>
    </div>

        		  <!--弹出内容-->
        <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="pass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-success" id="myModalLabel">
                           <!-- <i class="iconfont">&#xe6bf;</i> -->
                           	操作成功！
                        </h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-default" href="<%=request.getContextPath()%>/user/comment/listPage">确定</a>
                        <a class="btn btn-default" href="#">取消</a>
                    </div>
                </div>
            </div>
        </div>


          <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="refuse" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <!-- <i class="iconfont">&#xe643;</i> -->
                          	操作失败
                        </h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                       <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> -->
      					<button type="button" class="btn btn-default" data-dismiss="modal">确定
                        </button>
                    </div>
                </div>
            </div>
        </div>
</div>
</body>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/comment/commentlist.js"></script>

<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript">
    $(function(){
        // dom加载完毕
        var $m_btn = $('#modalBtn');
        var $modal = $('#myModal');
        $m_btn.on('click', function(){
            $modal.modal({backdrop: 'static'});
        });

//         测试 bootstrap 居中
        $modal.on('show.bs.modal', function(){
            var $this = $(this);
            var $modal_dialog = $this.find('.modal-dialog');
            // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
            $this.css('display', 'block');
            $modal_dialog.css({'margin-top': Math.max(0, ($(window).height() - $modal_dialog.height()) / 3) });
        });

    });
</script>

<script>
//点击 “待审核评价” “审核通过” “审核不通过” 按钮的切换
$(function(){
	$(".single").first().show();
	$(".menu .btn").click(function(){
		var index=$(".menu .btn").index(this);
		$(this).addClass("btn-success").siblings().removeClass("btn-success");
		$(".single").eq(index).show().siblings().hide();
	});

});
//点击 ”通过“ ”不通过“ 按钮的切换
$(function(){
		$(".menu .btn").click(function(){
			if(!$(this).hasClass("btn-success")){
				$(this).addClass("btn-success").siblings().removeClass("btn-success");
			}
		});
	});
</script>

</html>



