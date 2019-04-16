<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <title>私教课</title>
<!--    <link href="css/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">
   <link href="css/gm-sijiaoke.css" rel="stylesheet"> -->
   	<link href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/gm-sijiaoke.css">
   <style type="text/css">
   		/* .mint-tabbar{background-color: #fff; border-top: 1px solid #F2F2F2; padding: 1.5rem 0;}
		.mint-tabbar a{ padding: 0;}
		.mint-tab-item{border-left: 1px solid #F2F2F2;}
		.mint-tabbar>.mint-tab-item.is-selected{ background: none; color: #fa4a11;} */


		.mint-tabbar.bottom-tab-bar.boder-1px-top.tabbar.is-fixed.intTabBar{
    			width: 100%;
    			/* height: 4.5rem;
    			padding: 1.2rem 0; */
    			border-top: 1px solid #f2f2f2;
    			position: fixed;
    			bottom: 0;
    			left: 0;
    			z-index: 2;
    			background: #fff;
    			color: rgba(0, 0, 0, .6);
		}
		.mint-tab-item-label, .mint-tab-item-label a {
    		line-height: 2;
    		text-decoration: none;
		}
		.wrap .tabbar {
    			height: auto;
		}
		.bottom-tab-bar .mint-tab-item-label, .bottom-tab-bar .mint-tab-item-label a {
    			font-size: 15px;
		}
		.mint-tab-item.is-selected .mint-tab-item-label,
		.mint-tab-item.is-selected .mint-tab-item-label a {
    			color: #FF0000;
		}
		.mint-tabbar>.mint-tab-item.is-selected {
    			background-color: #fff;
		}
		.bottom-tab-bar .boder-1px-left:after {
    			height: 2.3rem;
    			top: 35%;
		}
		.boder-1px-left:after {
    			content: "";
    			position: absolute;
    			left: 0;
    			top: 25%;
    			bottom: 0;
    			width: 1px;
    			height: 100%;
    			border-left: 1px solid rgba(0, 0, 0, .1);
    			color: #d9d9d9;
    			-webkit-transform-origin: 0 0;
    			transform-origin: 0 0;
    			-webkit-transform: scaleY(.5);
    			transform: scaleY(.5);
		}
		.boder-1px-left {
    			position: relative;
		}
   </style>
</head>
<body>
	<div id="app">
    <div class="body-box">
        <div class="index main">
            <div id="map" class="position-btn clearfix text-center">
                <div class="one">
                    <img src="<%=request.getContextPath()%>/assets/images/outside/leoao-coach-mposition000.png" alt="">
                    <span class="fn-left">南京市<i></i></span>
                </div>
                <div class="two more"></div>
                <div class="three"></div>
            </div>

            <!--选择地区-->
            <div class="mask city-mask" style="display:none;">
                <div class="leoao-city">
                    <div class="city-text">
                        城市
                        <img src="<%=request.getContextPath()%>/assets/images/outside/leoao-coach-mxb00.png">
                    </div>
                    <div class="city-box"><div class="city">杭州市</div>
                        <div class="city">北京市</div>
                        <div class="city">上海市</div>
                        <div class="city active">南京市</div>
                        <div class="city">济南市</div>
                    </div>
                </div>
            </div>


            <div class="top-nav">
                <ul class="clearfix">
                    <li><a href="<%=request.getContextPath()%>/outside/buyCard/listPage">会员卡</a></li>
                    <li><span class="active">私教课</span></li>
                    <li><a href="<%=request.getContextPath()%>/outside/buyCard/courseGroupPage">训练营</a></li>
                    <li><a href="<%=request.getContextPath()%>/outside/buyCard/studioListPage">工作室</a></li>
                </ul></div>
            <%-- <div class="hot-box text-center">
                <div class="title">热门课程</div>
                <div class="sort">
                    <ul class="clearfix">
                        <li style="background-image: url('<%=request.getContextPath()%>/assets/images/outside/sj_1.png');"><div>减脂塑形</div></li>
                        <li style="background-image: url('<%=request.getContextPath()%>/assets/images/outside/sj_2.png');"><div>增肌</div></li>
                        <li style="background-image: url('<%=request.getContextPath()%>/assets/images/outside/sj_3.png');"><div>格斗</div></li>
                        <li style="background-image: url('<%=request.getContextPath()%>/assets/images/outside/sj_4.png');"><div>拉伸</div></li>
                        <li style="background-image: url('<%=request.getContextPath()%>/assets/images/outside/sj_5.png');"><div>康复</div></li>
                    </ul></div>
            </div> --%>
            <div class="sl-line"></div>

            <div class="title text-center swiper-title">当红人气王</div>
           <!--人气swiper-->
           <div class="swiper-container2 swiper-box swiper-container-horizontal">
                <div class="swiper-wrapper">

	                    <c:forEach items="${coach}" var="item" varStatus="status">

							<div class="swiper-slide swiper-slide-active" >
		                   <a href="<%=request.getContextPath()%>/outside/buyCard/coachPriDetail?id=${item.id}"><img class="pic hot-img" src="${item.image}"></a>
		                        <div class="at-title-box">
		                            <div class="hot-title">${item.nickname}</div>
		                            <div class="stars">
		                                <span class=""></span>
		                                <span class=""></span>
		                                <span class=""></span>
		                                <span class=""></span>
		                                <span class=""></span>
		                            </div>
		                        </div>
		                    </div>
	                    </c:forEach>
                   <%--  <div class="swiper-slide swiper-slide-active" >
                        <img class="pic hot-img" src="<%=request.getContextPath()%>/assets/images/outside/201707241355041500875710057.jpg">
                        <div class="at-title-box">
                            <div class="hot-title">喵洋</div>
                            <div class="stars">
                                <span class=""></span>
                                <span class=""></span>
                                <span class=""></span>
                                <span class=""></span>
                                <span class=""></span>
                            </div>
                        </div>
                    </div> --%>


                </div>
            </div>
            <!--//人气swiper-->
            <div class="sl-line"></div>

            <!--搜索盒子  滚动监听suspension-->

            <!-- <div class="search-box clearfix text-center ">
                <div class=""><span>场地</span></div>
                <div class=""><span>价格</span></div>
                <div class=""><span>排序</span></div>
                <div class=""><span>筛选</span></div>
            </div> -->
            <div id="search" infinite-scroll-disabled="loading" infinite-scroll-distance="200" class="coach-list-box">
                <!-- a href="gm_sijiaoke_jl.html">
                	<div class="coach-list clearfix">
                    <div class="left">
                        <img src="<%=request.getContextPath()%>/assets/images/outside/sjtx.png">
                        <img src="<%=request.getContextPath()%>/assets/images/outside/p1.png" class="hot">
                    </div>
                    <div class="right">
                        <div class="clearfix">
                            <div class="coach-name">大宝</div>
                            <div class="price text-right">
                                <span>￥</span>
                                <span>240</span>
                                <span>/课时起</span>
                            </div>
                        </div>
                        <div class="stars">
                            <span class=""></span>
                            <span class=""></span>
                            <span class=""></span>
                            <span class=""></span>
                            <span class=""></span>
                        </div>
                        <div class="advantage">减脂塑型，肌肉塑造，泰拳格斗，产后恢复#国家二级运动员#nasm-cpt 美国国家医学运动会私人教练认证#国家职业资格健身教练认证#国家职业资格游泳救生员#国家运动营养师#MFT格斗认证#陈博士体能康复学院#IKFF   CKT   壶铃大师lv1</div>
                        <div class="certificate">
                            <span class="tap">2项专业认证</span>
                        </div>
                    </div>
                </div>
                </a> -->

            </div>
          <!--   <div class="text-center" style="padding: 2rem 5rem; color: rgba(0, 0, 0, 0.298039);">没有更多数据了，亲</div> -->
           <!--搜索盒子二级--场地-->
            <div class="mask" style="display: none;">
                <div class="search-area">
                    <div class="space clearfix">
                        <div class="left">
                            <ul>
                                <li>全部</li>
                                <li class="active">浦口区</li>
                                <li class="">秦淮区</li>
                                <li class="">雨花台区</li>
                                <li class="">鼓楼区</li>
                                <li class="">玄武区</li>
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li class="">印象汇店</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
           <!--搜索盒子二级--价格-->
           <div class="mask" style="display: none;">
                <div class="search-price">
                    <div class="price-box clearfix text-center">
                        <div class="price-list">￥100元以下</div>
                        <div class="price-list">￥101-200</div>
                        <div class="price-list">￥201-300</div>
                        <div class="price-list">￥301-400</div>
                        <div class="price-list">￥401-500</div>
                        <div class="price-list">￥500元以上</div>
                        <div class="price-input">
                            <input type="text" placeholder="最低价格" class="text-center"> 至 <input type="text" placeholder="最高价格" class="text-center"></div>
                        <div style="display: none;">0</div>
                    </div>
                    <div class="clearfix text-center bottom">
                        <div class="left">重置</div>
                        <div class="right">确定</div>
                    </div>
                </div>
            </div>
           <!--搜索盒子二级--排序-->
           <div class="mask" style="display: none;">
                <div class="search-sort">
                    <ul class="text-center">
                        <li class="">综合排序</li>
                        <li class="">离我最近</li>
                        <li class="">价格最低</li>
                        <li class="">评价最好</li>
                        <li class="">人气最高</li>
                    </ul>
                </div>
            </div>
            <!--搜索盒子二级--筛选-->
            <div class="mask" style="display: none;">
                <div class="search-select">
                    <div class="sub-title">教练等级</div>
                    <div class="tap-box clearfix">
                        <div class="label-box">
                            <input type="checkbox" id="level0" name="coachLevel" value="1">
                            <label for="level0">P1认证</label>
                        </div>
                        <div class="label-box">
                            <input type="checkbox" id="level1" name="coachLevel" value="2">
                            <label for="level1">P2高级</label>
                        </div>
                        <div class="label-box">
                            <input type="checkbox" id="level2" name="coachLevel" value="3">
                            <label for="level2">P3资深</label>
                        </div>
                        <div class="label-box">
                            <input type="checkbox" id="level3" name="coachLevel" value="4">
                            <label for="level3">P4专家级</label>
                        </div>
                    </div>
                    <div class="sub-title">教练性别</div>
                    <div class="tap-box clearfix">
                        <div class="tap-list">男</div>
                        <div class="tap-list">女</div></div>
                    <div class="sub-title">健身需求</div>
                    <div class="tap-box clearfix">
                        <div class="label-box"><input type="checkbox" id="jsxq0" name="jsxq" value="241"><label for="jsxq0">增肌</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq1" name="jsxq" value="242"><label for="jsxq1">产后恢复</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq2" name="jsxq" value="243"><label for="jsxq2">康复</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq3" name="jsxq" value="244"> <label for="jsxq3">格斗</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq4" name="jsxq" value="246"> <label for="jsxq4">普拉提</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq5" name="jsxq" value="247"> <label for="jsxq5">拉伸</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq6" name="jsxq" value="248"> <label for="jsxq6">瑜伽</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq7" name="jsxq" value="249"> <label for="jsxq7">舞蹈</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq8" name="jsxq" value="250"> <label for="jsxq8">减脂塑形</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq9" name="jsxq" value="256"> <label for="jsxq9">壶铃</label></div>
                        <div class="label-box"><input type="checkbox" id="jsxq10" name="jsxq" value="281"> <label for="jsxq10">CrossFit</label></div>
                    </div>
                    <div class="clearfix text-center bottom">
                        <div class="left">重置</div>
                        <div class="right">确定</div>
                    </div>
                </div>
            </div>
            <!--//////搜索盒子-->
           <!--底部menu-->
           <%@ include file="/WEB-INF/view/common/mobile_bottom.jsp"%>
				<%-- <div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
			<a class="mint-tab-item" href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">约课</div>
            </a>
            <a class="mint-tab-item boder-1px-left is-selected" href="gm_Huiyuanka.html">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">购买</div>
            </a>
            <a class="mint-tab-item boder-1px-left" href="my_lesson.html">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">我的课程</div>
            </a>
            <a class="mint-tab-item boder-1px-left " href="personal_center.html">
                <div class="mint-tab-item-icon"></div>
                <div class="mint-tab-item-label">个人中心</div>
            </a>
				</div> --%>
        </div>
    </div>
</div>


<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/swiper.min.js"></script>
 <script src="<%=request.getContextPath()%>/assets/js/outside/buycard/coursepricoach/course_pri_coachlist.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>
//			当红人气
var mySwiper = new Swiper('.swiper-container2',{
slidesPerView :3,
centeredSlides : false,
})
//搜索盒子

</script>
<script type="text/javascript">
    var docEl = document.documentElement,
    //当设备的方向变化（设备横向持或纵向持）此事件被触发。绑定此事件时，
    //注意现在当浏览器不支持orientationChange事件的时候我们绑定了resize 事件。
    //总的来说就是监听当然窗口的变化，一旦有变化就需要重新设置根字体的值
            resizeEvt = 'onorientationchange' in window ? 'orientationchange' : 'resize',
            recalc = function() {
                //设置根字体大小
                setTimeout(function() {
                    docEl.style.fontSize = 10 * (docEl.clientWidth / 375) + 'px';
                },200)
            };

    //绑定浏览器缩放与加载时间
    window.addEventListener(resizeEvt, recalc, false);
    document.addEventListener('DOMContentLoaded', recalc, false);
</script>

</body>
</html>