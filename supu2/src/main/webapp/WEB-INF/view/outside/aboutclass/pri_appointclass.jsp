<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<title>预约详情</title>

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
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/style-yk-sjk-lesson.css">
		<style type="text/css" title="fading circle style">
			.circle-color-8>div::before {
				background-color: #ccc;
			}
			.time-list{
				display: none;
			}
			.mask{
				top: 0;
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="body-box">
				<div class="lesson-detail">
					<div class="detail-list"><span class="font-s16px">课程</span> <span class="font-s16px fn-right">${coachname }·私教课</span></div>
					<div class="detail-list"><span class="font-r15px">服务时间*</span> <span class="font-r15px color-main arrow-left fn-right lesson_time" id="clickTime">请选择</span></div>
					<div class="detail-list"><span class="font-r15px">上课场地*</span> <span class="font-r15px arrow-left fn-right lesson_cd" id="clickdiv">请选择</span></div>
					<form action="<%=request.getContextPath()%>/outside/aboutClass/appointSuccess" method="post" id="form">
					<div class="bottom-only-button">
							<input type="hidden" value="${courseid }" name="courseid" ></input>
							<input type="hidden" value="${coachname }" name="coachname" ></input>

							<div id="submitdiv">发起预约</div>

					</div>

					<!--请选择上课时间弹窗-->
					<div id="div_classTime" class="mymask lesson_time_tc" style="display:none;">
						<div class="appointe-time">
							<div class="pop-title text-center">
								请选择上课时间
								<img src="https://cdn.leoao.com/leoao-coach-mclose000.png" class="time_close"></div>
							<div class="pop-sub-title" style="display: none;"></div>
							<div class="date-box">
								<ul class="clearfix">
									<c:forEach items="${timeList }" var="items">
										<c:if test="${items.week=='今天' }"><input type="hidden" value="${items.appointTime }" name="appointtime" id="appointtime"></input></c:if>
										<li class="clickli <c:if test="${items.week=='今天' }">active</c:if>" data-date="${items.appointTime }">
											<div class="week">${items.week }</div>
											<div class="date">${items.simpleDte }</div>

										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="menu">

							<input type="hidden" value="" name="starttime" id="time"></input>
								<c:forEach items="${timeList }" var="items">
									<div class="time-list">
										<ul>
										<c:forEach items="${items.timeListDtos }" var="item" varStatus="status">
											<c:choose>
												<c:when test="${item.checked }">
													<li class="nodis" data-time="${item.time }">
														<div class="time">${item.time }</div>
													</li>
												</c:when>
												<c:otherwise>
													<li class="disabled">
														<div class="time">${item.time }</div>
													</li>
												</c:otherwise>
											</c:choose>


										</c:forEach>
										</ul>
									</div>
								</c:forEach>

							</div>
							<div class="btn-box clearfix">
								<div class="left classTime">暂不选择</div>
								<div class="right classTime">确定</div>
							</div>
						</div>
					</div>

					<!--选择上课场地弹窗-->
					<div id="div_classPlace" class="mymask lesson_cd_tc" style="display: none;">
						<div class="store-list">
							<div class="coupon-title text-center">
								选择上课场地
								<img src="https://cdn.leoao.com/leoao-coach-mclose.png" class="cd_close"></div>
							<div class="store-list-box">
								<!--无场地-->
								<!-- <div class="text-center no-stores">没有符合该条件的场地哦，亲</div> -->
								<!--有场地-->
								<div class="select-store-list">
									<c:forEach items="${stores }" var="items">
										<div data-storeid="${items.id }" data-name="${items.storename }" class="top clearfix divStoreid" style="background-image:url(<%=request.getContextPath()%>/assets/images/201707202140281500558049733.png);">
											<!--未选择active-->
											<div class="right">
												<div class="clearfix">
													<div class="left">${items.storename } <span class="position"></span></div>
													<div class="right"><span class="two">${items.distance }km</span></div>
												</div>
												<div>${items.province }${items.city }${items.region }${items.address }</div>
											<!-- 	<div>公共私教区</div> -->
											</div>
										</div>
									</c:forEach>
									<input type="hidden" value="" id="storename"></input>
									<input type="hidden" value="" name="storeid" id="storeid"></input>
									<input type="hidden" value="" name="appointid" id="appointid"></input>
			<%-- 						<div class="top clearfix" style="background-image:url(<%=request.getContextPath()%>/assets/images/201707202140281500558049733.png);">
										<!--选择 加active-->
										<div class="right active">
											<div class="clearfix">
												<div class="left">印象汇店 <span class="position"></span></div>
												<div class="right"><span class="two">250.1km</span></div>
											</div>
											<div>南京市浦口区大桥北路58号印象汇1-2楼</div>
											<div>公共私教区</div>
										</div>
									</div> --%>

									<div class="bottom">
										<!---->
									</div>
								</div>
							</div>
							<div class="pop-sure-box classPlace">确定</div>
						</div>
					</div>
				<!-- </form> -->
				</div>
			</div>



</form>
<!--弹出层-->
<div  class="mask successmask" style="display:none;"></div>
<div id="alertSuccess" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
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
        	<button class="mint-msgbox-btn mint-msgbox-cancel btn_success" style="">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel btn_success" style="">取消</button>
        </div>
    </div>
</div>
<!--弹出层-->
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
            <button class="mint-msgbox-btn mint-msgbox-cancel btn_div" style="">取消</button>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/aboutclass/pri_appointclass.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
			<script>
				$(function() {
					$(".lesson_time").click(function() {
						$(".lesson_time_tc").show()
					});
					$(".time_close").click(function() {
						$(".lesson_time_tc").hide()
					})
					$(".lesson_cd").click(function() {
						$(".lesson_cd_tc").show()
					});
					$(".cd_close").click(function() {
						$(".lesson_cd_tc").hide()
					});
					$(".time-list li").click(function() {
						$(".time-list li").removeClass("active");

						$(this).addClass("active");
					});
					$(".select-store-list .top .right").click(function() {
						$(".select-store-list .top .right").removeClass("active");
						$(this).addClass("active");
					});
				})
			</script>


			<script>
				$(function(){
					$(".time-list").first().show();
				    $(".clearfix>li").click(function () {
				        var index = $(".clearfix>li").index(this);
				        $(this).addClass("active").siblings().removeClass("active");
				        $(".time-list").eq(index).show().siblings().hide();
				    });


/* 				    $(".nodis:eq(0)").addClass("active");
				    var time=$(".nodis:eq(0)").data("time");
				    $('#time').val(time); */
				});
			</script>
	</body>

</html>

