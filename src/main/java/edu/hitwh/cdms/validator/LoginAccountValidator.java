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
  public static RetCode checkUserByIdAndPassword(TeacherService teacherService, StudentService studentService,UserInfo userInfo){
    LOGGER.info("[LoginAccountValidator]: Check user information start. userId= " + userInfo.getUserId());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    if(STUDENT.equals(userInfo.getUserType())){
      StudentInfo studentInfo = studentService.selectStudentById(userInfo.getUserId());
      if((null == studentInfo) || !(userInfo.getPwdCode().equals(studentInfo.getPwdCode())))
      {
        retCode.setCode("1");
        retCode.setMessage("用户不存在或密码错误。");
      }
      else{
        retCode.setMessage(studentInfo.getStudentName());
      }
    }
    else if(TEACHER.equals(userInfo.getUserType())){
      TeacherInfo teacherInfo = teacherService.selectTeacherById(userInfo.getUserId());
      if((null == teacherInfo) || !(userInfo.getPwdCode().equals(teacherInfo.getPwdCode())))
      {
        retCode.setCode("1");
        retCode.setMessage("用户不存在或密码错误。");
      }
      else{
        retCode.setMessage(teacherInfo.getTeacherName());
      }
    }
    return retCode;
  }
}
