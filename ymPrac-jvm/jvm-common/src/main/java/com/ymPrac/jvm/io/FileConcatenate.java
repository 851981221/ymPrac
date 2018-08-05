package com.ymPrac.jvm.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 链接流
 * 所谓链接流就是就多次对流的封装，这样能更好的操作个管理数据
 * 比如我们利用DataInputStream（BufferedInputStream(FileInputStream)）将字节流层层包装后
 * Created by Yan Meng on 2017/9/25.
 */
public class FileConcatenate {

    /**
     * 包装类进行文件级联操作
     */
    public static void main(String[] args) {
        try {
            concennateFile(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void concennateFile(String... fileName) throws IOException {
        String str;
        //构建对该文件您的输入流
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:/David/Java/java 高级进阶/files/copy2.txt"));
        for (String name : fileName) {
            BufferedReader reader = new BufferedReader(new FileReader(name));

            while ((str = reader.readLine()) != null) {
                writer.write(str);
                writer.newLine();
            }
        }
    }
}
