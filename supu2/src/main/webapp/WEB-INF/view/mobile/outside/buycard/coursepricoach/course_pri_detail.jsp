<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
	<head>
        <meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<title>私教详情</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/style-jl.css">
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">
		<style type="text/css">
					.circle-color-8>div::before {background-color: #ccc;}
					.detail .coach-info .info-box .info-center div{ width:30%; margin-left: 15%;}
					.check {background-image:url(/supu/assets/images/leoao-coach-mcheck.png);}
					.store-list .select-store-list{padding:1.5rem .5rem 0}
					.store-list .isDetail>.top>.right{padding-left:1.5rem; width: 95%;}
					.mask{top:0}
					#window_content_div img{
						max-height: 224px;
					}
		</style>
</head>

	<body>
		<div id="app">
			<div class="body-box">
				<div class="detail">
					<div class="coach-info">
						<div class="info-box">
							<div class="info-top clearfix">
								<div class="left">
									<div class="coach-name">${coach.nickname }</div>
									<div class="stars">
										<span class=""></span>
										<span class=""></span>
										<span class=""></span>
										<span class=""></span>
										<span class=""></span>
										<!-- <span>
											<a href="#apprise">153好评</a>
										</span> -->
									</div>
								</div>
								<div class="right"><img src="${coach.headimg}" class="coach-pic">
								<img src="<%=request.getContextPath()%>/assets/images/outside/jl_p${coach.coachlevel}.png" class="coach-level">
									<!---->
								</div>
							</div>
							<div class="info-center clearfix text-center">
								<div class="jl_zs">
									<div class="number">${fn:length(certificate)}</div>
									<div class="number-title">证书</div>
								</div>
								<!--<div>
									<div class="number">2</div>
									<div class="number-title">学员案例</div>
								</div>-->
								<div class="jl_xc">
									<div class="number">${imgCount }</div>
									<div class="number-title">相册</div>
								</div>
							</div>
							<div class="info-bottom">
								<ul class="clearfix">
									<li>专业保障</li>
									<li>严禁推销</li>
									<li>服务保障</li>
									<li>课程保障</li>
								</ul>
							</div>
						</div>
					</div>
			<!-- 		<div class="detail-title">可约时间 <span class="fn-right arrow-left-f00 jl_ck">查看7天</span></div>
					<div class="time-two"><span class="active">可约时间</span> <span>不可约时间</span></div>
					<div class="time-box">
						<div class="time-title clearfix">
							<div class="afterno"></div>
							<div>07</div>
							<div>09</div>
							<div>11</div>
							<div>13</div>
							<div>15</div>
							<div>17</div>
							<div>19</div>
							<div>21</div>
							<div class="afterno">23</div>
						</div>
						<div class="time-list clearfix">
							<div>今</div>
							<div></div>
						</div>
						<div class="time-list clearfix">
							<div>明</div>
							<div>
								<div class="timer" style="width: 68.75%; left: 12.5%;"></div>
							</div>
						</div>
						<div class="time-list clearfix">
							<div>后</div>
							<div>
								<div class="timer" style="width: 68.75%; left: 12.5%;"></div>
							</div>
						</div>




					</div> -->
					<div class="detail-title">擅长</div>
					<div class="good-at">${coach.goodat }</div>
					<div class="detail-title">
						服务场地
						<span class="left-text">${fn:length(store)}个场地</span>
						<span class="fn-right arrow-left-f00 jl_qbcd">全部场地</span></div>
					<div class="service-area">
						 <c:forEach items="${store}" var="item" varStatus="status">
							 <span>${item.storename }</span>
						</c:forEach>
					<!-- 	<span>城西银泰店</span>
						<span>西溪诚品店</span>
						<span>水晶城购物中心店</span>
						<span>运河上街店</span>
						<span>世纪新城店</span>
						<span>和平广场店</span>
						<span>中大银泰店</span>
						<span>文三颐高店</span>
						<span>文一国美店</span>
						<span>八方城店</span><span>
						西湖文化广场店</span>
						<span>秋涛国美店</span>
						<span>文一华润万家店</span>
						<span>西狗国际店</span>
						<span>中天MCC店</span>
						<span>教工物美店</span>
						<span>东新路物美店</span> -->
					</div>
					<div class="sl-line"></div>
					<div id="lessons" class="lessons">
						<div class="detail-title">
							所授课程
							<span class="left-text"></span></div>
						<div class="marketAds"></div>
						<div class="main">

								 <c:forEach items="${coachPri}" var="item" varStatus="status">

										<div class="lesson-list clearfix">
											<div class="fn-left headerpic"><img src="${item.courseimg }"></div>
											<div class="fn-left lesson-info">
												 <div class="lesson-name">${item.coursename }</div>
												 <div class="lesson-number">${item.totalhours}课时

												</div>
												<div class="price"><span>￥</span> <span>${item.courseamount }</span> <span>/课时</span></div>
											</div>

											<input type="hidden" class="isexperience"  value="${item.isexperience}">
											<div class="fn-left lesson-check"><span class="fn-right uncheck"></span></div>

												<!-- 课程id -->
												<input type="hidden" value="${item.id }">
													<!-- 课程标题 -->
											<input type="hidden" class="title" value="${item.coursetitle }">
											<!-- 课程图片 -->
											<input type="hidden" class="img" value="${item.courseimg} ">
											<!-- 课程详情 -->
											<div class="detail" style="display:none">
												${item.coursedetail}
											</div>
										</div>



	                   			 </c:forEach>
						<!-- 	<div class="lesson-list clearfix">
								<div class="fn-left headerpic"><img src="images/jl-02.png"></div>
								<div class="fn-left lesson-info">
									<div class="lesson-name">体验课 <span>仅限新人购买</span></div>
									<div class="lesson-number">1课时

									</div>
									<div class="price"><span>￥</span> <span>19</span> <span>/课时</span></div>
								</div>
								<div class="fn-left lesson-check"><span class="fn-right uncheck"></span></div>
							</div> -->


						</div>
					<!-- 	<div class="more-btn"><span>全部课程</span></div> -->
						<div class="sl-line"></div>
					</div>
					<div class="service-content">
						<div class="detail-title">
							服务流程
							<!-- <span class="fn-right arrow-left-f00 jl_kcxz">课程须知</span> --></div>
						<div class="service-box">
							<ul class="clearfix">
								<li><span>1</span>
									<div>在线购课</div>
								</li>
								<li><span>2</span>
									<div>预约课程</div>
								</li>
								<li><span>3</span>
									<div>课前签到</div>
								</li>
								<li><span>4</span>
									<div>正式上课</div>
								</li>
							</ul>
						</div>
					</div>
<!-- 					<div id="apprise" class="member-evaluate">
						<div class="sub-title clearfix"><span class="fn-left">会员评价</span></div> -->
						<!-- <div class="tap-box"><span class="new-tap">全部 <i>111</i></span><span class="new-tap">好评 <i>111</i></span><span class="new-tap">有图 <i>2</i></span></div> -->
					<!-- </div> -->
<!-- 					<div class="evaluate-box">
						<div class="evaluate-list main">
							<div class="top clearfix">
								<div class="left"><img src="http://omdweogbh.bkt.clouddn.com/anonymous2.png"></div>
								<div class="right">
									<div class="clearfix"><span>匿名用户</span> <span class="fn-right">2017年05月28日</span></div>
									<div class="stars"><span class=""></span> <span class=""></span> <span class=""></span> <span class=""></span> <span class=""></span> <span class="fn-right">体验课</span></div>
								</div>
							</div>
							<div class="content">喜欢汗流浃背的感觉，教练很给力。很贴心。必须给教练32个赞</div>

						</div>
						<div class="evaluate-list main">
							<div class="top clearfix">
								<div class="left"><img src="http://wx.qlogo.cn/mmopen/Q3auHgzwzM7kdAiaIvqQDWuHzlH3Ns2a8YuPYIofDZFqZP8eLHKUkOCzeiagzZmddUOVb7UzD7wPPqciclfL8vZWQ/0"></div>
								<div class="right">
									<div class="clearfix"><span>舒**</span> <span class="fn-right">2017年05月28日</span></div>
									<div class="stars"><span class=""></span> <span class=""></span> <span class=""></span> <span class=""></span> <span class=""></span> <span class="fn-right">减脂塑形</span></div>
								</div>
							</div>
							<div class="content">练了一个多月效果还是蛮好的</div>
							<div class="picture"></div>
						</div>


						<div class="more-btn"><span>更多评价</span></div>
					</div> -->
					<!---->
	 				<div class="last-box"></div>
					<div class="new-bottom">
						<div class="bottom-box">
							<!-- <div class="left">联系客服</div> -->
							<a id="buy"><div class="right">立即购买</div></a>
						</div>
					</div>

					<!--所授课程弹窗-->
					<div class="mask lesson-tips-mask sskctc" style="display: none;">
						<div class="lesson-tips">
							<div class="tips-title" id="window_div">
								<div id="titleappend"></div>
								<img src="<%=request.getContextPath()%>/assets/images/outside/leoao-coach-mclose000.png">

							</div>
							<div class="content" id="window_content_div">
								<img id="window_img" src="" >
							</div>
							<!-- 课程详情 -->
							<div id="div_detail" style="padding: 1rem">

							</div>
						</div>
					</div>

					<!--服务场地弹窗-->
					<div class="mask detail-store-list jl_qbcdtc" style="display: none;">
						<div class="store-list">
							<div class="coupon-title text-center">
								${fn:length(store)}个服务场地
								<img class="qbcd_close" src="<%=request.getContextPath()%>/assets/images/outside/leoao-coach-mclose000.png"></div>
							<div class="store-list-box">
								 <c:forEach items="${store}" var="item" varStatus="status">
									 <div class="select-store-list isDetail">
										<div class="top clearfix" style="background-image: url(&quot;https://img.leoao.com/o_1b5jv5b1bemh1mon1hfo1q1u1elu9.jpg?imageView2/2/w/300&quot;);">

											<div class="right">
												<div class="clearfix">
													<div class="left">${item.storename } <span class="position"></span></div>
													<!-- <div class="right"><span class="two">3.4km</span></div> -->
												</div>
												<div>${item.province}-${item.city}-${item.region } ${item.address }</div>
												<!-- <div>公共私教区</div> -->
											</div>
										</div>
										<div class="bottom">

										</div>
									</div>
								</c:forEach>
								<!---->
					<!-- 			<div class="select-store-list isDetail">
									<div class="top clearfix" style="background-image: url(&quot;https://img.leoao.com/o_1b5jv5b1bemh1mon1hfo1q1u1elu9.jpg?imageView2/2/w/300&quot;);">

										<div class="right">
											<div class="clearfix">
												<div class="left">西狗国际店 <span class="position"></span></div>
												<div class="right"><span class="two">3.4km</span></div>
											</div>
											<div>石桥路272号西狗国际2楼(石桥路与长城街交叉口东南侧100米)</div>
											<div>公共私教区</div>
										</div>
									</div>
									<div class="bottom">

									</div>
								</div> -->


							</div>
							<!---->
						</div>
					</div>
					<!--7天可约时间弹窗-->
                      <div class="mask detail-store-list jl_cktc" style="display: none;">
						<div class="lesson-time">
							<div class="pop-title text-center">
								近7天可约时间
								<img  class="ck_close" src="<%=request.getContextPath()%>/assets/images/outside/leoao-coach-mclose000.png"></div>
							<div class="pop-box">
								<div class="time-two"><span class="active">可约时间</span> <span>不可约时间</span></div>
								<div class="time-box">
									<div class="time-title clearfix">
										<div class="afterno"></div>
										<div>07</div>
										<div>09</div>
										<div>11</div>
										<div>13</div>
										<div>15</div>
										<div>17</div>
										<div>19</div>
										<div>21</div>
										<div class="afterno">23</div>
									</div>
									<div class="time-list clearfix">
										<div>今</div>
										<div></div>
									</div>
									<div class="time-list clearfix">
										<div>明</div>
										<div>
											<div class="timer" style="width: 68.75%; left: 12.5%;"></div>
										</div>
									</div>
									<div class="time-list clearfix">
										<div>后</div>
										<div>
											<div class="timer" style="width: 68.75%; left: 12.5%;"></div>
										</div>
									</div>
									<div class="time-list clearfix">
										<div>一</div>
										<div>
											<div class="timer" style="width: 71.875%; left: 12.5%;"></div>
										</div>
									</div>
									<div class="time-list clearfix">
										<div>二</div>
										<div></div>
									</div>
									<div class="time-list clearfix">
										<div>三</div>
										<div></div>
									</div>
									<div class="time-list clearfix">
										<div>四</div>
										<div></div>
									</div>
								</div>
							</div>
							<div class="bottom-only-button">
								<div>立即预约</div>
							</div>
						</div>
					</div>
					<!--证书弹窗-->
					<div class="mask certificate jl_zstc" style="display: none;">
						<div class="certificate-title">证书
							<img class="zs_close" src="<%=request.getContextPath()%>/assets/images/outside/leoao-coach-mclose000.png">
						</div>

							 <c:forEach items="${certificate}" var="item" varStatus="status">
								<div class="certificate-list"><img src="${item.certificateimg}">
									<div class="list-title">${item.name }</div>
									<div class="list-text"></div>
								</div>
							</c:forEach>
						<!-- div class="certificate-list"><img src="<%=request.getContextPath()%>/assets/images/outside/zhengshu.png">
							<div class="list-title">中英普拉提认证</div>
							<div class="list-text"></div>
						</div -->
					</div>
					<!--相册弹窗-->
					<div class="mask student-mask picture-mask jl_xctc" style="display: none;">
					 	<div class="title text-center">
							教练相册
						</div>


						<c:if test="${coach.coachimg1!=null && coach.coachimg1!=''}">
									<div class="pic-list"><img " src="${coach.coachimg1 }"></div>
						</c:if>
						<c:if test="${coach.coachimg2!=null && coach.coachimg2!=''}">
									<div class="pic-list"><img " src="${coach.coachimg2 }"></div>
						</c:if>

						<c:if test="${coach.coachimg3!=null && coach.coachimg3!=''}">
									<div class="pic-list"><img " src="${coach.coachimg3 }"></div>
						</c:if>

						<c:if test="${coach.coachimg4!=null && coach.coachimg4!=''}">
									<div class="pic-list"><img " src="${coach.coachimg4 }"></div>
						</c:if>

						<c:if test="${coach.coachimg5!=null && coach.coachimg5!=''}">
									<div class="pic-list"><img " src="${coach.coachimg5 }"></div>
						</c:if>


					<!-- 	<div class="pic-list"><img src="https://cdn.leoao.com/1500951438250"></div>
						<div class="pic-list"><img src="https://cdn.leoao.com/1500951438250"></div> -->

					</div>



				</div>
			</div>

		</div>

		<!--弹出层-->
<div  class="mask model" style="display:none;"></div>
<div id="alertquenen" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
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
        	<button class="mint-msgbox-btn mint-msgbox-cancel"  style="">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel" style="">取消</button>
        </div>
    </div>
</div>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/coursepricoach/detail_course_pri_coach.js"></script>

	<script>
			$(function() {
				$(".jl_qbcd").click(function() {
					$(".jl_qbcdtc").show()
				});
				$(".qbcd_close").click(function() {
					$(".jl_qbcdtc").hide()
				});

					$(".jl_ck").click(function() {
					$(".jl_cktc").show()
				});
				$(".ck_close").click(function() {
					$(".jl_cktc").hide()
				});

				$(".jl_zs").click(function() {
					$(".jl_zstc").show()
				});
				$(".zs_close").click(function() {
					$(".jl_zstc").hide()
				});

				$(".jl_xc").click(function() {
					$(".jl_xctc").show()
				});
				$(".xc_close").click(function() {
					$(".jl_xctc").hide()
				});


				$(".jl_kcxz").click(function() {
					$(".jl_kcxztc").show()
				});
				$(".kcxz_close").click(function() {
					$(".jl_kcxztc").hide()
				});

    $(".lesson-check .fn-right").click(function(){
              $(".lesson-check .fn-right").removeClass("check");
              $(this).addClass("check");
    });

    $(".more-btn").click(function() {
					$(".lesson-list").show();
					$(".more-btn").hide();
				});


	   $(".lesson-list .lesson-info,.lesson-list .headerpic").click(function() {
					$(".sskctc").show();
				});
		 $(".sskctc .tips-title img").click(function() {
					$(".sskctc").hide();
				});



			});
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
					}, 200)
				};

			//绑定浏览器缩放与加载时间
			window.addEventListener(resizeEvt, recalc, false);
			document.addEventListener('DOMContentLoaded', recalc, false);
		</script>


	</body>

</html>