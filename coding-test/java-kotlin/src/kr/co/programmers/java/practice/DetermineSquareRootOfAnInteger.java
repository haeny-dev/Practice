package kr.co.programmers.java.practice;

public class DetermineSquareRootOfAnInteger {

    public static void main(String[] args) {
        long n = 121;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public long solution(long n) {
            if(Math.sqrt(n) - (int)Math.sqrt(n) > 0){
                return -1;
            }

            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
    }
}
