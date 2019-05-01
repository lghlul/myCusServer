// pages/bbsRelpy/bbsRelpy.js
const app = getApp()
const url = require('../../config.js');
const util = require('../../utils/util.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:{},
    bbsId:0,
    content:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      userInfo: app.globalData.userInfo,
      bbsId: options.id ? options.id : ''
    })
  },
  inputeidt: function (e) {
    var that = this;
    that.setData({
      content: e.detail.value
    })
  } ,
  toReply:function(){

    var that = this;
    var content = that.data.content+"";

    if (content.trim()==""){
      wx.showToast({
        icon:"none",
        title: '请输入回复内容',

      })
      return;
    }
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.bbsReply,
      method:"POST",
      data: {
        wxSession: SinopecSession,
        bbsID: that.data.bbsId,
        content:that.data.content
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          wx.setStorage({
            key: 'newREPLY',
            data: 'true'
          })
          wx.showToast({
            title: '回复成功',
            duration: 2000,
            success: function () {
              setTimeout(function () {
                //要延时执行的代码
                wx.navigateBack({
                  
                })
              }, 2000) //延迟时间
            }
          })

        } 
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})