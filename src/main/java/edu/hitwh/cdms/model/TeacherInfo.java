package edu.hitwh.cdms.model;

/**
 * 教师信息类
 * @author alvin
 * Created by alvin on 2017/4/5.
 */
public class TeacherInfo {
  /**
   * 教师工号
   */
  private String teacherId;

  /**
   * 教师名称
   */
  private String teacherName;

  /**
   * 教师邮箱
   */
  private String teacherEmail;

  /**
   * 教师电话
   */
  private String teacherPhone;

  /**
   * 教师头像
   */
  private String teacherPicture;

  /**
   * 教师密码摘要
   */
  private String pwdCode;

  public String getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(String teacherId) {
    this.teacherId = teacherId;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public String getTeacherEmail() {
    return teacherEmail;
  }

  public void setTeacherEmail(String teacherEmail) {
    this.teacherEmail = teacherEmail;
  }

  public String getTeacherPhone() {
    return teacherPhone;
  }

  public void setTeacherPhone(String teacherPhone) {
    this.teacherPhone = teacherPhone;
  }

  public String getPwdCode() {
    return pwdCode;
  }

  public void setPwdCode(String pwdCode) {
    this.pwdCode = pwdCode;
  }

  public String getTeacherPicture() {
    return teacherPicture;
  }

  public void setTeacherPicture(String teacherPicture) {
    this.teacherPicture = teacherPicture;
  }

  @Override
  public String toString() {
    return "TeacherInfo{" +
        "teacherId='" + teacherId + '\'' +
        ", teacherName='" + teacherName + '\'' +
        ", teacherEmail='" + teacherEmail + '\'' +
        ", teacherPhone='" + teacherPhone + '\'' +
        ", teacherPicture='" + teacherPicture + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        '}';
  }
}
