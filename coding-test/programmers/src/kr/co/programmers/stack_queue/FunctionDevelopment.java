package kr.co.programmers.stack_queue;

import java.util.*;

public class FunctionDevelopment {

    public static void main(String[] args) {
        int[] progresses = {93, 30 , 55};
        int[] speeds = {1, 30 , 5};
        System.out.println(Arrays.toString(new Solution().solution(progresses, speeds)));
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> taskQue = new ArrayDeque<>();

            for(int i = 0; i < progresses.length; i++){
                int fullDay = (100 - progresses[i]) / speeds[i];
                int partDay = (100 - progresses[i]) % speeds[i];
                int workDay = partDay == 0 ? fullDay : fullDay + 1;
                taskQue.add(workDay);
            }

            List<Integer> deployCnts = new ArrayList<>();

            while(taskQue.size() > 0){
                int deployWorkDay = taskQue.poll();
                int deployTaskCnt = 1;

                while(taskQue.peek() != null && deployWorkDay >= taskQue.peek()){
                    taskQue.poll();
                    deployTaskCnt++;
                }

                deployCnts.add(deployTaskCnt);
            }

            return deployCnts.stream().mapToInt(x -> x).toArray();
        }
    }
}
