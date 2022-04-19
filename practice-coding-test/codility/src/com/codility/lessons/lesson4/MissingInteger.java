package com.codility.lessons.lesson4;

import java.util.Arrays;

public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(new Solution().solution(A));
    }

    static class Solution{
        public int solution(int[] A){
            int answer = 1;
            Arrays.sort(A);

            for(int i = 0; i < A.length; i++){
                if(answer == A[i]) answer++;
            }

            return answer;
        }
    }
}
