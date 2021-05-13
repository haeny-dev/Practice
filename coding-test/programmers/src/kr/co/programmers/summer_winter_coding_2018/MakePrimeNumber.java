package kr.co.programmers.summer_winter_coding_2018;

import java.util.ArrayList;
import java.util.List;

public class MakePrimeNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().solution(nums));
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            List<Integer> sumNums = new ArrayList<>();

            for(int i = 0; i < nums.length - 2; i++){
                for(int j = i + 1; j < nums.length - 1; j++){
                    for(int k = j + 1; k < nums.length; k++){
                        int temp = nums[i] + nums[j] + nums[k];
                        sumNums.add(temp);
                    }
                }
            }

            for(int num : sumNums){
                if(num % 2 == 0){
                    continue;
                }

                int i;
                for(i = 3; i <= num; i = i + 2){
                    if(num % i == 0){
                        break;
                    }
                }

                if(i == num){
                    answer++;
                }
            }

            return answer;
        }
    }
}
