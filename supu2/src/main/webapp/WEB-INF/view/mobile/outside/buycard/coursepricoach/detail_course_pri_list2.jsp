<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
	<head>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<title>私教课程详情页</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
		<link href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
		<link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
		<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
			.comment {
				background-color: red;
				color: #fff;
				text-align: center;
				width: 100%;
				height: 31px;
				font-size: 20px;
			}
			.commentList {
				font-size:12px;
				margin-bottom:30px;
			}
			.comment_title {
				font-size:16px;margin-top:12px;margin-left:12px;margin-bottom: 14px;
			}

			.commentList .item{
				width: 100%;
				height: 96px;
			}

			.item img {
				height:66px;
				display: inline-block;
				margin-bottom: 5px;
				float: left;
				margin-left:10px;
			}

			.item .right{
				float: right;
				width: 76%;
			}

			.item .right p {
				margin-bottom: 5px
			}
			.stars span {
				/*background-image: url(../../../images/leoao-coach-mstar.png);*/
				/*background-repeat: no-repeat;*/
				background-position: 0 50%;
				background-size: 0.2rem;
				width: 0.2rem;
				height: 0.2rem;
			}
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

					<div class="header-img" style="background-image: url('${coursePriCoach.courseImg }');"></div>
					<header class="header">
						<h3 class="title">${coursePriCoach.courseName }</h3>
						<%-- <div flex="dir:left main:justify">
							<!-- <div class="remain">仅剩6个名额</div> -->
						</div>
						<div class="info boder-1px-top">
							<div class="lable boder-1px-bottom">
							<p class="time">开营日期
								${startDate }
							</p>
							<input type="hidden" value="${startDate }" id="startDate">
							<input type="hidden" value="${endDate }" id="endDate">
							<input type="hidden" value="${courseExcGroup.id }" id="courseid">
							<p class="time">
							<c:forEach items="${weekTime.courseExcTimeDtos }" var="items">
								周${items.concatweek }&nbsp;${items.starttime }~${items.endtime }&nbsp;
							</c:forEach>
							</p>
							<c:choose>
								<c:when test="${courseExcGroup.coursetimetype==1 }">
									<p class="time">指定日期  <fmt:formatDate value="${courseExcGroup.startdate}" pattern="yyyy-MM-dd" />至<fmt:formatDate value="${courseExcGroup.enddate}" pattern="yyyy-MM-dd" /> ${courseExcGroup.starthour }:${courseExcGroup.startmin }-${courseExcGroup.endhour }:${courseExcGroup.endmin }</p>
								</c:when>
								<c:when test="${courseExcGroup.coursetimetype==2 }">
									<p class="time">每天${courseExcGroup.starthour }:${courseExcGroup.startmin }-${courseExcGroup.endhour }:${courseExcGroup.endmin } 预计<fmt:formatDate value="${courseExcGroup.courseexpstart}" pattern="yyyy-MM-dd" />开班</p>
								</c:when>
								<c:when test="${courseExcGroup.coursetimetype==3 }">
									<p class="time">每周${courseExcGroup.week } ${courseExcGroup.starthour }:${courseExcGroup.startmin }-${courseExcGroup.endhour }:${courseExcGroup.endmin }预计<fmt:formatDate value="${courseExcGroup.courseexpstart}" pattern="yyyy-MM-dd" />开班</p>
								</c:when>
								<c:when test="${courseExcGroup.coursetimetype==4 }">
									<p class="time">每月 <fmt:formatDate value="${courseExcGroup.startdate}" pattern="yyyy-MM-dd" />至<fmt:formatDate value="${courseExcGroup.enddate}" pattern="yyyy-MM-dd" /> ${courseExcGroup.starthour }:${courseExcGroup.startmin }-${courseExcGroup.endhour }:${courseExcGroup.endmin }  预计<fmt:formatDate value="${courseExcGroup.courseexpstart}" pattern="yyyy-MM-dd" />开班</p>
								</c:when>
							</c:choose>

								<a href="#/mapview?lat=32.071392&amp;lng=118.773575&amp;address=%E9%A9%AC%E5%8F%B0%E8%A1%97%E5%BA%97%E9%A9%AC%E5%8F%B0%E8%A1%9799%E5%8F%B7%E5%9F%8E%E5%B8%82%E9%9B%86%E5%B8%82%E4%B8%89%E6%A5%BC301&amp;name=%E9%A9%AC%E5%8F%B0%E8%A1%97%E5%BA%97%E9%A9%AC%E5%8F%B0%E8%A1%9799%E5%8F%B7%E5%9F%8E%E5%B8%82%E9%9B%86%E5%B8%82%E4%B8%89%E6%A5%BC301" class="">
									<div flex="dir:left box:justify cross:center" class="info-address">
										<i class="icon iconfont icon-iconfont-position"></i>
										<span class="one-single-file">${store.address }</span>
										<!-- <span class="arrow-left"></span> -->
									</div>
								</a>
							</div> --%>
							<div class="lable">
							<c:forEach items="${coachs }" var="items" >
							    <a href="<%=request.getContextPath()%>/outside/buyCard/coachPriDetail?id=${items.id}">
 								<div flex="dir:left box:last" class="coach-info-box coach-info">
									<div class="coach-info">
										<p class="coach-name">${items.nickName }</p>
										<p class="coach-intro clamp-2">${items.goodat }</p>
										<!-- <div class="getMore"><i class="iconfont icon-xiangshangsanjiaoshouqi"></i></div> -->
									</div>
									<div class="coach-img">
										<img src="${items.headImg }">
										<!---->
									</div>
								</div>
								</a>
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
						<div class="le-panel-heading">训练营详情</div>

						<article class="weui_article">
								${coursePriCoach.courseDetail }
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
					<%-- <div flex="dir:left box:mean cross:center" class="le-buy-box boder-1px-top">
						<div class="buy-info">
							<div>
								<div class="price">
									<small>¥ </small>${courseExcGroup.courseamount}</div>
								<span class="num"> / 共${courseExcGroup.totalhours }课时</span>
							</div>
						</div>
							<div class="buy-btn" id="buyexccourse">
								<button class="mint-button mint-button--primary mint-button--large">
	                        <label class="mint-button-text">购买</label>
	                    </button>
							</div>
					</div> --%>
					<div style="height: 0.85rem;"></div>
				</div>
			<p class="comment_title">评论</p>
			<div class="commentList">
				<div class="item">
					<img src="<%=request.getContextPath()%>/assets/images/1_3.jpg" alt="">
					<div class="right">
					<p>王涛</p>
					<p>医术高超</p>
					<p>11天前</p>
					</div>
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/assets/images/1_3.jpg" alt="">
					<div class="right">
						<p>王涛</p>
						<p>医术高超</p>
						<p>11天前</p>
					</div>
				</div>
			</div>
			<div class="comment">评价</div>
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
		<script src="<%=request.getContextPath()%>/assets/js/jquery.rating-stars.min.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/time.js"></script>

 <script>
var baseUrl = '${pageContext.request.contextPath}';
var sourceID = "${id}";
</script>
		<script>
            getCommentList();
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

			function getCommentList(){
                $.ajax({
                    type:"GET",
                    url:baseUrl+"/outside/comment/getCommenListPublic?source=1&sourceID="+sourceID+"&limitstart=1&limitend=10",
                    success:function(data){
                        if(data.resultCode == "200"){
                         showList(data.records);
                        }
                    }
                })
			}

			function showList(list){
                var htmlString = "";
                var star="";
			    for(var i =0;i<list.length;i++){
			        if(list[i].startlevel == 5){
			            star = '<span></span><span></span><span></span><span></span><span></span>';
					}
                    if(list[i].startlevel == 4){
                        star = '<span></span><span></span><span></span><span></span>';
                    }
                    if(list[i].startlevel == 3){
                        star = '<span></span><span></span><span></span>';
                    }
                    if(list[i].startlevel == 2){
                        star = '<span></span><span></span>';
                    }
                    if(list[i].startlevel == 1){
                        star = '<span></span>';
                    }
                    htmlString+='<div class="item"><img src="'+list[i].head+'" alt="">' +
						'<div class="right"><p>'+list[i].userName+'</p><span> <div class="stars">'+ star+ '</div></span>' +
                        '<p>'+list[i].content+'</p>' +
                        '<p>'+Time.getFormatTime(list[i].addtime)+'</p></div></div>';
				}
				$(".commentList").html(htmlString);
			}

			$(".comment").on("click",function(){
			    //弹出框
				window.location.href= "/outside/comment/priCourseComment?id=3";
			})
		</script>
		<script>
            // var Time = {
            //     //获取当前时间戳
            //     getUnix:function(){
            //         var date = new Date();
            //         return date.getTime();
            //
            //     },
            //     //获取今天0点0分0秒时间戳
            //     getTodayUnix:function(){
            //         var date = new Date();
            //         date.setHours(0);
            //         date.setMinutes(0);
            //         date.setSeconds(0);
            //         date.setMilliseconds(0);
            //         return date.getTime();
            //
            //     },
            //     //获取今年1月1日0点0分0秒的时间戳
            //     getYearUnix:function(){
            //         var date = new Date();
            //         date.setMonth(0);
            //         date.setDate(1);
            //         date.setHours(0);
            //         date.setMinutes(0);
            //         date.setSeconds(0);
            //         date.setMilliseconds(0);
            //         return date.getTime();
            //
            //
            //     },
            //     //获取标准年月日
            //     getLastDate:function(time){
            //         var date = new Date(time);
            //         var month = date.getMonth() +1 <10 ?'0'+(date.getMonth()+1):date.getMonth()+1;
            //         var day = date.getDate() < 10 ? '0'+date.getDate():date.getDate();
            //         return date.getFullYear()+'-'+month+'-'+day;
            //
            //     },
            //     //转换时间
            //     getFormatTime:function(timeStamp){
            //         var now = this.getUnix();
            //         var today = this.getTodayUnix();
            //         var year = this.getYearUnix();
            //
            //         var timer =(now - timeStamp)/1000;
            //         var tip = '';
            //
            //         if(timer <= 0){
            //             tip = '刚刚';
            //
            //         }else if (Math.floor(timer/60) <= 0){
            //             tip = '刚刚';
            //         }
            //         else if (timer < 3600){
            //             tip = Math.floor(timer/60)+'分钟前';
            //
            //         }else if(timer >= 3600 && (timeStamp-today >= 0)){
            //             tip = Math.floor(timer/3600)+'小时前';
            //
            //         }else if (timer/86400 <= 31){
            //             tip=Match.ceil(timer/86400)+'天前';
            //         }
            //         else{
            //             tip=this.getLastDate(timeStamp);
            //         }
            //         return tip;
            //
            //     }
            // }
		</script>
	</body>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/coursegroup/detail_course_group_list.js"></script>
</html>