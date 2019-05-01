//ranking.js
const app = getApp()
const url = require('../../config.js');
const util = require('../../utils/util.js');
Page({
  data: {
    userInfo: {},
    bbsId: 0,
    bbsInfo: 0,
    replyList: [],
    pageNo: 1,
    pageSize: 10,
    pageCount: 1,
    scrollTop: 0,
    scrollHeight: 0
  },
  onLoad: function (options) {
    var that = this;
    that.setData({
      userInfo: app.globalData.userInfo,
      bbsId: options.id ? options.id : ''
    });
    wx.getStorage({
      key: 'bbsInfo',
      success: function (res) {
        that.setData({
          replyList: [],
          bbsInfo: res.data
        })
        that.getRanking('');
        
      },
    })

  },
  onShow: function () {
    
    let that = this;
    wx.getSystemInfo({
      success: function (res) {
        var query = wx.createSelectorQuery();
        //选择id
        query.select('.exam-content').boundingClientRect(function (rect) {
          // console.log(rect.width)
          var h = res.windowHeight - rect.height;
          that.setData({
            scrollHeight: h
          });
        }).exec();

      }
    });
    wx.getStorage({
      key: 'newREPLY',
      success: function (res) {
        if (res.data == "true") {
          wx.removeStorage({
            key: 'newREPLY',
            success: function (res) { },
          })
          that.setData({
            replyList: [],
            pageNo: 1
          })
          that.getRanking('');
        }
      },
    })
    
  },
  toReply: function () {

    var that = this;
    wx.navigateTo({
      url: '../bbsRelpy/bbsRelpy?id=' + that.data.bbsId,
    })
  },
  getRanking: function (callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.bbsReplyList,
      data: {
        wxSession: SinopecSession,
        offset: that.data.pageNo,
        limit: that.data.pageSize,
        sortField: "createTime",
        sortDir: "desc",
        bbsID: that.data.bbsId
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {

          let list = that.data.replyList;
          list = list.concat(result.data.resultData.list);
          for (var i in result.data.resultData.list) {
            let reply = result.data.resultData.list[i];
            reply.time = util.formatTime(new Date(reply.createTime));

          }
          that.setData({
            pageCount: result.data.resultData.totalPage,
            replyList: list
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
  toInfo: function (e) {
    var id = e.currentTarget.dataset.id;
    console.log(id);
    for (var i in this.data.replyList) {
      let war = this.data.replyList[i];
      if (war.activityID == id) {
        if (war.isJoin == 1) {
          wx.navigateTo({
            url: '../warHistory/warHistory?id=' + id,
          })
        } else
          if (war.activityStatus == 2) {
            wx.navigateTo({
              url: '../warInfo/warinfo?warId=' + id,
            })
          } else
            if (war.activityStatus == 3) {
              wx.showToast({
                title: '活动已结束',
              })

            } else if (war.activityStatus == 1) {
              wx.showToast({
                title: '活动未开始',
              })
            }

      }

    }
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
