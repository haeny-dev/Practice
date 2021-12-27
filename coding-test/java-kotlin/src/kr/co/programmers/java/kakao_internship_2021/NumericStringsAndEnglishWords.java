package kr.co.programmers.java.kakao_internship_2021;

public class NumericStringsAndEnglishWords {

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};

            for(int i = 0; i < words.length; i++){
                if(s.contains(words[i])){
                    s = s.replace(words[i], String.valueOf(i));
                    continue;
                }
            }

            return Integer.parseInt(s);
        }
    }
}
