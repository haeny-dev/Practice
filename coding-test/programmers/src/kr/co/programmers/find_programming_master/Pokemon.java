package kr.co.programmers.find_programming_master;

import java.util.Arrays;

public class Pokemon {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(new Solution().solution(nums));
    }

    static class Solution {
        public int solution(int[] nums) {
            int pickNum = nums.length / 2;
            int kindsNum = Arrays.stream(nums).distinct().toArray().length;

            return pickNum > kindsNum ? kindsNum : pickNum;
        }
    }
}
