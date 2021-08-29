package com.duoyu.jdk8.stream;

import com.duoyu.jdk8.domain.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 分区操作
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo09 {
    public static void main(String[] args) {
        // 根据年龄是否大于18分区
        Stream<Person> personStream = Stream.of(new Person("李四", 26),
                new Person("李四", 15),
                new Person("王五", 16),
                new Person("李四", 32),
                new Person("王五", 27));
        Map<Boolean, List<Person>> map = personStream.collect(Collectors.partitioningBy(p -> p.getAge() > 18));
        map.forEach((k, v) -> System.out.println(k.toString() + v));
    }
}
