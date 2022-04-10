package com.algos;

import java.util.Comparator;
import java.util.stream.IntStream;

class Solution {
    public String longestPalindrome(String s) {
        var center = 0;
        // for each center find the longest possible palindrome

        return IntStream.range(0, s.length())
                .parallel()
                .mapToObj(c ->
                {
                    var sb1 = new StringBuilder();
                    sb1.append(s.charAt(c));
                    var l = c-1;
                    var r = c+1;

                    var p1 = findPalindrome(s, l, r, sb1);

                    var sb2 = new StringBuilder();
                    l = c;
                    r = c +1;
                    var p2 = findPalindrome(s, l, r, sb2);

                    return p2.length() > p1.length() ? p2 : p1;
                })
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    public String findPalindrome(String s, int l, int r, StringBuilder sb){
        while(r < s.length() && l >= 0){
            if (s.charAt(l) == s.charAt(r)) {
                sb.insert(0, s.charAt(l));
                sb.append(s.charAt(r));
            }
            else{
                break;
            }
            l--;
            r++;

        }
        return sb.toString();
    }
}
