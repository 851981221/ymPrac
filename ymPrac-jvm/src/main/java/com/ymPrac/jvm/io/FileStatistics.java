package com.ymPrac.jvm.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件关键词 统计
 * @author Yan Meng
 * @date 2018/5/22
 */
public class FileStatistics {

    public static void main(String[] args) {
        Map<String, Long> statistics = new HashMap<>();

        File file = new File("C:\\Users\\Yan Meng\\Desktop\\xss.2018-05-21.log");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.length() < 15 || !line.contains("2018-05-21")) {
                    continue;
                }
                String key = line.substring(0, 14);
                Long count = statistics.get(key);

                if (count == null) {
                    count = 0L;
                }

//                if (line.contains("das sync data is")) {
//                    count ++;
//                }
                count ++;
                statistics.put(key, count);
            }
        } catch (Exception e) {
            System.out.println("ERROR!!!" + e);
        }

        for (String key : statistics.keySet()) {
            System.out.println(key + ": --" + statistics.get(key));
        }
    }
}
