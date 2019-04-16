<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会员卡详情</title>
    <link rel="stylesheet" href="../../assets/css/common.css" />
    <script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.js"></script>

    <style>
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
                <a href="javascript:void(0)">会员卡</a>
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
                   	 会员卡名称
                </label>
                <div class="col-sm-5 contentShow">
                	<input type="hidden" name="id" value="${memberCard.id}">
                    ${memberCard.membername}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
                                                        会员卡促销说明
                </label>
                <div class="col-sm-5 contentShow">
                    ${memberCard.proinfo}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-1 control-label">
                                                         会员卡类型
                </label>
                <div class="col-sm-5 contentShow">
                    <c:forEach items="${memberCardType}" var="item" varStatus="status">
                    	<c:if test="${item.checked}">
                    		${item.title}
                    	</c:if>
                 	</c:forEach>

                    <!-- <a class="btn btn-success" data-toggle="modal" data-target="#addCardType" id="addcardType">+</a> -->
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                   	 会员卡时长
                </label>
                <div class="col-sm-5 contentShow">
                      <c:forEach items="${memberCardTimeLong}" var="item" varStatus="status">
                        <c:if test="${item.checked}">
                    		${item.title}
                    	</c:if>
                 	</c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                   	 金额
                </label>
                <div class="col-sm-5 contentShow">
                    ${memberCard.amountmoney}
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                                                           是否启用
                </label>
                <div class="col-sm-5">
                    <div class="onoffswitch">
                    	<c:choose>
                    		<c:when test="${memberCard.isuse==1 }">
								是
                    		</c:when>
                    		<c:otherwise>
								否
                    		</c:otherwise>
                    	</c:choose>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                   	 会员卡图片
                </label>
                <div class="col-sm-5">
                    <img src="${memberCard.mcardimg}" style="width: 265px;height: 209px">
                    <!-- <input type="file"> -->
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                                                               适用门店选择
                </label>
                <div class="col-sm-5">
                         <c:forEach items="${area}" var="province" >
                    			 <c:forEach items="${province.cityList}" var="city">
                    					<c:forEach items="${city.regionList}" var="region">
	                    					     <c:forEach items="${region.storeList}" var="store">
	                    					    	  	<c:if test="${store.checked}">${store.storename }&nbsp;&nbsp;</c:if>
	                    					    </c:forEach>
                    					</c:forEach>
                    			</c:forEach>
                    	</c:forEach>
                 <!--   <a class="btn btn-success" data-toggle="modal" data-target="#choose_stores">选择门店</a> -->
              <!--       <button choose_storestype="button" class="btn btn-success">选择门店</button> -->
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-1 control-label">
                                                              会员权益
                </label>
                <div class="col-sm-5 contentShow">
                    <div class="tr-main">
                        ${memberCard.memberrights}
                    </div>
                </div>
            </div>
            <div class="form-group component">
                <div class="col-sm-8 col-sm-offset-1 center">
                    <a class="btn btn-success" href="<%=request.getContextPath() %>/user/memberCard/listPage">返回</a>
                </div>
            </div>

     <!--弹出内容-->
    <!--门店选择框 -->
    <div class="modal fade" id="choose_stores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
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
	                    					    	  	 <label><input name="stores" class="stores"  disabled="disabled" type="checkbox" value="${store.id}"<c:if test="${store.checked}">checked="checked"</c:if>/>${store.storename }</label>
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
					<button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
        </form>
    </div>



</div>
</body>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=request.getContextPath()%>/assets/js/kindeditor/plugins/code/prettify.js"></script>


<script>
	var baseUrl = '${pageContext.request.contextPath}';
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