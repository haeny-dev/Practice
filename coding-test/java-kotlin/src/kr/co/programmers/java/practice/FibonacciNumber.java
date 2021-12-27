package kr.co.programmers.java.practice;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;
            int n_2 = 0;
            int n_1 = 1;
            for(int i = 0; i < n-1; i++){
                answer = (n_1 + n_2) % 1234567;
                n_2 = n_1;
                n_1 = answer;
            }

            return answer;
        }
    }
}
