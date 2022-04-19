package kr.co.programmers.java.summer_winter_coding_2018;

import java.util.Arrays;

public class Budget {

    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(new Solution().solution(d, budget));
    }

    static class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;

            Arrays.sort(d);

            for(int m : d){
                if(m > budget){
                    break;
                }

                budget = budget - m;
                answer++;
            }

            return answer;
        }
    }
}
