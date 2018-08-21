<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>AIVIACAD</title>
<link rel="stylesheet" type="text/css" href="../css/gccx.css">
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<style type="text/css">
	.searchBtn{
		background-color: blue;
		height: 35px;
		line-height: 35px;
		border-radius:5px;
		color: white; 
		cursor: pointer;
		width: 80%;
		font-size: 15px;
	}
	select{
		text-align: center;
	}

	.gccx span{
		font-family:  Arial Narrow;
	}
	td{
		text-align: center;

	}
	input{
		height: 20px;
		margin:  auto auto;
		margin-left: 10px;
		width: 100px;
	}
	.seaBtn{
		margin: 0px 10px;
		float: right;
		background-color: rgb(138, 131, 151);
		text-align: center;
		height: 26px;
		line-height: 26px;
		width: 50px;
		border-radius: 5px;
		cursor: pointer;
	}

	
</style>
<script type="text/javascript">

	$(function(){
		
		$(".seaBtn").click(function(){
			var url = "pressureChange.do";
			var type = this.getAttribute("type");
			var value = $("input[type='text']").eq(type-1).val();
			if(!value){
				alert("请输入");
				return false;
			}
			if(!checkNum(value)){
				alert("请输入数字");
				return false;
			}
			var args = {type : type,value : value};
			$.getJSON(url,args,function(data){
				var obj = data.resultData;
				$("input[type='text']").eq(0).val(obj.value_1);
				$("input[type='text']").eq(1).val(obj.value_2);
				$("input[type='text']").eq(2).val(obj.value_3);
				$("input[type='text']").eq(3).val(obj.value_4);
				$("input[type='text']").eq(4).val(obj.value_5);
				$("input[type='text']").eq(5).val(obj.value_6);
				$("input[type='text']").eq(6).val(obj.value_7);
				$("input[type='text']").eq(7).val(obj.value_8);
				$("input[type='text']").eq(8).val(obj.value_9);
				$("input[type='text']").eq(9).val(obj.value_10);
				$("input[type='text']").eq(10).val(obj.value_11);
				$("input[type='text']").eq(11).val(obj.value_12);
				$("input[type='text']").eq(12).val(obj.value_13);
				$("input[type='text']").eq(13).val(obj.value_14);
				var visitCount = data.visitNum;
				$("#visitCount").html(visitCount);
			})
		});
	})
	
var checkNum = function(number){
	var reg=/^[-\+]?\d+(\.\d+)?$/;
	if(reg.test(number)){
		return true;
	}else{
		return false;
	}
}
</script>

</head>
<body>
	<div class="top">
		<div class="title">
			<a href="../index.jsp">公差查询</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="../pressure/toIndex.do">气缸压力</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			压力转换
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="../projectMaterial/toIndex.do">工程材料</a>
		</div>
		<div class="login">
			<c:if test="${user == null}"> <a href="../user/toLogin.do">登录</a></c:if>
			<c:if test="${user != null}"> 你好,<span class="accountStyle">${user.userAccount}</span> <a href="../user/logout.do">退出</a></c:if>
		</div>
	</div>


	<div style="width: 800px;margin: 100px auto;">
		<table  style="margin:auto auto;" cellpadding="5px">
			<tr>
				<td>
					巴<br/><span>(bar)</span>
				</td>
				 <td>
					<input type="text" ><div class="seaBtn" type = "1">查询</div>
				</td>
				<td>
					兆帕<br/><span>(mPa)</span>
				</td>
			 	<td>
					<input type="text" ><div class="seaBtn" type = "2" >查询</div>
				</td>
			</tr>
			<tr>
				<td >
					千帕<br/><span>(kPa)</span>
				</td>
				<td>
					<input type="text" ><div class="seaBtn" type = "3">查询</div>
				</td>
				<td>
					百帕<br/><span>(hPa)</span>
				</td>
				 <td>
					<input type="text" ><div class="seaBtn" type = "4">查询</div>
				</td>
			</tr>
			<tr>
				<td >
					毫巴<br/><span>(mbar)</span>
				</td>
				<td>
					<input type="text" ><div class="seaBtn" type = "5">查询</div>
				</td>
				<td>
					帕斯卡<br/><span>(Pa)</span>
				</td>
				 <td>
					<input type="text" ><div class="seaBtn" type = "6">查询</div>
				</td>
			</tr>
			<tr>
				<td >
					标准大气压<br/><span>(atm)</span>
				</td>
				<td>
					<input type="text" ><div class="seaBtn" type = "7">查询</div>
				</td>
				<td>
					毫米汞柱<br/><span>(mm Hg = Tor)</span>
				</td>
				 <td>
					<input type="text" ><div class="seaBtn" type = "8">查询</div>
				</td>
			</tr>
			<tr>
				<td >
					磅力/英尺&sup2; <br/><span>lbf/ft&sup2; </span>
				</td>
				<td>
					<input type="text" ><div class="seaBtn" type = "9">查询</div>
				</td>
				<td>
					磅力/英寸&sup2; <br/><span>(lbf/in&sup2;  = PSI)</span>
				</td>
				 <td>
					<input type="text"><div class="seaBtn" type = "10">查询</div>
				</td>
			</tr>
			<tr>
				<td >
					英吋汞柱<br/><span>(in Hg)</span>
				</td>
				<td>
					<input type="text" ><div class="seaBtn" type = "11">查询</div>
				</td>
				<td>
					公斤力/厘米&sup2; <br/><span>(kgf/cm&sup2; )</span>
				</td>
				 <td>
					<input type="text" ><div class="seaBtn" type = "12">查询</div>
				</td>
			</tr>
			<tr>
				<td >
					公斤力/米&sup2; <br/><span>(kgf/m&sup2;)</span>
				</td>
				<td>
					<input type="text"><div class="seaBtn" type = "13">查询</div>
				</td>
				<td>
					毫米水柱<br/><span>(mmH<sub>2</sub>O)</span>
				</td>
				 <td>
					<input type="text" ><div class="seaBtn" type = "14">查询</div>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="bottom">
		<div class="email">
			<img src="../images/email.png"/><span id="email" style="font-family: Microsoft YaHei;">&nbsp;站长邮箱:<a href="mailto:aiviacad@163.com">aiviacad@163.com</a></span>
		</div>
		<div class="count">
			<span id="visitCount">${visitCount}</span>
		</div>
	</div>
</body>
</html>