package com.duoyu.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description Stream 常用方法一
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo04 {
    // Stream 为流式方法，不可逆
    // 不调用终结方法，Stream不执行   count，forEach,match,collect....为常用终结方法
    // 调用终结方法不可以再执行任何操作
    public static void main(String[] args) {
        List<String> list = Arrays.asList("周杰伦","周杰","高圆圆","林俊杰");
        list.stream().filter(s -> {
            System.out.println("-------------");
            return s.length()==2;
        });// 不会执行，因为未调用终结方法

        list.stream().filter(s -> {
            System.out.println("========");
            return s.length() == 2;
        }).count();// 会执行

        Stream<String> stream = list.stream();
        stream.count();
        stream.filter(s -> s.length()==2);// 报错，因为已执行count终结方法

    }
}
