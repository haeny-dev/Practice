package kr.co.programmers.java.kakao_blind_recruitment_2018;

public class NNumberGame {

    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(new Solution().solution(n, t, m, p));
    }

    static class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";

            int number = 0;
            StringBuilder toNString = new StringBuilder();

            while(toNString.length() < t * m){
                toNString.append(Integer.toString(number++, n).toUpperCase());
            }

            for(int i = 0; i < t; i++){
                answer += toNString.charAt(p - 1 + m * i);
            }

            return answer;
        }
    }
}
