<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑会员卡</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
   <link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/common.css" type="text/css" rel="stylesheet"/>
	<link href="<%=request.getContextPath()%>/assets/js/uploadImg/css/index.css" type="text/css" rel="stylesheet"/>
    <style>
    	.col-sm-1>span{
			color: #ff0000;
		}
        .onoffswitch {
            position: relative; width: 90px;
            -webkit-user-select:none; -moz-user-select:none; -ms-user-select: none;
        }
        .onoffswitch-checkbox {
            display: none;
        }
        .onoffswitch-label {
            display: block; overflow: hidden; cursor: pointer;
            border: 2px solid #999999; border-radius: 20px;
        }
        .onoffswitch-inner {
            width: 200%; margin-left: -100%;
            -moz-transition: margin 0.3s ease-in 0s; -webkit-transition: margin 0.3s ease-in 0s;
            -o-transition: margin 0.3s ease-in 0s; transition: margin 0.3s ease-in 0s;
        }
        .onoffswitch-inner > div {
            float: left; width: 50%; height: 30px; padding: 0; line-height: 30px;
            font-size: 14px; color: white; font-family: Trebuchet, Arial, sans-serif; font-weight: bold;
            -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box;
        }
        .onoffswitch-inner .onoffswitch-active {
            padding-left: 10px;
            background-color: #ff0000; color: #FFFFFF;
        }
        .onoffswitch-inner .onoffswitch-inactive {
            padding-right: 10px;
            background-color: #EEEEEE; color: #999999;
            text-align: right;
        }
        .onoffswitch-switch {
            width: 18px; margin: 6px;
            background: #FFFFFF;
            border: 2px solid #999999; border-radius: 20px;
            position: absolute; top: 0; bottom: 0; right: 56px;
            -moz-transition: all 0.3s ease-in 0s; -webkit-transition: all 0.3s ease-in 0s;
            -o-transition: all 0.3s ease-in 0s; transition: all 0.3s ease-in 0s;
        }
        .onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-inner {
            margin-left: 0;
        }
        .onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-switch {
            right: 0px;
        }
        .import-tip{
            padding-left: 5px;
            margin-top: 10px;
            color: #999;
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
        .mDian{
            margin: 10% auto;
        }
    </style>
</head>
<body>
<div class="external">
    <div class="page-header">
        <ul class="breadcrumb">
            <li>
                <i class="iconfont">&#xe648;</i>
                <a href="javascript:void(0)">编辑会员卡</a>
            </li>
        </ul>
    </div>

    <div class="menu-panel">
        <div class="panel-header">
            <b></b>
            <span>会员卡信息</span>
        </div>

        <form class="form-horizontal" id="form">
            <div class="form-group">
                <label class="col-sm-1 control-label">
					<span>*</span>会员卡名称
                </label>
                <div class="col-sm-5">
                <input type="hidden" name="id" value="${memberCard.id}">
                    <input type="text" name="membername" value="${memberCard.membername}" maxlength="100" class="form-control" placeholder="请输入会员卡名称" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
                   	 会员卡促销说明
                </label>
                <div class="col-sm-5">
                    <input type="text" name="proinfo" value="${memberCard.proinfo}"  maxlength="200" class="form-control" placeholder="请输入会员卡说明" >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
					<span>*</span> 会员卡类型
                </label>
                <div class="col-sm-8">
                  <div style="display: inline-block">
                    <c:forEach items="${memberCardType}" var="item" varStatus="status">
                  		  <c:choose>
	                    	<c:when  test="${item.checked}">
	 								<button class="btn btn-default btn-success cardtype" type="button" data-id="${item.basicvalue}">${item.title} </button>
	 								<input type="hidden" value="${item.basicvalue}" id="txt_cardtype" name="cardtype">
			       			</c:when>
				       		<c:otherwise>
				       				   <button class="btn btn-default cardtype" type="button" data-id="${item.basicvalue}">${item.title} </button>
				       		 </c:otherwise>
	       				 </c:choose>

                 	</c:forEach>
				   </div>
                   <a class="btn btn-success" data-toggle="modal" data-target="#addCardType" id="addcardType">+</a>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
					<span>*</span>会员卡时长
                </label>
                <div class="col-sm-5 type">
                      <c:forEach items="${memberCardTimeLong}" var="item" varStatus="status">
                  		  <c:choose>
	                    	<c:when  test="${item.checked}">
	 								<button class="btn btn-default btn-inverse timelong" type="button" data-id="${item.basicvalue}">${item.title} </button>
	 								<input type="hidden" value="${item.basicvalue}" name="timelong" id="txt_timelong">
			       			</c:when>
				       		<c:otherwise>
				       				<button class="btn btn-default timelong" type="button" data-id="${item.basicvalue}">${item.title} </button>
				       		 </c:otherwise>
	       				 </c:choose>

                 	</c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
					<span>*</span>金额
                </label>
                <div class="col-sm-5">
                    <input type="number" name="amountmoney" value="${memberCard.amountmoney}"  class="form-control" placeholder="请输入金额" >
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
					<span>*</span> 启用
                </label>
                <div class="col-sm-5">
                    <div class="onoffswitch">
                        <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" <c:if test="${memberCard.isuse==1 }">checked</c:if>/>
                        <label class="onoffswitch-label" for="myonoffswitch">
                            <div class="onoffswitch-inner">

                                <div class="onoffswitch-active"  id="div_on">ON</div>
                                <div class="onoffswitch-inactive" id="div_off">OFF</div>
                            </div>
                            <div class="onoffswitch-switch"></div>
                        </label>

                        <input type="hidden" value="${memberCard.isuse}" name="isuse" id="isuse_edit">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
					<span>*</span>会员卡图片
                </label>
                <div class="col-sm-5">
                    <div class="img-box">
							<section class=" img-section">
								<div class="z_photo upimg-div clear" >
  								<c:if test="${memberCard.mcardimg!=null && memberCard.mcardimg!='' }">
						               	<a id="delImg"><img class="close-img" src="<%=request.getContextPath()%>/assets/js/uploadImg/img/a7.png"></a>
						               	</c:if>
						               	 <section class="z_file fl">
						               	 	<div id="div_upload">
						               	 	<img id="showImg" src="<c:choose>
						                		 <c:when test="${memberCard.mcardimg!=null && memberCard.mcardimg!=''}">
						                			 ${memberCard.mcardimg}
						                		 </c:when>
												  <c:otherwise>
												 		<%=request.getContextPath()%>/assets/js/uploadImg/img/a11.png
												  </c:otherwise>
						                		</c:choose>" style='width:217px;height:125px'
						               	 	class="add-img">
						               	 	<input type="file" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
											</div>
						               	 </section>
						         </div>
							 </section>
                </div>
                            			<div class="tip">
                    		<p>1.图片尺寸为461px*331px，大小不超过500K，格式支持JPG、PNG、GIF</p>
                    		<p>2.图片需要清晰</p>
                    	</div>
            </div>
  				<input type="hidden" value="${memberCard.mcardimg}" name="mcardimg" id="mainfigure">
  			</div>
            <div class="form-group" id="div_servicearea">
                <label class="col-sm-1 control-label">
                	<span>*</span>适用门店选择
                </label>
                <div class="col-sm-5" id="cleandiv">
                        <c:forEach items="${area}" var="province" >
                    			 <c:forEach items="${province.cityList}" var="city">
                    					<c:forEach items="${city.regionList}" var="region">
	                    					     <c:forEach items="${region.storeList}" var="store">
	                    					    	  	<c:if test="${store.checked}">${store.storename }&nbsp;&nbsp;</c:if>
	                    					    </c:forEach>
                    					</c:forEach>
                    			</c:forEach>
                    	</c:forEach>
                   <a class="btn btn-success" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a>
              <!--       <button choose_storestype="button" class="btn btn-success">选择门店</button> -->
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                	<span>*</span> 会员权益
                </label>
                <div class="col-sm-8">
                    <div class="tr-main">
                        <textarea name="memberrights" id="pcservicedetail"  style="width:700px;height:300px;">${memberCard.memberrights}</textarea>
                    </div>
                </div>
            </div>
            <div class="form-group component">
                <div class="col-sm-8 col-sm-offset-1 center">
                    <!-- <button class="btn btn-default" >保存</button> --><!-- data-toggle="modal" data-target="#success" -->
                    <input type="submit" class="btn btn-default">
                    <a class="btn btn-success" href="<%=request.getContextPath() %>/user/memberCard/listPage">取消</a>
                </div>
            </div>

     <!--弹出内容-->
    <!--门店选择框 -->
    <div class="modal fade" id="choose_stores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog mDian">
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
	                    					    	  	 <label><input name="stores" class="stores" type="checkbox" value="${store.id}"<c:if test="${store.checked}">checked="checked"</c:if> data-name="${store.storename }"/>${store.storename }</label>
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

    <div class="modal fade" id="addCardType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h4 class="modal-title">
                        新增会员卡类型
                    </h4>
                </div>
                <div class="modal-body">
                    <input type="text" class="form-control" maxlength="20" placeholder="请输入会员卡类型名称"   id="add_cardtype">
                    <div class="import-tip">输入1~20个字</div>
                </div>
                <div class="modal-footer">
                    <!--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <!--<button type="button" class="btn btn-success">提交更改</button>-->
                     <button type="button"  class="btn btn-success"  id="btn_cardtype_sub">确定</button>
                    <button type="button"  class="btn btn-default"   data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>

          <!-- 模态框（Modal）成功后的框！ -->
        <div class="modal fade" id="addcard_success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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

                    </div>
                    <div class="modal-footer">

   						 <a class="btn btn-info" href="<%=request.getContextPath() %>/user/store/listPage">返回门店列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/store/editPage?id=${memberCard.id}">继续编辑</a>
                   <!--     	<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

                        </button> -->

                    </div>
                </div>
            </div>
        </div>

<!--luxinhuan-->
          <!-- 模态框（Modal）失败后的框！ -->
        <div class="modal fade" id="addcard_failure" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                   <!--      <button type="button" class="btn btn-default" data-dismiss="modal">确定</button> -->
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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
        <div class="modal fade" id="all_success_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/memberCard/listPage">返回会员卡列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/memberCard/editPage?id=${memberCard.id}">继续编辑</a>
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
        <div class="modal fade" id="all_failure_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
</div>
</body>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script><script src="<%=request.getContextPath()%>/assets/js/membercard/edit_membercard.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>


<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>

<script>
/*     $(function(){
        $(document).on('click','.type .btn',function(){
        	if(!$(this).hasClass("btn-inverse")){
                $(this).addClass("btn-inverse").siblings().removeClass("btn-inverse");
            }

        });
    }); */
</script>

<script type="text/javascript">
    $(function(){
        // dom加载完毕
        var $m_btn = $('#modalBtn');
        var $modal = $('#myModal');
        $m_btn.on('click', function(){
            $modal.modal({backdrop: 'static'});
        });

//         测试 bootstrap 居中
        $modal.on('show.bs.modal', function(){
            var $this = $(this);
            var $modal_dialog = $this.find('.modal-dialog');
            // 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零
            $this.css('display', 'block');
            $modal_dialog.css({'margin-top': Math.max(0, ($(window).height() - $modal_dialog.height()) / 3) });
        });

    });
</script>


<script>
	    var editor1;

		KindEditor.ready(function(K) {
			 editor1 = K.create('textarea[name="memberrights"]', {
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