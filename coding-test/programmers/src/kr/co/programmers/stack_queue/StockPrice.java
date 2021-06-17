package kr.co.programmers.stack_queue;

import java.util.Arrays;

public class StockPrice {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(new Solution().solution(prices)));
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i = 0; i < prices.length; i++){
                for(int j = i; j < prices.length; j++){
                    if(j == i) continue;

                    answer[i]++;

                    if(prices[i] > prices[j]){
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
