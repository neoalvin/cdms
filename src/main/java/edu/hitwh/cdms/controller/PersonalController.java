package edu.hitwh.cdms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 个人资料Controller类
 * Created by alvin on 2017/4/15.
 */
@Controller
public class PersonalController {

  @RequestMapping("/personal")
  public ModelAndView getPersonal() {
    ModelAndView mav = new ModelAndView("personal");
    return mav;
  }
}
