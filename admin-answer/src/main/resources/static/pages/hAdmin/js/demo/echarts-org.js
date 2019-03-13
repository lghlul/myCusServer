function loadOrgChart(orgChart){
    var data = {};
    var stime = $("#start").val();
    var etime = $("#end").val();
    if(stime&&etime){
        data.startTime = $.myTime.DateToUnix(stime);
        data.endTime = $.myTime.DateToUnix(etime);
    }
    $.get("/answer/orgCount",data,function(res){
        console.log(res);
        var orgArr = new Array();
        var allArr = new Array();
        var rigArr = new Array();
        var rallArr = new Array();
        var regArr = new Array();
        var index = 0;
        $.each(res.data,function(index,obj){
            orgArr.push(obj.orgName);
            allArr.push(obj.countNum-obj.rightNum);
            rigArr.push(obj.rightNum);
            rallArr.push(obj.countNum);
            regArr.push(obj.rightPercent);
        })
        var option = {
            title: {
                text: '答题情况统计'
                
            },
            tooltip: {
                trigger: "axis",  
            },
            legend: {
                data:['答题总数','正确题数']
            },
            grid:{
                x:50,
                y:45,
                x2:5,
                y2:150
            },
            xAxis: {
                data: orgArr,
                axisLabel: {  
                    interval:0,  
                    formatter:function(value)  
                    {  
                        return value.split("").join("\n");  
                    }  

                 }  
            },
            yAxis: {
            },
            tooltip: {
                formatter: function(params, ticket, callback) {
                    console.log(params);
                    var info = orgArr[params.dataIndex]+'</br>';
                        info += '答题总数：' + rallArr[params.dataIndex]+'</br>';
                        info += '正确题数：' + rigArr[params.dataIndex]+'</br>';
                        info += '正确率：'+regArr[params.dataIndex];
                    return info;
                }
            },
            series: [{
                name: '正确题数',
                type: 'bar',
                stack:'A',
                data: rigArr
            },{
                name: '答题总数',
                type: 'bar',
                stack:'A',
                data: allArr,
                itemStyle: {
                    normal: {
                        label: {
                            show: true, //开启显示
                            position: 'top',
                            formatter:function(params){
                                return rallArr[index++];
                            }
                        }
                    }
                }
            }]
        };
        
        orgChart.setOption(option);
    },"json")
}
$(function () {
    var orgChart = echarts.init(document.getElementById("echarts-line-chart"));
    loadOrgChart(orgChart);
    $("#search").click(function(){
        loadOrgChart(orgChart);

    })
    
    $(window).resize(orgChart.resize);

});
