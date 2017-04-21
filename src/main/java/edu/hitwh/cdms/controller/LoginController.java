package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.UserInfo;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.service.TeacherService;
import edu.hitwh.cdms.util.UserInfoUtil;
import edu.hitwh.cdms.validator.LoginAccountValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 用户登录Controller类
 * Created by alvin on 2017/4/5.
 */
@Controller
public class LoginController{

  /**
   * 学生信息数据操作对象
   */
  @Resource
  StudentService studentService;

  /**
   * 教师信息数据操作对象
   */
  @Resource
  TeacherService teacherService;

  /**
   *  定义日志对象
   */
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
  @RequestMapping(value = "/login/loginUser", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody RetCode loginUser(@RequestBody UserInfo userInfo, HttpServletRequest request){
    //定义返回信息对象
    RetCode retCode = new RetCode();

    //获取session
    HttpSession session = request.getSession();

    try {
      //校验传入用户信息对象是否为空
      if (null == userInfo) {
        retCode.setCode("1");
        retCode.setMessage("传入信息为空。");
        LOGGER.error("[LoginController]: Login account failed.retCode=" + retCode.toString());
      }

      //校验用户具体信息是否为空
      retCode = LoginAccountValidator.checkLoginUserInfo(userInfo);
      if ("1".equals(retCode.getCode())) {
        LOGGER.error("[LoginController]:  Login account failed.retCode = " + retCode.toString());
        return retCode;
      }

      //对用户明文密码进行加密
      userInfo.setPwdCode(UserInfoUtil.EncoderByMd5(userInfo.getPwdCode()));


      //打印入参信息
      LOGGER.info("[LoginController]: Login account start, studentInfo = " + userInfo.toString());

      //获取校验结果
      retCode = LoginAccountValidator.checkUserByIdAndPassword(teacherService, studentService, userInfo, session);

      if("0".equals(retCode.getCode())){
        LOGGER.info("[LoginController]: Login account successfully. userId in session: " + session.getAttribute("userId"));
      }
      else{
        LOGGER.error("[LoginController]: Login account failed.retCode = " + retCode.toString());
      }
    }
    catch (Exception e){
      LOGGER.error("[LoginController]: Exception occurs to login account. " + e.toString());
      retCode.setCode("1");
      retCode.setMessage(e.toString());
    }
    return retCode;
  }

  /**
   * 注销用户，清空session
   * @param request
   * @param response
   * @throws IOException
   */
  @RequestMapping("/logout")
  public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //获取seesion，并清空
    HttpSession session = request.getSession();
    session.invalidate();

    //跳转至登陆页面
    response.sendRedirect("login");
  }

}
