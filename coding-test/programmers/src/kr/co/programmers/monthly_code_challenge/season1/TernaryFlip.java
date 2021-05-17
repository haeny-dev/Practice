package kr.co.programmers.monthly_code_challenge.season1;

import java.util.Stack;

public class TernaryFlip {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            while(n/3 > 0){
                stack.push(n%3);
                n = n/3;
            }

            stack.push(n);

            for(int i = 0, l = stack.size(); i < l; i++){
                answer += stack.pop() * Math.pow(3, i);
            }

            return answer;
        }
    }
}
