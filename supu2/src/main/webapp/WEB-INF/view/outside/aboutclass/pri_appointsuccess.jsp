<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<title>课程详情</title>
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
		<link href="<%=request.getContextPath()%>/assets/css/outside/style-yk-sjk-yiyuyue.css" rel="stylesheet">
		<style type="text/css" title="fading circle style">
			.circle-color-8>div::before {
				background-color: #ccc;
			}
		</style>
	</head>

	<body>
		<div id="app">
			<div class="body-box">
				<div class="class-info">
					<div class="info-top clearfix"><img alt="" class="header-pic" src="https://img.leoao.com/o_1b4dnjmu91ibmjs0nvt103h12eop.png">
						<div class="info-box">
							<div class="class-name">${coachname }·1v1私教课</div>
							<div class="classNo">
								第${EmployeeBuyCourseDto.appointCount }节/共${EmployeeBuyCourseDto.totalclass } 节
								<span class="yqd">已预约</span>
								<!---->
								<!---->
								<!---->
								<!---->
							</div>
						</div>
					</div>
					<div class="top-message">
						<div class="time"><fmt:formatDate value="${date }" pattern="yyyy-MM-dd" /> ${starttime }~${EmployeeBuyCourseDto.endtime }
						<span class="fn-right" style="color: rgb(250, 74, 17);">课程前后1小时可扫码入场</span></div>
						<div class="message-box clearfix">
							<div class="left">
								<div class="store-name">${store.storename }</div>
								<div class="address">${store.province }${store.city }${store.region }${store.address }</div>
							</div>
							<!-- <div class="right">查看定位</div> -->
						</div>
					</div>
					<div class="content-box">
						<div class="content-title">课程内容</div>
						<div class="no-content">
							还未填写课程内容
						</div>
						<!---->
						<!---->
						<!---->
						<!---->
						<!---->
						<!---->
					</div>
					<!---->
					<!---->
					<div class="e-text"></div>
					<div class="pic-list clearfix"></div>
					<!---->
					<!---->
					<!---->
					<div class="new-bottom no-boder">
						<div class="bottom-box clearfix">
							<a href="tel://15755537670">
								<div class="left lxjl">联系教练</div>
							</a>

							<!---->
							<div class="right" id="cancelAppoint" data-id="${appointid }">取消课程</div>
							<!---->
							<!---->
							<!---->
						</div>
					</div>
				</div>
			</div>

			<!--加载loading-->
			<div class="mint-indicator" style="display: none;">
				<div class="mint-indicator-wrapper" style="padding: 20px;">
					<span class="mint-indicator-spin">
					<div class="mint-spinner-fading-circle circle-color-8" style="width: 32px; height: 32px;">
						<div class="mint-spinner-fading-circle-circle is-circle2"></div>
						<div class="mint-spinner-fading-circle-circle is-circle3"></div>
						<div class="mint-spinner-fading-circle-circle is-circle4"></div>
						<div class="mint-spinner-fading-circle-circle is-circle5"></div>
						<div class="mint-spinner-fading-circle-circle is-circle6"></div>
						<div class="mint-spinner-fading-circle-circle is-circle7"></div>
						<div class="mint-spinner-fading-circle-circle is-circle8"></div>
						<div class="mint-spinner-fading-circle-circle is-circle9"></div>
						<div class="mint-spinner-fading-circle-circle is-circle10"></div>
						<div class="mint-spinner-fading-circle-circle is-circle11"></div>
						<div class="mint-spinner-fading-circle-circle is-circle12"></div>
						<div class="mint-spinner-fading-circle-circle is-circle13"></div>
					</div></span> <span class="mint-indicator-text" style="">加载中...</span></div>
				<div class="mint-indicator-mask"></div>
			</div>
			<!--//加载loading-->

<%-- 			<!--预约成功提示-->
			<div class="mask" style="display:none;"></div>
			<div class="mint-msgbox-wrapper" style="position: absolute; z-index: 2005; display: none;">
				<div class="mint-msgbox" style="display:block;">
					<div class="mint-msgbox-header">
						<div class="mint-msgbox-title">确定取消预约</div>
					</div>
					<div class="mint-msgbox-content">
						<div class="mint-msgbox-message">上课两小时之前您可以自行 <br>取消课程。如果爽约了，这节课时 <br>费可要被扣掉的！</div>
						<div class="mint-msgbox-input" style="display: block;"><input placeholder="sdsd" type="text">
							<div class="mint-msgbox-errormsg" style="visibility: hidden;">dfsd</div>
						</div>
					</div>
					<div class="mint-msgbox-btns">
						<button class="mint-msgbox-btn mint-msgbox-cancel" style="display:block;">取消</button>
						<button class="mint-msgbox-btn mint-msgbox-confirm " id="cancelAppoint" data-id="${appointid }">确定</button></div>
				</div>
			</div> --%>

<!--弹出层-->
<div  class="mask successmask" style="display:none;"></div>
<div id="alertSuccess" class="mint-msgbox-wrapper" style="position: absolute; z-index: 2013; display:none;">
    <div class="mint-msgbox" style="display:block;">
        <div class="mint-msgbox-header">
            <div class="mint-msgbox-title" id="successMassage">取消成功</div>
        </div>
        <div class="mint-msgbox-content">
            <div class="mint-msgbox-message"></div>
            <div class="mint-msgbox-input" style="display: none;">
                <input placeholder="" type="text">
                <div class="mint-msgbox-errormsg" style="visibility: hidden;"></div>
            </div>
        </div>
        <div class="mint-msgbox-btns">
        	<button class="mint-msgbox-btn mint-msgbox-cancel successhide"  style="">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel successhide"  style="">取消</button>
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
        	<button class="mint-msgbox-btn mint-msgbox-cancel successhide" style="">确定</button>
            <button class="mint-msgbox-btn mint-msgbox-cancel successhide" style="">取消</button>
        </div>
    </div>
</div>

<!--//预约成功提示-->
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/aboutclass/pri_appointsuccess.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>

			<!--弹出层的js-->
	<!-- 		<script>
				$(function() {
					$(".right").click(function() {
						$(".mint-msgbox-wrapper").show();
						$(".mask").show();
					});
					$(".mint-msgbox-btns,.mask").click(function() {
						$(".mint-msgbox-wrapper").hide();
						$(".mask").hide();
					})
				})
			</script> -->
	</body>


