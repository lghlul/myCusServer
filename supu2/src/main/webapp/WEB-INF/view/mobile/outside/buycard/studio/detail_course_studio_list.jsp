<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
	<head>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>工作室详情页</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
		<style type="text/css">
			.header-img{
				width: 100%;
				height: 2rem;
				background: no-repeat 50%;
				background-size: cover
			}

			.le-panel-heading{
				margin-top: 0
			}

			.header{
				box-sizing: border-box;
				background: #fff;
				padding: .25rem .15rem 0;
				margin-top: -2px
			}

			.header .title{
				font-size: .23rem;
				color: #000;
				margin-bottom: .05rem;
				font-weight: 700
			}

			.header .remain{
				height: .18rem;
				line-height: .18rem;
				border: 1px solid rgba(0, 0, 0, .6);
				border-radius: .09rem;
				padding: 0 .1rem
			}

			.header .lable[data-v-8d08845c],
			.header .remain{
				font-size: .12rem;
				color: rgba(0, 0, 0, .6)
			}

			.header .lable .iconfont{
				font-size: .12rem;
				color: rgba(0, 0, 0, .3)
			}

			.header .info{
				margin-top: .25rem
			}

			.header .info .lable{
				padding: .15rem 0
			}

			.header .info .lable .iconfont{
				margin-right: .06rem
			}

			.header .info .coach-info{
				padding-top: 0
			}

			.header .info .time{
				font-size: .154rem;
				color: #717171
			}

			.header .info .info-address{
				background-color: #f2f2f2;
				height: .26rem;
				line-height: .26rem;
				padding: 0 .1rem;
				border-radius: .55rem;
				font-size: .12rem;
				color: #686868;
				margin: .05rem 0
			}

			.header .info .info-address .icon-iconfont-position{
				color: #606060
			}

			.header .info .info-address .arrow-left{
				height: 0;
				border-bottom: 5px solid transparent;
				border-top: 5px solid transparent;
				border-left: 5px solid #2f2f2f;
				font-size: 0;
				line-height: 0
			}

			.header .info .info-address .one-single-file{
				white-space: nowrap;
				overflow: hidden;
				text-overflow: ellipsis
			}

			.le-buy-box{
				position: fixed;
				left: 0;
				right: 0;
				bottom: 0;
				display: -webkit-box;
				display: -ms-flexbox;
				display: flex;
				background-color: #fff;
				padding: .15rem
			}

			.le-buy-box .buy-info{
				color: #000;
				text-align: center;
				margin-right: .15rem
			}

			.le-buy-box .buy-info .price{
				display: inline-block;
				font-size: .2rem;
				font-family: DIN-Medium
			}

			.le-buy-box .buy-info .price small{
				font-size: .13rem
			}

			.le-buy-box .buy-info .num{
				font-size: .12rem
			}
			.coach-info-box{
				padding: .15rem 0;
				-webkit-box-pack: justify;
				-ms-flex-pack: justify;
				justify-content: space-between;
				-webkit-box-align: center;
				-ms-flex-align: center;
				align-items: center;
				width: 100%;
				border-bottom: 1px solid #f5f5f5
			}

			.coach-info-box .getMore{
				text-align: center;
				margin-top: .05rem
			}

			.coach-info-box .getMore .iconfont{
				font-size: .2rem;
				color: rgba(0, 0, 0, .6)
			}

			.coach-info-box .coach-name{
				font-size: .18rem;
				color: #000;
				margin-bottom: .06rem;
				font-weight: 700
			}

			.coach-info-box .coach-intro{
				font-size: .12rem;
				color: #6e6e6e;
				padding-right: .15rem
			}

			.coach-info-box .coach-img{
				width: .82rem;
				height: .82rem;
				text-align: center;
				background: #f2f2f2;
				border-radius: 50%;
				line-height: .82rem;
				color: rgba(0, 0, 0, .3);
				-ms-flex-item-align: start;
				align-self: flex-start
			}

			.coach-info-box .coach-img img{
				width: 100%;
				height: 100%;
				border-radius: 50%
			}
			.weui_article{ background-color: #fff;}
			.weui_article p{text-align:justify; color: #6e6e6e;}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="wrap">
				<header class="mint-header blur-box header-bar is-fixed outHeaderBar">
					<div class="mint-header-button is-left">
						<div class="blur"></div>
						<button class="mint-button le-city-btn mint-button--default mint-button--normal">
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
				<div class="le-container">

					<!--加载-->
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

					<div class="header-img" style="background-image: url('${courseExcGroup.courseimg }');"></div>
					<header class="header">
						<h3 class="title">${courseExcGroup.coursename }</h3>
						<div flex="dir:left main:justify">
							<!-- <div class="remain">仅剩6个名额</div> -->
						</div>
						<div class="info boder-1px-top">
							<div class="lable boder-1px-bottom">
							<p class="time">开课时间
							<c:forEach items="${TimeList }" var="items"  varStatus="status">
								<c:if test="${status.index==0 }">${items.year }-${items.month }-${items.day }&nbsp;</c:if>
							</c:forEach>
							<%-- 	${startDate } --%>
							</p>
		<%-- 					<input type="hidden" value="${startDate }" id="startDate">
							<input type="hidden" value="${endDate }" id="endDate"> --%>
							<input type="hidden" value="${courseExcGroup.id }" id="courseid">
							<p class="time">
<%-- 							<c:forEach items="${TimeList }" var="items"  varStatus="status">
								<c:set value="${fn:split(items.timelist, ',') }" var="str1" />
								<c:if test="${status.index==0 }">${items.year }-${items.month }-${items.day }&nbsp;</c:if>
								<c:forEach items="${str1 }" var="s">${s } <br /></c:forEach>
							</c:forEach> --%>
							</p>

								<a href="#/mapview?lat=32.071392&amp;lng=118.773575&amp;address=%E9%A9%AC%E5%8F%B0%E8%A1%97%E5%BA%97%E9%A9%AC%E5%8F%B0%E8%A1%9799%E5%8F%B7%E5%9F%8E%E5%B8%82%E9%9B%86%E5%B8%82%E4%B8%89%E6%A5%BC301&amp;name=%E9%A9%AC%E5%8F%B0%E8%A1%97%E5%BA%97%E9%A9%AC%E5%8F%B0%E8%A1%9799%E5%8F%B7%E5%9F%8E%E5%B8%82%E9%9B%86%E5%B8%82%E4%B8%89%E6%A5%BC301" class="">
									<div flex="dir:left box:justify cross:center" class="info-address">
										<i class="icon iconfont icon-iconfont-position"></i>
										<span class="one-single-file">${store.province}${store.city}${store.region}${store.address }</span>
										<!-- <span class="arrow-left"></span> -->
									</div>
								</a>
							</div>
							<div class="lable">
							<c:forEach items="${coachs }" var="items" >
 								<div flex="dir:left box:last" class="coach-info-box coach-info">
									<div class="coach-info">
										<p class="coach-name">${items.nickname }</p>
										<p class="coach-intro clamp-2">${items.goodat }</p>
										<!-- <div class="getMore"><i class="iconfont icon-xiangshangsanjiaoshouqi"></i></div> -->
									</div>
									<div class="coach-img">
										<img src="${items.image }">
										<!---->
									</div>
								</div>
							</c:forEach>
<%-- 								<div flex="dir:left box:last" class="coach-info-box coach-info">
									<div class="coach-info">
										<p class="coach-name">李一粒</p>
										<p class="coach-intro clamp-2">擅长：增肌减脂，平衡柔韧，局部塑形#国家职业资格认证#国家专业人员认证#国家二级运动员#Myptyoga认证</p>
										<div class="getMore"><i class="iconfont icon-xiangshangsanjiaoshouqi"></i></div>
									</div>
									<div class="coach-img">
										<img src="<%=request.getContextPath()%>/assets/images/sjtx.png">
										<!---->
									</div>
								</div> --%>
							</div>
						</div>
					</header>
					<div class="le-panel">
						<div class="le-panel-heading">工作室详情</div>

						<article class="weui_article">
								${courseExcGroup.coursedetail }
<%--
						   <img src="<%=request.getContextPath()%>/assets/images/lk.png" style="width:100%">
						           <h1>大标题</h1>
						        <h2 class="title">章标题</h2>
						          <h3>1.1 节标题</h3>
						          <p>速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑
						          	健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身</p>

						          <h3>1.2 节标题</h3>
						          <p>速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速
						          	扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速
						          	扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑
						          	健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速
						          	扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身速扑健身</p>
						          	--%>
						    </article>
					</div>
					<div flex="dir:left box:mean cross:center" class="le-buy-box boder-1px-top">
						<div class="buy-info">
							<div>
								<div class="price">
									<small>¥ </small>${courseExcGroup.courseamount}</div>
								<span class="num"> / 共${courseExcGroup.totalhours }课时</span>
							</div>
						</div>
						<a href="<%=request.getContextPath()%>/outside/personal/buyStudio?courseId=${courseExcGroup.id }">
							<div class="buy-btn" id="buyexccourse">
								<button class="mint-button mint-button--primary mint-button--large">
	                        		<label class="mint-button-text">购买</label>
	                    		</button>
							</div>
						</a>
					</div>
					<div style="height: 0.85rem;"></div>
				</div>
			</div>


			<!--失败弹出层-->
<div  class="mask failmask" style="display:none;"></div>
<div id="alertFail" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="errorMassage"></div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message"></div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
        	<button class="mint-msgbox-btn mint-msgbox-cancel btn_div" style="">确定</button>
        </div>
    </div>
</div>

		</div>


<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>

 <script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
		<script>
			//  折叠 展开
			$(".getmore").click(function() {
				var self = $(this).find(".iconfont");
				if(self.hasClass("icon-xiangshangsanjiaoshouqi")) {

					self.removeClass("icon-xiangshangsanjiaoshouqi").addClass("icon-xiangxiasanjiaoxialazhankai");

					$(this).siblings(".coach-intro").removeClass("clamp-2");
				} else {

					self.removeClass("icon-xiangxiasanjiaoxialazhankai").addClass("icon-xiangshangsanjiaoshouqi");

					$(this).siblings(".coach-intro").addClass("clamp-2");
				}
			});
		</script>
	</body>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/coursegroup/detail_course_studio_list.js"></script>
</html>