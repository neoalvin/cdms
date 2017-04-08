package edu.hitwh.cdms.dao;

import edu.hitwh.cdms.model.TeacherInfo;
import org.springframework.stereotype.Repository;

/**
 * 教师信息Dao层接口
 * Created by alvin on 2017/4/5.
 */
@Repository
public interface TeacherInfoDao {
  /**
   * 根据ID查询教师信息
   * @param teacherId
   * @return
   */
  public TeacherInfo selectTeacherById(String teacherId);
}
