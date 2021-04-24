package kr.co.programmers.practice;

import java.util.Arrays;

public class RemoveSmallestNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(new Solution().solution(arr)));
    }

    static class Solution {
        public int[] solution(int[] arr) {
            if(arr.length == 1){
                return new int[]{-1};
            }

            int[] tempArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(tempArr);

            int min = tempArr[0];

            int[] answer = new int[arr.length-1];
            int idx = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == min){
                    continue;
                }

                answer[idx] = arr[i];
                idx++;
            }
            return answer;
        }
    }
}
