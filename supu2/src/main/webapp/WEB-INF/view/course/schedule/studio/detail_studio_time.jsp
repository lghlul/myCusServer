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
    <link rel="stylesheet" type="text/css" href="../../assets/css/add_scheduling.css">
    <script src="../../assets/js/jquery/jquery-2.0.3.min.js"></script>
    <script src="../../assets/js/My97DatePicker/WdatePicker.js"></script>
    <style>
        .menu-panel {padding: 30px 0;}
        .btn-group > .btn, .btn-group-vertical > .btn{ padding:5px;}
        .divselect select {width: 150px;}
        .pull-left>.form-control {width: 150px;}

        .form-group{overflow: hidden}
        .txt-left{text-align: left;margin-top: 8px}
        .txt-right{text-align: right}
        .col-sm-2{margin: 20px;}
        .sch-date{font-weight: normal}
        .pull-right .btn-sm{background-color:#E0E4ED; color: #333}
    </style>
</head>

<body>
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">排期</a>
            </li>
        </ul>
    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>新增排期（${year }年${month }月）</span>
        </div>

		<input type="hidden" value="${course.id }" id="courseId">

		<input type="hidden" value="${date }" id="date">
        <div class="pull-right">
      <!--    <input class="btn btn-sm" type="button"value="返回"> -->
            <a class="btn btn-sm" href="<%=request.getContextPath()%>/user/course/workspaceTimePage?courseId=${courseId }">返回</a>
        </div>

        <div class="form-group" style="margin-top: 40px">
            <div class="col-sm-3 col-sm-offset-1">课程名称：&nbsp;&nbsp;${course.coursename }</div>
            <div class="col-sm-3">教练：&nbsp;&nbsp;${coach }</div>
            <div class="col-sm-3">课程类型：&nbsp;&nbsp;工作室</div>
        </div>

        <div class="form-group" style="padding-left: 50px;margin-top: 50px">
      	 	 <c:forEach items="${courseStudioTime}" var="item">
		          	<div class="col-sm-2">
		                <div class="outside-frame">
		                    <div class="sch-date">${item.day}日</div>
		                	 <input type="hidden" value="${item.day }" name="day">

		                     	<c:forEach items="${item.courseStudioTime}" var="i">
									 <div class="de-show">
									  	   第${i.classhour }课时&nbsp;&nbsp;${i.starttime }~${i.endtime }
						             </div>
		                    	 </c:forEach>
		                </div>
		            </div>
          	 </c:forEach>


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

