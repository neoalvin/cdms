package edu.hitwh.cdms.util;

/**
 * 项目公共方法类
 * Created by alvin on 2017/4/6.
 */
public class CommonUtil {
  /**
   * 判断字符串是否为空
   * @param str
   * @return
   */
  public static boolean isStringEmpty(String str){
    return (null == str) || ("".equals(str));
  }
}
