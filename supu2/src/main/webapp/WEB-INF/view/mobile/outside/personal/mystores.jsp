<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<title>速扑健身门店</title>
		<meta charset="utf-8">
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

		<!--<link href="css/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">-->
		<link href="<%=request.getContextPath()%>/assets/css/outside/pay-tyk.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/assets/css/star.css" rel="stylesheet">
		<%--<link href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">--%>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/jquery-weui.min.css">
		<style type="text/css">
			body {
				background: rgb(238, 238, 238);
			}

			body,
			div,
			html,
			p {
				margin: 0;
				padding: 0;
				border: 0;
			}

			.order-detail {
				overflow: hidden;
			}

			.mymask {
				width: 100%;
				float: left;
			}

			.store-list-box2 {
				position: relative;
				top: 0;
			}

			.text-center {
				text-align: center;
			}

			.select-store .selector {
				margin-bottom: 0;
			}

			html {
				font-size: 14px
			}

			body {
				font-size: 14px
			}

			@media only screen and (min-width:319px) {
				html {
					font-size: 14px!important
				}
			}

			@media only screen and (min-width:414px) {
				html {
					font-size: 16px!important
				}
			}

			@media only screen and (min-width:480px) {
				html {
					font-size: 18px!important
				}
			}

			.demos-header {
				width: 90%;
				float: left;
				padding: 0.5rem 10%;
				;
				background-color: #fff;
				margin-bottom: 0.5rem;
				overflow: hidden;
			}

			.demos-header .sort-title {
				float: left;
			}

			.demos-header .sort-num {
				float: right;
				margin-right: 10%;
			}

			.demos-header .sort-num span {
				color: #F04134;
			}

			.search-box>div {
				width: 50%;
				float: left;
				height: 3.9rem;
				line-height: 3.9rem;
				background-color: #fff;
			}

			.weui_input {
				width: 5rem;
			}

			.select-store .selector>div i {
				display: inline-block;
				width: 0;
				height: 0;
				border: .3rem solid transparent;
				border-left-color: #333;
				vertical-align: middle;
				margin-left: .3rem
			}

			.select-store .selector>div {
				width: 50%;
				float: left;
			}

			.select-store .selector>div #xz-city {
				margin-top: 1.1rem;
			}

			.select-store-list2 .xzdd {
				overflow: hidden;
			}

			.select-store-list2 .xzdd .left,
			.select-store-list2 .xzdd .right {
				float: left;
			}

			.select-store-list2 .xzdd div {
				width: 90%;
				float: left;
			}

			.store-list-box2 {
				width: 100%;
				overflow: hidden;
				border-top: 1px solid #F2F2F2;
			}

			.select-store-list2 {
				width: 100%;
				float: left;
				overflow: hidden;
			}

			.select-store-list2 .right,
			.select-store-list2 .left {
				float: left;
			}

			.select-store-list2 .top {
				width: 75%;
				float: right;
				padding-left: 0;
			}

			.select-store-list2 .top>.right.active,
			.select-store-list2 .top>.right {
				background: no-repeat;
			}

			.select-store-list2 img {
				width: 20%;
				float: left;
				margin-left: 0.5rem;
			}

			.select-store-list2 .top>.right>div:nth-of-type(2),
			.select-store-list2 .top>.right>div:nth-of-type(3) {
				background-position: 0rem 1.8rem
			}

			.select-store-list2 .bottom {
				clear: both;
			}


			.select-store-list2 .top>.right {
    			width: 96%;
    			position: relative;
			}
			.select-store-list2 .top>.right>div:first-of-type>.left {
    			width: 100%;
			}
			.select-store-list2 .top>.right>div:first-of-type>.left span{
    			padding: .2rem .4rem;
    			color: #fff;
    			border-radius: 4px;
    			margin-left: .5rem;
    			/* background-color: #FF9421; */
    			/* background-color: #FF0000; */
			}
			#operating_state_y{
				background-color: #FF9421;
			}
			#operating_state_c{
				background-color: #FF0000;
			}
			.select-store-list2 .top>.right>div:first-of-type>.right {
    			width: 20%;
    			position: absolute;
    			top: 38%;
    			right: 15%;
			}
			.select-store-list2 .top>.right>div:nth-of-type(2), .select-store-list2 .top>.right>div:nth-of-type(3) {
    			line-height: 2.8rem;
			}

			.stars {
				margin-left:20px;
			}

			/*.stars span {*/
				/*background-image: url(../../../images/leoao-coach-mstar.png);*/
				/*background-repeat: no-repeat;*/
				/*background-position: 0 50%;*/
				/*background-size: 0.2rem;*/
				/*width: 0.2rem;*/
				/*height: 0.2rem;*/
			/*}*/

		</style>
	</head>

	<body>
		<div class="order-detail main">

			<div class='demos-header'>
				<h1>查看门店</h1>
				<!-- <div class="sort-title">筛选</div> -->
				<div class="sort-num" id="spancount"></div>
			</div>

			<!--选择上课场地弹窗-->
			<div class="mymask  skcdtc">

				<div class="select-store">
<!-- 					<div class="selector search-box clearfix text-center">
						<div><input class="weui_input" id="xz-city" type="text" value="南京市"><i></i></div>
						<div><input class="weui_input" id="xz-qy" type="text" value="鼓楼区"> <i></i></div>
					</div> -->
					<div class="store-list-box2" id="appenddiv">
<%-- 						<div class="select-store-list2">
							<img src="<%=request.getContextPath()%>/assets/images/201707202140281500558049733.png" />
							<div class="top clearfix">
								<div class="right">
									<div class="clearfix">
										<div class="left">马台街店<span class="position"></span></div>
										<div class="right"><span class="two">13.2km</span></div>
									</div>
									<div>马台街99号城市集市三楼301</div>
									<div>公共私教区</div>
								</div>
							</div>
							<div class="bottom"></div>
						</div> --%>
<%-- 						<div class="select-store-list2">
							<img src="<%=request.getContextPath()%>/assets/images/201707202140281500558049733.png" />
							<div class="top clearfix">
								<div class="right">
									<div class="clearfix">
										<div class="left">马台街店<span class="position"></span></div>
										<div class="right"><span class="two">13.2km</span></div>
									</div>
									<div>马台街99号城市集市三楼301</div>
									<div>公共私教区</div>
								</div>
							</div>
							<div class="bottom">
								<!---->
							</div>
						</div>--%>
<%-- 						<div class="select-store-list2">
							<img src="<%=request.getContextPath()%>/assets/images/201707202140281500558049733.png" />
							<div class="top clearfix">
								<div class="right">
									<div class="clearfix">
										<div class="left">马台街店<span class="position"></span></div>
										<div class="right"><span class="two">13.2km</span></div>
									</div>
									<div>马台街99号城市集市三楼301</div>
									<div>公共私教区</div>
								</div>
							</div>
							<div class="bottom">
								<!---->
							</div>
						</div> --%>

					</div>
					<!---->
				</div>
			</div>

			<a href="personal_center.html">
				<div class="order-btn clearfix">
					<!--<div class="left"><span>总计</span> <span><i>￥</i>19</span>
				</div>-->
					<a href="<%=request.getContextPath()%>/outside/personal/personalinfo"><div class="right">确定</div></a>
				</div>
			</a>
		</div>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/personal/mystores.js"></script>
<script>
var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js" type="text/javascript"></script>
<!-- <scarpt src="http://3gimg.qq.com/lightmap/components/geolocation/geolocation.min.js" /> -->
<!-- <script src="/Content/Scripts/jquery.flexslider.js"></script> -->

		<script type="text/javascript">
			$("#xz-city").picker({
				title: "请选择您的城市",
				cols: [{
					textAlign: 'center',
					values: ['南京市', '济南市', '徐州市']
				}],
				onChange: function(p, v, dv) {
					console.log(p, v, dv);
				},
				onClose: function(p, v, d) {
					console.log("close");
				}
			});
			$("#xz-qy").picker({
				title: "请选择您的区",
				cols: [{
					textAlign: 'center',
					values: ['鼓楼区', '栖霞区', '某某区']
				}],
				onChange: function(p, v, dv) {
					console.log(p, v, dv);
				},
				onClose: function(p, v, d) {
					console.log("close");
				}
			});
		</script>
    <!--  通过 iframe 嵌入前端定位组件，此处没有隐藏定位组件，使用了定位组件的在定位中视觉特效  -->
<iframe id="geoPage" width=0 height=0 frameborder=0  style="display:none;" scrolling="no"
    src="https://apis.map.qq.com/tools/geolocation?key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp">
</iframe>
<!-- <script type="text/JavaScript" src="https://apis.map.qq.com/tools/geolocation?key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp&effect=zoom"></script> -->

    <!-- 接收到位置信息后 通过 iframe 嵌入位置标注组件 -->
    <!-- <iframe id="markPage" width="100%" height="70%" frameborder=0 scrolling="no" src=""></iframe> -->
	</body>

</html>