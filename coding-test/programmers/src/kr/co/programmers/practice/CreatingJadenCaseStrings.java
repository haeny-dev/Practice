package kr.co.programmers.practice;

public class CreatingJadenCaseStrings {

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(new Solution().solution(s));
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
    }
}
