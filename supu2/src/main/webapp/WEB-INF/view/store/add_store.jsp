<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增门店</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
    <link rel="stylesheet" href="../../assets/css/backstagetwo.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css" />
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>
   <%--  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/js/uploadify/uploadify.css" />
 --%>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/css.css"/>
	<style>
		.col-sm-1>span{
			color: #ff0000;
		}
		.contentShow{
			padding-top: 7px;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">发布门店</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>门店基本信息</span>
                </div>

			<form id="form" class="form-horizontal" >
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	<span>*</span>门店名称
                    </label>
                    <div class="col-sm-3">
                        <input type="text" name="storename" class="form-control" placeholder="请输入门店名称"  maxlength="12">
                    </div>
                    <div class="col-sm-2 contentShow">
                    	支持输入12个汉字
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span>*</span>	门店状态
                    </label>
                    <div class="col-sm-5 menu">
                       <c:forEach items="${storeStatus}" var="item" varStatus="status">
                       <c:choose>
                      	 <c:when  test="${status.index=='0'}">
       						<button class="btn btn-default btn_storeStatus btn-inverse" type="button" data-id="${item.basicvalue}">${item.title} </button>
       						<input type="hidden" id="status" name="status" value="${item.basicvalue}">
       				    </c:when>
	       				<c:otherwise>
	       				    <button class="btn btn-default" type="button" data-id="${item.basicvalue}">${item.title} </button>
	       				 </c:otherwise>
	       				 </c:choose>

                    </c:forEach>

                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                      <span>*</span> 	门店图片
                    </label>
                    <div class="col-sm-5">
                        <!-- <div class="pr-upload"> -->
                            <!-- img id="showImg" src="<%=request.getContextPath() %>/assets/images/sc.png" style="width:265px;height:209px"/>
							<input type="file" id="uploadify"> -->
                        <!-- </div> -->

						<div class="img-box">
							<section class=" img-section">

								<div class="z_photo upimg-div clear" >

						               	 <section class="z_file fl">
						               	 	<div id="div_upload">
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
						<div class="tip">
                    		<p>1.图片尺寸为461px*331px，大小不超过500K，格式支持JPG、PNG、GIF、GIF</p>
                    		<p>2.图片需要清晰</p>
                    	</div>

                    </div>
                    <input type="hidden" name="storeimg" id="mainfigure">

                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span>*</span>	门店地址
                    </label>
                    <div class="col-sm-11">
                        <div class="divselect" id="city_china_val">
                         <select id="select_province" class="province"  data-value="江苏省"  name="province" data-required="true">
	                           		   <!-- option value="">请选择</option> -->
	                     </select>

	                     <select id="select_city" class="city" data-value="南京市" name="city" data-required="true">
	                              	 <!-- option value="">请选择</option> -->
	                    </select>

	                      <select id="select_area" class="area" data-value="栖霞区" name="region" data-required="true">

	                     </select>
						 <input class="form-control" type="text" placeholder="请输入门店详细地址" name="address" maxlength="100" style="width:240px;display:inline-block">

                        <i class="icon iconfont icon-xiala1 regional1"></i>
                        <i class="icon iconfont icon-xiala1 regional2"></i>
                    	<i class="icon iconfont icon-xiala1 regional3"></i>
                       </div>
                    </div>
                </div>

        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/store/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
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
                           	新增成功！
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
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/store/addPage">继续添加</a>
                        <!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭 -->
                       <!--  </button> -->
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
                          	  发布失败！
                        </h4>
                    </div>
                    <div class="modal-body">
                        <!-- <a class="btn btn-default" href="javascript:void(0)">取消</a>
                        <a class="btn btn-success" href="javascript:void(0)">返回修改</a> -->
                    </div>
                    <div class="modal-footer">
                  <!--   	<button class="btn btn-default" href="javascript:void(0)">取消</button>
                        <button class="btn btn-success" href="javascript:void(0)">重新发布</button> -->
                         <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <!--<button type="button" class="btn btn-success">
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
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/store/add_store.js"></script>

<script>
    $(function(){
        $(".menu .btn").click(function(){
            if(!$(this).hasClass("btn-inverse")){
                $(this).addClass("btn-inverse").siblings().removeClass("btn-inverse");
            }
        });
    });
</script>

</html>