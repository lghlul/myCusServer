<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN"  >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
     <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/font_zphmkln2rzyyzaor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/jquery-weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/login.css">
	<style>
		.weui_cell_bd.weui_cell_primary label.error{
			color: red;
			margin-top: .4rem;
			font-size: 14px;
		}
		.weui_cell_ft button.le_btn_captcha {
			border: none;
			outline: none;
			background-color: #fff;
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
    <div class="sign-container" id="app_sign">
        <div class="login-form">
            <form id="form" method="post" action="<%=request.getContextPath()%>/addregister" accept-charset="utf-8">
                <input type="hidden" name="source" value="0" >
                <div class="weui_cells weui_cells_form">
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_phone-copy"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input id="mobile" value="${employee.username }" class="weui_input" name="mobile" type="tel" maxlength="11" value="" placeholder="请输入手机号" v-model="input_1">
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_mm1"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input id="password" class="weui_input" name="password" maxlength="16" value="" type="password" placeholder="请输入密码" v-model="input_2">
                        </div>
                        <div class="weui_cell_ft" @click.stop="revealPasssword">
                            <i v-show="!isPwShow" class="iconfont icon-icologineyeclose le-font-size-lg"></i>
                            <i v-show="isPwShow" class="iconfont icon-icologineyeopen le-font-size-lg le-font-white"></i>
                        </div>
                    </div>

                  <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_mm1"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input id="confirmPasswd" class="weui_input" name="confirmPasswd" maxlength="16" value="" type="password" placeholder="请确认密码" >
                        </div>
                        <div class="weui_cell_ft" @click.stop="revealPasssword">
                            <i v-show="!isPwShow" class="iconfont icon-icologineyeclose le-font-size-lg"></i>
                            <i v-show="isPwShow" class="iconfont icon-icologineyeopen le-font-size-lg le-font-white"></i>
                        </div>
                    </div>

<!--
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_captcha-copy"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary" style="display: flex; justify-content: center; align-items: center">
                            <input name="captcha" class="weui_input" maxlength="11" type="text" value="" placeholder="图片验证码" v-model="input_4">
                            <img  title="点击刷新" src="/wap/captcha" align="absbottom" onclick="this.src='/wap/captcha?'+Math.random();" />
                        </div>
                    </div> -->



                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_yzm"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input id="shortMessage" name="shortMessage" class="weui_input" maxlength="4"  type="text" placeholder="请输入验证码" v-model="input_3">
                        </div>
                        <div class="weui_cell_ft">
                         <!--    <span class="le_btn_captcha">发送验证码</span> -->
                             <button type="button"  class="le_btn_captcha send" id="send">发送验证码</button>
                        </div>
                    </div>
                </div>

                 <c:if test="${register_error !=null && register_error !=''}">
		               <font color="red">${register_error}</font>
		          </c:if>
                 <button id="register" href="javascript:;" class="weui_btn leui_btn_warn form-submit" :class="{'leui_btn_disabled': disabled}">注册</button>
            </form>

            <!--<div class="sign-agreement">-->
          <!--<span class="sign-agreement-gou" :class="{'checked': agreementChecked}" @click="agreementChecked = !agreementChecked">-->
            <!--<i class="icon iconfont icon-gou"></i>-->
          <!--</span>-->
                <!--<span>同意<a href="/agreement">《速扑服务协议》</a></span>-->
            <!--</div>-->
        </div>
    </div>
</div>

<script>
	var baseUrl = '${pageContext.request.contextPath}';
	//var captcha_error='${captcha_error}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/font_zphmkln2rzyyzaor.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/vue.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/register/register.js"></script>
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
    var leVm = new Vue ({
        el: "#app_sign",
        data: {
            input_1: '',
            input_2: '',
            input_3: '',
            disabled: true,
            agreementChecked: true
        },
        watch: {
            'input_1': function(val, oldVal){
                this.canSub()
            },
            'input_2': function(val, oldVal){
                this.canSub()
            },
            'input_3': function(val, oldVal){
                this.canSub()
            },
        },
        methods: {
            canSub: function(){
                if (this.input_1 && this.input_2 && this.input_3) {
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
</body>
</html>

