package edu.hitwh.cdms.service.impl;

import edu.hitwh.cdms.dao.StudentInfoDao;
import edu.hitwh.cdms.model.StudentInfo;
import edu.hitwh.cdms.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * StudentService实现类
 * Created by alvin on 2017/4/3.
 */
@Service
public class StudentServiceImpl implements StudentService {
  /**
   * 定义学生信息数据库操作对象
   */
  @Resource
  private StudentInfoDao studentInfoDao;

  /**
   * 通过学生id获取学生信息
   * @param studentId
   * @return
   */
  public StudentInfo selectStudentById(String studentId) {
    return studentInfoDao.selectStudentById(studentId);
  }

  /**
   * 添加学生信息
   * @param studentInfo
   */
  public void addStudentInfo(StudentInfo studentInfo) {
    studentInfoDao.addStudentInfo(studentInfo);
  }
}
