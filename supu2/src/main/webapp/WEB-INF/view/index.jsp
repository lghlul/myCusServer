<!DOCTYPE html>
<html lang="zh-CN">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="utf-8">
    <title>速扑后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/common.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/images/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/themes/night.css"
          id="skin-switcher">
    <link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <script src="<%=request.getContextPath() %>/assets/js/jquery/jquery-2.0.3.min.js"></script>
    <style>
        .top-middle {
            /* background-color: #4CA8EB; */
        }
    </style>
</head>
<body onLoad="" style="overflow: hidden;">
<!-- 头部 -->
<header class="navbar clearfix" id="header">
    <div class="container">
        <div class="navbar-brand">
            <!-- LOGO -->
            <div class="top-logo">
                <img src="<%=request.getContextPath() %>/assets/images/logo.jpg" alt="" class="img-responsive">
            </div>

        </div>
        <div class="top-middle">

            <!-- BEGIN 头部菜单 -->
            <ul class="nav navbar-nav pull-right">
                <!--日期-->
                <!--li class="bill-date">
                    <i class="iconfont">&#xe68c;</i>
                    账期：
                    <input id="txt_time" type="text"
                              runat="server" onclick="WdatePicker({dateFmt:'yyyy年MM月'})"
                              class="Wdate" maxlength="6" style="height: 30px;outline: none" />
                </li>
                < BEGIN 通知提醒 -->
                <!-- li class="dropdown" id="header-notification">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="iconfont">&#xe667;</i>
                        <div class="hongse"><span>7</span></div>

                    </a>
                    <ul class="dropdown-menu notification">
                        <li class="dropdown-title">
                            <span><i class="fa fa-bell"></i> 7 通知</span>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-success"><i class="fa fa-user"></i></span>
                            <span class="body">
                                <span class="message">5 用户在线. </span>
                            <span class="time">
                                    <i class="fa fa-clock-o"></i>
                                    <span>Just now</span>
                            </span>
                            </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary"><i class="fa fa-comment"></i></span>
                            <span class="body">
                                <span class="message">最新评论.</span>
                            <span class="time">
                                    <i class="fa fa-clock-o"></i>
                                    <span>19 分钟前</span>
                            </span>
                            </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-warning"><i class="fa fa-lock"></i></span>
                            <span class="body">
                                <span class="message">DW1服务器锁定.</span>
                            <span class="time">
                                    <i class="fa fa-clock-o"></i>
                                    <span>32 分钟前</span>
                            </span>
                            </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-info"><i class="fa fa-twitter"></i></span>
                            <span class="body">
                                <span class="message">维持连接.</span>
                            <span class="time">
                                    <i class="fa fa-clock-o"></i>
                                    <span>55 分钟前</span>
                            </span>
                            </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-danger"><i class="fa fa-heart"></i></span>
                            <span class="body">
                                <span class="message">Jane liked. </span>
                            <span class="time">
                                    <i class="fa fa-clock-o"></i>
                                    <span>2 hrs</span>
                            </span>
                            </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-warning"><i class="fa fa-exclamation-triangle"></i></span>
                            <span class="body">
                                <span class="message">数据库过载.</span>
                            <span class="time">
                                    <i class="fa fa-clock-o"></i>
                                    <span>6 小时</span>
                            </span>
                            </span>
                            </a>
                        </li>
                        <li class="footer">
                            <a href="#">查看所有通知 <i class="fa fa-arrow-circle-right"></i></a>
                        </li>
                    </ul>
                </li-->
                <!-- END 通知提醒 -->
                <!-- 用户管理 -->
                <li class="dropdown user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="iconfont">&#xe657;</i>
                        <div class="user-name">admin</div>
                        <!-- <div class="uName-smallIcon"></div> -->
                    </a>

                </li>


                <li class="dropdown user">
                    <%--  href="${pageContext.request.contextPath }/user/logout" --%>
                    <a onclick="logout();" href="javascript:;" class="dropdown-toggle">
                        <i class="iconfont">&#xe600;</i>
                    </a>
                </li>

                <!-- END 用户管理 -->
            </ul>
            <!-- END 头部菜单 -->
        </div>
        <div class="">

        </div>
    </div>
</header>
<!--/头部 -->

<!-- 主体 -->
<section id="page">
    <!-- 左侧菜单 sidebar-->
    <div id="sidebar" class="sidebar">
        <div class="sidebar-menu nav-collapse">
            <div class="divide-20"></div>

            <div id="sidebar-collapse" class="sidebar-collapse btn">
                <i class="fa fa-bars" data-icon1="fa fa-bars" data-icon2="fa fa-bars"></i>
            </div>


            <ul>

                <li class="has-sub open" id="menu">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/store/listPage">
                        <i class="iconfont">&#xe63f;</i> <span class="menu-text">门店管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 			<ul class="sub">
                                        <li class="current">
                                            <a href="<%=request.getContextPath() %>/user/realse/firstCategory" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">发布服务</span></a>
                                        </li>
                                        <li class="current">
                                             </li>


                                </ul> --%>

                </li>
                <li class="has-sub ">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/memberCard/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">会员卡管理</span>
                        <span class="arrow"></span>
                    </a>
                <li class="has-sub ">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/member/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">会员管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 	<ul class="sub">
                                <li class="current">
                                    <a href="<%=request.getContextPath() %>/user/realse/listPage" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">已发布服务列表</span></a>
                                </li>


                        </ul> --%>

                </li>

                <li class="has-sub ">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/xfuser/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">用户管理</span>
                        <span class="arrow"></span>
                    </a>
                </li>
                <li class="has-sub">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/coach/listPage">
                        <i class="iconfont">&#xe63f;</i> <span class="menu-text">教练管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 		<ul class="sub">
                                    <li class="current">
                                        <a href="<%=request.getContextPath() %>/user/realseInfo/addPage" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">发布资讯</span></a>
                                    </li>
                                    <li class="current">
                                  </li>


                            </ul> --%>

                </li>
                <li class="has-sub">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/pricoursetime/listPage">
                        <i class="iconfont">&#xe63f;</i> <span class="menu-text">私教时间管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 		<ul class="sub">
                                    <li class="current">
                                        <a href="<%=request.getContextPath() %>/user/realseInfo/addPage" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">发布资讯</span></a>
                                    </li>
                                    <li class="current">
                                  </li>


                            </ul> --%>

                </li>
                <li class="has-sub ">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/course/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">课程管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 	<ul class="sub">
                                <li class="current">
                                    <a href="<%=request.getContextPath() %>/user/realseInfo/listPage" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">已发布资讯列表</span></a>
                                </li>


                        </ul> --%>

                </li>
                <li class="has-sub ">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/order/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">订单管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 	<ul class="sub">
                                <li class="current">
                                    <a href="<%=request.getContextPath() %>/user/realseInfo/listPage" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">已发布资讯列表</span></a>
                                </li>


                        </ul> --%>

                </li>
                <li class="has-sub ">
                    <a target="Conframe" href="<%=request.getContextPath() %>/user/appoint/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">约课管理</span>
                        <span class="arrow"></span>
                    </a>
                    <%-- 	<ul class="sub">
                                <li class="current">
                                    <a href="<%=request.getContextPath() %>/user/realseInfo/listPage" target="Conframe"><i class="fa fa-users fa-fw"></i><span class="sub-menu-text">已发布资讯列表</span></a>
                                </li>


                        </ul> --%>

                </li>
                <%-- 		<li class="has-sub ">
                <a target="Conframe" href="<%=request.getContextPath() %>/user/comment/listPage">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">评价管理</span>
                        <span class="arrow"></span>
                </a>


            </li> --%>
                <li class="has-sub ">
                    <a target="Conframe">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">活动管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="current">
                            <a href="<%=request.getContextPath() %>/activity/listPage" target="Conframe"><i
                                    class="fa fa-users fa-fw"></i><span class="sub-menu-text">活动管理</span></a>
                        </li>
                        <!--
                        <li class="current">
                            <a href="<%=request.getContextPath() %>/user/appoint/listPage" target="Conframe"><i
                                    class="fa fa-users fa-fw"></i><span class="sub-menu-text">奖品管理</span></a>
                        </li>-->
                    </ul>

                </li>



                <li class="has-sub ">
                    <a target="Conframe">
                        <i class="iconfont">&#xe615;</i> <span class="menu-text">问题数据处理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="current">
                            <a href="<%=request.getContextPath() %>/user/xfuser/listErrorPage" target="Conframe"><i
                                    class="fa fa-users fa-fw"></i><span class="sub-menu-text">问题用户</span></a>
                        </li>
                        <li class="current">
                            <a href="<%=request.getContextPath() %>/user/member/listErrorPage" target="Conframe"><i
                                    class="fa fa-users fa-fw"></i><span class="sub-menu-text">问题会员</span></a>
                        </li>
                    </ul>
                </li>

            </ul><!-- 左侧菜单 -->
            <!-- /左侧菜单 -->
        </div>
    </div>
    </div>
    <!-- /左侧菜单 sidebar-->
    <div id="main-content">
        <div class="container">
            <div class="Conframe">
                <!-- 右侧开始-->
                <iframe name="Conframe" id="Conframe" src="<%=request.getContextPath() %>/user/store/listPage" onload=""
                        width="80%" border="0" frameborder="0">
                </iframe>
                <!-- 右侧结束-->
            </div>
        </div>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="login_out" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <i class="iconfont">&#xe644;</i>
                    </button>
                    <h8 class="modal-title" id="myModalLabel">
                        确认退出
                    </h8>
                </div>
                <div class="modal-body">
                    <h4><span id="resultMsg"></span></h4>
                    <div class="modal-footer">
                        <a onclick="hide();" class="btn btn-default">
                            取消
                        </a>
                        <a href="<%=request.getContextPath() %>/user/logout" class="btn btn-default">
                            确定
                        </a>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal -->
        </div>
    </div>
</section>
<!--/主体 -->
<!-- JAVASCRIPTS -->
<!-- JQUERY -->

<!-- BOOTSTRAP -->
<script src="<%=request.getContextPath() %>/assets/bootstrap/js/bootstrap.min.js"></script>

<!--相应按钮 COOKIE -->
<script type="text/javascript"
        src="<%=request.getContextPath() %>/assets/js/jQuery-Cookie/jquery.cookie.min.js"></script>
<!-- CUSTOM SCRIPT -->
<script src="<%=request.getContextPath() %>/assets/js/script.js"></script>
<%-- <script src="<%=request.getContextPath() %>/assets/bootstrap/js/table/sidebar-menu.js"></script>
<script src="<%=request.getContextPath() %>/assets/bootstrap/js/table/bootstrap-addTabs.js"></script> --%>
<script>
    jQuery(document).ready(function () {
        App.setPage("dynamic_table"); //左侧菜单
        App.init();
    });
    $(".sidebar-collapse").click(function () {
        if ($(".sidebar-collapse").css("left") == "100px") {
            $(".sidebar-collapse").css({"left": "5px"});
        } else {
            $(".sidebar-collapse").css({"left": "100px"});
        }
    });

    function logout() {
        $('#login_out').modal('show');
    }

    function hide() {
        $('#login_out').modal('hide');
    }
</script>
<!-- /JAVASCRIPTS -->

</body>

</html>