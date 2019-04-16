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
        .col-sm-3{padding: 20px 5px;}
        .btn_quit{
            margin-left: 15%;
            padding: 10px 20px;
            border: 1px solid #D2D4E0;
            color: #666;
            border-radius: 4px;
        }
        .btn_return{
            margin-left: 15%;
            padding: 10px 20px;
            background-color: #4CA8EB;
            color: #fff;
            border-radius: 4px;
        }
        .btn_return:hover{color: #fff}
        .col-sm-3 input{
            width: 150px;
            display: inline-block;
        }
        .col-sm-3 input.txt{
            width: 20px;
            border: none;
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
            <span>${year }年${month }月团课排期编辑</span>
        </div>
        <form id="form" method="post" action="<%=request.getContextPath()%>/user/course/editSaveTime">
        <div class="form-group">
                <input type="hidden" value="${courseId}" name="courseId">
		        <input type="hidden" value="${year}" name="year">
		        <input type="hidden" value="${month}" name="month">
			<c:forEach items="${editTimeList }" var="items" varStatus="status">
				<div class="col-sm-3 col-sm-offset-1">

						<input class="txt" value="${items.day }" name="CourseGroupTimeList[${status.index}].day" type="text" readonly="readonly"/>
			                日：
						<input id="startDate${status.index }" <c:if test="${!items.isEdit}">disabled="true"</c:if> name="CourseGroupTimeList[${status.index}].starttime" class="form-control" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endDate${status.index }\')}'})" type="text" value="${items.starttime }" placeholder="请选择时间">
	                	~
	                	<input id="endDate${status.index }" <c:if test="${!items.isEdit}">disabled="true"</c:if> name="CourseGroupTimeList[${status.index}].endtime" class="form-control" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'startDate${status.index }\')}'})" type="text" value="${items.endtime }" placeholder="请选择时间">


			     		<input type="hidden" value="${courseId}"  name="CourseGroupTimeList[${status.index}].courseid">
			     		<input type="hidden" value="${items.year}"  name="CourseGroupTimeList[${status.index}].year">
			     		<input type="hidden" value="${items.month}"   name="CourseGroupTimeList[${status.index}].month">
			     		<input type="hidden" value="${items.id}" <c:if test="${!items.isEdit}">disabled="true"</c:if> name="CourseGroupTimeList[${status.index}].id">
			     </div>
			 </c:forEach>


        </div>
        <div class="form-group">
            <div class="col-sm-2 col-sm-offset-4">
                <a href="<%=request.getContextPath()%>/user/course/courseListPage?courseId=${courseId}" class="btn_quit">取消</a>
                <!-- <a class="btn_return">提交</a> -->
                <input type="submit" class="btn_return">
            </div>
        </div>
        </form>
    </div>


</div>



<!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                        <!-- <a id="a_infoLink" class="btn btn-default" href="">查看咨询</a> -->
                       <!--  <a class="btn btn-primary" href="javascript:void(0)">复制链接</a> -->
                        <%-- <a class="btn btn-info" href="<%=request.getContextPath() %>/user/realseInfo/listPage">返回资讯管理</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/realseInfo/addPage">继续发布</a> --%>
                    </div>
                    <div class="modal-footer">
                    <!-- 	<a id="a_infoLink" class="btn btn-default" href="">查看咨询</a> -->
                       <!--  <a class="btn btn-primary" href="javascript:void(0)">复制链接</a> -->
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/course/courseListPage?courseId=${courseId}">确定</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/course/editPageTime?courseId=${courseId}&&year=${year}&&month=${month}">继续编辑</a>
                        <%-- <a class="btn btn-success" href="<%=request.getContextPath() %>/user/course/addPage">继续添加</a> --%>
                        <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭 -->
                        </button>
                   <!--      <button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
                    </div>
                </div>
            </div>
        </div>
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
                          	<span id="span_msg"></span>
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
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/course/schedule/edit_coursegroup_time.js"></script>