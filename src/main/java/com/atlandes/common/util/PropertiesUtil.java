package com.atlandes.common.util;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by XD.Wang on 2017/6/6.
 * 配置文件提取
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {
    }

    private static Properties getProperties(String propertiesName) {
        String propertiesPath = getConfigPath(propertiesName);
        return createProperties(propertiesPath);
    }

    private static String getConfigPath(String propertiesName) {
        return PropertiesUtil.class.getResource(propertiesName).getPath().replaceAll("%20", " ");
    }

    private static Properties createProperties(String fullName) {
        try {
            File file = new File(fullName);
            Properties properties = new Properties();
            properties.load(Files.newReader(file, Charset.forName("utf-8")));
            return properties;
        } catch (Exception var3) {
            logger.error(var3.getMessage(), var3);
            return null;
        }
    }

    public static String getPropertiesByKey(String propertiesName, String key) {
        return getProperties(propertiesName).getProperty(key);
    }

    public static String getMercuryBaseUrl(){
        String ENV_PROPERTIES = "/config/env.properties";
        return getPropertiesByKey(ENV_PROPERTIES, "baseUrl");
    }

}
