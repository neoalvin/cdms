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
   * 班级
   */
  private String studentClass;

  /**
   * 邮箱
   */
  private String studentEmail;

  /**
   * 电话号码
   */
  private String studentPhone;

  /**
   *
   */
  private String studentPicture;

  /**
   * 密码摘要
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

  public String getStudentClass() {
    return studentClass;
  }

  public void setStudentClass(String studentClass) {
    this.studentClass = studentClass;
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

  public String getStudentPicture() {
    return studentPicture;
  }

  public void setStudentPicture(String studentPicture) {
    this.studentPicture = studentPicture;
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
        ", studentClass='" + studentClass + '\'' +
        ", studentEmail='" + studentEmail + '\'' +
        ", studentPhone='" + studentPhone + '\'' +
        ", studentPicture='" + studentPicture + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        '}';
  }
}
