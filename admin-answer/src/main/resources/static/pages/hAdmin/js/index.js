$(function(){
    //菜单点击
    J_iframe
    $("body").on('click','.J_menuItem',function(){
        var url = $(this).attr('href');
        $("#J_iframe").attr('src',url);
        return false;
    });
    $("#logout").on('click',function(){
        $.post("/logout",function(res){
            if(res.resultCode==1){
                window.localStorage.removeItem("roleId");
                window.localStorage.removeItem("adminId");
                window.location.href = "toLogin";
            }
        },"json")
    })
});