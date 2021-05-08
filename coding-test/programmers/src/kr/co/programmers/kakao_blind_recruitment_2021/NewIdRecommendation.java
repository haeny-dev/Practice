package kr.co.programmers.kakao_blind_recruitment_2021;

public class NewIdRecommendation {

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(new Solution().solution(new_id));
    }

    static class Solution {
        public String solution(String new_id) {
            String answer = "";

            answer = new_id.toLowerCase();

            answer = answer.replaceAll("[^a-z0-9-_.]", "");

            while(answer.contains("..")){
                answer = answer.replace("..", ".");
            }

            if(answer.startsWith(".")){
                answer = answer.replaceFirst(".", "");
            }

            if(answer.endsWith(".")){
                answer = answer.substring(0, answer.lastIndexOf("."));
            }

            if(answer.isEmpty()){
                answer = "a";
            }

            if(answer.length() > 15){
                answer = answer.substring(0, 15);

                if(answer.endsWith(".")){
                    answer = answer.substring(0, answer.lastIndexOf("."));
                }
            }

            while(answer.length() < 3) {
                answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
            }

            return answer;
        }
    }
}
