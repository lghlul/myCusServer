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
        regOrLogin(userAccount,userPwd,1);
        return false;
    });


    $("#registerForm button").click(function(){
        var msg = $("#registerForm .msg");
        msg.hide();
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
        regOrLogin(userAccount,userPwd,2);
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


var regOrLogin = function(userAccount , userPwd ,type){
    var data = {"userAccount":userAccount , "userPwd" : userPwd};
    var url = "login.do";

    if(type == 2){
        url = "register.do";
    }
    $.post(url,data,function(data){
        if(data.code == 0){
           window.location.href = "../index.jsp";
        }else if(data.code == 999) {
            var msg = $("#registerForm .msg");
            msg.html("用户名已被注册");
            msg.show();
        }else{
            if(type == 1){
                var msg = $("#loginForm .msg");
                msg.html("用户名或密码错误");
                msg.show();
            }else{
                var msg = $("#registerForm .msg");
                msg.html("注册失败");
                msg.show();
            }
        }
    });
}