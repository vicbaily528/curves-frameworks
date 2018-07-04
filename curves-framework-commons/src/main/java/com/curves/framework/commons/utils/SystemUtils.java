package com.curves.framework.commons.utils;

/**
 * 系统工具
 * @author vic
 */
public class SystemUtils {


    /**
     * 获取项目根目录
     * @return String 根目录
     */
    public static String getProjectRootPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取项目路径
     * @param projectName 项目名称
     * @return String 项目路径名称
     */
    public static String getProjectPath(String projectName) {
        StringBuffer projectPath = new StringBuffer();
        projectPath.append(getProjectRootPath());
        projectPath.append("/");
        projectPath.append(projectName);
        projectPath.append("/");
        return projectPath.toString();
    }
}