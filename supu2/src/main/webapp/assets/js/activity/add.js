$(function () {
    $("#form").validate({
        onSubmit: true,// 是否在提交是验证
        rules: {
            title: {
                required: true
            },
            contact: {
                required: true,
                maxlength: 11,
                minlength: 11,
                digits: true
            },
            introduce: {
                required: true
            },
            startDate: {
                required: true
            },
            endDate: {
                required: true
            }
        },
        messages: {
            title: {
                required: "请输入标题"
            },
            contact: {
                required: "请输入手机号码",
                maxlength: " 手机号码为11位数字",
                minlength: " 手机号码为11位数字",
                digits: " 手机号码为11位数字"
            },
            startDate: {
                required: "请输入开始时间"
            },
            endDate: {
                required: "请输入结束时间"
            },
            introduce: {
                required: "请输入介绍"
            }
        },
        submitHandler: function (form) {  //通过之后回调
            $.ajax({
                type: "POST",
                url: baseUrl + '/activity/add',
                data: $('#form').serialize(),
                success: function (data) {
                    if (data.resultCode == 200) {
                        $('#success').modal('show');
                    } else {
                        $('#sp_msg').text(data.message == null ? "添加失败" : data.message);
                        $('#failure').modal('show');
                    }
                }
            });
        }
    });

});