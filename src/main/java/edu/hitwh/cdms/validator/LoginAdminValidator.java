package edu.hitwh.cdms.validator;

import edu.hitwh.cdms.model.AdminInfo;
import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

/**
 * 管理员登录校验类
 * Created by alvin on 2017/4/19.
 */
public class LoginAdminValidator {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LoginAdminValidator.class);

  /**
   * 校验管理员信息
   * @param adminInfo
   * @return
   */
  public static RetCode checkAdminInfo(AdminService adminService, AdminInfo adminInfo, HttpSession session){
    //定义返回信息对象
    RetCode retCode = new RetCode();

    LOGGER.warn("[LoginAdminValidator]: Check admin information start. adminId = " + adminInfo.getAdminId());

    try {
      //获取管理员信息
      AdminInfo adminInfoInDb = adminService.selectAdminInfoById(adminInfo.getAdminId());
      //若数据库中不存在信息
      if(null == adminInfoInDb){
        retCode.setCode("1");
        retCode.setMessage("管理员账号不存在！");
        LOGGER.warn("[LoginAdminValidator]: Check admin information error. retCode = " + retCode.toString());
        return retCode;
      }

      //密码错误
      if(!adminInfoInDb.getPwdCode().equals(adminInfo.getPwdCode())){
        retCode.setCode("1");
        retCode.setMessage("管理员密码错误！");
        LOGGER.warn("[LoginAdminValidator]: Check admin information error. retCode = " + retCode.toString());
        return retCode;
      }

      //登录验证通过，则将adminId存入session中
      session.setAttribute("adminId", adminInfo.getAdminId());

    }
    catch(Exception e){
      LOGGER.error("[LoginAdminValidator]: Check admin information error. retCode = " + e.toString());
    }
    return retCode;
  }
}
