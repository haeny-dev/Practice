package kr.co.programmers.practice;

public class CorrectParenthesis {

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(new Solution().solution2(s));
    }

    static class Solution {
        boolean solution(String s) {
            if(s.startsWith(")") || s.endsWith("(")){
                return false;
            }

            int count = 0;
            for(char c : s.toCharArray()){
                if(c == '('){
                    count++;
                } else {
                    count--;
                }

                if(count < 0){
                    return false;
                }
            }

            return count == 0;
        }

        boolean solution2(String s){
            int flag = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    flag++;
                } else if (c == ')') {
                    flag--;
                }

                if (flag < 0) {
                    return false;
                }
            }

            return flag == 0;
        }
    }
}
