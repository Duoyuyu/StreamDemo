package com.duoyu.jdk8.stream;


import java.util.stream.Stream;

/**
 * @Description Stream 获取方式二
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo03 {
    public static void main(String[] args) {
        // 数组类型，Stream提供了of方法
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        Integer[] arr = {1,2,3,4};
        Stream<Integer> arr1 = Stream.of(arr);
        arr1.forEach(System.out::println);
        int[] arr2 = {1,2,3,4};
        Stream<int[]> arr3 = Stream.of(arr2);
        arr3.forEach(System.out::println);// [I@682a0b20,不支持对基本数据类型

    }
}
