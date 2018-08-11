var index = 0;
var is_often = 0;   //是否是常用
var z_nm = "-";     //轴名
var k_nm = "-";     //孔名
var value_1 = "---";
var value_2 = "---";
var deviation_type = 0;   //孔轴类型 1 是孔  2 是轴
var size_value = 100;   //尺寸
$(function(){
	$(".search .botton").eq(1).css("color","rgb(191,191,191)");
	$("#size_value").val(size_value);
	$("#size_2").html(size_value);
	setValue_1();
	setValue_2();
	/*
	index = Math.floor(Math.random()*5) + 1;
	var bg_pic = "images/bg_00" + index + ".png";
	 
	$("#size_value").val(size_value);
	$("#size_2").html(size_value);
	setValue_1();
	setValue_2();
	
	$(".right").click(function(){
		if(index === 5){
			index = 1;
		}else{
			index ++;
		}
		var bg_pic = "images/bg_00" + index + ".png";
		$("#bg").attr("src",bg_pic);
	});
	
	$(".left").click(function(){
		if(index === 1){
			index = 5;
		}else{
			index --;
		}
		var bg_pic = "images/bg_00" + index + ".png";
		$("#bg").attr("src",bg_pic);
	});*/
	var url = "getDeviation.do";
	var args = {"is_often":is_often}; 
	getData(url,args);
	
	//选择孔
	$("#k_nm").change(function(){
		deviation_type = 1;
		k_nm = $(this).find("option:selected").text();
		var size_type = $(this).val();
		if(size_type != "0"){
			getValue(deviation_type,k_nm,size_type);
		}else{
			k_nm = "-";     
			value_1 = "---";
			value_2 = "---";
			setValue_1();
		}
	});
	
	//选择轴
	$("#z_nm").change(function(){
		deviation_type = 2;
		z_nm = $(this).find("option:selected").text();
		var size_type = $(this).val();
		if(size_type != "0"){
			getValue(deviation_type,z_nm,size_type);
		}else{
			z_nm = "-";     
			value_1 = "---";
			value_2 = "---";
			setValue_2();
		}
	});
	
	
	//尺寸改变
	$('#size_value').bind('input propertychange', function() {
		size_value = $(this).val();
		$("#size_2").html(size_value);
		k_nm = $("#k_nm").find("option:selected").text();
		var size_type = $("#k_nm").val();
		if(size_type != "0"){
			getValue(1,k_nm,size_type);
		}else{
			k_nm = "-";     //孔名
			value_1 = "---";
			value_2 = "---";
			setValue_1();
		}
		z_nm = $("#z_nm").find("option:selected").text();
		size_type = $("#z_nm").val();
		if(size_type != "0"){
			getValue(2,z_nm,size_type);
		}else{
			z_nm = "-";     //轴名
			value_1 = "---";
			value_2 = "---";
			setValue_2();
		}
	}); 
	
	
	$(".search .botton").click(function(){
		z_nm = "-";     //轴名
	    k_nm = "-";
		value_1 = "---";
		value_2 = "---";
		setValue_1();
		setValue_2();
		var index = $(this).index();
		$(this).css("color","white");
		if(index == 1){
			//$(".search .botton").eq(0).css("background-color","#727d8d");
			$(".search .botton").eq(0).css("color","rgb(191,191,191)");
		}else{
			$(".search .botton").eq(1).css("color","rgb(191,191,191)");
		}
		is_often = index;
		var url = "getDeviation.do";
		var args = {"is_often":is_often}; 
		getData(url,args);
	});

	
})


var getData = function(url,args){
	$.getJSON(url,args,function(data){
		var obj = data.resultData;
		$("#k_nm").html("<option value='0'>请选择</option>");
		$("#z_nm").html("<option value='0'>请选择</option>");
		for(var i = 0 ; i < obj.length ; i++ ){
			var deviation_type = obj[i].deviation_type;
			if(deviation_type === "1"){
				$("#k_nm").append("<option value='" + obj[i].size_type + "'>" + obj[i].deviation_name + "</option>");
			}else if(deviation_type === "2"){
				$("#z_nm").append("<option value='" + obj[i].size_type + "'>" + obj[i].deviation_name + "</option>");
			}
		}
		var visitCount = data.visitNum;
		$("#visitCount").html(visitCount);
	})
}

var getValue = function(dt,nm,size_type){
	var url = "getDeviationValue.do";
	var args = {"deviation_name":nm,"deviation_type":dt,"size_value":size_value,"size_type":size_type};
	$.getJSON(url,args,function(data){
		var obj = data.resultData;
		var visitCount = data.visitNum;
		if(obj.value_one === "null" || obj.value_two === "null"){
			value_1 = "---";
			value_2 = "---";
		}else{
			value_1 = obj.value_one;
			value_2 = obj.value_two;
		}
		
		if(dt === 1){
			setValue_1();
		}else{
			setValue_2();
		}
		$("#visitCount").html(visitCount);
	})
}

var setValue_1 = function(){
	
	$(".name").eq(0).html(k_nm);
	$(".value_1").eq(0).html(value_1);
	$(".value_2").eq(0).html(value_2);
}

var setValue_2 = function(){
	
	$(".name").eq(1).html(z_nm);
	$(".value_1").eq(1).html(value_1);
	$(".value_2").eq(1).html(value_2);
}



