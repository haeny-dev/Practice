package kr.co.programmers.practice;

import java.util.Arrays;

public class MaximumAndMinimum {

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            int[] arr = Arrays.stream(s.split(" ")).mapToInt(x -> Integer.parseInt(x)).sorted().toArray();
            return arr[0] + " " + arr[arr.length -1];
        }
    }
}
