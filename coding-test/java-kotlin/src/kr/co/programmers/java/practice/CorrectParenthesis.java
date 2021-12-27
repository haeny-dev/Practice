package kr.co.programmers.java.practice;

public class CorrectParenthesis {

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(new Solution().solution(s));
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

    }
}
