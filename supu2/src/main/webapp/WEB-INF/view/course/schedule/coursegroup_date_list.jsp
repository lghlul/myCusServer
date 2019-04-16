<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="en">

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/common.css">
    <style>
        .menu-panel {padding: 30px 0;}
        .btn-group > .btn, .btn-group-vertical > .btn{ padding:5px;}
        .divselect select {width: 150px;}
        .pull-left>.form-control {width: 150px;}

        .form-group{overflow: hidden}
        .txt-left{text-align: left;margin-top: 8px}
        .txt-right{text-align: right}
        .btn_return {
        	width: 50px;
    		padding: 10px 20px;
    		background-color: #4CA8EB;
    		color: #fff;
    		border-radius: 4px;
    		box-sizing: border-box;
		}
		.vdrg {
			height: 40px;
			line-height: 40px;
    		float: right;
    		margin-right: 100px;
		}
    </style>
</head>

<body>
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">团课排期</a>
            </li>
        </ul>
    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>课程基本信息</span>
        </div>
        <div class="form-group" style="margin-top: 40px">
            <div class="col-sm-3 col-sm-offset-1">课程名称：&nbsp;&nbsp;${coursename }</div>
            <div class="col-sm-3">教练：&nbsp;&nbsp;${coachname }</div>
            <div class="col-sm-3">团课类型：&nbsp;&nbsp;<c:if test="${type==1 }">精品团课</c:if><c:if test="${type==2 }">基础团课</c:if></div>
        	<div class="vdrg">
                <a href="<%=request.getContextPath()%>/user/course/listPage" class="btn_return">返回</a>
            </div>
        </div>

    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>课程排期信息</span>
        </div>

        <div class="pull">
            <div class="pull-right">
            <input type="hidden" value="${courseId }" id="courseId">
                <a href="<%=request.getContextPath()%>/user/course/addTimePageFirst?courseId=${courseId}"><input class="btn btn-sm btn-success" type="button"value="新增"></a>
            </div>

        </div>

        <div class="tab-pane">
            <div class="bootstrap-table">
                <div class="fixed-table-toolbar"></div>
                <div class="fixed-table-container" style="padding-bottom: 0px;">
                    <div class="fixed-table-header" style="display: none;">
                        <table></table>
                    </div>
                    <div class="fixed-table-body">
                        <div class="fixed-table-loading" style="top: 38px; display: none;">正在努力地加载数据中，请稍候……</div>
                        <table class="table table-hover table-striped" id="tb">
                            <tbody>
                            <c:forEach items="${courseTimeList }" var="items">
                                <tr data-index="2" data-uniqueid="1">
	                                <td style="text-align: center; vertical-align: middle; ">
	                                    <div class="col-sm-5 txt-left col-sm-offset-1">${items.year }年${items.month }月</div>
	                                    <div class="col-sm-5 txt-right">
											<button class="btn btn-bj editTime" data-year="${items.year }" data-month="${items.month }" <c:if test="${items.isEdit }">disabled="disabled"</c:if>>编辑</button>

	                                        <a href="<%=request.getContextPath()%>/user/course/detialcourseExcTime?courseId=${courseId}&year=${items.year}&month=${items.month}">
	                                        <button class="btn btn-hf">查看</button>
	                                       </a>
	                                    </div>
	                                </td>
	                            </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
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
                            中止提示
                        </h8>
                    </div>
                    <div class="modal-body">
                        <h4><span id="resultMsg"></span></h4>
                        <div class="modal-footer">
                            <a href="/SpringMVC_Spring_Mybatis/contractinfo/contralistPage.action" class="btn btn-default" data-dismiss="modal">
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
<script src="<%=request.getContextPath()%>/assets/js/course/schedule/coursegroup_date_list.js"></script>