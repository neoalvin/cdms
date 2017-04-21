package edu.hitwh.cdms.validator;

import edu.hitwh.cdms.model.*;
import edu.hitwh.cdms.service.AdminService;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.service.TeacherService;
import edu.hitwh.cdms.util.CommonUtil;
import edu.hitwh.cdms.util.UserInfoConstants;
import edu.hitwh.cdms.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户个人信息校验类
 * Created by alvin on 2017/4/16.
 */
public class PersonalProfileValidator {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(PersonalProfileValidator.class);

  /**
   * 校验个人信息并处理
   * @param teacherService
   * @param studentService
   * @param userInfo
   * @param session
   * @return
   */
  public static RetCode checkPersonalProfile(TeacherService teacherService, StudentService studentService, UserInfo userInfo, HttpSession session){
    //打印入口日志
    LOGGER.info("[PersonalProfileValidator]: start to check the personal profile. userId = " + userInfo.getUserId());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    //获取用户信息
    String userId = userInfo.getUserId();
    String username = userInfo.getUsername();
    String userType = userInfo.getUserType();
    String password = userInfo.getPwdCode();
    String userEmail = userInfo.getUserEmail();
    String userPhone = userInfo.getUserPhone();
    try {
      //更新学生信息
      if (UserInfoConstants.STUDENT.equals(userType)) {
        //获取原本的学生信息
        StudentInfo studentInfo = studentService.selectStudentById(userId);
        LOGGER.info("[PersonalProfileValidator]: Get student information successfully.studentInfo = " + studentInfo.toString());

        //设置新的用户信息
        studentInfo.setStudentName(username);
        studentInfo.setStudentEmail(userEmail);
        studentInfo.setStudentPhone(userPhone);

        //若传入密码不为空
        if (!CommonUtil.isStringEmpty(password)) {
          //对新密码进行加密, 设置新密码
          String pwdCode = UserInfoUtil.EncoderByMd5(userInfo.getPwdCode());
          studentInfo.setPwdCode(pwdCode);
        }

        //更新session中的学生信息
        UserInfoUtil.saveStudentInfoInSession(session, studentInfo);

        //更新学生信息
        studentService.updateStudentInfo(studentInfo);

        LOGGER.info("[PersonalProfileValidator]: Update student information successfully.");
      } else if (UserInfoConstants.TEACHER.equals(userType)) {
        //获取原来的教师信息
        TeacherInfo teacherInfo = teacherService.selectTeacherById(userId);
        LOGGER.info("[PersonalProfileValidator]: Get student information successfully.studentInfo = " + teacherInfo.toString());

        teacherInfo.setTeacherName(username);
        teacherInfo.setTeacherEmail(userEmail);
        teacherInfo.setTeacherPhone(userPhone);

        //若传入密码为空
        if (!CommonUtil.isStringEmpty(password)) {
          //对新密码进行加密, 设置新密码
          String pwdCode = UserInfoUtil.EncoderByMd5(userInfo.getPwdCode());
          teacherInfo.setPwdCode(pwdCode);
        }

        //更新session中的学生信息
        UserInfoUtil.saveTeacherInfoInSession(session, teacherInfo);

        //更新教师信息
        teacherService.updateTeacherInfo(teacherInfo);

      } else {
        LOGGER.error("[PersonalProfileValidator]: User type is invalid. userType = " + userType);
        retCode.setCode("1");
        retCode.setMessage("用户类型无效！");
      }
    }
    catch(Exception e){
      LOGGER.error("[PersonalProfileValidator]: Update personal profile error. " + e.getMessage());
      retCode.setCode("1");
      retCode.setMessage(e.getMessage());
    }

    return retCode;
  }

  /**
   * 更新管理员信息
   * @param adminService
   * @param adminInfo
   * @return
   */
  public static RetCode checkAndUpdateAdminProfile(AdminService adminService, AdminInfo adminInfo){
    //打印入口日志
    LOGGER.info("[PersonalProfileValidator]: start to check the admin profile. userId = " + adminInfo.getAdminId());


    //定义返回信息对象
    RetCode retCode = new RetCode();

    //更新管理员信息
    try{
      adminService.updateAdminInfo(adminInfo);
    }
    catch(Exception e){
      retCode.setCode("1");
      retCode.setMessage("更新管理员信息失败：" + e.toString());
    }
    return retCode;
  }
}
