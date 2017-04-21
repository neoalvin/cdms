package edu.hitwh.cdms.dao;

import edu.hitwh.cdms.model.AdminInfo;
import org.springframework.stereotype.Repository;

/**
 * 管理员信息数据操作类
 * Created by alvin on 2017/4/19.
 */
@Repository
public interface AdminInfoDao {
  public AdminInfo selectAdminInfoById(String adminId);
  public void updateAdminInfo(AdminInfo adminInfo);
}
