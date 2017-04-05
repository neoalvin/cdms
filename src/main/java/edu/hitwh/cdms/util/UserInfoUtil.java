package edu.hitwh.cdms.util;

import edu.hitwh.cdms.model.RetCode;
import edu.hitwh.cdms.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用户操作公共方法类
 * @author alvin
 * Created by alvin on 2017/4/5.
 */
public class UserInfoUtil {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoUtil.class);

  /**
   * MD5加密
   * @param str
   * @return
   * @throws NoSuchAlgorithmException
   * @throws UnsupportedEncodingException
   */
  public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

    LOGGER.info("[UserInfoUtil]: Encode the password start.");

    //确定计算方法
    MessageDigest md5=MessageDigest.getInstance("MD5");
    BASE64Encoder base64en = new BASE64Encoder();

    //加密后的字符串
    return base64en.encode(md5.digest(str.getBytes("utf-8")));
  }

  /**
   * 通过用户名和密码校验用户
   * @return
   */
  public static RetCode checkUserByIdAndPassword(UserInfo userInfo){
    LOGGER.info("[UserInfoUtil]: Check user information start. userId= " + userInfo.getUserId());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    return retCode;
  }
}
