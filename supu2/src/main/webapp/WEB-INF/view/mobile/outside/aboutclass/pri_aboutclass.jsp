<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<html style="font-size: 10px;">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <title>约课-私教课</title>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/style-yk-sjk-yiyue.css">
    <style>
        .blank > div:first-of-type {
            margin-top: 4.5rem;
        }

        .right {
            float: right;
        }

        .mint-tabbar.bottom-tab-bar.boder-1px-top.tabbar.is-fixed.intTabBar {
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

        .mint-tab-item.is-selected .mint-tab-item-label,
        .mint-tab-item.is-selected .mint-tab-item-label a {
            color: #FF0000;
        }

        .mint-tabbar > .mint-tab-item.is-selected {
            background-color: #fff;
        }

        .bottom-tab-bar .mint-tab-item-label, .bottom-tab-bar .mint-tab-item-label a {
            font-size: 15px;
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
        <div infinite-scroll-disabled="loading" infinite-scroll-distance="200" class="my-lesson">
            <div id="map" class="position-btn clearfix text-center">
                <div class="one">
                    <img src="https://cdn.leoao.com/leoao-coach-mposition000.png" alt="">
                    <span class="fn-left">南京市<i></i></span>
                </div>
                <div class="two more fn-right">
                    <span>私教课<i></i></span>
                </div>
            </div>
            <div class="mask sjMask" style="display: none;">
                <div class="sj-text">
                    选择业务
                    <img src="<%=request.getContextPath()%>/assets/images/leoao-coach-mxb00.png">
                </div>
                <ul class="clearfix">
                    <a href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
                        <li class="one">基础团课</li>
                    </a>
                    <a href="<%=request.getContextPath()%>/outside/aboutClass/privatePage">
                        <li class="active two">私教课</li>
                    </a>
                    <a href="<%=request.getContextPath()%>/outside/aboutClass/courseGroupPage">
                        <li class="three">训练营</li>
                    </a>
                    <a href="<%=request.getContextPath()%>/outside/aboutClass/studioPage">
                        <li class="four">工作室</li>
                    </a>
                </ul>
            </div>


            <%--<c:choose>--%>
            <%--<c:when test="${empty priclass}">--%>
            <%--<div class="blank">--%>
            <%--<div>你还没有私教课哦</div>--%>
            <%--<div>--%>
            <%--&lt;%&ndash; 	<a href="<%=request.getContextPath()%>/outside/buyCard/coursePriCoachPage">--%>
            <%--<span class="">19元体验课专属私教</span>--%>
            <%--</a> &ndash;%&gt;--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
            <%--<c:forEach items="${priclass }" var="items">--%>
            <%--<div class="my-lesson-list clearfix">--%>
            <%--<div class="left"><img src="${items.image }"></div>--%>
            <%--<div class="center">--%>
            <%--<div class="center-box">--%>
            <%--<div class="lesson-title">--%>
            <%--${items.nickname }--%>
            <%--<a href="tel://${items.phonenumber }"></a>--%>
            <%--</div>--%>
            <%--<div class="lesson-name">${items.coursename }</div>--%>
            <%--<div class="class-info"><span>未预约 ${items.totalclass-items.appointCount } <i>|</i></span> <span>总课时 ${items.totalclass } <i>|</i></span> <span>已预约 <i class="main">${items.appointCount }</i></span></div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="right">--%>
            <%--<form id="form${items.id}" action="<%=request.getContextPath()%>/outside/aboutClass/appointPage" method="POST">--%>
            <%--<input type="hidden" value="${items.coachs}" name="coachid"></input>--%>
            <%--<input type="hidden" class="lng" value="" name="lng" id="lng"></input>--%>
            <%--<input type="hidden" class="lat" value="" name="lat" id="lat"></input>--%>
            <%--<input type="hidden" value="${items.coachname}" name="coachname"></input>--%>
            <%--<input type="hidden" value="${items.courseid}" name="courseid"></input>--%>
            <%--<a class="clickspan" data-id="${items.id}"><span class="one fn-right">在线预约</span></a>--%>
            <%--</form>--%>

            <%--</div>--%>
            <%--</div>--%>
            <%--</c:forEach>--%>
            <%--</c:otherwise>--%>
            <%--</c:choose>--%>

            <%--<div class="blank">--%>
            <%--&lt;%&ndash;<div>你还没有私教课哦</div>&ndash;%&gt;--%>
            <%--<div>--%>
            <%--</div>--%>
            <div id="coachList">
                <%--<div class="my-lesson-list clearfix">--%>
                    <%--<div class="left"><img src="/upload/1508935649577.jpg"></div>--%>
                    <%--<div class="center">--%>
                        <%--<div class="center-box">--%>
                            <%--<div class="lesson-title">--%>
                                <%--精华--%>
                                <%--<a href="tel://18512518085"></a>--%>
                            <%--</div>--%>
                            <%--<div class="lesson-name">测试体验课，请勿购买</div>--%>
                            <%--<div class="class-info"><span>未预约 ${items.totalclass-items.appointCount } <i>|</i></span> <span>总课时 100 <i>|</i></span>--%>
                                <%--<span>已预约 <i class="main">${items.appointCount }</i></span></div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="right">--%>
                        <%--<a href="<%=request.getContextPath()%>/outside/aboutClass/appointPage" class="clickspan" data-id="${items.id}"><span class="one fn-right">在线预约</span></a>--%>
                    <%--</div>--%>
                <%--</div>--%>

            </div>


            <!---->
            <%@ include file="/WEB-INF/view/common/mobile_bottom.jsp" %>
            <!-- 		<div class="bottom-nav text-center">
                        <ul class="clearfix">
                            <li class="active">
                                <a href="index.html">约课</a>
                            </li>
                            <li>
                                <a href="gm_Huiyuanka.html">购买</a>
                            </li>
                            <li>
                                <a href="my_lesson.html">我的课程</a>
                            </li>
                            <li>
                                <a href="personal_center.html">个人中心</a>
                            </li>
                        </ul>
                    </div> -->
        </div>
    </div>

    <script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
    <%--<script src="<%=request.getContextPath()%>/assets/js/outside/aboutclass/pri_aboutclass.js"></script>--%>
    <script>
        var baseUrl = '${pageContext.request.contextPath}';
    </script>
    <script>
        $(function () {
            var htmlString="";
            getPriCoachList();

            function getPriCoachList() {
                $.ajax({
                    type: "GET",
                    url: baseUrl+"/outside/priCoach/list",
                    success: function (data) {
                        if (data != null) {
                          var priCoachList =  data.records;
                          for(var i=0;i<priCoachList.length;i++){
                              htmlString+='<div data-courseId="'+priCoachList[i].courseId+'" data-coachId="'+priCoachList[i].coachId+'" data-id="'+priCoachList[i].id+'" class="my-lesson-list clearfix">\n' +
                                  '                    <div class="left"><img src="<%=request.getContextPath()%>/'+priCoachList[i].headImg +'"></div>\n' +
                                  '                    <div class="center">\n' +
                                  '                        <div class="center-box">\n' +
                                  '                            <div class="lesson-title">\n' +
                                  priCoachList[i].coachName +
                                  '                                <a href="tel://'+priCoachList[i].phoneNumber+'"></a>\n' +
                                  '                            </div>\n' +
                                  '                            <div class="lesson-name">'+priCoachList[i].courseName +'</div>\n' +
                                  '                            <div class="class-info"><span>未预约'+(priCoachList[i].totalClass-priCoachList[i].useClass)+'<i>|</i></span> <span>总课时'+priCoachList[i].totalClass+' <i>|</i></span>\n' +
                                  '                                <span>已预约 <i class="main">'+ priCoachList[i].useClass+'</i></span></div>\n' +
                                  '                        </div>\n' +
                                  '                    </div>\n' +
                                  '                    <div class="right">\n' +
                                  '                        <a href="<%=request.getContextPath()%>/outside/aboutClass/appointPage?coachId='+priCoachList[i].coachId+'&id='+priCoachList[i].id +'" class="clickspan" data-id=""><span class="one fn-right">在线预约</span></a>\n' +
                                  '                    </div>\n' +
                                  '                </div>';
                          }
                          $("#coachList").html(htmlString);
                            $(".my-lesson-list").click(function(){
                                var id=$(this).attr("data-id");
                                var coachId = $(this).attr("data-coachId");
                                var courseId = $(this).attr("data-courseId");
                                window.location.href="/outside/aboutClass/appoList?coachId="+coachId+"&id="+id+"&courseId="+courseId;
                            })
                        }
                    }
                    })
            }


            $(".more").click(function () {
                $(".mask").show();
            });
            $(".sj-text").click(function () {
                $(".mask").hide();
            });
        });
    </script>

</body>
<iframe id="geoPage" width=0 height=0 frameborder=0 style="display:none;" scrolling="no"
        src="https://apis.map.qq.com/tools/geolocation?key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp">
</iframe>
</html>
