package kr.co.programmers.practice;

public class SumOfFactors {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i = 1; i <= n; i++){
                if ( n % i == 0 ) {
                    answer += i;
                }
            }
            return answer;
        }
    }
}
