package edu.hitwh.cdms.model;

/**
 * 用户信息类
 * Created by alvin on 2017/4/5.
 */
public class UserInfo {
  /**
   * 用户ID
   */
  private String userId;

  /**
   * 用户姓名
   */
  private String username;

  /**
   * 密码摘要
   */
  private String pwdCode;

  /**
   * 用户类型
   */
  private String userType;

  /**
   * 用户邮箱
   */
  private String userEmail;

  /**
   * 用户电话
   */
  private String userPhone;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPwdCode() {
    return pwdCode;
  }

  public void setPwdCode(String pwdCode) {
    this.pwdCode = pwdCode;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
        "userId='" + userId + '\'' +
        ", username='" + username + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        ", userType='" + userType + '\'' +
        ", userEmail='" + userEmail + '\'' +
        ", userPhone='" + userPhone + '\'' +
        '}';
  }
}
