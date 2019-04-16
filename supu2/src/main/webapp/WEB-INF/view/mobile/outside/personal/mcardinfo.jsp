<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>速扑运动</title>
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

			.icon-navbar_icon_menu {
				font-size: .2rem
			}

			.le-container {
				padding-bottom: .3rem
			}

			.mint-popup {
				width: 100%;
				min-height: 100%;
				z-index: 10;
				background: transparent
			}

			.mint-popup .map-store-items {
				background-color: #f2f2f2;
				padding: .12rem 0;
				position: absolute;
				left: 20%;
				top: 0;
				right: 0;
				bottom: 0;
				overflow: auto
			}

			.mint-popup .map-store-items .map-store-item:first-child {
				margin-top: 0
			}

			.mint-popup .popupVisible-close {
				position: absolute;
				left: 0;
				top: 0;
				right: 80%;
				bottom: 0
			}

			.popup-mask.mask {
				background: rgba(0, 0, 0, .6);
				z-index: 9
			}

			.rights-container {
				position: relative
			}

			.mask {
				opacity: .8;
				background-image: linear-gradient(0deg, #000, #414141);
				z-index: 0
			}

			.header {
				position: relative;
				text-align: center;
				font-size: .27rem;
				padding: .45rem .24rem .24rem;
				background: url(<%=request.getContextPath()%>/assets/images/outside/CombinedShape.png) no-repeat top;
				background-size: 100% auto
			}

			.header h3 {
				margin-top: .12rem
			}

			.header .head-img {
				width: .6rem;
				height: .6rem;
				margin: 0 auto
			}

			.header .head-img img {
				width: .55rem
			}

			.cardRights-count {
				color: #ff4e00;
				display: inline-block
			}

			.card-rights-tag {
				font-size: .12rem;
				color: rgba(0, 0, 0, .6);
				margin-top: .05rem
			}

			.main {
				position: relative;
				padding: .25rem
			}

			.footer {
				padding: 0 .25rem
			}

			.le-fiche-header {
				font-size: .18rem;
				background: #fff;
				color: #333;
				padding: 0;
				font-weight: 700;
				margin-top: 0
			}

			.le-fiche .le-fiche-content {
				padding: .1rem 0 .05rem
			}

			.le-fiche-content {
				background: #fff;
				color: rgba(0, 0, 0, .6)
			}

			.le-fiche-foot {
				margin-top: .12rem;
				background: #fff;
				color: #000
			}

			.map-store-item {
				padding: .15rem 0;
				border-top: 1px solid #eee;
				padding-left: .15rem;
			}

			.map-store-item .left {
				padding-right: .12rem
			}

			.map-store-item .left .left-img {
				width: .638rem;
				height: .638rem;
				border-radius: 4px;
				background-position: 50%;
				background-size: cover
			}

			.map-store-item .center {
				padding-right: .2rem
			}

			.map-store-item .center .name {
				font-size: .15rem;
				color: #000;
				margin-bottom: .03rem;
				font-weight: 400;
				text-overflow: ellipsis;
				white-space: nowrap;
				overflow: hidden
			}

			.map-store-item .center .address {
				font-size: .12rem;
				color: rgba(0, 0, 0, .6)
			}

			.map-store-item .right {
				font-size: .12rem;
				color: rgba(0, 0, 0, .3)
			}

			.map-store-item .right .iconfont {
				color: #000;
				font-size: .2rem;
				margin-left: .01rem
			}

			.mint-popup {
				width: 100%;
				min-height: 100%;
				z-index: 10;
				background: transparent
			}

			.mint-popup .map-store-items {
				background-color: #fff;
				position: absolute;
				left: 0;
				top: 0;
				right: 0;
				bottom: 0;
				overflow: auto;
				-webkit-overflow-scrolling: touch
			}

			.mint-popup .map-store-items .map-store-item:first-child {
				margin-top: 0
			}

			.mint-popup .popupVisible-close {
				position: absolute;
				left: 0;
				top: 0;
				right: 80%;
				bottom: 0
			}

			.mask {
				background: rgba(0, 0, 0, .6)
			}

			.le-buy-detail {
				font-size: .14rem
			}

			.le-buy-detail .store-address {
				background: #fff;
				margin: 0 .15rem
			}

			.le-buy-detail .store-address .activity {
				padding: .15rem 0;
				color: rgba(0, 0, 0, .6)
			}

			.le-buy-detail .store-address .activity>div:first-of-type {
				color: #ff4e00;
				width: 3rem
			}

			.le-buy-detail .store-address .activity .icon-wenhao {
				color: rgba(0, 0, 0, .6);
				position: relative
			}

			.le-buy-detail .store-address .activity .icon-icon_notselected {
				font-size: .2rem;
				color: #ddd;
				position: relative
			}

			.le-buy-detail .store-address .activity .icon-icon_notselected.active {
				color: #ff4e00
			}

			.le-buy-detail .store-address .activity .mint-popup {
				background: rgba(0, 0, 0, .3)
			}

			.le-buy-detail .store-address .activity .rule {
				text-align: center;
				width: 3.15rem;
				padding: .2rem .3rem .3rem;
				margin: 0 auto;
				box-sizing: border-box;
				min-height: 0;
				position: absolute;
				background-color: #fff;
				top: 50%;
				left: 50%;
				-webkit-transform: translate(-50%, -50%);
				transform: translate(-50%, -50%);
				border-radius: .06rem
			}

			.le-buy-detail .store-address .activity .rule h5 {
				font-size: .18rem;
				color: #000;
				font-weight: 400;
				margin-bottom: .2rem
			}

			.le-buy-detail .store-address .activity .rule .p {
				font-size: .12rem;
				color: rgba(0, 0, 0, .6)
			}

			.le-buy-detail .store-address .activity .rule .yes {
				line-height: .37rem;
				height: .37rem;
				background: #ff4e00;
				color: #fff;
				width: 1.3rem;
				text-align: center;
				border: none;
				outline: none;
				text-decoration: none;
				margin: 0 auto;
				margin-top: .3rem;
				border-radius: .03rem
			}

			.le-buy-detail .store-address .heading {
				padding: .15rem 0
			}

			.le-buy-detail .store-address .heading .more {
				color: #000
			}

			.le-buy-detail .store-address .heading .more .iconfont {
				font-size: .2rem;
				position: relative;
				top: -.02rem
			}

			.le-buy-detail .store-address .body {
				padding: .15rem 0
			}

			.le-buy-detail .store-address .body .name small {
				color: rgba(0, 0, 0, .3)
			}

			.le-buy-detail .store-address .body .address {
				margin-top: .07rem;
				color: rgba(0, 0, 0, .6);
				font-size: .12rem
			}

			.le-buy-detail .store-address .body .range {
				color: #ff4e00;
				font-size: .12rem
			}

			.le-buy-detail .store-address .body .range .iconfont {
				font-size: .2rem;
				position: relative
			}

			.le-buy-detail .le-buy-box {
				position: fixed;
				left: 0;
				right: 0;
				bottom: 0;
				background: #fff;
				text-align: center;
				box-sizing: border-box;
				padding: .1rem .15rem
			}

			.le-buy-detail .le-buy-box .left {
				line-height: .4rem;
				font-family: PingFangSC-Medium;
				font-size: .2rem;
				color: #000
			}

			.le-buy-detail .le-buy-box .right {
				margin-left: .15rem;
				line-height: .4rem;
				background: #ff4e00;
				color: #fff;
				font-size: .16rem;
				border-radius: 3px
			}

			.le-buy-detail .le-buy-box .buy-price {
				font-family: DIN-Medium;
				font-size: .26rem
			}

			.le-buy-header {
				background: #fff url(https://cdn.leoao.com/img/Group%2034@2x.png) no-repeat;
				background-size: contain;
				padding: .25rem .15rem
			}

			.le-buy-header .le-buy-header-img {
				padding: .1rem .2rem .3rem
			}

			.le-buy-header .le-buy-header-img img {
				box-shadow: 0 10px 10px 0 rgba(0, 0, 0, .1);
				border-radius: .12rem
			}

			.le-buy-header .name {
				font-size: .23rem;
				color: #000;
				margin: .06rem 0 .07rem
			}

			.le-buy-header .info {
				font-size: .13rem;
				color: rgba(0, 0, 0, .3)
			}

			.le-panel-buy-body .left {
				padding-right: .12rem;
				border-right: 1px solid rgba(0, 0, 0, .1)
			}

			.le-panel-buy-body .right {
				margin-left: .12rem
			}

			.le-panel-buy-body .right .icon-bianjix {
				font-size: .2rem;
				padding: 0 .12rem
			}

			.le-panel-buy-body .info {
				font-size: .16rem;
				color: rgba(0, 0, 0, .8)
			}

			.le-panel-buy-body .address {
				font-size: .13rem;
				color: rgba(0, 0, 0, .6);
				margin-top: .07rem
			}

			.popup-exp.mint-popup {
				background-color: rgba(0, 0, 0, .3)
			}

			.popup-exp .wrap {
				width: 100%;
				background: #fff;
				position: absolute;
				bottom: 0;
				left: 0
			}

			.popup-exp .wrap .le-buy-panel .right .item.action {
				color: #fff
			}

			.popup-exp .wrap .coach-head {
				height: .65rem;
				padding-top: .12rem;
				box-sizing: border-box
			}

			.popup-exp .wrap .coach-head p {
				width: .75rem;
				height: .75rem;
				position: absolute;
				top: -.2rem;
				left: .14rem;
				display: table-cell;
				vertical-align: middle;
				line-height: .75rem;
				text-align: center;
				background: #fff;
				border: 3px solid #fff
			}

			.popup-exp .wrap .coach-head p img {
				width: 100%
			}

			.popup-exp .wrap .coach-head h5 {
				font-size: .16rem;
				color: rgba(0, 0, 0, .8);
				font-weight: 400;
				padding-left: 1.1rem;
				float: left
			}

			.popup-exp .wrap .coach-head .icon-fr {
				float: right;
				margin-right: .12rem;
				position: relative;
				top: -5px
			}

			.popup-exp .wrap .coach-head .icon-fr .icon {
				font-size: .22rem;
				color: rgba(0, 0, 0, .6)
			}

			.popup-exp .wrap .address {
				width: 3.5rem;
				box-sizing: border-box;
				margin: 0 auto;
				margin-top: .06rem;
				background: rgba(0, 0, 0, .04);
				font-size: .12rem;
				color: rgba(0, 0, 0, .6);
				padding: .05rem .12rem
			}

			.popup-exp .wrap .address .iconfont {
				font-size: .12rem;
				color: rgba(0, 0, 0, .3)
			}

			.popup-exp .wrap .certain {
				line-height: .44rem;
				height: .44;
				background: #ff4e00;
				color: #fff;
				width: 100%;
				text-align: center;
				border: none;
				outline: none;
				text-decoration: none;
				margin: 0 auto;
				font-size: .16rem
			}

			.popup-exp .wrap .le-buy-panel {
				padding: .12rem 0;
				background: #f2f2f2
			}

			.custom-tab-container-fixed .mint-tab-container-item {
				top: 38px
			}

			.le-container-sideBarMap {
				position: absolute;
				top: 0;
				left: 0;
				right: 0;
				bottom: 0;
				padding: .275rem;
				box-sizing: border-box;
				overflow: auto
			}

			.le-container-sideBarMap .custom-tab-container-fixed .mint-tab-container-item,
			.le-container-sideBarMap .le-custom-navbar-fixed {
				position: absolute
			}

			.le-custom-navbar-fixed {
				top: 0
			}

			.title {
				font-size: .286rem;
				font-weight: 700
			}

			.sort {
				margin-top: .275rem
			}

			.sort .sort-header {
				display: -webkit-box;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: justify;
				-ms-flex-pack: justify;
				justify-content: space-between;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center
			}

			.sort .sort-header .sort-title {
				font-size: .198rem;
				font-weight: 700
			}

			.sort .sort-header .sort-num {
				font-size: .132rem
			}

			.sort .sort-header .sort-num span {
				color: #fd5a28
			}

			.sort .sort-btn {
				display: -webkit-box;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: justify;
				-ms-flex-pack: justify;
				justify-content: space-between;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center;
				width: 100%;
				box-sizing: border-box;
				padding: .11rem .165rem;
				background-color: #f2f2f2;
				font-size: .154rem;
				border-radius: 4px;
				margin: .165rem 0
			}

			.sort .sort-btn .arrow-down {
				height: 0;
				border-left: 5px solid transparent;
				border-right: 5px solid transparent;
				border-top: 5px solid #2f2f2f;
				font-size: 0;
				line-height: 0
			}

			.sideBarMap-close {
				position: absolute;
				top: .3rem;
				right: .15rem;
				width: .5rem;
				height: .5rem;
				display: -webkit-box;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: center;
				-ms-flex-pack: center;
				justify-content: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center
			}

			.sideBarMap-close .iconfont {
				position: absolute;
				font-size: .18rem;
				overflow: visible
			}

			.picker-mask {
				position: fixed;
				left: 0;
				top: 0;
				width: 100%;
				height: 100vh;
				background-color: rgba(0, 0, 0, .5)
			}

			@-webkit-keyframes hide-to-bottom {
				0% {
					bottom: 0
				}
				to {
					bottom: -5rem
				}
			}

			@keyframes hide-to-bottom {
				0% {
					bottom: 0
				}
				to {
					bottom: -5rem
				}
			}

			@-webkit-keyframes show-from-bottom {
				0% {
					bottom: -5rem
				}
				to {
					bottom: 0
				}
			}

			@keyframes show-from-bottom {
				0% {
					bottom: -5rem
				}
				to {
					bottom: 0
				}
			}

			.picker-hide {
				-webkit-animation: hide-to-bottom .3s;
				animation: hide-to-bottom .3s;
				-webkit-animation-fill-mode: forwards;
				animation-fill-mode: forwards
			}

			.picker-show {
				-webkit-animation: show-from-bottom .3s;
				animation: show-from-bottom .3s;
				-webkit-animation-fill-mode: forwards;
				animation-fill-mode: forwards
			}

			.store-picker {
				position: fixed;
				bottom: 0;
				left: 0;
				width: 100%;
				background-color: #fff;
				z-index: 100
			}

			.picker-list {
				display: -webkit-box;
				display: -ms-flexbox;
				display: flex;
				-webkit-box-pack: center;
				-ms-flex-pack: center;
				justify-content: center
			}

			.picker-header {
				font-size: .154rem;
				background-color: #f9f9f9;
				padding: .1rem .162rem
			}

			.picker-header .picker-cancel {
				color: rgba(0, 0, 0, .6)
			}

			.picker-header .picker-title {
				font-size: "PingFang-SC-Semibold";
				font-size: .198rem
			}

			.picker-header .picker-submit {
				color: #ff4e00
			}

			.le-check-item {
				padding: .15rem 0
			}

			.le-check-item .icon-icon_notselected {
				position: relative;
				font-size: .2rem;
				color: #ddd
			}

			.le-check-item .center {
				margin: 0 .06rem;
				color: rgba(0, 0, 0, .6)
			}

			.le-check-item .icon-wenhao {
				position: relative;
				font-size: .2rem;
				top: -.03rem;
				color: rgba(0, 0, 0, .6)
			}

			.le-check-item.selected .center,
			.le-check-item.selected .center a,
			.le-check-item.selected .icon-icon_notselected {
				color: #fa4a11
			}
		</style>
	</head>

	<body>
		<div id="app" style="height: 100%; overflow: initial;">
			<div class="wrap">
				<!---->
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div><button class="mint-button le-city-btn mint-button--default mint-button--normal"><!----> <label class="mint-button-text"><div class="city-selector"><i class="icon iconfont icon-icon_didian_x"></i> <small class="cur-address">南京市</small> <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i></div></label></button></div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div  class="le-container rights-container">
					<div  class="header">
						<div  class="head-img"><img  src="${mCard.mcardimg}" style=""></div>
						<h3 >${mCard.membername}</h3>
						<div  class="card-rights-tag">
						<c:choose>
						   <c:when test="${isBuyCard }">
								已购买
						   </c:when>
						   <c:otherwise>
								  尚未购买
						   </c:otherwise>
						</c:choose>



						</div>
						<!---->
					</div>
					<div  class="main">
						<div  class="le-fiche">
							<header  class="le-fiche-header">
								会员卡介绍
							</header>
								${mCard.memberrights }
							<!-- div  class="le-fiche-content">
								<p><span style="font-family: 'Microsoft YaHei'; font-size: 14px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 习惯了健身房按年付费？习惯了一个人默默撸铁？是时候更新运动方式啦！这里不是健身房，这里是速扑！</span></p>
								<p><span style="font-family: 'Microsoft YaHei'; font-size: 14px;"> &nbsp; &nbsp;&nbsp; &nbsp;一月一付更自由： 99元/月，上百节趣味团操课程免费预约。在专业教练指导下，你将爱上大汗淋漓的感觉，轻松兑换好看又好用的身体！</span></p>
								<p><span style="font-family: 'Microsoft YaHei'; font-size: 14px;"> &nbsp; &nbsp;&nbsp; &nbsp;随时随地轻松健：速扑7*24小时不打烊，会员卡全城通用，您可以自由安排时间前往任何 门店锻炼</span></p>
							</div> -->
							<%-- <div  class="le-fiche-foot">
								<div   flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom boder-1px-top">
									<div  class="cell-left"></div>
									<div  flex="main:justify" class="cell-wrapper md">
										<div  class="title">适用门店(共${fn:length(storeList)}家)</div>
										<div  class="value"></div>
									</div>
									<div  class="cell-right">
										<!---->
										<!----><i   class="iconfont icon-navbar_icon_menu"></i></div>
								</div>
								<div   flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom">
									<div  class="cell-left"></div>
									<div  flex="main:justify" class="cell-wrapper kc">
<!-- 										<div  class="title">可约课程(共66节)</div>
 -->										<div  class="value"></div>
									</div>
									<div  class="cell-right">
										<!---->
										<!----><i   class="iconfont icon-navbar_icon_menu"></i></div>
								</div>
							</div> --%>
						</div>
					</div>
					<div  class="footer">
						<a  href="<%=request.getContextPath()%>/outside/personal/buyMcard?mCardId=${mCard.id }" class="">
							<button  class="mint-button mint-button--primary mint-button--large"><!---->
								<label class="mint-button-text">购买</label></button>
						</a>
						<!---->
					</div>



					<!--门店弹窗-->
					<div  class="mint-popup mint-popup mint-popup-right mdtc" style="display:none ;">
						<div  class="popupVisible-close"></div>
						<div  class="map-store-items">

								<c:forEach items="${storeList}" var="item" varStatus="status">
								<div   flex="dir:left box:justify cross:center" class="map-store-item">
									<div  class="left">
										<div  class="left-img" style="background-image:url(${item.storeimg });"></div>
									</div>
									<div  class="center">
										<h3  class="name">${item.storename }</h3>
										<p  class="address clamp-2">${item.province }-${item.city }-${item.region }${item.address }</p>
									</div>
									<a  href="#" class="">
										<div  class="right">
											<div ><span  style="display: none;">km</span> <i  class="icon iconfont icon-icon_weizhi"></i></div>
										</div>
									</a>
								</div>

								</c:forEach>
						<!-- 	<div   flex="dir:left box:justify cross:center" class="map-store-item">
								<div  class="left">
									<div  class="left-img" style="background-image:url(images/201707202140281500558049733.png);"></div>
								</div>
								<div  class="center">
									<h3  class="name">印象汇店</h3>
									<p  class="address clamp-2">南京市浦口区大桥北路58号印象汇1-2楼</p>
								</div>
								<a  href="#" class="">
									<div  class="right">
										<div ><span  style="display: none;">km</span> <i  class="icon iconfont icon-icon_weizhi"></i></div>
									</div>
								</a>
							</div> -->

					</div>
					</div>
					<!--课程弹窗-->
					<div  class="mint-popup mint-popup mint-popup-right kctc" style="display:none ;">
						<div  class="popupVisible-close"></div>
						<div  class="map-store-items">
							<a  class="mint-cell">
								<!---->
								<div class="mint-cell-left"></div>
								<div class="mint-cell-wrapper">
									<div class="mint-cell-title">
										<!----><span class="mint-cell-text">杠铃雕塑</span>
										<!---->
									</div>
									<div class="mint-cell-value"><span></span></div>
								</div>
								<div class="mint-cell-right"></div>
								<!---->
							</a>
							<a  class="mint-cell">
								<!---->
								<div class="mint-cell-left"></div>
								<div class="mint-cell-wrapper">
									<div class="mint-cell-title">
										<!----><span class="mint-cell-text">核心特训</span>
										<!---->
									</div>
									<div class="mint-cell-value"><span></span></div>
								</div>
								<div class="mint-cell-right"></div>
								<!---->
							</a>

						</div>
					</div>
					<div  class="mask popup-mask" style="display: none;"></div>
					<div  class="mask kc-mask" style="display: none;"></div>
				</div>
				</div>
		</div>


		<!--<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed outTabBar">
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
					<a class="mint-tab-item boder-1px-left is-selected" href="personal_center.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">个人中心</div>
					</a>
				</div>
		-->




<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
		<script>

			//门店弹出层
			$(function() {
				$(".md").click(function() {
					$(".mdtc").show();
					$(".popup-mask").show();
				});
				$(".mdtc .popupVisible-close").click(function() {
					$(".mdtc").hide();
					$(".popup-mask").hide();
				})
			});
			//课程弹出层
			$(function() {
				$(".kc").click(function() {
					$(".kctc").show();
					$(".kc-mask").show();
				});
				$(".kctc .popupVisible-close").click(function() {
					$(".kctc").hide();
					$(".kc-mask").hide();
				})
			});

</script>
	</body>

</html>