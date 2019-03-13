<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>MATLACDOM</title>
<link rel="stylesheet" type="text/css" href="css/gccx.css">
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script src="js/index.js"></script>
</head>
<body>
	<div class="top">
		<div class="title">
			公差查询
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="pressure/toIndex.do">气缸压力</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="pressureChange/toIndex.do">压力转换</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="projectMaterial/toIndex.do">工程材料</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="codeManage/toIndex.do">编码管理</a>
		</div>
		<div class="login">
			<c:if test="${user == null}"> <a href="user/toLogin.do">登录</a></c:if>
			<c:if test="${user != null}"> 你好,<a href="../user/toResetPwd.do"><span class="accountStyle">${user.userAccount}</span></a> <a href="user/logout.do">退出</a></c:if>
		</div>
	</div>


	<div class="gccx">
		<div class="item">
			<span>尺寸</span>
			<div class="search">
				<div style="width:100%;height:120px;line-height:100px;text-align:center;">
					<input id="size_value" type="text" maxlength="5"  style="width:100px;text-align:center;"/> <font style="font-family: Arial Narrow;">mm</font>
				</div>
			</div>
		</div>
		<div class="item">
			<span>公差</span>
			<div class="search">
				<div class="select-name">
					<span>孔公差</span>
					<select id="k_nm">
					</select>

				</div>
				<div class="select-name">
					<span>轴公差</span>
					<select id="z_nm">
					</select>
				</div>
				<div style="text-align: center;width: 100%;">
					<div class="botton" >
						全部公差
					</div>
					<div class="botton" >
						常用公差
					</div>
				</div>
			</div>

		</div>
		<div class="item">
			<span>结果</span>
			<div class="result">
				<div class="length"></div>
				<div class="detail">
					<div style="height: 44px;margin-left:5px;">
						<div class="name">
						</div>
						<div class="value">
							<div class="value_1"></div>
							<div class="value_2"></div>
						</div>
					</div>
					<div class="line"></div>
					<div style="height: 44px;margin-left:5px;">
						<div class="name">
						</div>
						<div class="value">
							<div class="value_1"></div>
							<div class="value_2"></div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="bottom">
		<div class="email">
			<img src="images/email.png"/><span id="email">&nbsp;站长邮箱:<a href="mailto:matlacdom@163.com">matlacdom@163.com</a></span>
		</div>
		<div class="count">
			<span id="visitCount"></span>
		</div>
	</div>
</body>
</html>