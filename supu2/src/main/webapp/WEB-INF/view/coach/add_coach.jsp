<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增教练</title>
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
	.col-sm-1>span{
			color: #ff0000;
		}
		.contentShow{
			padding-top: 7px;
		}
		.special{
			width: 5%!important;
		}
        .modal-title>span{
            font-size: 18px;
        }
        .province{
            padding: 10px;
            border-bottom: 3px dashed #e5e5e5;
        }
        .province-info{
            border-bottom: 2px dashed #ccc;
            padding-bottom: 5px;
        }
        .area-left{
            display: inline-block;
            width: 15%;
            float: left;
            margin-top: 10px;
            margin-left: 10px;
        }
        .area-right{
            display: inline-block;
            width: 78%;
            float: right;
        }
        .aR-info{
            padding: 10px 0;
            border-bottom: 2px dashed #ccc;
        }
        .region{
            margin-bottom: 5px;
        }
        .area-right :last-child.aR-info{
            padding-bottom: 0px;
            border-bottom: none;
        }
        .city{
            border-bottom: 2px dashed #ccc;
            overflow: hidden;
        }
        .province :last-child.city{
            border-bottom: none;
        }
        .alDifferent{
            top: -25px;
        }
        .region-info label{
            margin-right: 10px;
        }
        .place{
        	position: relative;
        }
        .place label.error{
        	position: absolute;
        	top: 7px;
        	right: -30%;
        }
	</style>
	<style>
		.file {
			width: 82px;
			height: 34px;
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
	<style type="text/css">
		.upimg-div .up-section {
    		width: 150px;
    		height: 200px;
		}
		.img-box .upimg-div .z_file {
    		width: 150px;
    		height: 200px;
		}
		.z_file .add-img {
    		display: block;
    		width: 150px;
    		height: 200px;
		}
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">新增教练</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>教练基本信息</span>
                </div>

			 <form id="form" class="form-horizontal" method="post" action="<%=request.getContextPath()%>/user/coach/addSave">
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	<span >*</span>
                       	教练名称
                    </label>
                    <div class="col-sm-5">
                        <input type="text" name="coachname" class="form-control" placeholder="请输入教练名称"  >
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	教练昵称
                    </label>
                    <div class="col-sm-5">
                        <input type="text" name="nickname" class="form-control" placeholder="请输入教练昵称"  maxlength="100">
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                     <span >*</span>  	性别
                    </label>
                    <div class="col-sm-5 contentShow">
                        <input type="radio" name="sex" checked="checked" value="1" >男
                         <input type="radio" name="sex" value="0" >女
                    </div>
                </div>

				<div class="form-group">
					<label class="col-sm-1 control-label">
                       	生日
                    </label>

							<div class="contractDay-menu">
								<div class="contractBeginDay time">

									<input type="text" name="birthday" class="form-control"
									 placeholder="请输入生日日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
								<!-- <i class="icon iconfont data type1"></i> -->
								</div>

							<%-- 	<div class="contractEndDay time">
									<span>合同期止</span><input type="text" placeholder="请输入合同结束时间" id="txtEndDay"
										name="contractInfo.enddate" value="<fmt:formatDate value="${contractInfo.contractInfo.enddate}" pattern="yyyy-MM-dd"/>" id="txtEndDay"
										onclick="WdatePicker({dateFmt:'yyyy-MM-dd' ,minDate:'#F{$dp.$D(\'txtBeginDay\')}'});" />
                                 <i class="icon iconfont data type1"></i>
							</div> --%>
							</div>

				</div>
				<div class="form-group">
			        <label class="col-sm-1 control-label">
			                                        邮箱
			        </label>
			        <div class="col-sm-5">
			        	<input type="email" name="email" class="form-control" placeholder="请输入邮箱"  maxlength="50">
			        </div>
			    </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	手机号码
                    </label>
                     <div class="col-sm-5">
                        <input type="text" name="phonenumber" class="form-control" placeholder="请输入电话号码" maxlength="11">
                    </div>
               </div>
			    <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	身份证号
                    </label>
                     <div class="col-sm-5">
                        <input type="text" name="idnumber" class="form-control" placeholder="请输入身份证号" maxlength="20">
                    </div>
                </div>

                 <div class="form-group">
                    <label class="col-sm-1 control-label">
      					<span >*</span>所在地
                    </label>
                     <div class="col-sm-5">
                         <!-- input type="text" name="location" class="form-control" placeholder="请输入所在地" > -->


                         <select name="location" id="location" class="form-control">

	                           <c:forEach items="${city}" var="item" varStatus="status">
	                           		 <c:choose>
		                           		<c:when  test="${status.index==0}">
			 								<option value="${item.zonecode}" selected="selected"> ${item.name}</option>
					       				</c:when>
						       			<c:otherwise>
						       				 <option value="${item.zonecode}"> ${item.name}</option>
						       			 </c:otherwise>
					       			 </c:choose>

	                       		</c:forEach>
                         </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">
                      <span >*</span> 	服务区域
                    </label>
                     <div class="col-sm-5 contentShow place" id="div_servicearea">
                    	 <c:forEach items="${region}" var="item" varStatus="status">
                        	<input type="checkbox" name="servicearea" value="${item.zonecode}">${item.name }
                        </c:forEach>
                    </div>
                </div>


				<div class="form-group" id="div_choseStores">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	门店选择
                    </label>
                     <div class="col-sm-6 cleandiv" id="div_servicearea">
                    	  <a class="btn btn-success" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a>
                    </div>
                </div>
                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	毕业院校
                    </label>
                     <div class="col-sm-5">
                        	 <input type="text" name="graduatecolleges" maxlength="100" class="form-control" placeholder="请输入毕业院校" >
                    </div>
                </div>
  				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	曾经就职
                    </label>
                     <div class="col-sm-5">
                        	 <input type="text" name="everworked" maxlength="100" class="form-control" placeholder="请输入曾经就职" >
                    </div>
                </div>
    			<div class="form-group">
                    <label class="col-sm-1 control-label">
                 		<span >*</span>      教龄
                    </label>
                     <div class="col-sm-5">
                        	<input type="number" name="teachyears"  class="form-control" placeholder="请输入教龄" >
                    </div>
                    <div class="col-sm-1 contentShow">
                    	年
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                      	 教练等级
                    </label>
                    	<input type="hidden" name="coachlevel" id="chooseCoachlevel" value="1">
                     <div class="col-sm-5 menu">
                     	<button type="button" class="btn btn-default btn-inverse coachlevel" data-id="1">P1认证</button>
                     	<button type="button" class="btn btn-default coachlevel" data-id="2">P2高级</button>
                     	<button type="button" class="btn btn-default coachlevel" data-id="3">P3资深</button>
                     	<button type="button" class="btn btn-default coachlevel" data-id="4">P4专家</button>
                    </div>
               	</div>
                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	擅长
                    </label>
                     <div class="col-sm-5 contentShow">
                        <textarea name="goodat" id="tabDetail" class="form-control"></textarea>
                    </div>
                </div>

                <div class="form-group">
					<label class="col-sm-1 control-label">
					<span >*</span>
						头像
					</label>
					<div class="col-sm-6">
						<div class="col-sm-2">
							<img id="headImg" src="" style="width:100px;height:100px" >
						</div>

						<div class="col-sm-2">
							  		 <a href="javascript:;" class="file">上传头像
			    						<input type="file"  id="file_head" onchange="previewImage(this)">
									</a>

							<input type="hidden" class="hidden"  id="hidden_headImg" name="headimg" >
						</div>

						<div class="col-sm-12">
							<div class="tip">
                    			<p>1.图片尺寸为100px*100px，大小不超过500K，格式支持JPG、PNG、GIF</p>
                    			<p>2.图片需要清晰</p>
                    		</div>
						</div>

					</div>

				</div>
   				<div class="form-group" >
                	<label class="col-sm-1 control-label">
                	<span >*</span>
                		照片
                	</label>
                	<div class="col-sm-10" id="img">
						<div class="img-box">
							<section class="img-section" id="div_img">

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
                    		<p>1.图片尺寸为600px*800px，大小不超过500K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    	</div>
 					<input type="hidden" name="coachimg1" value="" id="mainfigure1">
 					<input type="hidden" name="coachimg2" value="" id="mainfigure2">
 					<input type="hidden" name="coachimg3" value="" id="mainfigure3">
 					<input type="hidden" name="coachimg4" value="" id="mainfigure4">
 					<input type="hidden" name="coachimg5" value="" id="mainfigure5">
                	</div>
                </div>

			<%-- 	<div class="form-group div_certificate" id="div_certificate" >
					<label class="col-sm-1 control-label">
						资格证书
					</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="name[0]" placeholder="输入证书名称" >
					</div>

					<div class="col-sm-1">
						<!-- <button type="button" class="btn">上传证书</button> -->
						<form enctype="multipart/form-data" id="form0" method="post" action="<%=request.getContextPath()%>/user/upload/uploadMainFigure">
								<input type="file"  name="file" class="uploadFile" >
						</form>

						<input type="hidden" name="certificateimg[0]">

					</div>

					<div class="col-sm-1 special">
						<button type="button" class="btn add_div">&nbsp;&nbsp;+&nbsp;&nbsp;</button>
					</div>
				</div> --%>


				<!-- div class="form-group">
					<div class="col-sm-4 col-sm-offset-1">
						<input type="text" class="form-control" placeholder="输入证书名称">
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn">上传证书</button>
					</div>
					<div class="col-sm-1 special">
						<button type="button" class="btn">&nbsp;&nbsp;-&nbsp;&nbsp;</button>
					</div>
					<div class="col-sm-1 special">
						<button type="button" class="btn">&nbsp;&nbsp;+&nbsp;&nbsp;</button>
					</div>
				</div> -->

				<div class="form-group">
					<label class="col-sm-1 control-label">
						<span>*</span>  是否为人气王
					</label>
					<div class="col-sm-5 contentShow">
						<label><input name="ispopular" type="radio" checked="checked" value="0" />否</label>
						<label><input name="ispopular" type="radio" value="1" />是 </label>
					</div>
				</div>
        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/coach/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="下一步">
                </div>
        </div>


		<!-- 模态框（Modal）“查看图片”弹出框 -->
        <!-- <div class="modal fade" id="lookover" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">

                    </div>
                    <div class="modal-body">
							<img id="seeImg" src="" style="width:430px;height:200px" >
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div> -->



		    <!--门店选择框 -->
    <div class="modal fade" id="choose_stores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close surechoose" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        门店选择&nbsp;&nbsp;<span></span>
                    </h4>
                </div>
                <div class="modal-body">
                    <div class="province">
                    	<c:forEach items="${area}" var="province" >
                    			<div class="province-info">${province.name}</div>

                    			 <c:forEach items="${province.cityList}" var="city">
                    				<div class="city">
                    					<div class="area-left">${city.name}</div>

                    					<c:forEach items="${city.regionList}" var="region">
                    					  <div class="area-right">

	                    					   <div class="aR-info">
	                    					      <div class="region">${region.name}</div>
	                    					      <div class="region-info">
	                    					      		<c:forEach items="${region.storeList}" var="store">
	                    					    	  	 <label><input name="stores" class="stores" type="checkbox" value="${store.id}" data-name="${store.storename }"/>${store.storename }</label>
	                    					    	   </c:forEach>
	                    					      </div>
	                    					   </div>
                    					  </div>

                    					</c:forEach>
                    				</div>
                    			</c:forEach>

                    	</c:forEach>
                    </div>
                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
					<button type="button" class="btn btn-default surechoose" data-dismiss="modal">确定</button>
                </div>
            </div>
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
                           	发布成功！
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
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/coach/addPage">继续添加</a>
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
                          	  发布失败！
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/coach/listPage">返回教练列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/coach/addPage">继续添加</a>
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
                          	添加失败！
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


           <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="message" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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


<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery.form.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/cxselect/jquery.cxselect.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin5.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin2.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/card.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/coach/add_coach.js"></script>
<script>
$(function(){
    $(document).on('click','.menu .btn',function(){
    	if(!$(this).hasClass("btn-inverse")){
            $(this).addClass("btn-inverse").siblings().removeClass("btn-inverse");
        }
    });
});

</script>
</html>
