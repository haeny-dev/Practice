package kr.co.programmers.practice;

public class NumberOf124Contry {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().solution2(n));
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

        public String solution2(int n){
            StringBuilder answer = new StringBuilder();
            char[] chars = {'1', '2', '4'};
            while (n > 0) {
                answer.insert(0, chars[(n - 1) % 3]);
                n = (n - 1) / 3;
            }
            return answer.toString();
        }
    }
}
