package edu.hitwh.cdms.service;

import edu.hitwh.cdms.model.TeacherInfo;

import java.util.List;

/**
 * 教师信息Service层操作接口
 * Created by alvin on 2017/4/5.
 */
public interface TeacherService {
  /**
   * 根据ID查询教师信息
   * @param teacherId
   * @return
   */
  TeacherInfo selectTeacherById(String teacherId);
  void updateTeacherInfo(TeacherInfo teacherInfo);
  List<TeacherInfo> selectAllTeacherInfo();
}
