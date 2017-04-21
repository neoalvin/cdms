package edu.hitwh.cdms.service.impl;

import edu.hitwh.cdms.dao.AdminInfoDao;
import edu.hitwh.cdms.model.AdminInfo;
import edu.hitwh.cdms.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员信息数据操作实现类
 * Created by alvin on 2017/4/19.
 */
@Service
public class AdminServiceImpl implements AdminService {

  /**
   * 管理员数据Dao类
   */
  @Resource
  AdminInfoDao adminInfoDao;

  /**
   * 根据ID查询管理员信息
   * @param adminId
   * @return
   */
  public AdminInfo selectAdminInfoById(String adminId) {
    return adminInfoDao.selectAdminInfoById(adminId);
  }

  /**
   * 更新管理员信息
   * @param adminInfo
   */
  public void updateAdminInfo(AdminInfo adminInfo) {
    adminInfoDao.updateAdminInfo(adminInfo);
  }
}
