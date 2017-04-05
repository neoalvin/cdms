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
   * 密码摘要
   */
  private String pwdCode;

  /**
   * 用户类型
   */
  private String userType;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  @Override
  public String toString() {
    return "UserInfo{" +
        "userId='" + userId + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        ", userType='" + userType + '\'' +
        '}';
  }
}
