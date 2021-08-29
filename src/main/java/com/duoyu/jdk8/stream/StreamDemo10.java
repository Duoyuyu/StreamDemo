package com.duoyu.jdk8.stream;

import com.duoyu.jdk8.domain.Person;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 拼接操作
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo10 {
    public static void main(String[] args) {
        // 根据姓名拼接
        Stream<Person> personStream = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        String name1 = personStream.map(Person::getName).collect(Collectors.joining());
        System.out.println(name1);

        Stream<Person> personStream2 = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        String name2 = personStream2.map(Person::getName).collect(Collectors.joining("-"));
        System.out.println(name2);

        Stream<Person> personStream3 = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        String name3 = personStream3.map(Person::getName).collect(Collectors.joining("-","#","$"));
        System.out.println(name3);
    }
}
