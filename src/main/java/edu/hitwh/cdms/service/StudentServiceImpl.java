package edu.hitwh.cdms.service;

import edu.hitwh.cdms.dao.StudentInfoDao;
import edu.hitwh.cdms.model.StudentInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * StudentService实现类
 * Created by alvin on 2017/4/3.
 */
@Service
public class StudentServiceImpl implements StudentService {
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
}
