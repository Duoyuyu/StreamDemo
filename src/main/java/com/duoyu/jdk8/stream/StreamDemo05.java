package com.duoyu.jdk8.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description 常用方法二
 * @Author wangxc
 * @Date 2021/8/29
 */
public class StreamDemo05 {
    public static void main(String[] args) {
        // forEach
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        stream.forEach(System.out::println);
        // count
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);
        long count = stream2.count();
        System.out.println("大小为："+count);
        // filter
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4);
        stream3.filter(integer -> integer > 1).forEach(System.out::println);
        // limit
        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4);
        stream4.limit(2).forEach(System.out::println);
        // skip
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4);
        stream5.skip(2).forEach(System.out::println);
        // map 将流中的元素映射到另一个流中
        Stream<String> stream6 = Stream.of("a1", "b2", "c3", "f4");
        stream6.map(s -> s.substring(1)).forEach(System.out::println);
        // sorted
        Stream<Integer> stream7 = Stream.of(5, 3, 6, 4);
        stream7.sorted().forEach(System.out::println);// 默认升序
        Stream<Integer> stream8 = Stream.of(5, 3, 6, 4);
        stream8.sorted((o1,o2) -> o2-o1).forEach(System.out::println);// 自定义排序
        // distinct 基本数据类型可以直接去重，自定义类型需要重写equals和hashCode
        Stream<Integer> stream9 = Stream.of(5, 3, 6, 4, 3, 6, 8);
        stream9.distinct().forEach(System.out::println);
        // match
        Stream<Integer> stream10 = Stream.of(1,2,3,4);
        boolean b = stream10.allMatch(integer -> integer > 1);// 是否全部大于1
        System.out.println(b);
        Stream<Integer> stream11 = Stream.of(1,2,3,4);
        boolean b1 = stream11.anyMatch(integer -> integer > 1);// 是否有任意一个大于1
        System.out.println(b1);
        Stream<Integer> stream12 = Stream.of(1,2,3,4);
        boolean b2 = stream12.noneMatch(integer -> integer > 1);// 是否全部都不大于1
        System.out.println(b2);
        // find
        Stream<Integer> stream13 = Stream.of(1,2,3,4);
        Optional<Integer> first = stream13.findFirst();
        System.out.println(first.get());
        // 使用findAny()是为了更高效的性能。如果是数据较少，串行地情况下，一般会返回第一个结果
        Stream<Integer> stream14 = Stream.of(1,2,3,4);
        Optional<Integer> any = stream14.findAny();
        System.out.println(any.get());
        // 如果是并行的情况，那就不能确保是第一个
        Stream<Integer> stream15 = Stream.of(1,2,3,4);
        Optional<Integer> any1 = stream15.parallel().findAny();
        System.out.println(any1.get());
        // max min
        Stream<Integer> stream16 = Stream.of(1,2,3,4);
        Optional<Integer> min = stream16.min((o1, o2) -> o1 - o2);
        System.out.println(min.get());
        Stream<Integer> stream17 = Stream.of(1,2,3,4);
        Optional<Integer> max = stream17.max((o1, o2) -> o1 - o2);
        System.out.println(max.get());
        // reduce
        Stream<Integer> stream18 = Stream.of(1,2,3,4);
        Integer reduce = stream18.reduce(0, (x, y) -> {// identity 为默认值
            return x > y ? x : y;
        });
        System.out.println(reduce);
        // 统计字符a出现的次数
        Stream<String> stream19 = Stream.of("v", "a", "c", "a", "b");
        Integer reduce1 = stream19.map(sh -> "a".equals(sh) ? 1 : 0).reduce(0, Integer::sum);
        System.out.println(reduce1);
        // concat 静态方法
        Stream<String> stream20 = Stream.of("a", "b", "c");
        Stream<String> stream21 = Stream.of("d", "e", "f");
        Stream.concat(stream20, stream21).forEach(System.out::println);

    }
}
