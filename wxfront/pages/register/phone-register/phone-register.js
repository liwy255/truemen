// pages/register/phone-register/phone-register.js
Page({
  data: {
    phoneNumber: '',
    password: '',
    confirmPassword: '',
    agree: false,
    showPassword: false,
    showPassword2:false,
    isFormValid: false,
    phoneNumberValid: false,
    passwordValid:false,
    confirmPasswordValid:false,
  },
  // 是否展示密码，确认密码
  togglePasswordVisibility: function () {
    this.setData({
      showPassword: !this.data.showPassword
    });
  },

  togglePasswordVisibility2: function () {
    this.setData({
      showPassword2: !this.data.showPassword2
    });
  },

  onPhoneNumberChange: function(e) {
    const phoneNumber = e.detail.value;
    this.setData({
      phoneNumber: phoneNumber,
      phoneNumberValid: this.validatePhoneNumber(phoneNumber)
    });
  },

  validatePhoneNumber :function (phoneNumber) {
    // 中国手机号码的正则表达式
    const regex = /^(13[0-9]|14[5-9]|15[0-3,5-9]|16[6]|17[0-8]|18[0-9]|19[8,9])\d{8}$/;
    // 测试输入的手机号码是否匹配正则表达式
    const res=regex.test(phoneNumber);
    if(res===false){
      return res;
    }else if(res==true){
      return res;
    }else{
      console.warn('手机号验证报错，需要代码修复');
    }
  },

  onPasswordChange: function(e) {
    const password = e.detail.value;
    this.setData({
      password: password,
      passwordValid: this.validatePassword(password)
    });
  },

  onConfirmPasswordChange: function(e) {
    const password = e.detail.value;
    this.setData({
      confirmPassword: password,
      confirmPasswordValid:this.validateComfirmPassword(password)
    });
  },

  onAgreeChange: function(e) {
    this.setData({ agree: e.detail.value[0] === 'agree' });
    this.validateForm();
  },

  validateForm: function() {
    const { phoneNumberValid, passwordValid, confirmPasswordValid, agree } = this.data;
    console.warn(phoneNumberValid,passwordValid,confirmPasswordValid,agree)
    const isFormValid = phoneNumberValid && passwordValid && confirmPasswordValid && agree;
    console.warn(isFormValid);
    this.setData({ isFormValid });
  },

  validatePassword:function (password) {
    // 密码的正则表达式
    // 至少8位，包含数字和英文字母，不包含特殊符号
    const regex = /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z\d]{8,}$/;
  
    // 测试输入的密码是否匹配正则表达式
    const res= regex.test(password);
    if(res===false){
      return res;
    }else if(res===true){
      return res;
    }else{
      console.warn('密码验证报错，需要代码修复');
    }
  },

  validateComfirmPassword:function (password) {
    if(password===this.data.password && this.validatePassword(password)){
      return true;
    }else{
      return false;
    }
  },
  onRegister: function() {
      wx.showModal({
        title: '确认',
        content: '您确定要注册吗？',
        success: function(res) {
          if (res.confirm) {
            // 这里还要和后端交互，要保证手机号是不一样的！！！
            wx.showToast({
              title: '注册成功',
              icon: 'success',
              duration: 2000,
              complete: function() {
                // 在提示结束后跳转到 index 页面
                wx.switchTab({
                  url: '../../index/index'
                });
              }
            });
          } else if (res.cancel) {
            console.log('用户点击取消');
          }
        }
      });
  }
});