package edu.hitwh.cdms.service;

import edu.hitwh.cdms.model.StudentInfo;

import java.util.List;

/**
 * StudentService接口
 * Created by alvin on 2017/4/3.
 */
public interface StudentService {
  StudentInfo selectStudentById(String studentId);
  void addStudentInfo(StudentInfo studentInfo);
  void updateStudentInfo(StudentInfo studentInfo);
  List<StudentInfo> selectAllStudentInfo();
}
