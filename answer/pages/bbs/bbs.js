//ranking.js
const app = getApp()
const url = require('../../config.js');
const util = require('../../utils/util.js');
Page({
  data: {
    userInfo: {},
    bbsList: [],
    pageNo: 1,
    pageSize: 10,
    pageCount: 1,
    scrollTop: 0,
    scrollHeight: 0
  },
  onLoad: function () {
    this.setData({
      bbsList: []
    })
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
  onShow: function () {
    var that = this;
    wx.getStorage({
      key: 'newBBS',
      success: function (res) {
        if (res.data=="true"){
          wx.removeStorage({
            key: 'newBBS',
            success: function(res) {},
          })
          that.setData({
            bbsList: [],
            pageNo:1
          })
          wx.getSystemInfo({
            success: function (res) {
              that.setData({
                scrollHeight: res.windowHeight
              });
            }
          });
            that.getRanking('');
        }
      },
    })
  },
  getRanking: function (callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.bbsList,
      data: {
        wxSession: SinopecSession,
        offset: that.data.pageNo,
        limit: that.data.pageSize,
        sortField:"createTime",
        sortDir:"desc"
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {

          let list = that.data.bbsList;
          list = list.concat(result.data.resultData.list);
          for (var i in result.data.resultData.list) {
            let bbs = result.data.resultData.list[i];
            bbs.time = util.formatTime(new Date(bbs.createTime));
            
          }
          that.setData({
            pageCount: result.data.resultData.totalPage,
            bbsList: list
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
  toBbs: function () {

    wx.navigateTo({
      url: '../bbsNew/bbsNew',
    })
  },
  toInfo: function (e) {
    var id = e.currentTarget.dataset.id;
    for (var i in this.data.bbsList) {
      let bbs = this.data.bbsList[i];
      if (bbs.bbsID == id) {
        wx.setStorage({
          key: 'bbsInfo',
          data: bbs,

          success:function(){
            wx.navigateTo({
              url: '../bbsInfo/bbsInfo?id=' + id,
            })
          }
        })
       

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
