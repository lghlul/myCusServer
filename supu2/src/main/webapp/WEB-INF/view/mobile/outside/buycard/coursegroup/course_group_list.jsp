<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/style1500628681675.css">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>主题训练营</title>
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<style>
			.training-slip {
				margin-top: .5rem;
			}

			.training-center-item-main {
				height: 25%;
			}
			.wrap .tabbar {
    			height: auto;
			}
		</style>
	</head>

	<body style="overflow: initial;">
		<div id="app" style="height: 100%; overflow: initial;">
			<div class="wrap isHeaderBar isTabBar">
				<header class="mint-header blur-box header-bar is-fixed inHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div>
						<button class="mint-button le-city-btn mint-button--default mint-button--normal"><!---->
                    <label class="mint-button-text">
                        <div class="city-selector">
                            <i class="icon iconfont icon-icon_didian_x"></i>
                            <small class="cur-address">南京市</small>
                            <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i>
                        </div>
                    </label>
                </button>
					</div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div>
					<div class="mint-navbar dark le-class-navbar-fixed">
						<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/buyCard/listPage">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label">会员卡</div>
						</a>
						<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/buyCard/coursePriCoachPage">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label">私教课</div>
						</a>
						<a class="mint-tab-item is-selected" >
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label">训练营</div>
						</a>
						<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/buyCard/studioListPage">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label">工作室</div>
						</a>
					</div>
					<div>
						<div class="buy-list-main">
							<div class="le-class-items" id="appendgroupDiv">



								<!--loading-->
								<div flex="main:center cross:center" class="loding-mask" style="display: none;">
									<div class="loding-box">
										<div flex="main:center cross:center" class="logding-box">
											<span class="spinner">
                                        <div class="mint-spinner-snake" style="border-top-color: rgb(250, 74, 17); border-left-color: rgb(250, 74, 17); border-bottom-color: rgb(250, 74, 17); height: 22px; width: 22px;"></div>
                                    </span>
										</div>
									</div>
								</div>
							</div>
							<div class="mask" style="display: none;"></div>
						</div>
					</div>
				</div>
				<%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
		<%-- 		<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
					<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">约课</div>
					</a>
					<a class="mint-tab-item boder-1px-left is-selected">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">购买</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="<%=request.getContextPath()%>/outside/myCourse">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">我的课程</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="personal_center.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">个人中心</div>
					</a>
				</div> --%>
			</div>
		</div>
		</script>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/coursegroup/course_group_list.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
	</body>

</html>