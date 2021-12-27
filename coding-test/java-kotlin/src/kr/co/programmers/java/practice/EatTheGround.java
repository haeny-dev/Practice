package kr.co.programmers.java.practice;

public class EatTheGround {

    public static void main(String[] args) {
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        System.out.println(new Solution().solution(land));
    }

    static class Solution {
        int solution(int[][] land) {
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
    }

}
