<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN"  >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/font_zphmkln2rzyyzaor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/jquery-weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/login.css">
	<style>
		.le-other-item>a.login {
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
    <div class="login-container loginBgAnimation" id="app_sign">
        <div class="mask"></div>
        <div class="header login-header">
            <img src="<%=request.getContextPath()%>/assets/images/outside/logo.png"/>
        </div>
        <div class="main">
            <!-- login-form start -->
            <div class="login-form">
                <form id="form" method="post" action="<%=request.getContextPath()%>/outside/door_login" accept-charset="utf-8">
                    <div class="weui_cells weui_cells_form">
                        <div class="weui_cell">
                            <div class="weui_cell_hd">
                                <label class="weui_label"><i class="iconfont icon-ico_login_phone-copy"></i></label>
                            </div>
                            <div class="weui_cell_bd weui_cell_primary">
                                <input name="username" value="${username}" id="loginPhone" class="weui_input" maxlength="11" type="text"  placeholder="请输入手机号" v-model="input_1">
                            </div>
                        </div>


                        <div class="weui_cell">
                            <div class="weui_cell_hd">
                                <label class="weui_label"><i class="iconfont icon-ico_login_mm1"></i></label>
                            </div>
                            <div class="weui_cell_bd weui_cell_primary">
                                <input type="password"  name="password" id="loginPassword" class="weui_input" maxlength="16" placeholder="请输入密码" v-model="input_2">
                                <input name="type" class="weui_input" type="hidden" value="1">
                            </div>
                            <div class="weui_cell_ft">
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
						<div>
                      		<font color="red"> ${error}</font>
                        </div>
                    <button class="weui_btn leui_btn_warn form-submit" :class="{'leui_btn_disabled': disabled}">密码登录</button>
                </form>
            </div>
            <!-- login-form end -->

            <!-- 底层的mask 开始 -->
            <div class="mask-login">
                <div class="mask"></div>
            </div>
            <!-- 底层的mask 结束 -->

            <!-- 其他登陆框 开始 -->
            <div class="le-other-box le-login-other-box">
                <div class="le-divider">其他登录方式</div>
                <div class="le-other-items boder-1px-bottom">
                    <a href="javascript:;">
                        <div class="le-other-item">
                            <a href="<%=request.getContextPath()%>/outside/door_login?type=2">
                            	<div class="le-item-iconfont">
                                	<i class="iconfont icon-icon_login_sjyz"></i>
                            	</div>
                            </a>
                            <a class="login" href="<%=request.getContextPath()%>/outside/door_login?type=2">验证码登录</a>
                        </div>
                    </a>

                </div>
                <!-- 注册 -->
                <div class="le-bottom-fixed le-bg-w01">
                    <a href="<%=request.getContextPath()%>/outside/register"><span class="le-font-white-6 sign-login-item boder-1px-right">注册账号</span></a>
                       <a href="<%=request.getContextPath()%>/findpasswd/firststep"><span class=" le-font-white-6  sign-login-item">忘记密码</span></a>
                </div>
            </div>
            <!-- 其他登陆框 结束 -->

        </div>
    </div>
</div>
<script>
	var baseUrl = '${pageContext.request.contextPath}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/font_zphmkln2rzyyzaor.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
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
<!-- <script type="text/javascript">
    $(function(){
        $('.le-other-item').on('click',function(){
            window.location.href = $('.login').attr('url');
        });
        $('.form-submit').on('click',function(){
            var phone = $('[name=phone]').val();
            var password = $('[name=password]').val();
            if ( !(/^1\d{10}$/.test(phone)) ) {

                $.alert('请输入正确的手机号');
                return false;
            }
            if ( !(/\w{6,16}$/.test(password))) {
                $.alert('密码长度6-16位之间，只能包括字母、数字和下划线');
                return false;
            }

            $('form').submit();
        });
    })
</script> -->
</body>
</html>

<script>
	var baseUrl = '${pageContext.request.contextPath}';
	var captcha_error='${captcha_error}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/login/loginpasswd.js"></script>



<script>


var captcha;
function refreshCaptcha(){
    document.getElementById("img_captcha").src=baseUrl+"/images/kaptcha.jpg?t=" + Math.random();
}

</script>