package common;

import org.junit.Test;

import java.io.IOException;

/**
 * jdk 类
 * Created by Yan Meng on 2016/10/9.
 */
public class JDKs {

    @Test
    public void testAvailableProcessors() throws IOException {
        Runtime runtime= Runtime.getRuntime();
        int availableProcessors = runtime.availableProcessors();
        System.out.println("可用处理器数量：" + availableProcessors);

        System.out.println("maxMemory" + runtime.maxMemory());
        System.out.println("totalMemory" + runtime.totalMemory());
        System.out.println("freeMemory" + runtime.freeMemory());
    }
}
