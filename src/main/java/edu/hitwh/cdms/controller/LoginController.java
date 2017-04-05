package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.UserInfo;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户登录Controller类
 * Created by alvin on 2017/4/5.
 */
@Controller
public class LoginController {

  //学生信息数据操作类
  @Resource
  StudentService studentService;

  //定义日志对象
  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);



  /**
   * 返回用户登陆页面视图
   * @return
   */
  @RequestMapping("/login")
  public ModelAndView getLogin() {
    ModelAndView mav = new ModelAndView("login");
    return mav;
  }

  /**
   * 用户登录操作
   * @return
   */
  @RequestMapping(value = "/login/loginUser")
  public RetCode loginUser(UserInfo userInfo){
    //定义返回信息对象
    RetCode retCode = UserInfoUtil.checkUserByIdAndPassword(userInfo);
    return retCode;
  }

}
