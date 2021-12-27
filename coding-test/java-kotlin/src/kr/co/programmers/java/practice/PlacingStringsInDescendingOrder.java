package kr.co.programmers.java.practice;

import java.util.Arrays;

public class PlacingStringsInDescendingOrder {

    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            char[] sol = s.toCharArray();
            Arrays.sort(sol);
            return new StringBuilder(new String(sol)).reverse().toString();
        }
    }
}
