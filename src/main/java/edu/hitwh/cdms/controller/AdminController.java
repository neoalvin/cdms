package edu.hitwh.cdms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.hitwh.cdms.model.AdminInfo;
import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.model.TeacherInfo;
import edu.hitwh.cdms.service.AdminService;
import edu.hitwh.cdms.service.StudentService;
import edu.hitwh.cdms.service.TeacherService;
import edu.hitwh.cdms.util.CommonUtil;
import edu.hitwh.cdms.util.UserInfoUtil;
import edu.hitwh.cdms.validator.LoginAdminValidator;

/**
 * 管理员Controller类 Created by alvin on 2017/4/17.
 */
@Controller
public class AdminController {

	/**
	 * 定义日志对象
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminController.class);

	/**
	 * 管理员信息操作对象
	 */
	@Resource
	AdminService adminService;

	/**
	 * 学生信息操作对象
	 */
	@Resource
	StudentService studentService;

	/**
	 * 教师信息操作对象
	 */
	@Resource
	TeacherService teacherService;

	/**
	 * 学生默认头像路径
	 */
	private static final String STUDENT_PICTURE_DEFAULT_PATH = "images/user/student/default.jpg";

	/**
	 * 教师默认头像
	 */
	private static final String TEACHER_PICTURE_DEFAULT_PATH = "images/user/teacher/default.jpg";

	/**
	 * 返回管理员视图
	 *
	 * @return
	 */
	@RequestMapping("/admin")
	public ModelAndView getAdmin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获取session
		HttpSession session = request.getSession();

		LOGGER.info("[AdminController]: Get into admin page.username = "
				+ session.getAttribute("adminId"));

		// 定义视图对象
		ModelAndView mv = new ModelAndView();

		// 若session中不存在管理员信息,跳至登录页面
		if (null == session.getAttribute("adminId")) {
			LOGGER.warn(
					"[AdminController]: No administrator information in session.");
			mv.setViewName("loginAdmin");
			response.sendRedirect("/loginAdmin");
		} else {
			// 返回管理员页面视图
			mv.setViewName("admin");
			if (null == session.getAttribute("curModuleName")) {
				session.setAttribute("curModuleName", "studentInfoManagement");
			}
		}
		return mv;
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/admin/{moduleName}")
	public void getAdminModule(
			@PathVariable(value = "moduleName") String moduleName,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 打印入口日志
		LOGGER.info("[AdminController]: Switch admin page.moduleName = "
				+ moduleName);

		// TODO 校验入参

		// 获取session
		HttpSession session = request.getSession();
		session.setAttribute("curModuleName", moduleName);

		// 刷新当前页
		response.sendRedirect("/admin");
	}

	/**
	 * 返回管理员登录视图
	 *
	 * @return
	 */
	@RequestMapping("/loginAdmin")
	public ModelAndView getAdminLogin() {
		// 定义视图对象
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginAdmin");
		return mv;
	}

	/**
	 * 管理员登录
	 *
	 * @param adminInfo
	 * @return
	 */
	@RequestMapping(value = "/admin/login/loginAdmin", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody RetCode loginAdmin(@RequestBody AdminInfo adminInfo,
			HttpServletRequest request) {
		// 定义返回信息对象
		RetCode retCode = new RetCode();

		// 获取session
		HttpSession session = request.getSession();

		try {
			// 若管理员信息为空，则返回错误信息
			if (null == adminInfo
					|| CommonUtil.isStringEmpty(adminInfo.getAdminId())) {
				retCode.setCode("1");
				retCode.setMessage("管理员信息为空！");
				return retCode;
			}

			// 加密前台传入的明文密码
			adminInfo.setPwdCode(
					UserInfoUtil.EncoderByMd5(adminInfo.getPwdCode()));

			LOGGER.info("[AdminController]: Login admin start. adminId = "
					+ adminInfo.getAdminId());

			// 校验管理员信息是否正确
			retCode = LoginAdminValidator.checkAdminInfo(adminService,
					adminInfo, session);
		} catch (Exception e) {
			LOGGER.error(
					"[AdminController]: Login admin error. " + e.toString());
		}

		return retCode;
	}

	/**
	 * 管理员注销
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping("/admin/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 获取session,并清空
		HttpSession session = request.getSession();
		session.invalidate();

		// 跳转至登录页面
		response.sendRedirect("/loginAdmin");
	}

	/** ==========================学生信息操作============================= **/

	@RequestMapping(value = "/userInfo/student/page", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<StudentInfo> selectAllStudentInfo(
			@RequestParam("order") String order) {
		LOGGER.info(
				"[AdminController]: Start to select all student information.");
		List<StudentInfo> studentInfoList = studentService
				.selectAllStudentInfo();
		return studentInfoList;
	}

	@RequestMapping(value = "/userInfo/student/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody void addStudentInfo(
			@RequestBody StudentInfo studentInfo)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		studentInfo.setPwdCode(UserInfoUtil.EncoderByMd5("1234"));
		studentInfo.setStudentPicture(STUDENT_PICTURE_DEFAULT_PATH);
		studentService.addStudentInfo(studentInfo);
	}

	@RequestMapping(value = "/userInfo/student/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody void updateStudentInfo(
			@RequestBody StudentInfo studentInfo) {
		studentService.updateStudentInfo(studentInfo);
	}

	/** ==========================教师信息操作============================= **/

	@RequestMapping(value = "/userInfo/teacher/page", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<TeacherInfo> selectAllTeacherInfo(
			@RequestParam("order") String order) {
		LOGGER.info(
				"[AdminController]: Start to select all teacher information.");
		List<TeacherInfo> teacherInfoList = teacherService
				.selectAllTeacherInfo();
		return teacherInfoList;
	}

	@RequestMapping(value = "/userInfo/teacher/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody void addTeacherInfo(
			@RequestBody TeacherInfo teacherInfo)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		teacherInfo.setPwdCode(UserInfoUtil.EncoderByMd5("1234"));
		teacherInfo.setTeacherPicture(TEACHER_PICTURE_DEFAULT_PATH);
		teacherService.addTeacherInfo(teacherInfo);
	}

	@RequestMapping(value = "/userInfo/teacher/update", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody void updateTeacherInfo(
			@RequestBody TeacherInfo teacherInfo) {
		teacherService.updateTeacherInfo(teacherInfo);
	}

}
