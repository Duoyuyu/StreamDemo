package com.duoyu.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 初识Stream小应用
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo01 {

    public static void main(String[] args) {
        // 要求1、过去姓周
        // 2、姓名长度为3
        // 3、遍历输出
        List<String> list = Arrays.asList("周杰伦","周杰","高圆圆","林俊杰");
        // 获取姓周长度为3的，并且输出
        List<String> list1 = new ArrayList();
        list.forEach(s -> {
            if(s.startsWith("周")){
                list1.add(s);
            }
        });

        List<String> list2 = new ArrayList<>();

        list1.forEach(s -> {
            if(s.length() == 3){
                list2.add(s);
            }
        });

        list2.forEach( s -> System.out.println("List操作：" + s));

        // Stream流式思想 ，和IO无关，是一种思想
        // 不是数据结构，不存储数据，只是对数据进行加工，是流水线上的工序
        // 针对集合、数组进行操作

        // Stream流式写法
        list.stream().filter(s -> s.startsWith("周"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);// 方法引用
    }
}
