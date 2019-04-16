<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN"  >
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>基础团课</title>
		<meta content="email=no" name="format-detection">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<link href="<%=request.getContextPath()%>/assets/css/outside/star.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">

		<style type="text/css">
			.le-class-items{ display: none;}
			.wrap .tabbar{ height: auto;}
			.storeselect{
		        cursor:pointer
		    }
			.mint-tab-container-item.card-list.city-list .mint-cell{
		        cursor:pointer
		    }
		    #clickgrouplesson{
		    	cursor:pointer
		    }


			/*.stars {*/
				/*display: inline-block;*/
				/*background-image: url('../images/leoao-coach-mstar.png');*/
				/*background-repeat: no-repeat;*/
				/*background-position: 0 50%;*/
				/*background-size: 1.2rem;*/
				/*width: 1.2rem;*/
				/*height: 1.2rem;*/
			/*}*/
			/*.stars span {*/
				/*display: inline-block;*/
				/*background-image: url('../images/leoao-coach-mstar.png');*/
				/*background-repeat: no-repeat;*/
				/*background-position: 0 50%;*/
				/*background-size: 1.2rem;*/
				/*width: 1.2rem;*/
				/*height: 1.2rem;*/
			/*}*/

		</style>
	</head>
	<body style="overflow: hidden;">
		<div id="app" style="height: 100%; overflow: initial;">
			<div class="wrap isHeaderBar isTabBar">
				<!---->
				<form id="form" action="<%=request.getContextPath()%>/outside/aboutClass/courseGroupDetail" method="post">
				<input type="hidden" value="" name="id" id="id">
				<header class="mint-header blur-box header-bar is-fixed inHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div>
						<button type="button" type="button" class="mint-button le-city-btn mint-button--default mint-button--normal"><!---->
							<label class="mint-button-text">
								<div class="city-selector">
									<i class="icon iconfont icon-icon_didian_x"></i>
										<small class="cur-address" id="cityid"></small>
										<input type="hidden" value="" name="distance" id="distance">
										<input type="hidden" value="" name="storeId" id="storeId">
										<input type="hidden" value="" name="storeName" id="storeName">
<!-- 				 					 	<select id="select_store" class="form-control" name="storeId">


										</select> -->
                                   <i class="icon iconfont icon-xiangshangsanjiaoshouqi"></i>
                                </div>
                            </label>
                        </button>
                    </div>
					<h1 class="mint-header-title"></h1>
					<div class="mint-header-button is-right"></div>
				</header>
				<div >
					<div  class="head-fixed-select">
						<div  class="">
							<div  class="select-btn yk_select">
                                <span >基础团课</span>
                                <span >
                                    <i  class="icon iconfont icon-xiangshangsanjiaoshouqi"></i>
                                </span>
                                <span ></span>
                            </div>
						</div>
					</div>


					<!--基础团课弹窗-->

                    <div  class="option-card jctc" style="display: none">
                        <div class="card-close jc_close">
                            <i class="icon iconfont icon-icclose48px"></i>
                        </div>
                        <div class="card-container">
                            <div class="card-title">选择业务</div>
                            <div class="mint-tab-container-item card-list card-class">
                                <a class="mint-cell card-item action" href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper"><div class="mint-cell-title">
                                        <span class="mint-cell-text">基础团课</span>
                                    </div>
                                        <div class="mint-cell-value">
                                            <span></span>
                                        </div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a>
                                <a class="mint-cell card-item" href="<%=request.getContextPath()%>/outside/aboutClass/privatePage">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper">
                                        <div class="mint-cell-title">
                                            <span class="mint-cell-text">私教课</span>
                                        </div>
                                        <div class="mint-cell-value">
                                            <span></span>
                                        </div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a>
                            </div>
                        </div>
                    </div>

                   <!--加载loading-->
					<div >
						<div  class="cb-list-main">
							<div flex="main:center cross:center" class="loding-mask" style="display: none;">
								<div class="loding-box">
									<div flex="main:center cross:center" class="logding-box">
                                        <span class="spinner">
                                            <div class="mint-spinner-snake" style="border-top-color: rgb(250, 74, 17); border-left-color: rgb(250, 74, 17); border-bottom-color: rgb(250, 74, 17); height: 22px; width: 22px;"></div>
                                        </span>
                                    </div>
								</div>
							</div>

                        <!--tab-->
							<div class="weekTime dark le-class-navbar-fixed">
								<div class="mint-navbar dark weui_navbar">
									<c:forEach items="${weekAndDate }" var="items" varStatus="status">
 										<c:choose>
											<c:when test="${items.week=='今天'}">
												<a class="mint-tab-item  is-selected  changeDate" data-data="今天" data-id="${status.index }" data-date="${items.date }" data-week="${items.numWeek }">
													<div class="mint-tab-item-icon"></div>
													<div class="mint-tab-item-label">
														<p class="week">
															<!---->${items.week }</p>
														<p class="day">${items.simpleDate }</p>
														<input type="hidden" value="${items.date }" name="date" id="getSelectDate">
														<input type="hidden" value="${items.numWeek }" name="week" id="getSelectWeek">
														<input type="hidden" value="0" name="signType" id="getSign">
													</div>
												</a>
											</c:when>
											<c:otherwise>
												<a class="mint-tab-item changeDate" data-data="周${items.week }" data-id="${status.index }" data-date="${items.date }" data-week="${items.numWeek }">
													<div class="mint-tab-item-icon"></div>
													<div class="mint-tab-item-label">
														<p class="week"><span class="preText">周</span>${items.week }</p>
														<p class="day">${items.simpleDate }</p>
													</div>
												</a>
			 								</c:otherwise>
										</c:choose>
									</c:forEach>
									<input type="hidden" value=""  id="biaojiinput">
									<input type="hidden" value="今天"  id="weekinput">
								</div>
							</div>
							</form>
							<div class="swiper-container le-class-swipe swiper-container-horizontal swiper-container-autoheight ">
								<div class="swiper-wrapper">
									<div class="le-class-items swiper-slide" style=" display:block;">
										<div>
											<div  id="today">

											</div>

<!-- 											<div class="empty-box" style="display: none;">
												<div ><img src="https://cdn.leoao.com/img/%E8%AF%BE%E7%A8%8B@2x.png" class="empty-img">
													<p class="empty-text">暂无课程 敬请期待</p>
												</div>
											</div> -->
											<div class="le-class-status">
												<!---->
												<!---->
											</div>
										</div>


									</div>
									<div class="le-class-items swiper-slide" >
										<div>
											<div  id="todaynextone">

											</div>

										</div>
									</div>
									<div class="le-class-items swiper-slide" >
									    <div>
									    	<div  id="todaynexttwo">

											</div>
										</div>
                                    </div>
									<div class="le-class-items swiper-slide ">
									    	<div  id="todaynextthree">

											</div>
                                    </div>
									<div class="le-class-items swiper-slide">
									    	<div  id="todaynextfour">

											</div>
                                    </div>
									<div class="le-class-items swiper-slide">
									    	<div  id="todaynextfive">

											</div>
                                    </div>
									<div class="le-class-items swiper-slide">
									    	<div  id="todaynextsix">

											</div>
                                    </div>
								</div>
							</div>

							<!---->
							<div style="height: 45px;"></div>
						</div>
					</div>
				</div>
			<%-- 	<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
					<a class="mint-tab-item is-selected">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">
							约课
						</div>
					</a>
					<a class="mint-tab-item boder-1px-left" href="<%=request.getContextPath()%>/outside/buyCard/listPage">
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

				<!-- 选择地址弹窗 -->
				<div data-v-222004fa="" class="option-card wd-address" style="display: none">
                    <div data-v-222004fa="" class="card-close ad-close">
                        <i data-v-222004fa="" class="icon iconfont icon-icclose48px"></i>
                    </div>
                    <div data-v-222004fa="" class="card-container">
                        <div data-v-222004fa="" class="card-title">地址</div>
                        <div data-v-222004fa="" class="list-contaner">
                            <div data-v-222004fa="" class="mint-tab-container-item card-list city-list" id="select_store">
<!--                                 <a data-v-222004fa="" class="mint-cell card-item">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper">
                                        <div class="mint-cell-title">
                                            <span class="mint-cell-text" id="storeselect" data-id="10">北京市</span>
                                        </div>
                                        <div class="mint-cell-value"><span></span></div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a> -->
<!--                                 <a data-v-222004fa="" class="mint-cell card-item">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper">
                                        <div class="mint-cell-title">
                                            <span class="mint-cell-text">上海市</span>
                                        </div>
                                        <div class="mint-cell-value"><span></span></div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a>
                                <a data-v-222004fa="" class="mint-cell card-item action">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper">
                                        <div class="mint-cell-title">
                                            <span class="mint-cell-text">南京市</span>
                                        </div>
                                        <div class="mint-cell-value"><span></span></div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a>
                                <a data-v-222004fa="" class="mint-cell card-item">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper">
                                        <div class="mint-cell-title">
                                            <span class="mint-cell-text">杭州市</span>
                                        </div>
                                        <div class="mint-cell-value"><span></span></div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a>
                                <a data-v-222004fa="" class="mint-cell card-item">
                                    <div class="mint-cell-left"></div>
                                    <div class="mint-cell-wrapper">
                                        <div class="mint-cell-title">
                                            <span class="mint-cell-text">济南市</span>
                                        </div>
                                        <div class="mint-cell-value"><span></span></div>
                                    </div>
                                    <div class="mint-cell-right"></div>
                                </a> -->
                            </div>
                        </div>
                    </div>
                </div>


				<!--排序弹窗-->
				<div class="option-card pxtc" style="display: none;">
	<div class="card-close px_close"><i class="icon iconfont icon-icclose48px"></i></div>
	<div class="card-container">
		<div class="card-title">
			排序
		</div>
		<div class="mint-tab-container-item card-list card-sort">
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-navbar_icon_position"></i> <span class="mint-cell-text">距离最近</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_shaixuan"></i> <span class="mint-cell-text">智能排序</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_pingjia"></i> <span class="mint-cell-text">评价最好</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item action">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_timedown"></i> <span class="mint-cell-text">从早到晚</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_timeup"></i> <span class="mint-cell-text">从晚到早</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_qiangduup"></i> <span class="mint-cell-text">强度递增</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_qiangdudown"></i> <span class="mint-cell-text">强度递减</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
			<a class="mint-cell card-item">
				<!---->
				<div class="mint-cell-left"></div>
				<div class="mint-cell-wrapper">
					<div class="mint-cell-title"><i class="icon iconfont icon-icon_heart"></i> <span class="mint-cell-text">关注优先</span>
						<!---->
					</div>
					<div class="mint-cell-value"><span></span></div>
				</div>
				<div class="mint-cell-right"></div>
				<!---->
			</a>
		</div>
		<!---->
		<!---->
		<!---->
		<!---->
		<!---->
	</div>
</div>


			<!--筛选弹窗-->
			<div class="option-card sxtc" style="display: none;">
	<div class="card-close sx_close"><i class="icon iconfont icon-icclose48px"></i></div>
	<div class="card-container">
		<div class="card-title">
			筛选
		</div>
		<!---->
		<div class="card-filter">
			<div class="filter-list">
				<div class="mint-checklist filter-checkbox filter-type"><label class="mint-checklist-title">课程</label>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="1"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">瑜伽</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="2"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">踏板</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="5"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">舞蹈</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="6"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">杠铃</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="7"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">搏击</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="8"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">其他</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="24"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">单车</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
				</div>
				<div class="mint-checklist filter-checkbox filter-purpose"><label class="mint-checklist-title">目的</label>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="8"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">增肌塑形</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="18"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">轻松减脂</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="19"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">新人必修课</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="20"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">放松减压</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
					<a class="mint-cell">
						<!---->
						<div class="mint-cell-left"></div>
						<div class="mint-cell-wrapper">
							<div class="mint-cell-title">
								<!----><label class="mint-checklist-label"><span class="mint-checkbox"><input type="checkbox" class="mint-checkbox-input" value="21"> <span class="mint-checkbox-core"></span></span> <span class="mint-checkbox-label">进阶课程</span></label></div>
							<div class="mint-cell-value"><span></span></div>
						</div>
						<div class="mint-cell-right"></div>
						<!---->
					</a>
				</div>
			</div>
			<div class="filter-btn">
				<div class="btn-group"><button class="mint-button btn-reset mint-button--default mint-button--normal"><!----> <label class="mint-button-text">重置</label></button> <button class="mint-button btn-submit mint-button--primary mint-button--normal"><!----> <label class="mint-button-text">确定</label></button></div>
			</div>
		</div>
		<!---->
		<!---->
		<!---->
		<!---->
	</div>
</div>

			</div>
		</div>


<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/aboutclass/aboutclasslist.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>
//tab页的切换
$(function(){
    $(".le-class-items").first().show();
    $(".mint-tab-item").click(function () {
        var index = $(".mint-tab-item").index(this);
        $(this).addClass("is-selected").siblings().removeClass("is-selected");
        $(".le-class-items").eq(index).show().siblings().hide();
    });
});
//业务选择“基础团课”“私教课”弹窗
$(function(){
    $(".yk_select").click(function(){
        $(".jctc").show();
    })
    $(".jc_close").click(function(){
        $(".jctc").hide();
    })
});

 //排序弹窗
$(function(){
    $(".px").click(function(){
        $(".pxtc").show();
    })
    $(".px_close").click(function(){
        $(".pxtc").hide();
    })
});
//筛选弹窗
$(function(){
    $(".sx").click(function(){
        $(".sxtc").show();
    })
    $(".sx_close").click(function(){
        $(".sxtc").hide();
    })
});
//点击 显示和影藏 “选择地区弹窗”
$(function(){
	$('.city-selector').click(function(){
		$(".wd-address").show();
	});
	$('.ad-close').click(function(){
		$(".wd-address").hide();
	});
});

 $(function(){
	 /* $('.mint-tab-container-item.card-list.city-list .mint-cell').eq(0).hasClass("action"); */
	//门店改变事件
	$(document).on('click','.mint-tab-container-item.card-list.city-list .mint-cell',function(){
		if(!$(this).hasClass("action")){
			$(this).addClass("action").siblings().removeClass("action");
			$(".wd-address").hide();
		}
	});


});
</script>
</body>

</html>

