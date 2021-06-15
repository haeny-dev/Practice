package kr.co.programmers.full_search;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(new Solution().solution(brown, yellow)));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            int k = brown/2 - 2;

            for(int x = k/2; x < k; x++){
                int y = k - x;
                if(y <= x && x * y == yellow){
                    answer[0] = x + 2;
                    answer[1] = k - x + 2;
                }
            }

            return answer;
        }
    }
}
