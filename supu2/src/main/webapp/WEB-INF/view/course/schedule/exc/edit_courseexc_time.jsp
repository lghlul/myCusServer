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
        .row{
            margin-top: 40px;
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


<form id="form" method="post"  >
    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>新增训练营课程排期</span>
        </div>
        <input type="hidden" name="courseId" value="${courseId}">
        <div class="framework">

            开始日期：
            <input id="" name="editStartDate" class="form-control kaiShi"
			  value="<fmt:formatDate value="${startdate }" pattern="yyyy-MM-dd" type="date"/>"
            onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate: '%y-%M-#{%d+1}'})" type="text" placeholder="请选择日期">

			<input type="hidden" name="startDate" value="<fmt:formatDate value="${startdate }" pattern="yyyy-MM-dd" type="date"/>">

            <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周一：</div>
                    <div class="col-sm-2">
		                 <input id="starttime0" value="${timeEdit.list_mon.starttime}" name="courseExcTimeList[0].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime0\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
						<input type="hidden" name="courseExcTimeList[0].week" value="2">

             		  <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime0" value="${timeEdit.list_mon.endtime}" name="courseExcTimeList[0].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime0\')}'})"
                			 type="text" placeholder="请选择时间">
                 </div>
            </div>
            <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周二：</div>
 					<div class="col-sm-2">
		                 <input id="starttime1" value="${timeEdit.list_tue.starttime}" name="courseExcTimeList[1].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime1\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
						<input type="hidden" name="courseExcTimeList[1].week" value="3">

             		   <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime1" value="${timeEdit.list_tue.endtime}"  name="courseExcTimeList[1].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime1\')}'})"
                			 type="text" placeholder="请选择时间">
                 	</div>
            </div>
                 <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周三：</div>
                    <div class="col-sm-2">
		                 <input id="starttime2" value="${timeEdit.list_wed.starttime}" name="courseExcTimeList[2].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime2\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
						<input type="hidden" name="courseExcTimeList[2].week" value="4">

             		   <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime2" value="${timeEdit.list_wed.endtime}"  name="courseExcTimeList[2].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime2\')}'})"
                			 type="text" placeholder="请选择时间">
                 </div>
            </div>
                 <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周四：</div>
                     <div class="col-sm-2">
		                 <input id="starttime3" value="${timeEdit.list_ths.starttime}" name="courseExcTimeList[3].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime3\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
						<input type="hidden" name="courseExcTimeList[3].week" value="5">

             		   <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime3"  value="${timeEdit.list_ths.endtime}" name="courseExcTimeList[3].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime3\')}'})"
                			 type="text" placeholder="请选择时间">
                 </div>
            </div>
                 <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周五：</div>
                     <div class="col-sm-2">
		                 <input id="starttime4" value="${timeEdit.list_fri.starttime}" name="courseExcTimeList[4].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime4\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
						<input type="hidden" name="courseExcTimeList[4].week" value="6">

             		   <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime4" value="${timeEdit.list_fri.endtime}" name="courseExcTimeList[4].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime4\')}'})"
                			 type="text" placeholder="请选择时间">
                 </div>
            </div>
              <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周六：</div>
                    <div class="col-sm-2">
		                 <input id="starttime5" value="${timeEdit.list_sat.starttime}" name="courseExcTimeList[5].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime5\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
					<input type="hidden" name="courseExcTimeList[5].week" value="7">

             		   <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime5"  value="${timeEdit.list_sat.endtime}" name="courseExcTimeList[5].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime5\')}'})"
                			 type="text" placeholder="请选择时间">
                 </div>
            </div>
                 <div class="row">
                <div class="col-sm-2 col-sm-offset-2">周日：</div>
                   <div class="col-sm-2">
		                 <input id="starttime6" value="${timeEdit.list_sun.starttime}" name="courseExcTimeList[6].starttime" class="form-control startDate"
		                onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',maxDate:'#F{$dp.$D(\'endtime6\')}'})"
							 type="text" placeholder="请选择时间">
					 </div>
					<input type="hidden" name="courseExcTimeList[6].week" value="1">

             		   <div class="col-sm-1">至</div>

             		 <div class="col-sm-2">
                			<input id="endtime6" value="${timeEdit.list_sun.endtime}"  name="courseExcTimeList[6].endtime" class="form-control endDate" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm',minDate:'#F{$dp.$D(\'starttime6\')}'})"
                			 type="text" placeholder="请选择时间">
                 </div>
            </div>
        </div>



        <div class="dfg">
            <!-- <a class="btn_next">提交</a> -->
            <input type="submit" class="btn_next">
            <a class="btn_quit" href="<%=request.getContextPath()%>/user/course/courseExcTimePage?courseId=${courseId}">取消</a>
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
<script src="<%=request.getContextPath()%>/assets/js/course/schedule/exc/edit_courseexc_time.js"></script>