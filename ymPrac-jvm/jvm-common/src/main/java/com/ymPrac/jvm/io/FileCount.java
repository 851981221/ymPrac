package com.ymPrac.jvm.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节流
 * FileInputStream
 * Created by Yan Meng on 2017/9/25.
 */
public class FileCount {

    /**
     * 我们写一个检测文件长度的小程序，别看这个程序挺长的，你忽略try catch块后发现也就那么几行而已。
     */
    public static void main(String[] args) {
        int count = 0;  //统计文件字节长度
        try(InputStream streamReader = new FileInputStream(new File("F://create.txt"))) {
              /**
               * 1.new File()里面的文件地址也可以写成F://create.txt,前一个\是用来对后一个进行转换的，
               * FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
               */
            while (streamReader.read() != -1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }

            //read(byte[] b) 使用缓冲区读取 减少操作次数
            byte[] b = new byte[20];
            while (streamReader.read(b) != -1) {
                count ++;
            }
            System.out.println("---长度是： " + count + " 字节");
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            //已经在try()里面回收了
        }
    }
}
