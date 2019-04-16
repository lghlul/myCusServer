<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp" %>
<html>

<head>
    <meta charset="utf-8">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <title>预约列表</title>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/style-yk-sjk-yiyue.css">
    <style>
    .appointCoach{
        background-color: #f63e3e;
        width:80%;
        height:40px;
        border-radius:10px;
        line-height:40px;
        margin:0 auto;
        text-align:center;
        color:#fff;
        margin-top:40px;
        margin-bottom:40px;

    }
        .item{
            height: 50px;
            background-color: #e0e2e8;
            margin-bottom: 20px;
            line-height: 50px;
            width: 63%;
            margin-left: auto;
            margin-right: auto;
            font-size:16px;
            position: relative;
        }

        .item img{
            width: 50px;
            height: 50px;
            right: 0px;
            top: 0px;
            position: absolute;
        }

        .cancel{
            position: absolute; right: -55px;
            top: 0px;
            font-size: 16px;
            background-color: red;
            color: #fff;
            padding-left: 5px;
            padding-right: 5px;
            border-radius:10px;
        }


    </style>
</head>

<body>
<div id="app">
    <div class="body-box">
        <div class="appointCoach">预约私教</div>

            <div id="appointList">
                <%--<div class="item"><span>12:00-13:00</span>--%>
                    <%--<img src="<%=request.getContextPath()%>/assets/images/appoint/已完成.png" alt="">--%>
                <%--</div>--%>
                <%--<div class="item"><span>12:00-13:00</span>--%>
                    <%--<img src="<%=request.getContextPath()%>/assets/images/appoint/已完成.png" alt=""></div>--%>
                <%--<div class="item"><span>12:00-13:00</span>--%>
                    <%--<img src="<%=request.getContextPath()%>/assets/images/appoint/已取消.png" alt=""></div>--%>
                <%--<div class="item"><span>12:00-13:00</span>--%>
                    <%--<img src="<%=request.getContextPath()%>/assets/images/appoint/已预约.png" alt="">--%>
                    <%--<div class="cancel">取消</div>--%>
                <%--</div>--%>
              </div>
        </div>
    </div>

    <script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
    <%--<script src="<%=request.getContextPath()%>/assets/js/outside/aboutclass/pri_aboutclass.js"></script>--%>
    <script>
        var baseUrl = '${pageContext.request.contextPath}';
    </script>
    <script>
        $(function () {


            function GetQueryString(name)
            {
                var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
                if(r!=null)return  unescape(r[2]);
                return null;
            }
            var coachId = GetQueryString("coachId");
            var id = GetQueryString("id");
            var courseId = GetQueryString("courseId");
            debugger;
            var htmlString="";
            getAppointLis();

            $(".appointCoach").click(function(){
                window.location.href="/outside/aboutClass/appointPage?coachId="+coachId+"&id="+id;
            })


            function converTime(time) {
                var now = new Date(parseInt(time));
                var now1 = new Date(parseInt(time)+60 * 60 * 1000);
                var year = now.getFullYear(); //得到年份
                var month = now.getMonth();//得到月份
                var date = now.getDate();//得到日期
                var day = now.getDay();//得到周几
                var hour = now.getHours();//得到小时
                var minu = now.getMinutes();//得到分钟
                var sec = now.getSeconds();//得到秒
                month = month + 1;
                if (month < 10) month = "0" + month;
                if (date < 10) date = "0" + date;
                if (hour < 10) hour = "0" + hour;
                if (minu < 10) minu = "0" + minu;
                if (sec < 10) sec = "0" + sec;
                var year1 = now1.getFullYear(); //得到年份
                var month1 = now1.getMonth();//得到月份
                var date1 = now1.getDate();//得到日期
                var day1 = now1.getDay();//得到周几
                var hour1 = now1.getHours();//得到小时
                var minu1 = now1.getMinutes();//得到分钟
                var sec1 = now1.getSeconds();//得到秒
                month1 = month1 + 1;
                if (month1 < 10) month1 = "0" + month1;
                if (date1 < 10) date1 = "0" + date1;
                if (hour1 < 10) hour1 = "0" + hour1;
                if (minu1 < 10) minu1 = "0" + minu1;
                if (sec < 10) sec1 = "0" + sec1;
                var time1 = "";
                //精确到天
                // if(format==1){
                //     time = year + "-" + month + "-" + date;
                // }
                // //精确到分
                // else if(format==2){
                //     time = year + "-" + month + "-" + date+ " " + hour + ":" + minu + ":" + sec;
                // }
                // time = year + "-" + month + "-" + date+ " " + hour + ":" + minu +"-"+year1 + "-" + month1 + "-" + date1+ " " + hour1 + ":" + minu1;
                time1 =month + "-" + date+ " " + hour + ":" + minu +"-"+ month1 + "-" + date1+ " " + hour1 + ":" + minu1;
                return time1;
            }


            //status 1.已经预约 2.已经取消  3.已经完成
          function  getAppointLis() {
                $.ajax({
                    type: "GET",
                    url: baseUrl+"/outside/priCoach/appointList?courseid="+courseId+"&coachId="+coachId+"&pageNo=1&pageSize=10000",
                    success: function (data) {
                        if (data != null) {
                            debugger;
                            var appointList =  data.records;
                            for(var i=0;i<appointList.length;i++){

                                if(appointList[i].status =="1"){
                                    htmlString+='<div class="item"><span>'+converTime(appointList[i].starttime)+'</span>\n' +
                                        '                    <img src="<%=request.getContextPath()%>/assets/images/appoint/已预约.png" alt="">\n' +
                                        '                    <div class="cancel" data-id="'+appointList[i].id+'">取消</div>\n' +
                                        '                </div>';
                                }else if(appointList[i].status =="2"){
                                    htmlString+=' <div class="item" data-id="'+appointList[i].id+'"><span>'+converTime(appointList[i].starttime)+'</span>\n' +
                                        '                    <img src="<%=request.getContextPath()%>/assets/images/appoint/已取消.png" alt="">\n' +
                                        '                </div>';
                                }
                                else{
                                    htmlString+=' <div class="item" data-id="'+appointList[i].id+'"><span>'+converTime(appointList[i].starttime)+'</span>\n' +
                                        '                    <img src="<%=request.getContextPath()%>/assets/images/appoint/已完成.png" alt="">\n' +
                                        '                </div>';
                                }
                            }
                            $("#appointList").html(htmlString);
                            $(".item").on("click","div.cancel",function(){
                                debugger;
                                var id = $(this).attr("data-id");
                                $.post(baseUrl+"/outside/priCoach/cancelAppoint",{id:id},function(data){
                                    console.log(data);
                                    if(data.resultCode == "200"){
                                        alert("取消预约成功");
                                        window.location.reload();
                                    }
                                    else if(data.resultCode == "674"){
                                        alert("提前一小时才能取消预约");
                                    }
                                });
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
