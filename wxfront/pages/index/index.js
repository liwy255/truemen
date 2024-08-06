// index.js
const config = require('../../config.js')
Page({
  data: {
    m: wx.getMenuButtonBoundingClientRect(),
    s: wx.getSystemInfoSync(),
    longitude: config.center_longitude,
    latitude: config.center_latitude,
    mapSubKey: config.mapSubKey, // 地图key
  },
  onShow() {
    this.getTabBar().init()
  },
  onLoad: function () {
    // 初始化时获取用户当前位置
    this.getUserLocation()
  },
  getUserLocation: function () {
    const vm = this
    wx.getLocation({
      type: 'wgs84',
      success(res) {
        vm.setData({
          longitude: res.longitude,
          latitude: res.latitude,
        })
      },
    })
  },
  moveToLocation: function () {
    // 调用地图组件的移动到当前定位点
    const mapCtx = wx.createMapContext('map')
    mapCtx.moveToLocation()
  },
})
