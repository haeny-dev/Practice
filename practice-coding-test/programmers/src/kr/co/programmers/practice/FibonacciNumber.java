package kr.co.programmers.practice;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().solution2(n));
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

        public int solution2(int n) {
            int[] fibo = new int[n + 1];
            fibo[0] = 0;
            fibo[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
            }
            return fibo[n];
        }
    }
}
