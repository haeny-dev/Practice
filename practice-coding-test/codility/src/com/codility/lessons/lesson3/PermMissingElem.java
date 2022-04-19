package com.codility.lessons.lesson3;

public class PermMissingElem {

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5};
        System.out.println(new Solution().solution(A));
    }

    static class Solution{

        public int solution(int[] A){
            int answer = 0;

            boolean[] contains = new boolean[A.length + 2];
            for(int a : A){
                contains[a] = true;
            }

            for(int i = 1; i < contains.length; i++){
                if(!contains[i]){
                    answer = i;
                    break;
                }
            }

            return answer;
        }
    }
}
