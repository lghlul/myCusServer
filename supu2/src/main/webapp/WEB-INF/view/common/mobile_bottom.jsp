<%@ page contentType="text/html; charset=UTF-8"%>
<div class="mint-tabbar bottom-tab-bar boder-1px-top tabbar is-fixed intTabBar">
					<a class="mint-tab-item <c:if test="${bottom==1 }"> is-selected </c:if>" href="<%=request.getContextPath()%>/outside/aboutClass/listPage">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">约课</div>
					</a>
					<a class="mint-tab-item boder-1px-left <c:if test="${bottom==2 }"> is-selected </c:if>" href="<%=request.getContextPath()%>/outside/buyCard/listPage">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">购买</div>
					</a>
					<a class="mint-tab-item boder-1px-left <c:if test="${bottom==3 }"> is-selected </c:if>" href="<%=request.getContextPath()%>/outside/myCourse/nofinishPage">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">我的课程</div>
					</a>
					<a class="mint-tab-item boder-1px-left <c:if test="${bottom==4 }"> is-selected </c:if>" href="<%=request.getContextPath()%>/outside/personal/personalinfo">
						<div class="mint-tab-item-icon"></div>
						<div class="mint-tab-item-label">个人中心</div>
					</a>
</div>
<%-- <script src="<%=request.getContextPath()%>/assets/js/jquery/jquery-2.0.3.min.js">
$(function(){
	$('.mint-tab-item').click(function(){
		alert("1");

	});
})

</script> --%>