<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增活动</title>
    <link rel="stylesheet" href="../assets/css/common.css"/>
    <link rel="stylesheet" href="../assets/css/backstagetwo.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/themes/default/default.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css"/>
    <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/css.css"/>
    <style>
        .col-sm-1 > span {
            color: #ff0000;
        }
        .area-right :last-child.aR-info {
            padding-bottom: 0px;
            border-bottom: none;
        }


        .province :last-child.city {
            border-bottom: none;
        }


        .region-info label {
            margin-right: 10px;
        }

        .place label.error {
            position: absolute;
            top: 7px;
            right: -30%;
        }
    </style>
</head>
<body>
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">新增活动</a>
            </li>
        </ul>
    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>活动基本信息</span>
        </div>
        <form id="form" class="form-horizontal" action="<%=request.getContextPath()%>/activity/add"
              method="post">
            <div class="form-group">
                <label class="col-sm-1 control-label">
                    <span>*</span>
                    标题
                </label>
                <div class="col-sm-5 ">
                    <input class="form-control" type="text" name="title" placeholder="请输入标题" required="true"
                           maxlength="100">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
                    <span>*</span>
                    介绍
                </label>
                <div class="col-sm-5">
                    <input type="text" name="introduce" class="form-control" placeholder="请输入介绍" required="true"
                           maxlength="100">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
                    <span>*</span>
                    联系方式
                </label>
                <div class="col-sm-5">
                    <input type="tel" name="contact" class="form-control" placeholder="请输入联系方式" maxlength="11" required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
                    活动状态
                </label>
                <div class="col-sm-5">
                    <select id="status" class="form-control" name="status" >
                        <option value="1">上架</option>
                        <option value="2">下架</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                    <span>*</span>
                    有效时间
                </label>
                <div class="col-sm-5" style="width: 200px;">
                    <input type="text" id="startDate" class="form-control" name="startDate"
                           placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:00'});"
                           onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd HH:mm:00',lang:'zh-cn'})">
                </div>
                <div class="col-sm-1" style="width: 30px;text-align: center;">
                至
                </div>
                <div class="col-sm-5" style="width: 200px;">
                    <input type="text" id="endDate" class="form-control" name="endDate"
                           placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:00'});"
                           onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd HH:mm:00',lang:'zh-cn'})">
                </div>
            </div>

    <div class="footer-button">
        <a class="btn chooseone" href="<%=request.getContextPath()%>/activity/listPage">取消</a>
        <div class="submit">
            <input class="btn" type="submit" value="提交">
        </div>
    </div>

    </form>
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
                    添加成功！
                </h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <a class="btn btn-info" href="<%=request.getContextPath() %>/activity/listPage">返回活动列表</a>
                <a class="btn btn-success" href="<%=request.getContextPath() %>/activity/toAdd">继续添加</a>
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

</body>


<script>
    var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script
        src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/activity/add.js"></script>


</html>
