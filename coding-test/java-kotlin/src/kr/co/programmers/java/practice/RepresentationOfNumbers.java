package kr.co.programmers.java.practice;

public class RepresentationOfNumbers {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution().solution(n));
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
    }
}
