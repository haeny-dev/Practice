package com.codility.lessons.lesson4;

import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(new Solution().solution(N, A)));
    }

    static class Solution {
        public int[] solution(int N, int[] A) {
            int[] answer = new int[N];

            int base = 0;
            int max = 0;
            for(int i = 0; i < A.length; i++){
                if(A[i] >= 1 && A[i] <= N){
                    if(answer[A[i] - 1] < base){
                        answer[A[i] - 1] = base;
                    }

                    if(++answer[A[i] - 1] > max){
                        max = answer[A[i] - 1];
                    }
                } else if (A[i] == N + 1){
                    base = max;
                }
            }

            for(int i = 0; i < answer.length; i++){
                if(answer[i] < base){
                    answer[i] = base;
                }
            }

            return answer;
        }
    }
}
