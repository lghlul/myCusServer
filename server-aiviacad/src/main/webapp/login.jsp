<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>AIVIACAD</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/gccx.css">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script src="${basePath}/js/login.js"></script>
</head>
<body>
	<div class="top">
		<div class="title">
			<a href="${basePath}/index.jsp">
			公差查询
			</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${basePath}/pressure/toIndex.do">气缸压力</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${basePath}/pressureChange/toIndex.do">压力转换</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${basePath}/projectMaterial/toIndex.do">工程材料</a>
		</div>
	</div>

	<div class="gccx">
		<form class="form-inline" id="loginForm" action="${basePath}/user/login.do">
			<div class="alert alert-danger msg" style="display: none!important;">
			</div>
			<div class="form-group  has-feedback">
				<input type="text" class="form-control input-lg" name="userAccount" value="" placeholder="请输入用户名">
			</div>
			<div class="form-group  has-feedback">
				<input type="password" class="form-control input-lg" name="userPwd" value="" placeholder="请输入密码">
			</div>
			<div class="form-group  has-feedback">
				<button type="submit" class="btn btn-success">登 录</button>
			</div>
			<div class="register">
				<a href="javascript:void(0)" onclick="changeForm(0)">我要注册</a>
			</div>
		</form>

		<form class="form-inline" id="registerForm" style="display: none;">
			<div class="alert alert-danger msg" style="display: none!important;">
			</div>

			<div class="form-group  has-feedback">
				<span>*</span><input type="text" class="form-control input-lg" name="userAccount" value="" onkeyup="value=value.replace(/[\u4E00-\u9FA5]/g,'')" placeholder="请输入用户名(不区分大小写)">
			</div>
			<div class="form-group  has-feedback">
				<span>*</span><input type="password" class="form-control input-lg" name="userPwd" value="" placeholder="请输入密码">
			</div>
			<div class="form-group  has-feedback">
				<span>*</span><input type="password" class="form-control input-lg" name="userConfirmPwd" value="" placeholder="请输入确认密码">
			</div>
			<div class="form-group  has-feedback">
				<span></span><input type="text" class="form-control input-lg" name="phone" value="" placeholder="请输入手机号码">
			</div>
			<div class="form-group  has-feedback">
				<span></span><input type="text" class="form-control input-lg" name="email" value="" placeholder="请输入邮箱">
			</div>
			<div class="form-group  has-feedback">
				<button type="submit" class="btn btn-success">注册</button>
			</div>
			<div class="register">
				<a href="javascript:void(0)" onclick="changeForm(1)">直接登录</a>
			</div>
		</form>
	</div>
	
	<div class="bottom">
		<div class="email">
			<img src="${basePath}/images/email.png"/><span id="email">&nbsp;站长邮箱:<a href="mailto:aiviacad@163.com">aiviacad@163.com</a></span>
		</div>
		<div class="count">
			<span id="visitCount"></span>
		</div>
	</div>
</body>
</html>