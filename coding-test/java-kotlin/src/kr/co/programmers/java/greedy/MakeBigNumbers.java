package kr.co.programmers.java.greedy;

public class MakeBigNumbers {

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        System.out.println(new Solution().solution(number, k));
    }

    static class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            int max = 0;
            for(int i=0; i<number.length() - k; i++) {
                max = 0;
                for(int j = index; j<= k+i; j++) {
                    if(max < number.charAt(j)-'0') {
                        max = number.charAt(j)-'0';
                        index = j+1;
                    }
                }
                sb.append(max);
            }
            return sb.toString();
        }
    }
}
