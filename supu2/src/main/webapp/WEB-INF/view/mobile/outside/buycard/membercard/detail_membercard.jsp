<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN"  >
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>会员卡</title>
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/js/layer/need/layer.css">
		<style type="text/css">
			.map-store-item {
				padding: .15rem 0;
				border-top: 1px solid #eee
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
				color: #FF0000;
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
				color: #FF0000
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
				background: #FF0000;
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
				color: #FF0000;
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
				background: #FF0000;
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
				background: #FF0000;
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
				color: #FF0000
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
				color: #FF0000
			}

			.le-check-item-container a {
				color: #FF0000
			}

			.le-check-item-mt-popup.mint-popup {
				background: rgba(0, 0, 0, .3);
				width: 100%;
				min-height: 100%;
				z-index: 10
			}

			.le-check-item-mt-popup.mint-popup .rule {
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
				border-radius: 6px
			}

			.le-check-item-mt-popup.mint-popup .rule h5 {
				font-size: .18rem;
				color: rgba(0, 0, 0, .8);
				font-weight: 400;
				margin-bottom: .2rem
			}

			.le-check-item-mt-popup.mint-popup .rule .rule-text {
				color: rgba(0, 0, 0, .6);
				text-align: left;
				max-height: 2rem;
				overflow: auto
			}

			.le-check-item-mt-popup.mint-popup .rule .btn {
				display: inline-block;
				height: .35rem;
				margin: .3rem auto 0;
				line-height: .35rem;
				padding: 0 .35rem;
				font-size: .15rem;
				text-align: center;
				border-radius: 3px;
				background: #FF0000;
				color: #fff
			}
		</style>
	</head>

	<body style="overflow: initial;">
		<div id="app" style="height: 100%; overflow: initial;">
			<div class="wrap">
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div>
						<button class="mint-button le-city-btn mint-button--default mint-button--normal">
                <label class="mint-button-text">
                    <div class="city-selector"><i class="icon iconfont icon-icon_didian_x"></i>
                        <small class="cur-address">南京市</small>
                        <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i>
                    </div>
                </label>
            </button>
					</div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div class="le-buy-detail">
					<div flex="main:center cross:center" class="loding-mask" style="display: none;">
						<div class="loding-box">
							<div flex="main:center cross:center" class="logding-box">
								<span class="spinner">
                            <div class="mint-spinner-snake" style="border-top-color: rgb(250, 74, 17); border-left-color: rgb(250, 74, 17); border-bottom-color: rgb(250, 74, 17); height: 22px; width: 22px;"></div>
                        </span>
							</div>
						</div>
					</div>
					<div class="le-buy-header">
						<div class="le-buy-header-img">
							<img width="100%" src="${mCard.mcardimg }">
						</div>
						<h3 class="name">${mCard.membername }</h3>
						<p class="info">${mCard.proinfo }</p>
					</div>
					<div class="store-address boder-1px-top">
						<%-- <div flex="main:justify cross:center" class="heading boder-1px-bottom">
							<div>适用门店(共${count }家)</div>
							<div class="more">
								<i class="iconfont icon-navbar_icon_menu"></i>
							</div>
						</div> --%>
						<div flex="main:justify cross:center" class="body boder-1px-bottom">
							<div class="name"><span id="neareststorename"></span>
								<small id="nearestdistance"></small>
								<div class="address one-single-file"></div>
							</div>
							<div flex="main:justify cross:center" class="range">
								<span>
                            <a href="#/mapview?lat=32.071392&amp;lng=118.773575&amp;name=%E9%A9%AC%E5%8F%B0%E8%A1%97%E5%BA%97&amp;address=%E9%A9%AC%E5%8F%B0%E8%A1%9799%E5%8F%B7%E5%9F%8E%E5%B8%82%E9%9B%86%E5%B8%82%E4%B8%89%E6%A5%BC301" class="">
                                <i class="iconfont icon-icon_weizhi le-font-color-black"></i>
                            </a>
                        </span>
							</div>
						</div>
					</div>
					<div class="mint-popup mint-popup mint-popup-right" style="display: none;"></div>
					<div class="mint-popup mint-popup mint-popup-right" style="display: none">
						<div class="map-store-items">
							<div id="sideBarMap-container" class="le-container le-container-sideBarMap">
								<%-- <div class="title">门店列表</div>
								<div class="sort">
									<div class="sort-header">
										<div class="sort-title">筛选</div>
										<div class="sort-num">共<span data-v-7dc3a35e="">${count }</span>家</div>
									</div>
									<!--<div class="sort-btn">所有门店 <span class="arrow-down"></span></div>-->
								</div> --%>
								<div class="le-store-items">

									<c:forEach items="${storeList }" var="items">
										<div flex="dir:left box:justify cross:center" class="map-store-item">
											<div class="left">
												<div class="left-img" style="background-image: url('<%=request.getContextPath()%>/assets/images/md1.jpg');"></div>
											</div>
											<div class="center">
												<h3 class="name">${items.storename }</h3>
												<p class="address clamp-2">${items.province}${items.city}${items.region}${items.address}</p>
											</div>
											<a href="#/mapview?lat=32.023228&amp;lng=118.787086&amp;name=%E5%8D%97%E4%BA%AC%E5%B8%82%E7%A7%A6%E6%B7%AE%E5%8C%BA%E5%81%A5%E5%BA%B7%E8%B7%AF3%E5%8F%B74%E6%A5%BC&amp;address=%E5%8D%97%E4%BA%AC%E5%B8%82%E7%A7%A6%E6%B7%AE%E5%8C%BA%E5%81%A5%E5%BA%B7%E8%B7%AF3%E5%8F%B74%E6%A5%BC" class="">
												<div class="right">
													<div>
														<span style="display: none;">km</span>
														<i class="icon iconfont icon-icon_weizhi"></i>
													</div>
												</div>
											</a>
										</div>
									</c:forEach>

								</div>
								<div class="sideBarMap-close">
									<i class="icon iconfont icon-icclose48px"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="mask" style="display: none;"></div>
					<div class="le-panel">
						<div class="le-panel-heading">会员权益</div>

					 <div class="le-panel-body le-panel-buy-body le-font-color-black-3 le-font-size-13">
					 ${mCard.memberrights }

						</div>
					</div>
					<div class="le-buy-box boder-1px-top">
					    <div flex="dir:left box:justify main:center cross:center">
							<input id="agreementCbx" type="checkbox" >
						    <a href="<%=request.getContextPath()%>/outside/personal/membershipagreement">
							   <div> 我已阅读并同意《速扑会员协议》</div>
							 </a>
					     </div>
					    <div style="height: 0.1rem;"></div>
						<div flex="dir:left box:mean cross:center">
							<div class="left">
								<small>
                            		<small >总计 </small>
								</small>
								<small>￥</small>
								<span class="buy-price">${mCard.amountmoney}</span>
							</div>
							<a href="<%=request.getContextPath()%>/outside/personal/buyMcard?mCardId=${mCard.id}" onclick="return isCheck()">
								<div class="right">购买</div>
							</a>
						</div>
					</div>
					<div style="height: 0.85rem;"></div>
				</div>

			</div>
		</div>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/membercard/detail_membercard.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/layer/layer.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<iframe id="geoPage" width=0 height=0 frameborder=0  style="display:none;" scrolling="no"
    src="https://apis.map.qq.com/tools/geolocation?key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp">
</iframe>
		<script>
			$(function() {
				$(".more").click(function() {
					$(".mint-popup").show();
				});
				$(".sideBarMap-close").click(function() {
					$(".mint-popup").hide();
				})
			})
			
			function isCheck(){
				if($("input[type='checkbox']").prop("checked")){
					return true;
				}else{
				    layer.open({
						content: '请先阅读并同意《速扑会员协议》'
					    ,skin: 'msg'
				        ,time: 3 //2秒后自动关闭

				     });
         
					return false;
				}
				
			}
		</script>
	</body>

</html>

