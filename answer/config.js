/**
 * 小程序配置文件
 */

let host = "https://www.zgshnj.com/server-answer-new"
let webSocketHost = "wss://www.zgshnj.com/server-answer-new"
//let host = "https://www.zgshnj.com/server-answer-test"
//let webSocketHost = "wss://www.zgshnj.com/server-answer-test"
let SinopecSession = wx.getStorageSync('SinopecSession') || '';
let config = {
  SinopecSession,
  // 下面的地址配合云端 Server 工作
  host,

  // 登录post
  loginUrl: `${host}/user/login`,

  // 签到post
  signUrl: `${host}/user/sign`,

  // 个人积分get
  getScoreUrl: `${host}/user/score`,

  // 排行榜get
  rankListUrl: `${host}/user/rankList`,

  //校验是否绑定工号get
  checkJobNumUrl: `${host}/user/checkJobNum`,

  //绑定工号post
  bindJobNumUrl: `${host}/user/bindJobNum`,

  //获取用户信息get
  getUserInfoUrl: `${host}/user/userInfo`,

  //修改用户信息post
  updateUserInfoUrl: `${host}/user/update`,
  
  //是否签到过get
  isSignUrl: `${host}/user/isSign`,

  // 练习模式 下一题get
  nextQuestionUrl: `${host}/question/next`,

  // 获取题型列表get
  getTypeListUrl: `${host}/question/typeList`,

  // 练习模式答题get
  answerUrl: `${host}/question/answer`,

  // 我的错题列表get
  getWrongListUrl: `${host}/question/wrongList`,

  // 错题详情get
  wrongDetailUrl: `${host}/question/wrongDetail`,

  // 删除错题get
  delWrongUrl: `${host}/question/delWrong`,

  // 商品列表get
  getGoodsListUrl: `${host}/goods/goodsList`,

  // 商品详情get
  goodsDetailUrl: `${host}/goods/goodsDetail`,

  // 兑换奖品post
  exchangeUrl: `${host}/order/change`,

  // 兑换列表get
  getOrderListUrl: `${host}/order/orderList`,
  
  //创建对战房间
  createFightingRoomUrl: `${host}/user/createRoom`,

  //获取对战题目
  getRoomQueation: `${host}/question/roomQuestion`,

  //获取考试题目
  getExamQueation: `${host}/train/createTrain`,
  //获取历史考试
  getExamHistory: `${host}/train/trainList`,


  //获取历史考试详情
  getExamDetail: `${host}/train/trainDetail`,


  //提交考试
  submitExamDetail: `${host}/train/finishTrain`,


  //活动列表
  warList: `${host}/activity/list`,


  //活动详情
  getWarQueation: `${host}/activity/listByActivityID`,


  //活动提交
  submitWarQueation: `${host}/activity/finish`,


  //主题列表
  bbsList: `${host}//bbs/list`,


  //回复列表
  bbsReplyList: `${host}/bbs/listReply`,


  //回复主题
  bbsReply: `${host}/bbs/saveReply`,


  //发布主题 
  bbsSave: `${host}/bbs/save`,


  //我的回复
  myBbsReply: `${host}/bbs/listMyReply`,

  //我的主题
  myBbs: `${host}/bbs/listMy`,
  
  //好友对战积分
  fScore: `${host}/config/readBattleConfig`,
  //菜单配置
  menuConfig: `${host}/config/readModuleConfig`,

  websocket:`${webSocketHost}/websocket/socketServer`
  
};

module.exports = config
