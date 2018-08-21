<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		height: 60px;
		line-height: 60px;
	}

</style>

<script type="text/javascript">

	var getValue = function(){
		var url = "getValue.do";
		var bore_size = $("#bore_size").val();
		var pressure_size = $("#pressure_size").val();
		if(bore_size == "" || pressure_size == ""){
			$("#type_1").html("0.00");
			$("#type_2").html("0.00");
		}else{
			var args = {"bore_size":bore_size,"pressure_size":pressure_size};
			$.getJSON(url,args,function(data){
				var obj = data.resultData;
				for(var i = 0 ; i < obj.length ; i++ ){
					$("#type_" + obj[i].direction_type).html(obj[i].pressure_value);
				}
				var visitCount = data.visitNum;
				$("#visitCount").html(visitCount);
			})
		}
		
	}
</script>
</head>
<body>
	<div class="top">
		<div class="title">
			<a href="../index.jsp">公差查询</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			气缸压力
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="../pressureChange/toIndex.do">压力转换</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="projectMaterial/toIndex.do">工程材料</a>
		</div>
		<div class="login">
			<c:if test="${user == null}"> <a href="../user/toLogin.do">登录</a></c:if>
			<c:if test="${user != null}"> 你好,<span class="accountStyle">${user.userAccount}</span> <a href="../user/logout.do">退出</a></c:if>
		</div>
	</div>


	<div class="gccx">
		<table  style="margin:auto auto;">
			<tr>
				<td>
					缸径：
					<select id="bore_size" onchange="getValue()">
						<option value="">--请选择--</option>
						<c:forEach items="${boreSize}" var="bore">
							<option value="${bore.bore_size }">${bore.bore_size}</option>
						</c:forEach>
						
					</select>
					<span>(mm)</span>
				</td>
				 
				<td rowspan="2" width="50px;" align="center">
					<!--<div class="searchBtn" onclick="getValue()">
						查&nbsp;&nbsp;询
					</div>-->
				</td>
				 
				<td>
					伸出压力：<span id="type_1">0.00</span><span>(10N)</span>
				</td>
			</tr>
			<tr>
				<td >
					气压：
					<select id="pressure_size" onchange="getValue()">
						<option value="">--请选择--</option>
						<c:forEach items="${pressureSize}" var="pressure">
							<option value="${pressure.pressure_size}">${pressure.pressure_size}</option>
						</c:forEach>
					</select>
					<span>(0.1Mpa)</span>
				</td>
				
				<td>
					缩回压力：<span id="type_2">0.00</span><span>(10N)</span>
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

