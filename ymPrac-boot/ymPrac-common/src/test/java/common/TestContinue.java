package common;

/**
 * Created by Yan Meng on 2016/9/6.
 */
public class TestContinue {

    public static void main(String[] args) {
        int a = 1;
        for (int i=1; i<10; i++) {
            if (a != 0) {
                int b = 1;
                if (b == 1) {
                    continue;
                }
            }
        }
        System.out.println("aaaaaaaaaaa");
    }
}
