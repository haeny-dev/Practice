package kr.co.programmers.java.practice;

public class NumberOfpAndyInString {

    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        boolean solution(String s) {
            char[] sArr = s.toLowerCase().toCharArray();
            int pCount = 0;
            int yCount = 0;
            for(char c : sArr){
                if(c == 'p'){
                    pCount++;
                }

                if(c == 'y'){
                    yCount++;
                }
            }

            return pCount == yCount;
        }
    }
}
