<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>个人中心</title>
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<style type="text/css">
			.user-center .le-panel-user-center .iconfont {
				font-size: .25rem;
				margin-right: .03rem;
				position: relative
			}

			.user-center .le-panel-user-center .le-cell .cell-wrapper .title {
				color: #000
			}

			.user-center {
				font-size: .14rem
			}

			.user-center-main {
				padding-bottom: .24rem
			}

			.user-center-header {
				width: 100%;
				box-sizing: border-box
			}

			.user-center-header .header-top {
				box-sizing: border-box;
				width: 100%;
				padding: .1rem .1rem 0 .25rem;
				position: relative
			}

			.user-center-header .user-center-info {
				position: relative
			}

			.user-center-header .user-center-info .header-img {
				width: 1rem;
				height: 1rem;
				text-align: center
			}

			.user-center-header .user-center-info .header-img img {
				width: .7rem;
				height: .7rem;
				border-radius: 50%;
				box-shadow: 0 4px 20px 0 rgba(255, 78, 0, .2);
				margin-top: .15rem
			}

			.user-center-header .user-center-info .name {
				font-size: .27rem;
				color: rgba(0, 0, 0, .8);
				margin: .12rem 0 .03rem
			}

			.user-center-header .user-center-info .lable {
				font-size: .12rem;
				color: rgba(0, 0, 0, .6)
			}

			.user-center-header .right-box {
				position: absolute;
				bottom: .2rem;
				right: .42rem
			}

			.user-center-header .right-box .item {
				text-align: center;
				color: #ff4e00;
				font-size: .12rem
			}

			.user-center-header .right-box .item .activityIcon {
				width: .35rem;
				margin-bottom: .03rem
			}

			.user-center-header .header-bottom {
				margin: .1rem .25rem;
				background: #fff;
				padding: 0 0 .25rem;
				box-shadow: 0 2px 8px 0 rgba(0, 0, 0, .1);
				border-radius: 6px
			}

			.user-center-header .header-bottom .iconic-box {
				height: 1.38rem;
				overflow: hidden
			}

			.user-center-header .header-bottom .iconic-box.more {
				height: auto;
				overflow: inherit
			}

			.user-center-header .header-bottom.hasMore {
				padding: 0
			}

			.user-center-header .header-bottom .getMore {
				text-align: center;
				padding: 0 0 .1rem;
				position: relative;
				height: .2rem
			}

			.user-center-header .header-bottom .getMore .iconfont {
				color: rgba(0, 0, 0, .6);
				font-size: .18rem
			}

			.user-center-header .header-bottom .inline-block {
				display: inline-block;
				text-align: center
			}

			.user-center-header .header-bottom .inline-block.one {
				width: 60%
			}

			.user-center-header .header-bottom .inline-block.two {
				width: 30%
			}

			.user-center-header .header-bottom .inline-block .comingsoon {
				position: relative;
				top: .1rem
			}

			.user-center-header .header-bottom .member-benefits-item {
				position: relative;
				display: inline-block;
				text-align: center;
				width: 33%;
				height: 1.08rem;
				padding-top: .25rem
			}

			.user-center-header .header-bottom .member-benefits-item p {
				white-space: nowrap
			}

			.user-center-header .header-bottom .member-benefits-item .name {
				width: .55rem;
				height: .6rem
			}

			.user-center-header .header-bottom .member-benefits-item .labe-box {
				height: .42rem;
				overflow: hidden;
				position: absolute;
				left: 0;
				right: 0;
				bottom: 0
			}

			.user-center-header .header-bottom .member-benefits-item .labe-box .labe-box-center {
				position: absolute;
				left: 50%;
				top: 50%;
				transform: translate(-50%, -50%);
				-ms-transform: translate(-50%, -50%);
				-webkit-transform: translate(-50%, -50%);
				-o-transform: translate(-50%, -50%);
				-moz-transform: translate(-50%, -50%)
			}

			.user-center-header .header-bottom .member-benefits-item .labe-box .card-name {
				font-weight: 700
			}

			.user-center-header .header-bottom .member-benefits-item .labe-box .labe {
				font-size: .11rem;
				color: rgba(0, 0, 0, .6);
				margin-top: .03rem
			}

			.user-center-header .header-bottom .member-benefits-item.un-able {
				opacity: .3
			}

			.user-center-header .header-bottom .member-benefits-item.un-able .labe {
				color: rgba(0, 0, 0, .8)
			}

			.cell-active-icon {
				width: .3rem
			}

			.boder-1px-bottom {
				position: relative
			}

			.boder-1px-bottom:after {
				content: "";
				position: absolute;
				left: 0;
				bottom: 0;
				width: 100%;
				height: 1px;
				border-top: 1px solid rgba(0, 0, 0, .1);
				color: #d9d9d9;
				-webkit-transform-origin: 0 0;
				transform-origin: 0 0;
				-webkit-transform: scaleY(.5);
				transform: scaleY(.5)
			}

			.le-panel-user-center {
				margin-top: .12rem;
				padding: 0 .25rem
			}

			.setDown {
				position: absolute;
				width: .18rem;
				height: .2rem;
				margin-left: -.09rem;
				animation: mymove 1s;
				-webkit-animation: mymove 1s;
				animation-iteration-count: infinite;
				-webkit-animation-iteration-count: infinite
			}

			@-webkit-keyframes mymove {
				0% {
					top: 0;
					opacity: .9
				}
				to {
					top: .08rem;
					opacity: .1
				}
			}

			@keyframes mymove {
				0% {
					top: 0;
					opacity: .9
				}
				to {
					top: .08rem;
					opacity: .1
				}
			}

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
			a .card-name{color: #000000;}
			.wrap .tabbar {
    			height: auto;
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="wrap isTabBar">
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div>
						<button class="mint-button le-city-btn mint-button--default mint-button--normal">
                    <label class="mint-button-text">
                        <div class="city-selector"><i class="icon iconfont icon-icon_didian_x"></i>
                            <small class="cur-address">南京市</small> <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i>
                        </div>
                    </label>
                </button>
					</div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div class="user-center">
					<div class="user-center-main">
						<div class="user-center-header">
							<div class="header-top">
								<div flex="main:justify cross:center" class="user-center-info">
									<div >
										<h3 class="name one-single-file">${employee.username }</h3>
										<!-- <p class="lable one-single-file">您尚未成为速扑健身会员</p> -->
									</div>
									<div class="header-img"><img src="<%=request.getContextPath()%>/assets/images/outside/sp.png" style=""></div>
								</div>
							</div>

							<div class="header-bottom">
								<div class="iconic-box">
									<c:forEach items="${mCard}" var="item" varStatus="status">
										<c:choose>
											<c:when test="${item.isbuy}">
													<a href="<%=request.getContextPath()%>/outside/personal/mCardInfo?id=${item.id}">
													<div class="member-benefits-item">
													<img src="${item.mcardimg}" class="name">
													<div class="labe-box">
														<div class="labe-box-center">
															<p class="card-name">${item.membername}</p>
															<p class="labe">已购买</p>
														</div>
													</div>
												</div>

											</c:when>
											<c:otherwise>
													<a href="<%=request.getContextPath()%>/outside/personal/mCardInfo?id=${item.id}">
														<div class="member-benefits-item un-able">
															<img src="${item.mcardimg}" class="name">
															<div class="labe-box">
																<div class="labe-box-center">
																	<p class="card-name">${item.membername}</p>
																	<p class="labe">未购买</p>
																</div>
															</div>
														</div>
													</a>
											 </c:otherwise>
										</c:choose>

						            </c:forEach>
						            </div>
						<%-- 		<div class="iconic-box">
									<a href="my_vip.html">
										<div class="member-benefits-item">
										<img src="<%=request.getContextPath()%>/assets/images/outside/o_1bhv2n9rs1eb71gj9180kugr150i9.png" class="name">
										<!---->
										<div class="labe-box">
											<div class="labe-box-center">
												<p class="card-name">健身会员卡</p>
												<p class="labe">已购买</p>
											</div>
										</div>
									</div>
									</a>
									<a href="my_vip.html">
									<div class="member-benefits-item un-able">
										<img src="<%=request.getContextPath()%>/assets/images/outside/o_1bhv2n9rs1eb71gj9180kugr150i9.png" class="name">
										<!---->
										<div class="labe-box">
											<div class="labe-box-center">
												<p class="card-name">健身会员卡</p>
												<p class="labe">未购买</p>
											</div>
										</div>
									</div>
									</a>

									<div class="member-benefits-item un-able">
										<img src="<%=request.getContextPath()%>/assets/images/outside/o_1bhv2n9rs1eb71gj9180kugr150i9.png" class="name">
										<!---->
										<div class="labe-box">
											<div class="labe-box-center">
												<p class="card-name">健身会员卡</p>
												<p class="labe">未购买</p>
											</div>
										</div>
									</div>

								</div> --%>
							</div>
						</div>
						<div class="le-panel-user-center">

							<a href="<%=request.getContextPath()%>/outside/aboutClass/privatePage">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div flex="main:justify" class="cell-wrapper">
										<div class="title">我的私教</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
										<i class="icon iconfont icon-pt"></i>
									</div>
								</div>
							</a>

							<a href="<%=request.getContextPath()%>/outside/personal/mystores">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div flex="main:justify" class="cell-wrapper">
										<div class="title">速扑健身门店</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
										<i class="icon iconfont icon-8"></i>
									</div>
								</div>
							</a>
							<a href="<%=request.getContextPath()%>/outside/personal/systemsettings">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div flex="main:justify" class="cell-wrapper">
										<div class="title">系统设置</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
										<i class="icon iconfont icon-1"></i>
									</div>
								</div>
							</a>
					<!-- 		<a href="my-coach.html">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div flex="main:justify" class="cell-wrapper">
										<div class="title">教练入驻</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
										<i class="icon iconfont icon-7"></i>
									</div>
								</div>
							</a> -->

						</div>
					</div>
				</div>



			<%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
			</div>
		</div>

	</body>

</html>