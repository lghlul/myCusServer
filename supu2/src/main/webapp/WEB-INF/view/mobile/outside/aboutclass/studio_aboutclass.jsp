<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html style="font-size: 10px;">

	<head>
		<meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<title>约课-工作室</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/style-yk-sjk-yiyue.css">
		<style>
			.blank>div:first-of-type {
				margin-top: 4.5rem;
			}

			.right {
				float: right;
			}
			.mint-tabbar.bottom-tab-bar.boder-1px-top.tabbar.is-fixed.intTabBar{
    			width: 100%;
    			/* height: 4.5rem;
    			padding: 1.2rem 0; */
    			border-top: 1px solid #f2f2f2;
    			position: fixed;
    			bottom: 0;
    			left: 0;
    			z-index: 2;
    			background: #fff;
    			color: rgba(0, 0, 0, .6);
			}
			.mint-tab-item-label, .mint-tab-item-label a {
    			line-height: 2;
    			text-decoration: none;
			}
			.mint-tab-item.is-selected .mint-tab-item-label,
			.mint-tab-item.is-selected .mint-tab-item-label a {
    			color: #FF0000;
			}
			.mint-tabbar>.mint-tab-item.is-selected {
    			background-color: #fff;
			}
			.bottom-tab-bar .mint-tab-item-label, .bottom-tab-bar .mint-tab-item-label a {
    			font-size: 15px;
			}
			.bottom-tab-bar .boder-1px-left:after {
    			height: 2.3rem;
    			top: 35%;
			}
			.boder-1px-left:after {
    			content: "";
    			position: absolute;
    			left: 0;
    			top: 25%;
    			bottom: 0;
    			width: 1px;
    			height: 100%;
    			border-left: 1px solid rgba(0, 0, 0, .1);
    			color: #d9d9d9;
    			-webkit-transform-origin: 0 0;
    			transform-origin: 0 0;
    			-webkit-transform: scaleY(.5);
    			transform: scaleY(.5);
			}
			.boder-1px-left {
    			position: relative;
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="body-box">
				<div infinite-scroll-disabled="loading" infinite-scroll-distance="200" class="my-lesson">
					<div id="map" class="position-btn clearfix text-center">
						<div class="one">
							<img src="https://cdn.leoao.com/leoao-coach-mposition000.png" alt="">
							<span class="fn-left">南京市<i></i></span>
						</div>
						<div class="two more fn-right">
							<span>工作室<i></i></span>
						</div>
					</div>
					<div class="mask sjMask" style="display: none;">
						<div class="sj-text">
							选择业务
							<img src="<%=request.getContextPath()%>/assets/images/leoao-coach-mxb00.png">
						</div>
						<ul class="clearfix">
							<a href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
								<li class="one">基础团课</li>
							</a>
							<a href="<%=request.getContextPath()%>/outside/aboutClass/privatePage">
								<li class="two">私教课</li>
							</a>
							<a href="<%=request.getContextPath()%>/outside/aboutClass/studioPage">
								<li class="active three">工作室</li>
							</a>
							<a  href="<%=request.getContextPath()%>/outside/aboutClass/courseGroupPage">
                               <li class="three">训练营</li>
                           </a>
						</ul>
					</div>

					<!---->
					<c:choose>
						<c:when test="${empty studioclass}">
							<div class="blank">
								<div>你还没有工作室课程哦</div>
								<div>
								<%-- 	<a href="<%=request.getContextPath()%>/outside/buyCard/coursePriCoachPage">
									<span class="">19元体验课专属私教</span>
									</a> --%>
								</div>
							</div>
						</c:when>
						<c:otherwise>
		 					<c:forEach items="${studioclass }" var="items">
								<div class="my-lesson-list clearfix">
									<div class="left"><img src="${items.image }"></div>
									<div class="center">
										<div class="center-box">
											<div class="lesson-title">
												${items.nickname }
												<a href="tel://${items.phonenumber }"></a>
											</div>
											<div class="lesson-name">${items.coursename }</div>
											<div class="class-info"><span>未预约 ${items.totalclass-items.appointCount } <i>|</i></span> <span>总课时 ${items.totalclass } <i>|</i></span> <span>已预约 <i class="main">${items.appointCount }</i></span></div>
										</div>
									</div>
									<div class="right">
						<%-- 				<form id="form1" action="<%=request.getContextPath()%>/outside/aboutClass/appointPage" method="POST"> --%>
				<%-- 							<input type="hidden" value="${items.coachs}" name="coachid"></input>
											<input type="hidden" value="${items.coachname}" name="coachname"></input>
											<input type="hidden" value="${items.courseid}" name="courseid"></input> --%>
											<a href="<%=request.getContextPath()%>/outside/aboutClass/appointStudioPage?courseid=${items.courseid}"><span class="one fn-right">在线预约</span></a>
<!-- 										</form>
 -->
									</div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>

					<!---->
					<%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
			<!-- 		<div class="bottom-nav text-center">
						<ul class="clearfix">
							<li class="active">
								<a href="index.html">约课</a>
							</li>
							<li>
								<a href="gm_Huiyuanka.html">购买</a>
							</li>
							<li>
								<a href="my_lesson.html">我的课程</a>
							</li>
							<li>
								<a href="personal_center.html">个人中心</a>
							</li>
						</ul>
					</div> -->
				</div>
			</div>
		</div>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
		<script>
			$(function() {
				$(".more").click(function() {
					$(".mask").show();
				});
				$(".sj-text").click(function() {
					$(".mask").hide();
				});
			});
		</script>

	</body>
</html>
