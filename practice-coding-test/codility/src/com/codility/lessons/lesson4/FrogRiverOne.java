package com.codility.lessons.lesson4;

public class FrogRiverOne {

    public static void main(String[] args) {
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(new Solution().solution(X, A));
    }

    static class Solution {
        public int solution(int X, int[] A){
            int answer = -1;

            boolean[] isLeaf = new boolean[X + 1];
            int count = 0;
            for(int i = 0; i < A.length; i++){
                int position = A[i];

                if(isLeaf[position]){
                    continue;
                }

                isLeaf[position] = true;
                count++;
                if(count == X){
                    answer = i;
                    break;
                }
            }

            return answer;
        };
    }
}
