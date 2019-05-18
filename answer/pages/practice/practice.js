//practice.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    userInfo: {},
    type:'',
    typeId:0,
    mistakeId:0,
    questionData:{},
    answerList:[],
    isDisabled:false,
    over:false
  },
  onLoad: function (options) {
    var that = this;
    that.setData({
      userInfo: app.globalData.userInfo,
      type: options.type ? options.type:'',
      typeId: options.typeId ? options.typeId:'',
      mistakeId: options.id ? options.id:'',
    });
    if (that.data.type == 'mistakes'){
      that.getMistake(that.data.mistakeId,'')
    }else{
      that.getQuestion('')
    }
    var title = (that.data.type == 'mistakes') ?'我的错题':'练习模式'
      wx.setNavigationBarTitle({
        title: title,
        success: function () {
          // console.log('setNavigationBarTitle success')
        },
        fail: function (err) {
          // console.log('setNavigationBarTitle fail, err is', err)
        }
      });
    // wx.showModal({
    //   title: '本题库答题完毕',
    //   content: '您可在错题集中回看错题',
    //   cancelText: '返回首页',
    //   confirmText: '看错题',
    //   success: function (res) {
    //     if (res.confirm) {
    //       console.log('用户点击确定')
    //     } else if (res.cancel) {
    //       console.log('用户点击取消')
    //       wx.navigateTo({
    //         url: '../index/index',
    //         success: function (res) {
    //           console.log(res)// success
    //         },
    //         fail: function () {
    //           console.log('跳转到news页面失败') // fail
    //         },
    //         complete: function () {
    //           console.log('跳转到news页面完成') // complete
    //         }
    //       })
    //     }
    //   }
    //})
  },
  onUnload: function () {
    if (this.data.type != 'mistakes'){
      wx.showModal({
        title: '警告',
        content: '退出后将保存答题进度',
        showCancel: false,
        confirmText: '确定',
        success: function (res) {
          if (res.confirm) {
            // console.log('用户点击确定')
          } else if (res.cancel) {
            // console.log('用户点击取消')
          }
        }
      })
    }
  },
  chooseAnswer:function(e){
    //console.log(e)
    let that = this;
    
    let index = e.currentTarget.dataset.index;
    let id = e.target.id;
    let answers = that.data.answerList;
    
    //将答案添加到answerList
    let choose = "questionData.question.answerList[" + index +"].choose";
    if (that.data.questionData.question.answerList[index].choose == 'choose'){
      that.setData({
        [choose]: ''
      })
      let anIndex = answers.findIndex( ele => ele == id)
      if (anIndex>-1){
        answers.splice(anIndex,1);
      }
    }else{
      that.setData({
        [choose]: 'choose'
      })
      answers.push(id);
    }
    that.setData({
      answerList: answers
    })
    // console.log(that.data.answerList)
    if (that.data.questionData.question.quesType != 2){
      that.putAnswer();
    }

    // if (that.data.questionData.question.rightAnswerID == id){
    //   that.setData({
    //     [choose]: 'correct'
    //   })
    // }else{
    //   let answerIndex = that.data.questionData.question.answerList.findIndex(ele => ele.ansID == that.data.questionData.question.rightAnswerID);
    //   if (answerIndex>-1){
    //     let answerChoose = "questionData.question.answerList[" + answerIndex + "].choose";
    //     that.setData({
    //       [choose]: 'wrong',
    //       [answerChoose]: 'correct'
    //     })
    //   }
    // }
    // let chooseAnswer = that.data.questionData.question.answerList[index].choose;
    // wx.request({
    //   url: url.answerUrl,
    //   data: {
    //     wxSession: SinopecSession,
    //     questionID: that.data.questionData.question.quesID,
    //     answerID:id
    //   },
    //   header: {
    //     "Content-Type": "application/x-www-form-urlencoded"
    //   },
    //   method: "POST",
    //   success: function (result) {
    //     console.log(result.data)
    //     if (result.data.resultCode == 0) {
    //       if (chooseAnswer =='correct'){
    //         wx.showToast({
    //           title: '回答正确',
    //           icon: 'none',
    //           duration: 1000
    //         })
    //       }else{
    //         wx.showToast({
    //           title: '回答错误',
    //           icon: 'none',
    //           duration: 1000
    //         })
    //       }
    //       setTimeout(function () {
    //         that.getQuestion('')
    //       }, 1000)
    //     } else if (result.data.resultCode == 10000) {
    //       wx.clearStorage();
    //       app.getUserInfo(that.putAnswer(e));
    //     }
    //     // console.log('getuser', app.globalData.userInfo)
    //   },
    //   fail: function ({ errMsg }) {
    //     console.log('request fail', errMsg)
    //   }
    // });
  },


  putAnswer:function(){
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    that.setData({
      isDisabled: true
    })
    that.data.answerList.forEach(function (chooseItem,chooseIndex){
      let answerIndex = that.data.questionData.question.answerList.findIndex(ele => ele.ansID == chooseItem);
      if (answerIndex>-1){
        let choose = "questionData.question.answerList[" + answerIndex + "].choose";
        let chooseaRightIndex = that.data.questionData.question.rightAnswerID.split(',').findIndex(ele => ele == chooseItem);
        if (chooseaRightIndex > -1) {
          that.setData({
            [choose]: 'correct'
          })
        } else {
          that.setData({
            [choose]: 'wrong',
          })
        }
      }
      
    })
    that.data.questionData.question.rightAnswerID.split(',').forEach(function (answerItem, answerIndex) {
      let rightAnswerIndex = that.data.questionData.question.answerList.findIndex(ele => ele.ansID == answerItem);
      if (rightAnswerIndex > -1) {
        let answerChoose = "questionData.question.answerList[" + rightAnswerIndex + "].choose";
        if (that.data.questionData.question.answerList[rightAnswerIndex].choose !='correct'){
          that.setData({
            [answerChoose]: 'correct'
          })
        }
      }
    })

    wx.request({
      url: url.answerUrl,
      data: {
        wxSession: SinopecSession,
        questionID: that.data.questionData.question.quesID,
        answerID: that.data.answerList.join(',')
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "POST",
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          if (that.data.answerList.sort().join(',') == that.data.questionData.question.rightAnswerID.split(',').sort().join(',')) {
            wx.showToast({
              title: '回答正确',
              icon: 'none',
              duration: 1000
            })
          } else {
            wx.showToast({
              title: '回答错误',
              icon: 'none',
              duration: 1000
            })
          }
          that.setData({
            over: true
          });
          // setTimeout(function () {
            // that.getQuestion('')
          // }, 1000)
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.putAnswer(e));
        }
        // console.log('getuser', app.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  nextQuestion: function () {
    let that = this;
    that.setData({
      over: false
    });
    that.getQuestion('')
  },

  getQuestion: function (callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    
    wx.request({
      url: url.nextQuestionUrl,
      data: {
        wxSession: SinopecSession,
        typeID: that.data.typeId
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          result.data.resultData.question.answerList.forEach(function (item, index) {
            item.choose ='';
          })
          that.setData({
            isDisabled: false,
            questionData: result.data.resultData,
            answerList: []
          })
          //console.log(that.data.questionData)
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 10005) {
          wx.showModal({
            title: '提示',
            content: '本题库答题结束',
            cancelText: '我的错题',
            confirmText: '选择题库',
            success: function (res) {
              if (res.confirm) {
                wx.navigateBack({
                  delta: 1
                })
              } else if (res.cancel) {
                wx.navigateTo({
                  url: '../mymistakes/mymistakes',
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
              }
            }
          })

        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getQuestion(''));
        }
        // console.log('getuser', that.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  getMistake: function (id,callback) {
    var that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.wrongDetailUrl,
      data: {
        wxSession: SinopecSession,
        id: id
      },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          result.data.resultData.question.answerList.forEach(function (item, index) {
            let wrongaIndex = result.data.resultData.wrongAnswerID.split(',').findIndex(ele => ele == item.ansID);
            if (wrongaIndex>-1){
              item.choose = 'wrong';
            }
            let correctIndex = result.data.resultData.question.rightAnswerID.split(',').findIndex(ele => ele == item.ansID);
            if (correctIndex>-1){
              item.choose = 'correct';
            }
          })
          that.setData({
            questionData: result.data.resultData
          })
          if (result.data.resultData.nextID==0){
            wx.showToast({
              title: '已经是最后一题',
              icon: 'none',
              duration: 1000
            })
          }
          //console.log(that.data.questionData)
          if (typeof callback === "function") {
            callback();
          }
        } else if (result.data.resultCode == 9997){
          wx.showToast({
            title: '已经是最后一题',
            icon: 'none',
            duration: 1000
          })
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getMistake(that.data.mistakeId, ''));
        }
        // console.log('getuser', that.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  nextMistake(e){
    // console.log(e)
    this.getMistake(e.currentTarget.dataset.nextid, '')
  },
  onPullDownRefresh: function () {
    //wx.showNavigationBarLoading() //在标题栏中显示加载
    //模拟加载
    setTimeout(function () {
      // complete
      //wx.hideNavigationBarLoading() //完成停止加载
      wx.stopPullDownRefresh() //停止下拉刷新
    }, 1500);
  }
})
