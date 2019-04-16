<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.Date"%>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="../../assets/css/common.css">
    <style>
        .menu-panel {padding: 30px 0;}
        .btn-group > .btn, .btn-group-vertical > .btn{ padding:5px;}

        .form-group{overflow: hidden;margin-top: 40px}
        .col-sm-3{padding: 20px 5px;}
        .col-sm-4{padding: 20px 5px;}
        .btn_quit{
            margin-left: 10%;
            padding: 10px 20px;
            border: 1px solid #D2D4E0;
            color: #666;
            border-radius: 4px;
        }
        .btn_sbmt{
            margin-left: 10%;
            padding: 10px 40px;
            background-color: #4CA8EB;
            color: #fff;
            border-radius: 4px;
        }
        .btn_sbmt:hover{color: #fff}
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

<form id="form" method="post">
    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>团课排期新增&nbsp;&nbsp;&nbsp;月份：${year }年${month }月</span>
        </div>
        <div class="form-group">
        <input type="hidden" value="${courseId}" name="courseId">
        <input type="hidden" value="${year}" name="year">
         <input type="hidden" value="${month}" name="month">


      <c:forEach var="i" begin="1" end="${countDays }">
      	<div class="col-sm-3 col-sm-offset-1">
                <input class="txt" value="${i}" name="CourseGroupTimeList[${i-1}].day" type="text" readonly="readonly"/>
                <c:choose>
                	<c:when test="${i<10 }">
                		<c:set var="day" value="0${i }"></c:set>
                	</c:when>
                	<c:otherwise>
						<c:set var="day" value="${i }"></c:set>
                	</c:otherwise>
                </c:choose>
                日：		<c:set var="val" value="${year}-${month}-${day }"></c:set>
                 <c:set var="nowDate">
				    <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd " type="date"/>
				</c:set>
				<input type="hidden" id="nowDate_hidden" value=" <fmt:formatDate value="<%=new Date()%>" pattern="HH:mm " type="date"/>">
<%-- 				<c:set var="createDate">
				    <fmt:formatDate value="${val}" pattern="yyyy-MM-dd " type="date"/>
				</c:set> --%>
                <input id="startDate${i }" name="CourseGroupTimeList[${i-1}].starttime" class="form-control startDate"
                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',<c:if test="${val==nowDate }" >minDate:'#F{$dp.$D(\'nowDate_hidden\')}',</c:if>maxDate:'#F{$dp.$D(\'endDate${i }\')}'})"
                <c:if test="${val<nowDate }">disabled="true"</c:if>   type="text" placeholder="请选择时间">
                ~
                <input id="endDate${i }"  name="CourseGroupTimeList[${i-1}].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'startDate${i }\')}'})"  <c:if test="${val<nowDate }">disabled="true"</c:if> type="text" placeholder="请选择时间">
            </div>

      </c:forEach>


        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <a href="<%=request.getContextPath()%>/user/course/addTimePageFirst?courseId=${courseId}&&choosedate=${year}-${month}" class="btn_sbmt">上一步</a>
                <input type="submit" class="btn_sbmt">
                <a class="btn_quit" href="<%=request.getContextPath()%>/user/course/courseListPage?courseId=${courseId}">取消</a>
            </div>
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

</form>
</div>
</body>

</html>
<script src="../../assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="../../assets/js/script.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap-table.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap-table-zh-CN.js"></script>
<script src="../../assets/bootstrap/js/bootbox.js"></script>
   <script src="../../assets/js/My97DatePicker/WdatePicker.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="../../assets/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/course/schedule/add_coursegroup_second_time.js"></script>
