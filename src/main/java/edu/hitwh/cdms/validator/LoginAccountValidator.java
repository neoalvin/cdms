package edu.hitwh.cdms.validator;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.model.TeacherInfo;
import edu.hitwh.cdms.model.UserInfo;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.service.TeacherService;
import edu.hitwh.cdms.util.CommonUtil;
import edu.hitwh.cdms.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

/**
 * 用户登录校验类
 * Created by alvin on 2017/4/6.
 */
public class LoginAccountValidator {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LoginAccountValidator.class);

  //学生用户
  private static final String STUDENT = "student";

  //教师用户
  private static final String TEACHER = "teacher";


  /**
   * 校验用户信息格式
   * @return
   */
  public static RetCode checkLoginUserInfo(UserInfo userInfo){
    LOGGER.info("[LoginAccountValidator]: Check user information start. userId= " + userInfo.getUserId() + ", userType= " + userInfo.getUserType());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    //校验用户ID
    UserInfoUtil.checkAccountInfoEmpty(userInfo.getUserId(),retCode,"用户ID");
    if("1".equals(retCode)){
      return retCode;
    }

    //校验用户密码
    UserInfoUtil.checkAccountInfoEmpty(userInfo.getPwdCode(),retCode,"用户密码");
    if("1".equals(retCode)){
      return retCode;
    }

    //校验用户类型
    UserInfoUtil.checkAccountInfoEmpty(userInfo.getUserType(),retCode,"用户类型");
    if("1".equals(retCode)){
      return retCode;
    }

    return retCode;
  }
  /**
   * 通过用户名和密码校验用户
   * @return
   */
  public static RetCode checkUserByIdAndPassword(TeacherService teacherService, StudentService studentService,UserInfo userInfo, HttpSession session){
    LOGGER.info("[LoginAccountValidator]: Check user information start. userInfo= " + userInfo.toString());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    //获取用户ID
    String userId = userInfo.getUserId();

    //获取用户密码摘要
    String userPwd = userInfo.getPwdCode();

    //获取用户类型
    String userType = userInfo.getUserType();

    if(STUDENT.equals(userType)){
      StudentInfo studentInfo = studentService.selectStudentById(userId);
      if(null == studentInfo){
        retCode.setCode("1");
        retCode.setMessage("用户不存在！");
      }
      else if(!(userPwd.equals(studentInfo.getPwdCode())))
      {
        LOGGER.info("[LoginAccountValidator]: Get user information successfully. studentInfo= " + studentInfo.toString());
        retCode.setCode("1");
        retCode.setMessage("用户名或密码错误！");
      }
      else{
        LOGGER.info("[LoginAccountValidator]: Get user information successfully. studentInfo= " + studentInfo.toString());
        session.setAttribute("userId", userId);
        session.setAttribute("username",studentInfo.getStudentName());
        session.setAttribute("userPicture",studentInfo.getStudentPicture());
        session.setAttribute("userType","学生");
      }
    }
    else if(TEACHER.equals(userType)){
      TeacherInfo teacherInfo = teacherService.selectTeacherById(userId);
      if(null == teacherInfo){
        retCode.setCode("1");
        retCode.setMessage("用户不存在！");
      }
      else if(!(userPwd.equals(teacherInfo.getPwdCode())))
      {
        LOGGER.info("[LoginAccountValidator]: Get user information successfully. teacherInfo= " + teacherInfo.toString());
        retCode.setCode("1");
        retCode.setMessage("用户名或密码错误！");
      }
      else{
        LOGGER.info("[LoginAccountValidator]: Get user information successfully. teacherInfo= " + teacherInfo.toString());
        session.setAttribute("userId", userId);
        session.setAttribute("username",teacherInfo.getTeacherName());
        session.setAttribute("userPicture",teacherInfo.getTeacherPicture());
        session.setAttribute("userType","教师");
      }
    }
    return retCode;
  }
}
