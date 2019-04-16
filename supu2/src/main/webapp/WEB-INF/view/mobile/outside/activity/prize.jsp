<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/1
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>九宫格抽奖</title>
    <link href="<%=request.getContextPath()%>/assets/css/prize/common.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/prize/common_mobile.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/prize/index.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/prize/swiper.min.css">
    <%--<link rel="stylesheet" href="../common/css/common_mobile.css?version=1.0.0">--%>
    <%--<link rel="stylesheet" href="css/index.css?version=1.0.0">--%>
    <!-- 移动端适配 -->
    <script>
        var html = document.querySelector('html');
        changeRem();
        window.addEventListener('resize', changeRem);

        function changeRem() {
            var width = html.getBoundingClientRect().width;
            html.style.fontSize = width / 10 + 'px';
        }
    </script>
</head>
<body>

<div id="wrap">
    <p class="time"></p>
    <!--星星-->
    <div class="stars-box">
        <span class="stars"></span>
        <span class="stars"></span>
        <span class="stars"></span>
        <span class="stars"></span>
        <span class="stars"></span>
        <span class="stars"></span>
        <span class="stars"></span>
    </div>
    <!--主体-->
    <div class="main">
        <p class="rule"></p>
        <!--     <a href="../my.html" id="myWin"> -->
        <p class="my"></p>
        </a>
        <!--游戏区域-->
        <div class="box">
            <span class="coin"></span>
            <h2>您今日还有 <span id="change"></span> 次抽奖机会</h2>
            <ul class="light clearfix">
                <li class="fl">
                    <p></p>
                    <p class="blin"></p>
                    <p></p>
                    <p class="blin"></p>
                </li>
                <li class="fr">
                    <p class="blin"></p>
                    <p></p>
                    <p class="blin"></p>
                    <p></p>
                </li>
            </ul>
            <!--九宫格-->
            <ul class="play clearfix">
                <ul>
                    <li class="prize prize-0">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                    <li class="prize prize-1">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                    <li class="prize prize-2">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                </ul>
                <ul>
                    <li class="prize prize-7">
                        <div>

                            <img src="">
                            <p></p>
                        </div>
                    </li>

                    <li class="prize" id="btn"></li>

                    <li class="prize prize-3">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                </ul>
                <ul>
                    <li class="prize prize-6">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                    <li class="prize prize-5">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                    <li class="prize prize-4">
                        <div>
                            <img src="">
                            <p></p>
                        </div>
                    </li>
                </ul>
            </ul>
        </div>
        <!--奖品展示-->
        <div class="awards">
            <div class="swiper-container">
                <ul class="swiper-wrapper">
                    <li class="swiper-slide">
                        <img src="<%=request.getContextPath()%>/assets/images/prize/drag/drag1.png">
                    </li>
                    <li class="swiper-slide">
                        <img src="<%=request.getContextPath()%>/assets/images/prize/drag/drag2.png">
                    </li>
                    <li class="swiper-slide">
                        <img src="<%=request.getContextPath()%>/assets/images/prize/drag/drag3.png">
                    </li>
                    <li class="swiper-slide">
                        <img src="<%=request.getContextPath()%>/assets/images/prize/drag/drag4.png">
                    </li>
                    <li class="swiper-slide">
                        <img src="<%=request.getContextPath()%>/assets/images/prize/drag/drag5.png">
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--游戏规则弹窗-->
    <div class="mask-rule" id="mask1">
        <div class="box-rule">
            <span class="star"></span>
            <h2>活动规则说明</h2>
            <span class="close-rule" id="close1"></span>
            <div class="con">
                <div class="text" id="introduce">

                </div>
            </div>
        </div>
    </div>

    <!--我的奖品弹窗-->
    <div class="mask-rule" id="mask2">
        <div class="box-rule">
            <span class="star"></span>
            <h2>我的奖品</h2>
            <span class="close-rule" id="close2"></span>
            <div class="con">
                <div class="text" id="myPrizeList">

                </div>
            </div>
        </div>
    </div>

    <!--中奖提示-->
    <div id="mask" class="mask1">
        <div class="blin"></div>
        <div class="caidai"></div>
        <div class="winning">
            <div class="red-head"></div>
            <div class="red-body"></div>
            <div id="card" class="card">
                <a href="" target="_self" class="win"></a>
            </div>
            <a href="" target="_self" class="btn1"></a>
            <a href="" target="_self"><span id="close"></span></a>
        </div>
    </div>

    <!--未中奖提示-->
    <div id="maskfail" class="mask1">
        <div class="blin"></div>
        <div class="caidai"></div>
        <div class="winning">
            <div class="red-head"></div>
            <div class="red-body1"></div>
            <div id="card1" class="card">
                <a href="" target="_self" class="win"></a>
            </div>
            <a href="" target="_self" class="btn2"></a>
            <a href="" target="_self"><span id="close"></span></a>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/swiper.jquery.min.js"></script>
<%--<script src="../common/js/h5_game_common.js?version=1.0.0"></script>--%>
<!-- <script src="js/index.js?version=1.0.0"></script> -->
<script>
    var baseUrl = '${pageContext.request.contextPath}';
    var openid=  '${ sessionScope.openId }';
    var $maskRule = $("#mask1"),//规则遮罩层
        $maskMyPrize = $("#mask2"),//我的奖品遮罩层
        $mask = $("#mask"),//红包遮罩层
        $winning = $(".winning"),//红包
        $card = $("#card"),
        $card1 = $("#card1"),
        $close = $("#close");
        $mask1 = $("#maskfail");
    var prizeCount; //还剩抽奖次数
    var introduce;
    var lottery = {
        index: -1, //当前转动到哪个位置，起点位置
        count: 8, //总共有多少个奖品位置，9宫格就是8个奖品位置
        timer: 0, //setTimeout的ID，用clearTimeout清除
        speed: 10, //初始转动速度
        times: 0, //转动次数
        cycle: 50, //转动基本次数：即至少需要转动多少次再进入抽奖环节
        prize: 0, //默认中奖位置，放默认奖品
        init: function(id) {
            if ($("." + id).find(".prize").length > 0) {
                $lottery = $("." + id);
                $units = $lottery.find(".prize");
                this.obj = $lottery;
                this.count = $units.length;
                $lottery.find(".prize-" + this.index).addClass("select");
            };
        },
        roll: function() {
            var index = this.index;
            var count = this.count;
            var lottery = this.obj;
            $(lottery).find(".prize-" + index).removeClass("select");
            index += 1;
            if (index > count - 1) {
                index = 0;
            };
            $(lottery).find(".prize-" + index).addClass("select");
            this.index = index;

            return false;
        },
        stop: function(index) {
            this.prize = index;
            return false;
        }
    };

    //存储奖品信息
    var prize_data = {
        pname: '默认奖品', //奖品名称
        pnum: 0, //中奖位置 默认0，重要，转盘据此来定位获奖商品
        pid: 1, //奖品id 默认1
    };


    function roll() {
        lottery.times += 1;
        lottery.roll();

        if (lottery.times > lottery.cycle + 10 && lottery.prize == lottery.index) {
            clearTimeout(lottery.timer);
            lottery.times = 0;
            click = false;
            //显示中奖信息
            // showDetail();

            if(lottery.prize == 7){
             fail();
            }
            else{
                win();
            }

        } else {
            //速度控制
            if (lottery.times < lottery.cycle) {
                lottery.speed -= 10;
            } else if (lottery.times == lottery.cycle) {
                index = lottery.prize;
            } else {
                if (lottery.times > lottery.cycle + 10 && ((lottery.prize == 0 && lottery.index == 7) || lottery.prize == lottery.index + 1)) {
                    lottery.speed += 110;
                } else {
                    lottery.speed += 20;
                }
            }
            if (lottery.speed < 40) {
                lottery.speed = 40;
            };
            //延时递归调用
            lottery.timer = setTimeout(roll, lottery.speed);
        }

        return false;
    }
    /*
     * 获取中奖位置
     * @param {string} name 用户昵称（必须）
     * @param {string} avatar 微信头像网址（必须）
     * @param {string} openid 微信openid（必须，用于验证唯一性，一个用户只能抽奖一次）
     * @return {bool}
     */
    function doRoll(url, name, avatar, openid) {
        // oEE6FwF8NLSHHLd3ks20t0fnOI88
        $.post({ url: url, data:{activityId:"1",openId:openid}, async:false,dataType:'json',success: function(resp){
                lottery.speed=100;
                var data = resp.records;
                if(resp.resultCode == "667"){
                    alert("没有绑定手机");
                    window.location.href="http://www.spartner.cn";
                }
                if(resp.resultCode == "669"){
                    alert("不在活动时间范围内");
                }
                // lottery.prize = data.id;
                lottery.prize =data.id-1;
                prize_data = {
                    pname:data.pname,
                    pnum:data.pnum,
                    pid:data.pid
                };
                roll();
                click=true;
                return false;

            }});
    }

    //领奖(跳转收货地址页面，或者弹出收货地址页面)
    function getPrize() {
        alert("请填写收货地址");
    }
    //清空中奖信息
    function clearDetail() {
        $("#con_prize").hide();
        $("#pname").html("");
    }
    //显示中奖信息
    function showDetail() {
        $("#con_prize").show();
        $("#pname").html(prize_data.pname);
    }

    //关闭中奖提示
    $("#close,.win,.btn").click(function() {
        // clearInterval(timer); //关闭弹出时清除定时器
        // init();
        $mask.hide();
        $winning.removeClass("reback");
        $card.removeClass("pull");
    });

    //奖品展示
    var show = new Swiper(".swiper-container", {
        direction: "horizontal", //水平方向滑动。 vertical为垂直方向滑动
        loop: false, //是否循环
        slidesPerView: "auto" //自动根据slides的宽度来设定数量
    });

    //奖品信息
    function getPrizeList(openid){
        $.get(baseUrl+"/outside/activity/getActivityWithPrize?activityId=1&openId="+openid,function(resp){
            console.log(resp);
            var prizeList = resp.records.prizeStores;
            prizeCount=resp.records.description - resp.records.useNum;
            $("#change").text(resp.records.description - resp.records.useNum) ;


            $(".time").text(getMonthDay(parseInt(resp.records.startDate))+"-"+getMonthDay(parseInt(resp.records.endDate)));
            var introduce = resp.records.introduce;
            $("#introduce").html(resp.records.introduce);
            for (var i = 0; i < prizeList.length; i++) {
                $(".prize-"+i).find("img").attr("src",prizeList[i].path);
                $(".prize-"+i).find("p").text(prizeList[i].name);
            }
        })
    }

    //我的奖品
    function getMyPrize(){
        $("#myPrizeList").empty();
        $.get(baseUrl+"/outside/activity/getMyPrize?activityId=1&openId="+openid,function(resp){
            var myPrizeList = resp.records;
            var htmlStr = "";
            for (var i = 0; i < myPrizeList.length; i++) {
                htmlStr+='<p>'+myPrizeList[i].name+'</p>';
            }
            $("#myPrizeList").append(htmlStr);
        })
    }

    var click = false;

    window.onload = function() {
        getPrizeList(openid);
        var url = baseUrl+'/outside/activity/joinActivity';//这里改成实际后台抽奖接口
        lottery.init('play');

        //开始抽奖
        $("#btn").on("click",function() {
            //如果抽奖次数为0
            // 那么提示，您的抽奖次数已用完
            if( prizeCount<1){
                alert("对不起，您的抽奖次数已用完");
            }

            if (click) {
                return false;
            } else {
                clearDetail();
                doRoll(url,"name","avatar",openid);
            }
        });
    };

    //link = false;//判断是否在链接跳转中

    //规则
    $(".rule").click(function () {
        $maskRule.show();
    });
    $("#close1").click(function () {
        $maskRule.hide();
    });

    //我的奖品
    $(".my").click(function () {
        getMyPrize();
        $maskMyPrize.show();
    });
    $("#close2").click(function () {
        $maskMyPrize.hide();
    });

    /*中奖信息提示*/
    function win() {
        //遮罩层显示
        setTimeout(function(){
            $mask.show();
            $winning.addClass("reback");
            setTimeout(function () {
                $card.addClass("pull");
            }, 500);
        },1000);

        $("#close,.win,.btn").click(function () {
            //$close.click(function () {
            $mask.hide();
            $winning.removeClass("reback");
            $card.removeClass("pull");
        });
    }
        /*未中奖信息提示*/
        function fail() {
            //遮罩层显示
            setTimeout(function(){
                $mask1.show();
                $winning.addClass("reback");
                setTimeout(function () {
                    $card1.addClass("pull");
                }, 500);
            },1000);
    }

    //此处可以在commonjs中合并
    function queryString(name) {
        name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
        var regexS = "[\\?&]" + name + "=([^&#]*)";
        var regex = new RegExp(regexS);
        var results = regex.exec(window.location.search);
        if(results === null) {
            return "";
        }
        else {
            return decodeURIComponent(results[1].replace(/\+/g, " "));
        }
    }

    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y+M+D+h+m+s;
    }

    function getMonthDay(timestamp){
        var date = new Date(timestamp);
        return date.getMonth()+"-"+date.getDate();
    }

</script>



</body>
</html>
