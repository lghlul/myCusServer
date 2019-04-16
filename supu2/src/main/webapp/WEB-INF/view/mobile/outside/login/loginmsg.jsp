<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <title>验证码登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/font_zphmkln2rzyyzaor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/jquery-weui.min.css">
    <link rel='stylesheet' href='<%=request.getContextPath()%>/assets/css/outside/common.css' />
    <link rel='stylesheet' href='<%=request.getContextPath()%>/assets/css/outside/login.css' />
	<style>
		.weui_cell_ft button{
			border: none;
			outline: none;
			background-color: #fff;
		}
		.le-other-item>a.login{
			color: rgba(255, 255, 255, .6);
		}
		.weui_cell_bd.weui_cell_primary label.error{
			color: red;
			margin-top: .4rem;
			font-size: 14px;
		}
	</style>
</head>
<body class="">

<div class="leui-head-bar leui-head-top hide">
    <div class="leui-head-left">
        <a href="javascript:history.back();" class="header-back">返回</a>
        <div class="left-arrow"></div>
    </div>
</div>
<div class="container leui-container-top">
    <div class="login-container" id="app_sign">
        <div class="mask"></div>
        <div class="header login-header">
            <!-- <i class="iconfont icon-logo_lefit"></i> -->
            <img src="<%=request.getContextPath()%>/assets/images/outside/logo.png"/>
        </div>
        <div class="main">
            <!-- login-form start -->
            <div class="login-form">
                <form id="form" method="post" action="<%=request.getContextPath()%>/outside/login" accept-charset="utf-8">
                    <div class="weui_cells weui_cells_form">
                        <div class="weui_cell">
                            <div class="weui_cell_hd">
                                <label class="weui_label"><i class="iconfont icon-ico_login_phone-copy"></i></label>
                            </div>
                            <div class="weui_cell_bd weui_cell_primary">
                                <input id="mobile" name="username" value="${username}" class="weui_input" maxlength="11" type="tel" value="" placeholder="请输入手机号" v-model="input_1">
                            </div>
                        </div>


                         <div class="weui_cell">
                            <div class="weui_cell_hd">
                                <label class="weui_label"><i class="iconfont icon-ico_login_captcha-copy"></i></label>
                            </div>
                            <div class="weui_cell_bd weui_cell_primary" style="display: flex; justify-content: center; align-items: center">
                                <input id="ImagePictext" name="captcha" class="weui_input" maxlength="11" type="text" value="" placeholder="图片验证码" v-model="input_3">
                                <img  id="ImagePic" title="点击刷新" src="" align="absbottom" onclick="refreshCaptcha()" /><!-- this.src='getimgverify?mobile=111 -->
                            </div>
                        </div> 


                        <div class="weui_cell">
                            <div class="weui_cell_hd">
                                <label class="weui_label"><i class="iconfont icon-ico_login_yzm"></i></label>
                            </div>
                            <div class="weui_cell_bd weui_cell_primary">
                                <input id="Code" class="weui_input" name="password" maxlength="4" value="" type="text" placeholder="请输入验证码" v-model="input_2">
                                <input name="type" class="weui_input" type="hidden" value="2">
                            </div>
                            <div class="weui_cell_ft">
                                <button id="send" type="button" class="le_btn_captcha">发送验证码</button>
                            </div>
                        </div>

                               <c:if test="${count>3}">
	                	 <div class="yZ"  id="div_captcha"><!-- style="display: none" -->

	                	  <div class="weui_cell">
                            <div class="weui_cell_hd">
                                <label class="weui_label"><i class="iconfont icon-ico_login_captcha-copy"></i></label>
                            </div>
                            <div class="weui_cell_bd weui_cell_primary" style="display: flex; justify-content: center; align-items: center">


                              	<!-- <input type="text" placeholder="输入验证码" id="captcha" name="captcha"/> -->

                              	<input name="captcha" id="captcha" class="weui_input" maxlength="11" type="text" placeholder="图片验证码">

                                <%-- <img alt="验证码" src="<%=request.getContextPath()%>/images/kaptcha.jpg" title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" /> --%>

                            	<img title="点击刷新" src="<%=request.getContextPath()%>/images/kaptcha.jpg" id="img_captcha" align="absbottom" onclick="javascript:refreshCaptcha();">
                            </div>
                      	  </div>


	                 </div>
                	 </c:if>
                    </div>

                   		 <div id="div_error">
                      		<font color="red"> ${error}</font>
                        </div>
                    <input name="openid" id="openid" type="hidden" value="<%=(String)session.getAttribute("openId")%>"/>
                    <button id="login" class="weui_btn leui_btn_warn form-submit" :class="{'leui_btn_disabled': disabled}">绑定</button>
                </form>

            </div>
            <!-- login-form end -->

            <!-- 底层的mask 开始 -->
            <div class="mask-login">
                <div class="mask"></div>
            </div>
            <!-- 底层的mask 结束 -->

            <!-- 其他登陆框 开始 -->
            <!-- <div class="le-other-box le-login-other-box">
                <div class="le-divider">其他登录方式</div>
                <div class="le-other-items boder-1px-bottom">
                    <a href="javascript:;">
                        <div class="le-other-item">
                         <a href="<%=request.getContextPath()%>/outside/login">
                            <div class="le-item-iconfont">
                                <i class="iconfont icon-icon_login_sjyz"></i>
                            </div>
                            </a>
                            <a class="login" href="<%=request.getContextPath()%>/outside/login">密码登录</a>
                        </div>
                    </a>
                </div>
                <div class="le-bottom-fixed le-bg-w01 le-font-size-sm">
                    <a href="<%=request.getContextPath()%>/outside/register"><span class="le-font-white-6 sign-login-item">注册账号</span></a>
                    <a href="<%=request.getContextPath()%>/findpasswd/firststep"><span class=" le-font-white-6  sign-login-item">忘记密码</span></a>
                </div>
            </div> -->
            <!-- 其他登陆框 结束 -->

        </div>
    </div>
</div>

<!-- <script src="js/font_zphmkln2rzyyzaor.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-weui.min.js"></script>
<script src="js/vue.min.js"></script> -->
<script>

	var baseUrl = '${pageContext.request.contextPath}';
	var captcha_error='${captcha_error}';
    var openid = '${sessionScope.openId}';

</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/login/loginmsg.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/vue.min.js"></script>

<script>
    $(function(){
        var u = window.navigator.userAgent
        var isCoachApp = !!window.navigator.userAgent.match('LEFITCOACH')
        var $headTop = $('.leui-head-top')
        var $head = $('.leui-head-bar')
        var $containerTop = $('.leui-container-top')
        if (isCoachApp) {
            $head.show()
            if (u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/)) {
                $headTop.css('padding-top', '20px')
                $containerTop.css('padding-top', '64px')
            } else if (u.indexOf('Android') > -1 && parseFloat(u.substr(u.indexOf('Android') + 8, 3)) >= 4.4) {
                $headTop.css('padding-top', '25px')
                $containerTop.css('padding-top', '69px')
            } else {
                $headTop.css('padding-top', '0')
                $containerTop.css('padding-top', '44px')
            }
        }
    })
</script>
<script type="text/javascript">
    $(function(){
     /*    var time = 60;
        function settime(val) {
            if (time != 0 ) {
                val.html("重新发送(" + time + ")");
                val.css('color','grey');
                time--;
                setTimeout(function() {settime(val);},1000)
            } else {
                time = 60;
                val.html("获取验证码");
                val.css('color','#FF0000');
                return;
            }
        }
        if ( time != 60 ) { //如果时间不等于60说明已经发送
            settime($('.le_btn_captcha'));
        }

        $('.le_btn_captcha').on('click',function(){
            var phone = $('[name=phone]').val();
            var captcha = $('[name=captcha]').val();
            if ( !(/^1\d{10}$/.test(phone)) ) {
                $.alert('请输入正确的手机号');
                // $('[name=phone]').focus(); //不然会出现光标显示在提示框上面,并且键盘压住弹出框
                return false;
            }
            if ( time != 60 ) {
                return false;
            }

            $.post('https://m.leoao.com/wap/send_message',{ phone: phone, captcha : captcha },function(data){
                if ( data.code == 200 ) {
                    settime($('.le_btn_captcha'));
                } else {
                    $.alert(data.resultmessage);
                }
            },'json');

        });
        $('.le-other-item').on('click',function(){
            window.location.href = $('.login').attr('url');
        });
        $('.form-submit').on('click',function(){
            var phone = $('[name=phone]').val();
            var code = $('[name=code]').val();

            if ( !(/^1\d{10}$/.test(phone)) ) {

                $.alert('请输入正确的手机号');
                return false;
            }
            if ( !code) {
                $.alert('请输入4位验证码。');
                return false;
            }

            $('form').submit();
        }); */
    })
</script>
<script type="text/javascript">
    var leVm = new Vue ({
        el: "#app_sign",
        data: {
            input_1: '',
            input_2: '',
            disabled: true,
        },
        watch: {
            'input_1': function(val, oldVal){
                this.canSub()
            },
            'input_2': function(val, oldVal){
                this.canSub()
            },
        },
        methods: {
            canSub: function(){
                if (this.input_1 && this.input_2) {
                    this.disabled = false;
                }else{
                    this.disabled = true;
                };
            }
        }
    })
</script>
<script type='text/javascript'>
    var _vds = _vds || [];
    window._vds = _vds;
    (function(){
        _vds.push(['setAccountId', '9eabefbaddd8e63a']);
        (function() {
            var vds = document.createElement('script');
            vds.type='text/javascript';
            vds.async = true;
            vds.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'dn-growing.qbox.me/vds.js';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(vds, s);
        })();
    })();
</script>


<script>


var captcha;
function refreshCaptcha(){
    document.getElementById("img_captcha").src=baseUrl+"/images/kaptcha.jpg?t=" + Math.random();
}

</script>

<script>

$(document).ready(function(){
	
	refreshCaptcha();
	
	  /* $("#b01").click(function(){
	  htmlobj=$.ajax({url:"/jquery/test1.txt",async:false});
	  $("#myDiv").html(htmlobj.responseText);
	  }); */
	});
	
function refreshCaptcha(){	
	$.ajax({
	    type:'get',
	     /*  data:{"param1":"0001","param2":"0002"}, //参数
	      dataType:'json',  */
	      url: "getimgverify",	/* ?mobile="+$("#mobile").val() */
	      success: function(data) {
	          //将图片的Base64编码设置给src-----替换掉json中的引号字符串
	          $("#ImagePic").attr("src",("data:image/jpeg;base64,"+data).replace(/\"/g,""));
	      },
	      error:function(data){
	          alert('响应失败！');
	      }
	   });
}
</script>

</body>
</html>

