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


    $("#registerForm button").click(function(){
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
        if(!(phone || email)){
            msg.html("请输入手机或者邮箱");
            msg.show();
            return false;
        }
        if(phone && !isPoneAvailable(phone)){
            msg.html("请输入正确的手机");
            msg.show();
            return false;
        }
        if(email && !isEmail(email)){
            msg.html("请输入正确的邮箱");
            msg.show();
            return false;
        }

        register(userAccount,userPwd,phone,email);
        return false;
    });

})

var changeForm = function(index){
    $(".msg").hide();
    if(index == 0){
        $("form").eq(index).hide();
        $("form").eq(1).show();
    }else{
        $("form").eq(index).hide();
        $("form").eq(0).show();
    }
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

var register = function(userAccount , userPwd ,phone , email){
    var data = {"userAccount":userAccount , "userPwd" : userPwd , "phone" : phone , "email":email};
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