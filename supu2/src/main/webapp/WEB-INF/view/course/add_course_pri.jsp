<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增私教课</title>
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
		.single{
			display: none;
		}
        td{
            padding:5px;
        }
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">新增私教课</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>私教课基本信息</span>
                </div>

			 <form id="form" class="form-horizontal">

			 <input type="hidden" name="type" value="0">
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                       	课程类型
                    </label>
                    <div class="col-sm-5">
                        <a class="btn"  style="color: #666">私教课</a>
                        <a id="a_course_group" class="btn" style="color: #4CA8EB">切换为团课</a>
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                	         	   课程健身需求
                    </label>
                    <div class="col-sm-5 contentShow">
                    	<c:forEach items="${courseFitDemand}" var="item" varStatus="status">

  									  <label><input name="coursePriCoach.fitdemand" type="radio" <c:if test="${status.index==0}">checked="checked" </c:if>
  									   value="${item.basicvalue}" />${item.title}</label>
                    	</c:forEach>
                        <!-- <label><input name="course" type="radio" value="" />增肌</label>

						<label><input name="course" type="radio" value="" />体验课</label> -->
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                       	是否为体验课
                    </label>
                    <div class="col-sm-5">
                    	<input type="radio" id="isexperience" name="coursePriCoach.isexperience" value="0" checked/>非体验课
                    	<input type="radio" id="isexperience" name="coursePriCoach.isexperience" value="1"/>体验课
                       <!--  <a class="btn"  style="color: #666">私教课</a>
                        <a id="a_course_group" class="btn" style="color: #4CA8EB">切换为团课</a> -->
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                       	课程名称
                    </label>
                    <div class="col-sm-5">
                    	 <input type="text" name="coursePriCoach.coursename" class="form-control" placeholder="输入课程名称">
                    </div>
                    <div class="col-sm-2 contentShow">
                    	输入1~15个字
                    </div>

                </div>


				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	<span>*</span>
                       	课程金额
                    </label>
                    <div class="col-sm-5">
                    	<input type="number" name="coursePriCoach.courseamount" class="form-control" placeholder="输入课程金额">
                    </div>
                    <div class="col-sm-2 contentShow">
                    	元 / 课时
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                      	 起售课时
                    </label>
                    <div class="col-sm-5">
                        <input type="number" name="coursePriCoach.totalhours" class="form-control" placeholder="输入课时">
                    </div>
                    <div class="col-sm-2 contentShow">
                    	课时
                    </div>
               	</div>
                 <div class="form-group">
                     <label class="col-sm-1 control-label">
                         <span>*</span>
                         课程结束时间
                     </label>
                     <div class="col-sm-5">
                         <input type="text" name="coursePriCoach.courseEndTimeStr" class="form-control"
                                placeholder="选择月份" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
                     </div>
                     <div class="col-sm-2 contentShow">
                     </div>
                 </div>


               			<div class="form-group">
                    <label class="col-sm-1 control-label">
                      <span>*</span> 	课程图片
                    </label>
                    <div class="col-sm-8">
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
                    		<p>1.图片尺寸为720px*288px，大小不超过500K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    	 <input type="hidden" name="coursePriCoach.courseimg" id="mainfigure">
                    	</div>

                    </div>


                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<span>*</span>
                      	课程详情
                    </label>
                    <div class="col-sm-5">
						<input type="text" name="coursePriCoach.coursetitle" class="form-control" placeholder="请输入标题">
                    </div>
               </div>

               <div class="form-group">
                    <label class="col-sm-1 control-label">
                    	<!-- <span>*</span> -->

                    </label>
                    <div class="col-sm-8">
                    <div class="tr-main">
                        <textarea name="coursePriCoach.coursedetail" id="pcservicedetail"  style="width:700px;height:300px;"></textarea>
                    </div>
                </div>
               </div>

               <div class="form-group" id="div_choseStores">
                    <label class="col-sm-1 control-label">
                       	适用门店
                    </label>
                     <div class="col-sm-6 cleandiv" id="div_servicearea">
                    	  <a class="btn" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a>
                    </div>
                </div>

				<div class="form-group" id="div_choseCoachs">
                    <label class="col-sm-1 control-label">
                       	课程教练
                    </label>
                     <div class="col-sm-6 cleancoach" id="div_servicearea">
                    	  <a class="btn" data-toggle="modal" data-target="#choose_coachs" id="jiaolianchoose">选择教练</a>
                    </div>
                </div>



        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/course/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
                    <input class="btn" type="submit" value="提交">
                </div>
        </div>
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
	                    					    	  	 <label><input name="coursePriCoach.stores"  class="stores" type="checkbox" value="${store.id}" data-name="${store.storename }"/>${store.storename }</label>
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


   <!--教练选择框 -->
    <div class="modal fade" id="choose_coachs" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close coachsure" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        教练选择&nbsp;&nbsp;<span></span>
                    </h4>
                </div>
                <div class="modal-body" style="overflow-y:auto; overflow-x:auto; width:90%; height:400px;margin-left: 5%;">
                    <div class="province">
                        <table>
						<c:forEach items="${coach}" var="items">
                            <tr>
                                <td><input type="checkbox" name="coursePriCoach.coachs"  class="coachs" value="${items.id }" data-name="${items.coachname }">${items.coachname}</td>
                                <td><input type="text" name="coursePriCoach.price" class="form-control" placeholder="价格/课时"/></td>
                                <td><input type="text" name="coursePriCoach.orderNum" class="form-control" placeholder="排序"/></td>
                            </tr>
                        </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
					<button type="button" class="btn btn-default coachsure" >确定</button>
                    <button type="button" id="cancelBtn" data-dismiss="modal"></button>
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/course/listPage">返回课程列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/course/addPage?type=0">继续添加</a>
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
                        <h4 class="modal-title release-success">
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

<!--
		提示消息框
        <div class="modal fade" id="message" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            <i class="iconfont">&#xe644;</i>
                        </button>
                        <h4 class="modal-title release-failure">
                           <i class="iconfont">&#xe6bf;</i>
                          	<span id="span_msg"></span>
                        </h4>
                    </div>
                    <div class="modal-body">
                        <a class="btn btn-default" href="javascript:void(0)">取消</a>
                        <a class="btn btn-success" href="javascript:void(0)">返回修改</a>
                    </div>
                    <div class="modal-footer">

					<button class="btn btn-success" href="javascript:void(0)">确定</button>
                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        button type="button" class="btn btn-success">
                            提交更改
                        </button>
                    </div>
                </div>
            </div>
        </div> -->

</body>


<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/course/add_course_pri.js"></script>
<script src="<%=request.getContextPath()%>/assets/layer/layer.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script>
	    var editor1;

		KindEditor.ready(function(K) {
			 editor1 = K.create('textarea[name="coursePriCoach.coursedetail"]', {
				cssPath : '<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.css',
				uploadJson : '<%=request.getContextPath()%>/assets/js/kindeditor/jsp/upload_json.jsp',//标识处理图片的文件
				fileManagerJson : '<%=request.getContextPath()%>/assets/js/kindeditor/jsp/file_manager_json.jsp',
				allowImageUpload:true,//允许上传图片
				allowFileManager : true,//允许上传文件和图片
			    afterCreate : function() {
		            this.sync();
		        },
		        afterBlur:function(){
		            this.sync();
		        }
			});

			prettyPrint();
		});
</script>
</html>
