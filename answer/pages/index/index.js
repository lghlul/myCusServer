//index.js
//获取应用实例
const app = getApp();
const url = require('../../config.js');
const util = require('../../utils/util.js');
Page({
  data: {
    userInfo: {},
    hasUserInfo: true,
    showPage:false,
    hasJobNum:true,
    keyHeight:0,
    isSign:true,
    showMenu:{
      showWar:true,
      showBBs:true
    },
    signText:'签到',
    loading:true
  },
  //事件处理函数
  
  onLoad: function () {
    let that = this;
    //加载模块
    wx.request({
      url: url.menuConfig,
      data: {
        wxSession: "ceshiWxSession"
      },
      success: function (result) {
        // console.log(result)
        if (result.data.resultCode == 0) {
          wx.setStorage({
            key: 'showMenu',
            data: '',
          })
          if (result.data.resultData["谁与争锋"] && result.data.resultData["谁与争锋"]==1){
            that.setData({
              "showMenu.showWar":true
            })
        }
          if (result.data.resultData["你问我答"] && result.data.resultData["你问我答"] == 1) {
            that.setData({
              "showMenu.showBBs": true
            })
          }
          wx.setStorage({
            key: 'showMenu',
            data: that.data.showMenu,
          })
        }
      }
    })
    //转发
    wx.showShareMenu({
      withShareTicket: true,
      success: function (res) {
        // 分享成功
        //console.log('shareMenu share success')
        //console.log('分享', res)
      },
      fail: function (res) {
        // 分享失败
        // console.log(res)
      }
    })
    //存储用户信息
    //console.log('load', this.data)
  },
  getUserInfo: function (e) {
    // console.log(e.detail.userInfo);
    let that = this;
    app.getServiceUserInfo('');
  },
  //转发
  onShareAppMessage: function () {
    return {
      title: '答题比赛',
      path: '/pages/index/index',
      success: function (res) {
        //console.log(res.shareTickets[0])
        // console.log
        // wx.getShareInfo({
        //   shareTicket: res.shareTickets[0],
        //   success: function (res) { console.log(res) },
        //   fail: function (res) { console.log(res) },
        //   complete: function (res) { console.log(res) }
        // })
      },
      fail: function (res) {
        // 分享失败
        // console.log(res)
      }
    }
  },
  onShow: function () {
    let that = this;
    if (app.globalData.userInfo) {
      that.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: app.globalData.isAuth,
        showPage: app.globalData.isAuth
      })
      if (that.data.hasUserInfo) {
        that.checkJobNum();
        that.checkSign();
        that.getUserScroe();
      }
    }else{
      app.userInfoReadyCallback = res => {
        that.setData({
          userInfo: res,
          hasUserInfo: app.globalData.isAuth,
          showPage: app.globalData.isAuth
        })
        // console.log(that.data.hasUserInfo)
        if (that.data.hasUserInfo) {
          that.checkJobNum();
          that.checkSign();
          that.getUserScroe();
        }
      }
    }
    
    //console.log(that.data.userInfo)
    
  },
  onHide:function(){
  
  },
  //判断授权状态
  // checkSettingStatu: function () {
  //   var that = this;
  //   // 判断是否是第一次授权，非第一次授权且授权失败则进行提醒
  //   wx.getSetting({
  //     success: function success(res) {
  //       console.log(res.authSetting);
  //       var authSetting = res.authSetting;
  //       if (util.isEmptyObject(authSetting)) {
  //         authSetting = { 'scope.userInfo': false };
  //         console.log('首次授权', authSetting);
  //       } else {
  //         console.log('不是第一次授权', authSetting);
  //         // 没有授权的提醒
  //         if (authSetting['scope.userInfo'] === false) {
  //           app.showModal();
  //         } else {
  //           app.getServiceUserInfo(function(){
  //             that.setData({
  //               userInfo: app.globalData.userInfo,
  //               hasUserInfo: true
  //             })
  //             console.log('checkSettingStatu', that.data)
  //           }());
  //         }
  //       }
  //     }
  //   });
  // },
  checkJobNum:function(){
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.checkJobNumUrl,
      data: {
        wxSession: SinopecSession
      },
      success: function (result) {
        // console.log(result)
        if (result.data.resultCode == 0) {
          that.setData({
            hasJobNum: true
          })
        } else if (result.data.resultCode == 10001){
          that.setData({
            hasJobNum: false
          })
        } else if (result.data.resultCode == 10000){
          wx.clearStorage();
          app.getUserInfo(that.checkJobNum());
        }
        // console.log(that.data.hasJobNum)
      }
      })
  },
  onFocus: function (e) {
    //console.log(e)
    this.setData({
      keyHeight: e.detail.height
    })
  },
  onInput:function(e){
    this.setData({
      jobNum: e.detail.value
    })},
  onBlur:function(e){
    this.setData({
      keyHeight:0,
      jobNum: e.detail.value
    })
    // console.log(this.data.jobNum)
  },
  bindJobNum:function(){
    let SinopecSession = wx.getStorageSync('SinopecSession');
    let that = this;
    wx.request({
      url: url.bindJobNumUrl,
      data: {
        wxSession: SinopecSession,
        jobNum: that.data.jobNum
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "POST",
      success: function (result) {
        // console.log(result)
        if (result.data.resultCode == 0) {
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            duration: 2000
          })
          that.setData({
            hasJobNum: true
          })
        } else if (result.data.resultCode == 10002){
          wx.showToast({
            title: '无效工号或者已被绑定，请检查后重试',
            icon: 'none',
            duration: 2000
          })
        } else if (result.data.resultCode == 10003) {
          wx.showToast({
            title: '每日最多尝试三次，明日再试',
            icon: 'none',
            duration: 2000
          })
        } else if (result.data.resultCode == 10004) {
          wx.showToast({
            title: '不能重复绑定',
            icon: 'none',
            duration: 2000
          })
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.bindJobNum());
        }
      }
    })
  },
  //跳转个人中心
  bindViewTap:function(e){
    var that = this;
    // console.log("跳转个人中心")
    wx.navigateTo({
      url: '../my/my',
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
  },
  //检查是否签到
  checkSign:function(){
    let SinopecSession = wx.getStorageSync('SinopecSession');
    let that = this;
    wx.request({
      url: url.isSignUrl,
      data: {
        wxSession: SinopecSession
      },
      success: function (result) {
        // console.log(result)
        if (result.data.resultCode == 0) {
          that.setData({
            isSign: true,
            signText:'签到'
          })
        } else if (result.data.resultCode == 9995) {
          that.setData({
            isSign: false,
            signText:'已签到'
          })
        } else if (result.data.resultCode == 10001) {
          wx.showToast({
            title: '请先绑定工号',
            icon: 'none',
            duration: 2000
          })
          setTimeout(function () {
            that.setData({
              hasJobNum: false,
              isSign: true,
              signText:'签到'
            })
          }, 2000)
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.sign());
        }
      }
    })
  },
  //签到
  sign:function(){
    let SinopecSession = wx.getStorageSync('SinopecSession');
    let that = this;
    if(that.data.isSign){
      wx.request({
        url: url.signUrl,
        data: {
          wxSession: SinopecSession
        },
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        method: "POST",
        success: function (result) {
          // console.log(result)
          if (result.data.resultCode == 0) {
            wx.showToast({
              title: '签到成功',
              icon: 'success',
              duration: 2000
            })
            that.setData({
              isSign: false,
              signText: '已签到'
            })
            that.getUserScroe();
          } else if (result.data.resultCode == 9999) {
            wx.showToast({
              title: '已经签到过',
              icon: 'none',
              duration: 2000
            })
            that.setData({
              isSign: false,
              signText: '已签到'
            })
          } else if (result.data.resultCode == 10001) {
            wx.showToast({
              title: '请先绑定工号',
              icon: 'none',
              duration: 2000
            })
            setTimeout(function () {
              that.setData({
                hasJobNum: false
              })
            }, 2000)
          } else if (result.data.resultCode == 10000) {
            wx.clearStorage();
            app.getUserInfo(that.sign());
          }
        }
      })
    }
  },

  getUserScroe:function(){
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession') || '';
    wx.request({
      url: url.getUserInfoUrl,
      data: {
        wxSession: SinopecSession
      },
      success: function (result) {
        // console.log('getuser', result)
        if (result.data.resultCode == 0) {
          that.setData({
            userInfo: result.data.resultData
          })
          app.globalData.userInfo = result.data.resultData;
        } else if (result.data.resultCode == 10000) {
          that.getUserScroe();
        }
      }
    })
  },
  //下拉刷新
  onPullDownRefresh: function () {
    var that = this;
    app.getServiceUserInfo(function () {
      that.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
      wx.stopPullDownRefresh()
    }())
  }
})
