package edu.hitwh.cdms.util;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.model.TeacherInfo;
import edu.hitwh.cdms.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用户操作公共方法类
 * @author alvin
 * Created by alvin on 2017/4/5.
 */
public class UserInfoUtil {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoUtil.class);

  /**
   * MD5加密
   * @param str
   * @return
   * @throws NoSuchAlgorithmException
   * @throws UnsupportedEncodingException
   */
  public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

    LOGGER.info("[UserInfoUtil]: Encode the password start.");

    //确定计算方法
    MessageDigest md5=MessageDigest.getInstance("MD5");
    BASE64Encoder base64en = new BASE64Encoder();

    //加密后的字符串
    return base64en.encode(md5.digest(str.getBytes("utf-8")));
  }

  /**
   * 校验账号信息是否为空
   * @param param
   * @param retCode
   */
  public static void checkAccountInfoEmpty(String info, RetCode retCode, String param) {
    if (CommonUtil.isStringEmpty(info)) {
      retCode.setCode("1");
      retCode.setMessage(param + "不能为空。");
      LOGGER.error("Check account info start, retCode = " + retCode.toString());
    }
  }

  /**
   * 保存学生信息到session中
   * @param session
   * @param studentInfo
   */
  public static void saveStudentInfoInSession(HttpSession session, StudentInfo studentInfo){
    session.setAttribute("userId", studentInfo.getStudentId());
    session.setAttribute("username",studentInfo.getStudentName());
    session.setAttribute("userPicture",studentInfo.getStudentPicture());
    session.setAttribute("userType","学生");
    session.setAttribute("userEmail",studentInfo.getStudentEmail());
    session.setAttribute("userPhone",studentInfo.getStudentPhone());
  }

  /**
   * 保存教师信息到session中
   * @param session
   * @param teacherInfo
   */
  public static void saveTeacherInfoInSession(HttpSession session, TeacherInfo teacherInfo){
    session.setAttribute("userId", teacherInfo.getTeacherId());
    session.setAttribute("username",teacherInfo.getTeacherName());
    session.setAttribute("userPicture",teacherInfo.getTeacherPicture());
    session.setAttribute("userType","教师");
    session.setAttribute("userEmail",teacherInfo.getTeacherEmail());
    session.setAttribute("userPhone",teacherInfo.getTeacherPhone());
  }



}
