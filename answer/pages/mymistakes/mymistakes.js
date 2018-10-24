//logs.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    userInfo: {},
    mistakesList: [],
    delBtnWidth: 132,
    beforeTouchIndex:-1,
    page: 1,
    pageCount: 1,
    totalCount: 0
  },
  onLoad: function () {
    this.setData({
      userInfo: app.globalData.userInfo
    });
    this.init('');
  },
  //手指刚放到屏幕触发
  touchS: function (e) {
    //判断是否只有一个触摸点
    if (e.touches.length == 1) {
      this.setData({
        //记录触摸起始位置的X坐标
        startX: e.touches[0].clientX
      });
    }
    this.setData({
      beforeTouchIndex: -1
    })
    if (this.data.beforeTouchIndex>-1){
      var item = "mistakesList[" + this.data.beforeTouchIndex + "].txtStyle";
      this.setData({
        [item]: ''
      });
    }
    // console.log('touchS', this.data.beforeTouchIndex);
  },
  //触摸时触发，手指在屏幕上每移动一次，触发一次
  touchM: function (e) {
    //console.log("touchM:", e);
    var that = this
    if (e.touches.length == 1) {
      //记录触摸点位置的X坐标
      var moveX = e.touches[0].clientX;
      //计算手指起始点的X坐标与当前触摸点的X坐标的差值
      var disX = that.data.startX - moveX;
      //delBtnWidth 为右侧按钮区域的宽度
      var delBtnWidth = that.data.delBtnWidth;
      var txtStyle = "";
      if (disX == 0 || disX < 0) {//如果移动距离小于等于0，文本层位置不变
        txtStyle = "transform:translate(0,0);";
      } else if (disX > 0) {//移动距离大于0，文本层left值等于手指移动距离
        txtStyle = "transform:translate(-" + disX + "rpx,0);";
        if (disX >= delBtnWidth) {
          //控制手指移动距离最大值为删除按钮的宽度
          txtStyle = "transform:translate(-" + delBtnWidth + "rpx,0);";
        }
      }
      //获取手指触摸的是哪一个item
      var index = e.currentTarget.dataset.index;
      //将拼接好的样式设置到当前item中
      var item = "mistakesList[" + index + "].txtStyle";
      //更新列表的状态
      that.setData({
        [item]: txtStyle
      });
      // console.log('touchM', that.data.mistakesList);
    }
  },

  touchE: function (e) {
    //console.log("touchE" + e);
    var that = this
    if (e.changedTouches.length == 1) {
      //手指移动结束后触摸点位置的X坐标
      var endX = e.changedTouches[0].clientX;
      //触摸开始与结束，手指移动的距离
      var disX = that.data.startX - endX;
      var delBtnWidth = that.data.delBtnWidth;
      //如果距离小于删除按钮的1/2，不显示删除按钮
      var txtStyle;
      //获取手指触摸的是哪一项
      var index = e.currentTarget.dataset.index;
      if (disX > delBtnWidth / 2){
        txtStyle = "transform:translate(-" + delBtnWidth + "rpx,0);";
        that.setData({
          beforeTouchIndex: index
        })
      }else{
        txtStyle = "transform:translate(0, 0);";
        that.setData({
          beforeTouchIndex: -1
        })
      }
      var item = "mistakesList[" + index + "].txtStyle";
      //更新列表的状态
      that.setData({
        [item]: txtStyle
      });
      // console.log('touchE', that.data.mistakesList);
    }
  },
  init: function (callback){
    var that = this
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.getWrongListUrl,
      data: {
        wxSession: SinopecSession,
        pageNo: that.data.page,
        pageSize: 10,
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          let mistakes = result.data.resultData.list;
          mistakes.forEach(function(item,index){
            item.txtStyle = 'transform:translate(0, 0);';
          })
          that.setData({
            mistakesList: mistakes,
            pageCount: result.data.resultData.pageCount,
            totalCount: result.data.resultData.totalCount,
          })
          // console.log()
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.init(''));
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
    if (that.data.page < that.data.pageCount) {
      that.setData({
        page: that.data.page + 1
      })
      that.init('')
    }
  },
  delMistakes:function(e){
    // console.log(e)
    var that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    var mistakesId = e.currentTarget.dataset.mistakesid;
    var index = e.currentTarget.dataset.index;
    wx.showModal({
      title: '提示',
      content: '是否删除该条错题',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: url.delWrongUrl,
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            method: "POST",
            data: {
              wxSession: SinopecSession,
              id: mistakesId
            },
            success: function (result) {
              // console.log(result.data)
              if (result.data.resultCode == 0) {
                let mistakes = that.data.mistakesList;
                mistakes.splice(index, 1);
                // console.log(mistakes)
                that.setData({
                  mistakesList: mistakes
                })
                wx.showToast({
                  title: '删除成功',
                  icon: 'success',
                  duration: 1000
                })
              } else if (result.data.resultCode == 10000) {
                wx.clearStorage();
                app.getUserInfo(that.delMistakes());
              }
              // console.log('getuser', that.globalData.userInfo)
            },
            fail: function ({ errMsg }) {
              // console.log('request fail', errMsg)
              wx.showToast({
                title: '删除失败,请稍后重试',
                icon: 'none',
                duration: 1000
              })
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
    this.init(wx.stopPullDownRefresh());
  }
})
