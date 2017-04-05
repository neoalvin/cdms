package edu.hitwh.cdms.model;

/**
 * 返回信息类
 * Created by alvin on 2017/4/5.
 */
public class RetCode {
  /**
   * 返回码
   */
  private String code = "0";

  /**
   * 返回信息
   */
  private String message;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "RetCode{" +
        "code='" + code + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
