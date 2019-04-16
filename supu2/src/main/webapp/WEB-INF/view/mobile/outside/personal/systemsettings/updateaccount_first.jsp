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
            <form method="post" action="" accept-charset="utf-8">
                <div class="weui_cells weui_cells_form">
                    <div class="weui_cell">
                        <div class="weui_cell_hd">
                            <label class="weui_label"><i class="iconfont icon-ico_login_phone-copy"></i></label>
                        </div>
                        <div class="weui_cell_bd weui_cell_primary">
                            <input class="weui_input" type="tel" value="" maxlength="11" name="phone" placeholder="请输入原手机号" v-model="input_1">
                        </div>
                    </div>
                </div>
            </form>
            <button class="weui_btn leui_btn_warn form-submit" :class="{'leui_btn_disabled': disabled}"
            	 onclick="window.location='forget_step1.html'"
            	>下一步</button>
        </div>
        <!-- login-form end -->
    </div>
</div>

<script src="<%=request.getContextPath()%>/assets/js/outside/font_zphmkln2rzyyzaor.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/jquery-weui.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/outside/vue.min.js"></script>
<script type="text/javascript">
    var changePh = new Vue ({
      el: "#app_sign",
      data: {
        curPh: '',
        newPh: '',
        vailCode:'',
        picCode: '',
        count:0,
        show:1,
        timer:0,
      },
      watch: {
        'oldPw': function(val, oldVal){
          this.canSub()
        },
        'curPh': function(val, oldVal){
          this.canSub()
        },
      },
      computed:{
      	vailPhone:function(){
      		return !/^1\d{10}$/.test(this.curPh)
      	},
      	vailNewPhone:function(){
      		return !/^1\d{10}$/.test(this.newPh);
      	},
      	// vailYZM:function(){
      	// 	return /^1\d{10}$/.test(this.newPh) && this.count ==0;
      	// }
      },
      methods: {
        canSub: function(){
          if (this.oldPw && this.curPh) {
            this.disabled = false;
          }else{
              this.disabled = true;
          };
        },
        vaiOldPh:function(){
          //ajax
          console.log(this.curPh)
          var me = this;
          $.ajax({
          	url:'/wap/web/user/reset_phone',
          	data:{phone:this.curPh},
          	type:'POST',
          	success:function(res){
          		if(res.code == 200){
          			if(res.data.phone === me.curPh){
          				me.show = 2;
          			}
          		}else{
          			$.alert(res.resultmessage);
          		}
          	},
          	fail:function(){
          		$.alert('请求失败,请重新提交');
          	}
          })
        },
        getYzm:function(){
            var me = this;
            $.ajax({
                url:'https://m.leoao.com/wap/send_message',
                type:'POST',
                data:{phone:this.newPh,captcha:this.picCode},
                success:function(res){
                    if(res.code ==200){
                      me.count = 60;
                      me.timer = setInterval(function(){
                          me.count--;
                          if(me.count === 0){
                              clearInterval(me.timer);
                          }
                      },1000);
                    }else{
                      $.alert(res.resultmessage);
                    }
                },
                fail:function(){
                  $.alert('获取验证码失败,请重试');
                }
            })
        },
        resetPhone:function(){
    		$.ajax({
    			url:'/wap/web/user/do_reset_phone',
    			type:'POST',
    			data:{new_phone:this.newPh,code:this.vailCode},
    			success:function(res){
    				if(res.code==200){
              $.alert(res.resultmessage,function(){
                // var href = window.location.href.replace(/[^\?]+\?([^?]+)/,'$1');
                window.history.back()
              });
            }else{
              $.alert(res.resultmessage);
            }
    			},
    			fail:function(){
    				$.alert('请求失败,请重新提交');
    			}
    		})
        }
      }
    })
  </script>
</body>
</html>