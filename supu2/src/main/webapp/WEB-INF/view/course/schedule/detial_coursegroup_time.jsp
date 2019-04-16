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

        .form-group{overflow: hidden;margin-top: 40px}
        .col-sm-2{padding: 20px 5px;}
        .btn_return{
            margin-left: 20%;
            padding: 10px 20px;
            background-color: #4CA8EB;
            color: #fff;
            border-radius: 4px;
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
            <span>${year }年${month }月团课排期详情</span>
        </div>
        <div class="form-group">
        	<c:forEach items="${timeList }" var="items" varStatus="status">
				<c:choose>
					<c:when test="${status.index==0 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:when test="${status.index==5 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:when test="${status.index==10 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:when test="${status.index==15 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:when test="${status.index==20 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:when test="${status.index==25 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:when test="${status.index==30 }">
						<div class="col-sm-2 col-sm-offset-1">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-2">${items.day }日：${items.starttime }~${items.endtime }</div>
					</c:otherwise>
				</c:choose>
        	</c:forEach>
<!--             <div class="col-sm-2 col-sm-offset-1">1日：10：00~11:00</div>
            <div class="col-sm-2">2日：10：00~11:00</div>
            <div class="col-sm-2">3日：10：00~11:00</div>
            <div class="col-sm-2">4日：10：00~11:00</div>
            <div class="col-sm-2">5日：10：00~11:00</div>
            <div class="col-sm-2 col-sm-offset-1">6日：10：00~11:00</div>
            <div class="col-sm-2">7日：10：00~11:00</div>
            <div class="col-sm-2">8日：10：00~11:00</div>
            <div class="col-sm-2">9日：10：00~11:00</div>
            <div class="col-sm-2">10日：10：00~11:00</div>
            <div class="col-sm-2 col-sm-offset-1">11日：10：00~11:00</div>
            <div class="col-sm-2">12日：10：00~11:00</div>
            <div class="col-sm-2">13日：10：00~11:00</div>
            <div class="col-sm-2">14日：10：00~11:00</div>
            <div class="col-sm-2">15日：10：00~11:00</div>
            <div class="col-sm-2 col-sm-offset-1">16日：10：00~11:00</div>
            <div class="col-sm-2">17日：10：00~11:00</div>
            <div class="col-sm-2">18日：10：00~11:00</div>
            <div class="col-sm-2">19日：10：00~11:00</div>
            <div class="col-sm-2">20日：10：00~11:00</div>
            <div class="col-sm-2 col-sm-offset-1">21日：10：00~11:00</div>
            <div class="col-sm-2">22日：10：00~11:00</div>
            <div class="col-sm-2">23日：10：00~11:00</div>
            <div class="col-sm-2">24日：10：00~11:00</div>
            <div class="col-sm-2">25日：10：00~11:00</div>
            <div class="col-sm-2 col-sm-offset-1">26日：10：00~11:00</div>
            <div class="col-sm-2">27日：10：00~11:00</div>
            <div class="col-sm-2">28日：10：00~11:00</div>
            <div class="col-sm-2">29日：10：00~11:00</div>
            <div class="col-sm-2">30日：10：00~11:00</div> -->
            <!--<div class="col-sm-2 col-sm-offset-1">31日：10：00~11:00</div>-->

        </div>

        <div class="form-group">
            <div class="col-sm-2 col-sm-offset-5">
                <a href="<%=request.getContextPath()%>/user/course/courseListPage?courseId=${courseId}" class="btn_return">返回</a>
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