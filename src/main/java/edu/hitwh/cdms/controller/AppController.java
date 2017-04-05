package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class AppController {

  @Resource
  private StudentService studentService;

  @RequestMapping("/")
  public ModelAndView getIndex(){
    ModelAndView mav = new ModelAndView("index");
    StudentInfo studentInfo = studentService.selectStudentById("130420215");
    mav.addObject("studentInfo", studentInfo);
    return mav;
  }

  @RequestMapping("/login")
  public String getLogin() {
	    return "login";
    }

  @RequestMapping("/registry")
  public String getRegistry() {
	    return "registry";
    }

}
