package com.company;
import com.algos.Zigzag;
import com.data.Item;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
//        var strm = Stream.of("anil".toCharArray());
//        var maxCHar = "anil".toCharArray()
//        //).map(ch -> (int)ch).max().getAsInt();



//        var cardinalities = Stream.of("dvdf")
//                .flatMapToInt(String::chars)
//                .map(i -> {
//                    if (hashMap.containsKey(i)) {
//                        hashMap.clear();
//                    }
//                    hashMap.put(i, );
//                    return hashMap.size();
//                });
//
//        var val = cardinalities
//                .max().orElse(0);

        var s = new Zigzag();
        var x = s.convert("PAYPALISHIRING", 3);

        var l = Stream
                .iterate(new ArrayList<List<Integer>>(),
                        a -> a.size() < 5,
                        a -> {
                            a.add(Arrays.asList(1, 2, 3, 4, 5, 6));
                            return a;
                        })
                .peek(a -> System.out.println(a))
                //.collect(Collectors.toList())
                //.stream().
                .flatMap(List::stream)
                .collect(Collectors.toList());

        var l1 = (Collections.singletonList(Arrays.asList(1, 2, 3, 4)))
                .stream()
        .flatMap(List::stream)
                .collect(Collectors.toList());

        var l2 = Stream
                .iterate(new ArrayList<Integer>(),
                        lst -> {
                            lst.add(1);
                            return lst;
                        })
                .limit(5)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(Stream
                .iterate(0, i -> i< 10, i -> i + 1)
                .collect(Collectors.toList()));

        System.out.println(Stream
                .iterate(0, i -> i< 10, i -> i + 1)
                .reduce(0, (c, i) -> c + i));

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.commonPool());
        System.out.println(ForkJoinPool.commonPool().getParallelism());

        var numbers = Stream.iterate(1, i -> i +1).limit(20);
        numbers.parallel()
                .map(e -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(e + " " + Thread.currentThread());
                    return e;
                })
                .forEach(e -> {});

        Stream.iterate(0, i -> i+1)
                .map(i -> new Item)
    }

}
