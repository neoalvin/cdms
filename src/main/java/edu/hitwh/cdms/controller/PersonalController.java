package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.UserInfo;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.service.TeacherService;
import edu.hitwh.cdms.validator.PersonalProfileValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 个人资料Controller类
 * Created by alvin on 2017/4/15.
 */
@Controller
public class PersonalController {

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
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping("/personal")
  public ModelAndView getPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //获取session
    HttpSession session = request.getSession();

    LOGGER.info("[PersonalController]: Get into the profile page.userId= ", session.getAttribute("userId"));

    //定义视图
    ModelAndView mav = new ModelAndView();

    //若session中无用户信息，则用户未登录或session失效，跳转至登录页面
    if((null == session.getAttribute("userId")) || ("".equals(session.getAttribute("userId")))){
      LOGGER.warn("[PersonalController]: No user information in session.");
      mav.setViewName("login");
      response.sendRedirect("login");
    }
    else{
      //返回个人资料视图
      mav.setViewName("personal");
    }

    return mav;
  }

  @RequestMapping("personal/updateProfile")
  public @ResponseBody RetCode updateProfile(@RequestBody UserInfo userInfo, HttpServletRequest request){
    //打印日志信息
    LOGGER.info("[PersonalController]: start to update user profile.userId= ", userInfo.getUserId());

    //进行校验并获取返回信息对象
    RetCode retCode = PersonalProfileValidator.checkPersonalProfile(teacherService,studentService,userInfo,request.getSession());

    return retCode;
  }
}
