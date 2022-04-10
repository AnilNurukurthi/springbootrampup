package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var batchSize = 10;
//        var list = Stream
//                .iterate(1, i -> i +1)
//                .limit(100)
//                .collect(Collectors.partitioningBy( i-> i batchSize, Collectors.toList() ))
//                .values();

        var array = Stream
                .iterate(1,  i -> i + 1)
                .limit(105)
                .collect(Collectors.toList());

        var listOfLIsts = new ArrayList<List<Integer>>();
        System.out.println(array.size()/batchSize);

        for(int currentIndex =0; currentIndex < array.size(); currentIndex = currentIndex + batchSize) {
            System.out.println(currentIndex + " " + batchSize);

            var lastIndex = array.size() > currentIndex + batchSize ? currentIndex + batchSize : array.size() -1; ;
            var subList = array.subList(currentIndex, lastIndex);
            listOfLIsts.add(subList);
        }

        System.out.println(listOfLIsts);
    }
}
