package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan Meng on 2016/8/19.
 */
public class List2ArraYsTRING {

    private static List<Long> subList;

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        list.add(11111111L);
        list.add(333333333L);
        list.add(5555555555L);
        list.add(5555555555L);
        list.add(5555555555L);
        list.add(5555555555L);
        list.add(5555555555L);

        list2.add(11111111L);
        list2.add(333333333L);

        int size = list.size();
        int sub = size / 7;

        System.out.println(sub);


//        System.out.println(list);
////        list.retainAll(list2);
//        System.out.println(list2);
//
//        List<String> listStr = new ArrayList<>();
//        listStr.add("aaaaaaaaaaaaaaa");
//        listStr.add("aaaaaaaaaaaaaaa");
//        listStr.add("aaaaaaaaaaaaaaa");

//        System.out.println(listStr);
//        String str = list.toString().replace(" ", "");
//        System.out.println(str);
//        String replace = str.replace(" ", "");
//        System.out.println(replace);

        // List addAll ----NULL POINT
//        List<Long> subList = null;
//
//        list.addAll(subList);

//        System.out.println("================================================");
//        System.out.println(list.size());
//        if (list.size() > 5) {
//            list = list.subList(0, 5);
//        }
//        System.out.println(list.size());

    }
}
