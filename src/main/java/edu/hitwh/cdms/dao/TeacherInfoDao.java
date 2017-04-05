package edu.hitwh.cdms.dao;

import edu.hitwh.cdms.model.TeacherInfo;

/**
 * 教师信息Dao层接口
 * Created by alvin on 2017/4/5.
 */
public interface TeacherInfoDao {
  /**
   * 根据ID查询教师信息
   * @param teacherId
   * @return
   */
  public TeacherInfo selectTeacherById(String teacherId);
}
