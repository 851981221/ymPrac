import org.assertj.core.util.Lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        streamTest.test6();
        streamTest.test7();
        streamTest.test8();
        streamTest.test9();
        streamTest.test10();
        streamTest.test11();
        streamTest.test12();
        streamTest.test13();
        System.out.println("---------test14");
        streamTest.test14();
        streamTest.test15();
        streamTest.test16();
        streamTest.test17();

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
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);
    }

    private void test3() {
        Stream<String> stream = Stream.of("1", "2", "3");

        Stream<Integer> integerStream = Stream.of(1, 3, 4);

        String[] arrays = new String[]{"1", "23"};
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

    private void test6() {
        long count = list.stream().map(i -> i++).count();
        System.out.println(count);
    }

    private void test7() {
        Integer integer = list.stream().map(i -> i++).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(integer);
    }

    private void test8() {
        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6, 8)
        );

        Stream<Integer> integerStream = listStream.flatMap(Collection::stream);
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(collect);
    }

    private void test9() {
//        list.forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);
    }

    private void test10() {
        Stream.of("one", "tow", "three", "four")
                .filter(s -> s.length() > 3)
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .peek(s -> System.out.println("---"))
                .forEach(System.out::println);

    }

    private void test11() {
        Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));

        String s = "";
        Optional.ofNullable(s).ifPresent(System.out::println);
    }

    private void test12() {
        // 字符串连接，concat = "ABCD"
        String str1 = Stream.of("A", "b", "c", "d").reduce(String::concat).get();
        String str2 = Stream.of("A", "B", "C", "D").reduce("---", String::concat);
        System.out.println(str1);
        System.out.println(str2);

        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        String concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }

    private void test13() {
        // map limit
        List<Person> persons = Lists.newArrayList();
        IntStream.rangeClosed(1, 1000)
                .forEach(
                        i -> persons.add(new Person(i, "name" + i))
                );
        List<String> personList2 = persons.stream()
                .map(Person::getName)
                .limit(10)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(personList2);
    }

    private void test14() {
        // sorted method
        List<Person> persons = Lists.newArrayList();
        IntStream.rangeClosed(1, 5).forEach(
                i -> {
                    System.out.println(i);
                    persons.add(new Person(i, "name" + i));
                }
        );
        List<Person> personList2 = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(personList2);
    }

    private void test15() {
        List<Person> persons = Lists.newArrayList();
        IntStream.rangeClosed(1, 5).forEach(
                i -> persons.add(new Person(i, "name" + i))
        );
        List<Person> personList2 = persons.stream()
                .limit(2)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        System.out.println(personList2);
    }

    private void test16() {
        List<String> words;
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\SUService.log"))) {
            int longest = br.lines()
                    .mapToInt(String::length)
                    .max()
                    .getAsInt();
            System.out.println(longest);

            // use distinct 来找出不重复的单词。
            words = br.lines()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.length() > 0)
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(words);
        } catch (Exception e) {

        }
    }

    private void test17() {
        List<Person> persons = Lists.newArrayList();
        persons.add(new Person(1, "name" + 1, 10));
        persons.add(new Person(2, "name" + 2, 21));
        persons.add(new Person(3, "name" + 3, 34));
        persons.add(new Person(4, "name" + 4, 6));
        persons.add(new Person(5, "name" + 5, 55));

        boolean isAllAdult = persons.stream()
                .allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = persons.stream().
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
    }

}

class Person {
    private int no;
    private String name;
    private int age;

    public Person(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Person(int i, String s, int age) {

    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public int getAge() {
        return age;
    }
}