package com.seata.sys.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 描述: 字符串处理工具类
 *
 * @author Yangjinming
 * @create 2018-03-28 上午11:29
 */
public class StringUtilExt extends StringUtils{
    /**
     * 替换json字符串中存在的特殊字符 (json字符串中有特殊字符会在页面转成json对象时报错)
     * @param jsonStr json字符串
     * @return
     */
    public static String replaceSepStrForJson(String jsonStr){
        jsonStr = jsonStr.replaceAll("\'", "\\\\\'");
        jsonStr = jsonStr.replaceAll("\\\\\"", "\\\\\\\\\"");
        jsonStr = jsonStr.replaceAll("\\\\r\\\\n", "\\\\\\\\r\\\\\\\\n");
        jsonStr = jsonStr.replaceAll("\\\\t", "\\\\\\\\t");
        return jsonStr;
    }
}
