package kr.co.programmers.java.practice;

import java.util.Arrays;

public class AddDigits {

    public static void main(String[] args) {
        int n = 123;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            return Arrays.stream(String.valueOf(n).split(""))
                    .map(Integer::parseInt)
                    .mapToInt(x -> x)
                    .sum();
        }
    }
}
