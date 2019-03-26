<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>MATLACDOM</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/gccx.css">
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



        $("#searchBtn").click(function(){
            var codeType = $("#searchCodeType").val();
            var codeName = $("#searchCodeName").val();
			var args = {"codeType":codeType , "codeName":codeName};
			var url = "../codeManage/codeList.do";
            $.getJSON(url,args,function(data){
                if(data.code == 0){
                    $("#codeList").html("");
                    var codeList = data.resultData;
                    for(var i= 0 ; i< codeList.length ; i++){
                        $("#codeList").append("<div>" + codeList[i].codeValue + "</div>");
					}
                }
            });
            return false;
		});

    })

    var changeForm = function(index){
        $("#codeList").html("");
        $("form").eq(index).show();
        $("form:gt(" + index + ")").hide();
        $("form:lt(" + index + ")").hide();
    }
</script>

</head>
<body>
	<div class="top">
		<div class="title">
			<a href="${basePath}/index.jsp">公差查询</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${basePath}/pressure/toIndex.do">气缸压力</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${basePath}/pressureChange/toIndex.do">压力转换</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${basePath}/projectMaterial/toIndex.do">工程材料</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			编码管理
		</div>
		<div class="login">
			<c:if test="${user == null}"> <a href="${basePath}/user/toLogin.do">登录</a></c:if>
			<c:if test="${user != null}"> 你好,<a href="${basePath}/user/toResetPwd.do"><span class="accountStyle">${user.userAccount}</span></a> <a href="${basePath}/user/logout.do">退出</a></c:if>
		</div>
	</div>


	<div style="width: 800px;margin: 100px auto;">
		<form class="form-horizontal">
			<div class="alert msg" style="width: 60%;margin-left: 20%;display: none!important;" id="msg">
			</div>
			<div class="form-group" >
				<label class="col-sm-4 control-label">编码类别</label>
				<div class="col-sm-5">
					<select class="form-control" id="codeType">
						<option value="1">项目编码</option>
						<option value="2">文件编码</option>
						<option value="3">用户编码</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">编码名称</label>
				<div class="col-sm-5">
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
				<label class="col-sm-4 control-label">编码生成</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" maxlength="9" name="codeValue" id="codeValue" oninput="value=value.replace(/[^\d]/g,'')"/>
				</div>
				<div class="col-sm-1">
					<button type="button" class="btn btn-info" id="createCodeBtn">随机</button>
				</div>
			</div>
			<div class="form-group">
				<a href="javascript:void(0)" style="color: #337ab7!important;font-size: 15px;" onclick="changeForm(1)">编码查询</a>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-success " style="width: 20%;" id="submitBtn">确定</button>
			</div>
		</form>


		<form class="form-horizontal" style="display: none;">
			<div class="form-group" >
				<label class="col-sm-4 control-label">编码类别</label>
				<div class="col-sm-5">
					<select class="form-control" id="searchCodeType">
						<option value="1">项目编码</option>
						<option value="2">文件编码</option>
						<option value="3">用户编码</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">编码名称</label>
				<div class="col-sm-5">
					<select class="form-control" id="searchCodeName">
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
				<a href="javascript:void(0)" style="color: #337ab7!important;font-size: 15px;" onclick="changeForm(0)">编码创建</a>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-success " style="width: 20%;" id="searchBtn">查询</button>
			</div>
			<div class="form-group" style="text-align: center;" id="codeList">
				<div>1111</div>
				<div>1111</div>
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