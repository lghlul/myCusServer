//classify.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    classifyList: [],
    nowIndex:0,
    type:''
  },
  onLoad: function (options) {
    var that = this;
    that.setData({
      type: options.type
    });
    // console.log(that.data.type)
    that.getType('')
  },
  onShow:function(){
    let that = this;
    that.getType('')
  },
  getType:function(callback){
    var that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.getTypeListUrl,
      data: {
        wxSession: SinopecSession,
        type: that.data.type
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          result.data.resultData.forEach(function(item,index){
            if(index==0){
              item.isShowChild=true;
            }else{
              item.isShowChild = false;
            }
          })
          that.setData({
            classifyList: result.data.resultData
          })
          // console.log(that.data.classifyList)
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getType(''));
        }
        // console.log('getuser', that.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  classifyTap:function(e){
    let showchild = 'classifyList[' + e.currentTarget.id +'].isShowChild';
    this.setData({
      [showchild]: !this.data.classifyList[e.currentTarget.id].isShowChild
    })
  },
  onPullDownRefresh: function () {
    //wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getType(wx.stopPullDownRefresh());
  }
})
