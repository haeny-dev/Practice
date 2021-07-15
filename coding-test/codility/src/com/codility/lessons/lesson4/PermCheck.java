package com.codility.lessons.lesson4;

public class PermCheck {

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2};
        System.out.println(new Solution().solution(A));
    }

    static class Solution{
        public int solution(int[] A){
            int answer = 1;
            boolean[] contains = new boolean[A.length + 1];

            for (int i = 0; i < A.length; i++) {
                int number = A[i];

                if(number <= A.length && !contains[number]){
                    contains[number] = true;
                }
            }

            for (int i = 1; i < contains.length; i++) {
                if(!contains[i]){
                    return 0;
                }
            }

            return answer;
        }
    }
}
