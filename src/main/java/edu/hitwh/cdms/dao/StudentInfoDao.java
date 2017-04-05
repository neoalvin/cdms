package edu.hitwh.cdms.dao;

import edu.hitwh.cdms.model.StudentInfo;
import org.springframework.stereotype.Repository;

/**
 * 学生信息数据库操作接口
 *
 * @author alvin
 *
 */
@Repository
public interface StudentInfoDao {
    public StudentInfo selectStudentById(String studentId);
    public StudentInfo saveStudentInfo(StudentInfo studentInfo);
}
