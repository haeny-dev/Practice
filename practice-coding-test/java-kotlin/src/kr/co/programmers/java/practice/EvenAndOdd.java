package kr.co.programmers.java.practice;

public class EvenAndOdd {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(new Solution().solution(num));
    }

    static class Solution {
        public String solution(int num) {
            return num % 2 == 0 ? "Even" : "Odd";
        }
    }
}
