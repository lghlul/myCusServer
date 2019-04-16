<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>速扑健身</title>
		<meta content="email=no" name="format-detection">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
        <%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.36209059df2d810eeb6536a3cc0e274d.css"> --%>

        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.c8292720754131608eb0fac6964f4be0.css">
		<link href="<%=request.getContextPath()%>/assets/css/outside/style-my-lesson.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_lqw37te7tmjnstt9.css"/>
		<style>
			.mask{
				z-index: 2012;
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="wrap isTabBar">
				<!---->
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div><button class="mint-button le-city-btn mint-button--default mint-button--normal"><!----> <label class="mint-button-text"><div class="city-selector"><i class="icon iconfont icon-icon_didian_x"></i> <small class="cur-address">南京市秦淮区水平方店</small> <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i></div></label></button></div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div class="container" style="padding: 0;">
					<div class="le-tab-switch">
						<a href="<%=request.getContextPath()%>/outside/myCourse/nofinishPage"><span class="label  action">未完成</span></a>
						<a href="<%=request.getContextPath()%>/outside/myCourse/finishedcoursePage"><span class="label">已完成</span></a>
					<!-- 	<a href="my_lesson.html"><span class="label">无课程</span></a> -->
					</div>
					<div class="container courses-container">


						<!--课程01-->
						<c:choose >
						  <c:when test="${course!=null && fn:length(course) > 0}">

							<c:forEach items="${course}" var="item" varStatus="status">
								<div class="le-courses-box courses-box">
									<div class="date">${item.appointtime }</div>
									<div class="boder-1px-bottom">
										<div flex="main:justify" class="le-courses-class">
											<div class="left">
												<div class="top"><span class="title">${item.coursename }</span>
													<span class="state-text cancelAppoint" >取消预约</span>
													<input type="hidden" value="${item.id }">
												</div>
												<div class="bottom"><i class="iconfont icon-icon_shijian_"></i> <span>${item.starttime }-${item.endtime }</span>
												<i class="iconfont icon-icon_didian_x"></i> <span>${item.storename }</span></div>
											</div>
											<div class="right">
												<!-- <button class="btn" onclick="window.location='my_lesson_pl.html'">评价</button> -->
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:when>
						   <c:otherwise>
						   		<div class="empty-box">
								<div>

								<a href="<%=request.getContextPath()%>/outside/aboutClass/listPage"><img src="<%=request.getContextPath()%>/assets/images/wkc.png" class="empty-img">
									<p class="empty-text">没有课程 速去约课</p></a>
								</div>
							</div>
   							</c:otherwise>
						</c:choose>
			<!-- 			<div class="le-courses-box courses-box">
							<div class="date">08.08 周二</div>
							<div class="boder-1px-bottom">
								<div flex="main:justify" class="le-courses-class">
									<div class="left">
										<div class="top"><span class="title">线下减脂1 . 李一粒</span>
											<span class="state-text">已完成</span>

										</div>
										<div class="bottom"><i class="iconfont icon-icon_shijian_"></i> <span>07:00-08:00</span> <i class="iconfont icon-icon_didian_x"></i> <span>马台街店</span></div>
									</div>
									<div class="right">
										<button class="btn" onclick="window.location='my_lesson_pl.html'">评价</button>

									</div>
								</div>
							</div>
						</div> -->



						<!--loading-->
						<div flex="main:center cross:center" class="loding-mask" style="display: none;">
							<div class="loding-box">
								<div flex="main:center cross:center" class="logding-box"><span class="spinner"><div class="mint-spinner-snake" style="border-top-color: rgb(250, 74, 17); border-left-color: rgb(250, 74, 17); border-bottom-color: rgb(250, 74, 17); height: 22px; width: 22px;"></div></span></div>
							</div>
						</div>
						<!---->
					</div>
				</div>
						<%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
			<!-- 	<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
					<a class="mint-tab-item" href="index.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							约课
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="gm_Huiyuanka.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							购买
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left is-selected">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							我的课程
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="personal_center.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							个人中心
						</div>
					</a>
				</div> -->
			</div>
		</div>

</html>

<!--弹出层-->
<div  class="mask sure" style="display:none;"></div>
<div id="alertSure" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="sureMassage">提示</div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message">确定取消该预约吗？</div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
       		<input type="hidden" value="" id="cancelAppointId">
        	<button class="mint-msgbox-btn mint-msgbox-cancel btn_div " id="btn_sure" style="">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel btn_div" id="btn_cancel" style="">取消</button>
        </div>
    </div>
</div>


<!--弹出层-->
<div  class="mask failmask" style="display:none;"></div>
<div id="alertFail" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="errorMassage">操作失败</div>
        </div>
        <div class="mint-msgbox-content">

            <div class="mint-msgbox-message" id="failmsg"></div>

           <!--  <div class="mint-msgbox-message">请重试</div> -->

            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
        	<button class="mint-msgbox-btn mint-msgbox-cancel btn_div  btn_msg"  style="">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel btn_div  btn_msg" style="">取消</button>
        </div>
    </div>
</div>


<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<%-- <script
	src="<%=request.getContextPath()%>/assets/bootstrap/js/table/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootbox.js"></script> --%>
<script src="<%=request.getContextPath()%>/assets/js/outside/mycourse/nofinishlist.js"></script>