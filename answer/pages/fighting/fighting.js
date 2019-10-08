//logs.js
const app = getApp()
const url = require('../../config.js');
Page({
  data: {
    userInfo: {},
    acceptRoomID:'',
    createRoomID:'',
    rivalInfo: {
      userImg: '../../images/defaultIcon.png',
      userName: ''
    },
    step:1,
    fightingScore:10,
    countDownMinute: '05',
    countDownSecond: '00', 
    countDown:null,
    countDownStart: 5,
    answerTime:10,
    roomQuestionData:null,
    nowQuestionIndex:0,
    answerList: [],
    myScore:0,
    rivalScore:0,
    fightResult:'',
    hasUserInfo: true,
    showPage: true,
    hasJobNum: true,
    keyHeight: 0,
    isDisabled: false,
    resultIcon:'',
    resultTitle:'',
    acceptData:null,
    showShareBtn:false
  },
  onLoad: function (options) {
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.fScore,
      data: {
        wxSession: SinopecSession
      },
      method: "GET",
      success: function (result) {
        if (result.data.resultCode == 0) {
          that.setData({
            fightingScore: result.data.resultData.score
          })
        }
      }
    });
    that.setData({
      typeId: options.typeId ? options.typeId : '',
      acceptRoomID: options.roomID ? options.roomID : ''
    });
    if (that.data.createRoomID == '' && that.data.acceptRoomID == ''){
      that.createRoom();
      wx.showShareMenu({
        withShareTicket: true,
        success: function (res) {
        },
        fail: function (res) {
        }
      })
    }
  },
  onShow:function(){
    let that = this;
    if (that.data.acceptRoomID != '') {
      if (app.globalData.userInfo) {
        that.setData({
          userInfo: app.globalData.userInfo,
          hasUserInfo: app.globalData.isAuth,
          showPage: app.globalData.isAuth
        })
        if (that.data.hasUserInfo) {
          that.checkJobNum();

        }
      } else {
        app.userInfoReadyCallback = res => {
          that.setData({
            userInfo: res,
            hasUserInfo: app.globalData.isAuth,
            showPage: app.globalData.isAuth
          })
          if (that.data.hasUserInfo) {
            that.checkJobNum();
          }
        }
      }
    }
  },
  onHide:function(){
  },
  getUserInfo: function (e) {
    app.getServiceUserInfo('');
  },
  onUnload:function(){
    clearInterval(this.data.countDown);
  },
  createRoom:function(){
    let that=this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.createFightingRoomUrl,
      data: {
        wxSession: SinopecSession,
        typeID: that.data.typeId
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: "POST",
      success: function (result) {
        if (result.data.resultCode == 0) {
            that.setData({
              createRoomID: result.data.resultData.roomID,
              showShareBtn: true
            })
          that.getData();
        } else if (result.data.resultCode == 9996) {
          wx.showToast({
            title: '积分不足，练习模式赢取积分',
            icon: 'none',
            duration: 3000,
            success: function () {
              setTimeout(function () {
                wx.reLaunch({
                  url: '../index/index',
                  success: function (res) {
                  },
                  fail: function () {
                  },
                  complete: function () {
                  }
                })
              }, 3000)
            }
          })
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.createRoom());
        } else if (result.data.resultCode == -1) {
          wx.showToast({
            title: '服务器异常',
            icon: 'none',
            duration: 3000,
            success: function () {
              setTimeout(function () {
                wx.navigateTo({
                  url: '../index/index',
                  success: function (res) {
                  },
                  fail: function () {
                  },
                  complete: function () {
                  }
                })
              }, 3000)
            }
          })
        }
      },
      fail: function ({ errMsg }) {
      }
    });
  },
  //发送数据
  acceptFighting:function(){
    let that = this;
    //连接成功
    wx.onSocketOpen(function () {
      console.log('连接成功', that.data.acceptRoomID)
      wx.sendSocketMessage({
        data: '{ "roomID": ' + that.data.acceptRoomID+', "msgType": 1 }'
        })
    })
  },
  //链接websocket，接收数据
  getData:function(){
    console.log('链接websocket');
    let that =this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    console.log('建立连接', SinopecSession);
    wx.closeSocket();
    //建立连接
    wx.connectSocket({
      url: url.websocket + "?wxSession=" + SinopecSession ,
      success: function (res) {
        console.log('成功了', res);
      },
      fail: function () {
        console.log('失败了');
      }
    })
  
    //接收数据
    wx.onSocketMessage(function (data) {
      let result = JSON.parse(data.data);
      console.log('接收数据1', result)
        if (result.resultCode == 0) {
          if (result.resultData.msgType == 2) {
            that.setData({
              acceptData: result.resultData
            })
          } else if (result.resultData.msgType == 1){
            that.setData({
              rivalInfo: result.resultData,
              step: 3
            })
            that.beforeFighting();
          }
        } else if (result.resultCode == 9996) {
          that.setData({
            showPage: false
          })
          wx.showToast({
            title: '积分不足，练习模式赢取积分',
            icon: 'none',
            duration: 3000,
            success: function () {
              setTimeout(function () {
                wx.reLaunch({
                  url: '../index/index',
                  success: function (res) {
                  },
                  fail: function () {
                  },
                  complete: function () {
                  }
                })
              }, 3000)
            }
          })
        } else if (result.resultCode == 9994) {
          that.setData({
            showPage: false
          })
          wx.showToast({
            title: '好友已离开，返回首页',
            icon: 'none',
            duration: 3000,
            success: function () {
              setTimeout(function () {
                wx.reLaunch({
                  url: '../index/index',
                  success: function (res) {
                  },
                  fail: function () {
                  },
                  complete: function () {
                  }
                })
              }, 3000)
            }
          })
        }
    })

    //连接失败
    wx.onSocketError(function () {
    })
  },
  //检查是否绑定了工号
  checkJobNum: function () {
    let SinopecSession = wx.getStorageSync('SinopecSession');
    let that = this;
    wx.request({
      url: url.checkJobNumUrl,
      data: {
        wxSession: SinopecSession
      },
      success: function (result) {
        if (result.data.resultCode == 0) {
          that.setData({
            hasJobNum: true
          })
          that.getData();
          that.acceptFighting();
        } else if (result.data.resultCode == 10001) {
          that.setData({
            hasJobNum: false
          })
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.checkJobNum());
        }
      }
    })
  },
  //工号获取焦点
  onFocus: function (e) {
    this.setData({
      keyHeight: e.detail.height
    })
  },
  onInput: function(e){
    this.setData({
      jobNum: e.detail.value
    })
    console.log(this.data.jobNum)
  },
  //工号输入框失去焦点
  onBlur: function (e) {
    this.setData({
      keyHeight: 0,
      jobNum: e.detail.value
    })
    console.log(this.data.jobNum)
  },
  //绑定工号
  bindJobNum: function () {
    let SinopecSession = wx.getStorageSync('SinopecSession') || '';
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
        console.log('bindJobNum',result)
        if (result.data.resultCode == 0) {
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            duration: 2000
          })
          that.setData({
            hasJobNum: true
          })
          that.getData();
          that.acceptFighting();
        } else if (result.data.resultCode == 10002) {
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
  //邀请答题
  onShareAppMessage: function () {
    let that = this;
    that.setData({
      step: 2
    });
    if (that.data.step == 2) {
      that.countDownInviteTap();
    }
    return {
      title: '邀请答题',
      path: '/pages/fighting/fighting?typeId=' + that.data.typeId + '&roomID=' + that.data.createRoomID,
      imageUrl:'',
      success: function (res) {
        console.log('onShareAppMessage',res)
        that.setData({
          step: 2
        });
        if(that.data.step==2){
          that.countDownInviteTap();
        }
      },
      fail: function (res) {
        // 分享失败
        console.log(res)
      }
    }
  },
  //邀请倒计时
  countDownInviteTap: function () {
    let that = this;
    let totalSecond = 299
    let interval = setInterval(function () {
      // 秒数  
      let second = totalSecond;
      // 分钟位  
      let min = Math.floor((second) / 60);
      let minStr = min.toString();
      if (minStr.length == 1) minStr = '0' + minStr;

      // 秒位  
      let sec = second - min * 60;
      let secStr = sec.toString();
      if (secStr.length == 1) secStr = '0' + secStr;
      that.setData({
        countDownMinute: minStr,
        countDownSecond: secStr,
      });
      totalSecond--;
      if (totalSecond < 0) {
        clearInterval(interval);
        wx.showToast({
          title: '好友没有回应，请重新邀请',
          icon:'none',
          duration:2000
        });
        that.setData({
          step:1,
          countDownMinute: '00',
          countDownSecond: '00',
        });
      }
    }.bind(that), 1000);
    that.setData({
      countDown: interval
    })
  },
  //放弃邀请
  abandon:function(){
    clearInterval(this.data.countDown);
    wx.showToast({
      title: '请重新邀请',
      icon: 'none',
      duration: 2000
    });
    this.setData({
      step: 1,
      countDownMinute: '05',
      countDownSecond: '00',
    });
  },
  //对战前倒计时
  beforeFighting:function(){
    let that = this;
    clearInterval(that.data.countDown);
    let interval = setInterval(function () {
      // 秒数  
      let second = that.data.countDownStart;
      second--;
      that.setData({
        countDownStart: second
      });
      if (that.data.countDownStart < 1) {
        clearInterval(interval);
        that.setData({
          step: 4,
          countDownStart: 0
        });
        that.getQuestion();
      }
    }.bind(that), 1000);
    that.setData({
      countDown: interval
    })
  },
  //获取题目
  getQuestion:function(){
    let that = this;
    let SinopecSession = wx.getStorageSync('SinopecSession');
    wx.request({
      url: url.getRoomQueation,
      data: {
        wxSession: SinopecSession,
        roomID: that.data.createRoomID != '' ? that.data.createRoomID : that.data.acceptRoomID
      },
      success: function (result) {
        if (result.data.resultCode == 0) {
          result.data.resultData.forEach(function (questionItem, questionIndex){
            questionItem.answerList.forEach(function (item, index) {
              item.choose = '';
            })
          })
          that.setData({
            roomQuestionData: result.data.resultData
          })
          that.answerCount();
        } else if (result.data.resultCode == 10000) {
          wx.clearStorage();
          app.getUserInfo(that.getQuestion(''));
        }
      },
      fail: function ({ errMsg }) {
        // console.log('request fail', errMsg)
      }
    });
  },
  //答题时间倒计时
  answerCount:function(){
    let that = this;
    clearInterval(that.data.countDown);
    let interval = setInterval(function () {
      // 秒数  
      let second = that.data.answerTime;
      second--;
      that.setData({
        answerTime: second
      });
      if (that.data.answerTime < 1) {
        clearInterval(interval);
        that.setData({
          answerTime: 0
        });
        if (!that.data.isDisabled) {
          that.sendAnswer(that.data.answerList.length > 0 ? that.data.answerList.join(','):-1);
          that.setData({
            isDisabled: true
          })
        }
      }
    }.bind(that), 1000);
    that.setData({
      countDown: interval
    })
  },
  //选择答案
  chooseAnswer: function (e) {
    let that = this;
    let index = e.currentTarget.dataset.index;
    let id = e.target.id;
    let answers = that.data.answerList;
    //将答案添加到answerList
    let choose = "roomQuestionData[" + that.data.nowQuestionIndex + "].answerList[" + index + "].choose";
    
    if (that.data.roomQuestionData[that.data.nowQuestionIndex].answerList[index].choose == 'choose') {
      that.setData({
        [choose]: ''
      })
      let anIndex = answers.findIndex(ele => ele == id)
      if (anIndex > -1) {
        answers.splice(anIndex, 1);
      }
    } else {
      that.setData({
        [choose]: 'choose'
      })
      answers.push(id);
    }
    that.setData({
      answerList: answers
    })
    if (that.data.roomQuestionData[that.data.nowQuestionIndex].quesType !=2) {
      that.putAnswer();
    }
  },


  putAnswer:function(){
    let that = this;
    that.setData({
      isDisabled: true
    })
    let isCor = true;
    if (that.data.answerList.length == that.data.roomQuestionData[that.data.nowQuestionIndex].rightAnswerID.split(',').length){
      that.data.answerList.forEach(function (chooseItem, chooseIndex) {
        let answerIndex = that.data.roomQuestionData[that.data.nowQuestionIndex].answerList.findIndex(ele => ele.ansID == chooseItem);
        if (answerIndex > -1) {
          let choose = "roomQuestionData["+that.data.nowQuestionIndex+"].answerList[" + answerIndex + "].choose";
          let chooseRightIndex = that.data.roomQuestionData[that.data.nowQuestionIndex].rightAnswerID.split(',').findIndex(ele => ele == chooseItem);
         /* if (chooseRightIndex > -1) {
            that.setData({
              [choose]: 'correct',
            })
          } else {
            that.setData({
              [choose]: 'wrong',
            })
            isCor=false;
          }*/
          if (chooseRightIndex < 0) {
            isCor=false;
          }
        }
      })
    }else{
      isCor = false;
    }
    if (isCor){
      that.setData({
        myScore: that.data.myScore+1,
      })
    }
    //显示正确答案
    that.data.roomQuestionData[that.data.nowQuestionIndex].rightAnswerID.split(',').forEach(function (answerItem, answerIndex) {
      let rightAnswerIndex = that.data.roomQuestionData[that.data.nowQuestionIndex].answerList.findIndex(ele => ele.ansID == answerItem);
      if (rightAnswerIndex > -1) {
        let answerChoose = "roomQuestionData["+that.data.nowQuestionIndex+"].answerList[" + rightAnswerIndex + "].choose";
       /* if (that.data.roomQuestionData[that.data.nowQuestionIndex].answerList[rightAnswerIndex].choose != 'correct') {
          that.setData({
            [answerChoose]: 'correct'
          })
        }*/
        if(that.data.roomQuestionData[that.data.nowQuestionIndex].answerList[rightAnswerIndex].choose == 'choose'){
          that.setData({
            [answerChoose]: 'choose-correct'
          })
        }else{
          that.setData({
            [answerChoose]: 'correct'
          })
        }
      }
    })

    that.sendAnswer(that.data.answerList.join(','));
  },
  //发送答案，获取对方答案
  sendAnswer:function(id){
    let that = this;
    let roomId = that.data.createRoomID != '' ? that.data.createRoomID : that.data.acceptRoomID;
    //连接成功
      wx.sendSocketMessage({
        data: '{ "roomID": ' + roomId + ', "msgType": 2,"questionID":' + that.data.roomQuestionData[that.data.nowQuestionIndex].quesID + ',"answerID":"' + id + '"}'
      })
      if (that.data.acceptData) {
        that.handleAnswer(that.data.acceptData);
      } else {
        let answerTime = setInterval(function(){
          if (that.data.acceptData) {
            clearInterval(answerTime)
            that.handleAnswer(that.data.acceptData)
          }
        },1000)
      }
  },
  handleAnswer:function(data){
    let that = this;

    if (data.isRight == 1){
      that.setData({
        rivalScore: that.data.rivalScore + 1
      })
    }
    that.data.roomQuestionData[that.data.nowQuestionIndex].rightAnswerID.split(',').forEach(function (rightItem, rightIndex) {
      let correctIndex = that.data.roomQuestionData[that.data.nowQuestionIndex].answerList.findIndex(ele => ele.ansID == rightItem);
      if (correctIndex > -1) {
        let correctChoose = "roomQuestionData[" + that.data.nowQuestionIndex + "].answerList[" + correctIndex + "].choose";
        if(that.data.roomQuestionData[that.data.nowQuestionIndex].answerList[correctIndex].choose == 'choose'){
          that.setData({
            [correctChoose]: 'choose-correct'
          })
        }else{
          that.setData({
            [correctChoose]: 'correct'
          })
        }

      }
    })
    
    
    setTimeout(function () {
      if (that.data.nowQuestionIndex < 9) {
        clearInterval(that.data.countDown);

        that.setData({
          isDisabled: false,
          nowQuestionIndex: that.data.nowQuestionIndex + 1,
          answerTime: 10,
          acceptData:null,
          answerList:[]
        })
        that.answerCount();
      } else {
        that.setData({
          step: 5
        })
        if (that.data.myScore < that.data.rivalScore) {
          that.setData({
            resultIcon: '../../images/defeat.png',
            resultTitle: '挑战失败'
          })
        } else if (that.data.myScore > that.data.rivalScore) {
          that.setData({
            resultIcon: '../../images/victory.png',
            resultTitle: '胜利'
          })
        } else {
          that.setData({
            resultIcon: '../../images/tie.png',
            resultTitle: '平局'
          })
        }
      }
    }, 1000)
  },
  //返回首页
  backIndex:function(){
    wx.reLaunch({
      url: '../index/index',
      success: function (res) {
      },
      fail: function () {
      },
      complete: function () {
      }
    })
  }
})


