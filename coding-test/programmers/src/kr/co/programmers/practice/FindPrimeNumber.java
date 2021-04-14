package kr.co.programmers.practice;

public class FindPrimeNumber {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            boolean[] isNotPrimes = new boolean[n+1];

            for(int i = 2; i <= n; i++){
                if(isNotPrimes[i]){
                    continue;
                }

                answer++;

                for(int j = i * 2; j <= n; j = j + i){
                    isNotPrimes[j] = true;
                }
            }

            return answer;
        }
    }
}
