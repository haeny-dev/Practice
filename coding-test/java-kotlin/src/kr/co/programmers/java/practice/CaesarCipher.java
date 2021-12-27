package kr.co.programmers.java.practice;

public class CaesarCipher {

    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
        System.out.println(new Solution().solution(s, n));
    }

    static class Solution {
        public String solution(String s, int n) {
            String answer = "";

            for(int i = 0; i < s.length(); i++){
                int asc = s.charAt(i);

                if(asc == 32){
                    answer += (char)asc;

                } else if (asc >= 65 && asc <= 90){
                    asc += n;

                    if(asc > 90){
                        asc = asc - 26;
                    }

                    answer += (char)asc;
                } else if (asc >= 97 && asc <= 122){

                    asc += n;

                    if(asc > 122){
                        asc = asc - 26;
                    }

                    answer += (char)asc;
                }
            }

            return answer;
        }
    }
}
