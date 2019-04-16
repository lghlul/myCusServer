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
				color: #000;
				    display: inline-block;
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
				padding: .15rem .1rem 0 .25rem;
				position: absolute
			}

			.user-center-header .user-center-info {
				position: relative
			}

			.user-center-header .user-center-info .header-img {
				width: 0.8rem;
				/*height: 1rem;
				text-align: center*/
			}

			.user-center-header .user-center-info .header-img img {
				width: .6rem;
				height: .6rem;
				border-radius: 50%;
				box-shadow: 0 4px 20px 0 rgba(255, 78, 0, .2);
				margin-top: .15rem;
				border: 4px solid #FFF;
			}

			.user-center-header .user-center-info .name {
				font-size: .27rem;
				color: #fff;
				margin: .12rem 0 .03rem
			}
			.nameno{
				color: #000;
				font-size: .27rem;
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
				padding: 0;
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
				width: 99%;
				height: 99%;
				padding-top: 0.5%
			}
			
			

			.user-center-header .header-bottom .member-benefits-item p {
				white-space: nowrap;
				color:#FFFFFF
			}

			.user-center-header .header-bottom .member-benefits-item .name {
				width:99%;
				height:99%
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
				left: 70%;
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
			.labe{color:#fff}
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
						<c:set var="isbuy" value="0"></c:set>
						<c:forEach items="${mCard}" var="item" varStatus="status">
											<c:if test="${item.isbuy}">
											
						<c:set var="isbuy" value="1"></c:set>
							<div class="header-top">
								<div flex="cross:center" class="user-center-info">
									<div class="header-img">
									<c:if test="${employee.head == null  || employee.head ==''}"><img src="<%=request.getContextPath()%>/assets/images/outside/sp.png" style=""></c:if>
									<c:if test="${employee.head != null  && employee.head !=''}"><img src="${employee.head }" style=""></c:if>
									</div>
									<div >
										<h3 class="name one-single-file">${employee.cnname }</h3>
										<p class="labe">有效期：${item.buyTimestr}-${item.expireTimeStr}</p>
									</div>
									
								</div>
							</div>
							</div>
						<div class="iconic-box">
									
												<a href="<%=request.getContextPath()%>/outside/personal/mCardInfo?id=${item.id}">
												<div class="member-benefits-item">
													<img src="<%=request.getContextPath()%>/assets/images/newui/vipbg.png" style="width: 100%;" class="name">
												</div>
												</a>
											

						            </div>
									</c:if>
						            </c:forEach>
									
									<c:if test="${isbuy==0}">
									<div class="header-top">
											<div flex="cross:center" class="user-center-info">
												<div class="header-img">
												<c:if test="${employee.head == null  || employee.head ==''}"><img src="<%=request.getContextPath()%>/assets/images/outside/sp.png" style=""></c:if>
												<c:if test="${employee.head != null  && employee.head !=''}"><img src="${employee.head }" style=""></c:if>
												</div>
												<div >
													<h3 class="nameno one-single-file">${employee.cnname }</h3>
												</div>
												
											</div>
										</div></div>
									<div class="iconic-box">
												
															<div class="member-benefits-item">
																<img src="<%=request.getContextPath()%>/assets/images/newui/nvipbg.png" style="width: 100%;" class="name">
															</div>
															</a>
									 </div>
									</c:if>
						<div class="le-panel-user-center">

							<a href="<%=request.getContextPath()%>/outside/aboutClass/privatePage">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div  class="cell-wrapper">
										<i class="icon iconfont icon-pt"></i>
										<div class="title">我的私教</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
									</div>
								</div>
							</a>
							<a href="<%=request.getContextPath()%>/outside/aboutClass/studioPage">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div  class="cell-wrapper">
										<i class="icon iconfont icon-pt"></i>
										<div class="title">我的工作室</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
									</div>
								</div>
							</a>
							<a href="<%=request.getContextPath()%>/outside/personal/mystores">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div  class="cell-wrapper">
										<i class="icon iconfont icon-8"></i>
										<div class="title">速扑健身门店</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
									</div>
								</div>
							</a>
							<a href="<%=request.getContextPath()%>/outside/personal/systemsettings">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div class="cell-wrapper">
										<i class="icon iconfont icon-1"></i>
										<div class="title">系统设置</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
									</div>
								</div>
							</a>
							<%-- <a href="<%=request.getContextPath()%>/outside/personal/opendoor">
								<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div class="cell-left"></div>
									<div flex="main:justify" class="cell-wrapper">
										<div class="title">一键开门</div>
										<div class="value"></div>
									</div>
									<div class="cell-right">
										<i class="icon iconfont icon-pt"></i>
									</div>
								</div>
							</a> --%>
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