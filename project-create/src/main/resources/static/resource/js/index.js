$(function(){

    $("form button").click(function(){
        var loading;
        $.ajax({
            type: 'post',
            url: '../project/create',
            data: $('form').serialize(),
            beforeSend:function(XMLHttpRequest){
                //load.start();
                loading = layer.msg('创建中,请稍后...', {
                    icon: 16
                    ,shade:0.5,
                    time:0
                });
            },
            success: function (data) {
                //load.stop();
                layer.close(loading);
                if(data.code == 0){
                    window.location.href = "../" + $("input[name='artifactId']").val() + ".zip";
                }else{
                    layer.msg(data.msg);
                }
            },
            complete:function(XMLHttpRequest,textStatus){
                //load.stop();
                layer.close(loading);
            },
            error:function(XMLHttpRequest,textStatus,errorThrown){
                //load.stop();
                layer.close(loading);
            }
        });
    });
})