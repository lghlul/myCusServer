<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>




<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
//错误信息设置
String errorStr = "";
Object error = (Object) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
if(error != null){
	errorStr = error.toString();
}

request.setAttribute("error", errorStr);
%>

<style type="text/css">
	/*去除input默认样式*/
/*input {
	-webkit-appearance: none;
}

input[type="submit"],
input[type="reset"],
input[type="button"],
input {
	-webkit-appearance: none;
}*/


input:-webkit-autofill {
    text-indent: 2.2em;
    height: 43px;
    line-height: 43px;
    font-size: 16px;
    color: #696C7F;

    border: 1px solid #696C7F;
    border-radius: 3px;
    outline: medium;
    padding: 10px;
    /* -webkit-box-shadow: 0 0 0px 1000px white inset; */
}

.modal-content input::-moz-placeholder {
  color: #999;
  opacity: 1;
}
/*ie placeholder*/
.modal-content input:-ms-input-placeholder {
  color: #999; line-height: 20px; height:43px;
}

.modal-content input::-webkit-input-placeholder {
  color: #999;
}

.modal-content input {
  display: block;
    text-indent: 2.2em;
    height: 43px;
    line-height: 43px;
    font-size: 16px;
    color: #333333;
    border: 1px solid #D2D5DE;
    border-radius: 3px;
    outline: medium;
    padding: 10px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
          box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
       -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
          transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
/*鼠标点击后边框颜色*/
.modal-content input:focus {
  border-color: #66afe9;
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102, 175, 233, .6);
          box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102, 175, 233, .6);
}
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>速扑后台管理系统</title>
	<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
	<!---<link rel="stylesheet" type="text/css" href="${ctx}/assets/css/bglogin.css" />--->
   <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/images/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/login/anonymous.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/login.css" />

</head>
<body>
	<div id="particles-js"></div>

<div class="modal_my">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="loginForm" action="" method="post">
                <!--logo-->
                <div class="login_main_top"></div>
                <!--输入错误提示-->
                <div class="login_main_errortip"><i id='iconfont' class='iconfont'>&#xe721;</i>&nbsp;</div>
                <!--输入用户名-->
                <div class="login_main_ln">
                    <i class="iconfont">&#xe657;</i><input type="text" placeholder="请输入用户名" id="username" name="username" />
                </div>
                <!--输入密码-->
                <div class="login_main_pw">
                    <i class="iconfont">&#xe66a;</i><input type="password" placeholder="输入密码" id="password" name="password"/>
                </div>
               <!--输入验证码-->
               <c:if test="${loginCount >3}">
                <div class="login_main_yzm">
                    <i class="iconfont">&#xe71c;</i><input type="text" placeholder="输入验证码" id="captcha" name="captcha"/>

                    <img alt="验证码" src="<%=request.getContextPath()%>/images/kaptcha.jpg" title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" />
                </div>
                 </c:if>
                <!--提交验证-->
                <div class="login_main_submit">
                    <button type="button" onclick="onSubmintFun();">立 即 登 录</button>
                </div>



                <!--记住我单选框-->
                <!--<input id="rememberMe" name="rememberMe" type="checkbox"/>-->
                 <!--<div class="login_main_remb">
                    <div class="cbt"  id="rememberMe" name="rememberMe" type="checkbox" ></div>
                    <span>记住用户名</span>
                    <a href="javascript:void(0)">忘记密码？</a>
                </div>-->
            </form>
        </div>
    </div>
       <div class="copy_right">Copyright &copy; 2017-2018 速扑健身版权所有</div>
</div>
<script>
var baseUrl = "${pageContext.request.contextPath}";

</script>

<c:set var="exp_type" value="<%=errorStr %>"/>
<c:if test="${fn:contains(exp_type,'IncorrectCaptchaException')}">
    <script>
    $(".login_main_errortip").css("display","block");
    	/* $("<span>验证码错误，请重试</span>").appendTo("#iconfont p"); */
     /* 	$("<span>验证码错误，请重试</span>").appendto(".login_main_errortip"); */
		$(".login_main_errortip").append("<span style='float:left'>验证码错误，请重试</span>");
        /* $(".login_main_errortip #iconfont").html("<span>验证码错误，请重试</span>"); */
    </script>
</c:if>
<c:if test="${fn:contains(exp_type,'UnknownAccountException')}">
    <script>
    $(".login_main_errortip").css("display","block");
        $(".login_main_errortip #iconfont").html("<span>用户名不存在，请重试</span>");
    </script>
</c:if>
<c:if test="${fn:contains(exp_type,'DisabledAccountException')}">
    <script>
    $(".login_main_errortip").css("display","block");
        $(".login_main_errortip #iconfont").html("<span>账号被禁用，请重试</span>");
    </script>
</c:if>
<c:if test="${fn:contains(exp_type,'IncorrectCredentialsException')}">
    <script>
         // $(".login_main_errortip").html("密码错误，请重试!");
         $(".login_main_errortip").css("display","block");
        $(".login_main_errortip #iconfont").html("<span>密码错误，请重试</span>");
    </script>
</c:if>

		<!--背景动画-->
<script src="<%=request.getContextPath()%>/assets/js/51cs/particles.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/51cs/anonymous.js"></script>
   <!--背景动画样式-->
    <script src="<%=request.getContextPath()%>/assets/js/51cs/jquery.inputbox.js"></script>

	<script>
    $(function(){
        $('.cbt').inputbox();
    });
    $(document).ready(function () {
       // $('input, textarea').placeholder();
    });



	 if (window != top)
		top.location.href = location.href;

	var captcha;
	function refreshCaptcha(){
	    document.getElementById("img_captcha").src=baseUrl+"/images/kaptcha.jpg?t=" + Math.random();
	}

	//登录验证
	function onSubmintFun(){

		//用户名
		var username =  $('#username').val();
		//密码
		var password =  $('#password').val();

		//验证码
		//var captcha =  $('#captcha').val();

		if(username == ""){
			$(".login_main_errortip").css("display","block");
			$(".login_main_errortip #iconfont").html("<span>请输入用户名</span>");
			return;
		}

		if(password == ""){
			$(".login_main_errortip").css("display","block");
			$(".login_main_errortip #iconfont").html("<span>请输入密码");
			return;
		}

		 if(captcha == ""){
			$(".login_main_errortip").css("display","block");
			$(".login_main_errortip #iconfont").html("<span>请输入验证码");
			return;
		}

		//提交
		$('#loginForm').submit();

	}

	</script>
</body>
</html>
