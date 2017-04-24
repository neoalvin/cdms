package edu.hitwh.cdms.dao;

import edu.hitwh.cdms.model.StudentInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
