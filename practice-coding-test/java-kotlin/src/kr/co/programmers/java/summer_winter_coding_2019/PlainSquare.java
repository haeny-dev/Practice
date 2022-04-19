package kr.co.programmers.java.summer_winter_coding_2019;

public class PlainSquare {

    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(new Solution().solution(w, h));
    }

    static class Solution {
        public long solution(int w, int h) {
            long answer = 0;
            double rate = (double) h / (double) w;

            for(int i = 1; i <= w; i++){
                answer += (long)(h - (i * rate)) * 2;
            }

            return answer;
        }
    }
}
