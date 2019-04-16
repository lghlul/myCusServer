<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<%@ page trimDirectiveWhitespaces="true" %>

<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/assets/css/common.css">
    <style>
        .menu-panel {
            padding: 30px 0;
        }

        .btn-group > .btn, .btn-group-vertical > .btn {
            padding: 5px;
        }

        .divselect select {
            width: 150px;
        }

        .pull-left > .form-control {
            width: 150px;
        }

        .form-control {
            margin-right: 0px !important;
        }
    </style>
</head>

<body>
<input type="hidden" value="${activityId}" name="activityId" id="activityId">
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">活动管理</a>
            </li>
        </ul>
    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>活动管理</span>
        </div>

        <div class="pull">
            <div class="pull-left">
                <input type="text" class="form-control" name="" id="mobilePhone" placeholder="请输入手机"/>
                <div class="divselect">
                    <select id="status">
                        <option value="0">-选择状态-</option>
                        <option value="1">待领</option>
                        <option value="2">已领</option>
                    </select>
                    <i class="iconfont type1">&#xe772;</i>
                </div>
                <button class="btn btn-app btn-success" type="button" id="searchRecord">查询</button>
                <button class="btn btn-default" type="button" id="resetRecord">重置</button>
            </div>
        </div>
        <div class="tab-pane">
            <table class="table table-bordered" id="activitys">
            </table>
        </div>

        <!--弹出内容-->
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
                            领取成功！
                        </h4>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/activity/recordListPge?activityId=${activityId}">返回列表</a>
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
                            <span id="sp_msg"></span>
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
    </div>
</div>
</body>
</html>
<script
        src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="../assets/js/My97DatePicker/WdatePicker.js"></script>
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
<script
        src="<%=request.getContextPath()%>/assets/js/activity/recordList.js"></script>
<script>

    function updateRecord(id){
        $.ajax({
            type:'POST',
            url:"updateRecord",
            data:{"id":id,"status":2},
            success:function(data){
                if(data.resultCode==200){
                    $('#success').modal('show');
                }else{
                    $('#failure').modal('show');
                }
            },
            error:function(data){
                $('#failure').modal('show');
            }
        });
    }
</script>