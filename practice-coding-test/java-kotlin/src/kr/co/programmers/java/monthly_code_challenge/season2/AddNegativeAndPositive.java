package kr.co.programmers.java.monthly_code_challenge.season2;

public class AddNegativeAndPositive {

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        System.out.println(new Solution().solution(absolutes, signs));
    }

    static class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;

            for(int i = 0; i < absolutes.length; i++){
                answer += signs[i] ? absolutes[i] : absolutes[i] * -1;
            }

            return answer;
        }
    }
}
