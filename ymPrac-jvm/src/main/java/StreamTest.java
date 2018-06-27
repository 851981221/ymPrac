import org.assertj.core.util.Lists;

import sun.net.www.content.text.PlainTextInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream demo
 */
public class StreamTest {

    private static final List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();

        streamTest.test1();
        streamTest.test2();
        streamTest.test5();
    }

    private void test1() {
        List<Integer> collect = list.parallelStream()
                .filter(i -> i % 2 == 0)
                .sorted(Comparator
                        .comparing(Integer::intValue)
                        .reversed()
                )
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private void test2() {
        int sum = list.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i.intValue())
                .sum();
        System.out.println(sum);
    }

    private void test3() {
        Stream<String> stream = Stream.of("1", "2", "3");

        Stream<Integer> integerStream = Stream.of(1, 3, 4);

        String [] arrays = new String[] {"1", "23"};
        Stream<String> arrays1 = Stream.of(arrays);
        Stream<String> stream1 = Arrays.stream(arrays);

        Stream<Integer> stream2 = list.stream();
    }

    // stream for number class
    private void test4() {
        // performace better!
        IntStream of = IntStream.of(1, 2, 3);

        IntStream.of(1, 2, 3, 4).forEach(System.out::println);
        IntStream.range(1, 100).forEach(System.out::println);

        IntStream.rangeClosed(1, 100).forEach(System.out::println);
        Stream<Integer> stream = list.stream();
    }

    private void test5() {
        Stream<String> stream = Stream.of("1", "2", "3");
//        String[] objects = stream.toArray(String[] :: new);
//
//        List<String> collect = stream.collect(Collectors.toList());
//        ArrayList<String> collect2 = stream.collect(Collectors.toCollection(ArrayList::new));
//        Set<String> collect1 = stream.collect(Collectors.toSet());
//        Stack<String> collect3 = stream.collect(Collectors.toCollection(Stack::new));

        String s = stream.collect(Collectors.joining()).toString();
        System.out.println(s);
    }




}
