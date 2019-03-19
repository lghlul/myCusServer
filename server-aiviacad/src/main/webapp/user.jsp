<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>MATLACDOM</title>
	<link rel="stylesheet" type="text/css" href="../css/gccx.css">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
	<script src="../layer/layer.js"></script>
	<style type="text/css">
		.form-group{
			text-align: center;
		}
		.layui-layer-btn{
			text-align: center;
		}
	</style>
	<script type="text/javascript">
        $(function(){

            $("#toReset").click(function(){
				$("#pwdForm").show();
				$("#infoForm").hide();
			});

			$("#submitBtn").click(function(){
                var msg = $("#msg");
                msg.hide();
                var userId = $("#userId").val();
				var userOldPwd = $("#userOldPwd").val();
                var userPwd = $("#userPwd").val();
                var userConfirmPwd = $("#userConfirmPwd").val();

                if(!userOldPwd){
                    msg.html("请输入当前密码");
                    msg.show();
                    return false;
				}

                if(!userPwd){
                    msg.html("请输入新密码");
                    msg.show();
                    return false;
                }

                if(userPwd.length < 6){
                    msg.html("密码长度不能小于6");
                    msg.show();
                    return false;
                }

                if(userPwd != userConfirmPwd){
                    msg.html("密码不一致");
                    msg.show();
                    return false;
                }

                var data = {"userId":userId , "userOldPwd" : userOldPwd , "userPwd" : userPwd};
                var url = "../user/resetPwd.do";

                $.post(url,data,function(data) {
                    var msg = $("#msg");
                    if (data.code == 0) {
                        //$("#pwdForm").hide();
                        //$("#infoForm").show();
                        $('#pwdForm')[0].reset();
						layer.alert("密码修改成功",{closeBtn:0},function(){
						    window.location.href = "../user/logout.do";
						});
                    } else if (data.code == 995) {
                        msg.html("当前密码错误");
                        msg.show();
                    }
                });
			    return false;
			});
        })
	</script>

</head>
<body>
<div class="top">
	<div class="title">
		<a href="../index.jsp">公差查询</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="../pressure/toIndex.do">气缸压力</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="../pressureChange/toIndex.do">压力转换</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="../projectMaterial/toIndex.do">工程材料</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="../codeManage/toIndex.do">编码管理</a>
	</div>
	<div class="login">
		<c:if test="${user == null}"> <a href="../user/toLogin.do">登录</a></c:if>
		<c:if test="${user != null}"> 你好,<a href="../user/toResetPwd.do"><span class="accountStyle">${user.userAccount}</span></a> <a href="../user/logout.do">退出</a></c:if>
	</div>
</div>


<div style="width: 800px;margin: 100px auto;">
	<form class="form-horizontal" id="infoForm">
		<div class="form-group" >
			<label class="col-sm-5 control-label" style="padding-right: 0px;">用户名称</label>
			<label class="col-sm-1 control-label" style="padding-left: 0px ;padding-right: 0px;text-align: center">:</label>
			<label class="col-sm-5 control-label" style="text-align: left;padding-left: 0px;">${user.userAccount}</label>
		</div>
		<div class="form-group" >
			<label class="col-sm-5 control-label" style="padding-right: 0px;">用户编码</label>
			<label class="col-sm-1 control-label" style="padding-left: 0px ;padding-right: 0px;text-align: center">:</label>
			<label class="col-sm-5 control-label" style="text-align: left;padding-left: 0px;">${user.userCode}</label>
		</div>
		<div class="form-group" >
			<label class="col-sm-5 control-label" style="padding-right: 0px;">手机号码</label>
			<label class="col-sm-1 control-label" style="padding-left: 0px ;padding-right: 0px;text-align: center">:</label>
			<label class="col-sm-5 control-label" style="text-align: left;padding-left: 0px;">${user.phone}</label>
		</div>
		<div class="form-group" >
			<label class="col-sm-5 control-label" style="padding-right: 0px;">邮箱地址</label>
			<label class="col-sm-1 control-label" style="padding-left: 0px ;padding-right: 0px;text-align: center">:</label>
			<label class="col-sm-5 control-label" style="text-align: left;padding-left: 0px;">${user.email}</label>
		</div>
		<div class="form-group" >
			<label class="col-sm-5 control-label" style="padding-right: 0px;">密码管理</label>
			<label class="col-sm-1 control-label" style="padding-left: 0px ;padding-right: 0px;text-align: center">:</label>
			<label class="col-sm-5 control-label" style="text-align: left;padding-left: 0px;"><a href="javascript:void(0)" style="font-size: 15px;color: blue!important;" id="toReset">修改密码</a></label>
		</div>
	</form>
	<form class="form-horizontal" id="pwdForm" style="display: none;">
		<input type="hidden" class="form-control" value="${user.userId}" id="userId"/>
		<div class="alert alert-danger msg" style="width: 60%;margin-left: 20%;display: none!important;" id="msg">
		</div>
		<div class="form-group" >
			<label class="col-sm-4 control-label">用户名称</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" value="${user.userAccount}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label"><span style="color: red;">*</span>&nbsp;当前密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" name="userOldPwd" id="userOldPwd"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label"><span style="color: red;">*</span>&nbsp;新密码</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" name="userPwd" id="userPwd"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label"><span style="color: red;">*</span>&nbsp;再次输入</label>
			<div class="col-sm-5">
				<input type="password" class="form-control" name="userConfirmPwd" id="userConfirmPwd"/>
			</div>
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-success " style="width: 20%;" id="submitBtn">确定</button>
		</div>
	</form>

</div>

<div class="bottom">
	<div class="email">
		<img src="../images/email.png"/><span id="email" style="font-family: Microsoft YaHei;">&nbsp;站长邮箱:<a href="mailto:matlacdom@163.com">matlacdom@163.com</a></span>
	</div>
	<div class="count">
		<span id="visitCount">${visitCount}</span>
	</div>
</div>
</body>
</html>