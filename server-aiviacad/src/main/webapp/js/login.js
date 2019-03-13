$(function(){


    $("#registerForm input[name='userAccount']").blur(function(){
        var userAccount = $("#registerForm input[name='userAccount']").val();
        if(userAccount && userAccount.length > 3){
            var data = {"userAccount":userAccount};
            var url = "checkAccount.do";
            $.get(url,data,function(data){
                if(data.code == 999){
                    var msg = $("#registerForm .msg");
                    msg.html("用户名已被注册");
                    msg.show();
                }
            });
        }
    });

    $("#loginForm button").click(function(){
        var msg = $("#loginForm .msg");
        msg.hide();
        var userAccount = $("#loginForm input[name='userAccount']").val();
        if(!userAccount){
            msg.html("请输入用户名");
            msg.show();
            return false;
        }
        var userPwd = $("#loginForm input[name='userPwd']").val();
        if(!userPwd){
            msg.html("请输入密码");
            msg.show();
            return false;
        }
        login(userAccount,userPwd);
        return false;
    });

    $("#createCodeBtn").click(function(){
        var url = "../codeManage/getCode.do"
        $.getJSON(url,function(data){
            $("#userCode").val(data.resultData);
        })
        return false;
    });


    $("#registerBtn").click(function(){
        var msg = $("#registerForm .msg");
        msg.hide();
        //校验用户名
        var userAccount = $("#registerForm input[name='userAccount']").val();
        if(!userAccount){
            msg.html("请输入用户名");
            msg.show();
            return false;
        }
        if(userAccount.length < 4){
            msg.html("用户名长度不能小于4");
            msg.show();
            return false;
        }
        //校验用户密码
        var userPwd = $("#registerForm input[name='userPwd']").val();
        if(!userPwd){
            msg.html("请输入密码");
            msg.show();
            return false;
        }
        if(userPwd.length < 6){
            msg.html("密码长度不能小于6");
            msg.show();
            return false;
        }
        if(!$("#registerForm input[name='userConfirmPwd']").val()){
            msg.html("请输入确认密码");
            msg.show();
            return false;
        }

        if($("#registerForm input[name='userPwd']").val() != $("#registerForm input[name='userConfirmPwd']").val()){
            msg.html("密码不一致");
            msg.show();
            return false;
        }
        //校验邮箱和手机号码
        var phone = $("#registerForm input[name='phone']").val();
        var email = $("#registerForm input[name='email']").val();
        /*if(!phone){
            msg.html("请输入手机");
            msg.show();
            return false;
        }*/

        if(phone && !isPoneAvailable(phone)){
            msg.html("请输入正确的手机");
            msg.show();
            return false;
        }
        if(!email){
            msg.html("请输入邮箱");
            msg.show();
            return false;
        }
       /* if(!(phone || email)){
            msg.html("请输入手机或者邮箱");
            msg.show();
            return false;
        }*/

        if(email && !isEmail(email)){
            msg.html("请输入正确的邮箱");
            msg.show();
            return false;
        }
        var userCode = $("#registerForm input[name='userCode']").val();
        if(!userCode){
            msg.html("请输入用户编号");
            msg.show();
            return false;
        }

        register(userAccount,userPwd,phone,email,userCode);
        return false;
    });



    $("#sendCodeBtn").click(function() {
        var msg = $("#findPwdForm .msg");
        msg.hide();
        var email = $("#findPwdForm input[name='email']").val();
        if(!email || !isEmail(email)){
            msg.html("请输入正确的邮箱");
            msg.show();
            return false;
        }

        var url = "../user/sendEmailCode.do";
        var arg = {"email" : email};
        $.post(url,arg,function(data){
            if(data.code == 994){
                msg.html("邮箱尚未注册");
                msg.show();
            }else if(data.code == 0){
                settime();
            }
        },"JSON");


        return false;
    });


    $("#findPwdBtn").click(function(){
        var msg = $("#findPwdForm .msg");
        msg.hide();

        var email = $("#findPwdForm input[name='email']").val();
        if(!email || !isEmail(email)){
            msg.html("请输入正确的邮箱");
            msg.show();
            return false;
        }
        
        //校验用户密码
        var userPwd = $("#findPwdForm input[name='userPwd']").val();
        if(!userPwd){
            msg.html("请输入密码");
            msg.show();
            return false;
        }
        if(userPwd.length < 6){
            msg.html("密码长度不能小于6");
            msg.show();
            return false;
        }
        if(!$("#findPwdForm input[name='userConfirmPwd']").val()){
            msg.html("请输入确认密码");
            msg.show();
            return false;
        }

        if($("#findPwdForm input[name='userPwd']").val() != $("#findPwdForm input[name='userConfirmPwd']").val()){
            msg.html("密码不一致");
            msg.show();
            return false;
        }

        var emailCode = $("#findPwdForm input[name='emailCode']").val();
        if(!emailCode || emailCode.length < 6){
            msg.html("请输入6位数验证码");
            msg.show();
            return false;
        }


        var url = "../user/findPwd.do";
        var arg = {"email" : email , "userPwd" : userPwd , "emailCode" : emailCode};
        $.post(url,arg,function(data){
            if(data.code == 993){
                msg.html("验证码无效或者已过期");
                msg.show();
            }else if(data.code == 0){
                //changeForm(0);
                $('#findPwdForm')[0].reset();
                layer.alert("密码修改成功",{closeBtn:0});
            }
        },"JSON");

        return false;
    });

});
var countdown = 60;
function settime() {
    if (countdown == 0) {
        $("#sendCodeBtn").removeAttr("disabled");
        $("#sendCodeBtn").html("获取验证码");
        countdown = 60;
        return false;
    } else {
        $("#sendCodeBtn").attr("disabled","disabled")
        $("#sendCodeBtn").html("重新发送(" + countdown + ")");
        countdown--;
    }
    setTimeout(function() {
        settime();
    },1000);
}

var changeForm = function(index){
    $(".msg").hide();
    $("form").eq(index).show();
    $("form:gt(" + index + ")").hide();
    $("form:lt(" + index + ")").hide();
}


var login = function(userAccount , userPwd){
    var data = {"userAccount":userAccount , "userPwd" : userPwd};
    var url = "login.do";
    $.post(url,data,function(data){
        if(data.code == 0){
            window.location.href = "../index.jsp";
        }else{
            var msg = $("#loginForm .msg");
            msg.html("用户名或密码错误");
            msg.show();
        }
    });
}

var register = function(userAccount , userPwd ,phone , email,userCode){
    var data = {"userAccount":userAccount , "userPwd" : userPwd , "phone" : phone , "email":email, "userCode" : userCode};
    var url = "register.do";

    $.post(url,data,function(data){
        if(data.code == 0){
           window.location.href = "../index.jsp";
        }else if(data.code == 999) {
            var msg = $("#registerForm .msg");
            msg.html("用户名已被注册");
            msg.show();
        }else if(data.code == 998) {
            var msg = $("#registerForm .msg");
            msg.html("手机重复");
            msg.show();
        }else if(data.code == 997) {
            var msg = $("#registerForm .msg");
            msg.html("邮箱重复");
            msg.show();
        }else if(data.code == 996) {
            var msg = $("#registerForm .msg");
            msg.html("用户编号重复");
            msg.show();
        }else{
                var msg = $("#registerForm .msg");
                msg.html("注册失败");
                msg.show();
        }
    });
}

var isPoneAvailable = function(phone) {
    var myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
    return myreg.test(phone);
}

var isEmail = function(email) {
    var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
    return reg.test(email);
}