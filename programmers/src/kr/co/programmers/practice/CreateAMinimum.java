package kr.co.programmers.practice;

import java.util.Arrays;
import java.util.Comparator;

public class CreateAMinimum {

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(new Solution().solution2(A, B));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[B.length - 1 - i];
            }

            return answer;
        }

        public int solution2(int[] A, int[] B){
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            for (int i = 0, j = A.length - 1; i < A.length; i++, j--) {
                answer += A[i] * B[j];
            }
            return answer;
        }

    }
}
