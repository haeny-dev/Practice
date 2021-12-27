package kr.co.programmers.java.weekly_challenge;

public class MinimumRectangle {

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(new Solution().solution(sizes));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int width = 0;
            int height = 0;

            for(int i = 0; i < sizes.length; i++){
                int max = sizes[i][0];
                int min = sizes[i][1];

                if(sizes[i][0] < sizes[i][1]){
                    max = sizes[i][1];
                    min = sizes[i][0];
                }

                if(max > width){
                    width = max;
                }

                if(min > height){
                    height = min;
                }
            }

            return width * height;
        }
    }
}
