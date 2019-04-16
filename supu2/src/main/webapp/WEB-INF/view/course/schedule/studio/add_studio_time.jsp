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
            <a class="btn btn-sm"
          href="<c:choose><c:when test="${type==1}"><%=request.getContextPath()%>/user/course/workspaceTimePage?courseId=${courseId }</c:when>
			   <c:otherwise><%=request.getContextPath()%>/user/course/addStudioTime?courseId=${courseId } </c:otherwise></c:choose>">
            	返回</a>
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
		                    <div class="sch-date">
		                    	${item.day}日
		                    	<c:if test="${item.isedit}"><!--判断当前日期是否允许编辑  -->
		                    		<button class="add-add add_open" >+</button><!-- data-toggle="modal" data-target="#myModal" -->
		                    	</c:if>
		                    </div>
		                	 <input type="hidden" value="${item.day }" name="day">

		                     	<c:forEach items="${item.courseStudioTime}" var="i">
									 <div class="de-show">
									     第${i.classhour }课时&nbsp;&nbsp;${i.starttime }~${i.endtime }
						                        <div class="de-edit">
						                        	<c:if test="${i.isEdit}">
							                            <button class="edit_open" style="border:none;background-color: #fff">
							                            <!-- data-toggle="modal" data-target="#winModal" -->
							                                <i class="iconfont">&#xe615;</i>
							                            </button>
						                            </c:if>
						                        </div>
						                        <input type="hidden" value="${i.starttime }" name="starttime">
						                        <input type="hidden" value="${i.endtime }" name="endtime">
						                        <input type="hidden" value="${i.id }" name="id">
						                        <input type="hidden" value="${i.classhour}" name="classhour">
						                        <c:if test="${i.isEdit}">
						                       		 <div class="de-delete delStudioTime"><i class="iconfont">&#xe644;</i></div>
						                        </c:if>
						             </div>
		                    	 </c:forEach>


		                </div>
		            </div>
          	 </c:forEach>


        </div>
    </div>

    <!-- 添加模态框（Modal） -->
    <div class="modal fade" id="add_winModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <form id="add_form">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h8 class="modal-title" id="myModalLabel">
                        设置课程时间
                    </h8>
                </div>
                <div class="modal-body modal_add_div">
                    <h4>
                         <span id="">日期：${year }年${month }月<span id="add_span_day"></span>日</span>
                        <span class="window-add modal_add_new">+</span>
                        <span class="reduce">-</span>
                    </h4>
	 				<input type="hidden" id="modal_add_year" name="year" value="${year }">
	 				<input type="hidden" id="modal_add_month" name="month" value="${month }">
	 				<input type="hidden" id="modal_add_day" name="day">
	 				<input type="hidden"  name="courseId" value="${course.id }">
	 				<div class="fr">
	                    <div class="choose-time modal_time">
	                        	上课时间：<input id="startDate0" name="addCourseStudio[0].starttime" class="form-control add_starttime"
	                        	 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endDate0\')}'})" type="text" placeholder="请选择开始时间">
	                             	       至
	                                  <input id="endDate0" name="addCourseStudio[0].endtime" class="form-control add_endtime"
	                                  onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'startDate0\')}'})" type="text" placeholder="请选择结束时间">
	                                  &nbsp;&nbsp;&nbsp;
	                                 	 第 <input  name="addCourseStudio[0].classhour"  maxlength="10" class="form-control add_classhour" type="text" style="width: 50px"/>课时
	                    </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <a  class="btn btn-default" data-dismiss="modal">
                  		      取消
                    </a>
                  <!--   <a href="#" class="btn btn-default">
                  		      提交
                    </a> -->
                    <input type="submit" class="btn btn-default">
                </div>
            </div>
            </form>
        </div>
    </div>

    <!-- 编辑模态框（Modal） -->
    <div class="modal fade" id="edit_winModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h8 class="modal-title" id="myModalLabel">
                        编辑课程时间
                    </h8>
                </div>
                <form id="edit_form">
	                <div class="modal-body">
	                    <h4>
	                        <span id="resultMsg"></span><!-- 日期：2017年11月1日 -->
	                    </h4>
	                    <input type="hidden" id="modal_edit_id" name="id">
	 					<input type="hidden" id="modal_edit_year" name="year" value="${year }">
	 					<input type="hidden" id="modal_edit_month" name="month" value="${month }">
	 					<input type="hidden" id="modal_edit_day" name="day" >
	 					<input type="hidden"  name="courseid" value="${course.id }">
	                    <div class="choose-time">
	                        上课时间：			<input  name="starttime" id="modal_edit_starttime" class="form-control"
	                         onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'modal_edit_endtime\')}'})" type="text" placeholder="请选择开始时间">
	                        至
	                        <input name="endtime" id="modal_edit_endtime" class="form-control "
	                        onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'modal_edit_starttime\')}'})" type="text" placeholder="请选择结束时间">
	                        &nbsp;&nbsp;&nbsp;
	                        第 <input class="form-control" id="modal_edit_classhour" name="classhour" type="text" style="width: 50px"/>课时
	                    </div>
	                </div>
	                <div class="modal-footer">
	                    <a  class="btn btn-default" data-dismiss="modal">
	                        取消
	                    </a>
	                   <!--  <a href="#" class="btn btn-default"> -->
	                   <input type="submit" class="btn btn-default">


	                </div>
                </form>
            </div>
        </div>
    </div>

</div>

		  <!--弹出内容-->
        <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close close_modal" data-dismiss="modal" aria-hidden="true">
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
         <%--                <a class="btn btn-info" href="<%=request.getContextPath() %>/user/coach/listPage">返回教练列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/coach/addPage">继续添加</a> --%>
                         <button type="button"  class="close_modal btn btn-default" data-dismiss="modal">关闭
                        </button>

                    </div>
                </div>
            </div>
        </div>


          <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="failure" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe643;</i>
                          	  <span id="fail_message"> </span>
                        </h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">

                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>

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
<script src="../../assets/js/course/schedule/studio/add_studio_time.js"></script>
<!--<script src="../../assets/js/contractinfo/contractinfolist.js"></script>-->
