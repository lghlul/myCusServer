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
		$("select").change(function(){
			var pm_id = $(this).find("option:selected").attr("pm_id");
			var url = "getValue.do";
			var args = {"pm_id" : pm_id};
			$.getJSON(url,args,function(data){
				var obj = data.resultData;
				
				$("#china").val(obj.china);
				$("#germany").val(obj.germany);
				$("#spain").val(obj.spain);
				$("#usa").val(obj.usa);
				$("#mexico").val(obj.mexico);
				$("#india").val(obj.india);
				$("#turkey").val(obj.turkey);
				$("#carburize").text(obj.carburize);
				$("#quench").text(obj.quench);
				$("#nitriding").text(obj.nitriding);
				if(obj.baidubaike == "----"){
					$("#baidubaike").attr("href","javascript:");
				}else{
					$("#baidubaike").attr("href",obj.baidubaike);
				}
				
				var visitCount = data.visitNum;
				$("#visitCount").html(visitCount);;
			})
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
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工程材料
		</div>
		<div class="login">
			<c:if test="${user == null}"> <a href="../user/toLogin.do">登录</a></c:if>
			<c:if test="${user != null}"> 你好,<span class="accountStyle">${user.userAccount}</span> <a href="../user/logout.do">退出</a></c:if>
		</div>
	</div>


	<div style="width: 800px;margin: 100px auto;">
		<table  style="margin:auto auto;" cellpadding="5px">
			<tr>
				<td ><img src="../images/China.png" width="60px" height="50px;"/></td>
				<td>中国</td>
				<td>
				<select name="china" id="china">
					<c:forEach items="${list_0}" var="list">
						<option value="${list.china}" pm_id="${list.pm_id}">${list.china}</option>
					</c:forEach>
				</select>
				</td>
				<td width="20px;"></td>
				<td  align="left" colspan="2"><span style="font-weight: bold;font-size: 20px;">热处理</span></td>
				
			</tr>
			<tr>
				<td><img src="../images/Usa.png" width="60px" height="50px;"/></td>
				<td>美国</td>
				<td>
					<select name="usa" id="usa">
						<c:forEach items="${list_2}" var="list">
							<option value="${list.usa}" pm_id="${list.pm_id}">${list.usa}</option>
						</c:forEach>
					</select>
				</td>
				<td width="20px;"></td>
				<td align="left">淬火</td>
				<td><span id="quench">${pm.quench}</span></td>
			</tr>
			<tr>
				<td><img src="../images/Germany.png" width="60px" height="50px;"/></td>
				<td>德国</td>
				<td>
					<select name="germany"  id="germany">
						<c:forEach items="${list_1}" var="list">
							<option value="${list.germany}" pm_id="${list.pm_id}">${list.germany}</option>
						</c:forEach>
					</select>
				</td>
				<td width="20px;"></td>
				<td align="left">渗碳</td>
				<td><span id="carburize">${pm.carburize}</span></td>
			</tr>
			<tr>
				<td><img src="../images/Mexico.png" width="60px" height="50px;"/></td>
				<td>墨西哥</td>
				<td>
					<select name="mexico" id="mexico">
						<c:forEach items="${list_4}" var="list">
							<option value="${list.mexico}" pm_id="${list.pm_id}">${list.mexico}</option>
						</c:forEach>
					</select>
				</td>
				<td width="20px;"></td>
				<td align="left">渗氮</td>
				<td><span id="nitriding">${pm.nitriding}</span></td>
			</tr>
			<tr>
				<td><img src="../images/Spain.png" width="60px" height="50px;"/></td>
				<td>西班牙</td>
				<td>
					<select name="spain" id="spain">
						<c:forEach items="${list_5}" var="list">
							<option value="${list.spain}" pm_id="${list.pm_id}">${list.spain}</option>
						</c:forEach>
					</select>
				</td>
				
			</tr>
			<tr>
				<td><img src="../images/India.png" width="60px" height="50px;"/></td>
				<td>印度</td>
				<td>
					<select name="india" id="india">
						<c:forEach items="${list_6}" var="list">
							<option value="${list.india}" pm_id="${list.pm_id}">${list.india}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><img src="../images/Turkey.png" width="60px" height="50px;"/></td>
				<td>土耳其</td>
				<td>
					<select name="turkey" id="turkey">
						<c:forEach items="${list_3}" var="list">
							<option value="${list.turkey}" pm_id="${list.pm_id}">${list.turkey}</option>
						</c:forEach>
					</select>
				</td>
				<td width="20px;"></td>
				<td align="left" colspan="2">
				<table>
					<tr>
						<td>
							<span style="font-weight: bold;font-size: 20px;">
								百度百科
							</span>
						</td>
						<td>
							<a href="${pm.baidubaike}" target="_blank" style="color:black;text-decoration: underline;" id="baidubaike">
								<img src="../images/baidubaike.JPG" width="60px" />
							</a>
						</td>
					</tr>
				</table>
				
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