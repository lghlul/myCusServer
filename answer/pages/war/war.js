//ranking.js
const app = getApp()
const url = require('../../config.js');
const util = require('../../utils/util.js');
Page({
  data: {
    userInfo: {},
    warList: [],
    pageNo: 1,
    pageSize: 10,
    pageCount: 1,
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
  // onUnload: function () {
  //   console.log
  //   that.getRanking('');
  // },
  getRanking: function (callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.warList,
      data: {
        wxSession: SinopecSession,
        offset: that.data.pageNo,
        limit: that.data.pageSize
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          let statusArr = ["", "未开始", "已开始",'已结束'];
  
          let list = that.data.warList;
          list = list.concat(result.data.resultData.list);
          for (var i in result.data.resultData.list) {
            let war = result.data.resultData.list[i];
            war.time = util.formatTime(new Date(war.createTime));
            war.statusTxt = statusArr[war.activityStatus];
            if(war.isJoin == 1){
              war.statusTxt = '已参加';
            }
          }
          that.setData({
            pageCount: result.data.resultData.totalPage,
            warList: list
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
  toInfo:function(e){
    var id = e.currentTarget.dataset.id;
    console.log(id);
    for (var i in this.data.warList) {
      let war = this.data.warList[i];
      if(war.activityID==id){
        if(war.isJoin == 1){
          wx.navigateTo({
            url: '../warHistory/warHistory?id='+id,
          })
        }else
        if(war.activityStatus==2){
          wx.navigateTo({
            url: '../warInfo/warinfo?warId='+id,
          })
        }else
        if(war.activityStatus==3){
          wx.showToast({
            title: '活动已结束',
          })

        }else if (war.activityStatus ==1){
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
