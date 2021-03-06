//ranking.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    userInfo: {},
    rankingList: [],
    myRank:0,
    pageNo:1,
    pageSize:10,
    pageCount:1,
    scrollTop: 0,
    scrollHeight: 0
  },
  onLoad: function () {
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          scrollHeight: res.windowHeight
        });
      }
    });
    if (that.data.pageNo <= that.data.pageCount) {
      that.getRanking('');
    }
  },
  getRanking: function (callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.rankListUrl,
      data: {
        wxSession: SinopecSession,
        pageNo: that.data.pageNo,
        pageSize: that.data.pageSize
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          let list = that.data.rankingList;
          list = list.concat(result.data.resultData.list);
          that.setData({
            pageCount: result.data.resultData.pageCount,
            rankingList: list,
            myRank: result.data.resultData.myRank
          })
          // console.log(result.data.resultData)
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getRanking(''));
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
    if (that.data.pageNo < that.data.pageCount) {
      that.setData({
        pageNo: that.data.pageNo + 1
      })
      that.getRanking('')
    }
  },
  onPullDownRefresh: function () {
    //wx.showNavigationBarLoading() //在标题栏中显示加载
    //模拟加载
    var that = this;
    that.setData({
      pageNo: 1,
      pageCount: 1,
      rankingList: [],
      myRank: 0
    })
    if (that.data.pageNo <= that.data.pageCount) {
      that.getRanking(wx.stopPullDownRefresh());
    }
  }
})
