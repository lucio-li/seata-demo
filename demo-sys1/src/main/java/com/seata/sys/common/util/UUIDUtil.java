package com.seata.sys.common.util;

import java.util.UUID;

/**
 * 描述:
 *
 * @author Yangjinming
 * @create 2018-03-28 上午11:17
 */
public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
      }
}
