package kr.co.programmers.practice;

public class SumBetweenTwoIntegers {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        System.out.println(new Solution().solution(a, b));
    }

    static class Solution {
        public long solution(int a, int b) {
            return (long)(Math.abs(b - a) + 1) * (a + b) / 2;
        }
    }
}
