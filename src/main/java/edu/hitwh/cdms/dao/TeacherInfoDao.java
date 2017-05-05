package edu.hitwh.cdms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hitwh.cdms.model.TeacherInfo;

/**
 * 教师信息Dao层接口 Created by alvin on 2017/4/5.
 */
@Repository
public interface TeacherInfoDao {
	/**
	 * 根据ID查询教师信息
	 *
	 * @param teacherId
	 * @return
	 */
	public TeacherInfo selectTeacherById(String teacherId);

	public void updateTeacherInfo(TeacherInfo teacherInfo);

	public List<TeacherInfo> selectAllTeacherInfo();

	public void addTeacherInfo(TeacherInfo teacherInfo);

	public void deleteTeacherInfo(String teacherId);
}
