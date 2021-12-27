package kr.co.programmers.java.practice;

public class StringHandlingBasics {

    public static void main(String[] args) {
        String s = "a234";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public boolean solution(String s) {
            boolean answer = true;
            answer = s.length() == 4 || s.length() == 6;

            if(answer){
                for(char ch : s.toCharArray()){
                    if(!Character.isDigit(ch)){
                        answer = false;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
