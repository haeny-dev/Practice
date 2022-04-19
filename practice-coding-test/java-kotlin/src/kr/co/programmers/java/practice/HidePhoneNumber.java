package kr.co.programmers.java.practice;

public class HidePhoneNumber {

    public static void main(String[] args) {
        String phone_number = "01033334444";
        System.out.println(new Solution().solution(phone_number));
    }

    static class Solution {
        public String solution(String phone_number) {
            String answer = "";

            int leng = phone_number.length() - 4;
            while(leng > 0){
                answer += "*";
                leng--;
            }

            answer += phone_number.substring(phone_number.length() - 4);

            return answer;
        }
    }
}
