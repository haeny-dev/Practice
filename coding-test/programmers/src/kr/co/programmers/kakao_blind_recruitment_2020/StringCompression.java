package kr.co.programmers.kakao_blind_recruitment_2020;

public class StringCompression {

    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = s.length();

            for(int i = 1; i <= s.length(); i++){
                int beginIdx = 0;
                int endIdx = 0;
                int count = 1;
                String token = "";
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < s.length()/i; j++){
                    beginIdx = i * j;
                    endIdx = beginIdx + i;
                    if(!token.equals(s.substring(beginIdx, endIdx))){
                        if(count != 1){
                            sb.append(count);
                        }
                        sb.append(token);
                        token = s.substring(beginIdx, endIdx);
                        count = 0;
                    }
                    count++;
                }

                if(count != 1){
                    sb.append(count);
                }
                sb.append(token);

                if(endIdx < s.length()){
                    sb.append(s.substring(endIdx));
                }

                if(answer > sb.length()){
                    answer = sb.length();
                }
            }

            return answer;
        }
    }
}
