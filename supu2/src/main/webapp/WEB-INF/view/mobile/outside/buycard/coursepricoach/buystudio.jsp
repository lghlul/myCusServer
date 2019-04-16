<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>

	<head>
		<meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		<title>订单</title>
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
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/style-jl-fk.css">

		<style type="text/css">
			.order-detail .info>div .right .lesson-tap {
				display: inline-block;
				width: 48%;
				line-height: 2rem;
				text-align: center;
				border-radius: 0.2rem;
				-webkit-border-radius: 0.2rem;
				-moz-border-radius: 0.2rem;
				margin-bottom: 0.5rem
			}

			.order-detail .info>div .right .lesson-tap:nth-of-type(2n) {
				float: right
			}

			.zf {
				margin: 1rem 0;
			}

			.le-cashier-payment {
				width: 100%;
				overflow: hidden;
			}

			.le-cashier-payment div {
				float: left;
				padding: 0 .5rem;
			}

			.le-cashier-payment div:first-child {
				margin-top: .75rem;
			}

			.le-cashier-payment .payment.active,
			.le-cashier-payment .payment {
				padding: 1rem 0
			}

			.le-cashier-payment .payment.active .icon-icon_notselected {
				color: #FF0000
			}

			.le-cashier-payment .logo {
				margin: 0.12rem .12rem
			}

			.le-cashier-payment .name {
				font-weight: 400;
				margin-top: .75rem;
			}

			.le-cashier-payment .label {
				color: rgba(0, 0, 0, .3)
			}
			.ads {
    			background-image: none;
			}
		</style>

	</head>

	<body>
		<div id="app">
			<div class="body-box">
				<div class="order-detail main">
					<div class="ads active-bg">
					<!-- 	<div>满10节减100，16节减200，满10节免费礼品3选1！花呗免息活动同享！</div> -->
					</div>

					<!--vue计算开始-->
					<div class="info" v-for="item in data">

						<!--<div class="clearfix">
							<div class="left">购买项目*</div>
							<div class="right clearfix">
								<a href="gm_sijiaoke_jl_fk.html"><span class="lesson-tap active-bg">一对一</span></a>
								<a href="gm_sijiaoke_jl_fk2.html"><span class="lesson-tap not-active">一对二</span></a>
								<div class="tips"></div>
							</div>
						</div>
						-->

						<div class="clearfix">
						<input type=hidden value="${course.id}" id="courseId"></input>
							<div class="left"><span>○</span><span> ${course.coursename}</span></div>
							<div class="right text-right"><span>{{${course.courseamount}}}</span><span></span></div>
						</div>

						<div class="clearfix" style="padding:0;border-bottom:none">
							<!-- <div class="left"><span>课次*</span><span>（8节起售）</span></div>
							<div class="right clearfix">
								<span v-on:click="add($index)" :class="{off:item.count==100}"></span>
								<span>{{item.count}}</span>
								<span class="" v-on:click="reduce($index)" :class="{off:item.count==8}"></span>
							</div> -->
						</div>


						<%-- 		<div class="clearfix">
									<div class="left"><span>课次*</span><span>（${course.totalhours}节起售）</span></div>
									<div class="right clearfix">
									<span v-on:click="add($index)" :class="{off:item.count==100}"  ></span>
									<span id="totalclass">{{item.count}}</span>
									<span class="" v-on:click="reduce($index)" :class="{off:item.count==8}"></span></div>


					</div> --%>
			<!-- 		<a href="pay-city.html">
						<div class="item-box">
							<div class="item-list">
								<span>上课场地*</span> <span><i class="origin">选择意向上课场地</i></span>
							</div>
					</a> -->

					<div class="zf">
						<h3>选择支付方式</h3>
						<div class="le-cashier-payment">
							<div flex="dir:left cross:center" class="payment boder-1px-top active">
								<div>
									<span>
							        <i class="iconfont icon-icon_notselected"></i>
							        </span>
								</div>
								<div>
									<img width="30px" height="30px" src="<%=request.getContextPath()%>/assets/images/outside/wxfk.png" class="logo">
								</div>
								<div class="name">微信</div>
							</div>
						</div>


<!-- 支付--------------------------------------------------------------------------------------- -->
						<a href="javascript:void(0)">
							<div class="order-btn clearfix">
								<div class="left"><span>总计</span> ￥<span id="priceAccount">{{price}}</span> </div>
								<div class="right" id="sure_pay">去支付</div>
								<div class="right" style="display: none;">去支付</div>
							</div>
						</a>
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
        </div>
    </div>
</div>

				</div>
				<!--计算-->
				<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
				<script src="<%=request.getContextPath()%>/assets/js/outside/vue.min.js"></script>
				<script>
					$(function(){
						var name='${course.coursename}';
						var price='${course.courseamount}';
						var count=parseInt('${course.totalhours}');



					var data = [{
							name: name, //项目名称
							price: price, //单价
							id: 1,
							count:count //课次  最低8节
						}
					];

					new Vue({
						el: '#app',
						data: {
							data: data
						},
						computed: {
							price: function() {
								var price =0;
								 for(var i = 0; i < this.data.length; i++) {
									var self = this.data[i];
									price += parseInt(self.price);
								}
								return price;
							}
						},
						methods: {
							add: function($index) {
								var self = this.data[$index];
								if(self.count > 100) {
									return false;
								}
								self.count++;
							},
							reduce: function($index) {
								var self = this.data[$index];
								if(self.count <= count) {
									return false
								};
								self.count--;
							},

						}

					});

					});
				</script>

<script>
      $(function() {
        $(".mint-msgbox-cancel").click(function() {
          $(".mint-msgbox-wrapper").hide();
          $(".mask").hide();
        })
      })
</script>

<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
  var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>
$(function(){

	 var openId='${openId}';
	 console.log("openId="+openId);


	  var appId = "";
	  var timeStamp = "";
	  var nonceStr = "";
	  var packageValue = "";
	  var paySign = "";
	  var order_id = "";
 	 $('#sure_pay').click(function(){
		var pay_gz = $('#priceAccount').text();
			//会员卡id
		var cid=$('#courseId').val();
			//总课时
		var totalClass=$('#totalclass').text();

		//pay_gz = parseInt(pay_gz);
        $.post(baseUrl+"/topayServlet?order_id="+order_id+"&total_fee="+pay_gz+"&totalClass="+totalClass+"&openid="+openId+"&cid="+cid+'&type=3', function(data){
			var res = JSON.parse(data);
            if (res.code == 1) {
            	  appId = res.appid;
            	  timeStamp = res.timeStamp;
            	  nonceStr = res.nonceStr;
            	  packageValue = res.package;
            	  paySign = res.sign;
            	  order_id = res.order_id;
            	  //total_fee
            	  WeixinJSBridge.invoke('getBrandWCPayRequest',{
            	       "appId" : appId,"timeStamp" : timeStamp, "nonceStr" : nonceStr, "package" : packageValue,"signType" : "MD5", "paySign" : paySign
            	         },function(res){
            	                if(res.err_msg == "get_brand_wcpay_request:ok"){
            	                    //alert("支付成功");
            	                	   window.location.href=baseUrl+"/outside/buyCard/buyStudioSuccess";

            	                }else if(res.err_msg == "get_brand_wcpay_request:cancel"){
            	                    //alert("取消支付");
            	                	$('#errorMassage').text("");
            	        			$('.failmask').show();
            	    				$('#errorMassage').text("取消支付");
            	    				$('#alertFail').show();
            	                }else{
            	                   //alert("支付失败");
            	                	$('#errorMassage').text("");
            	        			$('.failmask').show();
            	    				$('#errorMassage').text("支付失败");
            	    				$('#alertFail').show();
            	                }
            	        });
            }
        });


	 });




});

</script>
	</body>

</html>