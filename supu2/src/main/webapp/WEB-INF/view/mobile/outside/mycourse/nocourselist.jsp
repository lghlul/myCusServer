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
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.c8292720754131608eb0fac6964f4be0.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/assets/css/outside/style-my-lesson.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_lqw37te7tmjnstt9.css"/>
		<style>
			.wrap .tabbar {
    			height: auto;
			}
			.mint-tab-item-label, .mint-tab-item-label a {
    			line-height: 2;
    			text-decoration: none;
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
						<!-- <a href="my_lesson-wwc.html"><span class="label">未完成</span></a>
						<a href="my_lesson-ywc.html"><span class="label">已完成</span></a> -->
						<a href="my_lesson.html"><span class="label action">无课程</span></a>
					</div>
					<div class="container courses-container">


						<!--没有课程-->
						<div class="empty-box">
							<a href="<%=request.getContextPath()%>/outside/aboutClass/listPage"><div><img src="<%=request.getContextPath()%>/assets/images/outside/wkc.png" class="empty-img">
								<p class="empty-text">没有课程 速去约课</p>
							</div>
							</a>
						</div>
						<!---->

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
			</div>
		</div>

</html>