package kr.co.programmers.java.practice;

public class Watermelon {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public String solution(int n) {
            String anwser = "";

            while(anwser.length() < n){
                anwser += "수박";
            }

            if(anwser.length() != n){
                anwser = anwser.substring(0, anwser.length()-1);
            }

            return anwser;
        }
    }
}
