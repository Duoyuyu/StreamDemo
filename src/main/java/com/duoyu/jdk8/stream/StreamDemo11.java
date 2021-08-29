package com.duoyu.jdk8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description 并行流
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo11 {
    public static void main(String[] args) {
        // 串行流 ， 同一个线程
        Stream.of(1, 2, 3, 4, 5, 6).filter(integer -> {
            System.out.println(Thread.currentThread());
            return integer > 1;
        }).count();
        // 并行流 ，多个线程处理，有数据安全问题
        Stream.of(1, 2, 3, 4, 5, 6).parallel(). // 将流转为并行流
                filter(integer -> {
            System.out.println(Thread.currentThread());
            return integer > 1;
        }).count();

        // 数据安全问题复现
        List list = new ArrayList<>();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            list.add(i);
        });
        System.out.println(list.size());
        // 数据安全   加同步锁方案
        List list2 = new ArrayList<>();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            synchronized (list2){
                list2.add(i);
            }
        });
        System.out.println(list2.size());
        // 数据安全   使用安全容器方案
        Vector vector = new Vector<>();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            synchronized (vector){
                vector.add(i);
            }
        });
        System.out.println(vector.size());
        // 数据安全   使用安全容器2
        List list3 = new ArrayList<>();
        List list4 = Collections.synchronizedList(list3);
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            synchronized (list4){
                list4.add(i);
            }
        });
        System.out.println(list4.size());
        // 数据安全 使用collect
        List<Integer> collect = IntStream.rangeClosed(1, 1000).parallel().boxed().collect(Collectors.toList());
        System.out.println(collect.size());
    }
}
