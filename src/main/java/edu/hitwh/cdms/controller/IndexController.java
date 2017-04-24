package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.util.UserInfoConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 主页Controller类
 */
@Controller
public class IndexController {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


  /**
   * 获取主页页面视图
   * @return
   */
  @RequestMapping("/")
  public ModelAndView getIndex(HttpServletRequest request) throws IOException{
    //获取session
    HttpSession session = request.getSession();

    //定义视图
    ModelAndView mv = new ModelAndView();

    //若session中无用户信息，则用户未登录，跳转至登录页面
    if((null == session.getAttribute("userId")) || ("".equals(session.getAttribute("userId")))){
      LOGGER.warn("[IndexController]: No user information in session.");
      mv.setViewName("login");
    }
    else {
      String userType = session.getAttribute("userType").toString();
      LOGGER.info("[IndexController]: Get into the homepage.userId = " + session.getAttribute("userId") + ", userType = " + userType);
      //判断用户类型，返回相应主页视图
      if (UserInfoConstants.TEACHER_ZH.equals(userType)){
        LOGGER.info("[IndexController]: Get into the teacher homepage.");
        if(null == session.getAttribute("curModuleName")){
          session.setAttribute("curModuleName","studentManagement");
        }
        mv.setViewName("teacherPage");
      } else if (UserInfoConstants.STUDENT_ZH.equals(userType)) {
        LOGGER.info("[IndexController]: Get into the student homepage.");
        if(null == session.getAttribute("curModuleName")){
          session.setAttribute("curModuleName","studentCourcesManagement");
        }
        mv.setViewName("studentPage");
      } else {
        LOGGER.info("[IndexController]: User type is not allowed, not found page.");
        mv.setViewName("notFoundPage");
      }
    }

    return mv;
  }

}
