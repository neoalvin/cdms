package edu.hitwh.cdms.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.hitwh.cdms.model.CoursesInfo;
import edu.hitwh.cdms.model.ScoresInfo;
import edu.hitwh.cdms.service.CoursesService;
import edu.hitwh.cdms.service.ScoresService;
import edu.hitwh.cdms.util.UserInfoConstants;

/**
 * 主页Controller类
 */
@Controller
public class IndexController {

	/**
	 * 定义日志对象
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(IndexController.class);

	@Resource
	CoursesService coursesService;

	@Resource
	ScoresService scoresService;

	/**
	 * 获取主页页面视图
	 *
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView getIndex(HttpServletRequest request)
			throws IOException {
		// 获取session
		HttpSession session = request.getSession();

		// 定义视图
		ModelAndView mv = new ModelAndView();

		// 若session中无用户信息，则用户未登录，跳转至登录页面
		if ((null == session.getAttribute("userId"))
				|| ("".equals(session.getAttribute("userId")))) {
			LOGGER.warn("[IndexController]: No user information in session.");
			mv.setViewName("login");
		} else {
			String userType = session.getAttribute("userType").toString();
			LOGGER.info("[IndexController]: Get into the homepage.userId = "
					+ session.getAttribute("userId") + ", userType = "
					+ userType);
			// 判断用户类型，返回相应主页视图
			if (UserInfoConstants.TEACHER_ZH.equals(userType)) {
				LOGGER.info(
						"[IndexController]: Get into the teacher homepage.");
				if (null == session.getAttribute("curModuleName")) {
					session.setAttribute("curModuleName", "studentManagement");
				}
				mv.setViewName("teacherPage");
			} else if (UserInfoConstants.STUDENT_ZH.equals(userType)) {
				LOGGER.info(
						"[IndexController]: Get into the student homepage.");
				if (null == session.getAttribute("curModuleName")) {
					session.setAttribute("curModuleName",
							"studentCourcesManagement");
				}
				mv.setViewName("studentPage");
			} else {
				LOGGER.info(
						"[IndexController]: User type is not allowed, not found page.");
				mv.setViewName("notFoundPage");
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
	@RequestMapping("/studentPage/{moduleName}")
	public void getStudentModule(
			@PathVariable(value = "moduleName") String moduleName,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 打印入口日志
		LOGGER.info("[IndexController]: Switch admin page.moduleName = "
				+ moduleName);

		// TODO 校验入参

		// 获取session
		HttpSession session = request.getSession();
		session.setAttribute("curModuleName", moduleName);

		// 刷新当前页
		response.sendRedirect("/");
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/teacherPage/{moduleName}")
	public void getTeacherModule(
			@PathVariable(value = "moduleName") String moduleName,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 打印入口日志
		LOGGER.info("[IndexController]: Switch admin page.moduleName = "
				+ moduleName);

		// TODO 校验入参

		// 获取session
		HttpSession session = request.getSession();
		session.setAttribute("curModuleName", moduleName);

		// 刷新当前页
		response.sendRedirect("/");
	}

	@RequestMapping(value = "/courses/page", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<CoursesInfo> selectAllCoursesInfo(
			@RequestParam("order") String order) {
		LOGGER.info(
				"[IndexController]: Start to select all courses information.");
		List<CoursesInfo> coursesInfoList = coursesService
				.selectAllCoursesInfo();
		return coursesInfoList;
	}

	@RequestMapping(value = "/scores/page", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<ScoresInfo> selectAllScoresInfo(
			@RequestParam("order") String order) {
		LOGGER.info(
				"[IndexController]: Start to select all scores information.");
		List<ScoresInfo> scoresInfoList = scoresService.selectAllScoresInfo();
		return scoresInfoList;
	}

}
