<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.Date"%>
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
            margin: 160px auto;
            text-align: center;
        }
        .framework input.kaiShi{width: 202px;display: inline-block}
        .framework input{width: 100%;display: inline-block}
        .btn_quit{
            margin-left: 5%;
            padding: 10px 20px;
            border: 1px solid #D2D4E0;
            color: #666;
            border-radius: 4px;
        }
        .btn_next{
            padding: 10px 30px;
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
        .row{
            margin-top: 40px;
        }
		.form-group{
			overflow: hidden;
			text-align: center;
			margin-top: 100px;
		}
		.btn_next{
			margin-left: 45%;
		}
		.btn_return {
    		margin-left: 20%;
    		padding: 10px 20px;
    		background-color: #4CA8EB;
    		color: #fff;
    		border-radius: 4px;
		}
		.vdrg {
    		padding: 20px 5px;
		}
    </style>
</head>

<body>
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">训练营排期</a>
            </li>
        </ul>
    </div>


<form id="form" method="post" action="<%=request.getContextPath()%>" >
    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>训练营课程排期详情</span>
        </div>

        <div class="framework">

            开始日期：
            <input id="" name="startDate" class="form-control kaiShi" value="<fmt:formatDate value="${startdate }" pattern="yyyy-MM-dd" type="date"/>"  onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate: new Date()})" type="text" placeholder="请选择日期">

			<c:forEach items="${timeList }" var="items" varStatus="status">
	            <div class="row">
	                <div class="col-sm-2 col-sm-offset-2">
	                	<c:if test="${items.week==2 }">周一：</c:if>
	                	<c:if test="${items.week==3 }">周二：</c:if>
	                	<c:if test="${items.week==4 }">周三：</c:if>
	                	<c:if test="${items.week==5 }">周四：</c:if>
	                	<c:if test="${items.week==6 }">周五：</c:if>
	                	<c:if test="${items.week==7 }">周六：</c:if>
	                	<c:if test="${items.week==1 }">周日：</c:if>
	                </div>
	                    <div class="col-sm-2">
			                 <input id="starttime0" name="courseExcTimeList[0].starttime" class="form-control startDate"
			                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime0\')}'})"
							value="${items.starttime }"	 type="text" placeholder="请选择时间">
						 </div>
	             		  <div class="col-sm-1">至</div>

	             		 <div class="col-sm-2">
	                			<input id="endtime0"  name="courseExcTimeList[0].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime0\')}'})"
	                				value="${items.endtime }"  type="text" placeholder="请选择时间">
	                 </div>
	            </div>
			</c:forEach>


        <div class="form-group">
            <div class="col-sm-2 col-sm-offset-5 vdrg">
                <a href="<%=request.getContextPath()%>/user/course/courseExcTimePage?courseId=${courseId}" class="btn_return">返回</a>
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/course/courseExcTimePage?courseId=${courseId}">确定</a>
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
<script>
		var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="../../assets/js/script.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap-table.js"></script>
<script src="../../assets/bootstrap/js/table/bootstrap-table-zh-CN.js"></script>
<script src="../../assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>

<script src="../../assets/js/moment.min.js"></script>
<script src="../../assets/js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/course/schedule/exc/add_courseexc_time.js"></script>