package edu.hitwh.cdms.service;

import edu.hitwh.cdms.model.AdminInfo;

/**
 * 管理员信息数据操作类
 * Created by alvin on 2017/4/19.
 */
public interface AdminService {
  AdminInfo selectAdminInfoById(String adminId);
  void updateAdminInfo(AdminInfo adminInfo);
}
