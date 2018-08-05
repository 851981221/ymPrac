/**
 * 测试脚本
 * Created by Yan Meng on 2017/7/5.
 */

class TestScript {
    static String output(def str){
        println str;
        Date d = new Date();

        return "hello"+str + d.getTime();
    }
}