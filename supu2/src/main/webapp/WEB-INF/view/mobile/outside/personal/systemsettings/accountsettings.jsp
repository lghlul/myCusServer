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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_lqw37te7tmjnstt9.css">
		<style type="text/css">
		
			.mint-msgbox-btn{
				line-height: 35px;
			    display: block;
			    background-color: #fff;
			    -webkit-box-flex: 1;
			    -ms-flex: 1;
			    flex: 1;
			    margin: 0;
			    border: 0;
			}
			.le-loading {
				display: inline-block;
				opacity: .8;
				-webkit-animation: leLoading 1s infinite;
				animation: leLoading 1s infinite;
				-webkit-transform: rotate(60deg);
				transform: rotate(60deg)
			}
			.mask{top:0}
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

			.le-container {
				padding: .25rem
			}

			.contactNum {
				font-size: .15rem;
				color: rgba(0, 0, 0, .3)
			}

			.logOut {
				width: 92%;
				margin: .24rem auto
			}
			.mint-msgbox-content {
			    padding: 10px 20px 15px;
			    border-bottom: 1px solid #ddd;
			    min-height: 36px;
			    position: relative;
			}
			.mint-msgbox-cancel{
				width: 50%;
			}
			
			
		</style>
	</head>

	<body style="overflow: initial;">
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

<%-- 					<a href="<%=request.getContextPath()%>/outside/personal/updateaccount_first">
					<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom" value="13915982076 点击修改">
						<div class="cell-left"></div>
						<div flex="main:justify" class="cell-wrapper">
							<div class="title">手机修改</div>
							<div class="value"></div>
						</div>
						<div class="cell-right">
							<i class="iconfont icon-jiantou_right"></i> </div>
					</div>
					</a> --%>
					<%-- <a href="<%=request.getContextPath()%>/findpasswd/firststep"> --%>
					<a id="cancleBind">
					<div flex="dir:left box:justify cross:center" class="le-cell boder-1px-bottom" value="点击修改">
						<div class="cell-left"></div>
						<div flex="main:justify" class="cell-wrapper">
							<div class="title">解除绑定</div>
							<div class="value"></div>
						</div>
						<div class="cell-right">
							<i class="iconfont icon-jiantou_right"></i> </div>
					</div>
					</a>
				</div>
				<%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
		<!-- 		<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
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
		
				<!--弹出层-->
<div  class="mask model" style="display:none;"></div>
<div id="alertquenen" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013;display: none; ">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="errorMassage">操作成功</div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message"></div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
        	<button id="sureCalBind" class="mint-msgbox-btn mint-msgbox-cancel"  style="border-right: 1px solid #ddd;height: 40px;">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel" style="border-left: 1px solid #ddd;height: 40px;">取消</button>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#cancleBind").click(function() {
		$('#errorMassage').text("");
		$('#errorMassage').text('是否确认解除绑定！');

		$('#alertquenen').show();
		$('.model').show();
		
	});
	$("#sureCalBind").click(function() {
		window.location.href="/outside/personal/cancleBind";
	});
	/**
	 * 隐藏弹出层
	 */
	$('.mint-msgbox-cancel').click(function(){
		$('#alertquenen').hide();
		$('.model').hide();

	});
})
</script>

	</body>

</html>