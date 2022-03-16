package kr.co.programmers.stack_queue;

import java.util.*;

public class FunctionDevelopment {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(new Solution().solution2(progresses, speeds)));
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

        public int[] solution2(int[] progresses, int[] speeds){
            List<Integer> deployCnts = new ArrayList<>();

            int pointer = 0;
            while (pointer < progresses.length) {
                int deployCnt = 0;

                int days = getWorkDays(progresses[pointer], speeds[pointer]);
                for (int i = pointer; i < progresses.length; i++) {
                    progresses[i] += days * speeds[i];
                }

                while (pointer < progresses.length
                        && progresses[pointer] >= 100) {
                    deployCnt++;
                    pointer++;
                }

                deployCnts.add(deployCnt);
            }

            return deployCnts.stream().mapToInt(x -> x).toArray();
        }

        private int getWorkDays(int progress, int speed) {
            return (100 - progress) % speed != 0 ? (100 - progress) / speed + 1 : (100 - progress) / speed;
        }
    }
}
