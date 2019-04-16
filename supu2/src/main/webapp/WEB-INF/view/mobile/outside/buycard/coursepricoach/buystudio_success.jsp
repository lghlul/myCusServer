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
			.le-container {
				text-align: center
			}

			.header {
				background: #fff;
				box-sizing: border-box;
				padding: .12rem 0 .24rem
			}

			.header img {
				margin: .24rem 0 .12rem
			}

			.header h3 {
				font-size: .17rem;
				color: rgba(0, 0, 0, .8);
				font-weight: 400;
				margin-bottom: .06rem
			}

			.header p {
				font-size: .15rem;
				color: rgba(0, 0, 0, .3);
				margin-bottom: .03rem
			}

			.btn {
				width: 94%;
				margin: .12rem auto 0
			}

			.ad {
				margin-top: .24rem
			}

			.payBearLuckImg {
				width: 100%;
				display: block;
				padding: .1rem 0;
				background: #f3f1f2;
				margin-top: .3rem
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="wrap">
				<!---->
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div><button class="mint-button le-city-btn mint-button--default mint-button--normal"><!----> <label class="mint-button-text"><div class="city-selector"><i class="icon iconfont icon-icon_didian_x"></i> <small class="cur-address">南京市</small> <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i></div></label></button></div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div class="le-container">
					<div class="header"><img width="40%" src="<%=request.getContextPath()%>/assets/images/outside/rr.png">
						<h3>支付成功</h3>
						<p>罗马不是一日建成的</p>
						<p>腹肌不是一日练成的！加油！</p>
					</div>
					<a href="<%=request.getContextPath()%>/outside/buyCard/studioListPage" class="">
						<button class="mint-button btn mint-button--primary mint-button--large">
							<label class="mint-button-text">确定</label></button>
					</a>

				</div>

			</div>
		</div>

		</script>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
	</body>

</html>