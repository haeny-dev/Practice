package kr.co.programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MoreSpicy {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(new Solution().solution2(scoville, K));
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

        public int solution2(int[] scoville, int K){
            int answer = 0;

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int i : scoville) {
                priorityQueue.add(i);
            }

            while (priorityQueue.peek() < K) {
                if (priorityQueue.size() == 1) {
                    return -1;
                }

                answer++;
                priorityQueue.add(priorityQueue.poll() + priorityQueue.poll() * 2);
            }

            return answer;
        }

        private boolean checkScoville(PriorityQueue<Integer> priorityQueue, int K) {
            for (Integer scoville : priorityQueue) {
                if (scoville < K) {
                    return true;
                }
            }
            return false;
        }


    }
}
