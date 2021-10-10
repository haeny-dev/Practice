package kr.co.programmers.java.monthly_code_challenge.season1;

import java.util.Arrays;

public class CountingAfterQuadCompression {

    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 1, 0, 0},
//                {1, 0, 0, 0},
//                {1, 0, 0, 1},
//                {1, 1, 1, 1}};
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(new Solution().solution(arr)));
    }

    static class Solution {

        public int[] solution(int[][] arr) {
            int[] answer = {0, 0};
            checkQuad(arr, answer, 0, 0, arr.length);
            return answer;
        }

        private void checkQuad(int[][] arr, int[] count, int x, int y, int length) {
            if (length == 1) {
                count[arr[x][y]]++;
                return;
            }

            int sum = 0;
            for (int i = x; i < x + length; i++) {
                for (int j = y; j < y + length; j++) {
                    sum += arr[i][j];
                }
            }

            if (sum == 0) {
                count[0]++;
            } else if (sum == length * length) {
                count[1]++;
            } else {
                int newLength = length / 2;
                checkQuad(arr, count, x, y, newLength);
                checkQuad(arr, count, x + newLength, y, newLength);
                checkQuad(arr, count, x, y + newLength, newLength);
                checkQuad(arr, count, x + newLength, y + newLength, newLength);
            }
        }
    }
}
