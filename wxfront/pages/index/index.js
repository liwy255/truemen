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
})
