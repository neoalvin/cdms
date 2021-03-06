package edu.hitwh.cdms.service;

import java.util.List;

import edu.hitwh.cdms.model.StudentInfo;

/**
 * StudentService接口 Created by alvin on 2017/4/3.
 */
public interface StudentService {
	StudentInfo selectStudentById(String studentId);

	void addStudentInfo(StudentInfo studentInfo);

	void updateStudentInfo(StudentInfo studentInfo);

	List<StudentInfo> selectAllStudentInfo();

	void deleteStudentInfo(String studentId);
}
