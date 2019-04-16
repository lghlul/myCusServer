<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑会员</title>
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
</head>
<body>
    <div class="external">
        <div class="page-header">
            <ul class="breadcrumb">
                <li>
                    <i class="iconfont">&#xe648;</i>
                    <a href="javascript:void(0)">编辑用户</a>
                </li>
            </ul>
        </div>

            <div class="menu-panel">
                <div class="panel-header">
                    <b></b>
                    <span>用户基本信息</span>
                </div>

			<form id="form" class="form-horizontal" action="<%=request.getContextPath()%>/user/xfuser/editSave" method="post">
					
					<input type="hidden" name="org"  value="${member.org}">
					<input type="hidden" name="userid"  value="${member.userid}">
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	用户类型
                    </label>
                    <div class="col-sm-5 contentShow" id="div_membertype">
                     	<input class="courseGroupType membertype" type="radio" name="membertype" <c:if test="${member.org==1}"> checked="checked" </c:if> value="1">会员
                    	<input class="courseGroupType membertype" type="radio" name="membertype" <c:if test="${member.org==0}"> checked="checked" </c:if> value="0">普通用户

                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	用户名称
                    </label>
                    <div class="col-sm-5">
                  	  <input type="hidden" name="id" value="${member.id}" >
                        <input type="text" name="membername"  value="${member.name}" class="form-control" placeholder="请输入会员名称" required="required" maxlength="100">
                    </div>
                </div>

				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <span >*</span>
                       	电话号码
                    </label>
                     <div class="col-sm-5">
                        <input type="tel" name="phonenumber" value="${member.phone}"  class="form-control" placeholder="请输入电话号码" >
                    </div>
                 </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                    <!-- <span >*</span> -->
                       	身份证号
                    </label>
                     <div class="col-sm-5">
                        <input type="text" name="idnumber"  value="${member.idNumber}"  class="form-control" placeholder="请输入身份证号" maxlength="18" >
                    </div>
                 </div>
				<div class="form-group">
                    <label class="col-sm-1 control-label">
                   <span >*</span>
                 			      选择会员卡
                    </label>
                    <div class="col-sm-5 choose" id="checkdiv">
                     	<c:forEach items="${memberCard}" var="item" varStatus="status">
							<input class="checkbox_memberCard" type="radio" name="mcardid" value="${item.id}"
							<c:if test="${item.id == mCardId}"> checked="checked" </c:if>/>	${item.membername}
                 		</c:forEach>


                    </div>
                </div>

<%--                  <c:forEach items="${mCardChecked}" var="item" varStatus="status">
                		 <div class="form-group"
                		 <c:if test="${item.memberid==null || item.memberid== ''}">style="display:none;"</c:if> id="div_${item.id}">

		                    <label class="col-sm-1 control-label"></label>
		                    <div class="col-sm-2">
		                        <button type="button" class="btn">${item.membername}</button>
		                    </div>
		                     <div class="col-sm-3">
		                    	 		<input id="buytime${item.id}" type="text" class="form-control"
		                    	 		<c:if test="${item.memberid==null || item.memberid== ''}">disabled="true"</c:if>
											value="<fmt:formatDate value="${item.buytime}" pattern="yyyy-MM-dd"/>"
		                    	 		 name="memberMiddleCardList[${status.index}].buytime"
									 placeholder="请输入日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});">
								<!-- <i class="icon iconfont data type1"></i> -->
		                    </div>
		                 </div>
 					 </c:forEach> --%>
 					 
 					 
 					<div class="form-group">
                    	<label class="col-sm-1 control-label">
	                    	<span >*</span>
	                       	有效时间
                    	</label>

							<div class="contractBeginDay time"><%-- <c:if test="${member.org==1}"> checked="checked" </c:if> --%>
								<c:if test="${member.org==1}">
									<input type="text" id="starttime"  class="form-control" name="buytime" value="<fmt:formatDate value="${member.buyTime }" pattern="yyyy-MM-dd HH:mm:ss" />"
									 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endtime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})">
								</c:if>
								<c:if test="${member.org==0}">
									<input type="text" id="starttime"  class="form-control" name="buytime" value="<fmt:formatDate value="${member.buyTime }" pattern="yyyy-MM-dd HH:mm:ss" />"
									 placeholder="开始日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endtime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})">
								</c:if>
							</div>
						至
							<div class="contractBeginDay time">
								<c:if test="${member.org==1}">
									<input type="text" id="endtime"  class="form-control" name="expiretime" value="<fmt:formatDate value="${member.expireTime }" pattern="yyyy-MM-dd HH:mm:ss" />"
									 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'starttime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})">
								</c:if>
								<c:if test="${member.org==0}">
									<input type="text" id="endtime"  class="form-control" name="expiretime" value="<fmt:formatDate value="${member.expireTime }" pattern="yyyy-MM-dd HH:mm:ss" />"
									 placeholder="结束日期" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'starttime\')}',dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})">
								</c:if>
								
								<!-- <i class="icon iconfont data type1"></i> -->
							</div>
						</div>

					<div class="form-group" id="div_choseStores">
	                    <label class="col-sm-1 control-label">
	                      <span >*</span> 	门店选择
	                    </label>
	                     <div class="col-sm-5" id="cleandiv">
	                    	<c:forEach items="${area}" var="province" >
	                    			 <c:forEach items="${province.cityList}" var="city">
	                    					<c:forEach items="${city.regionList}" var="region">
		                    					     <c:forEach items="${region.storeList}" var="store">
		                    					    	  	<c:if test="${store.checked}">
															<input type="hidden" id="f_storeid" name="storeid"  value="${store.id}" />
															${store.storename }&nbsp;&nbsp;
															</c:if>
		                    					    </c:forEach>
	                    					</c:forEach>
	                    			</c:forEach>
	                    	</c:forEach>
	                    	  <a class="btn btn-success" data-toggle="modal" data-target="#choose_stores" id="mendianchoose">选择门店</a>
	                    </div>
                	</div>

        </div>

        <div class="footer-button">
                <a class="btn chooseone" href="<%=request.getContextPath()%>/user/xfuser/listPage">取消</a>
                <div class="submit">
                   <!-- <a class="btn" id="a_sub">发布</a> -->
<input type="hidden" id="f_status" name="status"  value="1" />
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
	                    					      		<label><input name="stores" class="stores" type="radio" value="${store.id}"<c:if test="${store.checked}">checked="checked"</c:if> data-name="${store.storename }"/>${store.storename }</label>

	                    					    	  	<%--  <label><input name="storeid" class="stores" type="radio" value="${store.id}" data-name="${store.storename }"/>${store.storename }</label> --%>
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
                        <a class="btn btn-info" href="<%=request.getContextPath() %>/user/xfuser/listPage">返回用户列表</a>
                        <%-- <a class="btn btn-success" href="<%=request.getContextPath() %>/user/xfuser/editPage?id=${member.id}">继续编辑</a> --%>
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
                           <span id="sp_msg"></span>
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
<script src="<%=request.getContextPath()%>/assets/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/uploadImg/js/imgPlugin.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/card.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/user/edit_member.js"></script>


</html>
