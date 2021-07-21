package kr.co.programmers.monthly_code_challenge.season1;

import java.util.Arrays;

public class TriangularSnail {

    public static void main(String[] args) {
        /**
         * n = 4
         * 1
         * 2   9
         * 3  10   8
         * 4   5   6   7
         */

        int n = 4;
        System.out.println(Arrays.toString(new Solution().solution(n)));
    }

    static class Solution{

        public int[] solution(int n){
            int[] answer = new int[(n * (n + 1))/2];
            int[][] matrix = new int[n][n];

            int num = 1;
            int x = -1;
            int y = 0;

            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    if(i % 3 == 0){
                        x++;
                    } else if(i % 3 == 1){
                        y++;
                    } else if(i % 3 == 2){
                        x--;
                        y--;
                    }

                    matrix[x][y] = num++;
                }
            }

            int index = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    answer[index++] = matrix[i][j];
                }
            }

            return answer;
        }
    }
}
