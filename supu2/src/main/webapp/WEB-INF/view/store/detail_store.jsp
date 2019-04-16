<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>门店详情</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
    <link rel="stylesheet" href="../../assets/css/backstagetwo.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css" />
   <%--  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/js/uploadify/uploadify.css" />
 --%>
    <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/css.css"/>
	<style>
		.contentShow{
			padding-top: 7px;
		}
		.edit>input{
			margin-right: 5px;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">门店详情</a>
                </li>
            </ul>
        </div>
				<div class="pull">
					<div class="pull-right">
                       <button class="btn btn-sm btn-success" type="button" id="opendoor" >开业</button>

                       <button class="btn btn-sm btn-success" type="button" id="stopdoor" >暂停</button>

                       <button class="btn btn-sm btn-success" type="button" id="closedoor" >闭馆</button>

                        <a class="edit" href="<%=request.getContextPath() %>/user/store/editPage?id=${store.id }">
                            <input class="btn btn-sm btn-success" type="button" id="addStore" value="编辑">
                        </a>
					</div>
				</div>
			<input type="hidden" name="id" value="${store.id}" id="id_state">
            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>门店基本信息</span>
                </div>


			  <form id="form" class="form-horizontal" action="<%=request.getContextPath()%>/user/store/addSave" method="post">


				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	门店名称 :
                    </label>
                    <div class="col-sm-5 contentShow">
                        ${store.storename}
                    </div>
                </div>


				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	门店状态 :
                    </label>
                    <div class="col-sm-5 contentShow">
                        <c:forEach items="${basicdataChecked}" var="item" varStatus="status">
							<c:if test="${item.checked }">${item.title }</c:if>
						</c:forEach>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	门店地址 :
                    </label>
                    <div class="col-sm-5 contentShow">
                        ${store.address}
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	门店图片 :
                    </label>
                    <div class="col-sm-5 contentShow">
                        <img src="${store.storeimg}">
                    </div>
                </div>


        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/store/listPage">返回</a>
        </div>

		</form>

         </div>

        </div>

</body>


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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/store/listPage">返回门店列表</a>
                       <%--  <a class="btn btn-success" href="<%=request.getContextPath() %>/user/store/addPage">关闭</a> --%>
                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                   <!--      <button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
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
                          	  操作失败！
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!-- <a class="btn btn-default" href="javascript:void(0)">取消</a>
                        <a class="btn btn-success" href="javascript:void(0)">返回修改</a> -->
                    </div>
                    <div class="modal-footer">
                    	<!-- <button class="btn btn-default" href="javascript:void(0)">取消</button>
                        <button class="btn btn-success" href="javascript:void(0)">重新发布</button> -->
                         <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <!-- button type="button" class="btn btn-success">
                            提交更改
                        </button> -->
                    </div>
                </div>
            </div>
        </div>

<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/store/detail_store.js"></script>

</html>