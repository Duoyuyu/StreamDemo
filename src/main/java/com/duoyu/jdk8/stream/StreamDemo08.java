package com.duoyu.jdk8.stream;

import com.duoyu.jdk8.domain.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 分组操作
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo08 {
    public static void main(String[] args) {
        // 根据姓名进行分组
        Stream<Person> personStream = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        Map<String, List<Person>> map = personStream.collect(Collectors.groupingBy(Person::getName));
        map.forEach((k, v) -> System.out.println(k+v));
        // 根据年龄进行分组，大于18岁一组
        Stream<Person> personStream2 = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        Map<String, List<Person>> map1 = personStream2.collect(Collectors.groupingBy(p -> p.getAge() > 18 ? "成年" : "未成年"));
        map1.forEach((k,v) -> System.out.println(k+v));
        // 先根据姓名分组，在根据年龄分组
        Stream<Person> personStream3 = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        Map<String, Map<String, List<Person>>> map2 = personStream3.collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(p -> p.getAge() > 18 ? "成年" : "未成年")));
        map2.forEach((k, v) -> System.out.println(k + v));
    }
}
