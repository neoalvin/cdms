package edu.hitwh.cdms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
  @RequestMapping("/index")
  public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) throws IOException{
    //获取session
    HttpSession session = request.getSession();
    LOGGER.info("[IndexController]: Get into the homepage.userId= ", session.getAttribute("userId"));

    //定义视图
    ModelAndView mav = new ModelAndView();

    //若session中无用户信息，则用户未登录，跳转至登录页面
    if((null == session.getAttribute("userId")) || "".equals(session.getAttribute("userId"))){
      LOGGER.warn("[IndexController]: No user login.");
      mav.setViewName("login");
      response.sendRedirect("login");
    }
    else{
      //返回主页视图，将用户信息置于session中
      mav.setViewName("index");
      mav.addObject("userId", session.getAttribute("userId"));
      mav.addObject("username", session.getAttribute("username"));
    }
    return mav;
  }

}
