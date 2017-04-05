package edu.hitwh.cdms.validator;

import edu.hitwh.cdms.service.StudentService;
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
}
