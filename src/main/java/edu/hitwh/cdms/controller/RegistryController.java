package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.util.UserInfoUtil;
import edu.hitwh.cdms.validator.RegistryAccountValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户注册Controller类
 * Created by alvin on 2017/4/5.
 */
@Controller
public class RegistryController {

  /**
   * 定义学生信息数据操作对象
   */
  @Resource
  private StudentService studentService;

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(RegistryController.class);

  /**
   * 默认头像路径
   */
  private static final String PICTURE_DEFAULT_PATH = "images/user/default.jpg";

  /**
   * 返回注册界面视图
   * @return
   */
  @RequestMapping("/registry")
  public ModelAndView getRegistry() {
    ModelAndView mav = new ModelAndView("registry");
    return mav;
  }

  /**
   * 注册操作restful接口
   * @param studentInfo
   * @return
   */
  @RequestMapping(value = "/registry/addUser", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody RetCode addUser(@RequestBody StudentInfo studentInfo){

    //定义返回信息对象
    RetCode retCode = new RetCode();

    try {
      //若传入用户信息对象为空，则注册失败
      if(null == studentInfo){
        retCode.setCode("1");
        retCode.setMessage("用户信息不能为空！");
        LOGGER.error("[RegistryController]:  Registry account failed.retCode = " + retCode.toString());
        return retCode;
      }

      //若传入必选参数为空，则注册失败
      retCode = RegistryAccountValidator.checkAccountInfo(studentInfo);
      if("1".equals(retCode.getCode())){
        LOGGER.error("[RegistryController]:  Registry account failed.retCode = " + retCode.toString());
        return retCode;
      }

      //对前台传入的密码进行加密
      studentInfo.setPwdCode(UserInfoUtil.EncoderByMd5(studentInfo.getPwdCode()));

      LOGGER.info("[RegistryController]: Registry account start, studentInfo = " + studentInfo.toString());

      //判断学生信息是否已存在
      if (RegistryAccountValidator.checkAccountExist(studentService, studentInfo.getStudentId())) {
        retCode.setCode("1");
        retCode.setMessage("用户已存在!");
        LOGGER.warn("[RegistryController]: Registry account failed.retCode = " + retCode.toString());
      }
      //学生信息不存在
      else {
        //设置默认头像
        studentInfo.setStudentPicture(PICTURE_DEFAULT_PATH);
        //添加学生信息到数据库
        studentService.addStudentInfo(studentInfo);
        LOGGER.info("[RegistryController]: Registry account successfully.");
      }
    }
    catch (Exception e){
      LOGGER.error("[RegistryController]: Exception occurs to registry account. " + e);
      retCode.setCode("1");
      retCode.setMessage(e.toString());
    }
    return retCode;
  }


}
