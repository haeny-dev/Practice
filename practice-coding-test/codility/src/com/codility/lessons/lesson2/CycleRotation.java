package com.codility.lessons.lesson2;

import java.util.Arrays;

public class CycleRotation {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int K = 4;
        System.out.println(Arrays.toString(new Solution().solution(A, K)));
    }

    static class Solution {
        public int[] solution(int[] A, int K) {
            int[] answer = new int[A.length];
            for(int i = 0; i < A.length; i++){
                answer[(i + K) % A.length] = A[i];
            }

            return answer;
        }
    }
}
