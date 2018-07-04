package com.curves.framework.commons.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 * @author vic
 */
public class FileUtil {

    /**
     * 创建文件夹
     * @param folderPath 文件夹路径
     * @throws IOException IO异常
     */
    public static void createFolder(String folderPath) throws IOException {
        FileUtils.forceMkdir(new File(folderPath));
    }


    /**
     * 创建包文件夹路径
     * @param projectPath 项目路径
     * @param packagePath 包路径
     * @throws IOException IO异常
     */
    private static void createSrcPath(String projectPath, String packagePath) throws IOException {
        packagePath = packagePath.replaceAll(".","/");
        createFolder(projectPath + packagePath);
    }


    /**
     * 创建包文件夹路径
     * @param projectPath 项目路径
     * @param packagePath 包路径
     * @throws IOException IO异常
     */
    private static void createResourcePath(String projectPath, String packagePath) throws IOException {
        packagePath = packagePath.replaceAll(".","/");
        createFolder(projectPath + packagePath);
    }


}
