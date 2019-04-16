<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>速扑健身</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<style type="text/css">
			.h50 {
				height: 50px
			}

			.coupon-item .selected-slot {
				margin-top: -.5em
			}

			.coupon-item .icon-icon_notselected {
				color: rgba(0, 0, 0, .1);
				font-size: .2rem
			}

			.coupon-item .selected-slot.active .icon-icon_notselected,
			.icon-icon_notselected.active {
				color: #FF0000
			}

			.mint-popup {
				width: 100%;
				min-height: 100%;
				z-index: 10;
				background: transparent
			}

			.mint-popup .popupVisible-main {
				background-color: #fff;
				position: absolute;
				left: 0;
				top: 0;
				right: 0;
				bottom: 0;
				overflow: auto
			}

			.mint-popup .popupVisible-main .map-store-item:first-child {
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

			.mask.right {
				text-align: right
			}

			.le-container-cashier {
				padding: .1rem .25rem .25rem
			}

			.le-container-cashier-panel {
				padding: 0 .1rem
			}

			.le-container-cashier-panel .le-panel-heading {
				font-size: .16rem;
				margin-top: 0;
				font-weight: 400
			}

			.le-panel .le-panel-body {
				padding: 0 0 0 .12rem
			}

			.le-cashier-price {
				font-family: DIN-Medium;
				font-size: .2rem;
				font-weight: 400;
				color: #FF0000
			}

			.le-cashier-price small {
				font-size: .13rem
			}

			.le-cashier-payment .payment.active,
			.le-cashier-payment .payment {
				padding: .12rem 0
			}

			.le-cashier-payment .payment.active .icon-icon_notselected {
				color: #FF0000
			}

			.le-cashier-payment .payment.boder-1px-top:before {
				left: 0
			}

			.le-cashier-payment .payment.boder-1px-top:first-child:before {
				border: none
			}

			.le-cashier-payment .logo {
				margin: 0 .12rem
			}

			.le-cashier-payment .name {
				font-size: .14rem;
				color: rgba(0, 0, 0, .8);
				margin-bottom: .03rem;
				font-weight: 400
			}

			.le-cashier-payment .label {
				color: rgba(0, 0, 0, .3)
			}

			.le-cashier-btn {
				position: fixed;
				left: 0;
				right: 0;
				bottom: 0;
				padding: .25rem
			}

			.couponDataNum {
				font-size: .16rem;
				color: #FF0000
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
		</style>
	</head>

	<body>
		<div id="app">
			<div class="wrap">
				<div class="le-container">
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
					<!---->
					<div class="le-container-cashier">
						<div flex="dir:left box:justify cross:center" class="le-cell padding-right boder-1px-bottom">
							<div class="cell-left"></div>
							<div flex="main:justify" class="cell-wrapper">
								<div class="title">课程名称</div>
								<div class="value">${course.coursename }</div>
							</div>
							<div class="cell-right">
								<!---->
								<!---->
							</div>
						</div>
				<!-- 		<div flex="dir:left box:justify cross:center" class="le-cell coupon boder-1px-bottom">
							<div class="cell-left"></div>
							<div flex="main:justify" class="cell-wrapper">
								<div class="title">选择优惠券</div>
								<div class="value"><span class="couponDataNum">0 张可用</span>

								</div>
							</div>
							<div class="cell-right">


							</div>
						</div> -->
						<div flex="dir:left box:justify cross:center" class="le-cell padding-right boder-1px-bottom">
							<div class="cell-left"></div>
							<div flex="main:justify" class="cell-wrapper">
								<div class="title">支付金额</div>
								<div class="value">
									<div class="le-cashier-price"><small >￥</small>${course.courseamount}</div>
								</div>
							</div>
							<div class="cell-right">
								<!---->
								<!---->
							</div>
						</div>
					</div>

					<div class="le-container-cashier-panel">
						<div class="le-panel le-cashier-payment">
							<div class="le-panel-heading">选择支付方式</div>
							<div class="le-panel-body">
								<div flex="dir:left cross:center" class="payment boder-1px-top active">
									<div >
										<span >
                                    <i class="iconfont icon-icon_notselected"></i>
                                </span></div>
									<div >
										<img width="30px" height="30px" src="<%=request.getContextPath()%>/assets/images/outside/wxfk.png" class="logo">
									</div>
									<div >
										<h3 class="name">微信</h3>
										<p class="label"></p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="le-cashier-btn">
						<button class="mint-button mint-button--primary mint-button--large">
                    <label class="mint-button-text">确认支付</label>
                </button>
					</div>
					<div class="mask" style="display:none;"></div>
				</div>
			</div>
		</div>

<!-- 		<div class="mint-msgbox-wrapper" style="position: absolute; z-index: 2003; display: none;">
			<div class="mint-msgbox" style="display:block;">
				<div class="mint-msgbox-header">
					<div class="mint-msgbox-title">确认要放弃支付吗?</div>
				</div>
				<div class="mint-msgbox-content">
					<div class="mint-msgbox-message"> </div>
					<div class="mint-msgbox-input" style="display: none;">
						<input placeholder="" type="text">
						<div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
					</div>
				</div>
				<div class="mint-msgbox-btns">
					<button class="mint-msgbox-btn mint-msgbox-cancel " style="">去意已决</button>
					<button class="mint-msgbox-btn mint-msgbox-confirm " onclick="window.location='gm_jingpinTuanke.html'">我再想想</button>
				</div>
			</div>
		</div> -->


		<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
		<!--弹出层的js-->
		<script>
			/* $(function() {
				$(".le-cashier-btn").click(function() {
					$(".mint-msgbox-wrapper").show();
					$(".mask").show();
				});
				$(".mint-msgbox-cancel,.mask").click(function() {
					$(".mint-msgbox-wrapper").hide();
					$(".mask").hide();
				})
			}) */
		</script>
	</body>

</html>