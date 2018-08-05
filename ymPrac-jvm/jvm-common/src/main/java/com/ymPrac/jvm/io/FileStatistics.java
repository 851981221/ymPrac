package com.ymPrac.jvm.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 文件关键词 统计
 * @author Yan Meng
 * @date 2018/5/22
 */
public class FileStatistics {

    public static void main(String[] args) {
        long total = 0;
        long lianjia = 0;
        long deyou = 0;
        long allNone = 0L;
        long deyouTraficCount = 0L;

        long allCount = 0L;
        long allCountNone = 0L;
        long deyouAll = 0L;
        long deyouNone = 0L;

        File file = new File("F:\\广告系统\\c-API\\统计\\server_20180522.log");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.contains("trafficDistribute result") && line.contains("370100")) {
                    total ++;

                    if (!line.contains("lianjia count: 0")) {
                        lianjia ++;
                    }
                    if (!line.contains("deyou count: 0")) {
                        deyou ++;
                    }
                    if (line.contains("lianjia count: 0") && line.contains("deyou count: 0")) {
                        allNone ++;
                    }

                    int index = line.indexOf("houseCode: ");
                    String houseCode = line.substring(index + 11, index + 23);
                    int hash = HashUtils.hash(houseCode + 144);
                    if (hash < 19) {
                        System.out.println(houseCode);
                        deyouTraficCount ++;
                    }
                }

                if (line.contains("370100")) {
                    if (line.contains("DisplayAgent API") && !line.contains("total:0")) {
                        allCount ++;
                    }
                    if (line.contains("DisplayAgent API") && line.contains("total:0")) {
                        allCountNone ++;
                    }
                }

                if (line.contains("DeyouAgentHandler") && line.contains("getDisplayAgents") && line.contains("size:0")) {
                    deyouNone ++;
                }
                if (line.contains("DeyouAgentHandler") && line.contains("getDisplayAgents") && !line.contains("size:0")) {
                    deyouAll ++;
                }

            }
        } catch (Exception e) {
            System.out.println("ERROR!!!" + e);
        }

        System.out.println("大连: ");
        System.out.println("total:  " + total);
        System.out.println("lianjia:  " + lianjia);
        System.out.println("deyou:  " + deyou);
        System.out.println("all none: " + allNone);
        System.out.println("deyou trafic count: " + deyouTraficCount);

        System.out.println("===========================");
        System.out.println("all count: " + allCount);
        System.out.println("all count none: " + allCountNone);
        System.out.println("deyou all: " + deyouAll);
        System.out.println("deyouNone:  " + deyouNone);

    }

    /**
     * hash 工具
     */
    static class HashUtils {

        /**
         * 获取hash的最后两位
         * @param key   原始字符串
         * @return      两位整数
         */
        static int hash(String key) {
            int hash = FNVHash1(key);
            return Math.abs(hash - hash / 100 * 100);
        }

        /**
         * FNV-1 算法
         * reason：稳定，随机，无序，性能
         * @param data  字符串
         * @return      int值，有符号
         */
        static int FNVHash1(String data) {
            final int p = 16777619;
            int hash = (int) 2166136261L;
            for (int i = 0; i < data.length(); i++)
                hash = (hash ^ data.charAt(i)) * p;
            hash += hash << 13;
            hash ^= hash >> 7;
            hash += hash << 3;
            hash ^= hash >> 17;
            hash += hash << 5;
            return hash;
        }
    }
}
