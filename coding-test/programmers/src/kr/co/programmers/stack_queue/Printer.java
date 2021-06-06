package kr.co.programmers.stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Printer {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(new Solution().solution(priorities, location));
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int[] sortedPriorities = new int[priorities.length];
            Queue<Integer> documentQue = new ArrayDeque<>();
            for(int i = 0; i < priorities.length; i++){
                documentQue.add(i);
                sortedPriorities[i] = priorities[i];
            }

            Arrays.sort(sortedPriorities);

            int count = 0;
            while(documentQue.peek() != location || sortedPriorities[sortedPriorities.length - 1 - count] != priorities[location]){
                int tLocation = documentQue.poll();
                int currentPriorityIdx = sortedPriorities.length - 1 - count;
                if(sortedPriorities[currentPriorityIdx] == priorities[tLocation]) {
                    count++;
                } else {
                    documentQue.add(tLocation);
                }
            }

            return ++count;
        }
    }
}
