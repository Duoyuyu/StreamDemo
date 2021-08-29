package com.duoyu.jdk8.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Description Stream 获取的方式一
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        // Collection接口默认有Stream接口
        List<String> list = new ArrayList<>();
        Stream<String> stream3 = list.stream();
        Set<String> set = new HashSet<>();
        Stream<String> stream4 = set.stream();
        Vector vector = new Vector();
        Stream stream5 = vector.stream();

        // Map 并没有实现Collection接口，用如下方式实现
        Map<String, Object> map = new HashMap();
        Stream<Map.Entry<String, Object>> stream = map.entrySet().stream(); // entry
        Stream<String> stream1 = map.keySet().stream(); // key
        Stream<Object> stream2 = map.values().stream(); // value

        // Demo
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a",4);
        map1.put("b",5);
        map1.put("c",6);
        map1.put("d",7);
        map1.put("f",8);
        map1.entrySet().stream().filter(o -> o.getValue() > 5)
                .forEach(System.out::println);
    }
}
