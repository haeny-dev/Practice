package kr.co.programmers.practice;

import java.util.Arrays;

public class MaximumAndMinimum {

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(new Solution().solution2(s));
    }

    static class Solution {
        public String solution(String s) {
            int[] arr = Arrays.stream(s.split(" ")).mapToInt(x -> Integer.parseInt(x)).sorted().toArray();
            return arr[0] + " " + arr[arr.length -1];
        }

        public String solution2(String s){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (String str : s.split(" ")) {
                int num = Integer.parseInt(str);

                if (num > max) {
                    max = num;
                }

                if (num < min) {
                    min = num;
                }
            }

            return min + " " + max;
        }
    }
}
