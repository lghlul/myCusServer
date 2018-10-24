//app.js
const url = require('./config.js');
App({
  onLaunch: function () {
    // 展示本地存储能力
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession') || '';
    if (SinopecSession == '') {
      that.getUserInfo('');
    } else {
      //that.globalData.session = SinopecSession;
      that.getServiceUserInfo('');
    }
  },
  onShow: function () {
  },
  globalData: {
    userInfo: null,
    isAuth:false
  },
  getUserInfo(callback) {
    let that = this;
    //调用应用实例的方法获取全局数据
    wx.login({
      success: res => {
        // console.log(res)
        if (res.code) {
          wx.request({
            url: url.loginUrl,
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            method: "POST",
            data: {
              code: res.code
            },
            success: function (result) {
              // console.log(result)
              if (result.data.resultCode == 0) {
                wx.setStorageSync('SinopecSession', result.data.resultData.wxSession);
                //that.globalData.session = result.data.resultData.wxSession;
                if (typeof callback === "function") {
                  callback();
                }else{
                  that.getServiceUserInfo('');
                }
              }
            },
            fail: function ({ errMsg }) {
              // console.log('request fail', errMsg)
            }
          });
        } else {
          // console.log('登录失败！' + res.errMsg)
        }
      }
    })

  },
  // showModal() {
  //   wx.showModal({
  //     title: '请授权',
  //     content: '授权后才能使用小程序',
  //     showCancel: false,
  //     success: function (res) {
  //       if (res.confirm) {
  //         console.log('用户点击确定')
  //         wx.openSetting({
  //           success: function success(res) {
  //             console.log('openSetting success', res.authSetting);
  //           }
  //         });
  //       }
  //     }
  //   })
  // },
  getServiceUserInfo(callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
      wx.request({
        url: url.getUserInfoUrl,
        data: {
          wxSession: SinopecSession
        },
        success: function (result) {
          console.log('app', result)
          if (result.data.resultCode == 0) {
            wx.getSetting({
              success: function (res) {
                // console.log(res.authSetting['scope.userInfo'])
                if (res.authSetting['scope.userInfo']) {
                  that.globalData.userInfo = result.data.resultData;
                  that.globalData.isAuth = true;
                  wx.getUserInfo({
                    success: resuser => {
                      // console.log('getServiceUserInfo', resuser.userInfo);

                      if (that.globalData.userInfo.userName != resuser.userInfo.nickName || that.globalData.userInfo.userImg != resuser.userInfo.avatarUrl) {
                        that.updateServiceUserInfo(resuser.userInfo.avatarUrl, resuser.userInfo.nickName)
                      }
                    },
                    fail: error => {
                      // console.log(error)
                      // 调用微信弹窗接口
                      //that.showModal()
                    }
                  })
                  if (that.userInfoReadyCallback) {
                    that.userInfoReadyCallback(result.data.resultData)
                  }

                } else {
                  that.globalData.isAuth = false;
                  if (that.userInfoReadyCallback) {
                    that.userInfoReadyCallback(result.data.resultData)
                  }
                }
                if (typeof callback === "function") {
                  callback();
                }

              }
            })
          } else if (result.data.resultCode == 10000) {
            // console.log('getuser', result.data.resultCode)
            that.getUserInfo('');
          }
        },
        fail: function ({ errMsg }) {
          // console.log('request fail', errMsg)
        }
      });
    
  },
  updateServiceUserInfo(avatarUrl, nickName){
    var that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
      wx.request({
        url: url.updateUserInfoUrl,
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        method: "POST",
        data: {
          wxSession: SinopecSession,
          userImg: avatarUrl,
          userName: nickName
        },
        success: function (result) {
          // console.log(result)
          if (result.data.resultCode == 0) {
            that.globalData.userInfo.userName = nickName;
            that.globalData.userInfo.userImg = avatarUrl;
          } else if (result.data.resultCode == 10000) {
            that.getUserInfo();
          }
        //  console.log('getuser', that.globalData.userInfo)
        },
        fail: function ({ errMsg }) {
          // console.log('request fail', errMsg)
        }
      });
  }
})