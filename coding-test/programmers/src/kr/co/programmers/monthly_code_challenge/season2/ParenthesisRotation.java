package kr.co.programmers.monthly_code_challenge.season2;

public class ParenthesisRotation {

    public static void main(String[] args) {

        String s = "[](){}";
        System.out.println(new Solution().solution(s));
    }

    static class Solution{

        public int solution(String s){
            int answer = 0;

            for(int i = 0; i < s.length(); i++){

                if(checkParenthesis(s)){
                    answer++;
                }

                s = rotation(s);
            }

            return answer;
        }

        private boolean checkParenthesis(String s) {
            int preLength = s.length();
            s = s.replaceAll("\\[\\]|\\(\\)|\\{\\}", "");

            while(preLength != s.length() && s.length() != 0){
                preLength = s.length();
                s = s.replaceAll("\\[\\]|\\(\\)|\\{\\}", "");
            }

            return s.length() == 0;
        }

        private String rotation(String s) {
            return s.substring(1) + s.charAt(0);
        }
    }
}
