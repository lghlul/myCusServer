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
<style type="text/css">
	.form-group{
		text-align: center;
	}
</style>
<script type="text/javascript">
	$(function(){
        $("#createCodeBtn").click(function(){
            var url = "../codeManage/getCode.do"
            $.getJSON(url,function(data){
                $("#codeValue").val(data.resultData);
            })
            return false;
        });


        $("#submitBtn").click(function(){
			var codeType = $("#codeType").val();
            var codeName = $("#codeName").val();
            var codeValue = $("#codeValue").val();
            if(!codeValue || codeValue.length < 9){
                $("#msg").show();
                $("#msg").removeClass("alert-success");
                $("#msg").addClass("alert-danger");
                $("#msg").html("请输入长度为9的编码");
                return false;
			}


            var data = {"codeType":codeType , "codeName" : codeName , "codeValue" : codeValue };
            var url = "addCode.do";

            $.post(url,data,function(data){
                if(data.code == 0){
					$("#msg").show();
					$("#msg").removeClass("alert-danger");
                    $("#msg").addClass("alert-success");
                    $("#msg").html("创建成功");
                }else if(data.code == 996){
                    $("#msg").show();
                    $("#msg").removeClass("alert-success");
                    $("#msg").addClass("alert-danger");
                    $("#msg").html("编码重复");
				}else{
                    $("#msg").show();
                    $("#msg").removeClass("alert-success");
                    $("#msg").addClass("alert-danger");
                    $("#msg").html("创建失败");
				}
            },"JSON");
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
			编码管理
		</div>
		<div class="login">
			<c:if test="${user == null}"> <a href="../user/toLogin.do">登录</a></c:if>
			<c:if test="${user != null}"> 你好,<a href="../user/toResetPwd.do"><span class="accountStyle">${user.userAccount}</span></a> <a href="../user/logout.do">退出</a></c:if>
		</div>
	</div>


	<div style="width: 800px;margin: 100px auto;">
		<form class="form-horizontal">
			<div class="alert msg" style="width: 60%;margin-left: 20%;display: none!important;" id="msg">
			</div>
			<div class="form-group" >
				<label class="col-sm-2 control-label">编号类别</label>
				<div class="col-sm-9">
					<select class="form-control" id="codeType">
						<option value="1">项目编号</option>
						<option value="2">文件编号</option>
						<option value="3">用户编号</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">编号名称</label>
				<div class="col-sm-9">
					<select class="form-control" id="codeName">
						<option value="1">公差查询</option>
						<option value="2">气缸压力</option>
						<option value="3">压力转换</option>
						<option value="4">工程材料</option>
						<option value="5">编码管理</option>
						<option value="6">注册登录</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">编号生成</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" maxlength="9" name="codeValue" id="codeValue" oninput="value=value.replace(/[^\d]/g,'')"/>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-info" id="createCodeBtn">随机</button>
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