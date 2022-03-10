package kr.co.programmers.practice;

public class RepresentationOfNumbers {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution().solution2(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i = 1; i <= n; i++){
                int a = i;
                int m = n;

                while(a <= m){
                    m -= a;

                    if(m == 0){
                        answer++;
                    } else if (m < 0){
                        break;
                    }

                    a++;
                }
            }

            return answer;
        }

        public int solution2(int n){
            int answer = 0;
            int K = 1;
            double v = firstNumber(n, K);
            while (v > 0) {
                if (v == (int)v) {
                    answer++;
                }
                v = firstNumber(n, ++K);
            }
            return answer;
        }

        private double firstNumber(int n, int K) {
            return ((double)(2 * n) / K - K + 1) / 2;
        }
    }
}
