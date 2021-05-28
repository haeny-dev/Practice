package kr.co.programmers.practice;

public class NumberOf124Contry {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public String solution(int n) {
            String answer = "";
            String[] chars = {"1", "2", "4"};

            while(n > 0){
                answer = chars[(n-1)%3] + answer;
                n = (n-1)/3;
            }

            return answer;
        }
    }
}
