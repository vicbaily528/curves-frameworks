package com.curves.framework.commons.utils;


import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

/**
 * 模板工具
 * @author vic
 */
public class FreemarkerUtils {

    private FreemarkerUtils(){}

    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static{
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreemarkerUtils.class, "/templates"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    private static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * 清楚文件生成产生的缓存
     */
    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    /**
     * 生成文件
     * @param templateName 模板名称
     * @param file 文件名称
     * @param dataMap 数据对象
     * @throws Exception 异常处理
     */
    public static void generateFile(final String templateName, File file, Map<String,Object> dataMap) throws Exception{
        Template template = FreemarkerUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }

}
