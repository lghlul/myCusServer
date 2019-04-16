<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN"  >
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>会员卡</title>
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<style>
			.wrap .tabbar {
    			height: auto;
			}
			.mint-navbar .mint-tab-item .mint-tab-item-label {
	
    margin-top: 5px;
    padding: 5px;
}
.mint-navbar.dark .is-selected .mint-tab-item-label {
    border: 1px solid #000;
    border-radius: 20px;
}
.mint-navbar .mint-tab-item.is-selected {
    border-bottom: 2px solid #fff;
}
.gold-card-membership{
	border-radius:10px;
}

		</style>
	</head>
	<body>
		<div id="app" style="height: 100%;">
			<div class="wrap isHeaderBar isTabBar">

				<header class="mint-header blur-box header-bar is-fixed inHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div>
						<button class="mint-button le-city-btn mint-button--default mint-button--normal">
							<label class="mint-button-text"><div class="city-selector"><img src="/assets/images/newui/gps.png" style="width: 11px;">&nbsp;<small class="cur-address">南京市</small> <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i></div></label></button></div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div>
					<div class="mint-navbar dark le-class-navbar-fixed">
						<a class="mint-tab-item is-selected">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label" style="line-height: 1; ">会员卡</div>
						</a>
						<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/buyCard/coursePriCoachPage">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label" style="line-height: 1; ">私教课</div>
						</a>
						<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/buyCard/courseGroupPage">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label" style="line-height: 1; ">训练营</div>
						</a>
						<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/buyCard/studioListPage">
							<div class="mint-tab-item-icon"></div>
							<div class="mint-tab-item-label" style="line-height: 1; ">工作室</div>
						</a>
					</div>
					<div>
						<div class="cb-list-main">
							<div flex="main:center cross:center" class="loding-mask" style="display: none;">
								<div class="loding-box">
									<div flex="main:center cross:center" class="logding-box">
										<span data-v-05c5a342="" class="spinner">
											<div class="mint-spinner-snake" style="border-top-color: rgb(250, 74, 17); border-left-color: rgb(250, 74, 17); border-bottom-color: rgb(250, 74, 17); height: 22px; width: 22px;"></div></span></div>
								</div>
							</div>
							<div class="le-class-items card-list" id="memberCardDiv">
								<%-- <a href="huiyuankaDetail.html">
									<div class="membership-card-item">
										<div class="item-contanier">
											<div class="item-img">
                                                <img src="<%=request.getContextPath()%>/assets/images/hyk2.png" class="gold-card-membership">
                                            </div>
											<div flex="dir:top main:center" class="item-content">
												<div class="item-content-title">健身月卡</div>
												<div class="item-content-subTitle">杭州/南京/济南 30天 x 24小时</div>
												<div class="item-content-price"><small>¥</small> <span class="price">99.00</span></div>
											</div>
										</div>
									</div>
								</a> --%>

							</div>

							<div span class class="mint-navbar option-tabbar option-tabbar-single tabbar-show">
								<!---->

								<aspan class class="mint-tab-item option-item is-selected">
									<div class="mint-tab-item-icon"></div>
									<!-- <div class="mint-tab-item-label hyk_sx">
										<spanspan class class="text-filter">筛选</span>
										<ispan class class="icon iconfont icon-filter"></i>
									</div> -->
								</a>
							</div>

							<!--筛选弹窗-->
							<div class="option-card hyk-card " style="display: none;">
	<div class="card-close hyk-close"><i class="icon iconfont icon-icclose48px"></i></div>
	<div class="card-container">
		<div class="card-title">
			筛选
		</div>
		<!---->
		<!---->
		<div class="card-filter">
			<div class="filter-list">
				<div class="mint-radiolist filter-checkbox"><label class="mint-radiolist-title">选择会员卡种类</label>
					<c:forEach items="${memberCardType }" var="item">
						<a class="mint-cell">
							<!---->
							<div class="mint-cell-left"></div>
							<div class="mint-cell-wrapper">
								<div class="mint-cell-title">
									<!----><label class="mint-radiolist-label"><span class="mint-radio"><input type="radio" class="mint-radio-input" value="${item.basicvalue }"> <span class="mint-radio-core"></span></span> <span class="mint-radio-label">${item.title }</span></label></div>
								<div class="mint-cell-value"><span></span></div>
							</div>
							<div class="mint-cell-right"></div>
							<!---->
						</a>
					</c:forEach>

				</div>
			</div>
			<div class="filter-btn">
				<div class="btn-group"><button type="button" class="mint-button btn-reset mint-button--default mint-button--normal"><!----> <label class="mint-button-text">重置</label></button> <button class="mint-button btn-submit mint-button--primary mint-button--normal"><!----> <label class="mint-button-text">确定</label></button></div>
			</div>
		</div>
		<!---->
		<!---->
		<!---->
	</div>
</div>
						</div>
					</div>
				</div>
			<%-- 	<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
					<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							约课
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left is-selected">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							购买
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="my_lesson.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							我的课程
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="personal_center.html">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							个人中心
						</div>
					</a>
				</div> --%>
					<%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
				<!---->

			</div>
		</div>


<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/membercard/membercardlist.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>

   //筛选弹窗
    $(function(){
        $(".hyk_sx").click(function(){
            $(".hyk-card").show();
        })
        $(".hyk-close").click(function(){
            $(".hyk-card").hide();
        })
    });


</script>
	</body>

</html>

