<%@ page contentType="text/html; charset=UTF-8"%>
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
    <link rel="stylesheet" type="text/css" href="../../assets/css/common.css">
    <script src="../../assets/js/jquery/jquery-2.0.3.min.js"></script>
    <script src="../../assets/js/My97DatePicker/WdatePicker.js"></script>
    <style>
        .menu-panel {padding: 30px 0;}
        .btn-group > .btn, .btn-group-vertical > .btn{ padding:5px;}

        .framework{
            width: 60%;
            margin: 220px auto;
            text-align: center;
        }
        .framework input{width: 202px;display: inline-block}
        .btn_quit{
            margin-left: 5%;
            padding: 10px 20px;
            border: 1px solid #D2D4E0;
            color: #666;
            border-radius: 4px;
        }
        .btn_next{
            padding: 10px 50px;
            background-color: #4CA8EB;
            color: #fff;
            border-radius: 4px;
        }
        .btn_next:hover{color: #fff}
        .dfg{
            width: 40%;
            margin: 60px auto;
            text-align: center;
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

	<form id="form" method="post" action="<%=request.getContextPath()%>/user/course/addTimePageSecond">
	    <div class="menu-panel">
	        <div class="panel-header">
	            <b></b>
	            <span>团课排期新增</span>
	        </div>
	        <div class="framework">
	        <input type="hidden" value="${courseId }" name="courseId">

	            选择月份：
	            <!--<input id="year" class="form-control" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy年',minDate:new Date()})" type="text">-->

	            <input id="month" class="form-control" name="date" value="${date}" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM',minDate:new Date()})"
	            type="text" placeholder="请选择月份">
	        </div>
	        <div class="dfg">
	            <!-- <a href="" class="btn_next">下一步</a> -->
	            <input type="submit" class="btn_next" value="下一步">
	            <a class="btn_quit" href="<%=request.getContextPath()%>/user/course/courseListPage?courseId=${courseId}">取消</a>
	        </div>
	    </div>
	</form>


   <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="fail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe643;</i>
                          	<span id="span_msg">您本月对该课程已经进行过排期</span>
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
</div>
</body>

</html>

<script src="../../assets/js/script.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap-table.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap-table-zh-CN.js"></script>
<script src="../../assets/bootstrap/js/bootbox.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="../../assets/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/course/schedule/add_coursegroup_first_time.js"></script>
