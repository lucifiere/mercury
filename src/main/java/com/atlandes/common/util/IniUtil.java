package com.atlandes.common.util;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 有序读取 ini配置文件
 * Created by XD.Wang on 2017/6/15.
 */
public class IniUtil {

    /**
     * 用linked hash map 来保持有序的读取
     */
    final LinkedHashMap<String, LinkedHashMap<String, String>> coreMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
    /**
     * 当前Section的引用
     */
    String currentSection = null;

    /**
     * 读取
     *
     * @param file 文件
     * @throws FileNotFoundException FileNotFoundException
     */
    public IniUtil(File file) throws FileNotFoundException {
        this.init(new BufferedReader(new FileReader(file)));
    }

    /***
     * 重载读取
     * @param path 给文件路径
     * @throws FileNotFoundException FileNotFoundException
     */
    public IniUtil(String path) throws FileNotFoundException {
        this.init(new BufferedReader(new FileReader(path)));
    }

    /***
     * 重载读取，若文件在resource里，可直接写new ClassPathResource("file name");
     * @param source ClassPathResource
     * @throws IOException IOException
     */
    public IniUtil(ClassPathResource source) throws IOException {
        this(source.getFile());
    }

    void init(BufferedReader bufferedReader) {
        try {
            read(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO Exception:" + e);
        }
    }

    /**
     * 读取文件
     *
     * @param reader reader
     * @throws IOException IOException
     */
    void read(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            parseLine(line);
        }
    }

    /**
     * 转换
     *
     * @param line line
     */
    void parseLine(String line) {
        line = line.trim();
        // 此部分为注释
        if (line.matches("^#.*$")) {

        } else if (line.matches("^\\[\\S+]$")) {
            // section
            String section = line.replaceFirst("^\\[(\\S+)]$", "$1");
            addSection(section);
        } else if (line.matches("^\\S+=.*$")) {
            // key ,value
            int i = line.indexOf("=");
            String key = line.substring(0, i).trim();
            String value = line.substring(i + 1).trim();
            addKeyValue(currentSection, key, value);
        }
    }


    /**
     * 增加新的Key和Value
     *
     * @param currentSection currentSection
     * @param key            key
     * @param value          value
     */
    void addKeyValue(String currentSection, String key, String value) {
        if (!coreMap.containsKey(currentSection)) {
            return;
        }
        Map<String, String> childMap = coreMap.get(currentSection);
        childMap.put(key, value);
    }


    /**
     * 增加Section
     *
     * @param section section
     */
    void addSection(String section) {
        if (!coreMap.containsKey(section)) {
            currentSection = section;
            LinkedHashMap<String, String> childMap = new LinkedHashMap<String, String>();
            coreMap.put(section, childMap);
        }
    }

    /**
     * 获取配置文件指定Section和指定子键的值
     *
     * @param section section
     * @param key     key
     * @return
     */
    public String get(String section, String key) {
        if (coreMap.containsKey(section)) {
            return get(section).getOrDefault(key, null);
        }
        return null;
    }


    /**
     * 获取配置文件指定Section的子键和值
     *
     * @param section section
     * @return 键和值
     */
    public Map<String, String> get(String section) {
        return coreMap.getOrDefault(section, null);
    }

    /**
     * 获取这个配置文件的节点和值
     */
    public LinkedHashMap<String, LinkedHashMap<String, String>> get() {
        return coreMap;
    }

}

