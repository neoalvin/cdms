package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 主页Controller类
 */
@Controller
public class IndexController {

  /**
   * 学生信息Service类
   */
  @Resource
  private StudentService studentService;

  /**
   * 获取主页页面视图
   * @return
   */
  @RequestMapping("/")
  public ModelAndView getIndex(){
    ModelAndView mav = new ModelAndView("index");
    StudentInfo studentInfo = studentService.selectStudentById("130420215");
    mav.addObject("studentInfo", studentInfo);
    return mav;
  }

}
