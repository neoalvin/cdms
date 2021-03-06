package edu.hitwh.cdms.service;

import java.util.List;

import edu.hitwh.cdms.model.TeacherInfo;

/**
 * 教师信息Service层操作接口 Created by alvin on 2017/4/5.
 */
public interface TeacherService {
	/**
	 * 根据ID查询教师信息
	 * 
	 * @param teacherId
	 * @return
	 */
	TeacherInfo selectTeacherById(String teacherId);

	void updateTeacherInfo(TeacherInfo teacherInfo);

	List<TeacherInfo> selectAllTeacherInfo();

	void addTeacherInfo(TeacherInfo teacherInfo);

	void deleteTeacherInfo(String teacherId);
}
