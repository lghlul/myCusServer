<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>教练详情</title>
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
                    <a href="javascript:void(0)">教练详情</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>教练基本信息</span>
                </div>

			<form id="form" class="form-horizontal">
				<div class="form-group">
				<input type="hidden" value="${coach.id }" name="id">
                    <label class="col-sm-1 control-label">
                       	教练名称
                    </label>
                    <div class="col-sm-5 contentShow">
                        ${coach.coachname }
                    </div>
                </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	教练昵称
                    </label>
                    <div class="col-sm-5 contentShow">
                  	  ${coach.nickname }

                    </div>
                </div>


				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	性别
                    </label>
                    <div class="col-sm-5 contentShow">
                    	<c:if test="${coach.sex==1}">
                    		男
                    	</c:if>
                    	<c:if test="${coach.sex==0}">
                    		女
                    	</c:if>
                      <%--   <input type="radio" name="sex"  <c:if test="${coach.sex==1}">checked="checked"</c:if>  value="1" >男
                         <input type="radio" name="sex" <c:if test="${coach.sex==0}">checked="checked"</c:if> value="0" >女 --%>
                    </div>
                </div>



				<div class="form-group">
					<label class="col-sm-1 control-label">
                       	生日
                    </label>

					<div class="col-sm-5 contentShow">
							<div class="contractDay-menu">
								<div class="contractBeginDay time">

									<fmt:formatDate value="${coach.birthday}" pattern="yyyy-MM-dd"/>

								</div>


							</div>
					</div>

				</div>
				<div class="form-group">
			         <label class="col-sm-1 control-label">
			                                        邮箱
			         </label>
			         <div class="col-sm-5 contentShow">
			             ${coach.email}
					</div>
			     </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	手机号码
                    </label>
                     <div class="col-sm-5 contentShow">
                        ${coach.phonenumber }
                    </div>
                 </div>
			   <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	身份证号
                    </label>
                     <div class="col-sm-5 contentShow">
                     ${coach.idnumber }

                    </div>
                </div>
                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	身份证正面照
                    </label>
                     <div class="col-sm-5">
                        <img src="${coach.frontidnumber }">
                    </div>
                </div>

     			 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	身份证反面照
                    </label>
                     <div class="col-sm-5">
                        <img src="${coach.reverseidnumber }">
                    </div>
                </div>

                 <div class="form-group">
                    <label class="col-sm-1 control-label">
      					所在地
                    </label>
                     <div class="col-sm-5 contentShow">
	                      <c:forEach items="${city}" var="item" varStatus="status">
	                           	<c:if test="${item.checked}">
	                           		${item.name}
	                           	</c:if>
	                      </c:forEach>
                        <!--  </select> -->
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	服务区域
                    </label>
                     <div class="col-sm-5 contentShow" id="div_servicearea">
                    	 <c:forEach items="${region}" var="item" varStatus="status">
                    	 <c:if test="${item.checked }">
                    	 ${item.name } &nbsp;
                    	 </c:if>
                        	<%-- <input type="checkbox" name="servicearea" value="${item.zonecode}" <c:if test="${item.checked }">checked="checked"</c:if>>${item.name } --%>
                        </c:forEach>
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

                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       	毕业院校
                    </label>
                    <div class="col-sm-5 contentShow">
                        ${coach.graduatecolleges }
                    </div>
                </div>
  				<div class="form-group">
                    <label class="col-sm-1 control-label">
                       	曾经就职
                    </label>
                     <div class="col-sm-5 contentShow">
                        ${coach.everworked }
                    </div>
                	</div>
    		<div class="form-group">
                    <label class="col-sm-1 control-label">
                 		  教龄
                    </label>
                     <div class="col-sm-5 contentShow">
                        ${coach.teachyears }年
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                      	 教练等级
                    </label>
                     <div class="col-sm-5 menu">
                     	<button type="button" class="btn btn-default <c:if test="${coach.coachlevel==1 }">btn-success</c:if> coachlevel" data-id="1">P1认证</button>
                     	<button type="button" class="btn btn-default <c:if test="${coach.coachlevel==2 }">btn-success</c:if> coachlevel" data-id="2">P2高级</button>
                     	<button type="button" class="btn btn-default <c:if test="${coach.coachlevel==3 }">btn-success</c:if> coachlevel" data-id="3">P3资深</button>
                     	<button type="button" class="btn btn-default <c:if test="${coach.coachlevel==4 }">btn-success</c:if> coachlevel" data-id="4">P4专家</button>
                    </div>
               	</div>
                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	擅长
                    </label>
                     <div class="col-sm-5 contentShow place">
                        	${coach.goodat }
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	照片1
                    </label>
                     <div class="col-sm-5 contentShow place">
                        	<img src="${coach.coachimg1 }" style="width:216px;height:125px">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	照片2
                    </label>
                     <div class="col-sm-5 contentShow place">
                     	<img src="${coach.coachimg2 }" style="width:216px;height:125px">
                    </div>
                </div>
                                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	照片3
                    </label>
                     <div class="col-sm-5 contentShow place">
                     	<img src="${coach.coachimg3 }" style="width:216px;height:125px">
                    </div>
                </div>
                                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	照片4
                    </label>
                     <div class="col-sm-5 contentShow place">
                     	<img src="${coach.coachimg4 }" style="width:216px;height:125px">
                    </div>
                </div>
                                <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	照片5
                    </label>
                     <div class="col-sm-5 contentShow place">
                     	<img src="${coach.coachimg5 }" style="width:216px;height:125px">
                    </div>
                </div>
                <c:forEach items="${certificateList }" var="items" varStatus="status">
                     <div class="form-group">
	                    <label class="col-sm-1 control-label">
	                       <span >*</span>	证件${status.index+1 }
	                    </label>
	                     <div class="col-sm-5 contentShow place">
	                        	<img src="${items.certificateimg }" style="width:216px;height:125px">
	                    </div>
	                </div>
                </c:forEach>
<%--                                 <div class="form-group">
                    <label class="col-sm-1 control-label">
                       <span >*</span>	照片1
                    </label>
                     <div class="col-sm-5 contentShow place">
                        	${coach.goodat }
                    </div>
                </div> --%>
        </div>


        </form>
        <div class="form-group component center">
                    <a class="btn btn-success" href="<%=request.getContextPath()%>/user/coach/listPage">返回</a>
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
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/coach/detail_coach.js"></script>


</html>
