<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>会员详情</title>
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
	</style>
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">会员详情</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>会员基本信息</span>
                </div>

			<form id="form" class="form-horizontal" action="<%=request.getContextPath()%>/user/member/addSave" method="post">
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	会员类型
                    </label>
                     <div class="col-sm-5 contentShow">
                     	<c:if test="${member.membertype==1}">顾客</c:if>
						<c:if test="${member.membertype==2}">工作人员</c:if>
                    </div>
                 </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	会员名称
                    </label>
                    <div class="col-sm-5 contentShow">
                        ${member.membername }
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	电话号码
                    </label>
                     <div class="col-sm-5 contentShow">
                        ${member.phonenumber}
                    </div>
                 </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	身份证号
                    </label>
                     <div class="col-sm-5 contentShow">
                        ${member.idnumber}
                    </div>
                 </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                 			      持有会员卡
                    </label>
                    <div class="col-sm-5 contentShow">
                    <c:forEach items="${memberCard}" var="item" varStatus="status">
                    		<c:if test="${item.id == mCardId}">
								${item.membername}
							</c:if>
                 		</c:forEach>
              <%--       <c:choose>
                    	<c:when test="${!empty mCardChecked}">
                    	       <c:forEach items="${mCardChecked}" var="item" varStatus="status">
                    	       		<c:if test="${item.memberid!=null && item.memberid != ''}">
			                     		${item.membername} &nbsp;&nbsp;&nbsp;
			                     		</c:if>
			                 	</c:forEach>
                    	</c:when>
                    	<c:otherwise>
							无
                    	</c:otherwise>
                    </c:choose> --%>
        <%--             		   <c:forEach items="${mCardChecked}" var="item" varStatus="status">
			                     	<c:if test="${item.checked}">${item.membername}</c:if>
			                 	</c:forEach> --%>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-1 control-label">
                 		     开始时间
                    </label>
                     <div class="col-sm-5 contentShow">
                        <fmt:formatDate value="${member.buytime}" pattern="yyyy-MM-dd HH:mm:ss" />
                    </div>
                 </div>

                     <div class="form-group">
                    <label class="col-sm-1 control-label">
                 		     结束时间
                    </label>
                     <div class="col-sm-5 contentShow">
                       <fmt:formatDate value="${member.expiretime}" pattern="yyyy-MM-dd HH:mm:ss" />

                    </div>
                 </div>
                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	门店选择
                    </label>
                    <div class="col-sm-5 contentShow">
                        <c:forEach items="${area}" var="province" >
                    			 <c:forEach items="${province.cityList}" var="city">
                    					<c:forEach items="${city.regionList}" var="region">
	                    					     <c:forEach items="${region.storeList}" var="store">
	                    					    	  	<c:if test="${store.checked}">${store.storename }&nbsp;&nbsp;</c:if>
	                    					    </c:forEach>
                    					</c:forEach>
                    			</c:forEach>
                    	</c:forEach>
                    </div>
                </div>
         <%--         <c:forEach items="${mCardChecked}" var="item" varStatus="status">
                		 <div class="form-group"
                		 <c:if test="${item.memberid==null || item.memberid== ''}">style="display:none;"</c:if> id="div_${item.id}">

		                    <div class="col-sm-2 col-sm-offset-1">
		                        <button type="button" class="btn">${item.membername}</button>
		                    </div>
		                     <div class="col-sm-4 contentShow">
		                    <fmt:formatDate value="${item.buytime}" pattern="yyyy-MM-dd"/>
		                    	 		<input id="buytime${item.id}" type="text"
		                    	 		<c:if test="${item.memberid==null || item.memberid== ''}">disabled="true"</c:if>
											value="<fmt:formatDate value="${item.buytime}" pattern="yyyy-MM-dd"/>"
		                    	 		 name="memberMiddleCardList[${status.index}].buytime"
									 placeholder="请输入日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
								<i class="icon iconfont data type1"></i>
		                    </div>
		                 </div>


 					 </c:forEach> --%>


        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/member/listPage">返回</a>
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/member/listPage">返回会员列表</a>
                        <a class="btn btn-success" href="<%=request.getContextPath() %>/user/member/addPage">继续添加</a>
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
<script src="<%=request.getContextPath()%>/assets/js/member/detail_member.js"></script>

</html>
