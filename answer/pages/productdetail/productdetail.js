//logs.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    goodsID: 0,
    productDetail:{}
  },
  onLoad: function (options) {
    this.setData({
      goodsID: options.id
    });
    this.getProductDetail('');
  },
  getProductDetail: function (callback){
    var that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.goodsDetailUrl,
      data: {
        wxSession: SinopecSession,
        goodsID: that.data.goodsID
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          that.setData({
            productDetail: result.data.resultData
          })
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getProductDetail(''));
        }
        // console.log('getuser', that.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  exchange:function(){
    let that =this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.showModal({
      title: '确定使用' + that.data.productDetail.goodsScore+'积分兑换此商品？',
      content: '点击确定后生成兑换码',
      cancelText: '返回',
      confirmText: '确定',
      success: function (res) {
        if (res.confirm) {
          // console.log('用户点击确定')
          wx.request({
            url: url.exchangeUrl,
            data: {
              wxSession: SinopecSession,
              goodsID: that.data.goodsID
            },
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            method: "POST",
            success: function (result) {
              // console.log(result.data)
              if (result.data.resultCode == 0) {
                wx.navigateTo({
                  url: '../exchangesuc/exchangesuc?orderNo=' + result.data.resultData.orderNo,
                  success: function (res) {
                    // console.log(res)// success
                  },
                  fail: function () {
                    // console.log('跳转到news页面失败') // fail
                  },
                  complete: function () {
                    // console.log('跳转到news页面完成') // complete
                  }
                })
              } else if (result.data.resultCode == 9996){
                wx.showModal({
                  title: '抱歉，当前积分不够',
                  content: '请继续答题赢得积分',
                  showCancel:false,
                  confirmText: '确定'
                  })
              }else if (result.data.resultCode == 9989) {
                wx.showModal({
                  title: '抱歉，兑奖通道已经关闭',
                  content: '请等待下次开启',
                  showCancel:false,
                  confirmText: '确定'
                })
              } else if (result.data.resultCode == 10000) {
                wx.clearStorage();
                app.getUserInfo(that.exchange());
              }
              // console.log('getuser', that.globalData.userInfo)
            },
            fail: function ({ errMsg }) {
              // console.log('request fail', errMsg)
            }
          });
        } else if (res.cancel) {
          // console.log('用户点击取消')
        }
      }
    })
  },
  onPullDownRefresh: function () {
    //wx.showNavigationBarLoading() //在标题栏中显示加载
    //模拟加载
    this.getProductDetail(wx.stopPullDownRefresh());
  }
})
