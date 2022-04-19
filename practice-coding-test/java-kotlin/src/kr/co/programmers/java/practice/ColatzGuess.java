package kr.co.programmers.java.practice;

public class ColatzGuess {

    public static void main(String[] args) {
        long num = 6;
        System.out.println(new Solution().solution(num));
    }

    static class Solution {
        public int solution(long num) {
            int answer = 0;

            while(num != 1){
                if(answer == 500) return -1;
                num = num % 2 == 0 ? num / 2 : num * 3 + 1;
                answer++;
            }

            return answer;
        }
    }
}
