package com.algos;

import java.util.HashMap;

public class LongestCommonSubseq {
    public int getLongest() {
        var hashMap = new HashMap<Character, Integer>();
        var s = "dvdf";
        var maxSubSeq = 0;
        for(int i = 0; i< s.length(); i++){
            var curChar = s.charAt(i);
            if (hashMap.containsKey(curChar)) {
                var prevCharIndex = hashMap.get(curChar);
                hashMap.entrySet().removeIf(e -> e.getValue() <= prevCharIndex);
            }
            hashMap.put(curChar, i);
            maxSubSeq = Math.max(maxSubSeq, hashMap.size());
        }

        return maxSubSeq;
    }
}
