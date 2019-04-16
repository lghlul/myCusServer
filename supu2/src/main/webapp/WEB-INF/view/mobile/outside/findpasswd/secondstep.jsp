<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN"  >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <title>忘记密码第二步</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
 <!--    <link rel="stylesheet" href="css/font_zphmkln2rzyyzaor.css">
    <link rel="stylesheet" href="css/weui.min.css">
    <link rel="stylesheet" href="css/jquery-weui.min.css">
    <link rel='stylesheet' href='css/common.css' />
    <link rel='stylesheet' href='css/login.css' /> -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/font_zphmkln2rzyyzaor.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/jquery-weui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/login.css">
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
            <form id="form" method="post" action="<%=request.getContextPath()%>/findpasswd/secondstep" accept-charset="utf-8">
                <div class="weui_cells weui_cells_form">

                    <div class="weui_cell">
                    	<input type="hidden" name="mobile" value="${mobile}">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_mm1"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input v-show="!isPwShow" maxlength="16" value=""  id="passwd" class="weui_input" name="passwd" type="password" placeholder="请输入新密码" v-model="input_1">
                        </div>
                    </div>
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_mm1"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input v-show="!isPwShow" class="weui_input" maxlength="16" value="" name="confirmPasswd" type="password" placeholder="再次输入密码" v-model="input_2">
                        </div>
                    </div>
                </div>
                  <font color="red">${error }</font>
                 <button class="weui_btn leui_btn_warn form-submit"  :class="{'leui_btn_disabled': disabled}">确认修改</button>
            </form>

        </div>
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
<script src="<%=request.getContextPath()%>/assets/js/outside/findpasswd/secondstep.js"></script>
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

/*     $(function(){


        $('.form-submit').on('click',function(){

            var password = $('[name=password]');
            var newpassword = $('[name=newpassword]');

            if ( !password.val() ) {
                $.alert('请输入新密码');

                return false;
            }

            if ( !(/\w{6,16}$/.test(password.val())) ) {
                $.alert('新密码长度6-16位之间，只能包括字母、数字和下划线');

                return false;
            }

            if ( !newpassword.val() ) {
                $.alert('请确认新密码');

                return false;
            }

            if ( !(/\w{6,16}$/.test(newpassword.val())) ) {
                $.alert('确认密码长度6-16位之间，只能包括字母、数字和下划线');
                return false;
            }

            if ( password.val() != newpassword.val() ) {
                $.alert('两次密码不一致,请重新输入');
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
            input_3: '',
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
</body>
</html>

