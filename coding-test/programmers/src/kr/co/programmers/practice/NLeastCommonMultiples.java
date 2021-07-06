package kr.co.programmers.practice;

import java.util.Arrays;

public class NLeastCommonMultiples {

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(new Solution().solution(arr));
    }

    static class Solution {
        public int solution(int[] arr) {
            int answer = 0;

            Arrays.sort(arr);
            int max = arr[arr.length-1];
            int multiple = 1;

            while(answer == 0){
                int temp = max * multiple;

                for(int i = 0; i < arr.length; i++){
                    if(temp % arr[i] != 0){
                        temp = 0;
                        break;
                    }
                }

                if(temp == 0){
                    multiple++;
                    continue;
                }

                answer = temp;
            }

            return answer;
        }
    }
}
