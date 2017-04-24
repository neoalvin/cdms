package edu.hitwh.cdms.service.impl;

import edu.hitwh.cdms.dao.TeacherInfoDao;
import edu.hitwh.cdms.model.TeacherInfo;
import edu.hitwh.cdms.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师信息操作实现类
 * Created by alvin on 2017/4/5.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
  /**
   * 定义教师信息数据库操作对象
   */
  @Resource
  private TeacherInfoDao teacherInfoDao;
  /**
   * 根据ID查询教师信息实现
   * @param teacherId
   * @return
   */
  public TeacherInfo selectTeacherById(String teacherId) {
    return teacherInfoDao.selectTeacherById(teacherId);
  }

  /**
   * 更新教师信息
   * @param teacherInfo
   */
  public void updateTeacherInfo(TeacherInfo teacherInfo){
    teacherInfoDao.updateTeacherInfo(teacherInfo);
  }

  /**
   * 查询所有教师信息
   * @return
   */
  public List<TeacherInfo> selectAllTeacherInfo() {
    return teacherInfoDao.selectAllTeacherInfo();
  }
}
