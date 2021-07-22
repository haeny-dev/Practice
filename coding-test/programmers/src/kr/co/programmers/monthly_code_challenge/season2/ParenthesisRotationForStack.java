package kr.co.programmers.monthly_code_challenge.season2;

import java.util.Stack;

public class ParenthesisRotationForStack {

    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {

        private final Stack<Character> stack = new Stack<>();

        public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                if (correctParenthesis(s.toCharArray())) {
                    answer++;
                }

                s = s.substring(1) + s.charAt(0);
            }

            return answer;
        }

        private boolean correctParenthesis(char[] toCharArray) {
            for (char c : toCharArray) {
                if (!(check(c, '(', ')')
                        && check(c, '[', ']')
                        && check(c, '{', '}'))) {
                    return false;
                }
            }

            return stack.isEmpty();
        }

        private boolean check(char c, char start, char end) {
            if (c == start) {

                stack.push(c);

            } else if (c == end) {

                if (!stack.isEmpty() && stack.peek() == start) {
                    stack.pop();
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
