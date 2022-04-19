package kr.co.programmers.java.dev_matching_backend_2021;

import java.util.Arrays;

public class TheHighestAndLowestRanksOfTheLotto {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(new Solution().solution(lottos, win_nums)));
    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int[] ranking = {6, 6, 5, 4, 3, 2, 1};

            int count = 0;
            int blank = 0;

            for(int l : lottos){
                if(l == 0){
                    blank++;
                    continue;
                }

                for(int w : win_nums){
                    if(l == w){
                        count++;
                    }
                }
            }

            answer[0] = ranking[count + blank];
            answer[1] = ranking[count];
            return answer;
        }
    }
}
