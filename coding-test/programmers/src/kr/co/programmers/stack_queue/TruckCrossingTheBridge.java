package kr.co.programmers.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TruckCrossingTheBridge {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < bridge_length; i++){
                queue.add(0);
            }

            int currentWeights = 0;
            int truckIdx = 0;

            while(!queue.isEmpty()){
                answer++;
                currentWeights -= queue.poll();

                if(truckIdx == truck_weights.length) continue;

                int currentTruck = 0;
                if(bridge_length > queue.size() && weight - currentWeights >= truck_weights[truckIdx]){
                    currentTruck = truck_weights[truckIdx];
                    truckIdx++;
                }

                queue.add(currentTruck);
                currentWeights += currentTruck;
            }

            return answer;
        }
    }
}
