package edu.hitwh.cdms.controller;

import edu.hitwh.cdms.model.AdminInfo;
import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.UserInfo;
import edu.hitwh.cdms.service.AdminService;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.service.TeacherService;
import edu.hitwh.cdms.util.CommonUtil;
import edu.hitwh.cdms.util.UserInfoUtil;
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
   * 管理员信息数据操作对象
   */
  @Resource
  AdminService adminService;

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

  @RequestMapping("/personal")
  public ModelAndView getPersonal(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //获取session
    HttpSession session = request.getSession();

    LOGGER.info("[PersonalController]: Get into the profile page.userId = " + session.getAttribute("userId"));

    //定义视图
    ModelAndView mv = new ModelAndView();

    //若session中无用户信息，则用户未登录或session失效，跳转至登录页面
    if((null == session.getAttribute("userId")) || ("".equals(session.getAttribute("userId")))){
      LOGGER.warn("[PersonalController]: No user information in session.");
      mv.setViewName("login");
      response.sendRedirect("login");
    }
    else{
      //返回个人资料视图
      mv.setViewName("personal");
    }

    return mv;
  }

  @RequestMapping("personal/updateProfile")
  public @ResponseBody RetCode updateProfile(@RequestBody UserInfo userInfo, HttpServletRequest request){
    //定义返回信息对象
    RetCode retCode = new RetCode();

    //校验传入用户信息对象是否为空
    if(null == userInfo){
      retCode.setCode("1");
      retCode.setMessage("传入信息为空！");
      return retCode;
    }

    //打印日志信息
    LOGGER.info("[PersonalController]: start to update user profile.userId = " + userInfo.getUserId());

    //进行校验并获取返回信息对象
    retCode = PersonalProfileValidator.checkPersonalProfile(teacherService,studentService,userInfo,request.getSession());

    return retCode;
  }

  @RequestMapping("adminProfile")
  public ModelAndView getAdminProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //获取session
    HttpSession session = request.getSession();

    //定义视图对象
    ModelAndView mv = new ModelAndView();

    //若session中无管理员信息
    if((null == session.getAttribute("adminId")) || (CommonUtil.isStringEmpty(session.getAttribute("adminId").toString()))){
      LOGGER.warn("[PersonalController]: No admin information in session.");
      mv.setViewName("loginAdmin");
      response.sendRedirect("loginAdmin");
    }
    mv.setViewName("adminProfile");
    return mv;
  }

  @RequestMapping("adminProfile/updateProfile")
  public @ResponseBody  RetCode updateAdminProfile(@RequestBody AdminInfo adminInfo){
    //定义返回信息对象
    RetCode retCode = new RetCode();

    try {

      //校验传入用户信息对象是否为空
      if (null == adminInfo || null == adminInfo.getAdminId()) {
        retCode.setCode("1");
        retCode.setMessage("传入信息为空！");
        return retCode;
      }

      //打印日志信息
      LOGGER.info("[PersonalController]: start to update admin profile.adminId = " + adminInfo.getAdminId());

      //加密前台传入的明文密码
      adminInfo.setPwdCode(UserInfoUtil.EncoderByMd5(adminInfo.getPwdCode()));

      //进行校验并获取返回信息对象
      retCode = PersonalProfileValidator.checkAndUpdateAdminProfile(adminService, adminInfo);
    }catch(Exception e){
      retCode.setCode("1");
      retCode.setMessage("update admin profile error. " + e.toString());
      LOGGER.error(retCode.getMessage());
    }
    return retCode;
  }
}
