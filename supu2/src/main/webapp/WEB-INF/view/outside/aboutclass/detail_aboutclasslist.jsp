<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>速扑运动</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_lqw37te7tmjnstt9.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/style1500628681675.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.36209059df2d810eeb6536a3cc0e274d.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/yk_jichuTuankeDetail.css"/>
</head>
<body>


<div id="app">
    <div class="wrap">
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
        <div data-v-a8d8e73a="" class="classDetail-box">
            <div data-v-a8d8e73a="" flex="main:center cross:center" class="loding-mask" style="display: none;">
                <div data-v-a8d8e73a="" class="loding-box">
                    <div data-v-05c5a342="" data-v-a8d8e73a="" flex="main:center cross:center" class="logding-box">
                        <span data-v-05c5a342="" class="spinner">
                            <div class="mint-spinner-snake" style="border-top-color: rgb(250, 74, 17); border-left-color: rgb(250, 74, 17); border-bottom-color: rgb(250, 74, 17); height: 22px; width: 22px;"></div>
                        </span>
                    </div>
                </div>
            </div>
        <div data-v-a8d8e73a="" class="classDetail-container">
            <div data-v-6030a3e6="" data-v-a8d8e73a="" class="le-head-img-box">
                <div data-v-6030a3e6="" class="swiper-container head-swipe swiper-container-horizontal">
                    <div class="swiper-wrapper">
                        <div data-v-6030a3e6="" class="swiper-slide swiper-slide-active">
                            <img data-v-6030a3e6="" src="${courseExcGroup.courseimg }" class="swipe-image">
                        </div>
        <!--         <div data-v-6030a3e6="" class="swiper-slide swiper-slide-next" style="width: 375px;">
                            <img data-v-6030a3e6="" src="https://img.leoao.com/o_1bi09uk93ekfblp1pmfkd4k7kc.jpg" class="swipe-image">
                        </div>
                        <div data-v-6030a3e6="" class="swiper-slide" style="width: 375px;">
                            <img data-v-6030a3e6="" src="https://img.leoao.com/o_1bi09ubr5smhe281jkc8vn1kf0c.jpg" class="swipe-image">
                        </div>
                        <div data-v-6030a3e6="" class="swiper-slide" style="width: 375px;">
                            <img data-v-6030a3e6="" src="https://img.leoao.com/o_1bi09u42n1i6l1efuqje1ldr1e81c.jpg" class="swipe-image">
                        </div> -->
                    </div>
                    <!-- <div data-v-6030a3e6="" class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets">
                        <span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span>
                        <span class="swiper-pagination-bullet"></span>
                        <span class="swiper-pagination-bullet"></span>
                        <span class="swiper-pagination-bullet"></span>
                    </div> -->
                </div>
            </div>
            <div data-v-a8d8e73a="" class="main">
                <div data-v-de444692="" data-v-a8d8e73a="" flex="main:justify cross:center" class="rater-box boder-1px-bottom">
                    <div data-v-de444692="">
                        <div data-v-de444692="" class="title">${courseExcGroup.coursename }</div>
                        <div data-v-de444692="" class="rater">
                            <div data-v-12e22524="" data-v-de444692="" class="le-rater">
                                <a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 5px; font-size: 14px; width: 14px; height: 14px; line-height: 14px;">
                                    <span data-v-12e22524="" class="le-rater-inner">
                                        <i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 14px; line-height: 14px;"></i>
                                    </span>
                                </a>
                                <a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 5px; font-size: 14px; width: 14px; height: 14px; line-height: 14px;">
                                    <span data-v-12e22524="" class="le-rater-inner">
                                        <i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 14px; line-height: 14px;"></i>
                                    </span>
                                </a>
                                <a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 5px; font-size: 14px; width: 14px; height: 14px; line-height: 14px;">
                                    <span data-v-12e22524="" class="le-rater-inner">
                                        <i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 14px; line-height: 14px;"></i>
                                    </span>
                                </a>
                                <a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 5px; font-size: 14px; width: 14px; height: 14px; line-height: 14px;">
                                    <span data-v-12e22524="" class="le-rater-inner">
                                        <i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 14px; line-height: 14px;"></i>
                                    </span>
                                </a>
                                <a data-v-12e22524="" class="le-rater-box" style="color: rgb(253, 172, 58); margin-right: 5px; font-size: 14px; width: 14px; height: 14px; line-height: 14px;">
                                    <span data-v-12e22524="" class="le-rater-inner">
                                        <i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 14px; line-height: 14px;"></i>
                                    </span>
                                </a>
                            </div>
                          <!--   <span data-v-de444692="" class="comments-num">评价186</span>
                            <span data-v-de444692="" class="class-num">参课66166人</span> -->
                        </div>
                  <!--       <div data-v-de444692="" class="tag-list">
                            <div data-v-de444692="" class="tag-item consume-num">
                                <span data-v-de444692="">480</span>KCal</div>
                            <div data-v-de444692="" class="tag-item">全身</div>
                            <div data-v-de444692="" class="tag-item">舞蹈</div>
                            <div data-v-de444692="" class="tag-item">中等难度</div>
                            <div data-v-de444692="" class="tag-item">动感</div>
                        </div> -->
                    </div>
                    <div data-v-de444692=""></div>
                </div>
                <div data-v-56e2b5a2="" data-v-a8d8e73a="" class="box-list">
                    <a data-v-56e2b5a2="" href="#/mapview?lat=32.071392&amp;lng=118.773575&amp;address=%E9%A9%AC%E5%8F%B0%E8%A1%9799%E5%8F%B7%E5%9F%8E%E5%B8%82%E9%9B%86%E5%B8%82%E4%B8%89%E6%A5%BC301&amp;name=%E9%A9%AC%E5%8F%B0%E8%A1%97%E5%BA%97" class="">
                        <div data-v-56e2b5a2="" class="place-box">
                            <div data-v-56e2b5a2="" class="box-info">
                                <p data-v-56e2b5a2=""><fmt:formatDate value="${date}" pattern="yyyy.MM.dd" /> ${courseExcGroup.starthour }:${courseExcGroup.startmin }-${courseExcGroup.endhour }:${courseExcGroup.endmin }</p>
                                <p data-v-56e2b5a2="">${store.storename } ${store.address }</p>
                            </div>
                        <!--     <div data-v-56e2b5a2="" class="box-location">
                                <i data-v-56e2b5a2="" class="icon iconfont icon-icon_weizhi"></i>
                            </div> -->
                        </div>
                    </a>
                    <form id="form">
                    	<input type="hidden" name="appointtime" value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />"></input>
						<input type="hidden" name="starttime" value="${courseExcGroup.starthour }:${courseExcGroup.startmin }"></input>
						<input type="hidden" name="endtime" value="${courseExcGroup.endhour }:${courseExcGroup.endmin }"></input>
						<input type="hidden" name="courseid" value="${courseExcGroup.id }"></input>
						<input type="hidden" name="storeid" value="${store.storeId }"></input>
                    </form>
                </div>
                <c:forEach items="${coachs }" var="items">
					<div data-v-0f1f5c21="" data-v-a8d8e73a="" flex="dir:left box:last" class="coach-info-box coach-info">
	                <div data-v-0f1f5c21="" class="coach-info">
	                    <p data-v-0f1f5c21="" class="coach-name">${items.nickname }</p>
	                    <p data-v-0f1f5c21="" class="coach-intro clamp-2">
	                        ${items.goodat }
	                    </p>
	                    <div data-v-0f1f5c21="" class="getMore">
	                        <!-- <i data-v-0f1f5c21="" class="iconfont icon-xiangshangsanjiaoshouqi"></i> -->
	                    </div>
	                </div>
	                <div data-v-0f1f5c21="" class="coach-img">
	                    <img data-v-0f1f5c21="" src="${items.image}">
	                </div>
            </div>
			</c:forEach>

            </div>
            <div data-v-a8d8e73a="" class="le-fiche class-main">
                <!-- <header data-v-a8d8e73a="" class="le-fiche-header le-fiche-class-about">课程介绍</header> -->
        <div data-v-a8d8e73a="" class="le-fiche-content">
           <!--  <div data-v-42228a9e="" data-v-a8d8e73a="" class="graph-list">
                <div data-v-42228a9e="" class="graph-item"><div data-v-42228a9e="" class="graph-name">协调</div>
                    <div data-v-42228a9e="" class="graph-value">6</div>
                    <div data-v-42228a9e="" class="graph-line">
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 202, 52), rgb(253, 163, 42));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 163, 42), rgb(254, 177, 44));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(254, 177, 44), rgb(253, 140, 38));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 140, 38), rgb(253, 152, 40));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 152, 40), rgb(253, 115, 34));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 115, 34), rgb(253, 128, 36));"></div>
                    </div>
                </div>
                <div data-v-42228a9e="" class="graph-item"><div data-v-42228a9e="" class="graph-name">力量</div>
                    <div data-v-42228a9e="" class="graph-value">4</div>
                    <div data-v-42228a9e="" class="graph-line">
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 202, 52), rgb(253, 163, 42));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 163, 42), rgb(254, 177, 44));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(254, 177, 44), rgb(253, 140, 38));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 140, 38), rgb(253, 152, 40));"></div>
                    </div>
                </div>
                <div data-v-42228a9e="" class="graph-item">
                    <div data-v-42228a9e="" class="graph-name">消耗</div>
                    <div data-v-42228a9e="" class="graph-value">6</div>
                    <div data-v-42228a9e="" class="graph-line">
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 202, 52), rgb(253, 163, 42));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 163, 42), rgb(254, 177, 44));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(254, 177, 44), rgb(253, 140, 38));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 140, 38), rgb(253, 152, 40));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 152, 40), rgb(253, 115, 34));"></div>
                        <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 115, 34), rgb(253, 128, 36));"></div>
                        </div></div><div data-v-42228a9e="" class="graph-item"><div data-v-42228a9e="" class="graph-name">柔韧</div> <div data-v-42228a9e="" class="graph-value">2</div>
                         <div data-v-42228a9e="" class="graph-line"><div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 202, 52), rgb(253, 163, 42));"></div><div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 163, 42), rgb(254, 177, 44));"></div>
                         </div></div><div data-v-42228a9e="" class="graph-item"><div data-v-42228a9e="" class="graph-name">心肺
                         </div> <div data-v-42228a9e="" class="graph-value">6</div> <div data-v-42228a9e="" class="graph-line">
                         <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 202, 52), rgb(253, 163, 42));"></div>
                         <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 163, 42), rgb(254, 177, 44));"></div>
                         <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(254, 177, 44), rgb(253, 140, 38));"></div>
                         <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 140, 38), rgb(253, 152, 40));"></div>
                         <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 152, 40), rgb(253, 115, 34));"></div>
                         <div data-v-42228a9e="" class="graph-block" style="background-image: linear-gradient(90deg, rgb(253, 115, 34), rgb(253, 128, 36));"></div>
                         </div></div> <p data-v-42228a9e="" class="graph-exp">数值越大，代表该维度的锻炼效果越强</p></div> -->
                        <div data-v-a8d8e73a="" class="class-content"><p style="line-height: 1.5em;"><span style="font-size: 18px; color: rgb(0, 0, 0);">
                        <strong>课程简介</strong></span></p><p style="line-height: 1.5em;">
                        ${courseExcGroup.coursedetail }
<!--                         <span style="font-size: 14px; color: rgb(89, 89, 89);">莱美王牌课程~会走路就会跳舞！教练会分解动作保证大家跟上节奏~左右换步伸手踢腿，在这里随心所欲，尽情释放自己的热情！</span></p>
                        <p style="line-height: 1.5em;"><span style="font-family: 微软雅黑, " microsoft="" font-size:="" color:=""><br></span></p>
                        <p style="line-height: 1.5em;"><span style="font-family: 微软雅黑, " microsoft="" font-size:="" color:="">&nbsp;</span></p><p style="line-height: 1.5em;">
                        <span style="color: rgb(0, 0, 0); font-size: 18px;"><strong>训练效果</strong></span>
                        <span style="color: rgb(63, 63, 63);"><strong><span style="color: rgb(63, 63, 63); font-family: 微软雅黑, " microsoft="" font-size:=""></span></strong>
                        </span></p><p style="line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">该课程可消耗大量卡路里。轻松减脂以外还能释放日常压力，愉悦身心。每周1次课程，坚持1个月就能看到自己的改变。</span></p><p style="line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">&nbsp;</span></p><p style="line-height: 1.5em;"><span style="font-size: 18px; color: rgb(0, 0, 0);"><strong><br></strong></span></p><p style="line-height: 1.5em;"><span style="color: rgb(0, 0, 0);"><span style="color: rgb(63, 63, 63); font-size: 18px;"><strong>适合人群</strong></span><span style="color: rgb(63, 63, 63);"><strong><span style="color: rgb(63, 63, 63);" microsoft="" font-size:=""></span></strong>
                        </span></span></p><p style="line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">适合任何年龄、任何健身水平的人参加。孕妇和有心血管疾病等基础病的患者不宜参加。</span></p><p><br></p><p style="line-height: 1.5em;"><span style="color: rgb(63, 63, 63);"><strong><span style="color: rgb(63, 63, 63); font-family: 微软雅黑, " microsoft="" font-size:="">&nbsp;</span></strong><strong><span style="color: rgb(63, 63, 63); font-family: 微软雅黑, " microsoft="" font-size:=""></span></strong></span></p><p style="line-height: 1.5em;"><span style="font-size: 18px;"><span style="color: rgb(0, 0, 0);"><strong>注意事项</strong></span><span style="color: rgb(63, 63, 63);"><strong>
                        <span style="color: rgb(63, 63, 63);" microsoft="" font-size:=""></span></strong></span></span>
                        <span style="color: rgb(63, 63, 63);"><strong><span style="color: rgb(63, 63, 63); font-family: 微软雅黑, " microsoft="" font-size:=""></span>
                        </strong></span></p><p style="line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">1.&nbsp;运动装备：穿运动鞋，舒适、透气的运动服或任何自己喜欢的方便舞蹈的衣服参与锻炼。课程无道具。</span></p><p style="line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">2.&nbsp;饮食：课前不能有饱腹感、饥饿感，课中准备充足水分的补充，少量多次饮用。</span></p><p style="line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">3.&nbsp;本店不提供淋浴。运动后至少隔30分钟再洗澡最佳。</span></p><p style="line-height: 1.5em;"><span style="font-family: 微软雅黑, " microsoft="" font-size:="" color:="">&nbsp;</span>
                        </p><p style="line-height: 1.5em;"><span style="font-size: 18px; color: rgb(0, 0, 0);"><br></span></p><p style="line-height: 1.5em;"><span style="font-size: 18px; color: rgb(0, 0, 0);"></span></p><p style="white-space: normal; line-height: 1.5em;"><span style="color: rgb(0, 0, 0);"><span style="font-size: 18px;"><strong>常见问题</strong></span></span></p><p style="white-space: normal; line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">Q:舞蹈难不难，跟不上怎么办？</span></p><p style="white-space: normal; line-height: 1.5em;"><span style="font-size: 14px; color: rgb(89, 89, 89);">A:舞蹈动作不复杂，是一些简单的舞蹈动作组合，会在一首歌中不断重复。跟不上所有动作的时候可以选择从身体的某个部位开始去舞动，尝试把自己的身体交给音乐和当下的氛围，重复一段时间你就会得心应手。</span></p><p><br></p> -->
                        </div>
         <!--                <div data-v-a8d8e73a="" class="le-fiche class-step">
                        <header data-v-a8d8e73a="" flex="main:justify cross:center" class="le-fiche-header">
                        <div data-v-a8d8e73a="">约课流程</div>
                         <div data-v-a8d8e73a="" class="step-detail"><span data-v-a8d8e73a="" class="text">详情</span>
                         <i data-v-a8d8e73a="" class="iconfont icon-right"></i>
                         </div></header> <img data-v-a8d8e73a="" src="https://cdn.leoao.com/m/img/classStep.jpeg"></div> -->


                         </div></div>

<!--             <div data-v-a8d8e73a="" class="le-fiche class-main">
                <div data-v-a8d8e73a="" class="class-comment">
<header data-v-a8d8e73a="" class="le-fiche-header">
    学员评价
</header>
        <div data-v-a8d8e73a="" class="tag-list">
            <div data-v-a8d8e73a="" class="tag-item">
                效果显著
                <span data-v-a8d8e73a="" class="tag-num">73</span>
            </div>
            <div data-v-a8d8e73a="" class="tag-item">
                气氛活跃
                <span data-v-a8d8e73a="" class="tag-num">60</span>
            </div>
            <div data-v-a8d8e73a="" class="tag-item">
                Get新技能
                <span data-v-a8d8e73a="" class="tag-num">56</span>
            </div>
        </div>
    </div>

        <div data-v-a8d8e73a="" class="le-fiche-content">
            <div data-v-731413ca="" data-v-a8d8e73a="" class="comment-box boder-1px-top">
                <div data-v-731413ca="" class="comment-header"><div data-v-731413ca="" class="header-person"><div data-v-731413ca="" class="header-head"><img data-v-731413ca="" src="https://img.leoao.com/wx_avatar_14985594821022?imageView2/2/w/150" alt="" class="head-img"></div> <div data-v-731413ca="" class="header-think"><div data-v-731413ca="" class="header-name">小*</div> <div data-v-12e22524="" data-v-731413ca="" class="le-rater"><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a></div></div></div> <div data-v-731413ca="" class="header-info"><div data-v-731413ca="">2017.8.7 16:42</div> <div data-v-731413ca="">马台街店</div></div></div> <div data-v-731413ca="" class="comment-content">
    每周必上的课
</div></div>
            <div data-v-731413ca="" data-v-a8d8e73a="" class="comment-box boder-1px-top">
                <div data-v-731413ca="" class="comment-header"><div data-v-731413ca="" class="header-person"><div data-v-731413ca="" class="header-head"><img data-v-731413ca="" src="https://tfs.alipayobjects.com/images/partner/T1CPVzXc0bXXXXXXXX?imageView2/2/w/150" alt="" class="head-img"></div> <div data-v-731413ca="" class="header-think"><div data-v-731413ca="" class="header-name">凛*</div> <div data-v-12e22524="" data-v-731413ca="" class="le-rater"><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box" style="color: rgb(204, 204, 204); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i> <span data-v-12e22524="" class="le-rater-outer" style="color: rgb(253, 172, 58); width: 50%;"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></span></a></div></div></div> <div data-v-731413ca="" class="header-info"><div data-v-731413ca="">2017.7.30 18:54</div> <div data-v-731413ca="">马台街店</div></div></div> <div data-v-731413ca="" class="comment-content">
    流了一身汗挺开心的 强度也刚刚好w
</div></div>
            <div data-v-731413ca="" data-v-a8d8e73a="" class="comment-box boder-1px-top">
                <div data-v-731413ca="" class="comment-header"><div data-v-731413ca="" class="header-person"><div data-v-731413ca="" class="header-head"><img data-v-731413ca="" src="https://tfs.alipayobjects.com/images/partner/T1RSRdXfd7XXXXXXXX?imageView2/2/w/150" alt="" class="head-img"></div> <div data-v-731413ca="" class="header-think"><div data-v-731413ca="" class="header-name">*三*</div> <div data-v-12e22524="" data-v-731413ca="" class="le-rater"><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box is-active" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a><a data-v-12e22524="" class="le-rater-box" style="color: rgb(253, 172, 58); margin-right: 4px; font-size: 13px; width: 13px; height: 13px; line-height: 13px;"><span data-v-12e22524="" class="le-rater-inner"><i data-v-12e22524="" class="iconfont icon-wujiaoxingshixin" style="font-size: 13px; line-height: 13px;"></i></span></a></div></div></div> <div data-v-731413ca="" class="header-info"><div data-v-731413ca="">2017.7.30 17:22</div> <div data-v-731413ca="">马台街店</div></div></div> <div data-v-731413ca="" class="comment-content">
    教练是个可爱的小妞，热情。
</div></div>
        </div>
    </div> -->
    
              
            
           
            
            
            
        
    
    
            <div data-v-a8d8e73a="" class="class-box">
                <div data-v-a8d8e73a="" flex="dir:left box:justify cross:center" class="box-message">
                    <div data-v-a8d8e73a="" class="box-status">
                        <div data-v-a8d8e73a="" class="status-text"><!---->
                        <c:if test="${isOpen }">
                        	<c:if test="${queueStatus.queueStatus==1 }"><span data-v-a8d8e73a="">预约</span></c:if>
							<c:if test="${queueStatus.queueStatus==2 }"><span data-v-a8d8e73a="">已约满</span></c:if>
							<c:if test="${queueStatus.queueStatus==4 }"><span data-v-a8d8e73a="">排队</span></c:if>
                            <span data-v-a8d8e73a="">${queueStatus.people } /
	                            <c:choose>
	                            	<c:when test="${queueStatus.appointcount>queueStatus.people  }">
										${queueStatus.people }
	                            	</c:when>
	                            	<c:otherwise>
										${queueStatus.appointcount }
	                            	</c:otherwise>
	                            </c:choose>
               				</span>
               			</c:if>
                        </div>
                        <div data-v-a8d8e73a="" class="status-progress">
                            <div data-v-a8d8e73a="" class="progress-cur" style="width: 100%;"></div>
                        </div>
                    </div>
                    <div data-v-a8d8e73a="" class="box-option">
                    <c:choose>
  					 <c:when test="${isOpen }">
   							<c:if test="${queueStatus.queueStatus==1 }"><button type="button" class="mint-button option-btn mint-button--primary mint-button--large REQueue" data-id="1"><label class="mint-button-text">预约</label></button></c:if>
							<c:if test="${queueStatus.queueStatus==2 }"><button type="button" class="mint-button option-btn mint-button--primary mint-button--large REQueue" data-id="2"><label class="mint-button-text">排队</label></button></c:if>
			 				<c:if test="${queueStatus.queueStatus==4 }"><button type="button" class="mint-button option-btn mint-button--primary mint-button--large REQueue" data-id="4"><label class="mint-button-text">排队</label></button></c:if>
   					</c:when>
   					<c:otherwise>
						<button type="button" class="mint-button option-btn mint-button--primary mint-button--large" data-id="4"><label class="mint-button-text">未开放</label></button>
   				    </c:otherwise>
				  </c:choose>

                    </div>
                </div>
            </div>
    
            
            
            
            
            
            
            <div data-v-a8d8e73a="" style="height: 137px;"></div>
            <div data-v-222004fa="" data-v-a8d8e73a="" class="option-card" style="display: none">
                <div data-v-222004fa="" class="card-close"><i data-v-222004fa="" class="icon iconfont icon-icclose48px"></i></div>
                <div data-v-222004fa="" class="card-container"><div data-v-222004fa="" class="card-title">
                约课规则
            </div> <!----> <!----> <!----> <!----> <!----> <div data-v-222004fa="" class="card-list card-rule"><div data-v-222004fa="" class="rule-list"><div data-v-222004fa="" class="rule-item"><div data-v-222004fa="" class="rule-title">
                状态
            </div> <div data-v-222004fa="" class="rule-text"><p data-v-222004fa="">约课：每天中午11:00开放预约，团操课程提前2天开放</p><p data-v-222004fa="">举个例子：今天周一11:00可预约周三各门店全天课程</p></div></div>
            <div data-v-222004fa="" class="rule-item"><div data-v-222004fa="" class="rule-title">
                排队
            </div> <div data-v-222004fa="" class="rule-text"><p data-v-222004fa="">约满排队：当堂课名额已满，若预约成功的人取消课程，我们会按照排队先后顺序通知上课</p>
            <p data-v-222004fa="">排队提醒：排队成功会在微信公众号［速扑运动健身］发送排队成功提醒</p></div></div>

   <!--          <div data-v-222004fa="" class="rule-item"><div data-v-222004fa="" class="rule-title">
                签到 </div>
                 <div data-v-222004fa="" class="rule-text">
                 <p data-v-222004fa="">上课签到：上课前或下课后15分钟内需在速扑运动健身APP或微信扫一扫课程签到</p>
                 <p data-v-222004fa="">签到失败：因特殊原因导致课程签到失败，可在门店联系店长工作人员说明签到失败情况进行补签</p>
                 </div></div> -->



                 <div data-v-222004fa="" class="rule-item"><div data-v-222004fa="" class="rule-title">
                旷课
            </div> <div data-v-222004fa="" class="rule-text"><p data-v-222004fa="">旷课限制：因个人原因没能上课，旷课一周不能超过2次</p><p data-v-222004fa="">旷课影响：旷课2次及以上下周只！能！约！课！一！次!</p></div></div></div></div></div></div>
        </div>
    </div>
        <div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed outTabBar">
            <a class="mint-tab-item"><div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">约课</div>
            </a>
            <a class="mint-tab-item boder-1px-left"><div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">购买</div>
            </a>
            <a class="mint-tab-item boder-1px-left"><div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">我的课程</div>
            </a>
            <a class="mint-tab-item boder-1px-left">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">个人中心</div>
            </a>
        </div>

    </div>
</div>

<!--弹出层-->
 <div class="mask queuemask" style="display:none;"></div>
<div id="alertquenen" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title">操作失败</div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message" id="errorMassage">请先购买会员卡！</div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
            <button class="mint-msgbox-btn mint-msgbox-cancel " style="">取消</button>
            <button class="mint-msgbox-btn mint-msgbox-confirm " onclick="window.location='<%=request.getContextPath()%>/outside/buyCard/listPage'">去购买</button>
        </div>
    </div>
</div>

<!--弹出层-->
<div  class="mask succfal" style="display:none;"></div>
<div id="alertquenen_succfal" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="alertMassage"></div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message"></div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
        	<button class="mint-msgbox-btn mint-msgbox-cancel ">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel " style="">取消</button>
        </div>
    </div>
</div>


<!--弹出层-->
<div  class="mask success" style="display:none;"></div>
<div id="alertquenen_success" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="successMassage"></div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message"></div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
        	<button class="mint-msgbox-btn mint-msgbox-cancel " id="clicklocation">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel " style="">取消</button>
        </div>
    </div>
</div>


<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/swiper.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/aboutclass/detail_aboutclasslist.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>
    /* $(".swiper-container").swiper({
        loop: true,
        autoplay: 3000
    }); */

    $(function(){
        //点击“详情”弹出层
        $(function() {
            $(".step-detail").click(function() {
                $(".option-card").show()
            });
            $(".card-close").click(function() {
                $(".option-card").hide()
            })
        });

        //  提示弹窗
        $(function() {
          /*   $(".box-option").click(function() {
                $(".mint-msgbox-wrapper").show();
                $(".mask").show();
            }); */
            $(".mint-msgbox-cancel,.mask").click(function() {
                $(".mint-msgbox-wrapper").hide();
                $(".mask").hide();
            })
        })

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
    })
</script>


</body>
</html>