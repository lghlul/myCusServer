//logs.js
const app = getApp()
Page({
  data: {
    userInfo: {}
  },
  onLoad: function () {
    this.setData({
      userInfo: app.globalData.userInfo
    });
  },
  onPullDownRefresh: function () {
    //wx.showNavigationBarLoading() //在标题栏中显示加载
    //模拟加载
    setTimeout(function () {
      // complete
      //wx.hideNavigationBarLoading() //完成停止加载
      wx.stopPullDownRefresh() //停止下拉刷新
    }, 1500);
  }
})
