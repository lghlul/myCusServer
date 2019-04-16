<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>基础团课</title>
    <meta content="email=no" name="format-detection">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
    <style type="text/css">
        .le-class-items {
            display: none;
        }

        .wrap .tabbar {
            height: auto;
        }

        .storeselect {
            cursor: pointer
        }

        .mint-tab-container-item.card-list.city-list .mint-cell {
            cursor: pointer
        }

        .clickgrouplesson {
            cursor: pointer
        }
    </style>
</head>
<body style="overflow: hidden;">
<div id="app" style="height: 100%; overflow: initial;">
    <div class="wrap isHeaderBar isTabBar">
        <div>
            <div class="cb-list-main">
                <div class="weekTime dark le-class-navbar-fixed">
                    <div class="mint-navbar dark weui_navbar">
                        <c:forEach items="${weekAndDate }" var="items" varStatus="status">
                            <c:choose>
                                <c:when test="${items.week=='今天'}">
                                    <a class="mint-tab-item  is-selected  changeDate" data-data="今天"
                                       data-id="${status.index }" data-date="${items.date }"
                                       data-week="${items.numWeek }">
                                        <div class="mint-tab-item-icon"></div>
                                        <div class="mint-tab-item-label">
                                            <p class="week">
                                                <!---->${items.week }</p>
                                            <p class="day">今</p>
                                            <input type="hidden" value="${items.date }" name="date" id="getSelectDate">
                                            <input type="hidden" value="${items.numWeek }" name="week"
                                                   id="getSelectWeek">
                                            <input type="hidden" value="0" name="signType" id="getSign">

                                        </div>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a class="mint-tab-item changeDate" data-data="周${items.week }"
                                       data-id="${status.index }" data-date="${items.date }"
                                       data-week="${items.numWeek }">
                                        <div class="mint-tab-item-icon"></div>
                                        <div class="mint-tab-item-label">
                                            <p class="week"><span class="preText">周</span>${items.week }</p>
                                            <p class="day">${fn:split(items.simpleDate,".")[1]}</p>
                                        </div>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <input type="hidden" value="" id="biaojiinput">
                        <input type="hidden" value="今天" id="weekinput">
                    </div>
                </div>
                <div style="height: 32px;"></div>
            </div>
            <div style="font-size:20%;">
                <div style="margin-left:10px;"><img style="width:30px;height:30px;"
                                                    src="<%=request.getContextPath()%>/assets/images/appoint/健身房.png"
                                                    alt=""><span>上课时间</span> <span id="noTime" style="color:#fe0000;"></span></div>

                <div style="background-color: #f2f2f2">
                    <ul id="priCoachTime">

                    </ul>
                </div>
                <div>
                    <div style="margin-left:10px;"><img style="width:30px;height:30px"
                                                        src="<%=request.getContextPath()%>/assets/images/appoint/时间.png"
                                                        alt=""><span>已预约时间</span></div>
                    <ul id="appointTime" style="background-color: #f2f2f2">
                    </ul>
                </div>
                <div style="margin-left:10px;">
                    <p>选择预约时间</p>
                    <img src="<%=request.getContextPath()%>/assets/images/appoint/预约.png" alt="">
                    <input type="text" name="appTime" id="appTime"/>
                    <%--<div class="demos">--%>
                    <%--<label for="appTime">时间</label>--%>
                    <%--<input type="text" name="appTime" id="appTime" />--%>
                    <%--</div>--%>
                </div>

                <div id="submit"
                     style="background-color: #fe0000; color: #fff;text-align: center;height: 60px;line-height: 60px;margin: 0 auto;margin-top: 20px;">
                    预约
                </div>
                <%--<div class="content">--%>
                <%--<div class="demos">--%>
                <%--<label for="appDate">日期</label>--%>
                <%--<input type="text" name="appDate" id="appDate" />--%>
                <%--</div>--%>
                <%--<div class="demos">--%>
                <%--<label for="appDateTime">日期时间</label>--%>
                <%--<input type="text" name="appDateTime" id="appDateTime" />--%>
                <%--</div>--%>
                <%--<div class="demos">--%>
                <%--<label for="appTime">时间</label>--%>
                <%--<input type="text" name="appTime" id="appTime" />--%>
                <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/assets/js/datePicker/dev/jquery-1.9.1.js"></script>
<%--<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>--%>
<script src="<%=request.getContextPath()%>/assets/js/datePicker/dev/js/mobiscroll.core-2.5.2.js"
        type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/datePicker/dev/js/mobiscroll.core-2.5.2-zh.js"
        type="text/javascript"></script>

<link href="<%=request.getContextPath()%>/assets/js/datePicker/dev/css/mobiscroll.core-2.5.2.css" rel="stylesheet"
      type="text/css"/>
<link href="<%=request.getContextPath()%>/assets/js/datePicker/dev/css/mobiscroll.animation-2.5.2.css" rel="stylesheet"
      type="text/css"/>
<script src="<%=request.getContextPath()%>/assets/js/datePicker/dev/js/mobiscroll.datetime-2.5.1.js"
        type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/assets/js/datePicker/dev/js/mobiscroll.datetime-2.5.1-zh.js"
        type="text/javascript"></script>

<!-- S 可根据自己喜好引入样式风格文件 -->
<script src="<%=request.getContextPath()%>/assets/js/datePicker/dev/js/mobiscroll.android-ics-2.5.2.js"
        type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/assets/js/datePicker/dev/css/mobiscroll.android-ics-2.5.2.css"
      rel="stylesheet" type="text/css"/>

<%--<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>--%>
<%--<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>--%>
<script>
    var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>
    $(function () {
        var coachId;
        var dateTime;
        var htmlSting = "";
        var htmlString1 = "";
        var coachId = "${coachId}";
        var id = "${id}";
        var dateTime = $(".changeDate").eq(0).find("#getSelectDate").val();
        //查询私教可预约时间
        getPriCoachTime(coachId, dateTime);

        function converTime(time) {
            var time = time.replace(/-/g,'/');
            var date = new Date(time);
            var hour = date.getHours();
            var min = date.getMinutes();
            if (min < 10) {
                min = "0" + min;
            }
            return hour + ":" + min;
        }

        $('.changeDate').click(function () {	//赋值
            dateTime = $(this).data('date');
            $('#getSelectDate').val($(this).data('date'));
            $('#getSelectWeek').val($(this).data('week'));
            $('#getSign').val($(this).data('id'));
            $('#weekinput').val($(this).data('data'));
            $(this).siblings().find(".day").css({
                "background-color": "#fff",
                "color": "#000"
            });
            $(this).find(".day").css({"background-color": "red", "color": "#fff"});
            //查询私教可预约时间
            getPriCoachTime(coachId, dateTime);
        });

       // 获取选中时间的23点
        function getTime(time){
            var now = new Date(parseInt(time));
            now.setHours(23);
            now.setMinutes(0);
            now.setSeconds(0);
            return Date.parse(now);
        }

        $("#submit").click(function () {
            // if( $("#noTime").text()=="教练休息中"){
            //     alert("教练今天休息，无法预约");
            //     return false;
            // }
            var startTime = dateTime + " " + $("#appTime").val() + ":00";
            startTime = startTime.replace(/-/g,'/');
            // alert("开始时间"+startTime);
            var startTimeStamp =Date.parse(new Date(startTime));
           // alert("这天23点"+getTime(startTimeStamp));
            var endTimeStamp = startTimeStamp + 60 * 60 * 1000;
           if(startTimeStamp>getTime(startTimeStamp)){
               alert("预约时间不能超过23点");
               return;
           }
            var data = {"id": id, "startTime": startTimeStamp, "endTime": endTimeStamp}
            $.post(baseUrl + "/outside/priCoach/appoint",data, function (data) {
                if(data.resultCode=="670"){
                    alert("私教不在工作时间内");
                }
                else if(data.resultCode=="676"){
                    alert("只能选择当前时间以后时间预约");
                }
                else if(data.resultCode=="671"){
                    alert("私教时间已被预约");
                }
                else if(data.resultCode=="200"){
                    alert("预约成功");
                    window.location=baseUrl+'/outside/aboutClass/privatePage';
                }
            });
        });

        function getPriCoachTime(coachId, dateTime) {
            $.ajax({
                type: "GET",
                //data:$('#form').serialize(),
                // coachId = 6  dateTime=2018-11-06
                // url:baseUrl+'/outside/priCoach/toAppoint?coachId=6&dateTime=2018-11-06',
                // url: "http://n1987212y0.51mypc.cn/outside/priCoach/toAppoint?coachId=9&dateTime=2018-11-06",
                url: baseUrl + "/outside/priCoach/toAppoint?coachId=" + coachId + "&dateTime=" + dateTime,
                success: function (data) {
                    if (data != null) {
                        htmlSting = "";
                        htmlString1 = "";
                        var storeList = data.records;
                        var coachTimeList = storeList.coachTimeList;
                        var appointList = storeList.appointList;

                        if(coachTimeList.length == 0){
                            $("#noTime").text("教练休息中");
                        }
                        // $("#priCoachTime").text(storeList.coachTimeList);

                        for (var i = 0; i < coachTimeList.length; i++) {
                            htmlSting += '<li>' + converTime(coachTimeList[i].starttime) + '-' + converTime(coachTimeList[i].endtime) + '</li>';
                        }
                        $("#priCoachTime").html(htmlSting);

                        for (var i = 0; i < appointList.length; i++) {
                            htmlString1 += '<li>' + converTime(appointList[i].starttime) + '-' + converTime(appointList[i].endtime) + '</li>';
                        }
                        $("#appointTime").html(htmlString1);
                        //alert(storeList.distance+"km");
                    }
                }
            });
            // var data ={"total":null,"records":{"coachTimeList":[{"id":1445,"coachid":9,"type":2,"selectymonth":"2018-11","starttime":"2018-11-06 15:00:00","endtime":"2018-11-06 23:00:00","day":"06","status":null,"addtime":1541406235000}],"appointList":[{"id":14188,"courseid":49,"courseId":null,"userid":3685,"storeid":null,"type":11,"status":3,"appointtime":1541433600000,"starttime":"2018-11-06 15:00:00","endtime":"2018-11-06 16:00:00","addtime":1541491549000,"coachId":9,"pageNo":null,"pageSize":null,"appointTimeStr":null},{"id":14189,"courseid":49,"courseId":null,"userid":3685,"storeid":null,"type":11,"status":3,"appointtime":1541433600000,"starttime":"2018-11-06 15:00:00","endtime":"2018-11-06 16:00:00","addtime":1541491670000,"coachId":9,"pageNo":null,"pageSize":null,"appointTimeStr":null},{"id":14190,"courseid":49,"courseId":null,"userid":3685,"storeid":null,"type":11,"status":3,"appointtime":1541433600000,"starttime":"2018-11-06 15:00:00","endtime":"2018-11-06 16:00:00","addtime":1541493522000,"coachId":9,"pageNo":null,"pageSize":null,"appointTimeStr":null},{"id":14191,"courseid":49,"courseId":null,"userid":3685,"storeid":null,"type":11,"status":3,"appointtime":1541433600000,"starttime":"2018-11-06 15:00:00","endtime":"2018-11-06 16:00:00","addtime":1541493742000,"coachId":9,"pageNo":null,"pageSize":null,"appointTimeStr":null},{"id":14192,"courseid":49,"courseId":null,"userid":3685,"storeid":null,"type":11,"status":3,"appointtime":1541433600000,"starttime":"2018-11-06 15:00:00","endtime":"2018-11-06 16:00:00","addtime":1541493969000,"coachId":9,"pageNo":null,"pageSize":null,"appointTimeStr":null},{"id":14193,"courseid":49,"courseId":null,"userid":3685,"storeid":null,"type":11,"status":3,"appointtime":1541433600000,"starttime":"2018-11-06 17:10:00","endtime":"2018-11-06 18:00:00","addtime":1541494937000,"coachId":9,"pageNo":null,"pageSize":null,"appointTimeStr":null}]},"resultCode":200,"message":"成功"};
        }
    })
</script>
<script type="text/javascript">
    $(function () {
        var currYear = (new Date()).getFullYear();
        var opt = {};
        opt.date = {preset: 'date'};
        //opt.datetime = { preset : 'datetime', minDate: new Date(2012,3,10,9,22), maxDate: new Date(2014,7,30,15,44), stepMinute: 5  };
        opt.datetime = {preset: 'datetime'};
        opt.time = {preset: 'time'};
        opt.default = {
            theme: 'android-ics light', //皮肤样式
            // display: 'modal', //显示方式
            display: 'bottom', //显示方式
            mode: 'scroller', //日期选择模式
            lang: 'zh',
            startYear: currYear - 10, //开始年份
            endYear: currYear + 10 //结束年份
        };

        $("#appDate").val('').scroller('destroy').scroller($.extend(opt['date'], opt['default']));
        var optDateTime = $.extend(opt['datetime'], opt['default']);
        var optTime = $.extend(opt['time'], opt['default']);
        $("#appDateTime").mobiscroll(optDateTime).datetime(optDateTime);
        $("#appTime").mobiscroll(optTime).time(optTime);

        //下面注释部分是上面的参数可以替换改变它的样式
        //希望一起研究插件的朋友加我个人QQ也可以，本人也建个群 291464597 欢迎进群交流。哈哈。这个不能算广告。
        // 直接写参数方法
        //$("#scroller").mobiscroll(opt).date();
        // Shorthand for: $("#scroller").mobiscroll({ preset: 'date' });
        //具体参数定义如下
        //{
        //preset: 'date', //日期类型--datatime --time,
        //theme: 'ios', //皮肤其他参数【android-ics light】【android-ics】【ios】【jqm】【sense-ui】【sense-ui】【sense-ui】
        //【wp light】【wp】
        //mode: "scroller",//操作方式【scroller】【clickpick】【mixed】
        //display: 'bubble', //显示方【modal】【inline】【bubble】【top】【bottom】
        //dateFormat: 'yyyy-mm-dd', // 日期格式
        //setText: '确定', //确认按钮名称
        //cancelText: '清空',//取消按钮名籍我
        //dateOrder: 'yymmdd', //面板中日期排列格
        //dayText: '日',
        //monthText: '月',
        //yearText: '年', //面板中年月日文字
        //startYear: (new Date()).getFullYear(), //开始年份
        //endYear: (new Date()).getFullYear() + 9, //结束年份
        //showNow: true,
        //nowText: "明天",  //
        //showOnFocus: false,
        //height: 45,
        //width: 90,
        //rows: 3}

    });
</script>
<iframe id="geoPage" width=0 height=0 frameborder=0 style="display:none;" scrolling="no"
        src="https://apis.map.qq.com/tools/geolocation?key=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77&referer=myapp">
</iframe>
</body>

</html>

