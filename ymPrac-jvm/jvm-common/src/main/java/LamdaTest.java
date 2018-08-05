import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Yan Meng on 2017/8/10.
 */
public class LamdaTest {

    public static void main(String[] args) {
        //==================== thread =====================
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread runnable annon class!!!");
            }
        }).start();
        new Thread(() -> System.out.println("lamda thread !!!")).start();

        // ==================== 结合遍历 ==============================
        // Java 8之后：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "DateTest and Time API");
        features.forEach(n -> System.out.println(n));
        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);

        // ================= Predicate =====================
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);


        //====================== map reduce ==============================
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }
        // 使用lambda表达式
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);


        // ====================== map reduce 2 ================================
        // 为每个订单加上12%的税
        // 老方法：
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
        // 新方法：
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        // 创建一个字符串列表，每个字符串长度大于2
        // ! 关于 filter() 方法有个常见误解。在现实生活中，做过滤的时候，通常会丢弃部分，但使用filter()方法则是获得一个新的列表，且其每个元素符合过滤原则。
        List<String> filtered = languages.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", languages, filtered);


        //============================= 将字符串换成大写并用逗号链接起来 =============================
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        //============================== 用所有不同的数字创建一个正方形列表 ==========================
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);


        //============================== 获取数字的个数、最小值、最大值、总和以及平均值 ====================
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }



    //    private static void filter(List<String> names, Predicate<String> condition) {
//        for (String name : names) {
//            if (condition.test(name)) {
//                System.out.println(name + " ");
//            }
//        }
//    }
    // 更好的办法
    private static void filter(List<String> names, Predicate<String> condition) {
        names.stream()
                .filter((name) -> (condition.test(name)))
                .forEach((name) -> System.out.println(name + " "));
    }

    private static void filter2(List<String> names, Predicate<String> condition) {
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }
}

