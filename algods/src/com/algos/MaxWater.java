package com.algos;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxWater {
    public int maxArea(int[] height) {

        var maxArea = 0;

        for(int i =0; i< height.length; i++) {
            var currentHeight = height[i];
            var leftHeight = Arrays.stream(height)
                    .limit(i)
                    .filter(h -> h >= currentHeight)
                    .findFirst().orElse(-1);
            var currIndx = i;
            var rightHeight = Stream
                    .iterate(height.length -1, indx -> indx-1)
                    .takeWhile(indx -> indx > currIndx)
                    .filter(h -> h >= currentHeight)
                    .findFirst().orElse(-1);

            maxArea = Collections.max(Arrays.asList(maxArea, currentHeight * leftHeight, currentHeight * rightHeight));
        }

        return maxArea;

    }
}
