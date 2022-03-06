package kr.co.programmers.java.practice;

public class CreatingJadenCaseStrings {

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(new Solution().solution2(s));
    }

    static class Solution {
        public String solution(String s) {
            String answer = "";

            s = s.toLowerCase();
            String[] wArr = s.split("");

            for(int i = 0; i < wArr.length; i++){

                if(i == 0){
                    answer += wArr[i].toUpperCase();
                    continue;
                }

                if(" ".equals(wArr[i-1])){
                    answer += wArr[i].toUpperCase();
                    continue;
                }

                answer += wArr[i];
            }

            return answer;
        }

        public String solution2(String s) {
            char[] chars = s.toLowerCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i == 0) {
                    if(!Character.isDigit(chars[i])){
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    continue;
                }

                if (chars[i - 1] == ' ' && chars[i] != ' ' && !Character.isDigit(chars[i])) {
                    chars[i] = Character.toUpperCase(chars[i]);
                }
            }

            return String.valueOf(chars);
        }
    }
}
