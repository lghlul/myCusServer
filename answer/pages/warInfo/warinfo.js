//practice.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    userInfo: {},
    type: '',
    warId: 0,
    mistakeId: 0,
    questionData: {},
    warinfo: {},
    answerList: [],
    isDisabled: false,
    typeId: 0,
    trainId: 0
  },
  onLoad: function (options) {
    var that = this;
    that.setData({
      userInfo: app.globalData.userInfo,
      type: options.type ? options.type : '',
      mistakeId: options.id ? options.id : '',
      warId: options.warId ? options.warId : ''
    })
    that.getQuestion('')

  },
  onUnload: function () {

  },
  onUnload: function (e) {
  },
  chooseAnswer: function (e) {
    //console.log(e)
    let that = this;

    let index = e.currentTarget.dataset.index;
    let id = e.target.id;
    let answers = that.data.answerList;

    //将答案添加到answerList
    let choose = "questionData.question.answerList[" + index + "].choose";
    if (that.data.questionData.question.answerList[index].choose == 'choose') {
      that.setData({
        [choose]: ''
      })
      let anIndex = answers.findIndex(ele => ele == id)
      if (anIndex > -1) {
        answers.splice(anIndex, 1);
      }
    } else {
      let old = that.data.questionData.question.choose;
      if (old > -1 && that.data.questionData.question.quesType != 2 && old != index) {
        let oldchoose = "questionData.question.answerList[" + old + "].choose";
        let oldid = that.data.questionData.question.answerList[old].ansID;
        that.setData({
          [oldchoose]: ''
        })
        let anIndex = answers.findIndex(ele => ele == oldid)
        if (anIndex > -1) {
          answers.splice(anIndex, 1);
        }
      }
      let questionData = that.data.questionData;
      questionData.question.choose = index;
      that.setData({
        [choose]: 'choose',
        questionData: questionData
      })
      answers.push(id);
    }
    let chooseInfo = that.data.warinfo;
    let chooseanswer = [];
    for (var i in that.data.questionData.question.answerList) {
      if (that.data.questionData.question.answerList[i].choose == 'choose') {
        chooseanswer.push(that.data.questionData.question.answerList[i].ansID)
      }
    }
    chooseInfo[that.data.questionData.question.quesID] = chooseanswer;

    let answerNum = 0;
    for (var i in chooseInfo) {
      if (chooseInfo[i].length > 0) {
        answerNum++;
      }
    }

    let questionData = that.data.questionData;
    questionData.answerNum = answerNum;
    that.setData({
      answerList: answers,
      warinfo: chooseInfo,
      questionData: questionData
    })

  },


  putAnswer: function () {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    that.setData({
      isDisabled: true
    })
    that.data.answerList.forEach(function (chooseItem, chooseIndex) {
      let answerIndex = that.data.questionData.question.answerList.findIndex(ele => ele.ansID == chooseItem);
      if (answerIndex > -1) {
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
        if (that.data.questionData.question.answerList[rightAnswerIndex].choose != 'correct') {
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
          setTimeout(function () {
            that.getQuestion('')
          }, 1000)
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


  getQuestion: function (callback) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');

    wx.request({
      url: url.getWarQueation,
      method: "GET",
      data: {
        wxSession: SinopecSession,
        activityID: that.data.warId
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      success: function (result) {
        // console.log(result.data)
        if (result.data.resultCode == 0) {
          let questonData = new Object();
          questonData.answerNum = 0;
          questonData.currentNum = 0;
          questonData.allNum = result.data.resultData.length;
          questonData.questions = result.data.resultData;
          questonData.question = questonData.questions[0];
          questonData.answerNum = 0;
          that.setData({
            isDisabled: false,
            questionData: questonData
          })
          //console.log(that.data.questionData)
          if (typeof callback === "function") {
            callback();
          }


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
  submitWar: function () {
    let that = this;
    if (that.data.countDownNum > 0 && that.data.questionData.answerNum < that.data.questionData.allNum) {
      wx.showModal({
        title: '提示',
        content: '您尚有问题为作答，是否提交',
        cancelText: '继续作答',
        confirmText: '提交',
        success: function (res) {
          if (res.confirm) {
            that.submitWar2();
          }
        }
      })
    } else {
      that.submitWar2();
    }
  },
  submitWar2: function () {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');

    let strList = [];
    for (var i in that.data.warinfo) {
      console.log(i);
      strList.push({ "quesID": i, "answerID": that.data.warinfo[i].join(",") })
    }
    wx.request({
      url: url.submitWarQueation,
      method: "POST",
      data: {
        wxSession: SinopecSession,
        activityID: that.data.warId,
        strList: JSON.stringify(strList)
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      success: function (result) {
        
        if (result.data.resultCode == 0) {
         wx.showToast({
           title: '提交成功',
           success: function () {
             wx.navigateBack();
          }
         })
          
        } else if (result.data.resultCode == 9991) {
          wx.showModal({
            title: '提示',
            content: '活动已经结束',
            showCancel: false,
            success(res) {
              if (res.confirm) {
                wx.navigateBack({})
              }
            }
          })
        } else if (result.data.resultCode == 9992) {
          wx.showModal({
            title: '提示',
            content: '活动尚未开始',
            showCancel: false,
            success(res) {
              if (res.confirm) {
                wx.navigateBack({})
              }
            }
          })
        }
        // console.log('getuser', that.globalData.userInfo)
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });

  },
  getMistake: function (id, callback) {
    var that = this;
    let questionData = that.data.questionData;
    if (questionData.currentNum == 0 && id < 0) {
      wx.showToast({
        title: '已经是第一题',
        icon: 'none',
        duration: 1000
      })
    } else if (id > 0 && questionData.currentNum == (questionData.allNum - 1)) {
      wx.showToast({
        title: '已经是最后一题',
        icon: 'none',
        duration: 1000
      })

    } else {
      questionData.currentNum = (parseInt(questionData.currentNum) + parseInt(id)) + "";
      questionData.question = questionData.questions[questionData.currentNum];
      that.setData({
        questionData: questionData
      })
    }

  },
  nextMistake(e) {
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
