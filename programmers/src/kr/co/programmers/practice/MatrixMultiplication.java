package kr.co.programmers.practice;

import java.util.Arrays;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 4},
                {3, 2},
                {4, 1}};    // 3 x 2
        int[][] arr2 = {
                {3, 3},
                {3, 3}};    // 2 x 2
        Arrays.stream(new Solution().solution2(arr1, arr2)).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];

            for(int i = 0; i < arr1.length; i++){
                for(int j = 0; j < arr2[0].length; j++){
                    for(int k = 0; k < arr2.length; k++){
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            return answer;
        }

        public int[][] solution2(int[][] arr1, int[][] arr2){
            int[][] answer = new int[arr1.length][arr2[0].length];

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2[0].length; j++) {
                    for (int k = 0; k < arr1[0].length; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            return answer;
        }
    }
}
