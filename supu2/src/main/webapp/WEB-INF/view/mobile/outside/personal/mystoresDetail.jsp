<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/view/common/header.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>门店详情</title>
    <link href="<%=request.getContextPath()%>/assets/css/outside/app.bc1787ce0ba559569c9c8c9be952468e.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/outside/app.9e12c781367b0ad844d04a44c444df1c.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/outside/font_jkkyihorcrpv6lxr.css">
    <style type="text/css">

        .comment {
            background-color: red;
            color: #fff;
            text-align: center;
            width: 100%;
            height: 31px;
            font-size: 20px;
            line-height:31px;
        }
        .commentList {
            font-size:12px;
            margin-bottom:30px;
        }
        .comment_title {
            font-size:16px;margin-top:12px;margin-left:12px;margin-bottom: 14px;
        }

        .commentList .item{
            width: 100%;
            height: 96px;
        }

        .item img {
            height:66px;
            display: inline-block;
            margin-bottom: 5px;
            float: left;
            margin-left:10px;
        }

        .item .right{
            float: right;
            width: 70%;
        }

        .item .right p {
            margin-bottom: 5px
        }
        .stars span {
            /*background-image: url(../../../images/leoao-coach-mstar.png);*/
            /*background-repeat: no-repeat;*/
            background-position: 0 50%;
            background-size: 0.2rem;
            width: 0.2rem;
            height: 0.2rem;
        }
    </style>
<body>
<p class="comment_title">评价</p>
<div class="commentList">
</div>
<div class="comment">评价</div>
<script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/time.js"></script>
<script>
    $(function(){
        var baseUrl = '${pageContext.request.contextPath}';
        var id = '${id}';
        //评价来源标识：1私教课2团课3门店4私教
        $(".comment").on("click",function(){
            //弹出框
            window.location.href= "/outside/comment/priCourseComment?id="+id+"&source=3";
        })
        getCommentList();
        function getCommentList(){
            $.ajax({
                type:"GET",
                url:baseUrl+"/outside/comment/getCommenListPublic?source=3&sourceID="+id+"&limitstart=1&limitend=10",
                success:function(data){
                    if(data.resultCode == "200"){
                        debugger;
                        showList(data.records);
                    }
                }
            })
        }

        function showList(list){
            var htmlString = "";
            var star="";
            for(var i =0;i<list.length;i++){
                if(list[i].startlevel == 5){
                    star = '<span></span><span></span><span></span><span></span><span></span>';
                }
                if(list[i].startlevel == 4){
                    star = '<span></span><span></span><span></span><span></span>';
                }
                if(list[i].startlevel == 3){
                    star = '<span></span><span></span><span></span>';
                }
                if(list[i].startlevel == 2){
                    star = '<span></span><span></span>';
                }
                if(list[i].startlevel == 1){
                    star = '<span></span>';
                }
                htmlString+='<div class="item"><img src="'+list[i].head+'" alt="">' +
                    '<div class="right"><p>'+list[i].userName+'</p><span> <div class="stars">'+ star+ '</div></span>' +
                    '<p>'+list[i].content+'</p>' +
                    '<p>'+Time.getFormatTime(list[i].addtime)+'</p></div></div>';
            }
            $(".commentList").html(htmlString);
        }
    })

</script>

</body>
</html>
