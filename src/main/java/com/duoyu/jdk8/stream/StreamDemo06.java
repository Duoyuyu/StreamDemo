package com.duoyu.jdk8.stream;

import com.duoyu.jdk8.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 数据收集到集合和数组
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo06 {
    public static void main(String[] args) {
        // collect 收集到集合中
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6).filter(integer -> integer > 3).collect(Collectors.toList());
        System.out.println(collect);

        ArrayList<Integer> collect1 = Stream.of(1,2,3,4,5,6).filter(i -> i > 2).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect1);

        // 结果收集到数组中
        // object 类型
        Object[] objects = Stream.of(1,2,3,4,5,6).filter(i -> i > 2).toArray();
        System.out.println(Arrays.toString(objects));
        // 指定类型
        Integer[] integers = Stream.of(1,2,3,4,5,6).toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));


    }
}
