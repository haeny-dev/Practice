package kr.co.programmers.java.practice;

public class CreateWeirdChars {

    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            String answer = "";

            String[] sArr = s.split("");
            int idx = -1;
            for(String str : sArr){
                idx = str.equals(" ") ? -1 : idx + 1;
                answer += idx % 2 == 0 ? str.toUpperCase() : str.toLowerCase();
            }
            return answer;
        }
    }
}
