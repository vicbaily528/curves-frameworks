package com.curves.framework.commons.utils;

import com.curves.framework.commons.constant.PatternConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author vic
 */
public class StringUtils {

    /**
     * 数据库字段转换成驼峰字段
     * @param source 数据库字段
     * @param isBig  是否首字母大写
     * @return String 大写驼峰字段
     */
    public static final String toHump(String source, boolean isBig) {
        if (source == null || "".equals(source)) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        Pattern pattern = Pattern.compile(PatternConstant.HUMP_PATTERN);
        Matcher matcher = pattern.matcher(source);
        //匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            if (matcher.start() == 0 && !isBig) {
                buffer.append(Character.toLowerCase(word.charAt(0)));
            } else {
                buffer.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                buffer.append(word.substring(1, index).toLowerCase());
            } else {
                buffer.append(word.substring(1).toLowerCase());
            }
        }
        return buffer.toString();
    }
}
