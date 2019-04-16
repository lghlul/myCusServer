<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html lang="zh-CN"  >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <title>忘记密码第一步</title>
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
		#error{
			color: red;
			font-size: 14px;
		}
		#error_code{
			color: red;
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
    <div class="sign-container" id="app_sign">
        <!-- login-form start -->
        <div class="login-form">
            <form method="post" action="<%=request.getContextPath()%>/findpasswd/firststep" accept-charset="utf-8">
                <div class="weui_cells weui_cells_form">
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_phone-copy"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input id="mobile" class="weui_input" type="text" value="" maxlength="11" name="mobile" placeholder="请输入手机号" v-model="input_1">
                        </div>
                    </div>

<!--
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_captcha-copy"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary" style="display: flex; justify-content: center; align-items: center">
                            <input name="captcha" class="weui_input" maxlength="11" type="text" value="" placeholder="图片验证码" v-model="input_3">
                            <img  title="点击刷新" src="/wap/captcha" align="absbottom" onclick="this.src='/wap/captcha?'+Math.random();" />
                        </div>
                    </div> -->


                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_yzm"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input id="Code" v-show="!isPwShow" maxlength="4" class="weui_input" name="code" type="text" placeholder="请输入验证码" v-model="input_2">
                        </div>
                        <div class="weui_cell_ft">
                            <!-- <span class="le_btn_captcha">发送验证码</span> -->
                              <button class="le_btn_captcha" type="button" id="sendCode">发送验证码</button>
                        </div>
                    </div>
                </div>
                <font color="red">${error }</font>
                 <button  id="nextStep" class="weui_btn leui_btn_warn form-submit" :class="{'leui_btn_disabled': disabled}">下一步</button>
            </form>

        </div>
        <!-- login-form end -->
    </div>
</div>

<!-- <script src="js/font_zphmkln2rzyyzaor.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery-weui.min.js"></script>
<script src="js/vue.min.js"></script> -->
<script>
	var baseUrl = '${pageContext.request.contextPath}';
	//ar captcha_error='${captcha_error}';
</script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/font_zphmkln2rzyyzaor.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/vue.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/findpasswd/firststep.js"></script>
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
  /*   $(function(){
        var time = 60;
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


        $('.le_btn_captcha').on('click',function(){
            var phone = $('[name=phone]').val();
            var captcha = $('[name=captcha]').val();
            if ( !(/^1\d{10}$/.test(phone)) ) {
                $.alert('请输入正确的手机号');
                $('[name=phone]').focus();
                return false;
            }
            if ( time != 60 ) {
                return false;
            }

            $.post('https://m.leoao.com/wap/send_message',{ phone: phone,captcha:captcha },function(data){
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
                $('[name=phone]').focus();
                return false;
            }
            if ( !code) {
                $.alert('请输入验证码。');
                return false;
            }

            $('form').submit();

        });
    }) */
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
/*     var _vds = _vds || [];
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
    })(); */
</script>
</body>
</html>

