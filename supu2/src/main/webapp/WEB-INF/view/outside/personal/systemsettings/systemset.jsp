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
		<style type="text/css">
			.le-loading {
				display: inline-block;
				opacity: .8;
				-webkit-animation: leLoading 1s infinite;
				animation: leLoading 1s infinite;
				-webkit-transform: rotate(60deg);
				transform: rotate(60deg)
			}

			@-webkit-keyframes leLoading {
				0% {
					-webkit-transform: rotate(0deg);
					transform: rotate(0deg)
				}
				to {
					-webkit-transform: rotate(1turn);
					transform: rotate(1turn)
				}
			}

			@keyframes leLoading {
				0% {
					-webkit-transform: rotate(0deg);
					transform: rotate(0deg)
				}
				to {
					-webkit-transform: rotate(1turn);
					transform: rotate(1turn)
				}
			}

			.le-cell {
				background-color: #fff;
				box-sizing: border-box;
				font-size: .14rem;
				padding: .15rem 0;
				color: #000
			}

			.le-cell .cell-wrapper .title {
				font-size: .16rem
			}

			.le-cell .cell-wrapper .value {
				color: rgba(0, 0, 0, .8)
			}

			.icon-jiantou_right {
				color: rgba(0, 0, 0, .3)
			}

			.icon-icon07,
			.icon-loading {
				color: rgba(0, 0, 0, .3);
				margin-left: .03rem
			}
			.le-container {
				padding: .25rem
			}

			.le-container .set {
				font-size: .26rem;
				margin-bottom: .1rem
			}

			.le-container .tel {
				font-family: DIN-Medium;
				color: #ff4e00
			}

			.contactNum {
				font-size: .15rem;
				color: rgba(0, 0, 0, .3);
				font-family: monospace
			}

			.logOut {
				border: 1px solid #000;
				margin: .24rem auto;
				color: #000;
				background: #fff
			}
			.wrap .tabbar {
    			height: auto;
			}
			.mint-button{
				line-height: .4rem;
			}
		</style>

	</head>

	<body>
		<div id="app" style="height: 100%; overflow: initial;">
			<div class="wrap isTabBar">
				<!---->
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div><button class="mint-button le-city-btn mint-button--default mint-button--normal"><!----> <label class="mint-button-text"><div class="city-selector"><i class="icon iconfont icon-icon_didian_x"></i> <small class="cur-address">南京市</small> <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i></div></label></button></div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div class="le-container">
					<h3  class="set">设置</h3>

					<a href="<%=request.getContextPath()%>/outside/personal/accountsettings">
						<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
						<div class="cell-left"></div>
						<div flex="main:justify" class="cell-wrapper">
							<div class="title">账号设置</div>
							<div class="value"></div>
						</div>
						<div class="cell-right">
							<i class="iconfont icon-jiantou_right"></i></div>
					</div>
					</a>


					<a href="<%=request.getContextPath()%>/outside/personal/membershipagreement">
					<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
						<div class="cell-left"></div>
						<div flex="main:justify" class="cell-wrapper">
							<div class="title">会员协议</div>
							<div class="value"></div>
						</div>
						<div class="cell-right">
							<!----><i  class="iconfont icon-jiantou_right"></i> </div>
					</div>
					</a>
					<a href="<%=request.getContextPath()%>/outside/personal/aboutus">
					<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
						<div class="cell-left"></div>
						<div flex="main:justify" class="cell-wrapper">
							<div class="title">关于我们</div>
							<div class="value"></div>
						</div>
						<div class="cell-right">
							<!----><i  class="iconfont icon-jiantou_right"></i> </div>
					</div>
					</a>
					<a>
					<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
						<div class="cell-left"></div>
						<div flex="main:justify" class="cell-wrapper">
							<div class="title">联系我们</div>
							<div class="value"><span class="tel">QQ：602462692</span></div>
						</div>
						<div class="cell-right">

						</div>
					</div>
					</a>
					<a id="logout" href="<%=request.getContextPath()%>/outside/loginout" class="mint-button logOut mint-button--default mint-button--large">
						<label class="mint-button-text">退出登录</label></a>
				</div>

           <%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
				<!--menu-->
<!-- 				<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
					 <a class="mint-tab-item" href="index.html">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">约课</div>
            </a>
            <a class="mint-tab-item boder-1px-left" href="gm_Huiyuanka.html">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">购买</div>
            </a>
            <a class="mint-tab-item boder-1px-left" href="my_lesson.html">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">我的课程</div>
            </a>
            <a class="mint-tab-item boder-1px-left is-selected">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">个人中心</div>
            </a>
				</div> -->
			</div>
		</div>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_lqw37te7tmjnstt9.css">
		<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
	</body>


</html>