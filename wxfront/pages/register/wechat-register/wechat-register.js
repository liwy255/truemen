// pages/register/wechat-register/wechat-register.js
// pages/login/login.js
Page({
  data: {
    userInfo: null,
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
  },

  // 生命周期函数--监听页面加载
  onLoad: function (options) {
    // 页面加载时执行
  },

  // 获取用户信息
  getUserProfile: function (e) {
    if (!e.detail.userInfo) {
      return;
    }

    const userInfo = e.detail.userInfo;
    this.setData({
      userInfo: userInfo,
      hasUserInfo: true
    });

    // 可以在这里处理用户的登录流程
    // 如调用微信接口 wx.login 获取 code 然后发送到后端验证
  },

  // 同意按钮
  agree: function () {
    console.log('同意');
    if (this.data.hasUserInfo) {
      wx.navigateTo({
        url: '../index/index'
      });
    }
  },

  // 不同意按钮
  disagree: function () {
    console.log('不同意');
    // 不做任何事情
  }
});