<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑教练</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
    <link rel="stylesheet" href="../../assets/css/backstagetwo.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css" />
  <%--  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/js/uploadify/uploadify.css" /> --%>

    <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/css.css"/>
	<style>
		.col-sm-1>span{
			color: #ff0000;
		}
		.contentShow{
			padding-top: 7px;
		}
		.special{
			width: 4%!important;
		}
        .import-tip{
            padding-left: 5px;
            margin-top: 10px;
            color: #999;
        }
        .modal-title>span{
            font-size: 18px;
        }
	</style>
	<style>
		.file {
    		position: relative;
    		display: inline-block;
    		background: #D0EEFF;
    		border: 1px solid #99D3F5;
    		border-radius: 4px;
    		padding: 5px 12px;
    		overflow: hidden;
    		color: #1E88C7;
    		text-decoration: none;
    		text-indent: 0;
    		line-height: 20px;
		}
		.file input {
    		position: absolute;
    		font-size: 100px;
    		right: 0;
    		top: 0;
    		opacity: 0;
		}
		.file:hover {
    		background: #AADFFD;
    		border-color: #78C3F3;
    		color: #004974;
    		text-decoration: none;
		}
	</style>


</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">编辑教练</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>教练基本信息</span>
                </div>

			<form id="form" class="form-horizontal">
			<input type="hidden" value="${coach.id }" name="id">
				<div class="form-group">
                	<label class="col-sm-1 control-label">
                		<span >*</span>身份证真反面照
                	</label>
                	<div class="col-sm-10" id="img">
						<div class="img-box">
							<section class="img-section" id="div_img">
								<div class="z_photo upimg-div clear" >
						           <c:if test="${coach.frontidnumber !=null && coach.frontidnumber !=''}">
									 <section class="up-section fl loading">
										 <span class="up-span"></span>
										 <img class="close-upimg" src="<%=request.getContextPath()%>/assets/js/uploadImg/img/a7.png">
										 <img id="1" class="coachimg" style="width:217px;height:125px" src="${coach.frontidnumber}">
										 <p class="img-name-p">下载.jpg</p>
										 <input id="taglocation" name="taglocation" value="" type="hidden">
										 <input id="tags" name="tags" value="" type="hidden">
									 </section>
									</c:if>
									  <c:if test="${coach.reverseidnumber !=null && coach.reverseidnumber !=''}">
									 <section class="up-section fl loading">
										 <span class="up-span"></span>
										 <img class="close-upimg" src="<%=request.getContextPath()%>/assets/js/uploadImg/img/a7.png">
										 <img id="2" class="coachimg" style="width:217px;height:125px" src="${coach.reverseidnumber}">
										 <p class="img-name-p">下载.jpg</p>
										 <input id="taglocation" name="taglocation" value="" type="hidden">
										 <input id="tags" name="tags" value="" type="hidden">
									 </section>
									</c:if>

								 	 <section class="z_file fl">
						               	 	<div id="div_upload"
						               	 	<c:if test="${coachImgCount>=2}">
						               	 	style="display:none"</c:if>>
						               	 	<img src="<%=request.getContextPath()%>/assets/js/uploadImg/img/a11.png" class="add-img">
						               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp"  />
						               	 	</div>
						             </section>
						         </div>
							 </section>
						</div>
						<aside class="mask works-mask">
							<div class="mask-content">
								<p class="del-p">您确定要删除作品图片吗？</p>
								<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
							</div>
						</aside>
					<!-- 	<div class="tip">
                    		<p>1.图片尺寸为580*335，大小不超过100K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    	</div> -->
                	</div>
                 </div>
				<input type="hidden" name="frontidnumber" value="${coach.frontidnumber}" id="mainfigure1">
	 			<input type="hidden" name="reverseidnumber" value="${coach.reverseidnumber}" id="mainfigure2">


				<div class="form-group">
					<label class="col-sm-1 control-label">
						资质证书
					</label>
					<div class="col-sm-5">
						<button class="btn btn_add" type="button" >&nbsp;+&nbsp;</button>
					</div>
				</div>
				<div id="div_append_certificate">
				      <c:forEach items="${coachCertificate}" var="item" varStatus="status">

					<div class="form-group div_cetificate">
						<div class="col-sm-3 col-sm-offset-1">
							<input type="text" class="form-control" value="${item.name }" placeholder="请输入证书名称" name="coachCertificate[${status.index }].name" >
						</div>
						<div class="col-sm-1">
							<c:choose>
							   <c:when test="${item.certificateimg==null  || item.certificateimg==''}">
							  		 <a href="javascript:;" class="file">上传证书
			    						<input type="file"  id="file${status.index }" onchange="previewImage(this)">
									</a>
							   </c:when>
							   <c:otherwise>
							 	  <a class="btn btn-default checkImg" data-toggle="modal" >查看图片</a>
							   </c:otherwise>
							</c:choose>
							<input type="hidden" class="hidden" value="${item.certificateimg }" id="certificatefile${status.index }" name="coachCertificate[${status.index }].certificateimg" >
						</div>
						<div class="col-sm-1 special">
							<button class="btn btn_remove" type="button" >&nbsp;-&nbsp;</button>
						</div>
				<!-- 		<div class="col-sm-1">
							<a class="btn btn-default checkImg" data-toggle="modal" >查看图片</a>
						</div> -->
					</div>
                 	</c:forEach>

				</div>

        </div>

        <div class="footer-button">
        		<a class="btn chooseone" style="background-color: #ff0000;color: #fff;margin-right: 20px;border: none;"
        								 href="<%=request.getContextPath()%>/user/coach/editPage?id=${coach.id }">上一步</a>
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/coach/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
                </div>
        </div>

        </form>
    </div>

        <!-- 模态框（Modal）“查看图片”弹出框 -->
        <div class="modal fade" id="lookover" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        	<i class="iconfont">&#xe644;</i>
                    	</button>
                    </div>
                    <div class="modal-body">
							<img id="seeImg" src="" style="width:430px;height:200px" >
                    </div>
                    <div class="modal-footer">
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
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-success" id="myModalLabel">
                           <i class="iconfont">&#xe6bf;</i>
                           	编辑成功！
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/coach/listPage">返回教练列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/coach/editPage?id=${coach.id}">继续编辑</a>
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
        <div class="modal fade" id="failure" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe643;</i>
                          	  编辑失败！
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

<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin2.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/card.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<%-- <script src="<%=request.getContextPath()%>/assets/js/uploadify/jquery.uploadify.min.js"></script> --%>
<script src="<%=request.getContextPath()%>/assets/js/coach/edit_next_coach.js"></script>


</html>
