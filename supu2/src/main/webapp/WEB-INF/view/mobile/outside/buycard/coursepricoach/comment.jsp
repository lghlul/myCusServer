<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
        <title>私教课程评价</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/outside/weui.min.css">
        <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <style type="text/css">
            .comment {
                background-color: red;
                color: #fff;
                text-align: center;
                width: 100%;
                height: 31px;
                font-size: 20px;
                margin-top:20px;
            }
            a {
                color: #f1c40f;
            }

            a:hover,
            a:active,
            a:focus {
                color: #dab10d;
            }

            .rating-stars {
                width: 100%;
                text-align: center;
            }

            .rating-stars .rating-stars-container {
                font-size: 0px;
            }

            .rating-stars .rating-stars-container .rating-star {
                display: inline-block;
                font-size: 32px;
                color: #555555;
                cursor: pointer;
                padding: 5px 10px;
            }

            .rating-stars .rating-stars-container .rating-star.is--active,
            .rating-stars .rating-stars-container .rating-star.is--hover {
                color: #f1c40f;
            }

            .rating-stars .rating-stars-container .rating-star.is--no-hover {
                color: #555555;
            }
        </style>
    </head>

<body>
<div id="app">
    <p style="font-size:16px;margin-top:12px;margin-left:12px;margin-bottom: 14px;">打分</p>
    <div class="rating-stars block" id="another-rating">
        <div class="rating-stars-container">
            <div class="rating-star">
                <i class="fa fa-star"></i>
            </div>
            <div class="rating-star">
                <i class="fa fa-star"></i>
            </div>
            <div class="rating-star">
                <i class="fa fa-star"></i>
            </div>
            <div class="rating-star">
                <i class="fa fa-star"></i>
            </div>
            <div class="rating-star">
                <i class="fa fa-star"></i>
            </div>
        </div>
    </div>

    <p style="font-size:16px;margin-top:12px;margin-left:12px;margin-bottom: 14px;">评价(最多40字)</p>
    <textarea maxlength="40" id="content" style="width: 100%;height: 54px;font-size: 14px;">

    </textarea>

    <div class="comment">提交</div>
</div>

<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.rating-stars.min.js"></script>

<script>
    var baseUrl = '${pageContext.request.contextPath}';
</script>
<script>

    var star = "";
    var sourceID = "${id}";
    var source = "${source}";
    //souce 1私教课2团课3门店4私教
    $(".comment").on("click",function(){
        //弹出框
        var postData = {
            "source":source,
            "status":"2",
            "startlevel":star,
            "sourceID":sourceID,
            "content":$.trim($("#content").val())
        }

        if(star == ""){
            alert("请您给打星！");
            return false;
        }

        $.ajax({
            type:"POST",
            url:baseUrl+"/outside/comment/insertComment",
            data:postData,
            success:function(data){
                  if(data.resultCode == "200"){
                      alert("评论成功");
                      window.history.go(-1);
                  }
                }
            })
        });
</script>
<script type="text/javascript">
    var ratingOptions = {
        selectors: {
            starsSelector: '.rating-stars',
            starSelector: '.rating-star',
            starActiveClass: 'is--active',
            starHoverClass: 'is--hover',
            starNoHoverClass: 'is--no-hover',
            targetFormElementSelector: '.rating-value'
        }
    };

    $(".rating-stars").ratingStars(ratingOptions);

    $(".rating-stars").on("ratingChanged", function (ev, data) {
        star = data.ratingValue
    });
</script>

</body>
<script src="<%=request.getContextPath()%>/assets/js/outside/buycard/coursegroup/detail_course_group_list.js"></script>
</html>