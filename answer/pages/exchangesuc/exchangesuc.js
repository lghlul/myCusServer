//logs.js
const app = getApp()
Page({
  data: {
    userInfo: {},
    orderNo:''
  },
  onLoad: function (options) {
    this.setData({
      orderNo: options.orderNo
    });
  }
})
