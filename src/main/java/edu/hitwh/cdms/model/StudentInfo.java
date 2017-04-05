package edu.hitwh.cdms.model;

/**
 * 用户信息映射类
 *
 * @author alvin
 */
public class StudentInfo {

  /**
   * 学号
   */
  private String studentId;

  /**
   * 姓名
   */
  private String studentName;

  /**
   * 邮箱
   */
  private String studentEmail;

  /**
   * 电话号码
   */
  private String studentPhone;

  /**
   * 账号密码摘要
   */
  private String pwdCode;

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentEmail() {
    return studentEmail;
  }

  public void setStudentEmail(String studentEmail) {
    this.studentEmail = studentEmail;
  }

  public String getStudentPhone() {
    return studentPhone;
  }

  public void setStudentPhone(String studentPhone) {
    this.studentPhone = studentPhone;
  }

  public String getPwdCode() {
    return pwdCode;
  }

  public void setPwdCode(String pwdCode) {
    this.pwdCode = pwdCode;
  }

  @Override
  public String toString() {
    return "StudentInfo{" +
        "studentId='" + studentId + '\'' +
        ", studentName='" + studentName + '\'' +
        ", studentEmail='" + studentEmail + '\'' +
        ", studentPhone='" + studentPhone + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        '}';
  }
}
