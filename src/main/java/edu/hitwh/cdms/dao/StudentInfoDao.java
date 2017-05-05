package edu.hitwh.cdms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.hitwh.cdms.model.StudentInfo;

/**
 * 学生信息数据库操作接口
 *
 * @author alvin
 *
 */
@Repository
public interface StudentInfoDao {
	public StudentInfo selectStudentById(String studentId);

	public void addStudentInfo(StudentInfo studentInfo);

	public void updateStudentInfo(StudentInfo studentInfo);

	public List<StudentInfo> selectAllStudentInfo();

	public void deleteStudentInfo(String studentId);
}
