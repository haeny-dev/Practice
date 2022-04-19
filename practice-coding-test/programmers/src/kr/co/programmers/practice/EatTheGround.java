package kr.co.programmers.practice;

import java.util.Arrays;

public class EatTheGround {

    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println(new Solution().solution2(land));
    }

    static class Solution {
        public int solution(int[][] land) {
            int answer = 0;

            if(land.length == 1){
                return Math.max(land[0][0], Math.max(land[0][1], Math.max(land[0][2], land[0][3])));
            }

            for(int i = 1; i < land.length; i++){
                for(int j = 0; j < land[0].length; j++){
                    int max = 0;
                    for(int k = 0; k < land[0].length; k++){
                        if(k == j) continue;
                        max = Math.max(land[i-1][k], max);
                    }

                    land[i][j] = land[i][j] + max;
                    answer = answer > land[i][j] ? answer : land[i][j];
                }
            }

            return answer;
        }

        public int solution2(int[][] land){
            int[] result = Arrays.stream(land).reduce(new int[]{0, 0, 0, 0}, (a, b) -> new int[]{
                    b[0] + Math.max(a[1], Math.max(a[2], a[3])),
                    b[1] + Math.max(a[0], Math.max(a[2], a[3])),
                    b[2] + Math.max(a[0], Math.max(a[1], a[3])),
                    b[3] + Math.max(a[0], Math.max(a[1], a[2]))
            });

            return Math.max(result[0], Math.max(result[1], Math.max(result[2], result[3])));
        }
    }

}
