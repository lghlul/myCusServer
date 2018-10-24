//logs.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    userInfo: {},
    exchangeList:[],
    scrollTop: 0,
    scrollHeight: 0,
    page: 1,
    pageCount: 1,
    totalCount: 0
  },
  onLoad: function () {
    var that = this;
    that.setData({
      userInfo: app.globalData.userInfo
    });
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          scrollHeight: res.windowHeight
        });
      }
    });
    if (that.data.page <= that.data.pageCount) {
      that.getProductList('');
    }
  },
  getProductList: function (callback) {
    var that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.getOrderListUrl,
      data: {
        wxSession: SinopecSession,
        pageNo: that.data.page,
        pageSize: 10
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          let list = that.data.exchangeList;
          list = list.concat(result.data.resultData.list);
          that.setData({
            exchangeList: list,
            pageCount: result.data.resultData.pageCount,
            totalCount: result.data.resultData.totalCount
          })
          // console.log(list)
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getProductList(''));
        }
        // console.log('getuser', that.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  bindDownLoad: function () {
    var that = this;
    if (that.data.page < that.data.pageCount) {
      that.setData({
        page: that.data.page + 1
      })
      that.getProductList('')
    }
  },
  onPullDownRefresh: function () {
    //wx.showNavigationBarLoading() //在标题栏中显示加载
    //模拟加载
    var that = this;
    that.setData({
      page: 1,
      exchangeList: []
    })
    if (that.data.page <= that.data.pageCount) {
      that.getProductList(wx.stopPullDownRefresh());
    }
  }
})
