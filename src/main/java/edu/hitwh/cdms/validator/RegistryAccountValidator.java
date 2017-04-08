package edu.hitwh.cdms.validator;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户注册校验类
 * @author alvin
 * Created by alvin on 2017/4/5.
 */
public class RegistryAccountValidator {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(RegistryAccountValidator.class);

  /**
   * 校验用户信息是否已存在
   * @param userId
   * @return
   */
  public static boolean checkAccountExist(StudentService studentService, String userId){
    LOGGER.info("[RegistryAccountValidator]: Check account start, userId = " + userId);
    return null != studentService.selectStudentById(userId);
  }

  /**
   * 校验用户信息格式
   * @param studentInfo
   * @return
   */
  public static RetCode checkAccountInfo(StudentInfo studentInfo){
    RetCode retCode = new RetCode();
    //校验用户ID
    UserInfoUtil.checkAccountInfoEmpty(studentInfo.getStudentId(),retCode,"用户ID");
    if("1".equals(retCode)){
      return retCode;
    }
    //校验用户姓名
    UserInfoUtil.checkAccountInfoEmpty(studentInfo.getStudentName(),retCode,"用户姓名");
    if("1".equals(retCode)){
      return retCode;
    }
    //校验用户密码
    UserInfoUtil.checkAccountInfoEmpty(studentInfo.getPwdCode(),retCode,"用户密码");
    if("1".equals(retCode)){
      return retCode;
    }

    return retCode;
  }

}
