package com.duoyu.jdk8.stream;

import com.duoyu.jdk8.domain.Person;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 聚合计算
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo07 {
    public static void main(String[] args) {
        // 获取年龄最大值
        Stream<Person> personStream = Stream.of(new Person("张三", 10),
                new Person("李四", 15),
                new Person("王五", 54),
                new Person("小六", 32),
                new Person("大七", 27));
        Optional<Person> maxAge = personStream.collect(Collectors.maxBy((o1, o2) -> o1.getAge() - o2.getAge()));
        System.out.println(maxAge);
        // 最小年龄
        Stream<Person> personStream2 = Stream.of(new Person("张三", 10),
                new Person("李四", 15),
                new Person("王五", 54),
                new Person("小六", 32),
                new Person("大七", 27));
        Optional<Person> minAge = personStream2.collect(Collectors.minBy((o1, o2) -> o1.getAge() - o2.getAge()));
        System.out.println(minAge);
        // 年龄求和
        Stream<Person> personStream3 = Stream.of(new Person("张三", 10),
                new Person("李四", 15),
                new Person("王五", 54),
                new Person("小六", 32),
                new Person("大七", 27));
        Integer sumAge = personStream3.collect(Collectors.summingInt(Person::getAge));
        System.out.println(sumAge);
        // 平均
        Stream<Person> personStream4 = Stream.of(new Person("张三", 10),
                new Person("李四", 15),
                new Person("王五", 54),
                new Person("小六", 32),
                new Person("大七", 27));
        Double avgAge = personStream4.collect(Collectors.averagingInt(Person::getAge));
        System.out.println(avgAge);
        // 总数
        Stream<Person> personStream5 = Stream.of(new Person("张三", 10),
                new Person("李四", 15),
                new Person("王五", 54),
                new Person("小六", 32),
                new Person("大七", 27));
        Long count = personStream5.collect(Collectors.counting());
        System.out.println(count);
    }
}
