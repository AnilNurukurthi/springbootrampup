package com.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zigzag {
    public String convert(String s, int numRows) {
        // take a row of queues and insert chars accordingly
        var rows = IntStream
                .range(0, numRows)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> new ArrayList<Character>()));

        var zig = true;
        var zag = false;
        var curRow = 0;

        for (var ch : s.toCharArray()) {
            if (zig) {
                rows.get(curRow).add(ch);
                if (curRow == rows.size() -1) {
                    zig = false;
                    zag = true;
                    curRow--;
                }
                else {
                    curRow++;
                }
            } else {
                rows.get(curRow).add(ch);
                if (curRow == 0) {
                    zag = true;
                    zig = false;
                    curRow++;
                }
                else {
                    curRow--;
                }
            }
        }

        System.out.println(rows.values());
        return rows
                .values()
                .stream()
                .flatMap(List::stream)
                .map(ch -> ch.toString())
                .collect(Collectors.joining());
    }

    /*public static void Main(String[] args){
        var s = new ZigZag();
        var x = s.convert("PAYPALISHIRING", 3);
    }*/
}

