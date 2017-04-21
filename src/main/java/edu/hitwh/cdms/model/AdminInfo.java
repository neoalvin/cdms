package edu.hitwh.cdms.model;

/**
 * 管理员信息数据类
 * Created by alvin on 2017/4/19.
 */
public class AdminInfo {
  /**
   * 管理员ID
   */
  private String adminId;

  /**
   * 密码摘要
   */
  private String pwdCode;

  public String getAdminId() {
    return adminId;
  }

  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }

  public String getPwdCode() {
    return pwdCode;
  }

  public void setPwdCode(String pwdCode) {
    this.pwdCode = pwdCode;
  }

  @Override
  public String toString() {
    return "AdminInfo{" +
        "adminId='" + adminId + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        '}';
  }
}
