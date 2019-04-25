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
	<script src="${basePath}/layer/layer.js"></script>
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
			//var codeType = $("#codeType").val();
            var codeName = $("#codeName").val();
            var codeValue = $("#codeValue").val();

			if(!codeName){
				$("#msg").show();
				$("#msg").removeClass("alert-success");
				$("#msg").addClass("alert-danger");
				$("#msg").html("请输入编码名称");
				return false;
			}

            if(!codeValue || codeValue.length < 9){
                $("#msg").show();
                $("#msg").removeClass("alert-success");
                $("#msg").addClass("alert-danger");
                $("#msg").html("请输入长度为9的编码");
                return false;
			}


            //var data = {"codeType":codeType , "codeName" : codeName , "codeValue" : codeValue };
			var data = {"codeName" : codeName , "codeValue" : codeValue };
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
            var keyWord = $("#keyWord").val();
			var args = {"keyWord":keyWord};
			var url = "../codeManage/codeList.do";
            $.getJSON(url,args,function(data){
                if(data.code == 0){
                    var codeList = data.resultData;
                    if(codeList.length == 0){
						layer.open({
							type: 1,
							skin: 'layui-layer-rim', //加上边框
							area: ['350px', '200px'], //宽高
							content: '<div style="width: 100%;text-align: center;margin-top: 10px;">系统中没有所查询的编码</div>'
						});
					}
                    //for(var i= 0 ; i< codeList.length ; i++){
						layer.open({
							type: 1,
							skin: 'layui-layer-rim', //加上边框
							area: ['350px', '200px'], //宽高
							content: '<div style="width: 100%;text-align: center;margin-top: 10px;">'
									+ "编码名称&nbsp;:&nbsp;" + codeList[0].codeName +  '</div><div style="width: 100%;text-align: center;margin-top: 10px;">'
									+ "编码序号&nbsp;:&nbsp;" + codeList[0].codeValue +'</div>'
						});
					//}
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
				<label class="col-sm-4 control-label">编码名称</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" value="" id="codeName" placeholder="请输入编码名称"/>
				</div>
			</div>

			<div class="form-group" >
				<label class="col-sm-4 control-label">编码序号</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="codeValue" value="" placeholder="请自编9位数字或者随机产生" maxlength="9"/>
				</div>
				<div class="col-sm-1" style="padding-left:0px;">
					<button type="button" class="btn btn-info" id="createCodeBtn">随机</button>
				</div>
				<div class="col-sm-1" style="padding-left:0px;">
					<button type="button" class="btn btn-success" id="submitBtn">创建</button>
				</div>
			</div>
			<div class="form-group" >
				<label class="col-sm-4 control-label">编码查询</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="keyWord" value="" placeholder="请输入编码名称或者编码序号"/>
				</div>
				<div class="col-sm-1" style="padding-left:0px;">
					<button type="button" class="btn btn-success" id="searchBtn">查询</button>
				</div>
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