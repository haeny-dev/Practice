package kr.co.programmers.java.heap;

import java.util.PriorityQueue;

public class MoreSpicy {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(new Solution().solution(scoville, K));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> scovilleQue = new PriorityQueue<>();
            for(int s : scoville){
                scovilleQue.offer(s);
            }

            while(scovilleQue.peek() <= K){
                if(scovilleQue.size() < 2){
                    return -1;
                }

                int min = scovilleQue.poll();
                int nextMin = scovilleQue.poll();
                int newValue = min + nextMin * 2;

                scovilleQue.offer(newValue);
                answer++;
            }

            return answer;
        }

    }
}
