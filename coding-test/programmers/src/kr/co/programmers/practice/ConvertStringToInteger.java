package kr.co.programmers.practice;

public class ConvertStringToInteger {

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            return Integer.parseInt(s);
        }
    }
}
