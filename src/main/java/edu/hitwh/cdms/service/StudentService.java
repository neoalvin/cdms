package edu.hitwh.cdms.service;

import edu.hitwh.cdms.model.StudentInfo;

/**
 * StudentService接口
 * Created by alvin on 2017/4/3.
 */
public interface StudentService {
  StudentInfo selectStudentById(String studentId);
}
